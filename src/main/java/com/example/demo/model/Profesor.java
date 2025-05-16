package com.example.demo.model;


import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name="profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesor;

    private String dni;

    private String Nombre;

    private String Apellidos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codDpto")
    private Departamento departamento;

    private String email;

    private String pwd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idRol")
    private Rol rol;

    private String username;

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Apellidos, Nombre, departamento, dni, email, idProfesor, pwd, rol, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(Apellidos, other.Apellidos) && Objects.equals(Nombre, other.Nombre)
				&& Objects.equals(departamento, other.departamento) && Objects.equals(dni, other.dni)
				&& Objects.equals(email, other.email) && Objects.equals(idProfesor, other.idProfesor)
				&& Objects.equals(pwd, other.pwd) && Objects.equals(rol, other.rol)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Profesor [idProfesor=" + idProfesor + ", dni=" + dni + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos
				+ ", departamento=" + departamento + ", email=" + email + ", pwd=" + pwd + ", rol=" + rol
				+ ", username=" + username + "]";
	}
}
