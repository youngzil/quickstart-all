package com.quickstart.test.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * code转换
 * 
 * @author ziliang.yang
 *
 */
public class CoderUtils {

    public static char ascii2Char(int ASCII) {
        return (char) ASCII;
    }

    public static int char2ASCII(char c) {
        return (int) c;
    }

    public static String ascii2String(int[] ASCIIs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ASCIIs.length; i++) {
            sb.append((char) ascii2Char(ASCIIs[i]));
        }
        return sb.toString();
    }

    public static String ascii2String(String ASCIIs) {
        String[] ASCIIss = ASCIIs.split(",");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ASCIIss.length; i++) {
            sb.append((char) ascii2Char(Integer.parseInt(ASCIIss[i])));
        }
        return sb.toString();
    }

    public static int[] string2ASCII(String s) {// 字符串转换为ASCII码
        if (s == null || "".equals(s)) {
            return null;
        }

        char[] chars = s.toCharArray();
        int[] asciiArray = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            asciiArray[i] = char2ASCII(chars[i]);
        }
        return asciiArray;
    }

    public static String getIntArrayString(int[] intArray) {
        return getIntArrayString(intArray, ",");
    }

    public static String getIntArrayString(int[] intArray, String delimiter) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i]).append(delimiter);
        }
        return sb.toString();
    }

    public static String getASCII(int begin, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = begin; i < end; i++) {
            sb.append(i).append(":").append((char) i).append("\r\n");
            // sb.append((char) i).append("/t");
            /*if (i % 10 == 0) {
            	sb.append("/n");
            }*/
        }
        return sb.toString();
    }

    public static String getCHASCII() {
        return getASCII(19968, 40869);
    }

    public static void showASCII(int begin, int end) {
        for (int i = begin; i < end; i++) {
            // System.out.print(i + ":" + (char) i + "/t");
            System.out.print((char) i + "/t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void showCHASCII() {
        showASCII(19968, 40869);
    }

    public static void showIntArray(int[] intArray) {
        showIntArray(intArray, ",");
    }

    public static void showIntArray(int[] intArray, String delimiter) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + delimiter);
        }
    }

    public static void createFile(String filePathAndName, String fileContent) throws IOException {

        String filePath = filePathAndName.toString();
        File myFilePath = new File(filePath);
        if (!myFilePath.exists()) {
            myFilePath.createNewFile();
        }
        FileWriter resultFile = new FileWriter(myFilePath);
        PrintWriter myFile = new PrintWriter(resultFile);
        myFile.println(fileContent);
        myFile.close();
        resultFile.close();
    }

    public static void main(String[] args) throws IOException {

        String s = "好好学习！天天向上！————笑的自然 2009年3月11日";
        showIntArray(string2ASCII(s), " ");
        System.out.println();
        System.out.println(ascii2String(string2ASCII(s)));

        // createFile("c://console_ch.txt", getASCII(0, 100000));
        String ddd = getASCII(0, 20);
        System.out.println(ddd);
        createFile("c://console_ch1.txt", ddd);
    }

}
