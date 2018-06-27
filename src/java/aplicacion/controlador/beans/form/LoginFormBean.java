/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Gabriel
 */
@ManagedBean
@ViewScoped
public class LoginFormBean implements Serializable {

    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private String nombreUsuario;
    private String password;
    private boolean renderFinal;
    private boolean renderAdmin;
    private boolean renderSuper;
    public boolean dialogo = false;

    public LoginFormBean() {

    }
    
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
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

    public boolean isRenderFinal() {
        return renderFinal;
    }

    public void setRenderFinal(boolean renderFinal) {
        this.renderFinal = renderFinal;
    }

    public boolean isRenderAdmin() {
        return renderAdmin;
    }

    public void setRenderAdmin(boolean renderAdmin) {
        this.renderAdmin = renderAdmin;
    }

    public boolean isRenderSuper() {
        return renderSuper;
    }

    public void setRenderSuper(boolean renderSuper) {
        this.renderSuper = renderSuper;
    }

    public boolean isDialogo() {
        return dialogo;
    }

    public void setDialogo(boolean dialogo) {
        this.dialogo = dialogo;
    }

    public void valiadrUsuario() throws IOException {
        Usuario usuario = usuarioBean.validarUsuario(nombreUsuario, password);
        if (usuario != null) {

            validarPerfil();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario valido", "Usuario valido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().redirect("Home.xhtml");

        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario invalido", "Usuario invalido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void validarPerfil() {
        usuarioBean.validarPerfil();
    }

    public Perfil getPerfil() {
        return (Perfil) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil");
    }

    public void cerrarSesion() throws IOException {
        usuarioBean.cerrarSesion();
    }

    public void renderizar() throws IOException {
        validarSesion();
        getRenderizarFinal();
        getRenderizarAdministrador();
        getRenderizarSupervisor();

    }

    public void getRenderizarFinal() {
        this.renderFinal = usuarioBean.renderizarF();
    }

    public void getRenderizarAdministrador() {
        this.renderAdmin = usuarioBean.renderizarA();
    }

    public void getRenderizarSupervisor() {
        this.renderSuper = usuarioBean.renderizarS();
    }

    public void validarSesion() throws IOException {
        Usuario usu = usuarioBean.validarSesion();
        if (usu == null) {

            FacesContext.getCurrentInstance().getExternalContext().redirect("Pagina sin usuario.xhtml");
        }
    }

    public void mostrarDialogo() {
        this.dialogo = true;

    }

    public void ocultarDialogo() {
        this.dialogo = false;
    }

    @PostConstruct
    public void init() {
        Usuario usu = usuarioBean.validarSesion();
        if (usu != null) {
            mostrarDialogo();
        } else {
            ocultarDialogo();
        }
    }
}
