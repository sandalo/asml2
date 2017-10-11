package br.gov.prodemge.prodigio.cursoprodigio.controle.funcionario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Image;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Textbox;

import br.gov.prodemge.prodigio.cursoprodigio.controle.CursoProdigioBaseCtr;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.cidade.LogradouroVO;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.curso.CursoVO;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.funcionario.FuncionarioAnexoVO;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.funcionario.FuncionarioDependenteVO;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.funcionario.FuncionarioEnderecoVO;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.funcionario.FuncionarioVO;
import br.gov.prodemge.prodigio.cursoprodigio.enums.curso.CursoAreaEnum;
import br.gov.prodemge.prodigio.cursoprodigio.enums.funcionario.EstadoCivilEnum;
import br.gov.prodemge.prodigio.cursoprodigio.enums.funcionario.FuncionarioAnexoEnum;
import br.gov.prodigio.controle.componente.Bandboxbind;
import br.gov.prodigio.controle.componente.DetBox;
import br.gov.prodigio.controle.componente.InternalWindow;
import br.gov.prodigio.entidades.ProBaseVO;

public class FuncionarioCtr extends CursoProdigioBaseCtr<FuncionarioVO> {
	/**
	 * 
	 */

	FuncionarioVO funcionarioEmDetalhes;

	private static final long serialVersionUID = 6154613886089037614L;

	@Override
	public void doAfterCompose(Component tela) throws Exception {
		super.doAfterCompose(tela);
		Component component = getTela().getFellow("selecao");
		// pesquisar();
	}

	@Override
	protected void configuraValoresPadroesParaObjetoArg(FuncionarioVO pArg, FuncionarioVO pArg2) {
		/*		PaisVO pais = new PaisVO();
				EstadoSimpleVO estado = new EstadoSimpleVO();
				estado.setPais(pais);
				CidadeVO cidade = new CidadeVO();
				cidade.setEstado(estado);
				pArg.setCidade(cidade);
		*/super.configuraValoresPadroesParaObjetoArg(pArg, pArg2);
	}

	@Override
	protected void configuraValoresPadroesParaObjeto() {
		FuncionarioVO funcionarioVO = getObjetoAtual();
		FuncionarioEnderecoVO funcionarioEndereco = funcionarioVO.getFuncionarioEndereco();
		if (funcionarioEndereco == null) {
			funcionarioEndereco = new FuncionarioEnderecoVO();
		}
		funcionarioEndereco.setFuncionario(funcionarioVO);
		funcionarioVO.setFuncionarioEndereco(funcionarioEndereco);
	}

	public void recuperaLogradouroPorCep(Textbox textbox) throws Exception {
		String value = textbox.getValue();
		LogradouroVO exemplo = new LogradouroVO();
		exemplo.setCep(value);

		LogradouroVO logradouro = repositorio().recuperaPorChaveNatural(exemplo, "cep");

		getObjetoAtual().getFuncionarioEndereco().setLogradouro(logradouro);
		Component parteDaTelaQueContemOsCamposDeEndereco = getWindowAtual().getFellow("endereco");
		getBinder().loadComponent(parteDaTelaQueContemOsCamposDeEndereco);
	}

	public void aumentarImage(Image imagem) {
		String widthRaw = imagem.getWidth();
		if (widthRaw == null)
			widthRaw = "0";
		Integer width = Integer.valueOf(widthRaw.replace("px", "")) + 100;
		String heightRaw = imagem.getHeight();
		if (heightRaw == null)
			heightRaw = "0";
		Integer height = Integer.valueOf(heightRaw.replace("px", "")) + 100;
		imagem.setWidth(width + "px");
		imagem.setHeight(height + "px");
	}

	public void diminuirImage(Image imagem) {
		String widthRaw = imagem.getWidth();
		if (widthRaw == null)
			widthRaw = "0";
		Integer width = Integer.valueOf(widthRaw.replace("px", "")) - 100;
		String heightRaw = imagem.getHeight();
		if (heightRaw == null)
			heightRaw = "0";
		Integer height = Integer.valueOf(heightRaw.replace("px", "")) - 100;
		imagem.setWidth(width + "px");
		imagem.setHeight(height + "px");
	}

	public void downloadImage() {
		Filedownload.save(getObjetoAtual().getImagem(), "jpeg", "Nome do arquivo: Não definido");
	}

	@Override
	public void antesPesquisar(ProBaseVO pArg, ProBaseVO pArg2) throws Exception {
		((FuncionarioVO) pArg).setFuncionarioEndereco(null);
		((FuncionarioVO) pArg2).setFuncionarioEndereco(null);
		super.antesPesquisar(pArg, pArg2);
	}

	public void verCursos(Listcell listcell) {
		Listitem item = (Listitem) listcell.getParent();
		funcionarioEmDetalhes = item.getValue();

		InternalWindow internalWindow = (InternalWindow) getTela().getFellow("cursoDetalhe");
		//internalWindow.doPopup();
		//internalWindow.doEmbedded();
		//internalWindow.doOverlapped();
		//internalWindow.setParent(listcell);
		//internalWindow.doHighlighted();
		//internalWindow.doModal();
		Popup popupWindow = (Popup) getTela().getFellow("cursoDetalhePopup");
		popupWindow.open(listcell);

		getBinder().loadAll();
	}

	public FuncionarioVO getFuncionarioEmDetalhes() {
		return funcionarioEmDetalhes;
	}

	public void setFuncionarioEmDetalhes(FuncionarioVO funcionarioEmDetalhes) {
		this.funcionarioEmDetalhes = funcionarioEmDetalhes;
	}

	public List<EstadoCivilEnum> getEstadoCivil() {
		EstadoCivilEnum[] values = EstadoCivilEnum.values();
		ArrayList<EstadoCivilEnum> arrayList = new ArrayList<EstadoCivilEnum>(Arrays.asList(values));
		return arrayList;
	}

	@Override
	protected void inicializaNovoDetalhe(Object detalheNovo, DetBox detBox) {
		if (detalheNovo instanceof FuncionarioAnexoVO) {
			FuncionarioAnexoVO funcionarioAnexoVO = (FuncionarioAnexoVO) detalheNovo;
			if (detBox.getId().equals("anexosDet")) {
				funcionarioAnexoVO.setAnexoTipo(FuncionarioAnexoEnum.MEMORANDO);
			}
			if (detBox.getId().equals("anexosOficioDet")) {
				funcionarioAnexoVO.setAnexoTipo(FuncionarioAnexoEnum.OFICIO);
			}
		}
	}

	@Override
	public void setObjetoAtual(Object objetoAtual) {
		super.setObjetoAtual(objetoAtual);
		getTela().getDesktop().setAttribute("funcionarioAtual", this.objetoAtual);
	}

	public void editarDependente(Listitem listitem) throws Exception {
		FuncionarioDependenteVO dependenteVO = listitem.getValue();
		abreDependente(dependenteVO);
	}

	public void novoDependente() throws Exception {
		FuncionarioDependenteVO dependenteVO = new FuncionarioDependenteVO();
		dependenteVO.setFuncionario(getObjetoAtual());
		abreDependente(dependenteVO);
	}

	protected void abreDependente(FuncionarioDependenteVO dependenteVO) throws Exception {
		getTela().getDesktop().setAttribute("dependenteAtual", dependenteVO);
		getHelperView().abreCasoDeUsoSecundario("funcionario/funcionarioDependente.zul", getTela(), new LinkedHashMap<String, Object>(), false, "modal", "50%");

		this.objetoAtual = repositorio().recuperaObjeto(objetoAtual);
		getBinder().loadComponent(getTela().getFellow("div_dependente"));
	}

	@Override
	public boolean detalheSomenteLeitura(DetBox detalhe) {
		if (detalhe.getId().equals("dependentesDet"))
			return true;
		return super.detalheSomenteLeitura(detalhe);
	}

	public List<CursoVO> filtraCursoHumanas(Bandboxbind bandboxbind) {
		List<CursoVO> cursosVOHumanas = new ArrayList<CursoVO>();
		List<CursoVO> cursosVOs = getLista("listaDeCursoVO");
		for (CursoVO curso : cursosVOs) {
			if (curso.getAreaCurso() != null && curso.getAreaCurso().equals(CursoAreaEnum.HUMANAS)) {
				cursosVOHumanas.add(curso);
			}
		}
		return cursosVOHumanas;
	}
}