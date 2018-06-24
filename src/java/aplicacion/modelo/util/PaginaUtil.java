/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gabriel
 */
public class PaginaUtil implements Serializable{
    
  
  /**
   * Guarda el usuario como nulo (deslogueado) y redirecciona a la pagina de inicio
   **/
    public void cerrarSesion() throws IOException{
        Perfil perfil = null;
    Usuario usu=null;
    
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("perfil", perfil);
     FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usu", usu);
     FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    
       
        
    
}
    public boolean renderizarPaginaFinal(){
 boolean bool=false;
        Usuario usu =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usu");
    if (usu!= null && usu.getTipoUsuario().equals("final") ){
        bool=true;
    }
    return bool;
    }
     public boolean renderizarPaginaAdmin(){
 boolean bool=false;
        Usuario usu =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usu");
    if (usu.getTipoUsuario().equals("administrador")||usu.getTipoUsuario().equals("supervisor") ){
        bool=true;
    }
    return bool;
    }
     public boolean renderizarPaginaSuper(){
 boolean bool=false;
        Usuario usu =(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usu");
    if (usu!= null && usu.getTipoUsuario().equals("supervisor") ){
        bool=true;
    }
    return bool;
    }
}
        

