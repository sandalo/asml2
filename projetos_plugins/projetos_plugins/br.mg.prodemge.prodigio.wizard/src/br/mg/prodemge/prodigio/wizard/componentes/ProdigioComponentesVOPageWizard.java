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
	private Text inputNomeComponente;
	private Text inputPacote;

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
				if (!inputNomeComponente.getText().isEmpty() && !inputPacote.getText().isEmpty()) 
					updateButtons(true);
				 else 
					updateButtons(false);
			}

			private void updateButtons(boolean value) {
				setPageComplete(value);
				((ProdigioComponentesWizard) getWizard()).setCanFinish(value);;
				getWizard().getContainer().updateButtons();
			}
		};

		Label labelProjetos = new Label(container, SWT.NONE);
		labelProjetos.setText("Digite o nome do componente:");
		
		inputNomeComponente = new Text(container, SWT.BORDER);
		inputNomeComponente.setLayoutData(gd_combo);
		inputNomeComponente.addModifyListener(modifyListener);
		
		Label labelPacote = new Label(container, SWT.NONE);
		labelPacote.setText("Digite o pacote:");
		
		inputPacote = new Text(container, SWT.BORDER);
		inputPacote.setLayoutData(gd_combo);
		inputPacote.addModifyListener(modifyListener);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return false;
	}

	public String getClasse() {
		return inputNomeComponente.getText();
	}

	public String getPacote() {
		return inputPacote.getText();
	}
	
}
