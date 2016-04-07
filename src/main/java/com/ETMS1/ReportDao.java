package com.ETMS1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created by E on 28/03/2016.
 */
public class ReportDao implements Runnable{
    ResultLog readLog(File fileName){

        ResultLog returnobj = new ResultLog();
        try{
            //executingThread.wait();
            FileReader in = new FileReader(fileName);
            LineNumberReader lineIn = new LineNumberReader(in);
            boolean end = false;
            System.out.println(fileName);
            while (!end)
            {
                try
                {
                    //if (lineIn.readLine() == null)
                    String line = lineIn.readLine();
                    //System.out.println("net na lineIn.readLine()");
                    System.out.println("line = " + line);

                    if(line.contains("JUnit 4 Runner, Tests: ")){
                        System.out.println("Current line : " + line);
                        end=true;
                        line= line.substring(line.indexOf(":")+2);
                        line = line.trim();
                        System.out.println(line.substring(0,line.indexOf(",")));
                        int testsAmount = Integer.parseInt(line.substring(0,line.indexOf(",")));
                        line = line.substring(line.indexOf(":")+2);
                        int failuresAmount = Integer.parseInt(line.substring(0,line.indexOf(",")));
                        System.out.println("testsAmout="+testsAmount);
                        System.out.println("failuresAmount="+failuresAmount);
                        if(failuresAmount==0)System.out.println("RESULT is SUCCESS (" + testsAmount + "/"+testsAmount+" passed!)");
                        else System.out.println("RESULT is FAILED ("+failuresAmount+"/"+testsAmount+" failed, " + (testsAmount-failuresAmount) + "/" + testsAmount + " passed.)");
                        returnobj.amountFailed=failuresAmount;
                        returnobj.amountCases=testsAmount;
                        returnobj.filename=fileName;
                        returnobj.amountSkipped=-1;

                    }

                }
                catch (IOException ex2)
                {
                    System.out.println(ex2.getMessage());
                    ex2.printStackTrace();
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

        return returnobj;
    }

    @Override
    public void run() {

    }
}
