package br.mg.prodemge.prodigio.wizard.componentes;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class ProdigioComponentesPage2Wizard extends WizardPage {
	
	private Composite container;
	private Combo comboComponenteDominante;
	private Label labelNomeComponenteQueSeraInstanciado;

	public ProdigioComponentesPage2Wizard(String name) {
		super(name);
		setTitle("Criando componente proddigio");
		setDescription("Criando componente proddigio: Passo 2");
	}

	public ProdigioComponentesPage2Wizard() {
		super("Second Page");
		setTitle("Second Page");
		setDescription("Now this is the second page");
	}

	public void updatePage() {
		labelNomeComponenteQueSeraInstanciado.setText(ProdigioComponentesWizard.getComponenteQueSeraInstanciado().getName());
		labelNomeComponenteQueSeraInstanciado.getParent().layout();
		carregaComboComponentesDominantes();
	}
	
	private void carregaComboComponentesDominantes() {
		final Collection<String> componentsDominantesList = ProdigioComponentesWizard.getComponentesDominantes().keySet();
	    final String[] componentesDominantesArray = new String[componentsDominantesList.size()];
	    componentsDominantesList.toArray(componentesDominantesArray);
	    Arrays.sort(componentesDominantesArray);
	    comboComponenteDominante.setItems(componentesDominantesArray);
	}

	@Override
	public void createControl(Composite parent) {
		montaContainerPrincipal(parent);
		initUI();
	}

	private void montaContainerPrincipal(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		setControl(container);
		setPageComplete(false);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
	}

	private void initUI() {
		final Label labelComponenteQueSeraInstanciado = new Label(container, SWT.NONE);
		labelComponenteQueSeraInstanciado.setText("Componente que será instanciado:");

		labelNomeComponenteQueSeraInstanciado = new Label(container, SWT.NONE);

		final Label labelComponenteDominante = new Label(container, SWT.NONE);
		labelComponenteDominante.setText("Componente dominante:");

		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_text.widthHint = 200;
		
		comboComponenteDominante = new Combo(container, SWT.READ_ONLY);
		comboComponenteDominante.setLayoutData(gd_text);
		comboComponenteDominante.addSelectionListener(new SelectionAdapter() {
			@Override
	         public void widgetSelected(SelectionEvent e) {
				int idx = comboComponenteDominante.getSelectionIndex();
				String item = comboComponenteDominante.getItem(idx);
				ComponentInstance instance = ProdigioComponentesWizard.getComponentesDominantes().get(item);
				ProdigioComponentesWizard.setComponentInstanceDominante(instance);
				
				final AbstractComponent pai = (AbstractComponent) instance.getComponent().eContainer();
				
				final Set<ComponentInstance> instances = pai.getInstances();
				final IContainer parent = instance.getResource().getParent();
				
				for (ComponentInstance componentInstance : instances) {
					if(componentInstance.getRawName().equals(parent.getName())){
						ProdigioComponentesWizard.setInstanciaDoComponentePaiDoQueSeraInstanciado(componentInstance);
						break;
					}
				}

				setPageComplete(true);
				((ProdigioComponentesWizard) getWizard()).setCanFinish(true);;
				getWizard().getContainer().updateButtons();
				
			}
		});
	}
	


	
	@Override
	public boolean canFlipToNextPage() {
		return false;
	}
}
