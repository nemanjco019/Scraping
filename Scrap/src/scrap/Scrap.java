package scrap;

import java.util.ArrayList;
import java.util.List;
import scrap.websites.IProcessor;
import scrap.websites.Product;
import scrap.websites.idea.IdeaProcessor;
import scrap.websites.maxi.MaxiProcessor;

public class Scrap {
    public static void main(String[] args) {
        
        // test
//        (new CategoriesDiscovery()).listCategories();
        List<Product> products = new ArrayList<>();
        IProcessor[] processors = new IProcessor[]{
                new IdeaProcessor(),
                new MaxiProcessor()
        };
        for (IProcessor processor:processors) {
            try {
                List<Product> processorResult = processor.process();
                if (processorResult != null)
                    products.addAll(processorResult);
            } catch (InterruptedException e) {

            }
            // TODO: snimi u bazu products
        }
//        try {
//            Document doc = Jsoup.connect("https://www.idea.rs/online/v2/categories")
//                    .userAgent("Mozilla")
//                    .header("Cookie", "im-wsc-page-size=96; _ga=GA1.2.1899002668.1532865615; _gid=GA1.2.1899485563.1532865615; XSRF-TOKEN=NxKAwRMPjAWm69Udxku8RdCFR%2Bdi7kY%2BlIKJvdOCFOI%3D; idea_=rd104o00000000000000000000ffffac100040o80; _dc_gtm_UA-67270483-1=1; _ws-rails_session_id=BAh7EEkiD3Nlc3Npb25faWQGOgZFRkkiJWFhN2QzMGI1ZWM3OTc0YzcyYmRhMGRjMjEwMzZiYTU4BjsAVEkiFWN1cnJlbnRfbG9jYXRpb24GOwBGSSIsaHR0cHM6Ly93d3cuaWRlYS5ycy9vbmxpbmUvc2Vzc2lvbi9pbml0BjsARkkiGHByb2R1Y3RzX3NvcnRfZmllbGQGOwBGSSIJbmFtZQY7AFRJIhdwcm9kdWN0c19zb3J0X3R5cGUGOwBGSSIIYXNjBjsAVEkiHHRvcF9wcm9kdWN0c19zb3J0X2ZpZWxkBjsARkkiD3BvcHVsYXJpdHkGOwBUSSIbdG9wX3Byb2R1Y3RzX3NvcnRfdHlwZQY7AEZJIghhc2MGOwBUSSIQX2NzcmZfdG9rZW4GOwBGSSIxTnhLQXdSTVBqQVdtNjlVZHhrdThSZENGUitkaTdrWStsSUtKdmRPQ0ZPST0GOwBGSSIWcHJldmlvdXNfbG9jYXRpb24GOwBGSSJhaHR0cHM6Ly93d3cuaWRlYS5ycy9vbmxpbmUvdjIvY2F0ZWdvcmllcy82MDAwNzkyNi9wcm9kdWN0cz8mY2F0ZWdvcnlfaWQ9NjAwMDc5MjYmcGVyX3BhZ2U9MTIGOwBGSSIQc2VhcmNoX3Rlcm0GOwBGSSIGagY7AFRJIgtzb3VyY2UGOwBGSSILU0VBUkNIBjsARkkiEmFjdGlvbl9sb2dfaWQGOwBGaQTD8vUD--915b1973f06d72ba37953c820cabf5dd9b7c6f1e; TS01b33c01=0195e5b58b6c190c8dda0b86156bb12e771bf01ff268e4d2eab412964b62d1d49cc92dc2be36b7817954e13467495014543cfe176fca4df46257cd58734747ffbfe3a6434b9b3570d62ca1ae428d1d93ffa61f7c2011fcfa85fbfe3719a6d9614dfed162b0")
//                    .get();
//            System.out.println(doc.toString());
//        }
//        catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
        // end test

//        try {
//            Document doc = Jsoup.connect("https://www.imdb.com/chart/top").userAgent("Opera").get();
//            Elements temp = doc.select("tbody.lister-list");
//            int i = 0;
//
//            for(Element tbody:temp){
//                Elements rows = tbody.select("tr");
//                for(Element row:rows){
//                    Elements columns = row.select("td.titleColumn");
//                    Element title = columns.select("a").first();
//                    Element year = columns.select(".secondaryInfo").first();
//                    System.out.println(title.text() + " " + year.text());
//                }
//            }
//
//
//
//        }
//        catch (IOException ex) {
//            Logger.getLogger(Scrap.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }   
}
