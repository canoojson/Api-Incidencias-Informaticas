package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Blob;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Incidencia")
@Inheritance(strategy = InheritanceType.JOINED)
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

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
    @JoinColumn(name = "id_ubicacion")
    private Ubicacion ubicacion;

    private String descripcion;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "IdEstado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "responsable")
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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((fecha_incidencia == null) ? 0 : fecha_incidencia.hashCode());
        result = prime * result + ((fecha_introduccion == null) ? 0 : fecha_introduccion.hashCode());
        result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
        result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
        result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
        result = prime * result + ((estado == null) ? 0 : estado.hashCode());
        result = prime * result + ((responsable == null) ? 0 : responsable.hashCode());
        result = prime * result + ((fecha_resolucion == null) ? 0 : fecha_resolucion.hashCode());
        result = prime * result + ((tiempo_invertido == null) ? 0 : tiempo_invertido.hashCode());
        result = prime * result + ((mas_info == null) ? 0 : mas_info.hashCode());
        result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
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
        Incidencia other = (Incidencia) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (fecha_incidencia == null) {
            if (other.fecha_incidencia != null)
                return false;
        } else if (!fecha_incidencia.equals(other.fecha_incidencia))
            return false;
        if (fecha_introduccion == null) {
            if (other.fecha_introduccion != null)
                return false;
        } else if (!fecha_introduccion.equals(other.fecha_introduccion))
            return false;
        if (profesor == null) {
            if (other.profesor != null)
                return false;
        } else if (!profesor.equals(other.profesor))
            return false;
        if (departamento == null) {
            if (other.departamento != null)
                return false;
        } else if (!departamento.equals(other.departamento))
            return false;
        if (ubicacion == null) {
            if (other.ubicacion != null)
                return false;
        } else if (!ubicacion.equals(other.ubicacion))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (observaciones == null) {
            if (other.observaciones != null)
                return false;
        } else if (!observaciones.equals(other.observaciones))
            return false;
        if (estado == null) {
            if (other.estado != null)
                return false;
        } else if (!estado.equals(other.estado))
            return false;
        if (responsable == null) {
            if (other.responsable != null)
                return false;
        } else if (!responsable.equals(other.responsable))
            return false;
        if (fecha_resolucion == null) {
            if (other.fecha_resolucion != null)
                return false;
        } else if (!fecha_resolucion.equals(other.fecha_resolucion))
            return false;
        if (tiempo_invertido == null) {
            if (other.tiempo_invertido != null)
                return false;
        } else if (!tiempo_invertido.equals(other.tiempo_invertido))
            return false;
        if (mas_info == null) {
            if (other.mas_info != null)
                return false;
        } else if (!mas_info.equals(other.mas_info))
            return false;
        if (comentarios == null) {
            if (other.comentarios != null)
                return false;
        } else if (!comentarios.equals(other.comentarios))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Incidencia [ID=" + ID + ", tipo=" + tipo + ", fecha_incidencia=" + fecha_incidencia
                + ", fecha_introduccion=" + fecha_introduccion + ", profesor=" + profesor + ", departamento="
                + departamento + ", ubicacion=" + ubicacion + ", descripcion=" + descripcion + ", observaciones="
                + observaciones + ", estado=" + estado + ", responsable=" + responsable + ", fecha_resolucion="
                + fecha_resolucion + ", tiempo_invertido=" + tiempo_invertido + ", mas_info=" + mas_info
                + ", comentarios=" + comentarios + "]";
    }
}
