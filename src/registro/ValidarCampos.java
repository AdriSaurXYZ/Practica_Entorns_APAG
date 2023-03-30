/**

Clase que permite validar el formulario de registro de usuario
*/
package registro;
public class ValidarCampos {


/**
 * Método que valida el formulario de registro de usuario
 * @param registroUsuario objeto de tipo RegistroUsuario con los datos del usuario
 * @return true si el formulario es válido, false en caso contrario
 */
public boolean validarFormulario(RegistroUsuario registroUsuario) {
    
   // Verifica si el nombre es válido.
    if (!Comprobar.compruebaNombre(Comprobar.nombresUsuarios, registroUsuario.getNombre())) {
        return false;
    }
    

  // Verifica si el email es válido.
    if (!Comprobar.compruebaEmail(registroUsuario.getEmail())) {
        return false;
    }

    // Verifica si la contraseña es válida.
    if (!Comprobar.compruebaPassword(registroUsuario.getPassword())) {
        return false;
    }

  // Verifica si el código de seguridad es válido.
    if (!Comprobar.compruebaCodigoSeguridad(registroUsuario.getCodigo())) {
        return false;
    }
    
    

    return true;
}
}
