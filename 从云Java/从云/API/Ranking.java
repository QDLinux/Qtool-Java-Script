//呆呆

public String speakingList(String qun,int time)
{
try{
String cookie = "uin=o"+MyUin+";p_uin=o"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("qun.qq.com");
String result = speakingList("https://qun.qq.com/m/qun/activedata/speaking.html?gc="+qun+"&time="+time+"&_wv=3&_wwv=128",cookie);
int index = result.lastIndexOf("window.__INITIAL_STATE__=");
if(index!=-1)
{
String text = result.substring(index + 25);
int rd = text.indexOf("}<");
String re = text.substring(0,rd+1);
JSONObject json = new JSONObject(re);
JSONArray speakingList = json.getJSONArray("speakingList");
JSONObject speaking = speakingList.getJSONObject(0);
uin = speaking.getString("uin");
avatar = speaking.getString("avatar");
nickname = speaking.getString("nickname");
active = speaking.getString("active");
msgCount = speaking.getString("msgCount");
String wx;String headtext;
if(time==0)
{
wx = "\n昨日第一";
headtext = "昨日发言：";
}
else if(time==1)
{
wx = "\n七日内第一";
headtext = "七日内发言：";
}
else if(time==2)
{
wx = "\n本月内第一";
headtext = "本月内发言：";
}
wx += "[PicUrl="+avatar+"]"+nickname.replace("\n","")+"("+uin+")\n连续活跃"+active+"天\n"+headtext+msgCount+"条";
for(int i = 1; i < speakingList.length(); i++)
{
try
{
JSONObject speaking = speakingList.getJSONObject(i);
uin = speaking.getString("uin");
nickname = speaking.getString("nickname");
active = speaking.getString("active");
msgCount = speaking.getString("msgCount");
wx += "\n\n"+nickname.replace("\n","")+"("+uin+")\n连续活跃："+active+"天\n"+headtext+msgCount+"条";
}
catch(Exception e)
{
continue;
}
}
return wx;
}
else return "获取失败,Json未获取到";
}
catch(Exception e)
{
return "失败，原因:\n"+e;
}
}
	public String speakingList(String url,String Cookie) {
		StringBuffer buffer = new StringBuffer();
			InputStreamReader isr = null;
			try {
				URL urlObj = new URL(url);
				CookieManager cookieManager = new CookieManager();
				CookieHandler.setDefault(cookieManager);
				URLConnection uc = urlObj.openConnection();
				uc.setRequestProperty("Cookie",Cookie);
				uc.setRequestProperty("Host", "qun.qq.com");
				uc.setConnectTimeout(10000);
				uc.setReadTimeout(10000);
				isr = new InputStreamReader(uc.getInputStream(), "utf-8");
				BufferedReader reader = new BufferedReader(isr);
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
					e.printStackTrace();
				}
			}
		if(buffer.length()==0)return buffer.toString();
		buffer.delete(buffer.length()-1,buffer.length());
		return buffer.toString();
	}