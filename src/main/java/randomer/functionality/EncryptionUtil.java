package randomer.functionality;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class EncryptionUtil {
   public String encrypt(String text){
       StringBuilder builder = new StringBuilder();
       for (int i = 0; i < text.length(); i++) {
           builder.append((char)(text.charAt(i)+10));

       }
       return builder.toString();
   }
   public String decrypt(String text){
       StringBuilder builder = new StringBuilder();
       for (int i = 0; i < text.length(); i++) {
           builder.append((char)(text.charAt(i)-10));
       }
       return builder.toString();
   }
}
