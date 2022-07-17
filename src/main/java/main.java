import org.jboss.logging.Logger;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static Logger escribirEnConsola = Logger.getLogger(main.class) ;
    static Integer idJugador = 1;

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

    return "\n"+"******************************************************"+"\n\t"+textoPregunta + "\n\n" +   opcionesRespuestaA + "\n"+  opcionesRespuestaB +"\n"+ opcionesRespuestaC +"\n"+ opcionesRespuestaD + "\n"+ "escoge la opcion que considere correcta"+"\n"+"******************************************************";

    }

public static   boolean validarRespuesta (String respuesta , Pregunta pregunta, Jugador jugador,Integer nivel){
        if (respuesta.equalsIgnoreCase(pregunta.getOpcionesdeRespuesta().getRespuestaCorrectas())){

            escribirEnConsola.info("respuesta correcta");
            puntos(nivel,jugador);
            return true ;
        }
        escribirEnConsola.info("respuesta incorrecta");
        return false;
}
public static void puntos(Integer nivel,Jugador jugador ){

        Integer puntosObtenidos = (100*nivel);
        Integer puntosActuales = jugador.getPuntos();

        jugador.setPuntos(puntosActuales + puntosObtenidos);
}
    public static void main(String[] args) {

        Pregunta pregunta = new Pregunta();
        Scanner entradaConsola = new Scanner(System.in);
        int idRandom = pregunta.generadorRandomIdPregunta(6,1);
        pregunta = Pregunta.GeneradordePreguntas(idRandom, 1);
        escribirEnConsola.info(mostrarPreguntas(pregunta));
        escribirEnConsola.info(pregunta.getOpcionesdeRespuesta().getRespuestaCorrectas());

        Jugador jugador = new Jugador();
        jugador = jugador.CrearJugador(idJugador.toString());


    }
}
