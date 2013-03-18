package trabalhogetlinks;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLUtils {

    private static String domain = "www.feevale.br";
    
    public HTMLUtils(String domain) {
        this.domain = domain;
    }

    public List<String> extractLinks() throws IOException {
        
        Set result = new HashSet();

        String url = "http://" + domain;
        
        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select("a[href]");

        // href ...
        for (Element link : links) {
            String urlOfLink = link.attr("abs:href").toString();
            
            if (!urlOfLink.equals("") && isInDomain( urlOfLink ) && !result.contains(urlOfLink) ) {
                result.add( urlOfLink );
            }
        }
        
        List<String> finalResult = new ArrayList<>(result);
        return finalResult;
    }
    
    public static boolean isInDomain( String link ){
        if( link.contains( domain ) ){
            return true;
        }
        return false;
    }
}