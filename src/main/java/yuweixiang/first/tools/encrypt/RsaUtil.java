package yuweixiang.first.tools.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;

/**
 * RSA加密算法实现
 *
 * @author yuweixiang
 * @version $ Id: RsaUtil.java, v 0.1 16/7/31 上午12:06 yuweixiang Exp $
 */
public class RsaUtil {


    private static int[]        publicKeySpecial  = { 3, 6, 7, 9, 14 };

    private static int[]        privateKeySpecial = { 1, 3, 4, 7, 10, 20, 25 };

    private static String       chars             = "abcdefghijklmnopqrstuvwxyz";

    private static String       publicKey;

    private static String       privateKey;

    private static String       specialPrivateKey;

    private static String       specialPublicKey;

    /**
     * 对数据进行RSA加密
     *
     * @param data
     *            源数据
     * @return 加密之后的数据
     */
    public static String encryptData(String data) {
        try {
            String tempPublicKey = dealDeleteKey(publicKey, publicKeySpecial);
            X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(
                Base64.decodeBase64(tempPublicKey.getBytes()));
            KeyFactory keyf = KeyFactory.getInstance("RSA", "BC");
            PublicKey pubKey = keyf.generatePublic(pubX509);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] dataToEncrypt = data.getBytes("utf-8");
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);
            String encryptString = Base64.encodeBase64String(encryptedData);
            return encryptString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * RSA进行解密，对加密的密文进行解密
     *
     * @param data
     *            加密数据
     * @return 明文
     */
    public static String decryptData(String data) {
        try {
            String tempPrivateKey = dealDeleteKey(privateKey, privateKeySpecial);
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                Base64.decodeBase64(tempPrivateKey.getBytes()));
            KeyFactory keyf = KeyFactory.getInstance("RSA", "BC");
            PrivateKey privKey = keyf.generatePrivate(priPKCS8);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privKey);
            byte[] descryptData = Base64.decodeBase64(data);
            byte[] descryptedData = cipher.doFinal(descryptData);
            String srcData = new String(descryptedData, "utf-8");
            return srcData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * main 函数，生成公钥和私钥
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            StringBuilder result = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            System.out.println("请输入账号和密码(用户名和密码之间以英文,隔开,多个账号换行输入,结束输入回车#):");
            while (true) {
                Scanner scan = new Scanner(System.in);
                String read = scan.nextLine();
                if (read.equals("")||read==null){
                    continue;
                }
                if (read.equals("#")){
                    break;
                }else {
                    sb.append(read);
                    sb.append(";");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            String[] counts = sb.toString().split(";");
            if (counts.length<1){
                System.out.println("你输入的账号有误!程序将在5秒aaa后退出!");
                Thread.sleep(5000);
                System.exit(1);
            }
            System.out.println(counts.length);
            System.out.println(counts[0]);
            generatorKey();
            for (String count : counts){
                String[] countDetail = count.split(",");
                if (countDetail.length!=2){
                    System.out.println("你输入的账号有误!程序将在5秒后退出!");
                    Thread.sleep(5000);
                    System.exit(1);
                }
                result.append(countDetail[0]);
                result.append(":");
                String encryptStr = encryptData(countDetail[1]);
                result.append(encryptStr);
                result.append(";");
                System.out.println(decryptData(encryptStr));
            }
            System.out.println("请将以下数据交给研发进行配合:"+result.deleteCharAt(result.length()-1).toString());
            System.out.println("请将此密文交给运维:"+privateKey);
            System.out.println("输入结果为:"+sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generatorKey() {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
            generator.initialize(512, new SecureRandom());
            KeyPair pair = generator.generateKeyPair();
            PublicKey pubKey = pair.getPublic();
            PrivateKey privKey = pair.getPrivate();
            byte[] pk = pubKey.getEncoded();
            byte[] privk = privKey.getEncoded();
            String strpk = new String(Base64.encodeBase64(pk));
            String strprivk = new String(Base64.encodeBase64(privk));

            System.out.println("原公钥:" + strpk);
            System.out.println("原私钥:" + strprivk);
            publicKey = dealInsertKey(strpk, publicKeySpecial);
            privateKey = dealInsertKey(strprivk, privateKeySpecial);
            System.out.println("处理之后的公钥:" + publicKey);
            System.out.println("处理之后的私钥:" + privateKey);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String dealInsertKey(String key, int[] special) {
        StringBuilder sb = new StringBuilder(key);
        for (int index = 0; index < special.length; index++) {
            sb.insert(special[index], chars.charAt((int) (Math.random() * 26)));
        }
        return sb.toString();
    }

    public static String dealDeleteKey(String key, int[] special) {
        StringBuilder sb = new StringBuilder(key);
        for (int index = special.length - 1; index >= 0; index--) {
            sb.deleteCharAt(special[index]);
        }
        return sb.toString();
    }
}
