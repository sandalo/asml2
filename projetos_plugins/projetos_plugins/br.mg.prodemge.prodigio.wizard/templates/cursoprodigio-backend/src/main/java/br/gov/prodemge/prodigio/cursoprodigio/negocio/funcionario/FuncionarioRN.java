package br.gov.prodemge.prodigio.cursoprodigio.negocio.funcionario;

import java.util.LinkedHashMap;
import java.util.Map;

import br.gov.prodemge.prodigio.cursoprodigio.entidades.funcionario.FuncionarioVO;
import br.gov.prodemge.prodigio.cursoprodigio.negocio.CursoBaseRN;
import br.gov.prodigio.comuns.anotacoes.RegraDeNegocio;
import br.gov.prodigio.comuns.anotacoes.enumeracao.MomentoDeExecucao;
import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;
import br.gov.prodigio.comuns.utils.StringHelper;

public class FuncionarioRN extends CursoBaseRN {

	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = "gravar", momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void verificaNome(FuncionarioVO funcionarioVO) {
		/*		if (StringHelper.isEmpty(funcionarioVO.getNome())) {
					throw new ViolacaoDeRegraEx("Nome é obrigatório.");
				}*/

		Map<String, String> erros = new LinkedHashMap<String, String>();
		if (StringHelper.isEmpty(funcionarioVO.getNome())) {
			erros.put("nome", "Nome é obrigatório.");
		}
		if (StringHelper.isEmpty(funcionarioVO.getCpf())) {
			erros.put("cpf", "Cpf inválido.");
		}
		if ((funcionarioVO.getSalario() != null && funcionarioVO.getSalario().intValue() <= 0)) {
			erros.put("salario", "Aumenta esse salário!.");
		}
		if (StringHelper.isEmpty(funcionarioVO.getMatricula())) {
			erros.put("matricula", "Matrícula inválida.");
		}
		if (funcionarioVO.getCursosExatas() == null) {
			erros.put("cursosHumanas", "Preencha pelo menos uma formação");
		}
		if (funcionarioVO.getPaisVO() == null || funcionarioVO.getPaisVO().getId() == null) {
			erros.put("paisVO", "Preencha a cidade, estado e pais.");
		}
		if (!erros.isEmpty())
			throw new ViolacaoDeRegraEx(erros);
	}
}
