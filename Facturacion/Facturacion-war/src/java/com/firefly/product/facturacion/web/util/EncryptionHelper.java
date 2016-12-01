/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.web.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author dclav
 */
public class EncryptionHelper {
    
    public static String encrypt(String text) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        byte[] bytesOfMessage = text.getBytes("UTF-8");
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        byte[] digested = md.digest(bytesOfMessage);
        
        /*StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digested.length; i++){
            sb.append(Integer.toString((digested[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();*/
        
        return bytesToHex(digested);
        
    }
    
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    
}
