/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers.Concretes;

import java.util.ArrayList;
import java.util.Iterator;
import restaurant.models.work.Menu;
import restaurant.models.work.TypePlat;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.FolderWriter;
import restaurant.models.writers.Writer;

/**
 *
 * @author MAZE2
 */
public class FileWriterUtilityForMenu {

    private final Writer menuW;
    private Menu menu;

    public FileWriterUtilityForMenu(String filePath) {
        menuW = new FileWriter(filePath);
    }

    public FileWriterUtilityForMenu(Menu menu) {
        this(String.format("Exemples\\menusGenerated\\%d\\%s", menu.getId(), menu.getNom()));
        this.menu = menu;
    }

    public Writer.WriteStatus write() {
        Writer.WriteStatus status;
        if (menu == null) {
            return Writer.WriteStatus.TERMINATE_BADLY.addMessage("menu is NULL ...");
        }

        FolderWriter folderW = new FolderWriter();
        String path = ((FileWriter) menuW).getFolderPath();
        folderW.setPath(path);

        if ((status = folderW.write(menuW.getPath())) == Writer.WriteStatus.SUCEED) {
            status = menuW.write(menu.iterator());
        }
        return status;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
