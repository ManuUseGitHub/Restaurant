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
public class StringBuilderUtility implements IStringBuilderUtility {

    private final StringBuilder SB;
    private final StringSlicer slicer = new StringSlicer();;
    
    private static final StringBuilderUtility INSTANCE = new StringBuilderUtility();

    private StringBuilderUtility() {
        SB = new StringBuilder();
    }

    //<editor-fold defaultstate="collapsed" desc="advanced services">
    @Override
    public void clear() {
        SB.setLength(0);
    }

    @Override
    public String toString() {
        return String.format("SINGLETON %s", StringBuilderUtility.class.getName());
    }

    @Override
    public String getString() {
        return SB.toString();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="special appends">
    public void appendAll(String... strings) {
        for (String s : strings) {
            SB.append(s);
            slicer.addLengths(s);
        }
    }

    @Override
    public void appendAll(Object... elements) {
        for (Object s : elements) {
            SB.append(s);
            slicer.addLengths(s);
        }
    }

    @Override
    public void appendLine(String string) {
        SB.append(string).append("\r\n");
        slicer.addLength(string.length());
        slicer.addLength(1);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Traditional appends">
    @Override
    public void append(String string) {
        SB.append(string);
        slicer.addLength(string.length());
    }

    @Override
    public void append(char c) {
        SB.append(c);
        slicer.addLength(1);
    }

    @Override
    public void append(CharSequence[] cs) {
        SB.append(cs);
        slicer.addLength(cs.length);
    }
    //</editor-fold>
    
    public static void setNormalMode(){
        INSTANCE.slicer.stop();
    }
    //<editor-fold defaultstate="collapsed" desc="getInstances">
    public static StringBuilderUtility getInstance() {
        return INSTANCE;
    }

    public static StringBuilderUtility getClearInstance() {
        INSTANCE.SB.setLength(0);
        return INSTANCE;
    }

    public static StringBuilderUtility getInstanceToIterateOn() {
        if (!INSTANCE.slicer.isRunning()) {
            INSTANCE.slicer.reset();
        }
        return INSTANCE;
    }

    public static StringBuilderUtility getClearInstanceToIterateOn() {
        INSTANCE.SB.setLength(0);
        INSTANCE.slicer.reset();
        return INSTANCE;
    }
    //</editor-fold>

    public Iterator<String> iterator() {
        return slicer.iteratorFromStringBuilder(SB.toString());
    }
}
