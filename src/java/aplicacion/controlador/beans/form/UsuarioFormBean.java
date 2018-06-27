/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.UsuarioBean;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Gabriel.Y
 */
@ManagedBean
@ViewScoped
public class UsuarioFormBean implements Serializable {

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private List<Usuario> usuarios;
    private List<Usuario> usuariosAdministradores;
    private Usuario usuarioSeleccionado;
    private boolean dialogo = false;

    /**
     * Creates a new instance of UsuarioFormBean
     */
    public UsuarioFormBean() {
        usuarioSeleccionado = new Usuario();
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public List<Usuario> getUsuariosAdministradores() {
        return usuariosAdministradores;
    }

    public void setUsuariosAdministradores(List<Usuario> usuariosAdministradores) {
        this.usuariosAdministradores = usuariosAdministradores;
    }

    public boolean isDialogo() {
        return dialogo;
    }

    public void setDialogo(boolean dialogo) {
        this.dialogo = dialogo;
    }

    public void listarUsuarios() {
        this.usuarios = usuarioBean.obtenerUsuarios();
    }

    public void listarAdministradores() {
        this.usuariosAdministradores = usuarioBean.obtenerAdministradores();
    }

    @PostConstruct
    public void init() {
        listarUsuarios();
        listarAdministradores();
    }

    public void seleccionarUsuario(Usuario us) {
        this.usuarioSeleccionado = us;
        mostrarDialogo();
    }

    public void modificarUsuario() {

        usuarioBean.modificarUsuario(usuarioSeleccionado);
        ocultarDialogo();
    }

    public void mostrarDialogo() {
        this.dialogo = true;
    }

    public void ocultarDialogo() {
        this.dialogo = false;
    }
}
