package asmlbuilder.view.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import asmlbuilder.Activator;
import asmlbuilder.ThreadValidation;
import asmlbuilder.builder.ASMLNature;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class VaccinePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public VaccinePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Vaccine Preference Page");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		BooleanFieldEditor booleanFieldEditor = new BooleanFieldEditor(PreferenceConstants.P_LIVE_FEEDBACK, "&Live feedback violations", getFieldEditorParent());
		BooleanFieldEditor booleanFieldEditor1 = new BooleanFieldEditor(PreferenceConstants.P_BUILD_FEEDBACK, "&Build feedback violations", getFieldEditorParent());


		Group groupDebug = new Group(getFieldEditorParent(), SWT.NONE);
		groupDebug.setText("Debug");
		Layout layout = new FillLayout();
		groupDebug.setLayout(layout);
		groupDebug.setBounds(0, 0, 300, 100);
		

		BooleanFieldEditor booleanFieldEditor2 = new BooleanFieldEditor(PreferenceConstants.P_DEBUG, "&Debug", groupDebug);
		StringFieldEditor stringFieldEditor = new StringFieldEditor(PreferenceConstants.P_DEBUG_COMPONENT_FILTER, "&Debug component filter",25, groupDebug);
		
		
		
		Group groupFilter = new Group(getFieldEditorParent(), SWT.NONE);
		groupFilter.setText("Filter");
		Layout layout2 = new FillLayout();
		groupFilter.setLayout(layout2);
		groupFilter.setBounds(0, 0, 300, 100);

		
		BooleanFieldEditor booleanFieldEditor3 = new BooleanFieldEditor(PreferenceConstants.P_SHOW_STRUCTURAL_VIOLATIONS, "Show structural violations", groupFilter);
		BooleanFieldEditor booleanFieldEditor4 = new BooleanFieldEditor(PreferenceConstants.P_SHOW_RESTRCTION_VALIDATIONS, "Show restriction violations", groupFilter);
		StringFieldEditor ignoreFieldEditor = new StringFieldEditor(PreferenceConstants.P_IGNORE_ARTFACT_FILTER, "&Ignore artifact filter",25, groupFilter);
		
		
		
		addField(booleanFieldEditor);
		addField(booleanFieldEditor1);
		addField(booleanFieldEditor2);
		addField(stringFieldEditor);
		addField(booleanFieldEditor3);
		addField(booleanFieldEditor4);
		addField(ignoreFieldEditor);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	@Override
	protected void contributeButtons(Composite buttonBar) {
		((GridLayout) buttonBar.getLayout()).numColumns++;
		Button updateButton = new Button(buttonBar, SWT.PUSH);
		Point minButtonSize = updateButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		updateButton.setText("Validate");
		Dialog.applyDialogFont(updateButton);

		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		data.widthHint = Math.max(widthHint, minButtonSize.x);

		updateButton.setLayoutData(data);
		updateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ThreadValidation threadValidation = new ThreadValidation(getOpenedProjects(), true);
				threadValidation.schedule();
				performOk();//salvar
				getShell().close();
			}

			private List<IProject> getOpenedProjects() {
				final List<IProject> openedProjects = new ArrayList<IProject>();
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IProject[] projects = workspace.getRoot().getProjects();
				for (IProject iProject : projects) {
					try {
						if (iProject.isOpen()) {
							IProjectNature nature = iProject.getNature(ASMLNature.NATURE_ID);
							if (nature != null)
								openedProjects.add(iProject);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return openedProjects;
			}
		});
		updateButton.setEnabled(isValid());
	}



}