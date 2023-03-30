/**

The Comprobar class validates the user's input for a registration form, including username, password, email, and security code.
*/
package registro;
import java.util.Random;
import java.util.Scanner;
public class Comprobar {
static Random rnd = new Random();
static StringBuilder sb = new StringBuilder(8);
static Scanner scanner = new Scanner(System.in);


// Database of user names
static final String[] nombresUsuarios = {"Carles_345", "AnaGomez-783", "Pepito_999", "Laura_222",
        "Juanito-111", "Marta_444", "Pedro_777", "Sofia-666", "David_555", "Lucia888"};

/**
 * This function validates the username input and checks whether it meets the required conditions.
 * 
 * @param usuarios The list of usernames to check against
 * @param nombreUsuario The username string to validate
 * @return A boolean value indicating whether the username is valid or not
 */
public static boolean compruebaNombre(String[] usuarios, String nombreUsuario) {
    boolean valido = false;
    
    // Check if the username meets the required conditions
    if (nombreUsuario.matches("^[A-Z][a-z]+[-_][0-9]{3}$") && nombreUsuario.length() <= 16) {
        // Check if the username is already in the database
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

/**
 * This function validates the password input and checks whether it meets the required conditions.
 * 
 * @param password The password string to validate
 * @return A boolean value indicating whether the password is valid or not
 */
public static boolean compruebaPassword(String password) {
    boolean valido = false;

    // Check if the password meets the required conditions
    if (password.matches("^[A-Z][a-zA-Z0-9_#@-]{6}[0-9]{2}$")) {
        valido = true;
    } else {
        System.out.println("La contraseña no cumple las restricciones");
    }

    return valido;
}

/**
 * This function validates the email input and checks whether it meets the required conditions.
 * 
 * @param email The email string to validate
 * @return A boolean value indicating whether the email is valid or not
 */
public static boolean compruebaEmail(String email) {
    boolean valido = false;
    
    // Check if the email contains an @ symbol and ends with .com, .es or .cat
    if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|es|cat)$")) {
        // Check if the domain is allowed
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

        /**
    
    Comprueba si un código de seguridad introducido por el usuario es válido.
    
    @param codigo una cadena de texto con el código de seguridad a comprobar.
    
    @return un valor booleano que indica si el código de seguridad introducido es válido o no.
    */

        // Método para generar un código de seguridad aleatorio
        public static String generaCodigoSeguridad() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#-";
        

        for (int i = 0; i < 8; i++) {
        sb.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
        }

        System.out.println("El código de seguridad generado es: " + sb.toString());

        return sb.toString();
        }

        // Método para comprobar el código de seguridad
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

