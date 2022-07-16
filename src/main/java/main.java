import org.jboss.logging.Logger;
import java.io.PrintStream;
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

    public static String mostrarPreguntas(Pregunta pregunta){
     String textoPregunta = pregunta.getTextodelaPregunta();
     String opcionesRespuestaA = pregunta.getOpcionesdeRespuesta().getOpcionA();
    String opcionesRespuestaB = pregunta.getOpcionesdeRespuesta().getOpcionB();
    String opcionesRespuestaC = pregunta.getOpcionesdeRespuesta().getOpcionC();
    String opcionesRespuestaD = pregunta.getOpcionesdeRespuesta().getOpcionD();

    return textoPregunta + "\n" +   opcionesRespuestaA + "\n"+  opcionesRespuestaB +"\n"+
            "\n"+ opcionesRespuestaC +"\n"+ opcionesRespuestaD + "\n"+ "escoge la opcion que considere correcta";




    }
    public static void main(String[] args) {
        Pregunta pregunta = new Pregunta();
      int idRandom = pregunta.generadorRandomIdPregunta(6,1);
      pregunta = Pregunta.GeneradordePreguntas(idRandom, 1);

        escribirEnConsola.info(mostrarPreguntas(pregunta));

    }
}
