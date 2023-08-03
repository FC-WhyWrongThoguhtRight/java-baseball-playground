import ui.MainUI;

public class App {
    public static void main(String[] args) {
        try {
            MainUI.getInstance().service();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
