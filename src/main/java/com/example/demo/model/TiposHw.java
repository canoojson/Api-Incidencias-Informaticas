package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TiposHw")
public class TiposHw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoHw;
    private String descrip;

    @OneToMany(mappedBy = "tipoHw")
    private List<IncidenciaHardware> incidenciasHardware;
    
    public TiposHw() {
        super();
    }
    public TiposHw(Integer idTipoHw, String descrip, List<IncidenciaHardware> incidenciasHardware) {
        this.idTipoHw = idTipoHw;
        this.descrip = descrip;
        this.incidenciasHardware = incidenciasHardware;
    }
    public Integer getIdTipoHw() {
        return idTipoHw;
    }
    public void setIdTipoHw(Integer idTipoHw) {
        this.idTipoHw = idTipoHw;
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
        result = prime * result + ((idTipoHw == null) ? 0 : idTipoHw.hashCode());
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
        if (idTipoHw == null) {
            if (other.idTipoHw != null)
                return false;
        } else if (!idTipoHw.equals(other.idTipoHw))
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
        return "TiposHw [idTipoHw=" + idTipoHw + ", descrip=" + descrip + ", incidenciasHardware=" + incidenciasHardware
                + "]";
    }
}
