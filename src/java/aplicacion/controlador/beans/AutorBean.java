/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.imp.ram.AutorDAOImp;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aplicacion.modelo.dominio.Autor;
/**
 *
 * @author Gabriel.Y
 */
@ManagedBean
@ViewScoped
public class AutorBean implements Serializable{
    private Autor autor;

    /**
     * Creates a new instance of AutorBean
     */
    public AutorBean() {
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
public List<Autor> obtenerAutores(){
    AutorDAOImp autorDao=new AutorDAOImp();
return autorDao.obtenerAutores();
}
public void agregarDeAutor(Autor aut){
    AutorDAOImp autorDao=new AutorDAOImp();
    autorDao.agregarAutor(aut);
}
public void modificarAutor(Autor aut){
    AutorDAOImp autorDao=new AutorDAOImp();
    autorDao.modificarAutor(aut);
}
}