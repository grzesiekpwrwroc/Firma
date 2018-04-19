import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;


public class ClickListener implements MouseListener {

    private Consumer<MouseEvent> mouseClicked;

    public ClickListener(Consumer<MouseEvent> mouseClicked){
        this.mouseClicked = mouseClicked;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseClicked.accept(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
