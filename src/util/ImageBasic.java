package util;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pakkapon
 */
public class ImageBasic {
    /**
     * translate bufferedImage into2D array
     * @param BufferedImage bufferedImage
     * @return int[][] imagesIn2DintArray
     */
     public static int[][] loadToArray(BufferedImage img){
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
    /**
     * write 2D array into image buffer
     * @param int[][] images2Darray
     * @return BufferedImage images
     */
    public static BufferedImage writeToGrayBuffer(int[][] input){
        final int height = input.length;
        final int width = input[0].length;
        int[] bufferedPixel = new int[1];
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = image.getRaster();
        for(int row = 0;row < height; row++){
            for(int column = 0; column < width; column++){
                bufferedPixel[0] = input[row][column];
                raster.setPixel(column, row, bufferedPixel);
            }
        }
        return image;
    }
}
