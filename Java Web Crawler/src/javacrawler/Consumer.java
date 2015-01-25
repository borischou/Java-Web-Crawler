/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author bolizhou
 */
public class Consumer {

    public void Start() {
        String crawlDomain = "http://www.baidu.com";
        Domain domain = new Domain(Hasher.toSha256(crawlDomain), crawlDomain);
        DomainUrl domainUrl = new DomainUrl(domain.getDomainHash(), domain.getDomainUrl(), domain);

        HashSet<String> hrefs = new HashSet<String>();

        try {
            // TODO code application logic here
            Document doc = Jsoup.connect(domainUrl.getDomainUrl()).get();
            
            try {
                HtmlPage page = new HtmlPage(doc.html(), domainUrl, new Date());
            } catch (Exception ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //get all anchors
            Elements anchors = doc.select("a");
            for (Element anchor : anchors) {
                String href = anchor.attr("href");
                href = HtmlTools.fixUrl(href, domain);
                
                hrefs.add(href);
                System.out.println(anchor);
            }
        } catch (IOException ex) {
            Logger.getLogger(JavaCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("**************");

        for (String href : hrefs) {
            System.out.println(href);
        }
    }

}
