/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pakkapon
 */
public class ImageReading {
    public static void main(String[] args){
        BufferedImage img = null;
        try {
            File imgFile = new File("images/classical_building_small_gray.png");
            img = ImageIO.read(imgFile);
            System.out.print(""+img.getWidth()+"x"+img.getHeight());
        } catch(IOException ex) {
            System.err.println("Error loading image");
        }
    }
    
}
