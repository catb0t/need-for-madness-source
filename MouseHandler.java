import java.awt.event.MouseEvent;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;

class MouseHandler extends MouseAdapter
{
    private PopupMenu popupMenu;
    int id;
    
    public MouseHandler(final PopupMenu popupMenu, final int id) {
        this.popupMenu = popupMenu;
        this.id = id;
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.popupMenu.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
            Madness.textid = this.id;
            mouseEvent.consume();
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.popupMenu.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
            Madness.textid = this.id;
            mouseEvent.consume();
        }
    }
}
