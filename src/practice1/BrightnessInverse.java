/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice1;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author pakkapon
 */
public class BrightnessInverse {
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
        image = inverse(image);
        try{
            File outputFile = new File(outputPath);
            String[] extractData = outputPath.split("\\.");
            ImageIO.write(image,extractData[extractData.length - 1], outputFile);
        }catch(IOException e){
            System.err.print("Cannot write file");
        }
    }
    public static BufferedImage inverse(BufferedImage image){
        WritableRaster raster = image.getRaster();
        int[] pixelBuffer = new int[1];
        final int width = image.getWidth();
        final int height = image.getHeight();
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                raster.getPixel(j,i,pixelBuffer);
                pixelBuffer[0] = 255 - pixelBuffer[0];
                raster.setPixel(j,i,pixelBuffer);
            }
        }
        return image;
    }
}
