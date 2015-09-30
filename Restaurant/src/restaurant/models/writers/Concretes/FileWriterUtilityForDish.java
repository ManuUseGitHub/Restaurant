/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers.Concretes;

//Contient les classes Files, Paths, etc.
import java.util.Iterator;
import restaurant.models.javaUtilities.StringBuilderUtility;
import restaurant.models.work.Dish;
import restaurant.models.work.IPlat;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.FolderWriter;
import restaurant.models.writers.generics.IWriter;
import restaurant.models.writers.generics.Writer;

public class FileWriterUtilityForDish {

    private IPlat dish;
    private final IWriter dishW;

    public FileWriterUtilityForDish(String filePath) {
        dishW = new FileWriter(filePath);
    }

    public FileWriterUtilityForDish(Dish dish) {
        this(String.format("generated\\%d\\%s",dish.getId(),dish.getNom()));
        this.dish = dish;
    }

    private void completeIngredients(StringBuilderUtility builderU) {

//        on ne fait que parcourir la liste des ingrédients.
//        Donc on va utiliser un iterator et permettre le changement
//        de la collection utilisée sans devoir affecter le code ci-après
        Iterator<String> navigator = dish.getIngredients().iterator();
        while (navigator.hasNext()) {
            builderU.append("\t\t\t" + navigator.next());
        }
        //elements.add("\u001a"); // EOF

    }

    private Iterator<String> dishToIterator() {
        StringBuilderUtility builderU = StringBuilderUtility.getClearInstanceToIterateOn();
        builderU.appendAll(
                "Plat",
                "\t\tId:" + dish.getId(),
                "\t\tName:" + dish.getNom(),
                "\t\tPrice:" + dish.getPrix(),
                "\t\tIngredients:");
        completeIngredients(builderU);

        return builderU.iterator();
    }

    public Writer.WriteStatus write() {
        Writer.WriteStatus status;
        if (dish == null) {
            return Writer.WriteStatus.TERMINATE_BADLY.addMessage("Dish is null ...");
        }

        FolderWriter folderW = new FolderWriter();
        String path = ((FileWriter)dishW).getFolderPath();
        folderW.setPath(path);

        if ((status = folderW.write(dishW.getPath())) == Writer.WriteStatus.SUCEED) {
            status = dishW.write(dishToIterator());
        }
        return status;
    }

    /**
     * @param dish the dish to set
     */
    public void setDish(IPlat dish) {
        this.dish = dish;
    }
}
