package net.x.x;

import android.os.Build;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    public static String encrytData(String algorithm, String key, String iv, String text) throws Exception {

        Cipher cipher = Cipher.getInstance(algorithm);
        byte[] static_key = key.getBytes();

        SecretKeySpec keySpec = new SecretKeySpec(static_key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        byte[] results = cipher.doFinal(text.getBytes());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.getEncoder().encodeToString(results);
        } else {
            return new String(android.util.Base64.encodeToString(results, android.util.Base64.NO_WRAP|android.util.Base64.DEFAULT));
        }
    }


    public static String decryptData(String algorithm, String key, String iv, String text)throws Exception{
        byte[] encryted_bytes = new byte[0];
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encryted_bytes = Base64.getDecoder().decode(text);
        } else {
            encryted_bytes = android.util.Base64.decode(text, android.util.Base64.NO_WRAP|android.util.Base64.DEFAULT);
        }
        Cipher cipher = Cipher.getInstance(algorithm);
        byte[] static_key = key.getBytes();
        SecretKeySpec keySpec = new SecretKeySpec(static_key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        byte[] decrypted = cipher.doFinal(encryted_bytes);
        String result = new String(decrypted);

        return result;
    }
}
