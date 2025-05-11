package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "idIncidencia")
@Table(name="Incidencia_Hardware")
public class IncidenciaHardware extends Incidencia {
    private String modelo;
    private String num_serie;

    @ManyToOne
    @JoinColumn(name = "IdTipoHw") 
    private TiposHw tipoHw;

    public IncidenciaHardware() {
        super();
    }

    public IncidenciaHardware(String modelo, String num_serie, Incidencia incidencia, TiposHw tipoHw) {
        this.modelo = modelo;
        this.num_serie = num_serie;
        this.tipoHw = tipoHw;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((num_serie == null) ? 0 : num_serie.hashCode());
        result = prime * result + ((tipoHw == null) ? 0 : tipoHw.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        IncidenciaHardware other = (IncidenciaHardware) obj;
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
        if (tipoHw == null) {
            if (other.tipoHw != null)
                return false;
        } else if (!tipoHw.equals(other.tipoHw))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IncidenciaHardware [modelo=" + modelo + ", num_serie=" + num_serie + ", tipoHw=" + tipoHw + "]";
    }

    
}
