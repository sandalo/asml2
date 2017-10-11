package br.mg.prodemge.prodigio.wizard.novoprojeto;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class ProdigioNovoProjetoPageWizard extends WizardNewProjectCreationPage {

	public ProdigioNovoProjetoPageWizard(String name) {
		super(name);
		setTitle("Criando projeto proddigio");
		setDescription("Criando projeto proddigio: Passo 1");
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		
        Composite control = (Composite) getControl();
		Composite projectGroup = new Composite(control, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        projectGroup.setLayout(layout);
        projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Boolean check = false;
		Button checkBox = new Button(control, SWT.CHECK);
		checkBox.setText("Com SSC?");
		checkBox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				Object source = event.getSource();
				if (event.detail == SWT.CHECK) {
				}
			}
		});

	}
}
