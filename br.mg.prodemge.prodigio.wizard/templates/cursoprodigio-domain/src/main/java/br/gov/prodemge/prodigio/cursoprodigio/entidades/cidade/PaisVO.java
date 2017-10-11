package br.gov.prodemge.prodigio.cursoprodigio.entidades.cidade;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.prodemge.prodigio.cursoprodigio.entidades.CursoProdigioBaseVO;
import br.gov.prodigio.comuns.anotacoes.Lookup;

@Lookup
@Entity
@Table(name="tb_pais")
public class PaisVO extends CursoProdigioBaseVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1867520330557419868L;
	private Set<EstadoSimpleVO>estados = new LinkedHashSet<EstadoSimpleVO>();

	
	private String nome;
	
	@Override
	@Id
	@SequenceGenerator(name = "sq_cidade", sequenceName = "sq_cidade", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_cidade")
	public Long getId() {
		return super.getId();
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="pais", orphanRemoval = true)
	@OrderBy("id")
	public Set<EstadoSimpleVO> getEstados() {
		return estados;
	}
	public void setEstados(Set<EstadoSimpleVO> estados) {
		this.estados = estados;
	}
	
	@Override
	public String toString() {
		if(getNome() == null)
			setNome("");
		return getNome();
	}
	
}
