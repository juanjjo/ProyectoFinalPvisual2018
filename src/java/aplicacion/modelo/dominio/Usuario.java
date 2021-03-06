package aplicacion.modelo.dominio;
// Generated 10/06/2018 19:00:23 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

    private Integer codigo;
    private String nombreUsuario;
    private String password;
    private String tipoUsuario;
    private boolean estado;

    public Usuario() {

    }

    public Usuario(String tipoUsuario, boolean estado) {
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public Usuario(Integer codigo, String nombreUsuario, String password, String tipoUsuario, boolean estado) {
        this.codigo = codigo;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
