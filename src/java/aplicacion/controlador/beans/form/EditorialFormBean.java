/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.EditorialBean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import aplicacion.modelo.dominio.Editorial;
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
public class EditorialFormBean implements Serializable {

    @ManagedProperty(value = "#{editorialBean}")
    private EditorialBean editorialBean;
    private List<Editorial> editoriales;
    private Editorial editorial;
    private Editorial editorialSeleccionada;
    private boolean dialogo;

    /**
     * Creates a new instance of EditorialFormBean
     */
    public EditorialFormBean() {
        editorial = new Editorial();
        editorialSeleccionada = new Editorial();
    }

    public EditorialBean getEditorialBean() {
        return editorialBean;
    }

    public void setEditorialBean(EditorialBean editorialBean) {
        this.editorialBean = editorialBean;
    }

    public List<Editorial> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(List<Editorial> editoriales) {
        this.editoriales = editoriales;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Editorial getEditorialSeleccionada() {
        return editorialSeleccionada;
    }

    public void setEditorialSeleccionada(Editorial editorialSeleccionada) {
        this.editorialSeleccionada = editorialSeleccionada;
    }

    public boolean isDialogo() {
        return dialogo;
    }

    public void setDialogo(boolean dialogo) {
        this.dialogo = dialogo;
    }

    public void listarEditoriales() {
        this.editoriales = editorialBean.obtenerEditoriales();
    }

    @PostConstruct
    public void init() {
        listarEditoriales();
    }

    public void agregarEditorial() {

        editorialBean.agregarEditorial(editorial);
        init();
        ocultarDialogo();
    }

    public void seleccionarEditorial(Editorial edi) {
        this.editorialSeleccionada = edi;
        mostrarDialogo();
    }

    public void modificarEditorial() {
        editorialBean.modificarEditorial(editorialSeleccionada);
        ocultarDialogo();
    }

    public void mostrarDialogo() {
        this.dialogo = true;
    }

    public void ocultarDialogo() {
        this.dialogo = false;
    }
}
