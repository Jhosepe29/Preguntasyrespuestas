import org.jboss.logging.Logger;

import java.util.Random;
/**
 * @author Jhosepe11
 * @author JorgeMontoya
 *
 * la class pregunta guardara la pregunta de la ronda junto a las opciones de repuesta correspondiente
 * al nivel.
 */
public class Pregunta {

    /**
     * @author Jhosepe11
     * @author JorgeMontoya
     * Se definen los atributos de la clase Pregunta, tales como textodelaPregunta
     * OpcionesdeRespuesta niveldelJuego
     *
     */
    private String textodelaPregunta;
    private OpcionesdeRespuesta opcionesdeRespuesta;
    private Integer niveldelJuego;
    public static Logger escribirEnConsola = Logger.getLogger(Pregunta.class) ;

    /**
     * @author Jhosepe11
     * @author JorgeMontoya
     * Crea un objeto de tipo Pregunta con todos los atrivutos en null.
     *
     */
    public  Pregunta(){

    }
    /**
     * @author Jhosepe11
     * Crea un objeto de tipo Pregunta.
     * @param textodelaPregunta- El texto que tendra la pregunta.
     * @param opcionesdeRespuesta- El arreglo que continúe las opciones de respuesta a la pregunta.
     * @borrows listadeOpciones esta pensada para ser un objeto de la clase {@link OpcionesdeRespuesta}
     */
    public  Pregunta(String textodelaPregunta, OpcionesdeRespuesta opcionesdeRespuesta, Integer niveldelJuego) {
        this.textodelaPregunta = textodelaPregunta;
        this.opcionesdeRespuesta = opcionesdeRespuesta;
        this.niveldelJuego = niveldelJuego;
    }
    /**
     * Retorna el texto que tenga la variabel textodelaPregunta como {@link String}
     * @author Jhosepe11
     * @return  textodelaPregunta
     */
    public String getTextodelaPregunta() {
        return textodelaPregunta;
    }
    /**
     * Retorna un objeto de tipo OpcionesRerepuesta como  {@link OpcionesdeRespuesta}
     * @author Jhosepe11
     * @return  OpcionesdeRespuesta
     */
    public OpcionesdeRespuesta getOpcionesdeRespuesta() {
        return opcionesdeRespuesta;
    }
    /**
     * Retorna numero que tenga la variabel niveldelJuego como {@link Integer}
     * @author Jhosepe11
     * @return niveldelJuego
     */
    public Integer getNiveldelJuego() {
        return niveldelJuego;
    }
    /**
     * El método generadorRandomIdPregunta se encarga de generar un numero aleatorio que se
     * encuentre dentro del rango de números que se le pasan como parámetro.
     * Recibe como parámetro topeMaximo {@link Integer}  y el topeMinimo {@link Integer}
     * @author Jhosepe11
     * @author JorgeMontoya
     * @return int aleatorio que representa el id de la pregunta que se buscara.
     */
    public int generadorRandomIdPregunta(Integer topeMaximo,Integer topeMinimo){
        int aleatorio=0;
        do {
            aleatorio = ((int) (Math.random() * topeMaximo));
           if (aleatorio >= topeMinimo) {
               return aleatorio;
           }
       }while (aleatorio<=topeMinimo);
        return aleatorio;
    }

    /**
     * El método GeneradordePreguntas es el en cargado de crear la pregunta empleando métodos
     * de conexión y consulta a la base de datos instanciando un objeto de la clase  MySQL
     * Recibe como parámetro el id de la Pregunta que traerá de la base de datos y el nivel de juego {@link Integer}
     * @author Jhosepe11
     * @author JorgeMontoya
     * @return niveldelJuego
     */
    public static Pregunta GeneradordePreguntas(int idPregunta,Integer niveljuego){
        MySQL conection = new MySQL();
        String preguntaRetornada="";
        String[] opcionesRespuesta = new String[4];
        String[] respuestas;
        String[] opcionesRespuestaTemporal = new String[4];
        String respuestaCorrecta = "";
        int indice = 0;
        try {
            preguntaRetornada = conection.getpregunta(idPregunta);

        } catch (Exception e) {
            escribirEnConsola.info("Error en "+ e);
        }
        try{
            opcionesRespuestaTemporal = (conection.getOpciones(idPregunta)).split("¡");



        }catch (Exception e) {
            escribirEnConsola.info("Error en "+ e);
        }
        opcionesRespuesta = opcionesRespuestaTemporal;
        respuestaCorrecta = conection.getRespuestaCorrecta();
        OpcionesdeRespuesta opcionesdelapregunta = new OpcionesdeRespuesta(opcionesRespuesta[0],opcionesRespuesta[1],opcionesRespuesta[2],opcionesRespuesta[3],respuestaCorrecta );

        return new Pregunta(preguntaRetornada,opcionesdelapregunta,niveljuego);
    }


}
