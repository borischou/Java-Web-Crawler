/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

import java.security.MessageDigest;

/**
 *
 * @author bolizhou
 */
public class Hasher {

    public static String toSha256(String inString) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = inString.toLowerCase();
            md.update(text.getBytes("ASCII"));
            byte[] hash = md.digest();
            System.out.println(hash.toString());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
