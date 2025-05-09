package com.example.demo.model;

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
    private Integer IdEstado;
    private String Descrip;

    

    public Estado() {
        super();
    }

    public Estado(Integer idEstado, String descrip) {
        IdEstado = idEstado;
        Descrip = descrip;
    }

    public Integer getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(Integer idEstado) {
        IdEstado = idEstado;
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
        result = prime * result + ((IdEstado == null) ? 0 : IdEstado.hashCode());
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
        if (IdEstado == null) {
            if (other.IdEstado != null)
                return false;
        } else if (!IdEstado.equals(other.IdEstado))
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
        return "Estado [IdEstado=" + IdEstado + ", Descrip=" + Descrip + "]";
    }
    
}
