
public class ValidarCampos {
    public boolean validarFormulario(RegistroUsuario registroUsuario) {
        
        if (!Comprobar.compruebaNombre(registroUsuario.getNombre())) {
            return false;
        }

        if (!Comprobar.compruebaEmail(registroUsuario.getEmail())) {
            return false;
        }

        if (!Comprobar.compruebaPassword(registroUsuario.getPassword())) {
            return false;
        }

        if (!Comprobar.compruebaCodigoSeguridad(registroUsuario.getCodigo())) {
            return false;
        }
        
        

        return true;
    }
}
