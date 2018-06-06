/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balze.bal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import webcrawler2.WebCrawler2;

/**
 *
 * @author Nemanja
 */
public class WebPage {
    private Anchor anchor;
    private String webPageHash;
    private int anchorParseStatus;
    private int emailParseStatus;

    private Document document;
    
    /*
        General constructor for crawling
    */
    public WebPage(Anchor anchor) {
        this.anchor = anchor;
    }
    /*
        Jsoup gets html
    */
    private void loadDocumentFromWeb(){
        try {
            document = Jsoup.connect(anchor.getAnchorUrl()).get();
            
            
        } catch (IOException ex) {
            Logger.getLogger(WebCrawler2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
