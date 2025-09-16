//base64解密
import java.util.Base64;
public String jm(String text)
{
try{
            byte[] decode = Base64.getDecoder().decode(text);
            String str = new String(decode);
            return str;
            }catch(Exception e){return text;
            }

    }
    
public String b加(String text)
{
            String data = text;
            byte[] bytes = data.getBytes();
            String encode = Base64.getEncoder().encodeToString(bytes);
            return encode;

    }
//无心解密
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
//文字转unicode编码
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



//unicode编码转文字
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
    
    
    
    //—刺痛解密——————————————————————————————
    public static String CT(String sourceString) 
   {
    String QQ = new String(new byte[]{67,84,-27,-120,-70,-25,-105,-101,50,50,57,50,51,56,48,55,57,56,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,-24,-81,-73,-27,-117,-65,-27,-120,-96,-23,-103,-92,-26,-120,-106,-24,-128,-123,-26,-108,-91,-26,-108,-71,-27,-112,-90,-27,-120,-103,-27,-113,-81,-24,-125,-67,-28,-68,-102,-27,-81,-68,-24,-121,-76,-24,-124,-102,-26,-100,-84,-27,-92,-79,-26,-107,-120,}); 
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
