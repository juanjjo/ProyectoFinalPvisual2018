/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao.imp.ram;

import aplicacion.dao.IPrestamoDAO;
import aplicacion.datos.hibernate.configuracion.NewHibernateUtil;
import aplicacion.modelo.dominio.DetallePrestamo;
import aplicacion.modelo.dominio.Prestamo;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author Gabriel.Y
 */
public class PrestamoDAOImp implements IPrestamoDAO, Serializable{

    @Override
    public void altaPrestamo(Prestamo p) {
    if (p != null) {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
            session.close();
       
        } else {
         
        } 
    }

    @Override
    public void altaDetallePrestamo(DetallePrestamo dp) {
      if (dp != null) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(dp);
            session.getTransaction().commit();
            session.close();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Prestamo realizado", "Prestamo realizado");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } 
    }

    @Override
    public List<DetallePrestamo> listarPrestamos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
