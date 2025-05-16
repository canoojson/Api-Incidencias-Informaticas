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
	private String Comentario;

	@ManyToOne
	@JoinColumn(name = "idIncidencia", nullable = false)
    private Incidencia incidencia;

	public Comentario() {
		super();
	}

	public Comentario(Integer idComentario, String comentario, Incidencia incidencia) {
		this.idComentario = idComentario;
		this.Comentario = comentario;
		this.incidencia = incidencia;
	}

	public Integer getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		this.Comentario = comentario;
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
		result = prime * result + ((Comentario == null) ? 0 : Comentario.hashCode());
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
		if (Comentario == null) {
			if (other.Comentario != null)
				return false;
		} else if (!Comentario.equals(other.Comentario))
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
		return "Comentario [IdComentario=" + idComentario + ", Comentario=" + Comentario + ", incidencia=" + incidencia
				+ "]";
	}
}
