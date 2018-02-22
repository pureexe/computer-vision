package imageutil;

/**
 * Thresholder processing class
 * @author Pakkapon Phongthawee (07580028) <phongthawee_p@silpakorn.edu>
 * @author Prathumaraya Tamanee (07580446) <prathumaraya_t@silpakorn.edu>
 */
public class Thresholder {
    /**
     * Binarization image from gray-scale to black/white image.
     * @param I 2D array of gray-scale image
     * @param T threshold value (usually 0-255)
     * @param outputLow low value of output 
     * @param outputHigh height value of output
     */
    public static void binarize(int[][] I,final int T, int outputLow, int outputHigh){
        int i,j,height,width;
        height = I.length;
        width = I[0].length; 
        for(i = 0; i < height; i++){
            for(j = 0; j < width; j++){
                I[i][j] = I[i][j] < T ? outputLow:outputHigh;
            }
        }
    }
    /**
     * image wrapper for make easier implementation
     * @param image 2D array of image
     * @param threshold 
     */
    public static void binarize(int[][] image,final int threshold){
        binarize(image,threshold,0,255);
    }
}
