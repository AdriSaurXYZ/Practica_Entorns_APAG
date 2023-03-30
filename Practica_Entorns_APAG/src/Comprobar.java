import java.util.Random;
import java.util.Scanner;

        public class Comprobar {
            
        // Base de datos de nombres de usuarios
        private static final String[] nombresUsuarios = {"Carles_345", "AnaGomez-783", "Pepito_999", "Laura_222",
        "Juanito-111", "Marta_444", "Pedro_777", "Sofia-666", "David_555", "Lucia888"};

        // Método para comprobar el nombre de usuario
        public static boolean compruebaNombre(String nombre) {
        boolean valido = false;

        // Comprobar que el nombre cumple las restricciones
        if (nombre.matches("^[A-Z][a-z]+[-][0-9]{3}$") && nombre.length() <= 16) {
        // Comprobar que el nombre no está en la base de datos
        for (String n : nombresUsuarios) {
            if (n.equalsIgnoreCase(nombre)) {
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
          //generar Codigo
        public static String generaCodigoSeguridad() {
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#-";
            Random rnd = new Random();
            StringBuilder sb = new StringBuilder(8);
        
            for (int i = 0; i < 8; i++) {
                sb.append(caracteres.charAt(rnd.nextInt(caracteres.length())));
            }
        
            String codigoGenerado = sb.toString();
            System.out.println("El código de seguridad generado es: " + codigoGenerado);
            return codigoGenerado;
        }
        public static boolean compruebaCodigoSeguridad(String codigo) {
            Scanner scanner = new Scanner(System.in);
            boolean valido = false;
            // Comprobar que el código introducido coincide con el generado
            System.out.println("Introduce el código de seguridad generado:");
            String codigoIntroducido = scanner.nextLine();
            if (codigoIntroducido.equals(codigo)) {
                valido = true;
                System.out.println("El codigo  es correcto");
                return valido;
            } else {
                System.out.println("El codigo no es correcto");
                return valido;
            }
        }
}

