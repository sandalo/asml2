package <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.schedule.<%modulo%>;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import br.gov.prodigio.comuns.IProFacadeLocal;

import <%ecosistema_raw_matching%><%ecosistema_name%>.<%sistema_name%>.entidades.<%modulo%>.<%Conceito%>VO;

@Stateless
public class <%Conceito%>Schedule {
	
	@EJB
	private IProFacadeLocal facade;
	/*A cada minuto executa essa regra*/
	@Schedule(minute = "*/1", hour = "*", persistent = false)
	public void test(){
		try {
			facade.executar(new <%Conceito%>VO(), "executaTarefa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
