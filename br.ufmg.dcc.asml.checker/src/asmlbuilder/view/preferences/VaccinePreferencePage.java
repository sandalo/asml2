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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import asmlbuilder.Activator;
import asmlbuilder.builder.ASMLNature;
import asmlbuilder.builder.ASMLProcessor;

/**
 * This class represents a preference page that is contributed to the Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace that allows us to create a page that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main plug-in class. That way, preferences can be accessed directly via the preference store.
 */

public class VaccinePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public VaccinePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Vaccine Preference Page");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various types of preferences. Each field editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
//		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, "&Directory preference:", getFieldEditorParent()));
		BooleanFieldEditor booleanFieldEditor = new BooleanFieldEditor(PreferenceConstants.P_DESIGN_MODE, "&Design Mode", getFieldEditorParent());
		BooleanFieldEditor booleanFieldEditor2 = new BooleanFieldEditor(PreferenceConstants.P_DEBUG, "&Debug", getFieldEditorParent());
		addField(booleanFieldEditor);
		addField(booleanFieldEditor2);
//		addField(new RadioGroupFieldEditor(PreferenceConstants.P_CHOICE, "An example of a multiple-choice preference", 1, new String[][] { { "&Choice 1", "choice1" }, { "C&hoice 2", "choice2" } }, getFieldEditorParent()));
//		addField(new StringFieldEditor(PreferenceConstants.P_STRING, "A &text preference:", getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	
	@Override
	protected void contributeButtons(Composite buttonBar) {
		((GridLayout) buttonBar.getLayout()).numColumns++;
		Button updateButton = new Button(buttonBar, SWT.PUSH);
		Point minButtonSize = updateButton.computeSize(SWT.DEFAULT,SWT.DEFAULT, true);
		int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		updateButton.setText("Update");
		Dialog.applyDialogFont(updateButton);
	
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		data.widthHint = Math.max(widthHint, minButtonSize.x);
		
		updateButton.setLayoutData(data);
		updateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final List<IProject> openedProjects = getOpenedProjects();
				Activator.getAsmlProcessor().initialize(ASMLProcessor.FULL_BUILD, openedProjects);
				Activator.getAsmlProcessor().printEstatistica();
				Activator.getAsmlProcessor().printLog();

				for (IProject iProject : openedProjects) {
					//Activator.getAsmlProcessor().fullBuild(iProject);
				}
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