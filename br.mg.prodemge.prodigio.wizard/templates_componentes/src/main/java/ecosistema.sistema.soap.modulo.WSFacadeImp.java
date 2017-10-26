package <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.soap.<%modulo%>;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.entidades.<%modulo%>.<%Conceito%>VO;
import <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.interfaces.<%modulo%>.I<%Conceito%>WSFacade;
import <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.soap.<%BaseWSFacadeImp_name%>;

import br.gov.prodigio.comuns.IProFacadeLocal;

@Stateless(name = "<%conceito%>-ejb")
@WebService
public class <%Conceito%>WSFacadeImp extends <%BaseWSFacadeImp_name%> implements
		I<%Conceito%>WSFacade {

	@EJB
	private IProFacadeLocal facade;

	@Override
	public List<<%Conceito%>VO> metodo1() throws Exception {
		<%Conceito%>VO <%conceito%>VO = new <%Conceito%>VO();
		Set<<%Conceito%>VO> listaDe<%conceito%>VO = new HashSet<<%Conceito%>VO>();
		listaDe<%conceito%>VO = facade.listarBaseadoNoExemplo(<%conceito%>VO, null, 0, Integer.MAX_VALUE, "nome");
		return new ArrayList<<%Conceito%>VO>(listaDe<%conceito%>VO);
	}

	@Override
	public List<<%Conceito%>VO> metodo2(String nome)
			throws Exception {
		<%Conceito%>VO <%conceito%>VO = new <%Conceito%>VO();
		Set<<%Conceito%>VO> listaDe<%Conceito%>VO = facade.listarBaseadoNoExemplo(<%conceito%>VO, null, 0,Integer.MAX_VALUE, "id");

		return new ArrayList<<%Conceito%>VO>(listaDe<%Conceito%>VO);
	}
}
