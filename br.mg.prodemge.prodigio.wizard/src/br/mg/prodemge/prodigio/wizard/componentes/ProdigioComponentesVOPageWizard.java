package br.mg.prodemge.prodigio.wizard.componentes;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ProdigioComponentesVOPageWizard extends WizardPage {
	
	private Composite container;
	private Text inputNomeDaNovaInstanciaDoComponente;
	private Text inputModulo;

	public Text getInputModulo() {
		return inputModulo;
	}

	public Text getInputNomeDaNovaInstanciaDoComponente() {
		return inputNomeDaNovaInstanciaDoComponente;
	}

	public ProdigioComponentesVOPageWizard(String name) {
		super(name);
		setTitle("Criando componente proddigio");
		setDescription("Criando componente proddigio: Passo VO");
	}

	public ProdigioComponentesVOPageWizard() {
		super("First Page");
		setTitle("First Page");
		setDescription("First");
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
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_combo.widthHint = 200;
		
		ModifyListener modifyListener = new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (!inputNomeDaNovaInstanciaDoComponente.getText().isEmpty() && !inputModulo.getText().isEmpty()) 
					updateButtons(true);
				 else 
					updateButtons(false);
			}

			private void updateButtons(boolean value) {
				setPageComplete(value);
				((ProdigioComponentesWizard) getWizard()).setCanFinish(value);
/*				((ProdigioComponentesWizard) getWizard()).setCanFinish(value);
				getWizard().getContainer().updateButtons();
*/			}
		};

		Label labelProjetos = new Label(container, SWT.NONE);
		labelProjetos.setText("Digite o nome do componente:");
		
		inputNomeDaNovaInstanciaDoComponente = new Text(container, SWT.BORDER);
		inputNomeDaNovaInstanciaDoComponente.setLayoutData(gd_combo);
		inputNomeDaNovaInstanciaDoComponente.addModifyListener(modifyListener);
		
		Label labelPacote = new Label(container, SWT.NONE);
		labelPacote.setText("Digite o nome do módulo:");
		
		inputModulo = new Text(container, SWT.BORDER);
		inputModulo.setLayoutData(gd_combo);
		inputModulo.setEditable(false);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return false;
	}

	public String getNomeClasse() {
		return inputNomeDaNovaInstanciaDoComponente.getText();
	}

	public String getNomeModulo() {
		return inputModulo.getText();
	}
	
}
