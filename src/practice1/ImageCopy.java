/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice1;

import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pakkapon
 */
public class ImageCopy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final String inputPath = sc.nextLine();
        final String outputPath = sc.nextLine();
        BufferedImage image = null;
        try {
            File inputFile = new File(inputPath);
            image = ImageIO.read(inputFile);
        } catch(IOException ex) {
            System.err.println("Wrong input");
        }
        try{
            File outputFile = new File(outputPath);
            String[] extractData = outputPath.split("\\.");
            ImageIO.write(image,extractData[extractData.length - 1], outputFile);
        }catch(IOException e){
            System.err.print("Cannot write file");
        }
    }
}
