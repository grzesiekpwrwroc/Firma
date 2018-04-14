import java.awt.*;

public class Test {
    public static void main(String[] args) {
        Pliki.odczytajPlik();
        EventQueue.invokeLater(() -> new MainFrame());
    }
}