/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awj.java.grayscalehistogramegraylvl.histoLib;

import java.awt.image.BufferedImage;
import org.jfree.chart.ChartPanel;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author SorinM
 */
public abstract class ImplementHistogram implements histogram {
    private HistogramDataset dataset;
    abstract ChartPanel createChartPanel(BufferedImage image, String path, String Name);
}
