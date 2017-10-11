package br.gov.prodemge.prodigio.cursoprodigio.controle.funcionario;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zul.Window;

import br.gov.prodemge.prodigio.cursoprodigio.controle.CursoProdigioBaseCtr;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.funcionario.FuncionarioDependenteVO;

public class FuncionarioDependenteCtr extends CursoProdigioBaseCtr<FuncionarioDependenteVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6212997118498742374L;
	private FuncionarioDependenteVO dependente;

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		Desktop desktop = getTela().getDesktop();
		dependente = (FuncionarioDependenteVO) desktop.getAttribute("dependenteAtual");

		super.doAfterCompose(tela);

		if (estaEditando())
			atualizaObjetoAtual(dependente);
		else
			novo();
	}

	protected boolean estaEditando() {
		return dependente.getId() != null;
	}

	@Override
	protected FuncionarioDependenteVO instanciaNovoObjeto() {
		return dependente;
	}

	@Override
	public void excluir() {
		try {
			repositorio().excluir(getObjetoAtual());
			getMessagesHelper().emiteMensagemSucesso("Dependente removido com sucesso!");
			Window tela = getTela();
			tela.detach();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
