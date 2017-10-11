package br.gov.prodemge.prodigio.cursoprodigio.controle;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Window;

import br.gov.prodigio.controle.WindowPrincipalUnsecured;
import br.gov.prodigio.visao.helper.ProHelperView;

@SuppressWarnings({ "unchecked", })
public class CursoProdigioWindowIntroducao extends WindowPrincipalUnsecured {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8200952384997878357L;

	@SuppressWarnings("rawtypes")
	@Override
	public void abrir(AbstractComponent itemDeMenuClicado) {
		String urlcasodeuso = (String) itemDeMenuClicado.getAttribute("urlcasodeuso");
		Map attributes = getTela().getAttributes(Component.SESSION_SCOPE);
		ProHelperView.insereNovoConteudoNoCentroDaJanela(urlcasodeuso, getTela(), attributes);
	}

	@SuppressWarnings("rawtypes")
	public void abrirCasoDeUso(String url, Boolean historico, String modo, String width) {
		ProHelperView instance = ProHelperView.getInstance();
		HashMap attributes = new HashMap();
		attributes.put("telaOrigem", getTela());
		instance.abreCasoDeUsoSecundario(url, (Window) getTela(), attributes, historico, modo, width);
		getTela().setVisible(true);
	}

	public void inserePainel() {
		String urlcasodeuso = "painel.zul";
		Map attributes = getTela().getAttributes(Component.SESSION_SCOPE);
		ProHelperView.insereNovoConteudoNoCentroDaJanela(urlcasodeuso, getTela(), attributes);
	}
}
