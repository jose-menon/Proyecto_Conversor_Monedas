import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String entrada = "";
        String salida = "";
        Scanner lectura = new Scanner(System.in);
        Consulta_Conversion consulta = new Consulta_Conversion();
        while(true)
        {
            System.out.println("""
                    *************************
                    Menu de Conversiones
                    1- Peso Argentino a Dolares
                    2- Peso Chileno a Dolares
                    3- Peso Argentino a Peso Chileno
                    4- Peso Chileno a Real Brasileño
                    0- Salir
                    **************************
                    Seleccione la Opcion de Conversion: """);
            try
            {
                var seleccion = Integer.valueOf(lectura.nextLine());
                if(seleccion == 0)
                {
                    System.out.println("Gracias por utilizar el programa");
                    break;
                }
                if(seleccion < 1 || seleccion > 4)
                {
                    System.out.println("Seleccione una opcion valida (1 - 4)");
                    continue;
                }

                    switch (seleccion)
                    {
                        case 1 -> { entrada = "ARS"; salida = "USD"; }
                        case 2 -> { entrada = "CLP"; salida = "USD"; }
                        case 3 -> { entrada = "ARS"; salida = "CLP"; }
                        case 4 -> { entrada = "CLP"; salida = "BRL"; }
                        default ->System.out.println("Ingreso una opcion invalida");
                    }
                    System.out.println("Ingrese la Cantidad a Convertir: ");
                    var cantidad = Integer.valueOf(lectura.nextLine());
                    Conversor conversor = consulta.conversion(cantidad,entrada, salida);
                    System.out.println("Conversion Exitosa!!");
                    System.out.println(conversor);
                    Generador_Archivo generador = new Generador_Archivo();
                    generador.guardarDatos(conversor);
            }catch (NumberFormatException | IOException e)
            {
                System.out.println("Por Favor Ingrese un Numero Valido");
            }
        }
    }

}