package com.example.demo.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="incidencias_hardware")
public class IncidenciaHardware {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IDH;
	
    private String modelo;
    
    private String num_serie;

    @OneToOne
    @JoinColumn(name="IdIncidencia", unique = true)
    @JsonIgnore
    private Incidencia incidencia;
    
    @ManyToOne
    @JoinColumn(name = "tipo_hw") 
    private TiposHw tipoHw;
    
	public IncidenciaHardware() {
		super();
	}

	public IncidenciaHardware(Integer iDH, String modelo, String num_serie, Incidencia incidencia, TiposHw tipoHw) {
		super();
		IDH = iDH;
		this.modelo = modelo;
		this.num_serie = num_serie;
		this.incidencia = incidencia;
		this.tipoHw = tipoHw;
	}

	public Integer getIDH() {
		return IDH;
	}

	public void setIDH(Integer iDH) {
		IDH = iDH;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public Incidencia getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(Incidencia incidencia) {
		this.incidencia = incidencia;
	}

	public TiposHw getTipoHw() {
		return tipoHw;
	}

	public void setTipoHw(TiposHw tipoHw) {
		this.tipoHw = tipoHw;
	}

	@Override
	public int hashCode() {
		return Objects.hash(IDH, incidencia, modelo, num_serie, tipoHw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncidenciaHardware other = (IncidenciaHardware) obj;
		return Objects.equals(IDH, other.IDH) && Objects.equals(incidencia, other.incidencia)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(num_serie, other.num_serie)
				&& Objects.equals(tipoHw, other.tipoHw);
	}

	@Override
	public String toString() {
		return "IncidenciaHardware [IDH=" + IDH + ", modelo=" + modelo + ", num_serie=" + num_serie + ", incidencia="
				+ incidencia + ", tipoHw=" + tipoHw + "]";
	}
}
