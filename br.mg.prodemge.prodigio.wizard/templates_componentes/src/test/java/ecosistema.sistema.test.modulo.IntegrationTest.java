package <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.test.<%modulo%>;

import org.fest.assertions.Assertions;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import br.gov.prodigio.comuns.excecoes.ViolacaoDeRegraEx;

import <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.entidades.<%modulo%>.<%Conceito%>VO;
import <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.test.<%BaseIntegrationTest_name%>;

@RunWith(Arquillian.class)
public class  <%Conceito%>IntegrationTest extends <%BaseIntegrationTest_name%> {

	@Test
	public void gravar<%Conceito%>() {
		<%Conceito%>VO <%conceito%> = new <%Conceito%>VO();
	Exception e1 = capturaExcecaoAoGravar(<%conceito%>); 
		/*VERIFICA SE A EXCEÇÃO LANÇADA É A EXCEÇÃO ESPERADA */
		Assertions.assertThat(e1).isExactlyInstanceOf(ViolacaoDeRegraEx.class).hasMessage("Mensagem de erro");
	}

}
