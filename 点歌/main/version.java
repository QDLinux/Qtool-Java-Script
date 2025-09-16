import com.tencent.common.app.BaseApplicationImpl;
Object app=BaseApplicationImpl.getApplication().getRuntime();


import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;

PackageManager pm = context.getPackageManager();
ApplicationInfo sAppInfo = pm.getApplicationInfo("com.tencent.mobileqq",PackageManager.GET_META_DATA);
String UUID = sAppInfo.metaData.getString("com.tencent.rdm.uuid");
String Version_Code = UUID.substring(0,UUID.indexOf("_"));
int QQ_version=Integer.parseInt(Version_Code);

import com.tencent.mobileqq.app.BaseActivity;
BaseActivity activity;
while(activity==null){
activity=BaseActivity.sTopActivity;
}

import com.tencent.mobileqq.troop.api.ITroopInfoService;
ITroopInfoService TroopInfo=app.getRuntimeService(ITroopInfoService.class);

public String quncode(String qun) {
   String code= TroopInfo.getTroopCodeByTroopUin(qun);
   if(code==null||code.equals("")) code=qun;
   return code;
}

public String qunuin(String code) {
   String qun= TroopInfo.getTroopUinByTroopCode(code);
   if(qun==null||qun.equals("")) qun=code;
   return qun;
}

import mqq.manager.TicketManager;

public String GetUinClient(String uin)
{
if(getSkey().equals(""))
{
return "未授权";
}
String client;
if(uin==null||uin.equals("")) uin=Mqq;
TicketManager manager = app.getManager(2);
client=manager.getStweb(uin);
if(client==null||client.equals("")) return null;
else return client;
}

public String GetUinCookie(String uin)
{
try{
String Cache = getString(LoginUin,"COOKIE");
if(Cache!=null&&!Cache.equals("")) return Cache;

if(uin==null||uin.equals("")) return getCookie("y.qq.com");

if(getSkey().equals(""))
{
return null;
}

String skey = getSkey(uin);
String pskey = getPskey(uin,"y.qq.com");
if(skey==null||skey.equals("")||pskey==null||pskey.equals("")) return null;
else return "uin=o"+uin+"; skey="+skey+"; p_uin=o"+uin+"; p_skey=" +pskey+";";
}catch(e){
Toastm("QQ音乐校验失败\n可能本设备没登录上\""+uin+"\"");
}
}
//COOKIE=GetUinCookie(LoginUin);