package br.gov.prodemge.prodigio.cursoprodigio.controle;

import org.zkoss.zk.ui.Component;

import br.gov.prodemge.prodigio.cursoprodigio.entidades.CursoProdigioBaseVO;
import br.gov.prodigio.controle.ProCtr;
import br.gov.prodigio.visao.helper.ProMessageHelper;

public class CursoProdigioBaseCtr<ENTITY extends CursoProdigioBaseVO> extends ProCtr<ENTITY> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7461391100856773714L;
	@SuppressWarnings("unchecked")
	private ProMessageHelper messageHelper = new CursoProdigioBaseMessageHelper((CursoProdigioBaseCtr<CursoProdigioBaseVO>) this);

	@Override
	public ProMessageHelper getMessagesHelper() {
		return messageHelper;
	}

	@Override
	protected void configuraTelaDeEntrada(Component comp) throws Exception {
		super.configuraTelaDeEntrada(comp);
	}

}
