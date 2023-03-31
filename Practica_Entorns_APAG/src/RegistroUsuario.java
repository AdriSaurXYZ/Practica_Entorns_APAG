

import java.util.Random;
import java.util.Scanner;

/**

Esta clase representa un registro de usuario con información básica como nombre, email y contraseña.

También puede generar un código de seguridad aleatorio de 8 caracteres para el usuario.
*/
public class RegistroUsuario {
    private String nombre;
    private String email;
    private String password;
    private String codigo;
    Scanner scanner = new Scanner(System.in);
    
    /**
    
    Constructor vacío de la clase.
    */
    public RegistroUsuario() {
    }
    /**
    
    Constructor de la clase que recibe los datos del usuario y un código de seguridad.
    @param nombre2 Nombre del usuario.
    @param email2 Email del usuario.
    @param password2 Contraseña del usuario.
    @param codigo2 Código de seguridad del usuario.
    */
    public RegistroUsuario(String nombre2, String email2, String password2, String codigo2) {
    nombre = nombre2;
    email = email2;
    password = password2;
    codigo = codigo2;
    }
    /**
    
    Constructor de la clase que recibe los datos del usuario.
    @param nombre2 Nombre del usuario.
    @param email2 Email del usuario.
    @param password2 Contraseña del usuario.
    */
    public RegistroUsuario(String nombre2, String email2, String password2) {
    nombre = nombre2;
    email = email2;
    password = password2;
    }
    /**
    
    Método que genera un código de seguridad aleatorio de 8 caracteres para el usuario.
    Los caracteres pueden ser letras mayúsculas y minúsculas, números y los siguientes símbolos: @, # y -.
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

Solicita al usuario que ingrese su nombre y lo asigna al atributo "nombre".
*/
private void insertarNombre() {
    System.out.print("Ingrese su nombre (El nombre ha de comenzar con mayuscula, un guion cuando termines de colocar letras y tres numeros despues del mismo): ");
    nombre = scanner.nextLine();
    }
    /**
    
    Solicita al usuario que ingrese su correo electrónico y lo asigna al atributo "email".
    */
    private void insertarEmail() {
    System.out.print("Ingrese su email (Puede ser un @paucasesnovescifp ,@gmail, @hotmail o @yahoo): ");
    email = scanner.nextLine();
    }
    /**
    
    Solicita al usuario que ingrese su contraseña y lo asigna al atributo "password".
    */
    private void insertarPassword() {
    System.out.print("Ingrese su password (La contraseña ha de empezar con mayuscula, contener un max de 9 caracteres y los dos ultimos han de ser numeros): ");
    password = scanner.nextLine();
    }
    /**
    
    Solicita al usuario que ingrese un código de seguridad y lo asigna al atributo "codigo".
    */
    private void insertarCodigo() {
    System.out.print("Ingrese su código: ");
    codigo = scanner.nextLine();
    }
    /**
    
    Retorna el nombre del usuario.
    @return nombre del usuario
    */
    public String getNombre() {
    return nombre;
    }
    /**
    
    Retorna el correo electrónico del usuario.
    @return correo electrónico del usuario
    */
    public String getEmail() {
    return email;
    }
    /**
    
    Retorna la contraseña del usuario.
    @return contraseña del usuario
    */
    public String getPassword() {
    return password;
    }
    /**
    
    Retorna el código de seguridad del usuario.
    @return código de seguridad del usuario
    */
    public String getCodigo() {
    return codigo;
    }
    /**
    
    Inicia el proceso de registro de usuario. Solicita al usuario la inserción de su nombre, correo electrónico,
    contraseña y un código de seguridad. Luego valida el formulario mediante la clase ValidarCampos y muestra un
    mensaje de éxito o error dependiendo de si el formulario es válido o no.
    */
    
    void init() {
        insertarNombre();
        insertarEmail();
        insertarPassword();
        generaCodigoSeguridad();
        insertarCodigo();
        
        ValidarCampos validarCampos = new ValidarCampos();
        boolean formularioValido = validarCampos.validarFormulario(this);
    
        if (formularioValido) {
            System.out.println("El registro se ha realizado con éxito");
        } else {
            System.out.println("El formulario no es válido.");
        }
    }

}
