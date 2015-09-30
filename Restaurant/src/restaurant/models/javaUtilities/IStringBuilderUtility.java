/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.javaUtilities;

/**
 *
 * @author MAZE2
 */
public interface IStringBuilderUtility {

    void append(String string);

    void append(char c);
    
    void append(CharSequence[] cs);
    
    void appendAll(Object... elements);

    void appendLine(String string);
    
    void clear();

    String getString();
    
}
