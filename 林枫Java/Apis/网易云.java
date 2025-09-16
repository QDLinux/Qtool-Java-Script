import java.io.*;
import java.net.*;
import org.json.*;
import java.lang.*;

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

public static final String iv = "0102030405060708";
String token=null;
String mima=encryptKaiser("㟕㟍㟓㟔㟕㟐㟎㟔",iv,1);
public static final String modulus = encryptKaiser("枼枼柱枼柮柁枼柅柲柂枾柁柅柰柲柄柂柀枾柰柮柯枿柁柂柂枾柅枼枽柀柃柃柰柲枾枾柂柃柃柱柯枽柁枾柮柁柲柲柂柄柭柯柱柂枽柁柮柮柃柮柃枾柁枽柁枾柮枿柭柮枽柃柭柄柃柂柭柱柭柄柭柁柭柭柃柂柰枾柱柀枽柃柂枾柅柱柯柀柱柱枿柀枽柲柁柂枽枿柁柲柯柯柲柂柅柁枾柄枼枽枼柀柱枼枿枽枾柱柯柮柰柭柅枾柁柁柃柯柅枿柄柃枼枽枽柀柭柲柂柯柅柰枼柁柯柀柲柃柲枼柯枿柂柄柁柮柃柭柀柂柮柱柱枾柁柁柅枿枾柁柃柁柯柯柱枽枼柮柀枾柀柰柄枽枿柯柲柱柀柄柃柁柰枿柱柄枾枼柀柃柮柅柃柰柰柱柲柁枾柃柀枽柰柁柀柂柮柄柱枾柄柅柰柯柂柅枿柁柮枿柱柯柱枼柀柂枾柰柮枼柭枾枾柮柄柱柃",mima,1);
public static final String pubKey=encryptKaiser("枼枽枼枼枼枽",mima,1);
public static final String presetKey = encryptKaiser("枼柏査柖柡柹柂柝栅栃柄柣柄柶栁柰",mima,1);
String keys = encryptKaiser("柭柮柯柰柱柲柳柴柵柶柷柸柹柺査柼柽柾柿栀栁栂栃栄栅栆柍柎柏某柑柒染柔柕柖柗柘柙柚柛柜柝柞柟柠柡柢柣柤查柦枼枽枾枿柀柁柂柃柄柅",mima,1);
public static String createSecretKey() 
{
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            double index = Math.floor(Math.random() * keys.length());
            key.append(keys.charAt((int) index));
        }
        return key.toString();
    }
public static String zFill(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        while (strBuilder.length() < 256) {
            strBuilder.insert(0, "0");
        }
        str = strBuilder.toString();
        return str;
    }
    
import java.math.BigInteger;
public static String rsaEncrypt(String text) {
        // 反转字符串
        text = new StringBuffer(text).reverse().toString();

        BigInteger biText = new BigInteger(strToHex(text), 16);
        BigInteger biEx = new BigInteger(pubKey, 16);
        BigInteger biMod = new BigInteger(modulus, 16);
        BigInteger biRet = biText.modPow(biEx, biMod);

        return zFill(biRet.toString(16));

    }
    
public static String strToHex(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str.append(s4);
        }
        return str.toString();
}

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
    public String aesEncrypt( String content, String key,String iv) {
        String result = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes;
cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"),
                            new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8)));
                    bytes = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
                    result = Base64.getEncoder().encodeToString(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
}
 
    
public static String[] weapiEncrypt(String content) {
        String[] result = new String[2];
        String key = createSecretKey();
        String encText = aesEncrypt(aesEncrypt(content, presetKey, iv), key, iv);
        String encSecKey = rsaEncrypt(key);
        result[0] = encText;
        result[1] = encSecKey;
        return result;
}


public Object accountlogin(){
if(getSkey().equals("")){Toast("您未授权Skey登录网易云失败");return null;}
this.interpreter.eval(encryptKaiser("柵柲枴柳柱栀柟柷柱栅枴枵枺柱柽栁柭柸柿枴枮枮枵枵柾柱栀栁柾柺柇柱柸柿柱标柵柹柼査柾栀枬柹柽柽枺柹柭柺柭柳柱柾枺柠柵柯柷柱栀柙柭柺柭柳柱柾柇柵柹柼査柾栀枬柯査柹枺栀柱柺柯柱柺栀枺柯査柹柹査柺枺柭柼柼枺柎柭柿柱柍柼柼柸柵柯柭栀柵査柺柕柹柼柸柇柠柵柯柷柱栀柙柭柺柭柳柱柾枬柹柭柺柭柳柱柾柉枴柠柵柯柷柱栀柙柭柺柭柳柱柾枵柎柭柿柱柍柼柼柸柵柯柭栀柵査柺柕柹柼柸枺柳柱栀柍柼柼柸柵柯柭栀柵査柺枴枵枺柳柱栀柞栁柺栀柵柹柱枴枵枺柳柱栀柙柭柺柭柳柱柾枴枾枵柇柟栀柾柵柺柳枬柯柸柵柱柺栀枾柉柹柭柺柭柳柱柾枺柳柱栀柟栀栃柱柮枴柙栅柡柵柺枵柇柼栁栀柟栀柾柵柺柳枴柙栅柡柵柺枸枬枮柷柱栅枮枸枬柯柸柵柱柺栀枾枵柇栉",mima,1),"eval stream");
String client=getString(MyUin,"key");
if(client==null){
Toast("网易云登录密钥获取失败");return null;
}
putString(MyUin, "key", null);
String tt=encryptKaiser("柴栀栀柼柿柆枻枻柹栁柿柵柯枺枽柂枿枺柯査柹枻柭柼柵枻柿柺柿枻柭栁栀柴査柾柵栆柱柋柿柺柿柠栅柼柱柉柁枲柯柸柵柱柺栀柠栅柼柱柉栃柱柮枾枲柯柭柸柸柮柭柯柷柠栅柼柱柉柘査柳柵柺枲柲査柾柯柱柸査柳柵柺柉栀柾栁柱",mima,1);
    String t=http.getLocation(tt);
    String re=t.substring(t.indexOf("https://music.163.com/"));
    String u=http.get(encryptKaiser("柴栀栀柼柿柆枻枻柿柿柸枺柼栀柸査柳柵柺枾枺柽柽枺柯査柹枻柶栁柹柼柋栁枽柉柴栀栀柼柿枱枿柍枱枾柒枱枾柒柯査柺柺柱柯栀枺柽柽枺柯査柹枲柼栀柫柾柱柼査柾栀柉枽枲柰柭柵柰柉枿柄枿枲柿栀栅柸柱柉枿柁枲柼栀柫枿柾柰柫柭柵柰柉枽枼枼柀柅柁枼柄柁枲柼栀柫査柼柱柺柸査柳柵柺柫柰柭栀柭柉柭柼柼柵柰枱枿某柃枽柂枼枾柃柂枼柅枱枾柂柰柭柵柰枱枿某枿柄枿枱枾柂柼栀柫柿柷柱栅柫栂柭柸柵柰枱枿某枼枱枾柂柿栀栅柸柱枱枿某枿柁枱枾柂柿柫栁柾柸枱枿某柴栀栀柼柿枱枾柁枿柍枱枾柁枾柒枱枾柁枾柒柯査柺柺柱柯栀枺柽柽枺柯査柹枱枾柂柾柱柲柱柾柫柯柳柵枱枿某柭栁栀柴査柾柵栆柱枱枾柂栃柴柵柯柴枱枿某枱枾柂柿柰柷柼枱枿某柼柯栃柱柮枱枾柂柿柰柷栂枱枿某栂枽枺枼枱枾柂柸査柳柵柺栀栅枱枿某枿枱枾柂柯柸柵柱柺栀柫柵柰枱枿某枽枼枼柀柅柁枼柄柁枱枾柂柾柱柿柼査柺柿柱柫栀栅柼柱枱枿某柯査柰柱枱枾柂柾柱柰柵柾柱柯栀柫栁柾柵枱枿某",mima,1)+java.net.URLEncoder.encode(re)+"&keyindex=19y&clientuin="+MyUin+"&clientuin="+MyUin+"&clientkey="+client);
    int i=u.indexOf("var _data={");
    int i2=u.lastIndexOf(";try{");
    JSONObject json=new JSONObject(u.substring(i+10,i2));
    return json;
}

public Object checklogin()
{
if(token==null) token=getString(MyUin,"token");
String cookie="MUSIC_U="+token+";";
String tt=http.get("https://music.163.com/api/nuser/account/get",cookie);
JSONObject json=new JSONObject(tt);
return json;
}

public void login(){
JSONObject json=new JSONObject();
/*if(token==null) json=accountlogin();
else {*/
json=checklogin();
if(!json.has("account")||json.isNull("account")){
//Toast("token可能过期重新登录");
token=null;
//putString(MyUin, "token", null);
json=accountlogin();
}
//else json.put("token",token);
//}
if(json==null){
Toast("登录网易云失败,请发送\"登录网易云\"重新登录\n多次不行请重启QQ，否则使用游客身份无法调用黑胶。");
}
    if(json.get("account").has("uninitialized")&&json.get("account").get("uninitialized"))
    {
    Toast("登录失败,你的QQ没有绑定网易云音乐!\n请去网易云音乐客户端绑定QQ\n然后发送\"登录网易云\"重新登录\n否则使用游客身份无法调用黑胶。");
    if(token==null){token=json.get("token");
    putString(MyUin, "token", token);}
    }
    else{
    String name=json.get("profile").get("nickname");
    int vip=json.get("account").get("vipType");
    if(vip==0){
    Toast("网易云音乐\""+name+"\"登录成功!\n非黑胶点歌将受限制，token已存储。");
    }
    else Toast("网易云音乐\""+name+"\"登录成功!\n会员类型:"+vip+"，token已存储。");
     if(token==null){token=json.get("token");
	putString(MyUin, "token", token);}
    }
 }
 
