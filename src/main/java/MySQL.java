import com.mysql.cj.xdevapi.Statement;
import org.jboss.logging.Logger;

import javax.swing.*;
import java.io.PrintStream;
import java.sql.*;

public class MySQL {

    Logger escribirEnConsola = Logger.getLogger(MySQL.class) ;


    public String respuestaCorrecta;

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

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

    /* @Override
    public void historicoUsuarios(Jugador jugador)  {
        String query = "SELECT * FROM charactersprofile";
        ResultSet rs;

        try (PreparedStatement ps = CONNECTION.prepareStatement(query)) {

            PRINT_STREAM.printf("%-6s%-6s%-20s", "id", "nombreJugador", "puntos");
            rs = ps.executeQuery();
            while (rs.next()) {
                PRINT_STREAM.printf("%-6s%-6s%-20s%-20s%n", rs.getInt("id"), rs.getInt("idApi"), rs.getString("name"), rs.getString("description"));
            }

        } catch (SQLException e) {
            escribirEnConsola.info(e);
        }
    }
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
