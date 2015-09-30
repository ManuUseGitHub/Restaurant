/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.models.writers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import restaurant.models.javaUtilities.PathTranslator;
import restaurant.models.javaUtilities.StringBuilderUtility;
import restaurant.models.writers.generics.Writer;

/**
 *
 * @author MAZE2
 */
public class FileWriter extends Writer {

    public FileWriter(String path) {
        super(path);
    }

    public String getFolderPath() {
        StringBuilderUtility builderU = StringBuilderUtility.getClearInstance();
        String[] subs = path.split("\\\\");// \ doit être échapé => \\ pour signifier le caractère '\' mais en regex, il faut aussi échapper donc \\\\ 
        for (int i = 0, t = subs.length - 1; i < t; ++i) {
            builderU.appendAll(subs[i], i < t - 1 ? "\\" : "");
        }
        return PathTranslator.translate(builderU.getString());
    }

    @Override
    public WriteStatus write(Iterator<String> contenu) {
        Path outFilePath = Paths.get(getPath());
        try (final OutputStreamWriter out = new OutputStreamWriter(Files.newOutputStream(outFilePath, StandardOpenOption.CREATE), "UTF-8")) {
            while (contenu.hasNext()) {
//                if (!contenu.next().equals("\u001a")) {
                    String line = contenu.next() + "\r\n";
                    out.write(line);
//                }
//                else{
//                    out.write("\u001a".getBytes());
//                }
            }
            return WriteStatus.SUCEED;
        } catch (IOException ex) {
            return WriteStatus.OUT_FILE_PATH_NOT_FOUND.addMessage(ex.getMessage());
        } catch (Exception ex) {
            return WriteStatus.TERMINATE_BADLY.addMessage(ex.getMessage());
        }
    }

    @Override
    public WriteStatus write(String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
