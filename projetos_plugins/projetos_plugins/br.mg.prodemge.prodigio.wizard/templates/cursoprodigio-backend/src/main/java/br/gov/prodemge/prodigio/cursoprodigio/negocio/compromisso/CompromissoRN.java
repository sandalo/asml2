package br.gov.prodemge.prodigio.cursoprodigio.negocio.compromisso;

import java.util.LinkedHashMap;
import java.util.Map;

import br.gov.prodemge.prodigio.cursoprodigio.entidades.compromisso.CompromissoVO;
import br.gov.prodemge.prodigio.cursoprodigio.negocio.CursoBaseRN;
import br.gov.prodigio.comuns.anotacoes.RegraDeNegocio;
import br.gov.prodigio.comuns.anotacoes.enumeracao.MomentoDeExecucao;
import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;
import br.gov.prodigio.comuns.utils.StringHelper;

public class CompromissoRN extends CursoBaseRN {

	/*	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = br.gov.prodigio.comuns.constantes.Constantes.FLUXO.LISTAR_BASEADO_NO_EXEMPLO, momentoDeExecucao = MomentoDeExecucao.APOS)
		public List limpaPesquisa(CompromissoVO compromisso) {
			compromisso.getAtributo("")
			if (StringHelper.isEmpty(compromisso.getDescricao())) {
				throw new ViolacaoDeRegraEx("A descrição não pode ser nula.");
			}
		}*/

	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void verificaDescrição(CompromissoVO compromisso) {
		if (StringHelper.isEmpty(compromisso.getDescricao())) {
			throw new ViolacaoDeRegraEx("A descrição não pode ser nula.");
		}
	}

	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void verificadataInicio(CompromissoVO compromisso) {
		if (compromisso.getDataInicio() == null) {
			throw new ViolacaoDeRegraEx("A data de inicio não pode ser nula.");
		}
	}

	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void verificadataFim(CompromissoVO compromisso) {
		if (compromisso.getDataFim() == null) {
			throw new ViolacaoDeRegraEx("A data de fim não pode ser nula.");
		}
	}

	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void verificadataInicioMaiorQueDataFim(CompromissoVO compromisso) {
		if (compromisso.getDataFim().before(compromisso.getDataInicio())) {
			Map<String, String> erros = new LinkedHashMap<String, String>();
			erros.put("dataInicio", "A data de inicio não pode ser maior que a data de fim.");
			erros.put("dataFim", "A data de inicio não pode ser maior que a data de fim.");
			throw new ViolacaoDeRegraEx(erros);
		}
	}

}
