/**
 */
package edu.uvg.program;


/**
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author chama
 *
 */

public class TextFileManager {

    /**
     * This method separate the txt. file by lines.
     * 
     * @param path this is the path where is located the .txt file with the
     *             expressions
     * @return arraylist string od the txt file separated by lines
     * @throws Exception 
     */
    public ArrayList<String> daReader(String path) throws Exception {

        String line;
        ArrayList<String> lines = new ArrayList<String>();

        if (getExtension(path).equals("txt")) {

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }

                return lines;

            } catch (Exception e) {
            	throw new Exception("Critical! File not Found.");
            }
        } else {
        	throw new Exception("Critical! Incorrect file type.");
        }
    }

    /**
     * This method can extract the type file of a path.
     * 
     * @param path this is the chain that will verify
     * @return String return the extension of the file
     */
    public String getExtension(String path) {
        String extension = "";

        int i = path.lastIndexOf('.');
        if (i >= 0) {
            extension = path.substring(i + 1);
        }

        
        return extension;
    }

}
