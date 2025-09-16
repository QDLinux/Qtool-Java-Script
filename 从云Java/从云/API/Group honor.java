//卑微萌新

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*; 
import java.net.*;
import java.util.List; 
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;

public long GetBkn(String skey)
{
    int hash = 5381;
    for (int i = 0, len = skey.length(); i < len; i++) 
        hash += (hash << 5) + (int)(char)skey.charAt(i);
    return hash & 2147483647;
}


	
public String httppost(String urlPath, String cookie,String data)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            CookieManager cookieManager = new CookieManager();
CookieHandler.setDefault(cookieManager);
            try {
                URL url = new URL(urlPath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);
			uc.setDoOutput(true);
			uc.setConnectTimeout(2000000);// 设置连接主机超时（单位：毫秒）
			uc.setReadTimeout(2000000);// 设置从主机读取数据超时（单位：毫秒）
			uc.setRequestMethod("POST");
			uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			uc.setRequestProperty("Cookie",cookie);
	uc.getOutputStream().write(data.getBytes("UTF-8"));
			uc.getOutputStream().flush();
			uc.getOutputStream().close();
                isr = new InputStreamReader(uc.getInputStream(), "utf-8");
                BufferedReader reader = new BufferedReader(isr); //缓冲
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != isr) {
                        isr.close();
                    }
                } catch (IOException e) {
                    Toast("错误:\n"+e);
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
}



public String SetTroopShowHonour(String qun,String myQQ,String skey,String pskey,int type)
{
try{
String cookie="p_uin=o0"+myQQ+";uin=o0"+myQQ+";skey="+skey+";p_skey="+pskey;
String put="gc="+qun+"&flag="+type+"&bkn="+GetBkn(skey);
		JSONObject json = new JSONObject(httppost("https://qinfo.clt.qq.com/cgi-bin/qun_info/set_honour_flag",cookie,put));
		int ec=json.get("ec");
		String em=json.get("em");
		if(ec==0) return "设置成功";
		//else if(ec==13)	return "设置失败，管理位置已满";
		else return "设置失败，原因:\n"+em;
		}
catch(Exception e)
            {
                return "设置失败，原因:\n"+e;
            } 
}



public String SetTroopShowLevel(String qun,String myQQ,String skey,String pskey,int type)
{
return SetTroopShowInfo(qun,myQQ,skey,pskey,"&levelnewflag="+type);
}

public String SetTroopShowTitle(String qun,String myQQ,String skey,String pskey,int type)
{
return SetTroopShowInfo(qun,myQQ,skey,pskey,"&levelflag="+type);
}

public String SetTroopShowInfo(String qun,String myQQ,String skey,String pskey,String type)
{
try{
String cookie="p_uin=o0"+myQQ+";uin=o0"+myQQ+";skey="+skey+";p_skey="+pskey;
String put="gc="+qun+type+"&bkn="+GetBkn(skey);
		JSONObject json = new JSONObject(httppost("https://qinfo.clt.qq.com/cgi-bin/qun_info/set_group_setting",cookie,put));
		int ec=json.get("ec");
		String em=json.get("em");
		if(ec==0) return "设置成功";
		//else if(ec==13)	return "设置失败，管理位置已满";
		else return "设置失败，原因:\n"+em;
		}
catch(Exception e)
            {
                return "设置失败，原因:\n"+e;
            } 
}