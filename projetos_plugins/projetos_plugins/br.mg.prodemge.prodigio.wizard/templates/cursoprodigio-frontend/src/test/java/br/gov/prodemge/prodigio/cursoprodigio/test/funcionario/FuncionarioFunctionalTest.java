package br.gov.prodemge.prodigio.cursoprodigio.test.funcionario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.gov.prodemge.prodigio.cursoprodigio.test.CursoProdigioBaseFunctionalTest;

public class FuncionarioFunctionalTest extends CursoProdigioBaseFunctionalTest {

	@Test
	public void testGravacaoSucesso() throws Exception {
			waitAndClickById("nav_8-cnt");
			findElementById("navitem_9-a").click();
			waitAndClickById("novo_button_155");
			findElementById("nome_textboxbind_84").clear();
			findElementById("nome_textboxbind_84").sendKeys("TESTE_FUNCIONAL NOME FUNCIONARIO");
			waitAndClickById("salvar_button_158");
			assertEquals("Registro gravado com sucesso",findElementByXPath("//body/div[2]/div[2]").getText());
	}

	
/*	@Test
	public void testNomeObrigatorio() throws Exception {
		    waitAndClickById("nav_8-cnt");
			waitAndClickById("navitem_9-text");
			waitAndClickById("novo_button_145");
			findElementById("salvar_button_148").click();
			assertEquals("O funcionario precisa de um nome.",findElementById("label_230").getText());
	} 

	
	@Test
	public void testCpfInvalido() throws Exception {
			waitAndClickById("nav_8-cnt");
			waitAndClickById("navitem_9-text");
			waitAndClickById("novo_button_145");
			findElementById("cpf_cpfboxbind_86").clear();
			findElementById("cpf_cpfboxbind_86").sendKeys("12345678912");
			waitAndClickById("matricula_textboxbind_89");
			assertEquals("CPF inválido",findElementByXPath("//body/div[2]/div[2]").getText());
	}
	*/


}