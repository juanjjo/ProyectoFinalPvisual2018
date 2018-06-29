/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.ReservaBean;
import aplicacion.modelo.dominio.DetalleReserva;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.PubAut;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import aplicacion.modelo.dominio.Reserva;
import java.util.Date;
import javax.faces.context.FacesContext;
import aplicacion.modelo.dominio.Publicacion;
import java.io.Serializable;



import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Gabriel.Y
 */
@ManagedBean
@ViewScoped
public class ReservaFormBean implements Serializable {

    @ManagedProperty(value = "#{reservaBean}")
    private ReservaBean reservaBean;
    private Reserva reserva;
    private DetalleReserva detalleReserva;
    private boolean dialogo;
    private Publicacion publicacionSeleccionada;

    private List<DetalleReserva> reservas;
    private DetalleReserva reservaSeleccionada;
    /**
     * Creates a new instance of ReservaFormBean
     */
    public ReservaFormBean() {
        publicacionSeleccionada = new Publicacion();
        reserva = new Reserva(new Date(), true);
        detalleReserva = new DetalleReserva();
        reservaSeleccionada=new DetalleReserva();
    }

    public ReservaBean getReservaBean() {
        return reservaBean;
    }

    public void setReservaBean(ReservaBean reservaBean) {
        this.reservaBean = reservaBean;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public DetalleReserva getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(DetalleReserva detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    public boolean isDialogo() {
        return dialogo;
    }

    public void setDialogo(boolean dialogo) {
        this.dialogo = dialogo;
    }

    public Publicacion getPublicacionSeleccionada() {
        return publicacionSeleccionada;
    }

    public void setPublicacionSeleccionada(Publicacion publicacionSeleccionada) {
        this.publicacionSeleccionada = publicacionSeleccionada;
    }

    public DetalleReserva getReservaSeleccionada() {
        return reservaSeleccionada;
    }

    public void setReservaSeleccionada(DetalleReserva reservaSeleccionada) {
        this.reservaSeleccionada = reservaSeleccionada;
    }

    public void seleccionarPublicacion(PubAut p) {
        this.publicacionSeleccionada = p.getPublicacion();
        mostrarDialogo();
    }


 
    public List<DetalleReserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<DetalleReserva> reservas) {
        this.reservas = reservas;
    }

    
    public void nuevaReserva (){
        Perfil perf=(Perfil) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil");
        reserva.setPerfil(perf);

        reservaBean.altaDeReserva(reserva);
        detalleReserva.setPublicacion(publicacionSeleccionada);
        detalleReserva.setReserva(reserva);
        detalleReserva.setEstado(true);
        reservaBean.altaDeDetalleDeReserva(detalleReserva);
        ocultarDialogo();
        publicacionSeleccionada = new Publicacion();
        reserva = new Reserva(new Date(), true);
        detalleReserva = new DetalleReserva();

    }

    public void mostrarDialogo() {
        this.dialogo = true;
    }

    public void ocultarDialogo() {
        this.dialogo = false;
    }
     public void listarReservas(){
         this.reservas=reservaBean.listarReservas();
     }
     @PostConstruct
     public void init(){
         listarReservas();
     }
     public void seleccionarReserva(DetalleReserva r){
         this.reservaSeleccionada=r;
         mostrarDialogo();
     }
}
