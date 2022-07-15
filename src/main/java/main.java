import org.jboss.logging.Logger;

import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static Logger escribirEnConsola = Logger.getLogger(main.class) ;

    public static String menu(){
        Scanner in = new Scanner(System.in);
        String salida;
        escribirEnConsola.info("""
                **#**#**#**##**##**##**##
                __________________________
                        Juego 
                 Preguntas & Respuestas
                 
                1. Iniciar Juego.
                2. ver Records
                3. Salir.
               
                Ingrese una opción: 
                """);
        salida = in.next();
        return salida;
    }

    public static void main(String[] args) {
     MySQL conection = new MySQL();
        Connection conectar;

        try {
            conectar = conection.getConnection();
            escribirEnConsola.info("pa saber que pasa"+conection.getpregunta(1,conectar));
        } catch (Exception e) {
            escribirEnConsola.info("Error en "+ e);
        }





    }
}
