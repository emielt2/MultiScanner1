package com.ETMS1

import geb.Page

class GooglePage extends Page {

    static url = "http://www.google.nl";
    static at = {
        title == "Google"
        //title == "Getty Images"
    }
    static content = {
//        homelogo { $("a", class: "site_logo")}//WORKS for getty!!
    }
    def static printMe(){
        println "This is printMe() of ETS2\\GooglePage"
        return true
    }
}
