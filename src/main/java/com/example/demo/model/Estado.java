package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado")
    private Integer idEstado;
    private String Descrip;

    

    public Estado() {
        super();
    }

    public Estado(Integer idEstado, String descrip) {
        this.idEstado = idEstado;
        Descrip = descrip;
    }

    public Integer getidEstado() {
        return idEstado;
    }

    public void setidEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String descrip) {
        Descrip = descrip;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
        result = prime * result + ((Descrip == null) ? 0 : Descrip.hashCode());
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
        Estado other = (Estado) obj;
        if (idEstado == null) {
            if (other.idEstado != null)
                return false;
        } else if (!idEstado.equals(other.idEstado))
            return false;
        if (Descrip == null) {
            if (other.Descrip != null)
                return false;
        } else if (!Descrip.equals(other.Descrip))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estado [idEstado=" + idEstado + ", Descrip=" + Descrip + "]";
    }
    
}
