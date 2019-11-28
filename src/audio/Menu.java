/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audio;

import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Administrador
 */
public class Menu {
    
    Menu(JDesktopPane jDesktopPane, JPopupMenu menu){
        jDesktopPane.add(menu);
        JMenuItem item = new JMenuItem("Item 1");
        menu.add(item);
    }
}
