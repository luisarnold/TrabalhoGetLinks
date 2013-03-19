package trabalhogetlinks;

import java.util.List;
import java.util.ArrayList;

public class TrabalhoGetLinks {

    private static ArrayList<String> linksFiltered;
    
    private TrabalhoGetLinks() {
    }
    
    public final static void main(String[] args) throws Exception {

        HTMLUtils htmlUtils = new HTMLUtils("www.feevale.br");
        
        ArrayList<String> links = htmlUtils.extractLinks();
        
        linksFiltered = links;
        for (String link : links) {
            System.out.println(link);
        }
        
        System.out.println("Total: " + linksFiltered.size());
    }
}