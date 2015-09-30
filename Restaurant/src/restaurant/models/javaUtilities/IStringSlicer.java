/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.javaUtilities;

import java.util.Iterator;

/**
 *
 * @author MAZE2
 */
public interface IStringSlicer {

    /**
     * la taille du dernier string par rapport aux dernier renseigne sur son
     * commencement et son indice de fin
     */
    void addLength(int length);

    void addLengths(Object o);

    boolean isRunning();

    Iterator<String> iteratorFromStringBuilder(String string);

    void reset();

    void stop();
    
}
