package lab2;

import imageutil.Thresholder;
import imageutil.Util;
import java.awt.image.BufferedImage;

/**
 * ImageBinarization that easy to read
 * @author Pakkapon Phongthawee (07580028) <phongthawee_p@silpakorn.edu>
 * @author Prathumaraya Tamanee (07580446) <prathumaraya_t@silpakorn.edu>
 */

public class BinarizationWithUtil2 {
     public static void main(String[] args){
        String imagePath = "images/classical_building_small_gray.png"; //input image path
        String outputPath = imagePath.substring(0,imagePath.length() -4); //output directory and file prefix name
        BufferedImage originalImage = Util.loadImage(imagePath);
        int[][] imageArray;
        int[] thresholds = {72,96,128}; //value to threshold
        for(int threshold : thresholds){
            imageArray = Util.loadToArray(originalImage);
            Thresholder.binarize(imageArray, threshold);
            Util.saveImage(
                    outputPath
                    + "_binalization_threshold_"
                    +threshold + ".png",
                    Util.saveToImage(imageArray)
            );
        }
    }
}
