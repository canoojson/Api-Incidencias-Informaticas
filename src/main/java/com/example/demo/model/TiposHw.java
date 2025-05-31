package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tiposHw")
public class TiposHw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdTipoHw;
    private String descrip;

    @OneToMany(mappedBy = "tipoHw")
    @JsonIgnore
    private List<IncidenciaHardware> incidenciasHardware;
    
    public TiposHw() {
        super();
    }
    public TiposHw(Integer idTipoHw, String descrip, List<IncidenciaHardware> incidenciasHardware) {
        this.IdTipoHw = idTipoHw;
        this.descrip = descrip;
        this.incidenciasHardware = incidenciasHardware;
    }
    public Integer getIdTipoHw() {
        return IdTipoHw;
    }
    public void setIdTipoHw(Integer idTipoHw) {
        this.IdTipoHw = idTipoHw;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public List<IncidenciaHardware> getIncidenciasHardware() {
        return incidenciasHardware;
    }
    public void setIncidenciasHardware(List<IncidenciaHardware> incidenciasHardware) {
        this.incidenciasHardware = incidenciasHardware;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((IdTipoHw == null) ? 0 : IdTipoHw.hashCode());
        result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
        result = prime * result + ((incidenciasHardware == null) ? 0 : incidenciasHardware.hashCode());
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
        TiposHw other = (TiposHw) obj;
        if (IdTipoHw == null) {
            if (other.IdTipoHw != null)
                return false;
        } else if (!IdTipoHw.equals(other.IdTipoHw))
            return false;
        if (descrip == null) {
            if (other.descrip != null)
                return false;
        } else if (!descrip.equals(other.descrip))
            return false;
        if (incidenciasHardware == null) {
            if (other.incidenciasHardware != null)
                return false;
        } else if (!incidenciasHardware.equals(other.incidenciasHardware))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "TiposHw [idTipoHw=" + IdTipoHw + ", descrip=" + descrip + ", incidenciasHardware=" + incidenciasHardware
                + "]";
    }
}
