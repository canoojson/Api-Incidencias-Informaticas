package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codDpto;
    private String nombreDpto;

    
	public Departamento() {
		super();
	}

	public Departamento(Integer codDpto, String nombreDpto) {
		super();
		this.codDpto = codDpto;
		this.nombreDpto = nombreDpto;
	}

	public Integer getCodDpto() {
		return codDpto;
	}
	public void setCodDpto(Integer codDpto) {
		this.codDpto = codDpto;
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
		result = prime * result + ((codDpto == null) ? 0 : codDpto.hashCode());
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
		if (codDpto == null) {
			if (other.codDpto != null)
				return false;
		} else if (!codDpto.equals(other.codDpto))
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
		return "Departamento [codDpto=" + codDpto + ", nombreDpto=" + nombreDpto + "]";
	}
	

}
