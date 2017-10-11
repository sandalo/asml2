package <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.persistencia.<%modulo%>;

import <%BaseDAO_fullname%>;
import br.gov.prodigio.entidades.ProBaseVO;
import java.util.Set;

public class <%Conceito%>DAO extends <%BaseDAO_name%> {
	@Override
	public Object gravar(Object objeto) throws Exception {
		return super.gravar(objeto);
	}

	@Override
	public Set<ProBaseVO> listarBaseadoNoExemplo(ProBaseVO exemplo, ProBaseVO exemplo2, int primeiroRegistro, int quantidadeDeRegistros, String... projecoes) {
		return super.listarBaseadoNoExemplo(exemplo, exemplo2,primeiroRegistro, quantidadeDeRegistros, projecoes);
	}

}
