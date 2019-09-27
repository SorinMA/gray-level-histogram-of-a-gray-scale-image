/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awj.java.grayscalehistogramegraylvl.imgProc;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author SorinM
 */
public class EQ implements ImgPorc{
    @Override
    public BufferedImage proc(BufferedImage src, BufferedImage dest) {
        dest = new BufferedImage(src.getWidth(), src.getHeight(),
                         BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = src.getRaster();
        WritableRaster er = dest.getRaster();
        int totpix= wr.getWidth()*wr.getHeight();
        int[] histogram = new int[256];

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                histogram[wr.getSample(x, y, 0)]++;
            }
        }

        int[] chistogram = new int[256];
        chistogram[0] = histogram[0];
        for(int i=1;i<256;i++){
            chistogram[i] = chistogram[i-1] + histogram[i];
        }

        float[] arr = new float[256];
        for(int i=0;i<256;i++){
            arr[i] =  (float)((chistogram[i]*255.0)/(float)totpix);
        }

        for (int x = 0; x < wr.getWidth(); x++) {
            for (int y = 0; y < wr.getHeight(); y++) {
                int nVal = (int) arr[wr.getSample(x, y, 0)];
                er.setSample(x, y, 0, nVal);
            }
        }
        dest.setData(er);
        return dest;
    }
}
