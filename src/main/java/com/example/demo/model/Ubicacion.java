package com.example.demo.model;

import javax.persistence.*;



@Entity
@Table(name="Ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Integer IdUbicacion;
    private String Nombre;
	private String Descrip;

	

	
	public Ubicacion() {
		super();
	}

	public Ubicacion(Integer IdUbicacion, String nombre, String descrip) {
		this.IdUbicacion = IdUbicacion;
		Nombre = nombre;
		Descrip = descrip;
	}
	public Integer getIdUbicacion() {
		return IdUbicacion;
	}
	public void setIdUbicacion(Integer IdUbicacion) {
		IdUbicacion = IdUbicacion;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
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
		result = prime * result + ((IdUbicacion == null) ? 0 : IdUbicacion.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		Ubicacion other = (Ubicacion) obj;
		if (IdUbicacion == null) {
			if (other.IdUbicacion != null)
				return false;
		} else if (!IdUbicacion.equals(other.IdUbicacion))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Descrip == null) {
			if (other.Descrip != null)
				return false;
		} else if (!Descrip.equals(other.Descrip))
			return false;
		return true;
	}
    
    
   
    
}
