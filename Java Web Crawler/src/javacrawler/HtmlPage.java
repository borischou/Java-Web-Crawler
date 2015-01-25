/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

import java.util.Date;

/**
 *
 * @author bolizhou
 */
public class HtmlPage {
    private int id;
    private byte[] compressedHtml;
    private DomainUrl domainUrl;
    private Date created;

    public HtmlPage(String html, DomainUrl domainUrl, Date created) throws Exception {
        this.compressedHtml = new CompressionUtils().Compress(html);
        this.domainUrl = domainUrl;
        this.created = created;
    }
    
    /*
     * saves html page to database
     */
    public void save() {
        
    }

    public int getId() {
        return id;
    }

    public byte[] getCompressedHtml() {
        return compressedHtml;
    }

    public DomainUrl getDomainUrl() {
        return domainUrl;
    }

    public Date getCreated() {
        return created;
    }
    
}
