import java.awt.*;

public class Test {
    public static void main(String[] args) {
        Pliki.odcztajPlik();
        EventQueue.invokeLater(() -> new MainFrame());
    }
}