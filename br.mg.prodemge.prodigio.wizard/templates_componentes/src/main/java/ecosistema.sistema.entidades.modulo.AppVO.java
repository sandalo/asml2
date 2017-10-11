package br.gov.prodemge.<%ecosistema_name%>.<%sistema_name%>.entidades.<%modulo%>;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;

import <%AppBaseVO_fullname%>;

@Entity
public class <%Conceito%>VO extends <%AppBaseVO_name%> {

	@Override
	@Id
	@SequenceGenerator(name = "sq_<%conceito%>", sequenceName = "sq_<%conceito%>", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_<%conceito%>")
	public Long getId() {
		return super.getId();
	}

}
