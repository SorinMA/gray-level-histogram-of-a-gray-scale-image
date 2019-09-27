/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awj.java.grayscalehistogramegraylvl.histoLib;

import java.awt.image.BufferedImage;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author SorinM
 */
public abstract class AbstractHistoDraw extends ImplementHistogram{
    abstract ChartPanel display(BufferedImage image,String path, String name);   
}
