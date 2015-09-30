/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers.generics;

import java.util.Iterator;

/**
 *
 * @author MAZE2
 */
public interface IWriter {

    String getPath();

    void setPath(String path);

    Writer.WriteStatus write(Iterator<String> content);
    
    Writer.WriteStatus write(String content);
    
}