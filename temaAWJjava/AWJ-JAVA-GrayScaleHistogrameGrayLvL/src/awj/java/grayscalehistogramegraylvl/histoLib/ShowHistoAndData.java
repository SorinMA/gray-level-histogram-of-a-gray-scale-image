/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awj.java.grayscalehistogramegraylvl.histoLib;

/**
 *
 * @author SorinM
 */

public class ShowHistoAndData extends FinalHisto{
    
    protected String[] runTime = {"<html>Read time: ", "<br/>Filter time: ", 
                                  "<br/>GrayScale time: ", "<br/>EQ time: ",
                                  "<br/>Histogram EQ time: ",
                                  "<br/>Histogram GS time: ",
                                  "<br/>ImgWrite EQ time: ",
                                  "<br/>ImgWrite GS time: ",
                                  "<br/>ImgWrite Filter time: ",
                                  "<br/>ImgWrite Initial time: ",
                                  "</html>"};
    
    public String fLabelPrintData(long ...a) 
    { 
        System.out.println("Number of arguments: " + a.length); 
        String out;
        // using for each loop to display contents of a 
        long [] arryPrint = new long [11];
        for(int i = 0 ; i < arryPrint.length ; i += 1)
            arryPrint[i] = 0;
        for(int i = 0 ; i < a.length ; i += 1)
            if(i < arryPrint.length)
                arryPrint[i] = a[i];
        out = (runTime[0] + arryPrint[0] +" ms"+
                        runTime[1] + arryPrint[1] +" ms"+
                        runTime[2] + arryPrint[2] +" ms"+
                        runTime[3] + arryPrint[3] +" ms"+
                        runTime[4] + arryPrint[4] +" ms"+
                        runTime[5] + arryPrint[5] +" ms"+
                        runTime[6] + arryPrint[6] +" ms"+
                        runTime[7] + arryPrint[7] +" ms"+
                        runTime[8] + arryPrint[8] +" ms"+
                        runTime[9] + arryPrint[9] +" ms"+
                        runTime[10]);
        return out;
    } 
}
