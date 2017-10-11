package br.gov.prodemge.prodigio.cursoprodigio.controle.curso;

import org.zkoss.zk.ui.Component;

import br.gov.prodemge.prodigio.cursoprodigio.controle.CursoProdigioBaseCtr;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.curso.CursoVO;

public class CursoCtr extends CursoProdigioBaseCtr<CursoVO> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6212997118498742374L;

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		super.doAfterCompose(tela);
		pesquisar();
	}
	
}
