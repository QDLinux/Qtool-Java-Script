//u加u解部分二改自云汐
//凯撒加解密来自卑微萌新
//Y解,X解来自无心，用于破解
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.net.URLEncoder;
import java.util.Base64;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import com.tencent.mobileqq.activity.shortvideo.d;
import com.tencent.mobileqq.app.BaseActivity;
import android.content.Intent;
import java.util.*;
import java.text.*;
public static String X(String sourceString) {
    String QQ = "WWWWWWWWWW无心1738662546"; 
      char[] p = QQ.toCharArray();
       int n = p.length;
       char[] c = sourceString.toCharArray();
       int m = c.length;
       for (int k = 0; k < m; k++) {
           int mima = c[k] - p[k / n];
           c[k] = (char) mima;
       }
       return new String(c);
   }
public String encryptKaiser(String orignal, String str,int type) {
long key = Long.parseLong(str);
char[] chars = orignal.toCharArray();
StringBuilder sb = new StringBuilder();
for (char aChar : chars) {
long asciiCode = aChar;
if(type==1)  asciiCode += key;
if(type==0)  asciiCode -= key;
char result = (char) asciiCode;
    sb.append(result);
}
return sb.toString();
}
public static String Y(String sourceString) {
    String QQ = jm("WUFOWVVF5peg5b+DMTIzNDU2Nzg5MGFiY2RlZmdoaWprbG1ub3BxcnN0dXZ3eHl6QUJDREVGR0hJSktMTU5PUFFSU1RVVldYWVror7fli7/liKDpmaTmiJbogIXmlKXmlLnlkKbliJnlj6/og73kvJrlr7zoh7TohJrmnKzlpLHmlYg=");
      char[] p = QQ.toCharArray();
       int n = p.length;
       char[] c = sourceString.toCharArray();
       int m = c.length;
       for (int k = 0; k < m; k++) {
           int mima = c[k] - p[k / n];
           c[k] = (char) mima;
       }
       return new String(c);
}
public String jm(String text)
{
try{
            byte[] decode = Base64.getDecoder().decode(text);
            String str = new String(decode);
            return str;
            }catch(Exception e){return text;
            }

}
public String jam(String text)
{
try{
            String data = text;
            byte[] bytes = data.getBytes();
            String encode = Base64.getEncoder().encodeToString(bytes);
            return encode;
            }catch(Exception e){return text;
            }

}
    public static String u解( String unicode) {
        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 0; i < hex.length; i++) {

            try {
                if(hex[i].length()>=4){
                    String chinese = hex[i].substring(0, 4);
                    try {
                        int chr = Integer.parseInt(chinese, 16);
                        boolean isChinese = isChinese((char) chr);
                            string.append((char) chr);
                            String behindString = hex[i].substring(4);
                            string.append(behindString);
                    } catch (NumberFormatException e1) {
                        string.append(hex[i]);
                    }

                }else{
                    string.append(hex[i]);
                }
            } catch (NumberFormatException e) {
                string.append(hex[i]);
            }
        }

        return string.toString();
}
        public static String u加(String str) {
        String r = "";
        for (int i = 0; i < str.length(); i++) {
            int chr1 = (char) str.charAt(i);
            String x=""+Integer.toHexString(chr1);
            if(x.length()==1)r+= "\\u000"+x;
            if(x.length()==2)r+= "\\u00"+x;
            if(x.length()==3)r+= "\\u0"+x;
            if(x.length()==4)r+= "\\u"+x;
        }
        return r;
}
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
}