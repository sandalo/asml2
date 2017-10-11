package br.gov.prodemge.prodigio.cursoprodigio.controle.cidade;

import org.zkoss.zk.ui.Component;

import br.gov.prodemge.prodigio.cursoprodigio.controle.CursoProdigioBaseCtr;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.cidade.LogradouroVO;

public class LogradouroCtr extends CursoProdigioBaseCtr<LogradouroVO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1262569840013458723L;

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		super.doAfterCompose(tela);
		pesquisar();
	}
	
}
