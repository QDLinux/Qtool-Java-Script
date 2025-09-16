public long GetGTK(String pskey){
    int hash = 5381;
    for (int i = 0, len = pskey.length();
    i < len;
    i++){
        hash +=(hash << 5)+(int)(char)pskey.charAt(i);
    }return hash & 0x7fffffff;
}
public String getUserName(String uin){
String qzone=getPskey("qzone.qq.com");
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+uin+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String nickname=json1.get("nickname");//昵称
return nickname;
}

public String getUserRealName(String uin){
String qzone=getPskey("qzone.qq.com");
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+uin+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String realname=json1.get("realname");//备注
return realname;
}


public String getIntimacyScore(String uin){
String qzone=getPskey("qzone.qq.com");
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+uin+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String intimacyScore=json1.get("intimacyScore");//亲密度
return intimacyScore;
}

public String getGender(String uin){
String qzone=getPskey("qzone.qq.com");
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+uin+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String gender=json1.get("gender");//性别
String sex=gender.replace("1","男").replace("2","女");
return sex;
}

public String getVipLevel(String uin){
String qzone=getPskey("qzone.qq.com");
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+uin+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String qqvip=json1.get("qqvip");//获取会员等级
return qqvip;
}

public String getGreenVipLevel(String uin){
String qzone=getPskey("qzone.qq.com");
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+uin+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String greenvip=json1.get("greenvip");//获取绿钻等级
return greenvip;
}

public String getCommfrd(String uin){
String qzone=getPskey("qzone.qq.com");
long gtk=GetGTK(qzone);
String cookie="p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qzone;
String url="https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+uin+"&remark=0&g_tk="+gtk;
String nm=httpget(url,cookie);
String nv=nm.replace("_Callback(","");
String nan=nv.replace(");","");
String boy=nan.replaceAll("\n","");
JSONObject json1 = new JSONObject(boy);
String commfrd=json1.get("commfrd");//共同好友
return commfrd;
}

public String getGroupMembers(String qun){
String cookie="uin=o"+qq+";p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qunpskey;
String put="gc="+qun+"&st=0&end=0&sort=0&bkn="+GetBkn(skey);
String get=httppost1("https://qun.qq.com/cgi-bin/qun_mgr/search_group_members",cookie,put);
JSONObject json = new JSONObject(get);
String count=json.optString("count");
return count;
}


public String getMaxGroupMembers(String qun){
String cookie="uin=o"+qq+";p_uin=o0"+MyUin+";skey="+skey+";p_skey="+qunpskey;
String put="gc="+qun+"&st=0&end=0&sort=0&bkn="+GetBkn(skey);
String get=httppost1("https://qun.qq.com/cgi-bin/qun_mgr/search_group_members",cookie,put);
JSONObject json = new JSONObject(get);
String max_count=json.optString("max_count");
return max_count;
}