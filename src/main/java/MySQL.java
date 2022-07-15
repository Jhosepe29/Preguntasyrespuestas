import com.mysql.cj.xdevapi.Statement;
import org.jboss.logging.Logger;

import javax.swing.*;
import java.io.PrintStream;
import java.sql.*;

public class MySQL {

    Logger escribirEnConsola = Logger.getLogger(MySQL.class) ;



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
        ResultSet rs;
        String salidaConsulta= "";
        try (PreparedStatement ps = CONNECTION.prepareStatement(query)) {
            ps.setInt(1, idRandom);
            rs = ps.executeQuery();

            if(rs.next()) {
                String salidaConsult = rs.getString("id");
                String pregunta = rs.getString("pregunta");

                salidaConsulta = pregunta;
                escribirEnConsola.info(pregunta);
            salidaConsulta = rs.getString("pregunta");


            }
        } catch (SQLException e) {

            escribirEnConsola.info(e);
        }
        return salidaConsulta;

    }




}
