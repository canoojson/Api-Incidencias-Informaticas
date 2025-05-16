package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="incidencia_software")
public class IncidenciaSoftware{
	
	@Id
	private Integer IDS;
	
	@OneToOne
    @MapsId 
    @JoinColumn(name = "idIncidencia") 
    private Incidencia incidencia;
	
    @Column(name = "S.O.")
    private String SO;
    private String software;
    private String clave;
    
    
	public IncidenciaSoftware(Integer iDS, Incidencia incidencia, String sO, String software, String clave) {
		super();
		IDS = iDS;
		this.incidencia = incidencia;
		SO = sO;
		this.software = software;
		this.clave = clave;
	}
	public IncidenciaSoftware() {
		super();
	}
	public Integer getIDS() {
		return IDS;
	}
	public void setIDS(Integer iDS) {
		IDS = iDS;
	}
	public Incidencia getIncidencia() {
		return incidencia;
	}
	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
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
	@Override
	public int hashCode() {
		return Objects.hash(IDS, SO, clave, incidencia, software);
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
		return Objects.equals(IDS, other.IDS) && Objects.equals(SO, other.SO) && Objects.equals(clave, other.clave)
				&& Objects.equals(incidencia, other.incidencia) && Objects.equals(software, other.software);
	}
	@Override
	public String toString() {
		return "IncidenciaSoftware [IDS=" + IDS + ", incidencia=" + incidencia + ", SO=" + SO + ", software=" + software
				+ ", clave=" + clave + "]";
	}
	
    
    
}
