import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

/**
 * Created by md on 2018-04-14.
 */
public class ClickListener implements MouseListener {

    private Consumer<MouseEvent> _mouseClicked;

    public ClickListener(Consumer<MouseEvent> mouseClicked){
        _mouseClicked = mouseClicked;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        _mouseClicked.accept(e);
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
