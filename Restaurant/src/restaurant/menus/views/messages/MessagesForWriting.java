package restaurant.menus.views.messages;

import javax.swing.JOptionPane;
import restaurant.models.writers.generics.Writer;

/**
 *
 * @author MAZE2
 */
public class MessagesForWriting {

    public static void showMessage(Writer.WriteStatus status) {

        switch (status) {
            case OUT_FILE_PATH_NOT_FOUND:
                javax.swing.JOptionPane.showMessageDialog(null, "Le fichier à l'adresse specifié est introuvable",
                        "erreur de fichier", JOptionPane.ERROR_MESSAGE);
                break;
            case SUCEED:
                javax.swing.JOptionPane.showMessageDialog(null, "Plat ajouté",
                        "Opération réussie", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(null, String.format("Une erreur inconnue s'est produite, type:%s", status.toString()),
                        "erreur inconnue", JOptionPane.ERROR_MESSAGE);
                break;
        }

    }
}
