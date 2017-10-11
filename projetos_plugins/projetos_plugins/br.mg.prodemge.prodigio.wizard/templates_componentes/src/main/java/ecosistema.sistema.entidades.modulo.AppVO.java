package <%package%>;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import <%package_componente_base%>.<%componente_base%>BaseVO;

public class <%componente%>VO extends <%componente_base%>BaseVO {

	@Override
	@Id
	@SequenceGenerator(name = "sq_<%componente%>", sequenceName = "sq_<%componente%>", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_<%componente%>")
	public Long getId() {
		return super.getId();
	}

}
