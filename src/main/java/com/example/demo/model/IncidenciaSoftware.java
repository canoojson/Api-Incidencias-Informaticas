package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Incidencia_Software")
public class IncidenciaSoftware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdIncidencia;
    @Column(name = "S.O.")
    private String SO;
    private String software;
    private String clave;

    @OneToOne
    @MapsId
    @JoinColumn(name = "IdIncidencia")
    private Incidencia incidencia;

    public IncidenciaSoftware() {
        super();
    }

    public IncidenciaSoftware(Integer idIncidencia, String sO, String software, String clave, Incidencia incidencia) {
        IdIncidencia = idIncidencia;
        SO = sO;
        this.software = software;
        this.clave = clave;
        this.incidencia = incidencia;
    }

    public Integer getIdIncidencia() {
        return IdIncidencia;
    }

    public void setIdIncidencia(Integer idIncidencia) {
        IdIncidencia = idIncidencia;
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
        result = prime * result + ((SO == null) ? 0 : SO.hashCode());
        result = prime * result + ((software == null) ? 0 : software.hashCode());
        result = prime * result + ((clave == null) ? 0 : clave.hashCode());
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
        IncidenciaSoftware other = (IncidenciaSoftware) obj;
        if (IdIncidencia == null) {
            if (other.IdIncidencia != null)
                return false;
        } else if (!IdIncidencia.equals(other.IdIncidencia))
            return false;
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
        if (incidencia == null) {
            if (other.incidencia != null)
                return false;
        } else if (!incidencia.equals(other.incidencia))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IncidenciaSoftware [IdIncidencia=" + IdIncidencia + ", SO=" + SO + ", software=" + software + ", clave="
                + clave + ", incidencia=" + incidencia + "]";
    }
}
