import java.awt.*;

public class Test {
    public static void main(String[] args) {
        Files.readFile();
        EventQueue.invokeLater(() -> new MainFrame());
    }
}