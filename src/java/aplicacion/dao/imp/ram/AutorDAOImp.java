/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp.ram;

import aplicacion.dao.IAutorDAO;
import aplicacion.datos.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Autor;
import aplicacion.modelo.dominio.Publicacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Gabriel.Y
 */
public class AutorDAOImp implements IAutorDAO, Serializable {

    @Override
    public List<Autor> obtenerAutores() {
        List<Autor> listaAutores = new ArrayList<>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //trae de la base datos todos los usuari final nada mas
        Criteria criteria = session.createCriteria(Autor.class);
        listaAutores = criteria.addOrder(Order.asc("codigo")).list();

        session.flush();//actuliseme ese opjeto de la base de dato
        session.close();
        return listaAutores;
    }

    @Override
    public void agregarAutor(Autor a) {
        if (a != null) {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(a);
            session.getTransaction().commit();
            session.close();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor Agregado con exito", "Autor Agregado con exito");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    @Override
    public void modificarAutor(Autor a) {
        if (a != null) {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(a);
            session.getTransaction().commit();
            session.close();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor Modificado con exito", "Autor Modificado con exito");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

}
