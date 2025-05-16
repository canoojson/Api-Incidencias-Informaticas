package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Blob;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="incidencia")

public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idIncidencia")
    private Integer idIncidencia;

    @OneToOne(mappedBy = "incidencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private IncidenciaHardware incidenciaHardware;
    
    private String tipo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fecha_incidencia;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fecha_introduccion;

    @ManyToOne
    @JoinColumn(name = "idProfesor")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "IdUbicacion")
    private Ubicacion ubicacion;

    private String descripcion;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "IdEstado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "Responsable")
    private Profesor responsable;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fecha_resolucion;

    private Time tiempo_invertido;

    private Blob mas_info;

    @OneToMany(mappedBy = "incidencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;
    
    

	public Incidencia() {
		super();
	}

	public Incidencia(Integer idIncidencia, IncidenciaHardware incidenciaHardware, String tipo, Date fecha_incidencia,
			Date fecha_introduccion, Profesor profesor, Departamento departamento, Ubicacion ubicacion,
			String descripcion, String observaciones, Estado estado, Profesor responsable, Date fecha_resolucion,
			Time tiempo_invertido, Blob mas_info, List<Comentario> comentarios) {
		super();
		this.idIncidencia = idIncidencia;
		this.incidenciaHardware = incidenciaHardware;
		this.tipo = tipo;
		this.fecha_incidencia = fecha_incidencia;
		this.fecha_introduccion = fecha_introduccion;
		this.profesor = profesor;
		this.departamento = departamento;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.observaciones = observaciones;
		this.estado = estado;
		this.responsable = responsable;
		this.fecha_resolucion = fecha_resolucion;
		this.tiempo_invertido = tiempo_invertido;
		this.mas_info = mas_info;
		this.comentarios = comentarios;
	}

	public Integer getIdIncidencia() {
		return idIncidencia;
	}

	public void setIdIncidencia(Integer idIncidencia) {
		this.idIncidencia = idIncidencia;
	}

	public IncidenciaHardware getIncidenciaHardware() {
		return incidenciaHardware;
	}

	public void setIncidenciaHardware(IncidenciaHardware incidenciaHardware) {
		this.incidenciaHardware = incidenciaHardware;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha_incidencia() {
		return fecha_incidencia;
	}

	public void setFecha_incidencia(Date fecha_incidencia) {
		this.fecha_incidencia = fecha_incidencia;
	}

	public Date getFecha_introduccion() {
		return fecha_introduccion;
	}

	public void setFecha_introduccion(Date fecha_introduccion) {
		this.fecha_introduccion = fecha_introduccion;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Profesor getResponsable() {
		return responsable;
	}

	public void setResponsable(Profesor responsable) {
		this.responsable = responsable;
	}

	public Date getFecha_resolucion() {
		return fecha_resolucion;
	}

	public void setFecha_resolucion(Date fecha_resolucion) {
		this.fecha_resolucion = fecha_resolucion;
	}

	public Time getTiempo_invertido() {
		return tiempo_invertido;
	}

	public void setTiempo_invertido(Time tiempo_invertido) {
		this.tiempo_invertido = tiempo_invertido;
	}

	public Blob getMas_info() {
		return mas_info;
	}

	public void setMas_info(Blob mas_info) {
		this.mas_info = mas_info;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentarios, departamento, descripcion, estado, fecha_incidencia, fecha_introduccion,
				fecha_resolucion, idIncidencia, incidenciaHardware, mas_info, observaciones, profesor, responsable,
				tiempo_invertido, tipo, ubicacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidencia other = (Incidencia) obj;
		return Objects.equals(comentarios, other.comentarios) && Objects.equals(departamento, other.departamento)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(estado, other.estado)
				&& Objects.equals(fecha_incidencia, other.fecha_incidencia)
				&& Objects.equals(fecha_introduccion, other.fecha_introduccion)
				&& Objects.equals(fecha_resolucion, other.fecha_resolucion)
				&& Objects.equals(idIncidencia, other.idIncidencia)
				&& Objects.equals(incidenciaHardware, other.incidenciaHardware)
				&& Objects.equals(mas_info, other.mas_info) && Objects.equals(observaciones, other.observaciones)
				&& Objects.equals(profesor, other.profesor) && Objects.equals(responsable, other.responsable)
				&& Objects.equals(tiempo_invertido, other.tiempo_invertido) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(ubicacion, other.ubicacion);
	}

	@Override
	public String toString() {
		return "Incidencia [idIncidencia=" + idIncidencia + ", incidenciaHardware=" + incidenciaHardware + ", tipo="
				+ tipo + ", fecha_incidencia=" + fecha_incidencia + ", fecha_introduccion=" + fecha_introduccion
				+ ", profesor=" + profesor + ", departamento=" + departamento + ", ubicacion=" + ubicacion
				+ ", descripcion=" + descripcion + ", observaciones=" + observaciones + ", estado=" + estado
				+ ", responsable=" + responsable + ", fecha_resolucion=" + fecha_resolucion + ", tiempo_invertido="
				+ tiempo_invertido + ", mas_info=" + mas_info + ", comentarios=" + comentarios + "]";
	}
}
