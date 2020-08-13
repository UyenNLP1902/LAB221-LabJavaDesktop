/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uyen.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author SE140355
 */
public class FileHelper {

    public static void saveFile(String content, String filepath) throws FileNotFoundException {
        try (PrintWriter fw = new PrintWriter(new FileOutputStream(filepath), true)) {
            String s[] = content.split("\n");
            for (int i = 0; i < s.length; i++) {
                String string = s[i];
                fw.print(string + "\r\n");
            }
        }
    }

    public static void loadFile(JFileChooser file, JTextArea txtText) throws FileNotFoundException {
        txtText.setText("");
        Scanner scan = new Scanner(new FileReader(file.getSelectedFile().getPath()));
        while (scan.hasNext()) {
            txtText.append(scan.nextLine() + "\n");
        }
    }
}
