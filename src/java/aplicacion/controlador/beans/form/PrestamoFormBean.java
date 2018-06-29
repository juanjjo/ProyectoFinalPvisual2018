/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PrestamoBean;
import aplicacion.modelo.dominio.DetallePrestamo;
import aplicacion.modelo.dominio.DetalleReserva;
import aplicacion.modelo.dominio.Prestamo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Gabriel.Y
 */
@ManagedBean
@ViewScoped
public class PrestamoFormBean {
     @ManagedProperty(value = "#{prestamoBean}")
    private PrestamoBean prestamoBean;
     private Prestamo prestamo;
     private DetallePrestamo dPrestamo;
     private List<DetallePrestamo>prestamos;
     private DetalleReserva reservaSeleccionada;
    /**
     * Creates a new instance of PrestamoFormBean
     */
    public PrestamoFormBean() {
    }

    public PrestamoBean getPrestamoBean() {
        return prestamoBean;
    }

    public void setPrestamoBean(PrestamoBean prestamoBean) {
        this.prestamoBean = prestamoBean;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public DetallePrestamo getdPrestamo() {
        return dPrestamo;
    }

    public void setdPrestamo(DetallePrestamo dPrestamo) {
        this.dPrestamo = dPrestamo;
    }

    public List<DetallePrestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<DetallePrestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public DetalleReserva getReservaSeleccionada() {
        return reservaSeleccionada;
    }

    public void setReservaSeleccionada(DetalleReserva reservaSeleccionada) {
        this.reservaSeleccionada = reservaSeleccionada;
    }
    public void seleccionarReserva (){
        
    }
}
