/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Editorial;
import java.util.List;

/**
 *
 * @author Gabriel.Y
 */
public interface IEditorialDAO {
    public List<Editorial>editoriales();
     public void agregarEditorial(Editorial e);
    public void modificarEditorial(Editorial e);
}
