package com.example.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol")
    private Integer IdRol;
    private String descrip;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_permisos",
        joinColumns = @JoinColumn(name = "IdRol"),
        inverseJoinColumns = @JoinColumn(name = "IdPermiso")
    )
    private Set<Permiso> permisos = new HashSet<>();

    public Rol() {
        super();
    }

    public Rol(Integer idRol, String descrip, Set<Permiso> permisos) {
        super();
        this.IdRol = idRol;
        this.descrip = descrip;
        this.permisos = permisos;
    }

    public Integer getIdRol() {
        return IdRol;
    }
    public void setIdRol(Integer idRol) {
        this.IdRol = idRol;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public Set<Permiso> getPermisos() {
        return permisos;
    }
    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((IdRol == null) ? 0 : IdRol.hashCode());
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
        if (IdRol == null) {
            if (other.IdRol != null)
                return false;
        } else if (!IdRol.equals(other.IdRol))
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
        return "Rol [idRol=" + IdRol + ", descrip=" + descrip + ", permisos=" + permisos + "]";
    }  
}
