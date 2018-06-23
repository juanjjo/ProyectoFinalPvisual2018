/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp.ram;

import aplicacion.dao.IEditorialDAO;
import aplicacion.datos.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.Editorial;
import aplicacion.modelo.dominio.Publicacion;
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
public class EditorialDAOImp implements IEditorialDAO{

    @Override
    public List<Editorial> editoriales() {
 List<Editorial> listaEditoriales = new ArrayList<>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //trae de la base datos todos los usuari final nada mas
        Criteria criteria = session.createCriteria(Editorial.class);
        listaEditoriales = criteria.addOrder(Order.asc("codigo")).list();

        session.flush();//actuliseme ese opjeto de la base de dato
        session.close();
    return listaEditoriales;
    }

    @Override
    public void agregarEditorial(Editorial e) {
Session session = NewHibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(e);
    session.getTransaction().commit();
    session.close();
  FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO ,"Editorial Agregada con exito" ,"Editorial Agregada con exito");
  FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }

    @Override
    public void modificarEditorial(Editorial e) {
      Session session = NewHibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(e);
    session.getTransaction().commit();
    session.close();
  FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO ,"Editorial modificada con exito" ,"Editorial modificada con exito");
  FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    
    }
    
}
