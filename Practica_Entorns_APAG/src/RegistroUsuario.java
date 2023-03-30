import java.util.Random;
import java.util.Scanner;

public class RegistroUsuario {
    private String nombre;
    private String email;
    private String password;
    private String codigo;

    public static String generaCodigoSeguridad() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#-";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            sb.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
        }
        System.out.println("El código de seguridad generado es: " + sb.toString());
        return sb.toString();
    }

    public void insertarNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre (El nombre ha de comenzar con mayuscula, un guion cuando termines de colocar letras y tres numeros despues del mismo): ");
        this.nombre = scanner.nextLine();
    }

    public void insertarEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su email (Puede ser un @paucasesnovescifp ,@gmail, @hotmail o @yahoo): ");
        this.email = scanner.nextLine();
    }

    public void insertarPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su password (La contraseña ha de empezar con mayuscula, contener un max de 9 caracteres y los dos ultimos han de ser numeros): ");
        this.password = scanner.nextLine();
    }

    public void insertarCodigo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su código: ");
        this.codigo = scanner.nextLine();
    }

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

    public static void main(String[] args) {
        
        RegistroUsuario registroUsuario = new RegistroUsuario();
        registroUsuario.insertarNombre();
        registroUsuario.insertarEmail();
        registroUsuario.insertarPassword();
        RegistroUsuario.generaCodigoSeguridad();
        registroUsuario.insertarCodigo();

        ValidarCampos validarCampos = new ValidarCampos();
        boolean formularioValido = validarCampos.validarFormulario(registroUsuario);

        if (formularioValido) {
            System.out.println("El registro se ha realizado con éxito");
        } else {
            System.out.println("El formulario no es válido.");
        }
    }
}