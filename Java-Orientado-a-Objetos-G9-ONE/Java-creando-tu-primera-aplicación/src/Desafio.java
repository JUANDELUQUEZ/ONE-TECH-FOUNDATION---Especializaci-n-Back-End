/* Se nos precenta el desafio final de este curso: Java: Creando primer aplicacion
  El deesafio se basa en la construccion de una aplicacion bancaria. 

  Tenemos la siguiente arquitectura de conceptos 
  - Estado inicial: Definimos la informacin del cliente: nombre, tipo de cuenta, saldo inicial, numero de cuenta.
  - Menú ciclico: Tenemos el menu de opciones que se va a repetir hasta que el usuario decida salir, 
  - Enrutamiento logico: las opciones son las siguientes: 
      - Depositar dinero - 1
      - Retirar dinero - 2 
      - Consultar saldo - 3
      - Salir - 9
  - Validacion de Negocio: (si saldo es insuficiente, mostrar mensaje de error)

*/
import java.util.Scanner;
public class Desafio {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      System.out.println(
          "Bienvenidoa nuestra aplicacion bancaria, porfavor ingresa tu informacion para crear tu perfil de usuario...");
      System.out.println("Ingresa tu nombre completo: ");
      String nombreUsuario = sc.nextLine();
      System.out.println("Ingresa el tipo de cuenta (Ahorros o Credito): ");
      String tipoCuenta = sc.nextLine();
      System.out.println("Ingresa tu saldo inicial: ");
      double saldoInicial = sc.nextDouble();
      sc.nextLine(); // Limpiar el buffer
      System.out.println("Ingresa tu numero de cuenta: ");
      int numeroCuenta = sc.nextInt();
      sc.nextLine(); // Limpiar el buffer
      System.out.println("Perfil de usuario creado exitosamente!");
      System.out.println("\n");
      System.out.println("---------------------------------------------");
      System.out.println("""
        Usuario creado:
        Nombre: %s
        Tipo de cuenta: %s
        Saldo inicial: %.2f
        Numero de cuenta: %d
        """.formatted(nombreUsuario, tipoCuenta, saldoInicial, numeroCuenta));
      System.out.println("---------------------------------------------");
      System.out.println("\n");
      int opcion = 0;
      while (opcion != 9) {
        System.out.println("""
            
            Menu e opciones; 
            1. Depositar dinero
            2. Retirar dinero
            3. Consultar saldo
            9. Salir
            """);
        switch (opcion = sc.nextInt()) {
          case 1:
            System.out.println("Ingrese la cantidad a depositar: ");
            double cantidadDepositar = sc.nextDouble();
            saldoInicial += cantidadDepositar;
            System.out.println("Deposito realizado con exito. Su nuevo saldo es: " + saldoInicial);
            break;
          case 2:
            System.out.println("Ingrese la cantidad a retirar: ");
            double cantidadRetirar = sc.nextDouble();
            if (cantidadRetirar > saldoInicial) {
              System.out.println("Saldo insuficiente.");
            } else {
              saldoInicial -= cantidadRetirar;
              System.out.println("Retiro realizado con exito. Su nuevo saldo es: " + saldoInicial);
            }
            break;
          case 3:
            System.out.println("Su saldo actual es: " + saldoInicial);
            break;
          case 9:
            System.out.println("Gracias por usar nuestra aplicacion bancaria.");
            break;
        
          default:
            System.out.println("Opcion no valida, por favor intente de nuevo.");
            break;
        }
        
      }
    }
  }
}
