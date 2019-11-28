package audio;

import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JPopupMenu;

public class Mouse {
    
    public void botaoDireito(MouseEvent evt, JDesktopPane jDesktopPane, JPopupMenu menu)
    {
        menu.show(jDesktopPane, evt.getX(), evt.getY()+20);
    }
    
    public void botaoEsquerdo(MouseEvent evt, JFileChooser chooser)
    {
        chooser.setMultiSelectionEnabled(true);
        JInternalFrame frame = new JInternalFrame();
        chooser.showOpenDialog(frame);
        

    }
   
    
}
