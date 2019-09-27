/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awj.java.grayscalehistogramegraylvl.imgProc;

import java.awt.image.BufferedImage;

/**
 *
 * @author SorinM
 */
public interface ImgPorc {
    double stdDev = 10.0;
    BufferedImage proc(BufferedImage src, BufferedImage dest);
    
}
