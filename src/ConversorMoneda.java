import java.util.Scanner;

public class ConversorMoneda {
    public static void convertir (String monedaBase, String monedaTarget, ConsultarMoneda consulta, Scanner lectura){

        System.out.println("Ingrese el valor a convertir: ");
        String cantidad = lectura.nextLine();
        Monedas monedas = consulta.consultaMoneda(monedaBase, monedaTarget, cantidad);
        System.out.println("La tasa de conversion es: 1" + monedaBase + "= " + monedas.conversion_rate() + " " + monedaTarget);
        System.out.println("Valor convertido: "+ cantidad + " " + monedaBase + "= " + monedas.conversion_result() + " " + monedaTarget + "\n\n");

    }

    public static void convertirOtraMoneda (ConsultarMoneda consulta, Scanner lectura){
        System.out.println("Ingerese el codigo de la moneda base: ");
        String  monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese el codigo de la moneda objetivo: ");
        String monedaTarget = lectura.nextLine().toUpperCase();
        if (consulta.consultaIndividual(monedaBase).result().equals("error") || consulta.consultaIndividual(monedaTarget).result().equals("error") ){
            if(consulta.consultaIndividual(monedaBase).result().equals("error") ){
                System.out.println("Moneda no encontrada: " + monedaBase);
            } else {
                System.out.println("Moneda no encontrada: " + monedaTarget);
            }

        } else {
            convertir(monedaBase, monedaTarget, consulta, lectura);
        }

    }
}
