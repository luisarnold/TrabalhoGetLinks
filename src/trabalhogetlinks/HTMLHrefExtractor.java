package trabalhogetlinks;

import httpClient.HTTPClient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriel
 */
public class HTMLHrefExtractor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HTTPClient httpClient = new HTTPClient("www.feevale.br");
        
        String html = httpClient.getContent();
        Pattern p = Pattern.compile("a.*href=[',\"](.*?)[',\"]");
        Matcher m = p.matcher(html);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
    
}
