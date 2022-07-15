public class OpcionesdeRespuesta {
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;
    private String respuestaCorrectas;

    public OpcionesdeRespuesta(String opcionA, String opcionB, String opcionC, String opcionD, String respuestaCorrectas) {
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.respuestaCorrectas = respuestaCorrectas;
    }
    public OpcionesdeRespuesta(){
    }

    public String getOpcionA() {
        return opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public String getOpcionD() {
        return opcionD;
    }

    public String getRespuestaCorrectas() {
        return respuestaCorrectas;
    }
}
