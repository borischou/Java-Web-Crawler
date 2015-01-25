/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrawler;

import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 *
 * @author bolizhou
 */
public class CompressionUtils {
    public byte[] Compress(String inputString) throws Exception {
        //encode a string into bytes
        byte[] input = inputString.getBytes("UTF-8");
        //compress the bytes
        byte[] output = inputString.getBytes(); //new byte[100]
        Deflater compresser = new Deflater();
        compresser.setInput(input);
        compresser.finish();
        int compressedDataLength = compresser.deflate(output);
        return output;
    }
    
    public String Decompress(byte[] inBytes) throws Exception {
        //decompress the bytes
        Inflater decompresser = new Inflater();
        decompresser.setInput(inBytes, 0, inBytes.length);
        byte[] result = new byte[inBytes.length];
        int resultLength = decompresser.inflate(result);
        decompresser.end();

        //decode the bytes into a string
        return new String(result, 0, resultLength, "UTF-8");
    }
}
