package br.mg.prodemge.prodigio.wizard.componentes;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
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
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;

public class ProdigioComponentesPage2Wizard extends WizardPage {
	
	private Composite container;
	private Combo comboComponenteDominante;
	private Label labelNomeComponenteQueSeraInstanciado;
	private Map<String, ComponentInstance> componentesDominantes = new HashMap<String, ComponentInstance>();

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
		carregaIntanciasDeComponentesDominantes();
		carregaComboComponentes();
	}
	
	private void carregaComboComponentes() {
		final Collection<String> componentsDominantesList = componentesDominantes.keySet();
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
				ComponentInstance instance = componentesDominantes.get(item);
				ProdigioComponentesWizard.setComponentInstance(instance);
				setPageComplete(true);
				((ProdigioComponentesWizard) getWizard()).setCanFinish(true);;
				getWizard().getContainer().updateButtons();
				
			}
		});
	}
	
	public void carregaIntanciasDeComponentesDominantes() {
		componentesDominantes.clear();
		
		final AbstractComponent abstractComponent = ProdigioComponentesWizard
				.getComponenteQueSeraInstanciado();
		EList<Restriction> restrictions = abstractComponent.getRestrictions();
		Set<ComponentInstance> allComponentInstances = null;
		for (Restriction restriction : restrictions) {
			if (restriction.getRelactionType().equals(RelactionType.REQUIRES)) {
				final EList<ComponentsBinRestrictionDeclareation> componentsB = restriction
						.getComponentB();
				if (!componentsB.isEmpty()) {
					final ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation2 = componentsB
							.get(0);
					ComponentsBinRestrictionDeclareation componentsBinRestrictionDeclareation = componentsBinRestrictionDeclareation2;
					AbstractComponent componentB = componentsBinRestrictionDeclareation
							.getComponentB();
					allComponentInstances = componentB.getInstances();
				}
			}
		}
		
		for (ComponentInstance componentInstance : allComponentInstances) 
			componentesDominantes.put(componentInstance.toString(), componentInstance);

	}
	
	@Override
	public boolean canFlipToNextPage() {
		return false;
	}
}
