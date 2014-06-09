package com.ccb.security;

import csspji.CSSPCipher;
import csspji.CSSPCipherException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by IntelliJ IDEA.
 * User: zhanrui
 * Date: 2010-3-19
 * Time: 20:23:28
 * To change this template use File | Settings | File Templates.
 */
public class SecurityUtils {
    private static final Log logger = LogFactory.getLog(SecurityUtils.class);

    private static  CSSPCipher gCipher;

    static {
        try {
            gCipher = new CSSPCipher();
        } catch (CSSPCipherException e) {
            logger.error("初始化加密工具失败!");
        }
    }
    //private static java.sql.Connection connect;


    private static String getKey() {
        CSSPCipher gCipher = null;
        byte[] SymKey = null;
        BASE64Encoder base64en = new BASE64Encoder();

        try {
            gCipher = new CSSPCipher();
            int nKeyType = gCipher.JI_DES_KEY;
            gCipher.JI_DeviceInit();
            SymKey = gCipher.JI_GenSymKey(nKeyType);
            if (SymKey == null)
                System.out.println("-->JI_GenSymKey error!");
            gCipher.JI_DeviceFinal();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return base64en.encode(SymKey);
    }

    public static String encrypt(String key) {
        CSSPCipher gCipher = null;
        byte[] encData = null;
        byte[] bKey = null;
        BASE64Encoder base64en = new BASE64Encoder();
        BASE64Decoder base64De = new BASE64Decoder();

        try {
            gCipher = new CSSPCipher();
            // algID对称算法ID
//            int algID = gCipher.JI_ALGO_DES_ECB;
            int algID = gCipher.JI_ALGO_DES_ECB_PAD;
            byte[] plaintxt = null;
            plaintxt = "ccb".getBytes();
            gCipher.JI_DeviceInit();

            //key处理
            bKey = base64De.decodeBuffer(key);

            encData = gCipher.JI_SymEncrypt(algID, bKey, plaintxt);
            if (encData == null)
                System.out.println("-->Enc error!");
//            gCipher.JI_DeviceFinal();
        } catch (Exception ee) {
            ee.printStackTrace();
            throw new RuntimeException(ee);
        } finally {
            try {
                gCipher.JI_DeviceFinal();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return base64en.encode(encData);
    }

    /**
     * 个贷系统所用 加密方法
     * @param systemkey  加密密钥
     * @param usertext  数据库密码明文
     * @return  数据库密码密文
     */
    public static String encrypt(String systemkey, String usertext) {
        CSSPCipher gCipher = null;
        byte[] encData = null;
        byte[] bSystemKey = null;
        BASE64Encoder base64en = new BASE64Encoder();
        BASE64Decoder base64De = new BASE64Decoder();

        try {
            gCipher = new CSSPCipher();
            // algID对称算法ID
//            int algID = gCipher.JI_ALGO_DES_ECB;
            int algID = gCipher.JI_ALGO_DES_ECB_PAD;
            byte[] plaintxt = null;
            plaintxt = usertext.getBytes();
            gCipher.JI_DeviceInit();

            //key处理
            bSystemKey = base64De.decodeBuffer(systemkey);

            encData = gCipher.JI_SymEncrypt(algID, bSystemKey, plaintxt);
            if (encData == null)
                System.out.println("-->Enc error!");
//            gCipher.JI_DeviceFinal();
        } catch (Exception ee) {
            ee.printStackTrace();
            throw new RuntimeException(ee);
        } finally {
            try {
                gCipher.JI_DeviceFinal();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return base64en.encode(encData);
    }

    public static String decrypt(String key, String encStr) {
        //CSSPCipher gCipher = null;
        byte[] decData = null;
        byte[] encData = null;
        byte[] bKey = null;
        BASE64Decoder base64De = new BASE64Decoder();

        try {
            //gCipher = new CSSPCipher();
            // algID对称算法ID
            int algID = gCipher.JI_ALGO_DES_ECB_PAD;
            //key为对称密钥
            gCipher.JI_DeviceInit();

            encData = base64De.decodeBuffer(encStr);

            //key处理
            bKey = base64De.decodeBuffer(key);

            decData = gCipher.JI_SymDecrypt(algID, bKey, encData);
            if (decData == null)
                System.out.println("-->dec error!");
        } catch (Exception ee) {
            ee.printStackTrace();
            throw new RuntimeException(ee);
        } finally {
            if (gCipher != null) {
                try {
                    gCipher.JI_DeviceFinal();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }
            }
        }
        return new String(decData);
    }


    public static void main(String argv[]) {
        try {
            //随机生成的systemkey
            //String key = getKey();

            String syskey = "+9MuieNVKfY=";
            System.out.println("syskey:" + syskey);

            //
            String usertext = "c6c7b8a9";
            String encStr = encrypt(syskey, usertext);
            System.out.println("密文：" + encStr);

            String decStr = decrypt(syskey, encStr);
            System.out.println("明文：" + decStr);

        } catch (Exception e) {

        }
    }

}