
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int opcion =0;
        while (opcion != 8){
            System.out.println("*****************************\n"
                    + "Bienvenido al conversor de monedas\n\n"
                    +"Escoja la opcíon de conversion que desea realizar: \n\n"
                    +"1. Dollar a Peso Argentino\n"
                    +"2. Peso Argentino a Dollar\n"
                    +"3. Dollar a Real Brasilero\n"
                    +"4. Real Brasilero a Dollar\n"
                    +"5. Dollar a Peso Colombiano\n"
                    +"6. Peso Colombiano a Dollar\n"
                    +"7. Convertir otra moneda\n"
                    +"8. Salir\n");
            opcion= lectura.nextInt();
            lectura.nextLine();

            switch (opcion){
                case 1:
                    ConversorMoneda.convertir("USD", "ARS", consulta, lectura);
                    break;

                case 2:
                    ConversorMoneda.convertir("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    ConversorMoneda.convertir("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    ConversorMoneda.convertir("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    ConversorMoneda.convertir("USD", "COP", consulta, lectura);
                    break;
                case 6:
                    ConversorMoneda.convertir("COP", "USD", consulta, lectura);
                    break;
                case 7:
                    ConversorMoneda.convertirOtraMoneda(consulta, lectura);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcin no valida");
                    break;

            }

        }
    }

}
