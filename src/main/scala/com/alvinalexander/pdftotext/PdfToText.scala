package com.alvinalexander.pdftotext

import akka.actor.ActorSystem
import akka.actor.Props
import javax.swing.JOptionPane

/**
 * -----------------------------------------------
 * TEST FILE: /Users/al/Desktop/Scala-Cookbook.pdf
 * -----------------------------------------------
 * 
 */object PdfToText extends App {

    val controller = new MainFrameController

    val system = ActorSystem("PdfToText")
    
    // TODO it's a poor design choice to pass the controller to the PdfReader like this
    val pdfReader = system.actorOf(Props(new PdfReader(controller)), name = "PdfReader")

    try {
        controller.start(pdfReader)
    } catch {
        case t: Throwable => 
            JOptionPane.showMessageDialog(
                null,
                Utils.getStackTraceAsString(t),
                "Error",
                JOptionPane.ERROR_MESSAGE)  
    }
    

}


