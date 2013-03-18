package trabalhogetlinks;

import java.util.List;
import java.util.ArrayList;

public class TrabalhoGetLinks {

    private ArrayList<String> links;
    
    private TrabalhoGetLinks() {
    }
    
    public final static void main(String[] args) throws Exception {

        HTMLUtils htmlUtils = new HTMLUtils("www.feevale.br");
        
        List<String> links = htmlUtils.extractLinks();
        for (String link : links) {
            links.add(link);
            System.out.println(link);
        }
    }
}