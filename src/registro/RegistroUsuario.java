/**

Clase que representa el registro de un usuario en un sistema.
*/
package registro;
import java.util.Random;
import java.util.Scanner;
public class RegistroUsuario {
private String nombre;
private String email;
private String password;
private String codigo;


/**
 * Constructor que genera un código de seguridad y solicita los datos necesarios para el registro.
 */
public RegistroUsuario() {
    generaCodigoSeguridad();
    insertarNombre();
    insertarEmail();
    insertarPassword();
    insertarCodigo();
}

/**
 * Constructor que recibe los datos del usuario como parámetros.
 * @param nombre2 El nombre del usuario.
 * @param email2 El correo electrónico del usuario.
 * @param password2 La contraseña del usuario.
 * @param codigo2 El código de seguridad del usuario.
 */
public RegistroUsuario(String nombre2, String email2, String password2, String codigo2) {
}

/**
 * Constructor que recibe los datos del usuario como parámetros, excepto el código de seguridad.
 * @param nombre2 El nombre del usuario.
 * @param email2 El correo electrónico del usuario.
 * @param password2 La contraseña del usuario.
 */
public RegistroUsuario(String nombre2, String email2, String password2) {
}

/**
 * Genera un código de seguridad aleatorio de 8 caracteres.
 */
private void generaCodigoSeguridad() {
    String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#-";
    Random rnd = new Random();
    StringBuilder sb = new StringBuilder(8);
    for (int i = 0; i < 8; i++) {
        sb.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
    }
    System.out.println("El código de seguridad generado es: " + sb.toString());
    codigo = sb.toString();
}

/**
 * Solicita al usuario que introduzca su nombre.
 */
private void insertarNombre() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese su nombre (El nombre ha de comenzar con mayuscula, un guion cuando termines de colocar letras y tres numeros despues del mismo): ");
    nombre = scanner.nextLine();
}

/**
 * Solicita al usuario que introduzca su correo electrónico.
 */
private void insertarEmail() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese su email (Puede ser un @paucasesnovescifp ,@gmail, @hotmail o @yahoo): ");
    email = scanner.nextLine();
}

/**
 * Solicita al usuario que introduzca su contraseña.
 */
private void insertarPassword() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese su password (La contraseña ha de empezar con mayuscula, contener un max de 9 caracteres y los dos ultimos han de ser numeros): ");
    password = scanner.nextLine();
}

/**
 * Solicita al usuario que introduzca su código de seguridad.
 */
private void insertarCodigo() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese su código: ");
    codigo = scanner.nextLine();
}

/**
 * Devuelve el nombre del usuario.
 * @return El nombre del usuario.
 */
public String getNombre() {
    return nombre;
}
   
/**
 * Devuelve el correo electrónico del usuario.
 * @return El correo electrónico del usuario.
 */
public String getEmail() {
     return email;
 }
    
 /**
 * Devuelve la contraseña del usuario.
 * @return La contraseña del usuario.
 */
 public String getPassword() {
     return password;
 }
    
/**
 * Devuelve el codigo.
 * @return El codigo.
 */
 public String getCodigo() {
     return codigo;
 }
    
    
    public static void main(String[] args) {
        RegistroUsuario registroUsuario = new RegistroUsuario();
        ValidarCampos validarCampos = new ValidarCampos();
        boolean formularioValido = validarCampos.validarFormulario(registroUsuario);
    
        if (formularioValido) {
            System.out.println("El registro se ha realizado con éxito");
        } else {
            System.out.println("El formulario no es válido.");
        }
    }
} 