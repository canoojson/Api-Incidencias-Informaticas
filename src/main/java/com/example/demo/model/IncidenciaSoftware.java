package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Incidencia_Software")
@PrimaryKeyJoinColumn(name = "idIncidencia")
public class IncidenciaSoftware extends Incidencia {
    @Column(name = "S.O.")
    private String SO;
    private String software;
    private String clave;

    public IncidenciaSoftware() {
        super();
    }

    public IncidenciaSoftware(String SO, String software, String clave, Incidencia incidencia) {
        this.SO = SO;
        this.software = software;
        this.clave = clave;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String sO) {
        SO = sO;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((SO == null) ? 0 : SO.hashCode());
        result = prime * result + ((software == null) ? 0 : software.hashCode());
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
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
        IncidenciaSoftware other = (IncidenciaSoftware) obj;
        if (SO == null) {
            if (other.SO != null)
                return false;
        } else if (!SO.equals(other.SO))
            return false;
        if (software == null) {
            if (other.software != null)
                return false;
        } else if (!software.equals(other.software))
            return false;
        if (clave == null) {
            if (other.clave != null)
                return false;
        } else if (!clave.equals(other.clave))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IncidenciaSoftware [SO=" + SO + ", software=" + software + ", clave=" + clave + "]";
    }
}
