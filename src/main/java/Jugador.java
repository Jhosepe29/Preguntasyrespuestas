import java.util.Scanner;

/**
 * @autor jhosepe11
 * @author JorgeMontoya
 * * esta clase define los atributos  necesarios que debe de tener el jugador, con su respectivo constructor
 * y metodos getter y setter para acceder u obtener sus valores
 *
 */
public class Jugador extends EscribirEnConsola {

    /**
     * @autor jhosep11
     * @jorgeMontoya
     * se definen los atributos de de la clase jugador
     */
    private String idJugador;
    private String nombreJugador;
    private Integer Puntos;

    /**
     * @autor jhosep11
     * Se crea el constructor con los siguientes parametros
     * @param idJugador - el identificador unico que tendra el jugador generado automaticamente en MySQl
     * @param nombreJugador - nombre del jugador capturado por consola
     * @param puntos - puntos obtenidos por cada respuesta correcta
     */
    public Jugador(String idJugador, String nombreJugador, Integer puntos) {
        this.idJugador = idJugador;
        this.nombreJugador = nombreJugador;
        Puntos = puntos;
    }
    public Jugador(){

    }
    /**

     * @autor jhosep11
     * metodo que permite  obtener el id del Jugador
     * @return idJugador
     */
    public String getIdJugador() {
        return idJugador;
    }

    /**
     * @autor jhosep11
     * metodo que permite  actualizar  el valor del atributo idJugador
     */
    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    /**
     * @autor jhosep11
     * metodo que permite obtener el nombre del Jugador
     * @return nombreJugador
     */
    public String getNombreJugador() {
        return nombreJugador;
    }

    /**
     * @autor jhosep11
     * metodo que permite  actualizar  el valor del atributo nombreJugador
     */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    /**
     * @autor jhosep11
     * metodo que permite obtener el valor de los puntos del jugador
     * @return puntos
     */
    public Integer getPuntos() {
        return Puntos;
    }

    /**
     * @autor jhosep11
     * metodo que permite actualizar el valor de los puntos del jugador
     * @param puntos
     */
    public void setPuntos(Integer puntos) {
        Puntos = puntos;
    }

    /**
     * @autor jhosep11

     * el metodo crearJugador se encarga de recibir por consola el nombre del jugador; este metodo recibe
     * como parametro el idJugador.
     * @param idJugador
     * @return idJugador, nombreJugador y los puntos en cero
     */
    public Jugador CrearJugador(String idJugador){
        Scanner entradaConsola = new Scanner(System.in);
        super.getEscribir().info("Ingrese su nombre: ");
        String nombreJugador = entradaConsola.nextLine();

        return new Jugador(idJugador,nombreJugador,0);

    }
    
}
