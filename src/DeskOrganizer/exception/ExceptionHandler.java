/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeskOrganizer.exception;

import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class ExceptionHandler extends Exception {

 
    public ExceptionHandler(String mensagem) {
        super(mensagem);
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.ERROR_MESSAGE);  
        this.printStackTrace();
                
    }
    
}
