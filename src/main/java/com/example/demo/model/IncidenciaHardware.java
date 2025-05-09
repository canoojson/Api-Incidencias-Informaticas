package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Incidencia_Hardware")
public class IncidenciaHardware {
    
    private Integer IdIncidencia;
    private Integer tipo_hw;
    private String modelo;
    private String num_serie;

    @OneToOne
    @MapsId
    @JoinColumn(name = "IdIncidencia")
    private Incidencia incidencia;

    @ManyToOne
    @JoinColumn(name = "IdTipoHw") 
    private TiposHw tipoHw;

    public IncidenciaHardware() {
        super();
    }

    public IncidenciaHardware(Integer idIncidencia, Integer tipo_hw, String modelo, String num_serie, Incidencia incidencia, TiposHw tipoHw) {
        IdIncidencia = idIncidencia;
        this.tipo_hw = tipo_hw;
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.incidencia = incidencia;
        this.tipoHw = tipoHw;
    }
    public Integer getIdIncidencia() {
        return IdIncidencia;
    }
    public void setIdIncidencia(Integer idIncidencia) {
        IdIncidencia = idIncidencia;
    }
    public Integer getTipo_hw() {
        return tipo_hw;
    }
    public void setTipo_hw(Integer tipo_hw) {
        this.tipo_hw = tipo_hw;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getNum_serie() {
        return num_serie;
    }
    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
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
        result = prime * result + ((IdIncidencia == null) ? 0 : IdIncidencia.hashCode());
        result = prime * result + ((tipo_hw == null) ? 0 : tipo_hw.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((num_serie == null) ? 0 : num_serie.hashCode());
        result = prime * result + ((incidencia == null) ? 0 : incidencia.hashCode());
        result = prime * result + ((tipoHw == null) ? 0 : tipoHw.hashCode());
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
        IncidenciaHardware other = (IncidenciaHardware) obj;
        if (IdIncidencia == null) {
            if (other.IdIncidencia != null)
                return false;
        } else if (!IdIncidencia.equals(other.IdIncidencia))
            return false;
        if (tipo_hw == null) {
            if (other.tipo_hw != null)
                return false;
        } else if (!tipo_hw.equals(other.tipo_hw))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (num_serie == null) {
            if (other.num_serie != null)
                return false;
        } else if (!num_serie.equals(other.num_serie))
            return false;
        if (incidencia == null) {
            if (other.incidencia != null)
                return false;
        } else if (!incidencia.equals(other.incidencia))
            return false;
        if (tipoHw == null) {
            if (other.tipoHw != null)
                return false;
        } else if (!tipoHw.equals(other.tipoHw))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IncidenciaHardware [IdIncidencia=" + IdIncidencia + ", tipo_hw=" + tipo_hw + ", modelo=" + modelo
                + ", num_serie=" + num_serie + ", incidencia=" + incidencia + ", tipoHw=" + tipoHw + "]";
    }
}
