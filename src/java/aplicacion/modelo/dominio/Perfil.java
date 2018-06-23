package aplicacion.modelo.dominio;
// Generated 10/06/2018 19:00:23 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil  implements java.io.Serializable {


     private Integer codigo;
     private Usuario usuario;
     private String apellido;
     private String nombre;
     private String dni;
     private Date fechaNac;
     private String email;
     private String direccion;
     private String telefono;
     private Set reservases = new HashSet(0);
     private Set prestamoses = new HashSet(0);

    public Perfil() {
    }

    public Perfil(Integer codigo, Usuario usuario, String apellido, String nombre, String dni, Date fechaNac, String email, String direccion, String telefono) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public Set getReservases() {
        return this.reservases;
    }
    
    public void setReservases(Set reservases) {
        this.reservases = reservases;
    }
    public Set getPrestamoses() {
        return this.prestamoses;
    }
    
    public void setPrestamoses(Set prestamoses) {
        this.prestamoses = prestamoses;
    }




}


