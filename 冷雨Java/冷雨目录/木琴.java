//卑微萌新
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
public String SetTroopShowHonour(String qun,String myQQ,String skey,String cltpskey,int type)
{
String key="";
if(type==0) key="隐藏";
else if(type==1) key="显示";
else return "互动标识设置参数"+type+"错误";
try{
String cookie="p_uin=o0"+myQQ+";uin=o0"+myQQ+";skey="+skey+";p_skey="+cltpskey;
String put="gc="+qun+"&flag="+type+"&bkn="+GetBkn(skey);
		JSONObject json = new JSONObject(httppost1("https://qinfo.clt.qq.com/cgi-bin/qun_info/set_honour_flag",cookie,put));
		int ec=json.get("ec");
		String em=json.get("em");
		if(ec==0) return "互动标识"+key+"成功";
		else if(ec==7)	return "互动标识"+key+"失败，原因:\n非该群管理或群主";
		else return "互动标识"+key+"失败，原因:\n"+em;
		}
catch(Exception e)
            {
                return "互动标识"+key+"失败，原因:\n"+e;
            } 
}
public String SetTroopShowLevel(String qun,String myQQ,String skey,String cltpskey,int type)
{
String key="";
if(type==0) key="等级隐藏";
else if(type==1) key="等级显示";
else return "等级设置参数"+type+"错误";
return key+SetTroopShowInfo(qun,myQQ,skey,cltpskey,"&levelnewflag="+type);
}

public String SetTroopShowTitle(String qun,String myQQ,String skey,String cltpskey,int type)
{
String key="";
if(type==0) key="头衔隐藏";
else if(type==1) key="头衔显示";
else return "头衔设置参数"+type+"错误";
//Toast("正在设置"+key+"请稍后");
return key+SetTroopShowInfo(qun,myQQ,skey,cltpskey,"&levelflag="+type);
}
public String SetTroopShowInfo(String qun,String myQQ,String skey,String cltpskey,String type)
{
try{
String cookie="p_uin=o0"+myQQ+";uin=o0"+myQQ+";skey="+skey+";p_skey="+cltpskey;
String put="gc="+qun+type+"&bkn="+GetBkn(skey);
		JSONObject json = new JSONObject(httppost1("https://qinfo.clt.qq.com/cgi-bin/qun_info/set_group_setting",cookie,put));
		int ec=json.get("ec");
		String em=json.get("em");
		if(ec==0) return "成功";
		else if(ec==11)	return "失败，原因:\n非该群管理或群主";
		else return "失败，原因:\n"+em;
		}
catch(Exception e)
            {
                return "失败，原因:\n"+e;
            } 
}