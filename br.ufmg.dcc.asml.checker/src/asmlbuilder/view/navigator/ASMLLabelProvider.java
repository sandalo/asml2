package asmlbuilder.view.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import br.ufmg.dcc.asml.ClassPathUtil;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.ASMLModel;

public class ASMLLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {
		String imageFilePath = "";
		ImageDescriptor imageDescriptor = null;
		Image image = null;
		try {
			if (ASMLModel.class.isInstance(element)) {
				ASMLModel asmlmodel = (ASMLModel) element;
				IProject project = asmlmodel.getProject();
				IJavaProject create = JavaCore.create(project);
				String path = ClassPathUtil.recuperaPathVaccine(create);
				path = path.replace("vaccine.asml", "");
				imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin("br.ufmg.dcc.asml.checker", imageFilePath);
				imageFilePath = path+"icons/" + asmlmodel.getName() + ".gif";
				imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin("br.ufmg.dcc.asml.checker", imageFilePath);
				if (imageDescriptor.getImageData() ==null) {
					imageFilePath = "icons/imagen_camadas.gif";
					imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin("br.ufmg.dcc.asml.checker", imageFilePath);
				}
				image = imageDescriptor.createImage();
			} else if (ComponentInstance.class.isInstance(element)) {
				ComponentInstance componentInstance = (ComponentInstance) element;
				if (componentInstance.getComponent() != null) {
					IProject project = componentInstance.getResource().getProject();
					IJavaProject create = JavaCore.create(project);
					String path = ClassPathUtil.recuperaPathVaccine(create);
					path = path.replace("vaccine.asml", "");
					imageFilePath = path+"icons/" + componentInstance.getComponent().getName() + ".gif";
					imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin("br.ufmg.dcc.asml.checker", imageFilePath);
					if (imageDescriptor.getImageData() ==null) {
						if (componentInstance.getResource() instanceof IFolder)
							imageFilePath = "icons/packagefolder_obj.gif";
						else if (componentInstance.getResource() instanceof IFile && componentInstance.getResource().getFileExtension().equals("java"))
							imageFilePath = "icons/jcu_obj.gif";
					}
				} else {
					imageFilePath = "icons/unknown.gif";
				}
				imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin("br.ufmg.dcc.asml.checker", imageFilePath);
			}
			image = imageDescriptor.createImage();
		} catch (Exception e) {
			imageFilePath = "icons/packagefolder_obj.gif";
		}
		return image;
	}

	@Override
	public String getText(Object element) {
		String text = "";
		try {
			if (ASMLModel.class.isInstance(element)) {
				text = ((ASMLModel) element).getProject().getName();
			} else if (ComponentInstance.class.isInstance(element)) {
				ComponentInstance componentInstance = (ComponentInstance) element;
				String name2 = componentInstance.getResource().getName();
				if (componentInstance.getComponent() != null) {
					String name = componentInstance.getComponent().getName();
					if (name.equals(name2))
						text = name;
					else
						text = name2 + " <<" + name + ">>";
				} else {
					text = name2 + " <<unknown>>";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}
}
