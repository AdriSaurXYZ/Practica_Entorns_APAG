/**
 * It validates the user's input and throws an exception if the input is not valid
 */
package registro;
import java.util.Random;
import java.util.Scanner;

        public class Comprobar {
            static Random rnd = new Random();
            static StringBuilder sb = new StringBuilder(8);
            static Scanner scanner = new Scanner(System.in);
            
            // Base de datos de nombres de usuarios
            static final String[] nombresUsuarios = {"Carles_345", "AnaGomez-783", "Pepito_999", "Laura_222",
                    "Juanito-111", "Marta_444", "Pedro_777", "Sofia-666", "David_555", "Lucia888"};
        
            // Método para comprobar el nombre de usuario
            public static boolean compruebaNombre(String[] usuarios, String nombreUsuario) {
                boolean valido = false;
        
                // Comprobar que el nombre cumple las restricciones
                if (nombreUsuario.matches("^[A-Z][a-z]+[-_][0-9]{3}$") && nombreUsuario.length() <= 16) {
                    // Comprobar que el nombre no está en la base de datos
                    for (String n : usuarios) {
                        if (n.equalsIgnoreCase(nombreUsuario)) {
                            System.out.println("El nombre de usuario ya existe");
                            return false;
                        }
                    }
                    valido = true;
                } else {
                    System.out.println("El nombre de usuario no cumple las restricciones");
                }
        
                return valido;
            }
    
    
        // Método para comprobar la contraseña
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

        // Método para comprobar el correo electrónico
        public static boolean compruebaEmail(String email) {
            boolean valido = false;
            
    // Comprobar que el correo electrónico contiene un @ y acaba en .com, .es o .cat
    if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|es|cat)$")) {
        // Comprobar que el dominio está permitido
        if (email.contains("@paucasesnovescifp") || email.contains("@yahoo") || email.contains("@gmail")
            || email.contains("@hotmail")) {
            valido = true;
        } else {
            System.out.println("El dominio del correo electrónico no está permitido");
        }
    } else {
        System.out.println("El correo electrónico no es válido");
    }
    
    return valido;
}

        // Método para generar un código de seguridad aleatorio
        public static String generaCodigoSeguridad() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#-";
        

        for (int i = 0; i < 8; i++) {
        sb.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
        }

        System.out.println("El código de seguridad generado es: " + sb.toString());

        return sb.toString();
        }

        // Método para comprobar el código de seguridads
        public static boolean compruebaCodigoSeguridad(String codigo) {
        boolean valido = false;

        // Comprobar que el código introducido coincide con el generado
        System.out.println("Vuelve a introducir el código de seguridad generado:");
        String codigoIntroducido = scanner.nextLine();
        if (codigoIntroducido.equals(codigo)) {
        valido = true;
        System.out.println("El codigo  es correcto");
        return valido;

        }
        else{
            System.out.println("El codigo no es correcto");
            return valido;
        }

    }

    /**
     * This function validates the user's input and throws an exception if the input is invalid.
     * 
     * @param nombreUsuario The username
     * @param password String
     * @param email String
     * @param codigoSeguridad is a string that contains a number
     */
    public void ValidarCampos(String nombreUsuario, String password, String email, String codigoSeguridad) {
        compruebaNombre(nombresUsuarios, nombreUsuario);
        compruebaPassword(password);
        compruebaEmail(email);
        boolean codigoValido = compruebaCodigoSeguridad(codigoSeguridad);
        if (!codigoValido) {
            throw new IllegalArgumentException("El código de seguridad no es válido");
        }
    }
}

