package randomer.functionality;

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
