public class Comprobar{
    
    public static boolean compruebaPassword(String password) {
        boolean valido = false;

        // Comprobar que la contraseña cumple las restricciones
        if (password.matches("^[A-Z][a-zA-Z0-9_#@-]{6}[0-9]{2}$")) {
        valido = true;
        } else {
        System.out.println("La contraseña no cumple las restricciones");
        }

        return valido;
        }
// Método para comprobar la contraseña
}