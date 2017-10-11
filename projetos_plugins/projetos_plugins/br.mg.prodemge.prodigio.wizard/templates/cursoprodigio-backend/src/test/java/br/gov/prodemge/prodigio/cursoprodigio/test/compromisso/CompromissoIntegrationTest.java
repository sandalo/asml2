package br.gov.prodemge.prodigio.cursoprodigio.test.compromisso;

import java.util.Calendar;
import java.util.Date;

import org.fest.assertions.Assertions;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.prodemge.prodigio.cursoprodigio.entidades.compromisso.CompromissoVO;
import br.gov.prodemge.prodigio.cursoprodigio.test.CursoProdigioBaseIntegrationTest;
import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;
import br.gov.prodigio.entidades.ProVO.SITUACAO_DO_REGISTRO;
import br.gov.prodigio.entidades.StatusDoRegistro;

@RunWith(Arquillian.class)
public class CompromissoIntegrationTest extends CursoProdigioBaseIntegrationTest {

	@Test
	public void gravarCompromisso() throws Exception {
		// Preenchendo o objeto compromisso
		CompromissoVO compromisso = new CompromissoVO();
		Date agora = new Date();
		compromisso.setTsMovimentacao(agora);
		compromisso.setIpMovimentacao("127.0.0.1");
		compromisso.setStatusDoRegistro(StatusDoRegistro.ATIVO);
		compromisso.setTpOperacao(SITUACAO_DO_REGISTRO.EM_EDICAO);
		compromisso.setDescricao("Compromisso " + agora);
		compromisso.setCdLoginMovimentacao("2154567899");
		Calendar calendar = Calendar.getInstance();
		compromisso.setDataInicio(agora);
		calendar.setTime(agora);
		calendar.add(Calendar.HOUR, 1);
		calendar.add(Calendar.MINUTE, 30);
		compromisso.setDataFim(calendar.getTime());
		// Enviando o objeto para a gravação.
		Long id = (Long) repositorio.gravar(compromisso);
		// Conferindo se foi gravado.
		Assertions.assertThat(id).isNotNull();
	}

	@Test
	public void testDescricaoObrigatoria() {
		// Preenchendo o objeto compromisso
		CompromissoVO compromisso = new CompromissoVO();
		Date agora = new Date();
		compromisso.setTsMovimentacao(agora);
		compromisso.setIpMovimentacao("127.0.0.1");
		compromisso.setStatusDoRegistro(StatusDoRegistro.ATIVO);
		compromisso.setTpOperacao(SITUACAO_DO_REGISTRO.EM_EDICAO);
		//compromisso.setDescricao("Compromisso " + agora);
		compromisso.setCdLoginMovimentacao("2154567899");
		Calendar calendar = Calendar.getInstance();
		compromisso.setDataInicio(agora);
		calendar.setTime(agora);
		calendar.add(Calendar.HOUR, 1);
		calendar.add(Calendar.MINUTE, 30);
		compromisso.setDataFim(calendar.getTime());

		Exception e1 = capturaExcecaoAoGravar(compromisso);

		Assertions.assertThat(e1).isExactlyInstanceOf(ViolacaoDeRegraEx.class).hasMessage("A descrição não pode ser nula.");

	}/*

		@Test
		public void testDescricaoDataInicioObrigatoria() {
		// Preenchendo o objeto compromisso
		CompromissoVO compromisso = new CompromissoVO();
		Date agora = new Date();
		compromisso.setTsMovimentacao(agora);
		compromisso.setIpMovimentacao("127.0.0.1");
		compromisso.setStatusDoRegistro(StatusDoRegistro.ATIVO);
		compromisso.setTpOperacao(SITUACAO_DO_REGISTRO.EM_EDICAO);
		compromisso.setDescricao("Compromisso " + agora);
		compromisso.setCdLoginMovimentacao("2154567899");
		Calendar calendar = Calendar.getInstance();
		//compromisso.setDataInicio(agora);
		calendar.setTime(agora);
		calendar.add(Calendar.HOUR, 1);
		calendar.add(Calendar.MINUTE, 30);
		compromisso.setDataFim(calendar.getTime());

		Exception e1 = capturaExcecaoAoGravar(compromisso);

		Assertions.assertThat(e1).isExactlyInstanceOf(ViolacaoDeRegraEx.class).hasMessage("A data de inicio não pode ser nula.");

		}

		@Test
		public void testDescricaoDataFimObrigatoria() {
		// Preenchendo o objeto compromisso
		CompromissoVO compromisso = new CompromissoVO();
		Date agora = new Date();
		compromisso.setTsMovimentacao(agora);
		compromisso.setIpMovimentacao("127.0.0.1");
		compromisso.setStatusDoRegistro(StatusDoRegistro.ATIVO);
		compromisso.setTpOperacao(SITUACAO_DO_REGISTRO.EM_EDICAO);
		compromisso.setDescricao("Compromisso " + agora);
		compromisso.setCdLoginMovimentacao("2154567899");
		Calendar calendar = Calendar.getInstance();
		compromisso.setDataInicio(agora);
		calendar.setTime(agora);
		calendar.add(Calendar.HOUR, 1);
		calendar.add(Calendar.MINUTE, 30);
		//compromisso.setDataFim(calendar.getTime());

		Exception e1 = capturaExcecaoAoGravar(compromisso);

		Assertions.assertThat(e1).isExactlyInstanceOf(ViolacaoDeRegraEx.class).hasMessage("A data de fim não pode ser nula.");

		}

		@Test
		public void testDataInicioMaiorQueDataFim() {
		// Preenchendo o objeto compromisso
		CompromissoVO compromisso = new CompromissoVO();
		Date agora = new Date();
		compromisso.setTsMovimentacao(agora);
		compromisso.setIpMovimentacao("127.0.0.1");
		compromisso.setStatusDoRegistro(StatusDoRegistro.ATIVO);
		compromisso.setTpOperacao(SITUACAO_DO_REGISTRO.EM_EDICAO);
		compromisso.setDescricao("Compromisso " + agora);
		compromisso.setCdLoginMovimentacao("2154567899");
		Calendar calendar = Calendar.getInstance();
		compromisso.setDataFim(agora);
		calendar.setTime(agora);
		calendar.add(Calendar.HOUR, 1);
		calendar.add(Calendar.MINUTE, 30);
		compromisso.setDataInicio(calendar.getTime());

		Exception e1 = capturaExcecaoAoGravar(compromisso);

		Assertions.assertThat(e1).isExactlyInstanceOf(ViolacaoDeRegraEx.class).hasMessage("A data de inicio não pode ser maior que a data de fim.");

		}
		*/
}