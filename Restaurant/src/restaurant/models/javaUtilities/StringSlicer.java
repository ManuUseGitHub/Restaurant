/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.javaUtilities;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author MAZE2
 */
public class StringSlicer implements IStringSlicer {

    private ArrayList<Integer> wordsLimits;
    private int index = 0;

    @Override
    public void reset() {
        index = 0;
        wordsLimits = new ArrayList<>();
    }

    @Override
    public boolean isRunning() {
        return wordsLimits != null;
    }

    @Override
    public void stop() {
        wordsLimits = null;
    }

    /**
     * la taille du dernier string par rapport aux dernier renseigne sur son
     * commencement et son indice de fin
     */
    @Override
    public void addLength(int length) {
        if (isRunning()) {
            wordsLimits.add(index += length);
        }
    }

    @Override
    public void addLengths(Object o) {
        if (o instanceof Character) {
            addLength(1);
        } else if (o instanceof CharSequence) {
            addLength(((CharSequence) o).length());
        } else if (o instanceof String) {
            addLength(((String) o).length());
        }
    }

    @Override
    public Iterator<String> iteratorFromStringBuilder(String SB) {
        java.util.ArrayList<String> result = new ArrayList<>();
        int currentIndex = 0;
        for (int i : wordsLimits) {
            result.add(SB.substring(currentIndex, i));
            currentIndex = i;
        }
        return result.iterator();
    }
}
