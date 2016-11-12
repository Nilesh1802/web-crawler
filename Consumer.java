package webcrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.FileObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Consumer {

    PrintStream myconsole;
    public void Start() {
        crawl();
    }

    private void crawl() {
        String crawlUrl = this.getCrawlUrl();
        System.out.println(crawlUrl);
        
        
        HashSet<String> anchors = new HashSet<String>();

        try {
            Document doc = Jsoup.connect(crawlUrl).get();

            Elements hrefs = doc.select("a");

            for (Element e : hrefs) {

                String anchor = e.attr("href").trim();
                anchors.add(anchor);
                System.out.println(anchor);
            }

        } catch (IOException ex) {
            Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("-------------");

        try {
            FileOutputStream fos = new FileOutputStream(new File("F:\\tesst.txt"));
            myconsole = new PrintStream(fos);
            System.setOut(myconsole);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String s : anchors) {
            System.out.println(s);
        }

        try{

        if ((new File("F:\\tesst.txt")).exists()) {

            Process p = Runtime
               .getRuntime()
               .exec("rundll32 url.dll,FileProtocolHandler F:\\tesst.txt");
            p.waitFor();

        } else {

            System.out.println("File does not exist");

        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    private String getCrawlUrl() {
        String url = CrawlerGui.url;
        return url;

    }
}
