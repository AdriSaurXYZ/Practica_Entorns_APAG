

import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase se encarga de validar los campos de usuario y contraseña. También contiene una
 * base de datos de nombres de usuarios para comprobar si el nombre de usuario ya existe.
 */
public class ValidarCampos {

    // Generador de números aleatorios y constructor de cadenas de caracteres
    Random rnd = new Random();
    StringBuilder sb = new StringBuilder(8);
    // Objeto para leer entradas del usuario por la consola
    Scanner scanner = new Scanner(System.in);

    /**
     * Este es el constructor de la clase.
     */
    public ValidarCampos() {

    }

    // Base de datos de nombres de usuarios
    final String[] nombresUsuarios = {"Carles_345", "AnaGomez-783", "Pepito_999", "Laura_222",
            "Juanito-111", "Marta_444", "Pedro_777", "Sofia-666", "David_555", "Lucia888"};

    /**
     * Este método comprueba si el nombre de usuario es válido y si no está ya en uso.
     * 
     * @param usuarios La lista de nombres de usuario en uso actualmente.
     * @param nombreUsuario El nombre de usuario a comprobar.
     * @return true si el nombre de usuario es válido y no está ya en uso, false en caso contrario.
     */
    public boolean compruebaNombre(String[] usuarios, String nombreUsuario) {
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

    /**
 * Comprueba que la contraseña cumple las restricciones.
 * 
 * @param password la contraseña a comprobar
 * @return true si la contraseña cumple las restricciones, false en caso contrario
 */
public boolean compruebaPassword(String password) {
    boolean valido = false;

    // Comprobar que la contraseña cumple las restricciones
    if (password.matches("^[A-Z][a-zA-Z0-9_#@-]{6}[0-9]{2}$")) {
        valido = true;
    } else {
        System.out.println("La contraseña no cumple las restricciones");
    }

    return valido;
}

/**
 * Comprueba si el correo electrónico es válido y si su dominio está permitido.
 * 
 * @param email el correo electrónico a comprobar
 * @return true si el correo electrónico es válido y su dominio está permitido, false en caso contrario
 */
public boolean compruebaEmail(String email) {
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

/**
 * Genera un código de seguridad aleatorio.
 * 
 * @return el código de seguridad generado
 */
public String generaCodigoSeguridad() {
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#-";
    
    for (int i = 0; i < 8; i++) {
        sb.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
    }

    System.out.println("El código de seguridad generado es: " + sb.toString());

    return sb.toString();
}

/**
 * Comprueba si el código de seguridad introducido coincide con el generado.
 * 
 * @param codigo el código de seguridad generado
 * @return true si el código introducido coincide con el generado, false en caso contrario
 */
public boolean compruebaCodigoSeguridad(String codigo) {
    boolean valido = false;

    // Comprobar que el código introducido coincide con el generado
    System.out.println("Vuelve a introducir el código de seguridad generado:");
    String codigoIntroducido = scanner.nextLine();
    if (codigoIntroducido.equals(codigo)) {
        valido = true;
        System.out.println("El codigo es correcto");
        return valido;
    } else {
        System.out.println("El codigo no es correcto");
        return valido;
    }

    }

    /**

    Valida los campos de un formulario de registro de usuario.
    @param registroUsuario Objeto que contiene los campos del formulario.
    * @return true si el formulario esta correcto, false en caso contrario
    **/

        public boolean validarFormulario(RegistroUsuario registroUsuario) {
            return false;
        }
}