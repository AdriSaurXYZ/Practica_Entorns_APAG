package registro;

public class ValidarCampos {
    public boolean validarFormulario(RegistroUsuario registroUsuario) {
        
       // Checking if the name is valid.
        if (!Comprobar.compruebaNombre(Comprobar.nombresUsuarios, registroUsuario.getNombre())) {
            return false;
        }
        

      // Checking if the email is valid.
        if (!Comprobar.compruebaEmail(registroUsuario.getEmail())) {
            return false;
        }

        // Checking if the password is valid.
        if (!Comprobar.compruebaPassword(registroUsuario.getPassword())) {
            return false;
        }

      // Checking if the security code is valid.
        if (!Comprobar.compruebaCodigoSeguridad(registroUsuario.getCodigo())) {
            return false;
        }
        
        

        return true;
    }
}
