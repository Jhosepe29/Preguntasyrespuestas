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






}
