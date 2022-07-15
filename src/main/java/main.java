import org.jboss.logging.Logger;
import java.io.PrintStream;

public class main {
    public static void main(String[] args) {

        MySQL conection = new MySQL();

        try {
            conection.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        conection.getpregunta("4");


    }
}
