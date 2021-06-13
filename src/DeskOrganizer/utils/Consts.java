/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeskOrganizer.utils;

/**
 *
 * @author Eduardo
 */
public class Consts {

    public static String configuracaoUsuario = System.getProperty("user.name").equals("Eduardo") ? "Pichau" : System.getProperty("user.name");
    public static String caminhoArquivo = ("C:\\Users\\" + configuracaoUsuario + "\\Desktop" + "\\Conf");
    public static String arquivo = "ArquivoConf.conf";

    public static void setArquivo(String arquivo) {
        Consts.arquivo = arquivo;
    }

    public static void setConfiguracaoUsuario(String configuracaoUsuario) {
        Consts.configuracaoUsuario = configuracaoUsuario;
    }

    public static void setCaminhoArquivo(String caminhoArquivo) {
        Consts.caminhoArquivo = caminhoArquivo;
    }

    private static Consts instance;
    public String valor;

    private Consts(String value) {
        // The following code emulates slow initialization.
        this.valor = value;
    }

    public static Consts getInstance(String value) {
        if (instance == null) {
            instance = new Consts(value);
        }
        return instance;
    }

}
