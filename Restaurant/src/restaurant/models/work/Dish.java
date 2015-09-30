/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.work;

import java.util.ArrayList;
import java.util.List;
import restaurant.models.Consommable;
import restaurant.models.javaUtilities.StringBuilderUtility;

/**
 *
 * @author MAZE2
 */
public class Dish  extends Consommable implements IPlat{
    private long id;
    private String name;
    private float price;
    private ArrayList<String> ingredients;
    
    public Dish(long id,String name,float price,ArrayList<String> ingredients){
        super(id,name,price);
        this.ingredients = ingredients;
    }
    public Dish(String name,float price,ArrayList<String> ingredients){
        this(name.hashCode(),name,price,ingredients);
    }

    public Dish() {
        ingredients = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        return String.format("Plat=> [id:%d]\t [nom:%s]\t [prix:%f]\n[Est composé de :%s]\n",id,name,price,toStringIngredients());
    }

    private String toStringIngredients(){
        StringBuilderUtility builderU = StringBuilderUtility.getClearInstance();
        ingredients.stream().forEach((ingr)->{
            builderU.appendAll(ingr,";");
        });
        return builderU.getString();
    }
    @Override
    public List<String> getIngredients() {
        return ingredients;
    }
    @Override
    public void setIngredients(List<String> ingredients) {
        this.ingredients = (ArrayList<String>)ingredients;
    }
}
