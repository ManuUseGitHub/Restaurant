/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers.Concretes;

//Contient les classes Files, Paths, etc.
import restaurant.models.work.Dish;
import restaurant.models.writers.FileWriter;
import restaurant.models.writers.FolderWriter;
import restaurant.models.writers.Writer;

public class FileWriterUtilityForDish {

    private Dish dish;
    private final Writer dishW;

    public FileWriterUtilityForDish(String filePath) {
        dishW = new FileWriter(filePath);
    }

    public FileWriterUtilityForDish(Dish dish) {
        this(String.format("Exemples\\generated\\%d\\%s", dish.getId(), dish.getNom()));
        this.dish = dish;
    }

    public Writer.WriteStatus write() {
        Writer.WriteStatus status;
        if (dish == null) {
            return Writer.WriteStatus.TERMINATE_BADLY.addMessage("Dish is null ...");
        }

        FolderWriter folderW = new FolderWriter();
        String path = ((FileWriter) dishW).getFolderPath();
        folderW.setPath(path);

        if ((status = folderW.write(dishW.getPath())) == Writer.WriteStatus.SUCEED) {
            status = dishW.write(dish.iterator());
        }
        return status;
    }

    /**
     * @param dish the dish to set
     */
    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
