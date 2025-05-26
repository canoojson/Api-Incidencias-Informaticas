package com.example.demo.service;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
	public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            // Convertimos el resultado a hexadecimal
            BigInteger number = new BigInteger(1, messageDigest);
            StringBuilder hexString = new StringBuilder(number.toString(16));
            // Rellenamos con ceros a la izquierda si hace falta
            while (hexString.length() < 32) {
                hexString.insert(0, "0");
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
