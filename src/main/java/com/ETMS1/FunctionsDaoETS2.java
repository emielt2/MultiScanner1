package com.ETMS1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by E on 12/01/2016.
 */
public class FunctionsDaoETS2 {
    public String getDateString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
        Calendar cal = Calendar.getInstance();
        String bestandsnaam = dateFormat.format(cal.getTime());
        //return bestandsnaam;
        return dateFormat.format(    Calendar.getInstance().getTime());
    }
}
