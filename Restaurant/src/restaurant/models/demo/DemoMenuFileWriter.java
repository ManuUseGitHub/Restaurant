/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.demo;

import restaurant.models.work.Menu;
import restaurant.models.writers.Concretes.FileWriterUtilityForMenu;
import restaurant.models.writers.generics.Writer;

/**
 *
 * @author MAZE2
 */
public class DemoMenuFileWriter {

    public static void main(String[] args) throws Exception {
        
        String name = "Super menu d'exe"; 
        Menu menu = new Menu(name.hashCode(),name,5.5f);
        
        String outFilePath = String.format("Exemples\\menusGenerated\\%d\\%s",menu.getId(),menu.getNom());

        FileWriterUtilityForMenu writer = new FileWriterUtilityForMenu(outFilePath);
        writer.setMenu(menu);
        Writer.WriteStatus status;

        if ((status = writer.write()) == Writer.WriteStatus.OUT_FILE_PATH_NOT_FOUND) {
            throw new Exception(String.format("Le fichier à l'adresse :%s est introuvable", outFilePath));

        } else {
            System.out.println(status);
        }

    }
}
