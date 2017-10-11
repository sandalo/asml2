package <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.interfaces.<%modulo%>;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.entidades.<%modulo%>.<%Conceito%>VO;


@WebService
public interface I<%Conceito%>WSFacade {


	@WebMethod
	List<<%Conceito%>VO> metodo1() throws Exception;
	

	@WebMethod
	List<<%Conceito%>VO> metodo2(String param) throws Exception;

}


