package com.ETMS1

import geb.Page

class GettyPage extends Page {

    static url = "http://gettyimages.nl";

    static at = {
        title == "Stockfotografie, royalty free foto's en de meest recente nieuwsfoto's | Getty Images"
        //title == "Getty Images"
    }

    static content = {
        //manualsMenu { module MenuModule, $("#header-content ul li", 0) }
        //homelogo { $("h1", id: "logo")}
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
}