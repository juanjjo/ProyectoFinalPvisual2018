/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Autor;
import java.util.List;

/**
 *
 * @author Gabriel.Y
 */
public interface IAutorDAO {
    public List<Autor> obtenerAutores();
    public void agregarAutor(Autor a);
    public void modificarAutor(Autor a);
   
}
