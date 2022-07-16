import org.jboss.logging.Logger;

import java.util.Random;

public class Pregunta {
    private String textodelaPregunta;
    private OpcionesdeRespuesta opcionesdeRespuesta;
    private Integer niveldelJuego;
    public static Logger escribirEnConsola = Logger.getLogger(Pregunta.class) ;



    public Pregunta(String textodelaPregunta, OpcionesdeRespuesta opcionesdeRespuesta, Integer niveldelJuego) {
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

    public int generadorRandomIdPregunta(int topeMaximo,int topeMinimo){
        Random idAleatorio = new Random();
        return  idAleatorio.nextInt(topeMaximo + topeMinimo) + topeMinimo;
    }
    public Pregunta GeneradordePreguntas(int idPregunta,int niveljuego){
        MySQL conection = new MySQL();
        String preguntaRetornada="";
        String[] opcionesRespuesta;
        String[] respuestas;
        String respuestaCorrecta;

        try {
            preguntaRetornada = conection.getpregunta(idPregunta);

        } catch (Exception e) {
            escribirEnConsola.info("Error en "+ e);
        }
        try{
            String[] opcionesRespuestaTemporal = (conection.getOpciones(idPregunta)).split("¡");
            for (String opcion:opcionesRespuestaTemporal) {
                int index = opcion.length();
                 char letra = opcion.charAt(index);
                if(letra == '1'){
                    respuestaCorrecta = ""+opcion.charAt(0);
                    opcion.replace("1","");
                }
                opcion.replace("0","");
                op
            }

        }catch (Exception e) {
            escribirEnConsola.info("Error en "+ e);
        }
        OpcionesdeRespuesta opcionesdelapregunta = new OpcionesdeRespuesta()

        return new Pregunta()
    }


}
