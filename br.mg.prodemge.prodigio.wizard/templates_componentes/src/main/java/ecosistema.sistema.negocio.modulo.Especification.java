package <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.negocio.<%modulo%>;

import <%BaseEspecification_fullname%>;

import br.gov.prodigio.comuns.anotacoes.RegraDeNegocio;
import br.gov.prodigio.comuns.anotacoes.enumeracao.MomentoDeExecucao;
import <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.entidades.<%modulo%>.<%Conceito%>VO;
import br.gov.prodigio.comuns.constantes.Constantes;


public class <%Conceito%>RN extends <%BaseEspecification_name%> {
	@RegraDeNegocio(autor = "Autor", codigo = "CODIGO_DA_REGRA", ordem = 1, fluxo = Constantes.FLUXO.GRAVAR, momentoDeExecucao = MomentoDeExecucao.ANTES)
	public void aplicaRegra(<%Conceito%>VO <%conceito%>) {
		
	}
}
