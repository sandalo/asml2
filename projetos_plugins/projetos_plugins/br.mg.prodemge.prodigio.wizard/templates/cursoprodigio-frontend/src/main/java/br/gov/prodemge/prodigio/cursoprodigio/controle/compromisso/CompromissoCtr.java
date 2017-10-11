package br.gov.prodemge.prodigio.cursoprodigio.controle.compromisso;

import br.gov.prodemge.prodigio.cursoprodigio.controle.CursoProdigioBaseCtr;
import br.gov.prodemge.prodigio.cursoprodigio.entidades.compromisso.CompromissoVO;
import br.gov.prodigio.controle.componente.DateboxBind;

public class CompromissoCtr extends CursoProdigioBaseCtr<CompromissoVO> {
	public void configuraLimiteData(DateboxBind bind) {
		bind.setConstraint("between 20170217 and 20170218 , between 20170220 and 20170221");
	}
}
