package com.example.demo.model;


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

    @Column(columnDefinition = "text")
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codDpto")
    private Departamento departamento;

    private String email;

    private String pwd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idRol")
    private Rol rol;

    private String username;

    

   
    public Profesor(Integer idProfesor, String dni, String nombre, String apellidos, String descripcion,
            Departamento departamento, String email, String pwd, Rol rol, String username) {
    	idProfesor = idProfesor;
        this.dni = dni;
        Nombre = nombre;
        Apellidos = apellidos;
        this.descripcion = descripcion;
        this.departamento = departamento;
        this.email = email;
        this.pwd = pwd;
        this.rol = rol;
        this.username = username;
    }

    public Profesor() {
        super();
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
    	idProfesor = idProfesor;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idProfesor == null) ? 0 : idProfesor.hashCode());
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
        result = prime * result + ((Apellidos == null) ? 0 : Apellidos.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
        result = prime * result + ((rol == null) ? 0 : rol.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        Profesor other = (Profesor) obj;
        if (idProfesor == null) {
            if (other.idProfesor != null)
                return false;
        } else if (!idProfesor.equals(other.idProfesor))
            return false;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (Nombre == null) {
            if (other.Nombre != null)
                return false;
        } else if (!Nombre.equals(other.Nombre))
            return false;
        if (Apellidos == null) {
            if (other.Apellidos != null)
                return false;
        } else if (!Apellidos.equals(other.Apellidos))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (departamento == null) {
            if (other.departamento != null)
                return false;
        } else if (!departamento.equals(other.departamento))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (pwd == null) {
            if (other.pwd != null)
                return false;
        } else if (!pwd.equals(other.pwd))
            return false;
        if (rol == null) {
            if (other.rol != null)
                return false;
        } else if (!rol.equals(other.rol))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Profesor [IdProfesor=" + idProfesor + ", dni=" + dni + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos
                + ", descripcion=" + descripcion + ", departamento=" + departamento + ", email=" + email + ", pwd="
                + pwd + ", rol=" + rol + ", username=" + username + "]";
    }
}
