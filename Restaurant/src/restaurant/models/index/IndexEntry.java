/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.index;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 *
 * @author Thibault Piront
 */
public class IndexEntry {
    private String key;
    private String address;
    
    public IndexEntry(String key) {
        this.key = key;
        this.address = generateUUID();
    }
    
    // @todo move to repository
    public IndexEntry(byte[] utf8Key, byte[] asciiAddress) {
        key = new String(utf8Key, StandardCharsets.UTF_8);
        address = new String(asciiAddress, StandardCharsets.US_ASCII);
    }
    
    public String getKey() {
        return key;
    }
    public String getAddress() {
        return address;
    }

    private String generateUUID() {
        UUID uuid = UUID.randomUUID();
        
        return uuid.toString();
    }
}
