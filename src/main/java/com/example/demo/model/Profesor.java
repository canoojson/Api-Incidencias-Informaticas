package com.example.demo.model;


import java.util.List;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name="profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdProfesor;

    private String dni;

    private String Nombre;

    private String Apellidos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDpto")
    private Departamento departamento;

    private String email;

    private String pwd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idRol")
    private Rol rol;

    private String username;

	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios;

	public Profesor() {
		super();
	}

	public Profesor(Integer idProfesor, String dni, String nombre, String apellidos, Departamento departamento,
			String email, String pwd, Rol rol, String username, List<Comentario> comentarios) {
		super();
		IdProfesor = idProfesor;
		this.dni = dni;
		Nombre = nombre;
		Apellidos = apellidos;
		this.departamento = departamento;
		this.email = email;
		this.pwd = pwd;
		this.rol = rol;
		this.username = username;
		this.comentarios = comentarios;
	}

	
	public Integer getIdProfesor() {
		return IdProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		IdProfesor = idProfesor;
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Apellidos, IdProfesor, Nombre, comentarios, departamento, dni, email, pwd, rol, username);
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
		return Objects.equals(Apellidos, other.Apellidos) && Objects.equals(IdProfesor, other.IdProfesor)
				&& Objects.equals(Nombre, other.Nombre) && Objects.equals(comentarios, other.comentarios)
				&& Objects.equals(departamento, other.departamento) && Objects.equals(dni, other.dni)
				&& Objects.equals(email, other.email) && Objects.equals(pwd, other.pwd)
				&& Objects.equals(rol, other.rol) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Profesor [IdProfesor=" + IdProfesor + ", dni=" + dni + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos
				+ ", departamento=" + departamento + ", email=" + email + ", pwd=" + pwd + ", rol=" + rol
				+ ", username=" + username + ", comentarios=" + comentarios + "]";
	}
	
	
}
