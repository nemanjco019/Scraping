package scrap;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrap {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.imdb.com/chart/top").userAgent("Opera").get();
            Elements temp = doc.select("tbody.lister-list");
            int i = 0;
            
            for(Element tbody:temp){
                Elements rows = tbody.select("tr");
                for(Element row:rows){
                    Elements columns = row.select("td.posterColumn");
                }
            }
        
        
        
        } 
        
        
        
        catch (IOException ex) {
            Logger.getLogger(Scrap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
