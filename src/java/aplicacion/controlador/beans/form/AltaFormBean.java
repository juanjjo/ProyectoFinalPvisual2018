/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PerfilBeans;
import aplicacion.controlador.beans.UsuarioBean;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import aplicacion.modelo.dominio.Perfil;
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
public class AltaFormBean implements Serializable{
    @ManagedProperty(value = "#{perfilBeans}")
    private PerfilBeans perfilbeans;
    private UsuarioBean usuariobeans;
    private Usuario usuariof;
    private Perfil perfil;
    /**
     * Creates a new instance of AltaFormBean
     */
    public AltaFormBean() {
         perfil=new Perfil();
         usuariof=new Usuario("final", true);
    }

    public PerfilBeans getPerfilbeans() {
        return perfilbeans;
    }

    public void setPerfilbeans(PerfilBeans perfilbeans) {
        this.perfilbeans = perfilbeans;
    }

    public Usuario getUsuariof() {
        return usuariof;
    }

    public void setUsuariof(Usuario usuariof) {
        this.usuariof = usuariof;
    }

  
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public UsuarioBean getUsuariobeans() {
        return usuariobeans;
    }

    public void setUsuariobeans(UsuarioBean usuariobeans) {
        this.usuariobeans = usuariobeans;
    }
    public void agregarPerfilF (){
     
        if(usuariof!=null){
        perfil.setUsuario(usuariof);
        perfilbeans.agregarPerfil(perfil);
        usuariof=new Usuario("final", true);
    }else{ FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO ,"Faltan datos de usuario" ,"Faltan datos de usuario");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
             }
}
}