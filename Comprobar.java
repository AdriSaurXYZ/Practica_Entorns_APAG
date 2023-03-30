public class Comprobar{
    

    // Método para comprobar la contraseña
    public static boolean compruebaPassword(String password) {
        boolean valido = false;

        // Comprobar que la contraseña cumple las restricciones
        if (password.matches("^[A-Z](?=.*[@#_-])[A-Za-z0-9@#_-]{5}[0-9]{2}$")) {
        valido = true;
        } else {
        System.out.println("La contraseña no cumple las restricciones");
        }

        return valido;
        }

}