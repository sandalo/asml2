package br.gov.prodemge.prodigio.cursoprodigio.controle.cidade;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Textbox;

import br.gov.prodemge.prodigio.cursoprodigio.controle.CursoProdigioBaseCtr;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.cidade.CidadeVO;
import br.gov.prodigio.entidades.ProBaseVO;

public class CidadeCtr extends CursoProdigioBaseCtr<CidadeVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void antesSalvar(ProBaseVO objetoAtual) {
		CidadeVO cidadeVO = (CidadeVO) objetoAtual;
		if(cidadeVO.getApelido()==null || cidadeVO.getNome().isEmpty()){
			Textbox textBox = (Textbox) getTela().getFellow("apelido");
			Clients.clearBusy();
			throw new WrongValueException(textBox,"Campo 'apelido' é obrigatório!");
		}
		super.antesSalvar(objetoAtual);
	}

}
