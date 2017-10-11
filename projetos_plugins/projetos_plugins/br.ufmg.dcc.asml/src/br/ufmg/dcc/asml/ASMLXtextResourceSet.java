package br.ufmg.dcc.asml;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

public class ASMLXtextResourceSet extends XtextResourceSet {
	public Resource getResource(URI uri, boolean loadOnDemand, boolean lazy) {
		if (!lazy) {
			Map m = getURIResourceMap();
			m.remove(uri);
		}
		return super.getResource(uri, loadOnDemand);
	}
}
