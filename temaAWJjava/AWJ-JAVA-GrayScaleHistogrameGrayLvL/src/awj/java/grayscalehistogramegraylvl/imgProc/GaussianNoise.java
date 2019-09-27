/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awj.java.grayscalehistogramegraylvl.imgProc;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 *
 * @author SorinM
 */
public class GaussianNoise implements ImgPorc{
    @Override
    public BufferedImage proc(BufferedImage image, BufferedImage output) {
        Raster source = image.getRaster();
        WritableRaster out = output.getRaster();
          
        int currVal;                    // the current value
        double newVal;                  // the new "noisy" value
        double gaussian;                // gaussian number
        int bands  = out.getNumBands(); // number of bands
        int width  = image.getWidth();  // width of the image
        int height = image.getHeight(); // height of the image
        java.util.Random randGen = new java.util.Random();
          
        for (int j=0; j<height; j++) {
            for (int i=0; i<width; i++) {
                gaussian = randGen.nextGaussian();
                  
                for (int b=0; b<bands; b++) {
                    newVal = stdDev * gaussian;
                    currVal = source.getSample(i, j, b);
                    newVal = newVal + currVal;
                    if (newVal < 0)   newVal = 0.0;
                    if (newVal > 255) newVal = 255.0;
                      
                    out.setSample(i, j, b, (int)(newVal));
                }
            }
        }
          
        return output;
    }
}
