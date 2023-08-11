import dispatcher.Dispatcher;

public class App {
    public static void main(String[] args) {
        Dispatcher dispatcher = Dispatcher.getInstance();

        try {
            dispatcher.service();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
