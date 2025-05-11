package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    private String descrip;

    @OneToMany(mappedBy="persona" )
    private List<Permiso> permisos;

    public Rol() {
        super();
    }

    public Rol(Integer idRol, String descrip, List<Permiso> permisos) {
        super();
        this.idRol = idRol;
        this.descrip = descrip;
        this.permisos = permisos;
    }

    public Integer getIdRol() {
        return idRol;
    }
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public List<Permiso> getPermisos() {
        return permisos;
    }
    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idRol == null) ? 0 : idRol.hashCode());
        result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
        result = prime * result + ((permisos == null) ? 0 : permisos.hashCode());
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
        Rol other = (Rol) obj;
        if (idRol == null) {
            if (other.idRol != null)
                return false;
        } else if (!idRol.equals(other.idRol))
            return false;
        if (descrip == null) {
            if (other.descrip != null)
                return false;
        } else if (!descrip.equals(other.descrip))
            return false;
        if (permisos == null) {
            if (other.permisos != null)
                return false;
        } else if (!permisos.equals(other.permisos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rol [idRol=" + idRol + ", descrip=" + descrip + ", permisos=" + permisos + "]";
    }  
}
