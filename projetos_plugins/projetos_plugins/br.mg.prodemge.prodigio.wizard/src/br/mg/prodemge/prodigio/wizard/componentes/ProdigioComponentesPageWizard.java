package br.mg.prodemge.prodigio.wizard.componentes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.MetaModule;

public class ProdigioComponentesPageWizard extends WizardPage {
	
	private Composite container;
	private Map<String, AbstractComponent> componentes = new HashMap<String, AbstractComponent>();
	private Text textDescricaoDoComponente;
	private Combo comboProjetos;
	private Combo comboComponentes;

	public ProdigioComponentesPageWizard(String name) {
		super(name);
		setTitle("Criando componente proddigio");
		setDescription("Criando componente proddigio: Passo 1");
	}

	public ProdigioComponentesPageWizard() {
		super("First Page");
		setTitle("First Page");
		setDescription("First");
	}

	@Override
	public void createControl(Composite parent) {
		montaContainerPrincipal(parent);
		initUI();
		initData();
	}
	
	private void montaContainerPrincipal(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		setControl(container);
		setPageComplete(false);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
	}
	
	
	private void initUI() {
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_combo.widthHint = 200;

		// ####### Projetos
		Label labelProjetos = new Label(container, SWT.NONE);
		labelProjetos.setText("Selecione o projeto:");
		
		comboProjetos = new Combo(container, SWT.READ_ONLY);
	    comboProjetos.setLayoutData(gd_combo);
	    comboProjetos.addSelectionListener(new SelectionAdapter() {
	    	
	    	private void clearData() {
	    		textDescricaoDoComponente.setText("");
	    		comboComponentes.select(-1);
	    	}
	    	 
	    	@Override
	         public void widgetSelected(SelectionEvent e) {
	    		clearData();
	    		
	           int idx = comboProjetos.getSelectionIndex();
	           String item = comboProjetos.getItem(idx);
	           
	           ProdigioComponentesWizard.setProjectName(item);
	           final IProject iProject = ProdigioComponentesWizard.getOpenedProjectsMap().get(item);
	           ProdigioComponentesWizard.setIproject(iProject);
	           
	           recuperaComponentes();
	           carregaComboComponentes();
	           comboComponentes.setEnabled(true);
	           
	           if (isPageComplete())
            	   setPageComplete(true);
               else
            	   setPageComplete(false);
	         }
		});
	    
	    
	    // ####### Componentes
	    Label labelComponentes = new Label(container, SWT.NONE);
	    labelComponentes.setText("Selecione o componente:");
	    
	    comboComponentes = new Combo(container, SWT.READ_ONLY);
	    comboComponentes.setEnabled(false);
	    comboComponentes.setLayoutData(gd_combo);
	    comboComponentes.addSelectionListener(new SelectionAdapter() {
	    	 
	    	@Override
	         public void widgetSelected(SelectionEvent e) {
	           int idx = comboComponentes.getSelectionIndex();
	           String selectedItem = comboComponentes.getItem(idx);
	           MetaModule abstractComponent = (MetaModule) componentes.get(selectedItem);
               textDescricaoDoComponente.setText(abstractComponent.getDescription() + "");
               ProdigioComponentesWizard.setComponenteQueSeraInstanciado(abstractComponent);
               
               if (isPageComplete())
            	   setPageComplete(true);
               else
            	   setPageComplete(false);
	                
	         }
		});
	    
	    // ####### Descricao
	    Label labelDescricaoDoComponente = new Label(container, SWT.NONE);
	    labelDescricaoDoComponente.setText("Descri��o do componente:");
	    labelDescricaoDoComponente.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1));

	    textDescricaoDoComponente = new Text(container, SWT.READ_ONLY
	        | SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);
	    textDescricaoDoComponente.setLayoutData(new GridData(GridData.FILL_BOTH));
	    textDescricaoDoComponente.setEnabled(false);
	}
	
	private void initData() {
		// ####### Projetos
		final Collection<String> openedProjects = ProdigioComponentesWizard.getOpenedProjectsMap().keySet();
	    final String[] openedProjectsArray = new String[openedProjects.size()];
	    openedProjects.toArray(openedProjectsArray);
	    Arrays.sort(openedProjectsArray);
	    comboProjetos.setItems(openedProjectsArray);
	    
	}
	
	private void carregaComboComponentes() {
		 // ####### Componentes
	    List<String> componenetesList = new ArrayList(componentes.keySet());
	    final String[] componenetesArray = new String[componenetesList.size()];
	    componenetesList.toArray(componenetesArray);
	    Arrays.sort(componenetesArray);
	    comboComponentes.setItems(componenetesArray);
	}
	
	private void recuperaComponentes() {
		componentes.clear();
		
		final IProject iProject = ProdigioComponentesWizard.getOpenedProjectsMap().get(ProdigioComponentesWizard.getProjectName());
		ASMLModel asmlModel = asmlbuilder.Activator.getAsmlProcessor().getAsmlContext().getAsmlModel(iProject);
		List<AbstractComponent> allComponents = asmlModel.getAllComponents();
		for (EObject eObject : allComponents) {
			if (!(eObject instanceof ASMLModel)) {
				AbstractComponent component = (AbstractComponent) eObject;
				String fullName = component.getFullName();
				boolean hasUppercase = !fullName.equals(fullName.toLowerCase());
				if (hasUppercase && ProdigioComponentesWizard.templates.get(fullName) != null) {// identifica classes
//					if (hasUppercase) {// identifica classes
					componentes.put(fullName, component);
				}
			}
		}
	}
	
	@Override
	public boolean isPageComplete() {
		if (comboProjetos.getSelectionIndex() != -1 && 
				comboComponentes.getSelectionIndex() != -1)
			return true;
		return false;
	}

}
