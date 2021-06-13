/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeskOrganizer;

import DeskOrganizer.exception.ExceptionHandler;
import DeskOrganizer.views.TelaInicial;
import com.bulenkov.darcula.DarculaLaf; 
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 *
 * @author Eduardo
 */
public class DesktopOrganizador {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        BasicLookAndFeel darcula = new DarculaLaf();
        UIManager.setLookAndFeel(darcula);
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaInicial tela = new TelaInicial();
                tela.setVisible(true);
                try {
                    tela.verificacaoInicial();
                } catch (IOException ex) {
                    new ExceptionHandler(ex.getMessage());
                }
            }
        });
    }

}
