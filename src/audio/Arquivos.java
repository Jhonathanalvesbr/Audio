package audio;

import java.io.File;
import javax.swing.JFileChooser;

public class Arquivos {

    
    void selecionarArquivos(JFileChooser chooser, FrameP frame)
    {
        chooser.showOpenDialog(frame);
        File[] files = chooser.getSelectedFiles();
    }
}
