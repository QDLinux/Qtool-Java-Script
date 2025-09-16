String COOKIE=null;

public Object accountlogin(){
String client=GetUinClient(LoginUin);
if(client==null){
Toast("QQ"+LoginUin+"网易云登录密钥获取失败");return null;
}
else if(client.equals("未授权")){
Toast("您未授权脚本!\n获取QQ"+LoginUin+"网易云登录密钥失败");
return null;
}
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
if(COOKIE==null) COOKIE=getString(MyUin,"COOKIE");
String tt=http.get("https://music.163.com/api/nuser/account/get",COOKIE);
JSONObject json=new JSONObject(tt);
return json;
}

import java.text.SimpleDateFormat;
SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

public void login(){
login(false);
}

public void login(boolean iftoast){
JSONObject json=new JSONObject();
/*if(COOKIE==null) json=accountlogin();
else {*/
json=checklogin();
if(!json.has("account")||json.isNull("account")){
Toast("正在登录网易云音乐");
COOKIE=null;
putString(MyUin, "COOKIE", null);
json=accountlogin();
}
else if(!iftoast) return;
//else json.put("COOKIE",COOKIE);
//}
if(json==null){
Toast("登录网易云失败,请发送\"登录网易云\"重新登录\n多次不行请重启QQ，否则使用游客身份无法调用黑胶。");
COOKIE=null;
}
    if(json.get("account").has("uninitialized")&&json.get("account").get("uninitialized"))
    {
    Toast("登录失败,你的QQ没有绑定网易云音乐!\n请去网易云音乐客户端绑定QQ\n然后发送\"登录网易云\"重新登录\n否则使用游客身份无法调用黑胶会员。");
    if(COOKIE==null){
    COOKIE="MUSIC_U="+json.get("token")+";";
    putString(MyUin, "COOKIE", COOKIE);}
    }
    else{
    String name=json.get("profile").get("nickname");
    String head=json.get("profile").get("avatarUrl");
    int vip=json.get("account").get("vipType");
    long createtime=json.get("account").get("createTime");
    String time1=df.format(createtime);
    if(vip==0){
    //Toast("网易云音乐\""+name+"\"登录成功!\n注册时间:"+time1+"\n非黑胶点歌将受限制，Cookie已存储。");
    mToast("网易云音乐\""+name+"\"登录成功!\n注册时间:"+time1+"\n非黑胶点歌将受限制，Cookie已存储。",bitmapurl(head),true,Gravity.BOTTOM,0,0);
    }
   // else Toast("网易云音乐\""+name+"\"登录成功!\n注册时间:"+time1+"\n会员类型:"+vip+"，Cookie已存储。");
   else mToast("网易云音乐\""+name+"\"登录成功!\n注册时间:"+time1+"\n会员类型:"+vip+"，Cookie已存储。",bitmapurl(head),true,Gravity.BOTTOM,0,0);
     if(COOKIE==null){
     COOKIE="MUSIC_U="+json.get("token")+";";
	putString(MyUin, "COOKIE", COOKIE);}
    }
 }
 
