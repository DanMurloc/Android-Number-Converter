package com.example.numberconverter;

public class Convertor {

    public static boolean param=false;
    public static String DecToHex(Integer value){
        return Integer.toString(value,16).toUpperCase();
    }
    public static String DecToBin(Integer value){
        return Integer.toString(value,2).toUpperCase();
    }
    public static String BinToDec(String value){
        // Перевод шестнадцатеричной строки в десятичное число
        int decimalValue = Integer.parseInt(value, 2);
        return Integer.toString(decimalValue);
    }
    public static String HexToDec(String value){
        // Перевод шестнадцатеричной строки в десятичное число
        int decimalValue = Integer.parseInt(value, 16);
        return Integer.toString(decimalValue).toUpperCase();
    }
}
