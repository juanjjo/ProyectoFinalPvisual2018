/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.dao.imp.ram.EditorialDAOImp;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aplicacion.modelo.dominio.Editorial;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gabriel.Y
 */
@ManagedBean
@ViewScoped
public class EditorialBean implements Serializable {

    private Editorial editorial;

    /**
     * Creates a new instance of EditorialBean
     */
    public EditorialBean() {
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public List<Editorial> obtenerEditoriales() {
        EditorialDAOImp editorialDao = new EditorialDAOImp();
        return editorialDao.editoriales();
    }

    public void agregarEditorial(Editorial edit) {
        EditorialDAOImp ediDao = new EditorialDAOImp();
        ediDao.agregarEditorial(edit);
    }

    public void modificarEditorial(Editorial edit) {
        EditorialDAOImp ediDao = new EditorialDAOImp();
        ediDao.modificarEditorial(edit);

    }
}
