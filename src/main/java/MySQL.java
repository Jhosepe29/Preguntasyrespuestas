import com.mysql.cj.xdevapi.Statement;
import org.jboss.logging.Logger;

import javax.swing.*;
import java.io.PrintStream;
import java.sql.*;
/**
 * @author jorgeMontoya
 * @autor jhosep11
 * esta clase establece la conexion a la base de datos, contiene los metodos para consultar e insertar datos en las
 * respectivas tablas que garantizan la persistencia de los datos
 */
public class MySQL {

    Logger escribirEnConsola = Logger.getLogger(MySQL.class) ;

    /**
     * @author jorgeMontoya
     *  * @autor jhosep11
     * se definen los atributos necesarios para la clase MySQL
     */
    public String respuestaCorrecta;

    /**
     * metodo que permite obtener la respuesta correcta
     * @autor jhosep11
     * @returnrespuestaCorrecta
     */
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    /**
     * metodo que permite actualizar el valor del atributo respuestaCorrecta
     *  * @autor jhosep11
     * @param respuestaCorrecta
     */
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }


    /**
     * @jorgeMontoya
     * se crean los atributos Final que no se pueden cambiar porque son las credenciales que
     * nos permiten conectarnos a la base de datos
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String USER = "root";

    private static final String PASSWORD = "admin";

    private static final String URL = "jdbc:mysql://localhost/preguntas_respuestas?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true";


    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error en el driver" + e);
        }
    }

    /**
     * @author jorgeMontoya
     *
     * se crea metodo para establecer la conecion a la base de datos pasando como parametros
     * las credenciales.
     * @return connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection failed" + e);
        }
        return connection;
    }
    private static final Connection CONNECTION = getConnection();
    final PrintStream PRINT_STREAM = new PrintStream(System.out);

    /**
     * @author jorgeMontoya
     *  @autor jhosep11
     * metodo que permite obtener una pregunta de la base de datos  por medio de un idRandom que entra como parametro, la pregunta se obtiene
     * mediante una sentencia Sql.
     * @param idRandom entra el  un numero aleatorio para relacionarlo con el id de la pregunta
     * @return salidaConsulta
     */
    public String getpregunta (int idRandom) {

        String query = "SELECT * FROM preguntas_respuestas.preguntas WHERE id = ?";
        ResultSet resultadoQuery;
        String salidaConsulta= "";
        try (PreparedStatement preParacionQuery = CONNECTION.prepareStatement(query)) {
            preParacionQuery.setInt(1, idRandom);
            resultadoQuery = preParacionQuery.executeQuery();

            if(resultadoQuery.next()) {
                String pregunta = resultadoQuery.getString("pregunta");

                salidaConsulta = pregunta;
                //escribirEnConsola.info(pregunta);
           // salidaConsulta = resultadoQuery.getString("pregunta");


            }
        } catch (SQLException e) {

            escribirEnConsola.info(e);
        }
        return salidaConsulta;

    }

    /**
     * @autor jhosep11
     * metodo que permite obtener las opciones de respuesta relacionadas a la pregunta correspondiente
     * se realiza por medio de un idpregunta que entra como parametro, la pregunta se obtiene
     * mediante una sentencia Sql.
     * @param idpregunta entra como parametro el id de la pregunta necesario para hacer la consulta a la base de datos
     * @return salidaConsulta
     */
    public String getOpciones (int idpregunta) {

        String query = "SELECT * FROM preguntas_respuestas.opciones_respuesta  WHERE idpregunta = ?";
        ResultSet resultadoQuery;
        String salidaConsulta= "";
        try (PreparedStatement preParacionQuery = CONNECTION.prepareStatement(query)) {
            preParacionQuery.setInt(1, idpregunta);
            resultadoQuery = preParacionQuery.executeQuery();

            while (resultadoQuery.next()) {
                String letra = resultadoQuery.getString("letra");
                String textpOpcion= resultadoQuery.getString("descripción");
                int respuestaCorrescta = resultadoQuery.getInt("respuestacorrecta");
                if(respuestaCorrescta==1){
                    this.setRespuestaCorrecta(letra);
                }

                salidaConsulta += letra+"."+textpOpcion+"¡";
                //escribirEnConsola.info(salidaConsulta);
                // salidaConsulta = resultadoQuery.getString("pregunta");


            }
        } catch (SQLException e) {

            escribirEnConsola.info(e);
        }
        return salidaConsulta;



    }


    /**
     * @author jorgeMontoya
     * metodo para ingresar el nombre del jugador y los puntos obtenidos en la ronda de juego.
     * @param jugador
     */
    public void CargarHistoricoUsuario(Jugador jugador) {

        String query = "INSERT INTO   preguntas_respuestas.historicousuario (nombreJugador,puntos) VALUES(?,?)";

        try (PreparedStatement ps = CONNECTION.prepareStatement(query)) {

            ps.setString(1,jugador.getNombreJugador());
            ps.setInt(2,jugador.getPuntos());
            ps.executeUpdate();
            escribirEnConsola.info("CONTACT CREATED SUCCESSFULLY");
        }
        catch (SQLException e) {
            escribirEnConsola.info(e);
        }
    }


    /**
     * @author jorgeMontoya
     * metodo que permite obtener los datos de la tabla historico nombre del jugador y puntos; posteriormente  se  pueden mostrar al usuario cuando
     * lo requieran
     * @return nombre, puntaje
     */

    public String getHistorico() {

        String query = "SELECT * FROM preguntas_respuestas.historicousuario ";
        ResultSet resultadoQuery;
        String salidaConsulta= "";
        try (PreparedStatement preParacionQuery = CONNECTION.prepareStatement(query)) {

            resultadoQuery = preParacionQuery.executeQuery();

            while (resultadoQuery.next()) {
                String nombreJugador = resultadoQuery.getString("nombreJugador");
                String puntos = resultadoQuery.getString("puntos");


                salidaConsulta += "Nombre: "+nombreJugador+" Puntaje: "+puntos+"¡";



            }
        } catch (SQLException e) {

            escribirEnConsola.info(e);
        }
        return salidaConsulta;

    }

}
