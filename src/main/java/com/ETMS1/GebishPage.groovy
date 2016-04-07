package com.ETMS1

import geb.Page

class GebishPage extends Page {

    static url = "http://gebish.org";
    static at = {
        title == "Geb - Very Groovy Browser Automation"
    }
    static content = {
//        homelogo { $("a", class: "site_logo")}//WORKS for getty!!
    }
    def static printMe(){
        println "Dit is printMe() van ETS2\\GettyPage"
        return true
    }
}
