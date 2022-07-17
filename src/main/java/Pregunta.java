import org.jboss.logging.Logger;

import java.util.Random;

public class Pregunta {
    private String textodelaPregunta;
    private OpcionesdeRespuesta opcionesdeRespuesta;
    private Integer niveldelJuego;
    public static Logger escribirEnConsola = Logger.getLogger(Pregunta.class) ;


    public  Pregunta(){

    }
    public  Pregunta(String textodelaPregunta, OpcionesdeRespuesta opcionesdeRespuesta, Integer niveldelJuego) {
        this.textodelaPregunta = textodelaPregunta;
        this.opcionesdeRespuesta = opcionesdeRespuesta;
        this.niveldelJuego = niveldelJuego;
    }

    public String getTextodelaPregunta() {
        return textodelaPregunta;
    }

    public OpcionesdeRespuesta getOpcionesdeRespuesta() {
        return opcionesdeRespuesta;
    }

    public Integer getNiveldelJuego() {
        return niveldelJuego;
    }

    public int generadorRandomIdPregunta(Integer topeMaximo,Integer topeMinimo){
        Random idAleatorio = new Random();
        return  idAleatorio.nextInt(topeMaximo + topeMinimo) + topeMinimo;
    }
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
