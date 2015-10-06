/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.index;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 *
 * @author Thibault Piront
 */
public class IndexRepository {
    private static final String INDEX_PATH = "index.bin";
    
    // index file specification:
    //
    // description : <entry>
    //     100 bytes -- (utf8) key
    //     16 bytes  -- (ascii) address
    // 
    // content
    //     [<entry>...]
    
    public void saveIndex(IIndex index) throws IOException {
        Path output = Paths.get(INDEX_PATH);
        
        // @todo it breaks the file when exception occurs in the middle..
        // @note compact each IO calls into one
        
        Files.deleteIfExists(output);
        Files.createFile(output);
        
        for (IndexEntry entry: index) {
            String key = entry.getKey();
            byte[] binaryKey = key.getBytes(StandardCharsets.UTF_8);
            binaryKey = Arrays.copyOf(binaryKey, 100);
            Files.write(output, binaryKey, StandardOpenOption.APPEND);
            
            String address = entry.getAddress();
            byte[] binaryAddress = address.getBytes(StandardCharsets.US_ASCII);
            binaryAddress = Arrays.copyOf(binaryAddress, 16); // @note should be useless
            Files.write(output, binaryAddress, StandardOpenOption.APPEND);
        }
    }
    
    public IIndex loadIndex() throws IOException {
        Index index = new Index();
        Path input = Paths.get(INDEX_PATH);
        
        byte[] content = Files.readAllBytes(input);
        int ptr = 0;
        while (ptr < content.length) {
            // @todo check buffer overflow

            byte[] binaryKey = Arrays.copyOfRange(content, ptr, ptr + 100);
            byte[] binaryAddress = Arrays.copyOfRange(content, ptr+100, ptr+116);
            
            IndexEntry indexEntry = new IndexEntry(binaryKey, binaryAddress);
            index.add(indexEntry);

            ptr += 116;
        }
        
        return index;
    }
    
}
