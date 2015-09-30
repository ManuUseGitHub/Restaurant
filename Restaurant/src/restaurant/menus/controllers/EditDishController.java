package restaurant.menus.controllers;

import java.util.ArrayList;
import java.util.List;
import restaurant.core.Controller;
import restaurant.menus.views.messages.MessagesForWriting;
import restaurant.models.work.Dish;
import restaurant.models.writers.Concretes.FileWriterUtilityForDish;
import restaurant.models.writers.generics.Writer;

/**
 *
 * @author Nicolas
 */
public class EditDishController extends Controller {

    public interface EditDishWindow {

        void setController(EditDishController controller);

        String getName();

        void setName(String value);

        void setErrorForName(String value);

        void setPrice(float value);

        float getPrice();

        void setErrorForPrice(String value);

        List<String> getIngredients();

        void setIngredients(List<String> value);

        void setErrorForIngredients(String value);

        void show();

        void hide();
    }

    private EditDishWindow window;

    public EditDishController(EditDishWindow editDishWindow) {
        this.setWindow(editDishWindow);
    }

    public EditDishWindow getWindow() {
        return window;
    }

    public void setWindow(EditDishWindow window) {
        this.window = window;
        this.window.setController(this);
    }

    public void saveEvent() {
        
        Dish dish = new Dish(
                window.getName().hashCode(),
                window.getName(),
                window.getPrice(),
                (ArrayList<String>)window.getIngredients());
        
        FileWriterUtilityForDish writer = new FileWriterUtilityForDish(dish);
        
        Writer.WriteStatus status = writer.write();
        MessagesForWriting.showMessage(status);
        
        if(status == Writer.WriteStatus.SUCEED){
            window.hide();
        }
        
    }

    public void cancelEvent() {
        this.window.hide();
    }

    @Override
    public void handleNavigation(Object args) {
        this.window.show();
    }
}
