/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeskOrganizer.utils;

import DeskOrganizer.exception.ExceptionHandler;
import DeskOrganizer.utils.Consts; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class Util {

    public static void showMessageWarning(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public static void showMessageSucess(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.PLAIN_MESSAGE);
    }

    public static String nvl(String valor, String defaultString) {
        return valor != null ? valor : (defaultString == null ? "" : defaultString);
    }

    public static boolean salvarArquivos(String desktopPath, String arqNome, LinkedHashMap<String, String> arquivo) {

        try {
            criarPastaSeNaoExistir(desktopPath);
            File f = new File(desktopPath +"\\"+ arqNome);

            if (!f.exists()) {
                f.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arquivo);
            oos.close();
            fos.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            new ExceptionHandler(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            new ExceptionHandler(ex.getMessage());
        }
        return false;
    }

    public static boolean isArquivoConfigurado(String caminho, String arq) {
        LinkedHashMap<String, String> listaProgramas = lerArquivos(caminho, arq);
        return listaProgramas != null ? !listaProgramas.isEmpty() : false;
    }

    public static LinkedHashMap<String, String> lerArquivos(String caminho, String arq) {
        try {
            criarPastaSeNaoExistir(caminho);
            File f = new File(caminho + "\\" + arq);
            if(!f.exists()){
                return null;
            }
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedHashMap<String, String> Arquivo = (LinkedHashMap<String, String>) ois.readObject();
            ois.close();
            fis.close();
            return Arquivo;
        } catch (Exception e) {
            new ExceptionHandler(e.getMessage());
        }
        return null;
    }

    public static boolean isCaminhoVazio(final String caminho) {
        File f = new File(caminho);
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(f.toPath())) {
            return !dirStream.iterator().hasNext();
        } catch (IOException ex) {
            new ExceptionHandler(ex.getMessage());
        }
        return false;
    }

    public static boolean criarPastaSeNaoExistir(String desktopPath) {
        File f = new File(desktopPath);
        if (!f.exists()) {
            return f.mkdir();
        }
        return true;
    }
}
