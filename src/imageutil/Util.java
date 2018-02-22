package imageutil;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Utilization for awt image processing.
 * @class Util
 * @author Pakkapon Phongthawee (07580028) <phongthawee_p@silpakorn.edu>
 * @author Prathumaraya Tamanee (07580446) <prathumaraya_t@silpakorn.edu>
 */
public class Util {
    /**
     * load image from file-system into BufferedImage
     * @param imagePath - string of image path on local drive.
     * @return image that have buffered in memories.
     */
    public static BufferedImage loadImage(String imagePath){
        BufferedImage img = null;
        try {
            File imgFile = new File(imagePath);
            img = ImageIO.read(imgFile);
        } catch(IOException ex) {
            System.err.println("Error loading image");
        }
        return img;
    }
     /**
     * save image to file-system from BufferedImage
     * @param outputPath - string of image path to save on local drive.
     * @param image - buffered image in memory
     * @return image that have buffered in memories.
     */
    public static void saveImage(String outputPath,BufferedImage image){
        try{
            File outputFile = new File(outputPath);
            String[] extractData = outputPath.split("\\.");
            ImageIO.write(image,extractData[extractData.length - 1], outputFile);
        }catch(IOException e){
            System.err.print("Cannot write file");
        }
    }
    /**
     * translate bufferedImage into2D array
     * @param img - BufferedImage in memory
     * @return gray scale  2D array
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
     * @param input - gray scale 2D array 
     * @return BufferedImage in memory
     */
    public static BufferedImage saveToImage(int[][] input){
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
