/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awj.java.grayscalehistogramegraylvl.histoLib;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author SorinM
 */
public class FinalHisto extends AbstractHistoDraw{
    @Override
    public double[] computeHistogram(BufferedImage img) {
         
        int width = img.getWidth();
        int height = img.getHeight();
        double[] histo = new double[width*height];
        int index = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                histo[index] = img.getRGB(x, y)& 0xFF;
                index++;
            }
        }
        
        return histo;
    }
    
    @Override
    public ChartPanel createChartPanel(BufferedImage image, String path, String Name) {
        HistogramDataset dataset = new HistogramDataset();
      
        dataset.addSeries( Name,this.computeHistogram(image), 256);
     
        // chart
        JFreeChart chart = ChartFactory.createHistogram(path, "Values",
            "Count", dataset, PlotOrientation.VERTICAL , true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setForegroundAlpha(0.85f);
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();   
        ChartPanel panel = new ChartPanel(chart); 
        
         try {
            ChartUtilities.saveChartAsPNG(new File(path), chart, image.getWidth(),image.getHeight());
         } catch (IOException ex) {
            System.err.println(ex);
        }
        
        return panel;
        
    }
    
    @Override
    public ChartPanel display(BufferedImage image,String path, String name) {
        JFrame f = new JFrame("Histogram");
       
        ChartPanel panel = this.createChartPanel(image, path, name);
        f.add(panel);
        f.setPreferredSize(new Dimension(600, 450));
        f.pack();
        f.setLocationRelativeTo(null);
   
        f.setVisible(true);
        return panel;
    } 
}
