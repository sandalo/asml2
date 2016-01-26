package asmlbuilder.view.decorator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.swt.graphics.Image;

import asmlbuilder.builder.ASMLNature;

public class ASMLDecorator extends LabelDecorator implements ILightweightLabelDecorator {

	@Override
	public void decorate(Object resource, IDecoration decoration) {
		IProject iProject = (IProject) resource;
		IProjectNature nature;
		try {
			if (iProject.isOpen()) {
				nature = iProject.getNature(ASMLNature.NATURE_ID);
				if (nature != null){
					decoration.addOverlay(ImageDescriptor.createFromFile(ASMLDecorator.class, "/icons/vaccine_decorator.png"), IDecoration.BOTTOM_LEFT);
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
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
	public Image decorateImage(Image image, Object element) {
		return null;
	}

	@Override
	public String decorateText(String text, Object element) {
		return null;
	}

	@Override
	public Image decorateImage(Image image, Object element, IDecorationContext context) {
		return null;
	}

	@Override
	public String decorateText(String text, Object element, IDecorationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean prepareDecoration(Object element, String originalText, IDecorationContext context) {
		// TODO Auto-generated method stub
		return false;
	}
}
