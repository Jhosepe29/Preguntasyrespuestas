import org.jboss.logging.Logger;

import java.awt.*;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.Scanner;
/**
 * @author Jhosepe11
 * @author JorgeMontoya
 *
 *la class contendrá los métodos de ejecución del juego como son los Menu()
 *  puntos() montrarpregunta() validarRespesta() y la lógica del juego instanciando
 *  los objetos de las demás clase y empleando sus métodos propios.
 *
 */
public class main {
    /**
     * @author Jhosepe11
     *
     * Se definen los atributos de la clase escribirEnConsola {@link Logger} para ecribir en la consola
     * e idJugador {@link Integer}
     *
     */
    public static Logger escribirEnConsola = Logger.getLogger(main.class) ;
    static Integer idJugador = 1;

    /**
     * El método menú se encarga de mostrar las opciones iniciales del juego
     * como son jugar, ver histórico o récords y salir del juego. Empleando un objeto
     * Scanner este método lee la entrada por teclado y la retorna como String
     *
     * @author Jhosepe11
     *
     *
     *  @return salida {@link String}
     *
     */
    public static String Menu(){
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

    /**
     *El método mostarPregunta recibe como parámetro un objeto de a clase Pregunta y empleando
     *sus métodos getters obtiene los textos que le mostrarán al usuario como pregunta y opciones
     *de respuesta de la ronda y  organiza la salida en un formato
     *
     * @author Jhosepe11
     * @author JorgeMontoya
     *
     *  @return  {@link String}
     *
     */
    public static String mostrarPreguntas(Pregunta pregunta){
     String textoPregunta = pregunta.getTextodelaPregunta();
     String opcionesRespuestaA = pregunta.getOpcionesdeRespuesta().getOpcionA();
    String opcionesRespuestaB = pregunta.getOpcionesdeRespuesta().getOpcionB();
    String opcionesRespuestaC = pregunta.getOpcionesdeRespuesta().getOpcionC();
    String opcionesRespuestaD = pregunta.getOpcionesdeRespuesta().getOpcionD();

    return "\n"+"******************************************************"+"\n\t"+textoPregunta + "\n\n" +   opcionesRespuestaA + "\n"+  opcionesRespuestaB +"\n"+ opcionesRespuestaC +"\n"+ opcionesRespuestaD + "\n"+ "escoge la opcion que considere correcta"+"\n"+"******************************************************";
    }

    /**
     *El método validarRespeusta se encarga de según la pregunta que reciba y la respuesta validar si es correcta.
     *Si es correcta invocara al meto puntos, de lo contrario avisara respuesta equivocada.
     *
     *
     * @author JorgeMontoya
     *
     *  @return   boolean
     *
     */
    public static boolean validarRespuesta (String respuesta , Pregunta pregunta, Jugador jugador,Integer nivel){
        if (respuesta.equalsIgnoreCase(pregunta.getOpcionesdeRespuesta().getRespuestaCorrectas())){
            escribirEnConsola.info("respuesta correcta");
            puntos(nivel,jugador);
            return true ;
        }
        escribirEnConsola.info("respuesta incorrecta");
        return false;
}

    /**
     *El método puntos se encarga de según el nivel calcuar cuantos puntos ganara el
     *  jugador y modificarle los puntos usando el setter correspondiente a la variable puntos del jugador.
     *
     *
     * @author JorgeMontoya
     *
     */
    public static void puntos(Integer nivel,Jugador jugador ){
        Integer puntosObtenidos = (100*nivel);
        Integer puntosActuales = jugador.getPuntos();

        jugador.setPuntos(puntosActuales + puntosObtenidos);
}

    /**
     *Método main el método de ejecución del juago instanciara las clases requerida e
     * invocara los métodos necesarios para la correcta ejecución del juego aplicando
     * la lógica para el correcto funcionamiento.
     *
     * @author Jhosepe11
     * @author JorgeMontoya
     *
     */
    public static void main(String[] args) {
        MySQL conection = new MySQL();
        Scanner entradaConsola = new Scanner(System.in);
        Jugador jugador = new Jugador();
        Pregunta pregunta = new Pregunta();
        boolean bandera =true;
        do {
            String opcionmenu = Menu();
             switch (opcionmenu){
                 case "1":  jugador = jugador.CrearJugador(idJugador.toString());
                            idJugador++;
                            Integer topeMaximo = 5;
                            Integer topeMinimo = 1;
                            String respuesRonda;
                           for (int nivelJuego = 1; nivelJuego<6;nivelJuego++){
                                int idRandom = pregunta.generadorRandomIdPregunta(topeMaximo,topeMinimo);
                                topeMaximo+=5;
                                topeMinimo+=5;
                                pregunta = Pregunta.GeneradordePreguntas(idRandom, nivelJuego);
                                escribirEnConsola.info(mostrarPreguntas(pregunta));
                                respuesRonda = entradaConsola.next();
                                if(validarRespuesta(respuesRonda,pregunta,jugador,nivelJuego)){
                                    if(nivelJuego==5){
                                        escribirEnConsola.info("Ganaste el juego");
                                        conection.CargarHistoricoUsuario(jugador);
                                    }
                                }else{
                                    escribirEnConsola.info("El juego termino");
                                    conection.CargarHistoricoUsuario(jugador);
                                    break;
                                }
                            }
                     break;
                 case "2":
                     String respuestaHistorico = conection.getHistorico();
                     String  [] arrayHitorico = respuestaHistorico.split("¡");
                     for (int i = 0; i < arrayHitorico.length; i++ ){
                         escribirEnConsola.info(arrayHitorico[i]);
                     }
                     break;
                 case "3": bandera = false;
                        break;
                 default: escribirEnConsola.info("Ingreso una opción erronea, intentelo de nuevo");
                     break;

             }
        }while (bandera);

    }
}
