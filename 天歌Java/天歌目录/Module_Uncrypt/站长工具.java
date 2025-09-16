List OpenGroupList = new ArrayList(Arrays.asList(item.MakeListForItem(X("ÅÅÅºÀÌ"), X("ÈÆÆÈÇ"), X("ÈÉ¾Ç ËÈÎÉ"))));
String[] AdminList = item.MakeListForItem(X("ÅºÀÌ"), X("º½ÆÂÇ"), X("»Åº¼ÄÅÂÌÍ"));
import com.bug.utils.JSONUtils;
public boolean Module_站长工具(Object msg)
{	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;

	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "站长工具")) return false;
	String 域名 = item.GetItemData(X("ÉÂ"), "域名", "地址", "1");

		if(msg.Message_Content.startsWith("ping"))
		{
		String text = msg.Message_Content.substring(2).replace("ng","");
		String url = http.get("https://api.xingzhige.com/API/ping/api.php?url="+text);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.startsWith("防洪"))
	{
		String text = msg.Message_Content.substring(2).replace(" ","");
		String url =http.get(域名+"/API/wl/fh.php?url="+text);
		JSONObject b=new JSONObject(url);//json解析
		String ae_url=b.getString("ae_url");
	MyMsg.FixAndSendMsg(msg.Message_GroupUin, ae_url,DefInfo.CardDefImages,false);
	}
		if(msg.Message_Content.startsWith("URL加密"))
		{
			String text = msg.Message_Content.substring(5).replace(" ","");
		String url = http.get(域名+"/API/other/url.php?data=&msg="+text+"&type=");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("URL解密"))
		{
			String text = msg.Message_Content.substring(5).replace(" ","");
		String url = http.get(域名+"/API/other/url.php?data=&msg="+text+"&type=1");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("uincode解密"))
		{
		String text = msg.Message_Content.substring(9);
		String url = http.get(域名+"/API/other/unicode.php?msg="+text);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.startsWith("ip代理库"))
	{
		String page = msg.Message_Content.substring(5).replace(" ","");
		String url = http.get("https://api.devopsclub.cn/api/proxypool?page=" + page);
		String text = url.replace("[","").replace("]","").replace("{","").replace("}","").replace("\"","").replace(",","\n").replace(" ","");
		String text = text.replace("port","端口").replace("ip","\n\nip").replace("anonymity","匿名类型").replace("protocol","协议类型").replace("country","所在国家").replace("address","所在地区").replace("speed","速度").replace("verify_time","最后效验时间").replace("pages","总页数").replace("msg","内容");
	    MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@"+msg.nickName+"\n内容太多，会造成刷屏\n所以私发给你了");
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin,"@"+msg.nickName+"\n代理库:" + text+"现在是第"+page+"页\n更多参数:ip代理库1\n1代表第1页\n更多请耐心等待更新");
			return false;
	}
	if(msg.Message_Content.startsWith("访问"))
	{
		String text = msg.Message_Content.substring(2).replace(" ","");
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@" + msg.nickName+"\n"+http.get(text));
		return false;
	}
		if(msg.Message_Content.startsWith("发图"))
	{
		String text = msg.Message_Content.substring(2);
	MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, text);
		return false;
	}
		if(msg.Message_Content.startsWith("摩斯电码加密"))
	{
		String text = msg.Message_Content.substring(4);
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@" + msg.nickName+"\n"+http.get("https://yingy.20wl.co/Api/php/morse?msg="+text+"&type=encode"));
		return false;
	}
		if(msg.Message_Content.startsWith("摩斯电码解密"))
	{
		String text = msg.Message_Content.substring(4);
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@" + msg.nickName+"\n"+http.get("https://yingy.20wl.co/Api/php/morse?msg="+text+"&type=decode"));
		return false;
	}
	if(msg.Message_Content.startsWith("MD加密"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@" + msg.nickName+"\n"+http.get("http://lost.52msr.cn/md5/api.php?msg="+text));
		return false;
	} if(msg.Message_Content.equals("文字加解密"))
	{       
	            String png = http.get("http://xingchen666.cqdm.xyz/api/picture.php?msg=动漫");
       MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin,"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?><msg serviceID=\"108\" templateID=\"1\" action=\"web\" brief=\""+name+"文字加解密\" sourceMsgId=\"0\" url=\"https://youxi.vip.qq.com/m/act\" flag=\"0\" adverSign=\"0\" multiMsgFlag=\"0\"><item layout=\"2\" advertiser_id=\"0\" aid=\"0\"><picture cover=\""+xmlImages+"\" w=\"0\" h=\"0\" /><title>"+name+"文字加解密</title><summary>↓点击下面按钮进行操作↓</summary></item><source name=\"点击我进行在线操作哦\" icon=\"http://t.cn/RVIeaZK\" url=\"https://sym233.github.io/core-values-encoder/\" action=\"web\" appid=\"-1\" /></msg>");
       }
	  if(msg.Message_Content.startsWith("64加密"))
	{
		String text = msg.Message_Content.substring(4);
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要加密的内容");
			return false;
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, http.get(域名+"/API/other/base64.php?data=&msg="+text+"&type="));
	}
	if(msg.Message_Content.startsWith("64解密"))
	{
		String text = msg.Message_Content.substring(4);
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要解密的内容");
			return false;
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, http.get(域名+"/API/other/base64.php?data=&msg="+text+"&type=1"));
	}     
		  if(msg.Message_Content.startsWith("MD5加密"))
	{
		String text = msg.Message_Content.substring(5);
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要加密的内容");
			return false;
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@"+msg.nickName+"\n加密完成\n当前加密的内容为:"+text+"\n加密的结果为:↓\n————————————\n↓↓↓↓↓↓↓↓↓↓↓↓");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "叮！"+http.get("http://api.tianyi2006.xyz/api/md5.php?act=加密&md5=" + text));
	}
	if(msg.Message_Content.startsWith("MD5解密"))
	{
		String text = msg.Message_Content.substring(5);
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要解密的内容");
			return false;
		}
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@"+msg.nickName+"\n解密完成\n当前解密的内容为:"+text+"\n解密的结果为:↓\n————————————\n↓↓↓↓↓↓↓↓↓↓↓↓");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "叮！"+http.get("http://api.tianyi2006.xyz/api/md5.php?act=解密&md5=" + text));
	}     
	if(msg.Message_Content.startsWith(X("筈吼拄搨")))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@" + msg.nickName+"\n"+http.get("http://lost.52msr.cn/dksm/api.php?ip="+text+"&n="+name));
		return false;
	}	
 	if(msg.Message_Content.startsWith(X("堸呦栾谻")))
	{
		String text = msg.Message_Content.substring(4);
		if(text.contains("/"))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "输入有误,请勿包含斜杠等");
			return false;
		}
		JSONObject json = new JSONObject(http.get("https://api.devopsclub.cn/api/whoisquery?type=json&domain=" + text));
		String result = json.getJSONObject("data").getString("data");
		int index = result.indexOf("information");
		if(index != -1) result = result.substring(0, index - 10);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "查询结果如下:\n" + result);
	}
if(msg.Message_Content.startsWith("备案查询"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
		JSONObject json = new JSONObject(http.get("http://ai.kenaisq.top/API/bacx.php?url="+ text+"&type="));
		String Name = json.getJSONObject("data").getString("organizer");
		String xz = json.getJSONObject("data").getString("Organizers nature");
		String icp = json.getJSONObject("data").getString("Site for the record");
		String name = json.getJSONObject("data").getString("Site Name");
		String ym = json.getJSONObject("data").getString("Home Address");
		String tim = json.getJSONObject("data").getString("Review time");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@"+msg.nickName+"\n名字:" + Name+"\n性质:" + xz+"\n备案号:"+ icp+"\n名称:" + name+"\n首页:" + ym+"\n时间:"+ tim);
		return false;
	}

	if(msg.Message_Content.startsWith("IP定位"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
	JSONObject json = new JSONObject(http.get("http://www.xiaojieapi.cn/API/Positioning.php?ip=" + text));
        String N = json.getJSONObject("data").getString("Accuracy");		
        String Y = json.getJSONObject("data").getString("Latitude");		
        String NAME = json.getJSONObject("data").getString("address");		
		String text = "{\"app\":\"com.tencent.map\",\"desc\":\"地图\",\"view\":\"LocationShare\",\"ver\":\"0.0.0.1\",\"prompt\":\"[应用]地图\",\"from\":1,\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"Location.Search\":{\"id\":\"9244204906666984707\",\"name\":\""+name+"IP定位\",\"address\":\""+NAME+"\",\"lat\":\""+Y+"\",\"lng\":\""+N+"\",\"from\":\"plusPanel\"}},\"config\":{\"forward\":1,\"autosize\":1,\"type\":\"card\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
		 MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin,text);         

		return false;
	}
	if(msg.Message_Content.startsWith("异常查询"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");
			JSONObject json = new JSONObject(http.get("https://api.oioweb.cn/api/ymjc.php?url=" + text));
		String aq = json.getJSONObject("data").getString("Wording");
		String bq= json.getJSONObject("data").getString("whitetype");
		String cq= json.getJSONObject("data").getString("WordingTitle");
		String dq= json.getJSONObject("data").getString("ICPSerial");
		String eq= json.getJSONObject("data").getString("Orgnization");
		String tex = "网站状态:1:'未知',2:'危险',3:'安全\n"+bq+"网站安全提示:\n"+aq+"网站域名:\n"+text+"风险标题:\n"+cq+"网站安全提示:\n"+dq+"网站安全提示:\n"+eq;
		 MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin,tex);         

		return false;
	}
	if(msg.Message_Content.startsWith("收录量查询"))
	{
		String text = msg.Message_Content.substring(5).replace(" ","");
		JSONObject json = new JSONObject(http.get("https://api.oioweb.cn/api/baidu.php?url=" + text));
     	String tim = json.getString("datetime");
		String sopag = json.getJSONObject("data").getString("SoPages");
		String Sogou = json.getJSONObject("data").getString("SogouPages");
		String Baidu = json.getJSONObject("data").getString("BaiduSiteIndex");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@"+msg.nickName+"\n收录时间" + tim+"\n百度收录:" + Baidu+"\n搜狗收录:"+ Sogou+"\n360收录:"+sopag);
		return false;
	}
	if(msg.Message_Content.startsWith("查网站"))
	{
		String text = msg.Message_Content.substring(3).replace(" ","");
		JSONObject json = new JSONObject(http.get("https://api.oioweb.cn/api/dns.php?url=" + text));
		String url = json.getJSONObject("data").getString("url").replace("[","").replace("]","").replace("\"","").replace(",","\n");
		String name = json.getJSONObject("data").getString("title").replace("[","").replace("]","").replace("\"","").replace(",","\n");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,"@"+msg.nickName+"\n同网站ip下的域名:\n" + url+"\n对应域名名称:\n"+ name);
		return false;
	}
	
	return false;
}