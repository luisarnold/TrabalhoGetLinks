package httpClient;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author gabriel
 */
public class HTTPClient {

    private String url;
   
    public HTTPClient( String url ){
        this.url = url;
    }
    
    public String getContent() {
        
        String result = "";
        
        try{
            Socket s = new Socket( url, 80);
            PrintWriter out = new PrintWriter(s.getOutputStream());
            
            out.println("GET / HTTP/1.1");
            out.println("Host: www.feevale.br:80");
            out.println("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/536.26.17 (KHTML, like Gecko) Version/6.0.2 Safari/536.26.17");
            out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            out.println("Connection: close");
            out.println();
            out.flush();          
            
            InputStream in = s.getInputStream();
            byte buffer[] = new byte[128];
            int len = 0;
            
            while((len = in.read(buffer)) > 0){
                result += new String(buffer, 0, len);
            }
            
            System.out.println(result);
            
            in.close();
            out.close();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
}
