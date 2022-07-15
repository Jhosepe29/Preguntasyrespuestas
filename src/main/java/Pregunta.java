import java.util.Random;

public class Pregunta {
    private String textodelaPregunta;
    private OpcionesdeRespuesta opcionesdeRespuesta;
    private Integer niveldelJuego;



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
}
