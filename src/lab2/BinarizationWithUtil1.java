package lab2;

import imageutil.Util;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * same as ImageBinarization but move loadImage and saveImage to Util
 * @author Pakkapon Phongthawee (07580028) <phongthawee_p@silpakorn.edu>
 * @author Prathumaraya Tamanee (07580446) <prathumaraya_t@silpakorn.edu>
 */
public class BinarizationWithUtil1 {
    public static void main(String[] args){
        String imagePath = "images/classical_building_small_gray.png"; //input image path
        String outputPath = imagePath.substring(0,imagePath.length() -4); //output directory and file prefix name
        // read image file
        BufferedImage originalImage = Util.loadImage(imagePath);
        int[] thresholds = {72,96,128}; //value to threshold
        for(int threshold : thresholds){
            // convert from buffer image to 2D gray-scale array
            Raster raster = originalImage.getRaster();
            int[] pixelBuffer = new int[1];
            final int width = originalImage.getWidth();
            final int height = originalImage.getHeight();
            int[][] imageArray = new int[height][width];
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    raster.getPixel(j,i,pixelBuffer);
                    imageArray[i][j] = pixelBuffer[0];
                }
            }
            //Binaization image using threadhold
            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    imageArray[i][j] = imageArray[i][j] < threshold ? 0:255;
                }
            }
            //save image
            BufferedImage outputImage = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
            WritableRaster writeRaster = outputImage.getRaster();
            for(int row = 0;row < height; row++){
                for(int column = 0; column < width; column++){
                    pixelBuffer[0] = imageArray[row][column];
                    writeRaster.setPixel(column, row, pixelBuffer);
                }
            }
            Util.saveImage(
                    outputPath
                    + "_binalization_threshold_"
                    +threshold + ".png",
                    outputImage
            );       
        }
    }    
}
