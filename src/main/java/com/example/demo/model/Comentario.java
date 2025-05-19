package com.example.demo.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdComentario;
	private String Comentario;
	private Date fecha_comentario;
	
	@ManyToOne
    @JoinColumn(name = "IdProfesor")
    private Profesor profesor;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "IdIncidencia")
    private Incidencia incidencia;

	public Comentario() {
		super();
	}

	public Comentario(Integer idComentario, String comentario, Date fecha_comentario, Profesor profesor,
			Incidencia incidencia) {
		super();
		IdComentario = idComentario;
		Comentario = comentario;
		this.fecha_comentario = fecha_comentario;
		this.profesor = profesor;
		this.incidencia = incidencia;
	}

	public Integer getIdComentario() {
		return IdComentario;
	}

	public void setIdComentario(Integer idComentario) {
		IdComentario = idComentario;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	public Date getFecha_comentario() {
		return fecha_comentario;
	}

	public void setFecha_comentario(Date fecha_comentario) {
		this.fecha_comentario = fecha_comentario;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Comentario, IdComentario, fecha_comentario, incidencia, profesor);
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
		return Objects.equals(Comentario, other.Comentario) && Objects.equals(IdComentario, other.IdComentario)
				&& Objects.equals(fecha_comentario, other.fecha_comentario)
				&& Objects.equals(incidencia, other.incidencia) && Objects.equals(profesor, other.profesor);
	}

	@Override
	public String toString() {
		return "Comentario [IdComentario=" + IdComentario + ", Comentario=" + Comentario + ", fecha_comentario="
				+ fecha_comentario + ", profesor=" + profesor + ", incidencia=" + incidencia + "]";
	}
}
