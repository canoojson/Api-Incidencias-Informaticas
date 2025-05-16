package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;
	private String comentario;

	@ManyToOne
	@JoinColumn(name = "idIncidencia", nullable = false)
    private Incidencia incidencia;

	public Comentario() {
		super();
	}

	public Comentario(Integer idComentario, String comentario, Incidencia incidencia) {
		this.idComentario = idComentario;
		this.comentario = comentario;
		this.incidencia = incidencia;
	}

	public Integer getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
		result = prime * result + ((idComentario == null) ? 0 : idComentario.hashCode());
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
		if (idComentario == null) {
			if (other.idComentario != null)
				return false;
		} else if (!idComentario.equals(other.idComentario))
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
		return "Comentario [IdComentario=" + idComentario + ", Comentario=" + comentario + ", incidencia=" + incidencia
				+ "]";
	}
}
