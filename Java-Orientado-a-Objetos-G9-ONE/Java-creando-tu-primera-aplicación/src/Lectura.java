
/* Lectura del usuario por medio de la clase Scanner con la herramienta de java.util 

- Vamos a crear un pequeño "Registro de usuario" 
- Vamos a desarrollar una solicutud donde le pida al usuario su nombre (String), edad(int), correo electrónico(String) y presupuesto mensual para entretenimiento (double).
- Vamos a imprimir la informacion del usaurio usando el formato de Text blocks.
*/
import java.util.Scanner;

public class Lectura {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(
        "Bienvenido a nuestra aplicacioón de entretenimiento, porfavor ingresa tu información para crear tu perfil de usuario...");
    System.out.print("Ingresa tu nombre: ");
    String nombre = sc.nextLine();
    System.out.println("Ingresa tu edad: ");
    int edad = sc.nextInt();
    sc.nextLine(); // Limpiar el buffer después de leer un entero
    System.out.println("Ingresa tu correo electrónico: ");
    String correoElectronico = sc.nextLine();
    System.out.println("Ingresa tu presupuesto mensual para entretenimiento: ");
    double presupuestoMensual = sc.nextDouble();
    System.out.println("\n");
    System.out.println("""
        Perfil de Usuario:
        Nombre: %s
        Edad: %d
        Correo Electrónico: %s
        Presupuesto Mensual para Entretenimiento: %.2f
        """.formatted(nombre, edad, correoElectronico, presupuestoMensual));
  }
}
