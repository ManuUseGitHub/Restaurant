package restaurant.models.work;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import restaurant.models.Consommable;
import restaurant.models.javaUtilities.StringBuilderUtility;

public class Menu extends Consommable implements IMenu {

    private EnumMap<TypePlat, List<String>> etapes;

    public Menu() {
        super();
        setNewEtapes(); // défniti les étapes du menu
    }

    public Menu(long id,String nom, float prix) {
        super(id,nom, prix);

        this.setId(nom.hashCode());
        this.setNewEtapes(); // défniti les étapes du menu
    }
    
    @Override
    public String toString(){
        return String.format("Plat=> [id:%d]\t [nom:%s]\t [prix:%f]\n[Est composé de :%s]\n",getId(),this.getNom(),this.getPrix(),"plats");
    }

    private String toStringSteps(TypePlat step){
        StringBuilderUtility builderU = StringBuilderUtility.getInstanceToIterateOn();
        etapes.get(step).stream().forEach((dish)->{
            builderU.appendAll(dish,";");
        });
        return builderU.getString();
    }

    @Override
    public ArrayList<String> getSteps(TypePlat step) {
        return (ArrayList<String>)etapes.get(step);
    }
    @Override
    public void setSteps(TypePlat step,List<String> ingredients) {
        etapes.put(step, ingredients);
    }

    /**
     * initialise la map des étapes du menu
     */
    private void setNewEtapes() {
        etapes = new EnumMap<>(TypePlat.class);
        for(TypePlat t : TypePlat.values()){
            etapes.put(t, new ArrayList<>());
        }
    }

}
