import java.util.Scanner;

public class Jugador extends EscribirEnConsola {
    private String idJugador;
    private String nombreJugador;
    private Integer Puntos;

    public Jugador(String idJugador, String nombreJugador, Integer puntos) {
        this.idJugador = idJugador;
        this.nombreJugador = nombreJugador;
        Puntos = puntos;
    }
    public Jugador(){

    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Integer getPuntos() {
        return Puntos;
    }

    public void setPuntos(Integer puntos) {
        Puntos = puntos;
    }

    public Jugador CrearJugador(String idJugador){
        Scanner entradaConsola = new Scanner(System.in);
        super.getEscribir().info("Ingrese su nombre: ");
        String nombreJugador = entradaConsola.nextLine();

        return new Jugador(idJugador,nombreJugador,0);

    }
    
}
