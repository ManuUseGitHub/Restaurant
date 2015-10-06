/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.index;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Thibault Piront
 */
public class Index implements IIndex {
    
    private final List<IndexEntry> entries;
    
    public Index() {
        entries = new ArrayList<>();
    }
    
    @Override
    public void add(IndexEntry indexEntry) {
        entries.add(indexEntry);
    }
    
    @Override
    public Iterator<IndexEntry> iterator() {
        return entries.iterator();
    }
}
