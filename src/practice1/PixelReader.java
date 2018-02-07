/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice1;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pakkapon
 */
public class PixelReader {
    public static void main(String[] args){
        BufferedImage img = null;
        try {
            File imgFile = new File("images/gray.png");
            img = ImageIO.read(imgFile);
            System.out.println(""+img.getWidth()+"x"+img.getHeight());
            int[][] arrayImages = loadToArray(img);
            printArray2D(arrayImages);
        } catch(IOException ex) {
            System.err.println("Error loading image");
        }
    }
    private static int[][] loadToArray(BufferedImage img){
        Raster raster = img.getRaster();
        int[] pixelBuffer = new int[1];
        final int width = img.getWidth();
        final int height = img.getHeight();
        int[][] imagesArray = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                raster.getPixel(j,i,pixelBuffer);
                imagesArray[i][j] = pixelBuffer[0];
            }
        }
        return imagesArray;
    }
    private static void printArray2D(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
