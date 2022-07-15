import org.jboss.logging.Logger;
public class main {
    public static void main(String[] args) {
     MySQL conection = new MySQL();

        try {
            conection.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }

        conection.getpregunta("1");

    }
}
