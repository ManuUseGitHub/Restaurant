/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.demo;

import java.util.Iterator;
import restaurant.models.javaUtilities.StringBuilderUtility;

/**
 *
 * @author MAZE2
 */
public class DemoIterableStringBuilder {
    public static void main(String[] args){
        StringBuilderUtility u = StringBuilderUtility.getClearInstanceToIterateOn();
        u.append("hello");
        u.appendAll("World",'\n',"How Are you","?");
        
        Iterator<String> iter = u.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next());
        }
    }
}
