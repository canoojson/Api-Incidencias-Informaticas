package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcomentario;
	private String comentario;

	@ManyToOne
	@JoinColumn(name = "IdIncidencia", nullable = false)
    private Incidencia incidencia;

	public Comentario() {
		super();
	}

	public Comentario(Integer idComentario, String comentario, Incidencia incidencia) {
		idcomentario = idComentario;
		comentario = comentario;
		this.incidencia = incidencia;
	}

	public Integer getIdComentario() {
		return idcomentario;
	}

	public void setIdComentario(Integer idComentario) {
		idcomentario = idComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		comentario = comentario;
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcomentario == null) ? 0 : idcomentario.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((incidencia == null) ? 0 : incidencia.hashCode());
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
		Comentario other = (Comentario) obj;
		if (idcomentario == null) {
			if (other.idcomentario != null)
				return false;
		} else if (!idcomentario.equals(other.idcomentario))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (incidencia == null) {
			if (other.incidencia != null)
				return false;
		} else if (!incidencia.equals(other.incidencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [IdComentario=" + idcomentario + ", Comentario=" + comentario + ", incidencia=" + incidencia
				+ "]";
	}
}
