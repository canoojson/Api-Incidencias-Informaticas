package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Permisos")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPermiso;
    private String descrip;

    
    private List<Rol> roles;

    public Permiso() {
        super();
    }

    public Permiso(Integer codPermiso, String descrip, List<Rol> roles) {
        this.codPermiso = codPermiso;
        this.descrip = descrip;
        this.roles = roles;
    }

    public Integer getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(Integer codPermiso) {
        this.codPermiso = codPermiso;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codPermiso == null) ? 0 : codPermiso.hashCode());
        result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
        Permiso other = (Permiso) obj;
        if (codPermiso == null) {
            if (other.codPermiso != null)
                return false;
        } else if (!codPermiso.equals(other.codPermiso))
            return false;
        if (descrip == null) {
            if (other.descrip != null)
                return false;
        } else if (!descrip.equals(other.descrip))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Permiso [codPermiso=" + codPermiso + ", descrip=" + descrip + ", roles=" + roles + "]";
    }
    
    
}
