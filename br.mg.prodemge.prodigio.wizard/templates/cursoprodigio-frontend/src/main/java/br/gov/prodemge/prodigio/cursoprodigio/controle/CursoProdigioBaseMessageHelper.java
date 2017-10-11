package br.gov.prodemge.prodigio.cursoprodigio.controle;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Clients;

import br.gov.prodemge.prodigio.cursoprodigio.entidades.CursoProdigioBaseVO;
import br.gov.prodigio.visao.helper.ProMessageHelper;

public class CursoProdigioBaseMessageHelper extends ProMessageHelper {
	@Override
	public void emiteMensagemSucesso(String msg, Component component) {
		Clients.showNotification(msg, "info", component, "middle_center", 1000, true);
	}

	public CursoProdigioBaseMessageHelper(CursoProdigioBaseCtr<CursoProdigioBaseVO> ctr) {
		super(ctr);
	}
}
