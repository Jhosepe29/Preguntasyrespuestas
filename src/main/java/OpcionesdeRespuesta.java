
/**
 * @author Jhosepe11
 *
La class OpciónesRespuesta al se encargara de crear el objeto que contenga
las opciones de la pregunta y la letra correspondiente a la respuesta correcta.
 */
public class OpcionesdeRespuesta {
    /**
     * @author Jhosepe11
     *
     * Se definen los atributos de la clase OpcionesRespuesta tales como opcionA, opcionB
     * opcionC, opcionD y respuesta correcta todos de tipo {@link String}
     *
     */
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    private String respuestaCorrectas;

    /**
     * @author Jhosepe11
     * Crea un objeto de tipo OpcionesRespuesta inicializando los atributos con los paramtros que recibe.
     * @param opcionA- El texto que resprencenta la opcion A.
     * @param opcionB- El texto que resprencenta la opcion B.
     * @param opcionC- El texto que resprencenta la opcion C.
     * @param opcionD- El texto que resprencenta la opcion D.
     * @param respuestaCorrectas letra que coresponde a la opción correcta.
     */
    public OpcionesdeRespuesta(String opcionA, String opcionB, String opcionC, String opcionD, String respuestaCorrectas) {
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.respuestaCorrectas = respuestaCorrectas;
    }
    /**
     * @author Jhosepe11
     * Crea un objeto de tipo OpcionesRespuesta con todos los atrivutos en null.
     *
     */
    public OpcionesdeRespuesta(){
    }

    /**
     * Retorna el texto que tenga la variabel opcionA como {@link String}
     * @author Jhosepe11
     * @return  opcionA
     */
    public String getOpcionA() {
        return opcionA;
    }
    /**
     * Retorna el texto que tenga la variabel opcionB como {@link String}
     * @author Jhosepe11
     * @return  opcionB
     */

    public String getOpcionB() {
        return opcionB;
    }

    /**
     * Retorna el texto que tenga la variabel opcionC como {@link String}
     * @author Jhosepe11
     * @return  opcionC
     */
    public String getOpcionC() {
        return opcionC;
    }

    /**
     * Retorna el texto que tenga la variabel opcionD como {@link String}
     * @author Jhosepe11
     * @return  opcionD
     */
    public String getOpcionD() {
        return opcionD;
    }

    /**
     * Retorna el texto que tenga la variabel respuestaCorrectas como {@link String}
     * @author Jhosepe11
     * @return  respuestaCorrectas
     */
    public String getRespuestaCorrectas() {
        return respuestaCorrectas;
    }
}
