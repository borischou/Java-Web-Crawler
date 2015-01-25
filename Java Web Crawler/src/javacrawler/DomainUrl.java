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
public class DomainUrl {
    private String domainUrlHash;
    private String domainUrl;
    private Domain domain;
   
    public DomainUrl(String domainUrlHash, String domainUrl, Domain domain) {
        this.domainUrlHash = domainUrlHash;
        this.domainUrl = domainUrl;
        this.domain = domain;
    }

    public String getDomainUrlHash() {
        return domainUrlHash;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public Domain getDomain() {
        return domain;
    }
    
    
    
    

    
    
    


    

    
    
}
//    public DomainUrl(String domain, String rawUrl) {
//    
//    }
//    
//    public static String formatDomainUrl(String domain, String rawUrl) {
//        String newUrl = rawUrl;
//        //check for FQDN
//        if (!newUrl.startsWith(domain)) {
//        //is this an external url? still starts with http.. just not our current domain
//            
//            if (!newUrl.startsWith("http")) {
//            //add our domain as this is a relative url
//                
//                // /cookbook/input/parse-body-fragment
//                if (newUrl.startsWith("/")) {
//                    newUrl = domain.concat(newUrl);
//                } else newUrl = domain.concat("/" + newUrl);
//                
//            } else {
//                //external url or properly formatted url or almost properly formatted rul
//                
//                // http://github.com (one period) -> http://www.github.com (2 periods)
//                String tempUrl = newUrl.split("/")[2];
//                
//                if (tempUrl.lastIndexOf(".") > 10) //quick fix
//                    newUrl = tempUrl.concat(domain);
//            }
//        }
//        return newUrl;
//    }