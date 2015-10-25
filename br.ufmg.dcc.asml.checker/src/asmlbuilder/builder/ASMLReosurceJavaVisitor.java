package asmlbuilder.builder;

import java.util.logging.Logger;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IAnnotationBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentInstanceReference;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;

public class ASMLReosurceJavaVisitor extends ASTVisitor {
	private static final Logger log = Logger.getLogger(ASMLReosurceJavaVisitor.class.getName());
	IProject iProject = null;
	private ComponentInstance componentInstance;
	ASMLContext asmlContext = null;

	public ASMLReosurceJavaVisitor(ASMLContext asmlContext) {
		this.asmlContext = asmlContext;
	}

	private void addReference(ASTNode node, String qualifiedName, RelactionType relactionType) {
		try {
			IType findType;
			IJavaProject javaProject = asmlContext.getJavaProject(iProject);
			findType = javaProject.findType(qualifiedName);
			ComponentInstance componentInstanceReferenced = asmlContext.getComponentInstanceByITypeName(findType);
			ComponentInstanceReference reference = new ComponentInstanceReference();
			reference.setRelactionType(relactionType);
			reference.setAstNode(node);
			componentInstance.addDependency(reference);// Referência declarada nesta instancia, o addReference pode levar a pessar que a referência da componentInstance mas na verdade a referência é para outra instancia
			if (componentInstanceReferenced == null /* && findType.isBinary() */) {
				asmlContext.getViolations().add(new Violation(reference, componentInstance.getResource(), "Referencia desconhecida ao tipo :" + qualifiedName, reference.getLineNumber(), IMarker.SEVERITY_ERROR));
			}
			componentInstanceReferenced.addReferenceThatPointToMe(reference);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean visit(VariableDeclarationStatement node) {
		try {
			String qualifiedName = node.getType().resolveBinding().getQualifiedName();
			addReference(node, qualifiedName, RelactionType.DECLARE);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. VariableDeclarationStatement visit.");
		}
		return true;
	}

	@Override
	public boolean visit(SingleMemberAnnotation node) {
		try {
			SingleMemberAnnotation annotation = (SingleMemberAnnotation) node;
			IAnnotationBinding annotationBinding = annotation.resolveAnnotationBinding();
			String qualifiedName = annotationBinding.getAnnotationType().getQualifiedName();
			addReference(node, qualifiedName, RelactionType.DECLARE);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. SingleMemberAnnotation visit.");
		}
		return true;
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		try {
			if (node.getType().isPrimitiveType() || node.getType().isArrayType()) {
				return true;
			}
			FieldDeclaration fieldDeclaration = (FieldDeclaration) node;
			ITypeBinding typeDeclarationBinding = fieldDeclaration.getType().resolveBinding();
			String binaryName = typeDeclarationBinding.getBinaryName();
			addReference(node, binaryName, RelactionType.DECLARE);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. NormalAnnotation visit.");
		}
		return true;
	}

	@Override
	public boolean visit(NormalAnnotation node) {
		try {
			NormalAnnotation normalAnnotation = (NormalAnnotation) node;
			ITypeBinding typeDeclarationBinding = normalAnnotation.resolveTypeBinding();
			String qualifiedName = typeDeclarationBinding.getQualifiedName();
			addReference(node, qualifiedName, RelactionType.DECLARE);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. NormalAnnotation visit.");
		}
		return true;
	}

	@Override
	public boolean visit(ImportDeclaration node) {
		try {
			ImportDeclaration importDeclaration = (ImportDeclaration) node;
			String qualifiedName = importDeclaration.getName().getFullyQualifiedName();
			if (qualifiedName != null && !qualifiedName.contains("*"))
				addReference(node, qualifiedName, RelactionType.DECLARE);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. ImportDeclaration visit.");
		}
		return true;
	}

	@Override
	public boolean visit(SingleVariableDeclaration node) {
		try {
			SingleVariableDeclaration singleVariableDeclaration = (SingleVariableDeclaration) node;
			IVariableBinding variableBinding = singleVariableDeclaration.resolveBinding();
			String qualifiedName = variableBinding.getType().getQualifiedName();
			addReference(node, qualifiedName, RelactionType.DECLARE);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. SingleVariableDeclaration visit.");
		}
		return true;
	}

	@Override
	public boolean visit(TypeDeclaration node) {
		try {
			TypeDeclaration typeDeclaration = (TypeDeclaration) node;
			ITypeBinding typeDeclarationBinding = typeDeclaration.resolveBinding();
			String qualifiedName = typeDeclarationBinding.getQualifiedName();
			ComponentInstance componentInstanceByITypeName = asmlContext.getComponentInstanceByITypeName(qualifiedName);
			IType iType = componentInstanceByITypeName.getType();
			ITypeHierarchy typeHierarchy = (ITypeHierarchy) iType.newSupertypeHierarchy(new NullProgressMonitor());
			IType supertypes[] = typeHierarchy.getAllSupertypes(iType);
			if (supertypes.length > 0) {
				qualifiedName = supertypes[0].getFullyQualifiedName();
				if (qualifiedName != null)
					addReference(node, qualifiedName, RelactionType.EXTEND);

				supertypes = typeHierarchy.getAllInterfaces();
				for (IType iType2 : supertypes) {
					qualifiedName = iType2.getFullyQualifiedName();
					if (qualifiedName != null) {
						addReference(node, qualifiedName, RelactionType.IMPLEMENT);
					}
				}
			}
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. TypeDeclaration visit.");
		}
		return true;
	}

	@Override
	public boolean visit(ClassInstanceCreation node) {
		try {
			ClassInstanceCreation classInstanceCreation = (ClassInstanceCreation) node;
			ITypeBinding typeDeclarationBinding = classInstanceCreation.resolveTypeBinding();
			String qualifiedName = typeDeclarationBinding.getQualifiedName();
			addReference(node, qualifiedName, RelactionType.CREATE);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. ClassInstanceCreation visit.");
		}
		return true;
	}

	@Override
	public boolean visit(MethodInvocation node) {
		try {
			MethodInvocation methodInvocation = (MethodInvocation) node;
			ITypeBinding typeDeclarationBinding = methodInvocation.getExpression().resolveTypeBinding();
			String qualifiedName = typeDeclarationBinding.getQualifiedName();
			addReference(node, qualifiedName, RelactionType.ACCESS);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. MethodInvocation visit.");
		}
		return true;
	}

	/*
	 * @Override public boolean visit(ThrowStatement node) { addReference(node, null); return true; }
	 */
	@Override
	public boolean visit(MarkerAnnotation node) {
		try {
			MarkerAnnotation normalAnnotation = (MarkerAnnotation) node;
			ITypeBinding typeDeclarationBinding = normalAnnotation.resolveTypeBinding();
			String qualifiedName = typeDeclarationBinding.getQualifiedName();
			addReference(node, qualifiedName, RelactionType.DECLARE);
		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado. MarkerAnnotation visit.");
		}
		return true;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		try {
			MethodDeclaration methodDeclaration = (MethodDeclaration) node;
			String qualifiedName = "";
			ITypeBinding[] exceptionTypes = methodDeclaration.resolveBinding().getExceptionTypes();
			for (int i = 0; i < exceptionTypes.length; i++) {
				qualifiedName = exceptionTypes[i].getQualifiedName();
				addReference(node, qualifiedName, RelactionType.DECLARE);
			}
			qualifiedName = "";
			if (node.getReturnType2() != null && !(node.getReturnType2().isPrimitiveType() && ((PrimitiveType) node.getReturnType2()).getPrimitiveTypeCode() == PrimitiveType.VOID)&&!node.getReturnType2().isPrimitiveType()) {
				if (!node.getReturnType2().resolveBinding().isTypeVariable()) {
					ITypeBinding iTypeBinding = node.getReturnType2().resolveBinding();
					 qualifiedName = iTypeBinding.getBinaryName();
					addReference(node, qualifiedName, RelactionType.DECLARE);
				} else {
					if (node.getReturnType2().resolveBinding().getTypeBounds().length >= 1) {
						ITypeBinding iTypeBinding = node.getReturnType2().resolveBinding().getTypeBounds()[0];
						qualifiedName = iTypeBinding.getBinaryName();
						addReference(node, qualifiedName, RelactionType.DECLARE);
					}
				}

			}

/*			ITypeBinding returnBinding = methodDeclaration.resolveBinding().getReturnType();
			qualifiedName = returnBinding.getBinaryName();
			addReference(node, qualifiedName, RelactionType.DECLARE);
*/		} catch (Exception e) {
			if (asmlContext.isDesignMode())
				log.warning("Erro controlado.  MethodDeclaration visit.");
		}
		return true;
	}

	public boolean visit_(MethodDeclaration node) {
		try {
			for (Object o : node.parameters()) {
				if (o instanceof SingleVariableDeclaration) {
					SingleVariableDeclaration svd = (SingleVariableDeclaration) o;
/*					String identifier = node.getName().getIdentifier();
					String identifier2 = svd.getName().getIdentifier();
*/					ITypeBinding resolveBinding1 = svd.getType().resolveBinding();
					if(resolveBinding1.isPrimitive())
						continue;
					String qualifiedName = resolveBinding1.getBinaryName();
					addReference(node, qualifiedName, RelactionType.DECLARE);
					if (svd.getType().getNodeType() == Type.PARAMETERIZED_TYPE) {
						for (Object t : ((ParameterizedType) svd.getType()).typeArguments()) {
							if (t instanceof SimpleType) {
								SimpleType st = (SimpleType) t;
								ITypeBinding resolveBinding2 = st.resolveBinding();
								String qualifiedName2 = resolveBinding2.getBinaryName();
								addReference(node, qualifiedName2, RelactionType.DECLARE);
							} else if (t instanceof ParameterizedType) {
								ParameterizedType pt = (ParameterizedType) t;
								ITypeBinding resolveBinding3 = pt.getType().resolveBinding();
								String qualifiedName3 = resolveBinding3.getBinaryName();
								addReference(node, qualifiedName3, RelactionType.DECLARE);
							}
						}
					}

				}
			}

			ITypeBinding[] exceptionTypes = node.resolveBinding().getExceptionTypes();
			for (int i = 0; i < exceptionTypes.length; i++) {
				String qualifiedName = exceptionTypes[i].getQualifiedName();
				addReference(node, qualifiedName, RelactionType.DECLARE);
			}

			if (node.getReturnType2() != null && !(node.getReturnType2().isPrimitiveType() && ((PrimitiveType) node.getReturnType2()).getPrimitiveTypeCode() == PrimitiveType.VOID)&&!node.getReturnType2().isPrimitiveType()) {
				if (!node.getReturnType2().resolveBinding().isTypeVariable()) {
					ITypeBinding iTypeBinding = node.getReturnType2().resolveBinding();
					String qualifiedName = iTypeBinding.getBinaryName();
					addReference(node, qualifiedName, RelactionType.DECLARE);
				} else {
					if (node.getReturnType2().resolveBinding().getTypeBounds().length >= 1) {
						ITypeBinding iTypeBinding = node.getReturnType2().resolveBinding().getTypeBounds()[0];
						String qualifiedName = iTypeBinding.getBinaryName();
						addReference(node, qualifiedName, RelactionType.DECLARE);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void setComponentInstance(ComponentInstance componentInstance) {
		this.componentInstance = componentInstance;
	}

	public IProject getiProject() {
		return iProject;
	}

	public void setProject(IProject iProject) {
		this.iProject = iProject;
	}

}