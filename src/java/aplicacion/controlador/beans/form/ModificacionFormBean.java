/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PerfilBeans;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import aplicacion.modelo.dominio.Perfil;
/**
 *
 * @author Gabriel
 */
@ManagedBean
@ViewScoped
public class ModificacionFormBean implements Serializable{
@ManagedProperty(value = "#{perfilBeans}")
    private PerfilBeans perfilbeans;
    private boolean dialogo=false;


    /**
     * Creates a new instance of ModificacionFormBean
     */
    public ModificacionFormBean() {
    
    }

    public PerfilBeans getPerfilbeans() {
        return perfilbeans;
    }

    public void setPerfilbeans(PerfilBeans perfilbeans) {
        this.perfilbeans = perfilbeans;
    }

    public boolean isDialogo() {
        return dialogo;
    }

    public void setDialogo(boolean dialogo) {
        this.dialogo = dialogo;
    }
    

public void modificarPerfil(){
 Perfil perfil=(Perfil) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil");
perfilbeans.modificarPerfil(perfil);
ocultarDialogo();
 }
public void mostrarDialogo(){
this.dialogo=true;
}
public void ocultarDialogo(){
    this.dialogo=false;
}

}
