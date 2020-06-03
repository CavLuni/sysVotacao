package sys.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OpcoesVotos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String opcao;
	private Integer voto;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="enquete_id")
	private Enquete enquete;
			
	public OpcoesVotos() {
	}

	public OpcoesVotos(Integer id, String opcao, Enquete enquete) {
		this.id = id;
		this.opcao = opcao;
		this.enquete = enquete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
	
	public Integer getVoto() {
		return voto;
	}

	public void setVoto(Integer voto) {
		this.voto = voto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((opcao == null) ? 0 : opcao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpcoesVotos other = (OpcoesVotos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (opcao == null) {
			if (other.opcao != null)
				return false;
		} else if (!opcao.equals(other.opcao))
			return false;
		return true;
	}
}
