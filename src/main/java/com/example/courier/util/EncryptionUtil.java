//package com.example.courier.util;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//public class EncryptionUtil {
//    public static String encrypt(String input) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            byte[] hash = md.digest(input.getBytes());
//            StringBuilder hexString = new StringBuilder();
//            for (byte b : hash) {
//                hexString.append(String.format("%02x", b));
//            }
//            return hexString.toString();
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
