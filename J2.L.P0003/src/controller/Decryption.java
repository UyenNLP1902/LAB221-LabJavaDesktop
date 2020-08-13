/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author SE140355
 */
public class Decryption {

    private static int len = 0;

    public static String decrypt(String imgPath) throws Exception {
        BufferedImage img = readImageFile(imgPath);
        String bitString = decodeTheMessage(img);
        String msg = "";
        for (int i = 0; i < len * 8; i += 8) {
            String subString = bitString.substring(i, i + 8);
            
            int m = Integer.parseInt(subString, 2);
            char ch = (char)m;
            msg += ch;
        }
        return msg;
    }

    private static BufferedImage readImageFile(String imgPath) throws Exception {
        BufferedImage theImage = null;

        File p = new File(imgPath);
        theImage = ImageIO.read(p);
        return theImage;
    }

    private static String decodeTheMessage(BufferedImage yImage) throws Exception {
        String bitMessage = "";
        int j = 0;
        int currentBitEntry = 0;
        String bx_msg = "";
        for (int x = 0; x < yImage.getWidth(); x++) {
            for (int y = 0; y < yImage.getHeight(); y++) {
                if (x == 0 && y < 8) {
                    int currentPixel = yImage.getRGB(x, y);
                    int red = currentPixel >> 16;
                    red = red & 255;
                    int green = currentPixel >> 8;
                    green = green & 255;
                    int blue = currentPixel;
                    blue = blue & 255;
                    String x_s = Integer.toBinaryString(blue);
                    bx_msg += x_s.charAt(x_s.length() - 1);
                    len = Integer.parseInt(bx_msg, 2);

                } else if (currentBitEntry < len * 8) {
                    int currentPixel = yImage.getRGB(x, y);
                    int red = currentPixel >> 16;
                    red = red & 255;
                    int green = currentPixel >> 8;
                    green = green & 255;
                    int blue = currentPixel;
                    blue = blue & 255;
                    String x_s = Integer.toBinaryString(blue);
                    bitMessage += x_s.charAt(x_s.length() - 1);

                    currentBitEntry++;
                }
            }
        }
        return bitMessage;
    }
    
    public static void main(String[] args) throws Exception{
        System.out.println(decrypt("C:\\Users\\HP\\Desktop\\stego.png"));
    }
}
