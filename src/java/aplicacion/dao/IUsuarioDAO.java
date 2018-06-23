/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.List;


/**
 *
 * @author Gabriel
 */
public interface IUsuarioDAO {
    public Usuario login (String nombreUsuario,String password);  
    public void add(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public List<Usuario> listarAdministradores();
    public void modificarUsuario(Usuario u);
  
}
