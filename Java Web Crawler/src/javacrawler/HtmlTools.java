/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

/**
 *
 * @author bolizhou
 */
public class HtmlTools {

    public static String fixUrl(String inUrl, Domain domain) {
        String url = "";
        
        //url does not begin with domain
        if (!inUrl.startsWith(domain.getDomainUrl())) {
            //if doesn't start with http - fix
            if (!inUrl.startsWith("http")) {
                if (inUrl.startsWith("/")) {
                    url = domain.getDomainUrl().concat(inUrl);
                } else {
                    url = domain.getDomainUrl().concat("/" + inUrl);
                }
            } else {
                url = inUrl;
            }
        }
        
        //remove trailing '/'
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        //remove bookmark '#'
        if (url.contains("#")) {
            url = url.substring(0, url.indexOf("#"));
        }
        
        return url;
    }
}
