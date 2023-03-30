package registro;
import java.util.Random;
import java.util.Scanner;

public class RegistroUsuario {
    private String nombre;
    private String email;
    private String password;
    private String codigo;
    
    // A constructor. It is a special method that is called when an object is created from a class.
    public RegistroUsuario() {
        generaCodigoSeguridad();
        insertarNombre();
        insertarEmail();
        insertarPassword();
        insertarCodigo();
    }
    
    public RegistroUsuario(String nombre2, String email2, String password2, String codigo2) {
    }

    public RegistroUsuario(String nombre2, String email2, String password2) {
    }

    /**
     * It generates a random string of 8 characters, using the characters in the string
     * "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#-"
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
     * It asks the user to input a name, and then it stores the name in a variable called nombre.
     */
    private void insertarNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre (El nombre ha de comenzar con mayuscula, un guion cuando termines de colocar letras y tres numeros despues del mismo): ");
        nombre = scanner.nextLine();
    }
    
   /**
    * It asks the user to input an email address and then stores it in the variable email
    */
    private void insertarEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su email (Puede ser un @paucasesnovescifp ,@gmail, @hotmail o @yahoo): ");
        email = scanner.nextLine();
    }
    
    /**
     * It asks the user to input a password, and then it stores the input in the variable password.
     */
    private void insertarPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su password (La contraseña ha de empezar con mayuscula, contener un max de 9 caracteres y los dos ultimos han de ser numeros): ");
        password = scanner.nextLine();
    }
    
    /**
     * It asks the user to input a code, and then it stores that code in the variable codigo.
     */
    private void insertarCodigo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su código: ");
        codigo = scanner.nextLine();
    }
    
   // A getter method. It is used to get the value of a private variable.
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * The function validarFormulario() takes an object of type RegistroUsuario as a parameter and
     * returns a boolean value
     */
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