import org.jboss.logging.Logger;

import java.awt.*;
import java.io.PrintStream;
import java.sql.Connection;
import java.util.Scanner;

public class main {
    public static Logger escribirEnConsola = Logger.getLogger(main.class) ;
    static Integer idJugador = 1;

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
        Scanner entradaConsola = new Scanner(System.in);
        Jugador jugador = new Jugador();
        Pregunta pregunta = new Pregunta();
        boolean bandera =true;
        do {
            String opcionmenu = Menu();
             switch (opcionmenu){
                 case "1":  jugador = jugador.CrearJugador(idJugador.toString());
                            idJugador++;
                            Integer topeMaximo = 6;
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
                                        //cargardatos a la base de datos Inser tabla historico
                                    }
                                }else{
                                    escribirEnConsola.info("El juego termino");

                                    // inser taba historico
                                    break;
                                }


                            }
                     break;
                 case "2": // hacer select de tabla historico
                     break;
                 case "3": bandera = false;
                        break;
                 default: escribirEnConsola.info("Ingreso una opción erronea, intentelo de nuevo");
                     break;

             }


        }while (bandera);










    }
}
