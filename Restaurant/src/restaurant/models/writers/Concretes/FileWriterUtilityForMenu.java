/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers.Concretes;

import java.util.ArrayList;
import java.util.Iterator;
import restaurant.models.javaUtilities.IStringBuilderUtility;
import restaurant.models.javaUtilities.StringBuilderUtility;
import restaurant.models.work.IMenu;
import restaurant.models.work.Menu;
import restaurant.models.work.TypePlat;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.FolderWriter;
import restaurant.models.writers.generics.IWriter;
import restaurant.models.writers.generics.Writer;

/**
 *
 * @author MAZE2
 */
public class FileWriterUtilityForMenu {

    private final IWriter menuW;
    private IMenu menu;

    public FileWriterUtilityForMenu(String filePath) {
        menuW = new FileWriter(filePath);
    }

    public FileWriterUtilityForMenu(Menu menu) {
        this(String.format("Exemples\\menusGenerated\\%d\\%s", menu.getId(), menu.getNom()));
        this.menu = menu;
    }

    private void completeMenuLines(IStringBuilderUtility builder) {

//        on ne fait que parcourir la liste des ingrédients.
//        Donc on va utiliser un iterator et permettre le changement
//        de la collection utilisée sans devoir affecter le code ci-après
        
        for(TypePlat t : TypePlat.values()) {
            builder.append("\t\t"+t.toString()+":");
            Iterator<String> navigator = menu.getSteps(t).iterator();
            while (navigator.hasNext()) {
                builder.append("\t\t\t" + navigator.next());
            }
        }
        //elements.add("\u001a"); // EOF

    }

    private Iterator<String> dishToIterator() {
        
        StringBuilderUtility builderU = StringBuilderUtility.getClearInstanceToIterateOn();
        
        builderU.appendAll(
                "Menu",
                "\t\tId:"+ menu.getId(),
                "\t\tName:" + menu.getNom(),
                "\t\tPrice:" + menu.getPrix());
        completeMenuLines(builderU);

        return builderU.iterator();
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
            status = menuW.write(dishToIterator());
        }
        return status;
    }

    public void setMenu(IMenu menu) {
        this.menu = menu;
    }
}
