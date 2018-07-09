package com.quickstart.test.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class RSAEncrypt {
    /** 指定加密算法为DESede */
    private static String ALGORITHM = "RSA";
    /** 指定key的大小 */
    private static int KEYSIZE = 1024;
    /** 指定公钥存放文件 */
    private static String PUBLIC_KEY_FILE = "PublicKey";
    /** 指定私钥存放文件 */
    private static String PRIVATE_KEY_FILE = "PrivateKey";

    /**
     * 生成密钥对
     */
    private static void generateKeyPair() throws Exception {
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(KEYSIZE, sr);
        /** 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();
        /** 得到公钥 */
        Key publicKey = kp.getPublic();
        /** 得到私钥 */
        Key privateKey = kp.getPrivate();
        /** 用对象流将生成的密钥写入文件 */
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
        oos1.writeObject(publicKey);
        oos2.writeObject(privateKey);
        /** 清空缓存，关闭文件输出流 */
        oos1.close();
        oos2.close();
    }

    /**
     * 加密方法 source： 源数据
     */
    public static String encrypt(String source) throws Exception {
        generateKeyPair();
        /** 将文件中的公钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
        Key key = (Key) ois.readObject();
        ois.close();
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] b = source.getBytes();
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b1);
    }

    /**
     * 解密算法 cryptograph:密文
     */
    public static String decrypt(String cryptograph) throws Exception {
        /** 将文件中的私钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
        Key key = (Key) ois.readObject();
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(cryptograph);
        System.out.println(b1.length);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

    public static void main(String[] args) throws Exception {
        String source = "火车";// 要加密的字符串 System.out.println("要加密的字符串:"+source);
        String cryptograph = encrypt(source);// 生成的密文
        System.out.println("生成的密文:" + cryptograph);
        // String target =
        // decrypt("AgFE1/gW3myTdaBgAjdloTfUGTUB/njyDIYJXKF2SjW2opGj+EqLcneYi8BL9cJNYed02EUm5t/7N/i0sIXAlOqhU0UNTPB2ygAo+kaJSr/yCbM4BdmlMlzztGLZ9NhpBiB23oj3e3LaQ/rSbEIqFWSBWD/ZPgJxWXD04/psdP0=");//
        // 解密密文
        // System.out.println("解密密文:" + target + "------------------------");
        // String target2 =
        // decrypt("BCx5IkAzeqMVHeCzPKDEjOE7uLjDOTVBwgj08mYtxULZ97zmsqctFVcmMWMNI2lRhpjQUd1FzM65QrE3xiE6C4TYLq8WS/CeSMBWE3Xs+v/2RdNq1FfbapW9BowsxqEdd9q27FPtN+jLcXDxzDsyTZeoiA//1wlhx/7ueYfLRUg=");//
        // 解密密文

        String dd = "W0Eqs/z6HzZJh2SPIpe0f0Nu+Gs+Bdkej3byi+qZZ2V70xI9hxwrgC5Q2E2zHUEZlegv6byUulvk" + "9iQcbSy6R3XsNz6M8/ub+CieIpKEutYu11FTACnnTIHh1jvKFwNgFQnPa2xfpmfQHLVzlTyRNGEJ"
                + "mKHJHfmyUR8iFzNoqAg=";
        String target2 = decrypt(cryptograph);
        System.out.println("解密密文2:" + target2);
    }
}
