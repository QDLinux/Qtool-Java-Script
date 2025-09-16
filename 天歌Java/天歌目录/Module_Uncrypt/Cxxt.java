
public boolean Module_查询(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "查询系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	String 域名 = item.GetItemData("Api", "域名", "地址", "1");

           if(msg.Message_Content.startsWith("选"))
			{
		String xh = msg.Message_Content.substring(1).replace(" ","");
		String group = msg.Message_GroupUin;
		String uin = mQQ;
		String text = item.GetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin);
	       if(item.GetItemDataInt(msg.Message_GroupUin, "AllFlags", "类型", uin) == 27)
			{
		String data = http.get("http://api.tangdouz.com/xf.php?nr="+text+"&xz="+xh);
		data=data.replaceAll("\\\\r","\n");
        MyMsg.FixAndSendMsg(msg.Message_GroupUin, data,DefInfo.CardDefImages,false);
		return true; 
        }
        }
            if(msg.Message_Content.startsWith("刑法"))
			{
	String text = msg.Message_Content.substring(2).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『刑法+关键词』");
			return false;
		}
			String group = msg.Message_GroupUin;
		String uin = mQQ;
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "多选", uin, text);
		item.SetItemData(msg.Message_GroupUin, "AllFlags", "类型", uin, "27");
		String data = http.get("http://api.tangdouz.com/xf.php?nr="+text);
			data=data.replaceAll("\\\\r","\n");
        MyMsg.FixAndSendMsg(msg.Message_GroupUin, data+"\n发送选序号进行选择\n",DefInfo.CardDefImages,false);
		return true; 
        }
         	if(msg.Message_Content.startsWith("介绍英雄"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『介绍英雄+王者英雄名』");
			return false;
		}
	String url = "http://hm.suol.cc/API/wzry_pic.php?msg="+text;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
 		if(msg.Message_Content.startsWith("查询战力"))
		{	
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入查询战力+英雄");
			return false;
		}
		String qq = http.get(域名+"/API/other/wzzl.php?msg="+text);
		JSONObject b=new JSONObject(qq);//json解析
		String title=b.getString("title");
		String content=b.getString("content");
			MyMsg.FixAndSendMsg(msg.Message_GroupUin, title+"\n"+content,DefInfo.CardDefImages,false);
		return true; 
		}
       /*
			if(msg.Message_Content.startsWith("超级查询@"))
	{
		   String text= msg.atList[0];
		   	if(text.equals("484151048"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ:484151048"+"\n"+"昵称:天歌"+"\n"+"提示:"+"\n"+"嗯？敢查作者，你是不是飘了");
			  return false;
			}
			try
			{
//估价
	String gujia = http.get(域名+"/API/other/gujia.php?data=&qq="+text);
//绑
	String bang = http.get("http://api.ovoaa.cn/api/chabang.php?qq="+text);
    JSONObject e=new JSONObject(bang);//json解析
		String phone=e.getString("phone");
		String phonediqu=e.getString("phonediqu");
		String	message = e.getString("message");
		String 	lol = e.getString("lol");
	    String	wb = e.getString("wb");
		String	qqlm = e.getString("qqlm");
		 	//河北省山西省辽宁省吉林省黑龙江江苏浙江安徽福建江西省山东省河南省湖北省湖南省广东省海南省四川省贵州云南省陕西省甘肃省青海台湾省北京天津上海重庆河北省山西省辽宁省吉林省黑龙江江苏浙江安徽福建江西省山东省河南省湖北省湖南省广东省海南省四川省贵州云南省陕西省甘肃省青海台湾省广西省壮族自治区内蒙古省自治区西藏省自治区宁夏省回族自治区新疆省维吾尔自治区香港特别行政区澳门特别行政区
		 	phonediqu=phonediqu.replace("河北省","").replace("山西省","").replace("辽宁省","").replace("吉林省","").replace("黑龙江","").replace("江苏","").replace("浙江","").replace("安徽","").replace("福建","").replace("江西省","").replace("山东省","").replace("河南省","").replace("湖北省","").replace("湖南省","").replace("广东省","").replace("海南省","").replace("四川省","").replace("陕西省","").replace("云南省","").replace("甘肃省","").replace("台湾省","").replace("广西省","").replace("内蒙古省","").replace("西藏省","").replace("宁夏省","").replace("新疆省","").replace("电信","").replace("联通","").replace("移动","").replace("重庆","").replace("贵州","").replace("市","");
//邮编
		 	String youbian = http.get(域名+"/API/other/yzbm.php?msg="+phonediqu).replace(" ","");
//天气
		 	String tianqi = http.get("http://xiaoapi.cn/API/zs_tq.php?type=cytq&msg="+phonediqu+"&num=20&n=1");
		JSONObject tq=new JSONObject(tianqi);//json解析
		String keyWord=tq.getString("keyWord");
		//String name=tq.getString("name");
		String jttq=tq.getString("data");
//疫情
		 	String yiqing = http.get("http://lkaa.top/API/yiqing/api?type=text&msg="+phonediqu);
		 	yiqing = yiqing.replace("±img=","").replace("±","");
		 
		 	//头/名
		 	String duo =http.get("http://api.tangdouz.com/qq.php?qq="+text);
		JSONObject b=new JSONObject(duo);//json解析
		String imgurl=b.getString("imgurl");
		String name=b.getString("name");
//人品
		String jixiong = http.get("http://ovooa.com/API/Ren/?name="+name);
		JSONObject b=new JSONObject(jixiong);//json解析
		String jtjx=b.getString("text");
//次元
		   String erci = http.get("http://ovooa.com/API/Ser/api?name="+name+"&type=text");

	
MyMsgApi.Message_Send_Group(msg.Message_GroupUin,   "『此功能仅供娱乐』"+"\n\n"+"查询状态:"+message+"\n昵称:"+name+"\n头像:[PicUrl="+imgurl+"]\n"+"电话:"+phone+"\n"+"归属地:"+phonediqu+"\n"+"LOL:"+lol+"\n"+"微博:"+wb+"\n"+"微博地址:https://m.weibo.cn/"+wb+"\n"+"QQ老密:"+qqlm+"\n邮政编码:"+youbian+"\n"+"QQ邮箱:"+text+"@qq.com"+"\n"+"QQ空间:http://"+text+".qzone.qq.com"+"\n"+"QQ估价:"+gujia+"\n当地天气:"+jttq+"\n当地疫情:\n"+yiqing+"\n"+"QQ吉凶:"+jtjx+"\n二次元里的"+name+":"+erci+"\n—————————————\n"+"天歌Java技术支持");
}
	catch(Exception e)
		{
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin,"未查询到结果！");
		}
}
if(msg.Message_Content.startsWith("超级查询 "))
	{
		  String text = msg.Message_Content.substring(5).replace(" ","").replace("+","").replace("＋","");
		   	if(text.equals("484151048"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ:484151048"+"\n"+"昵称:天歌"+"\n"+"提示:"+"\n"+"嗯？敢查作者，你是不是飘了");
			  return false;
			}
			try
			{
//估价
	String gujia = http.get(域名+"/API/other/gujia.php?data=&qq="+text);
//绑
	String bang = http.get("http://api.ovoaa.cn/api/chabang.php?qq="+text);
    JSONObject e=new JSONObject(bang);//json解析
		String phone=e.getString("phone");
		String phonediqu=e.getString("phonediqu");
		String	message = e.getString("message");
		String 	lol = e.getString("lol");
	    String	wb = e.getString("wb");
		String	qqlm = e.getString("qqlm");
		 	//河北省山西省辽宁省吉林省黑龙江江苏浙江安徽福建江西省山东省河南省湖北省湖南省广东省海南省四川省贵州云南省陕西省甘肃省青海台湾省北京天津上海重庆河北省山西省辽宁省吉林省黑龙江江苏浙江安徽福建江西省山东省河南省湖北省湖南省广东省海南省四川省贵州云南省陕西省甘肃省青海台湾省广西省壮族自治区内蒙古省自治区西藏省自治区宁夏省回族自治区新疆省维吾尔自治区香港特别行政区澳门特别行政区
		 	phonediqu=phonediqu.replace("河北省","").replace("山西省","").replace("辽宁省","").replace("吉林省","").replace("黑龙江","").replace("江苏","").replace("浙江","").replace("安徽","").replace("福建","").replace("江西省","").replace("山东省","").replace("河南省","").replace("湖北省","").replace("湖南省","").replace("广东省","").replace("海南省","").replace("四川省","").replace("陕西省","").replace("云南省","").replace("甘肃省","").replace("台湾省","").replace("广西省","").replace("内蒙古省","").replace("西藏省","").replace("宁夏省","").replace("新疆省","").replace("电信","").replace("联通","").replace("移动","").replace("重庆","").replace("贵州","").replace("市","");
//邮编
		 	String youbian = http.get(域名+"/API/other/yzbm.php?msg="+phonediqu).replace(" ","");
//天气
		 	String tianqi = http.get("http://xiaoapi.cn/API/zs_tq.php?type=cytq&msg="+phonediqu+"&num=20&n=1");
		JSONObject tq=new JSONObject(tianqi);//json解析
		String keyWord=tq.getString("keyWord");
		//String name=tq.getString("name");
		String jttq=tq.getString("data");
//疫情
		 	String yiqing = http.get("http://lkaa.top/API/yiqing/api?type=text&msg="+phonediqu);
		 	yiqing = yiqing.replace("±img=","").replace("±","");
		 
		 	//头/名
		 	String duo =http.get("http://api.tangdouz.com/qq.php?qq="+text);
		JSONObject b=new JSONObject(duo);//json解析
		String imgurl=b.getString("imgurl");
		String name=b.getString("name");
//人品
		String jixiong = http.get("http://ovooa.com/API/Ren/?name="+name);
		JSONObject b=new JSONObject(jixiong);//json解析
		String jtjx=b.getString("text");
//次元
		   String erci = http.get("http://ovooa.com/API/Ser/api?name="+name+"&type=text");

	
MyMsgApi.Message_Send_Group(msg.Message_GroupUin,   "『此功能仅供娱乐』"+"\n\n"+"查询状态:"+message+"\n昵称:"+name+"\n头像:[PicUrl="+imgurl+"]\n"+"电话:"+phone+"\n"+"归属地:"+phonediqu+"\n"+"LOL:"+lol+"\n"+"微博:"+wb+"\n"+"微博地址:https://m.weibo.cn/"+wb+"\n"+"QQ老密:"+qqlm+"\n邮政编码:"+youbian+"\n"+"QQ邮箱:"+text+"@qq.com"+"\n"+"QQ空间:http://"+text+".qzone.qq.com"+"\n"+"QQ估价:"+gujia+"\n当地天气:"+jttq+"\n当地疫情:\n"+yiqing+"\n"+"QQ吉凶:"+jtjx+"\n二次元里的"+name+":"+erci+"\n—————————————\n"+"天歌Java技术支持");
}
	catch(Exception e)
		{
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, msg.Message_UserUin,"未查询到结果！");
		}
}
*/
if(msg.Message_Content.startsWith("学习通泄漏"))
	{
		String text = msg.Message_Content.substring(5);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『学习通泄漏+学校』");
			return false;
		}
		String url = http.get("http://tfkapi.top/API/xxtxl.php?msg="+text);
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,url,DefInfo.CardDefImages,false);
		return true;
	}
	
			if(msg.Message_Content.startsWith("手机反查"))
	{
	
		String text = msg.Message_Content.substring(4).replace(" ","").replace("+","").replace("＋","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『手机反查+手机号』");
			return false;
		}
			if(msg.Message_UserUin.equals(mQQ))
	{
	try
{
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"&spec=640"+"]\n结果私发给主人您了…");
String url =http.get("http://175.178.188.119/API/cx.php?type=qq&msg="+text);
JSONObject b=new JSONObject(url);//json解析
		String qq=b.getString("qq");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, qq);
		}
			catch(Exception e)
		{
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, "库中无此号记录");
		}
	return false;
	}
     String pskey = item.GetItemData("cookie", "pay", mQQ, "pskey");			
String skey = item.GetItemData("cookie", "pay", mQQ, "skey");
String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je=10"));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "¶ 申请:『手机反查』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"&spec=640"+"]\n¶ 名称:"+msg.nickName+"\n¶ 所需:0.1r"+"\n¶ 限时:60秒\n¶ 惩罚:禁言10分钟");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 60);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=60;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je=5&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"&spec=640"+"]\n支付成功,结果私发…");
try
{
String url =http.get("http://175.178.188.119/API/cx.php?type=qq&msg="+text);
JSONObject b=new JSONObject(url);//json解析
		String qq=b.getString("qq");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, qq);
		}
			catch(Exception e)
		{
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin,"未查询到结果！");
		}
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, "¶ 申请:『手机反查』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n¶ 名称:"+msg.nickName+"\n¶ 账号:"+msg.Message_UserUin+"\n¶ 状态:支付0.1r成功✅");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 0);
oki=true;
break;
//结束循环
}
Thread.sleep(1000);
//循环一次之后的延迟
}
//判断,如果超时......
if(!oki){
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je=10&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, "¶ 申请:『手机反查』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n¶ 名称:"+msg.nickName+"\n¶ 账号:"+msg.Message_UserUin+"\n¶ 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je=10&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}

}

		if(msg.Message_Content.startsWith("身份证解析"))
	{
		String text = msg.Message_Content.substring(5).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入身份证号");
			return false;
		}
		String url =http.get("https://api.linhun.vip/api/idcard?number="+text);
		JSONObject b=new JSONObject(url);//json解析
		String msg=b.getString("msg");
		String num=b.getString("num");
		String sex=b.getString("sex");
		String time=b.getString("time");
		String age=b.getString("age");
		String animal=b.getString("animal");
		String sign=b.getString("sign");
		String add=b.getString("add");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@"+msg.nickName+msg.Message_UserUin+"\n查询状态:"+msg+"\n解析身份证号:"+num+"\n性别:"+sex+"\n出生日期:"+time+"\n年龄:"+age+"\n生肖:"+animal+"\n星座:"+sign+"\n出生地:"+add);
	
	}
if(msg.Message_Content.startsWith("同名查询"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "未输入姓名");
			return false;
		}
		String url = http.get("http://tfkapi.top/API/tongming.php?msg="+text+"&type=txt");
MyMsg.FixAndSendMsg(msg.Message_GroupUin,"全国"+url,DefInfo.CardDefImages,false);
		return true;
		}
	
			if(msg.Message_Content.startsWith("QQ天气"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要查询的地区");
			return false;
		}
		String url = http.get(域名+"/API/other/qq_weather.php?data=&msg="+text);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("密码强度"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『密码强度+要测试的密码』");
			return false;
		}
		String url = http.get("http://tianyi.qrspeed.pro/api/mmqd.php?mm=tianyi719&type="+text);
		JSONObject b=new JSONObject(url);//json解析
		String safety_margin=b.getString("safety_margin");
		String Test_prompt=b.getString("Test_prompt");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "安全系数:"+safety_margin+"\n密码强度:"+Test_prompt);
		}
	
			if(msg.Message_Content.startsWith("查询读音"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/other/py.php?msg="+text);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	
			if(msg.Message_Content.startsWith("我的世界"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『我的世界+人物』");
			return false;
		}
		String url = http.get("http://api.tangdouz.com/mcwiki.php?nr="+text+"&return=text");
		url = url.replace("±img=","[PicUrl=").replace("±","]").replaceAll("\\\\r","\n");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}	
			if(msg.Message_Content.equals("降雨查询"))
		{	
		String url = http.get("http://tianyi.qrspeed.pro/api/jiangyu.php");
		url=url.replace("天一API降雨查询\n━━━━━━━━━","").replace("±","").replace("img=","").replace("━━━━━━━━━\nTips:天一API技术支持","");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("QQ估价"))
		{
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "https://c.51240.com/temp/qqjiazhi/"+msg.Message_UserUin+".jpg");
		}
		
	if(msg.Message_Content.startsWith("估价"))
		{
			String text = msg.Message_Content.substring(2);
			if(text.startsWith("1000"))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "---指令超管Java---\n@"+msg.nickName+"你输入的QQ号不对喔~");
				return ;
			}
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "https://c.51240.com/temp/qqjiazhi/"+text+".jpg");
		}
		if(msg.Message_Content.equals("我的有缘人"))
		{
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "https://c.bmcx.com/temp/qqyouyuanren/"+msg.Message_UserUin+".jpg?v=1");
		}
			if(msg.Message_Content.startsWith("查询梗"))
		{
		String text = msg.Message_Content.substring(3);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要查询的梗");
			return false;
		}
		String url = http.get(域名+"/API/other/gzsss.php?msg="+text);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("邮编查询"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入邮编查询+地区");
			return false;
		}
		String url = http.get(域名+"/API/other/yzbm.php?msg="+text);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		
			if(msg.Message_Content.startsWith("卡片天气"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『卡片天气+城市』");
			return false;
		}
		String url = http.get("http://tianyi.qrspeed.pro/api/kptq.php?msg="+text);
		url=url.replace("json:","");
		MyMsgApi.Message_Send_Group_Card(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("车牌查询"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入车牌查询+车牌号");
			return false;
		}
		String url = http.get(域名+"/API/other/cpcx.php?msg="+text);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.startsWith("梗排行"))
		{
		String url = http.get(域名+"/API/other/gzsph.php?type=&n=");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
			if(msg.Message_Content.equals("地震查询"))
		{
		String url = http.get("http://hm.suol.cc/API/dzxx.php");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "╭───────────╮\n\n\n"+url+"\n\n\n╰───────────╯");
		}
			if(msg.Message_Content.equals("访客查询"))
		{
		String url = http.get("http://qxu66.top/api/cfk/api.php?qq="+msg.Message_UserUin);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		           	if(msg.Message_Content.equals("奥运榜单"))
		{	
		String url = http.get(域名+"/API/other/ayh.php?type=text&max=10");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		     	if(msg.Message_Content.equals("冬奥榜单"))
		{	
		String url = http.get(域名+"/API/other/beijing.php");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
 if(msg.Message_Content.startsWith("查询天气"))
	{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的地区");
			return false;
		}
		try
		{
			String mStr = http.get("http://jiuli.xiaoapi.cn/i/tianqi.php?city="+text);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, mStr);
			}
		catch(Exception e)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "查不到");
		}
	}
	if(msg.Message_Content.startsWith("查询汉字"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get("https://api.xingzhige.com/API/chazi/api.php?msg="+text);
		url=url.replace("±img=","图片参考").replace("±","");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		
		if(msg.Message_Content.startsWith("查询信息"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的账号");
			return false;
		}
		String url = http.get("http://shengapi.cn/skey/qqzl.php?qq="+text);
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}




	
			if(msg.Message_Content.equals("抖音正能量"))
	{
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,http.get(域名+"/API/other/dy_znl.php"),DefInfo.CardDefImages,false);
		return true;
	}
		if(msg.Message_Content.equals("抖音视频榜"))
	{
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,http.get(域名+"/API/other/dy_sp.php"),DefInfo.CardDefImages,false);
		return true;
	}	if(msg.Message_Content.equals("抖音热搜榜"))
	{
		MyMsg.FixAndSendMsg(msg.Message_GroupUin,http.get(域名+"/API/other/dy.php"),DefInfo.CardDefImages,false);
		return true;
	}
			if(msg.Message_Content.startsWith("微博信息"))
		{	String text = msg.Message_Content.substring(2);
		String url = http.get("http://tianyi.qrspeed.pro/api/weibo.php?uid="+text);
		url=url.replace("img=","").replace("±","").replace("Tips:天一API技术支持","");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	
	
			if(msg.Message_Content.startsWith("代挂查询"))
	{
		String uin = msg.Message_Content.substring(4);
		if(uin.equals("")) uin = msg.Message_UserUin;
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, http.get(ServiceRoot +"recall/dg?qq="+ uin), DefInfo.CardDefImages, false);
	}
	if(msg.Message_Content.startsWith("查询星座"))
		{
		String text = msg.Message_Content.substring(4);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的星座");
			return false;
		}
		String url = http.get(域名+"/API/other/conste.php?msg="+text);
		url=url.replace("查询星座"," 查询星座");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
		
		if(msg.Message_Content.startsWith("QR授权查询"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的账号");
			return false;
		}
		String url = http.get("https://api.xingzhige.com/API/QR/api.php?qq="+text);
		url=url.replace("{","").replace("}","").replace("text","查询结果");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
		}
	if(msg.Message_Content.startsWith("疫情查询"))	{
		String text = msg.Message_Content.substring(4).replace("","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入疫情查询+省级地区");
			return false;
		}
		try
		{
		String url = http.get(域名+"/API/other/yiqing.php?msg="+text);
        JSONObject b=new JSONObject(url);//json解析
		String year=b.getString("year");
		String date=b.getString("date");
		String country=b.getString("country");
		String province=b.getString("province");
		String confirm=b.getString("confirm");
		String dead=b.getString("dead");
		String heal=b.getString("heal");
		String confirm_add=b.getString("confirm_add");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "地区:"+country+"-"+province+"\n时间:"+year+"."+date+"\n累计确诊:"+confirm+"\n累计死亡:"+dead+"\n累计治愈:"+heal+"\n新增确诊:"+confirm_add);
	  	  }
	  	 	catch(Exception e)
	  	  {
	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "确定输入的省？眼睛没问题吧");
		}
}

      		if(msg.Message_Content.startsWith("快递查询"))
	{       
	String text = msg.Message_Content.substring(4);
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『快递查询+快递单号』");
			return false;
		}
	   String url =http.get("https://api.cuol.cc/api/kdcx?dh="+text);
               MyMsgApi.Message_Send_Group(msg.Message_GroupUin, url);
               }
               	if(msg.Message_Content.startsWith("查头像@"))
      		{
      				for(String XIAOB: msg.atList)
			      		{
      			
      		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin,"http://api.nanyinet.com/api/qq/api.php?qq=" +XIAOB);
      			}   
      	} 
      	
	if(msg.Message_Content.startsWith("查昵称@"))
      		{
      				for(String NICHENG: msg.atList)
			      		{
      			
      			NICHENG = http.get("http://lingyu.asia/api/qqnick.php?qq="+NICHENG);
      			MyMsgApi.Message_Send_Group(msg.Message_GroupUin,NICHENG);
      			}   
      	} 		return false;
}