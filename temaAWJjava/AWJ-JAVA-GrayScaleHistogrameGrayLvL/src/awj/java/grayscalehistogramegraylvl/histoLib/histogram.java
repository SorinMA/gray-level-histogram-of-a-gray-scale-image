/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awj.java.grayscalehistogramegraylvl.histoLib;

import java.awt.image.BufferedImage;

/**
 *
 * @author SorinM
 */
public interface histogram {
    int BINS = 256;

    /**
     *
     * @param img
     * @return
     */
    
    double[] computeHistogram(BufferedImage img);
}
