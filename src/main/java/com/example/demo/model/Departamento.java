package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdDpto;
    private String nombreDpto;

    
	public Departamento() {
		super();
	}

	public Departamento(Integer codDpto, String nombreDpto) {
		super();
		this.IdDpto = codDpto;
		this.nombreDpto = nombreDpto;
	}

	public Integer getCodDpto() {
		return IdDpto;
	}
	public void setCodDpto(Integer codDpto) {
		this.IdDpto = codDpto;
	}
	public String getNombreDpto() {
		return nombreDpto;
	}
	public void setNombreDpto(String nombreDpto) {
		this.nombreDpto = nombreDpto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdDpto == null) ? 0 : IdDpto.hashCode());
		result = prime * result + ((nombreDpto == null) ? 0 : nombreDpto.hashCode());
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
		Departamento other = (Departamento) obj;
		if (IdDpto == null) {
			if (other.IdDpto != null)
				return false;
		} else if (!IdDpto.equals(other.IdDpto))
			return false;
		if (nombreDpto == null) {
			if (other.nombreDpto != null)
				return false;
		} else if (!nombreDpto.equals(other.nombreDpto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [codDpto=" + IdDpto + ", nombreDpto=" + nombreDpto + "]";
	}
	

}
