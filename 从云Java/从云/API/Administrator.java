//原作者我也不知道谁

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


public String setadmin(String qun,String qq,int type)
{
try{
String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("qun.qq.com");
String put="gc="+qun+"&ul="+qq+"&op="+type+"&bkn="+GetBkn(getSkey());
		JSONObject json = new JSONObject(httppost("https://qun.qq.com/cgi-bin/qun_mgr/set_group_admin",cookie,put));
		int ec=json.get("ec");
		String em=json.get("em");
		if(ec==0) return "设置成功";
		else if(ec==13)	return "设置失败，管理位置已满";
		else return "设置失败，原因:\n"+em;
		}
catch(Exception e)
            {
                return "设置失败，原因:\n"+e;
            } 
}
