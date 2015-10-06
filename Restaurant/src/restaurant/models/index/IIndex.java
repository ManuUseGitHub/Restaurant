/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.index;


/**
 *
 * @author Thibault Piront
 */
public interface IIndex extends Iterable<IndexEntry> {
    public void add(IndexEntry indexEntry);
}
