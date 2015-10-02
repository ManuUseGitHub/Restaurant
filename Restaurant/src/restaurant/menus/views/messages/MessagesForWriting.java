package restaurant.menus.views.messages;

import javax.swing.JOptionPane;
import restaurant.models.writers.Writer;

/**
 *
 * @author MAZE2
 */
public class MessagesForWriting {

    public static void showMessage(Writer.WriteStatus status) {

        String title;
        int iconMessageBox;
        switch (status) {
            case OUT_FILE_PATH_NOT_FOUND:
                title = "erreur de fichier";
                iconMessageBox = JOptionPane.ERROR_MESSAGE;
                break;
            case SUCEED:
                title = "Opération réussie";
                iconMessageBox = JOptionPane.INFORMATION_MESSAGE;
                break;
            default:
                title = "erreur inconnue";
                iconMessageBox = JOptionPane.ERROR_MESSAGE;
                break;
        }
        javax.swing.JOptionPane.showMessageDialog(null, status.getMessage(), title, iconMessageBox);
    }
}
