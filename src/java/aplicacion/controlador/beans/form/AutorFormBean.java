/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.AutorBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aplicacion.modelo.dominio.Autor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
/**
 *
 * @author Gabriel.Y
 */
@ManagedBean
@ViewScoped
public class AutorFormBean implements Serializable{
     @ManagedProperty(value = "#{autorBean}")
      private AutorBean autorBean;
      private List<Autor>autores;
      private Autor autor;
      private Autor autorSeleccionado;
      private boolean dialogo=false;
    /**
     * Creates a new instance of AutorFormBean
     */
    public AutorFormBean() {
    autor=new Autor();
    }

    public AutorBean getAutorBean() {
        return autorBean;
    }

    public void setAutorBean(AutorBean autorBean) {
        this.autorBean = autorBean;
    }
    

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Autor getAutorSeleccionado() {
        return autorSeleccionado;
    }

    public void setAutorSeleccionado(Autor autorSeleccionado) {
        this.autorSeleccionado = autorSeleccionado;
    }

    public boolean isDialogo() {
        return dialogo;
    }

    public void setDialogo(boolean dialogo) {
        this.dialogo = dialogo;
    }
    

     
    public void ListarAutores(){
    this.autores=autorBean.obtenerAutores();
    }
    
    @PostConstruct
    public void init(){
    
    ListarAutores();
    }
    public void agregarAutor(){
    
    autorBean.agregarDeAutor(autor);
    init();
    ocultarDialogo();
     autor=new Autor();
    }
    public void seleccionarAutor (Autor au){
    this.autorSeleccionado=au;
    mostrarDialogo();
    }
    public void modificarAutor(){
    autorBean.modificarAutor(autorSeleccionado);
    ocultarDialogo();
    }
    public void mostrarDialogo (){
    this.dialogo=true;
    }
    public void ocultarDialogo (){
    this.dialogo=false;
    }
}
