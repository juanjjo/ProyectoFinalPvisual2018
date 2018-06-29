package aplicacion.modelo.dominio;
// Generated 10/06/2018 19:00:23 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Prestamos generated by hbm2java
 */
public class Prestamo  implements java.io.Serializable {


     private Integer codigo;
     private Perfil perfil;
     private Date fechaPrestamo;
     private boolean estado;
     private String administrativo;
     private Set detallesPrestamoses = new HashSet(0);

    public Prestamo() {
    }

    public Prestamo(Date fechaPrestamo, boolean estado) {
        this.fechaPrestamo = fechaPrestamo;
        this.estado = estado;
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(String administrativo) {
        this.administrativo = administrativo;
    }

	
    public Set getDetallesPrestamoses() {
        return this.detallesPrestamoses;
    }
    
    public void setDetallesPrestamoses(Set detallesPrestamoses) {
        this.detallesPrestamoses = detallesPrestamoses;
    }




}


