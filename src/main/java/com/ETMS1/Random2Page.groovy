package com.ETMS1

import geb.Page

class Random2Page extends Page {

    static url = "http://localhost:63342/MultiScanner1/src/htmlApp2.html";

    static at = {
        title == "Random games2"
        //title == "Getty Images"
    }

    static content = {
        //manualsMenu { module MenuModule, $("#header-content ul li", 0) }
        //homelogo { $("h1", id: "logo")}
        but1 { $("input", id: "FFid")}
        //but1 (By.id("FFid")
        homelogo { $("a", class: "site_logo")}//WORKS!!
        //creativebutton { $("input", partialLinkText: "Creatief")}
        //creativebutton { $("li>a", linkText: "Creatief")}
        cartbutton { $("a", title: "Vraag prijzen op en doe aankopen.")}//WORKS!!

        //creativebutton { $("input", id: "creative_toggle")}


        // homelogo2 { $("h1", id: contains("logo"))}

    }
    def static printMe(){
        println "Dit is printme() van ETS2\\GettyPage"
        return true
    }
    def ClickTimes(int times, int sleeptime){
        for(int i=0;i<times;i++){
            but1.click()
            sleep(sleeptime)
        }
    }
}