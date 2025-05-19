package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estados")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstado")
    private Integer IdEstado;
    private String Descrip;

    

    public Estado() {
        super();
    }

    public Estado(Integer idEstado, String descrip) {
        this.IdEstado = idEstado;
        Descrip = descrip;
    }

    public Integer getidEstado() {
        return IdEstado;
    }

    public void setidEstado(Integer idEstado) {
        this.IdEstado = idEstado;
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
        return "Estado [idEstado=" + IdEstado + ", Descrip=" + Descrip + "]";
    }
    
}
