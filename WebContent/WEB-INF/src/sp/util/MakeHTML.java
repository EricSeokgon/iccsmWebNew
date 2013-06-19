package sp.util;

import java.net.*;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MakeHTML {
    
    private String from;
    private String to;
    
    public MakeHTML(String from, String to) {
        this.from = from ;
        this.to = to;
    }
    
    public void makeByJAVA_NET_URL() throws Exception {
        
        URL url = new URL(from);
        
        FileOutputStream fos = null;
        InputStream in = null;
        try {
            in = url.openStream();

            //  url의 내용을 openStream()으로 읽어 들인다.


            fos = new FileOutputStream(to);

            byte[] buffer = new byte[512];
            int readcount = 0;


            while((readcount = in.read(buffer)) != -1)  {
                fos.write(buffer, 0, readcount);
            }

            //System.out.println("finish!");
        } catch (Exception ex) {
            //System.out.println(ex);
            
        } finally {
            try {
                if(fos != null) fos.close();
            } catch(Exception e) {}

            try {
                if(in != null) in.close();
            } catch(Exception e) {}
        }
    }


}
