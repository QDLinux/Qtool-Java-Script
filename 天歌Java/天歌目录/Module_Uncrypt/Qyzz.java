
HashMap VerHashInMap = new HashMap();
    public boolean Module_群员自助(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "群员自助")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	String 域名 = item.GetItemData("Api", "域名", "地址", "1");

if(msg.Message_UserUin.equals(mQQ))
	{
    if(msg.Message_Content.startsWith("群收款@"))
	{
      	String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
		String text = msg.Message_Content.substring(index + 1);
       			

String collection_no = item.GetItemData("cookie", "pay", strQQ, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+text));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", strQQ, "collectionno", collection_no);
//MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 『群收款』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n 所需:"+text+"分\n 限时:120秒");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, strQQ, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+text+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+strQQ+"]群收款完成✅");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 『群收款』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n 账号:"+strQQ+"\n 状态:支付"+text+"分成功✅");

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, strQQ, 0);
oki=true;
break;
//结束循环
}
Thread.sleep(1000);
//循环一次之后的延迟
}
//判断,如果超时......
if(!oki){
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+text+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n支付超时订单取消");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 『群收款』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n 账号:"+strQQ+"\n 状态:支付"+text+"分失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+text+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
}
	}
	

 if(msg.Message_Content.startsWith("自助查绑 "))
 {
 if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助查绑") == 1)
  {
  String text = msg.Message_Content.substring(5).replace("+","").replace("＋","");
   if(text.equals(""))
  {
   MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『自助查绑QQ』");
   return false;
  }
   if(msg.Message_UserUin.equals(mQQ))
 {
 String url2 =http.get("https://zy.xywlapi.cc/qqapi?qq="+text);
JSONObject b=new JSONObject(url2);//json解析
		String status2=b.getString("status");
		String message2=b.getString("message");
		if(status2.equals("500"))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+text+"&spec=640"+"]\n结果私发…");
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, message2);
		return false;
		}
		String phone2=b.getString("phone");
		String phonediqu2=b.getString("phonediqu");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+text+"&spec=640"+"]\n结果私发…");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, phone2+phonediqu2);
 return false;
 }
   			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助查绑")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助查绑")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+text+"&spec=640"+"]\n支付成功,结果私发…");
String url =http.get("https://zy.xywlapi.cc/qqapi?qq="+text);
JSONObject b=new JSONObject(url);//json解析
		String status=b.getString("status");
		String message=b.getString("message");
		if(status.equals("500"))
		{
		MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, message);
		return false;
		}
		String phone=b.getString("phone");
		String phonediqu=b.getString("phonediqu");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, phone+phonediqu);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助查绑』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助查绑")+"分成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/AI/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助查绑")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容 
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助查绑』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败");
String code=http.get(域名+"/AI/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助查绑")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
  }
}
if(msg.Message_Content.startsWith("赞助")){
	String text = msg.Message_Content.substring(2).replace(" ","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入赞助+金额\n—————————————\n赞助100=1r,以此类推");
			return false;
		}	
			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+text));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请在120秒内支付订单!");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+text+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功,感谢您的赞助!");
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "哇!谢谢老板");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+text+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+text+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}

}

	
	if(msg.Message_Content.equals("自助管理")){
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助管理") == 1)
		{
		if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助管理")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);
//MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 申请:『自助管理』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 所需:50r"+"\n 限时:120秒"+"\n 惩罚:禁言10分钟\n注意:支付成功后，主人(群主)需接收并允许Cookie验证");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助管理")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功\n恭喜"+msg.nickName+msg.Message_UserUin+"晋升为本群管理!");
	String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_gl.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+group+"&qq="+msg.Message_UserUin+"&op=1");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "恭喜"+msg.nickName+msg.Message_UserUin+"\n通过自助管理的支付方式被授予了管理员👑");
	  	  MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, "✨管理须知✨\n首先恭喜您通过自助支付的方式成为本群管理，管理将不能对群员踢出或禁言(以群员自助为主)，群员之间可以通过自助升/降/禁言/踢出，其次还要知道如果做出有损本群利益的事或者引发众怒，本群主将毫不留情罢免。所付费用为自愿支付，概不退还");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『管理』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助管理")+"分成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助管理")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『管理』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助管理")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}

		}}
	
	if(msg.Message_Content.startsWith("自助删管@")){
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助删管") == 1)
		{
	String strQQ= msg.atList[0];
			if(strQQ.equals("484151048"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"天歌你也敢搞？你是不是飘了");
	MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
			  return false;
			}
			if(strQQ.equals("2794619410"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"天歌的女人你也敢禁？滚出QQ");
	MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
			  return false;
			}
				if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助删管")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);
//MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 申请:『自助删管』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 所需:20r"+"\n 限时:120秒"+"\n 惩罚:禁言10分钟\n注意:支付成功后，主人(群主)需接收并允许Cookie验证");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助删管")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功\n"+msg.nickName+msg.Message_UserUin+"正在为您执行…");
	String group = msg.Message_GroupUin;
	 String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
	  String url = http.get(域名+"/API/qqgn/qun_gl.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+group+"&qq="+strQQ+"&op=0");
	  	  MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "遗憾"+strQQ+"\n降为平民");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助删管』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助删管")+"分成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助删管")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助删管』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助删管")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}

		if(msg.Message_Content.equals("自助代管")){
			if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助代管") == 1)
		{
			if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助代管")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助代管")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功,恭喜"+msg.nickName+msg.Message_UserUin+"成为代管!");
item.SetItemData(msg.Message_GroupUin, "admin", "list",msg.Message_UserUin, 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已添加以下成员为代管:\n"+msg.Message_UserUin);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助代管』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助代管")+"分成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助代管")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助代管』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助代管")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}
	
	
			if(msg.Message_Content.equals("自助白名单")){
				if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助白名单") == 1)
		{
				if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助白名单")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助白名单")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功,"+msg.nickName+msg.Message_UserUin+"恭喜加入白名单!");
item.SetItemData(msg.Message_GroupUin, "admin", "WhiteList", msg.Message_UserUin, 1);
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + msg.Message_UserUin + "已加入白名单");
//MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助白名单』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助白名单")+"成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助白名单")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助白名单』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助白名单")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}

		if(msg.Message_Content.startsWith("自助禁言 "))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助禁言") == 1)
		{
		String text = msg.Message_Content.substring(5).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『自助禁言🈳QQ』");
			return false;
		}
		if(text.equals("484151048"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"天歌你也敢搞？你是不是飘了");
	MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
			  return false;
			}
			
				if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je=50"));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);
//MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 申请:『自助禁言』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 所需:0.5r"+"\n 限时:120秒"+"\n 惩罚:禁言10分钟");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je=10&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功,已将"+text+"禁言!");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, text, 86400);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, text, "禁言Tips:\nǿ@ 群内让朋友发『自助解禁+你QQ』\nǿ@ 来自群:"+msg.Message_GroupUin);
//MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『禁言』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付0.5r成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je=50&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『禁言他人』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je=50&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}
		if(msg.Message_Content.startsWith("自助禁言@"))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助禁言") == 1)
		{
	String strQQ= msg.atList[0];
			if(strQQ.equals("484151048"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"天歌你也敢搞？你是不是飘了");
	MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
			  return false;
			}
			if(strQQ.equals("2794619410"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"天歌的女人你也敢禁？滚出QQ");
	MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
			  return false;
			}
				if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助禁言")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=60;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助禁言")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功,已将"+strQQ+"禁言!");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, strQQ, 86400);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, strQQ, "禁言Tips:\nǿ@ 群内让朋友发『解🈳你QQ』\nǿ@ 来自群:"+msg.Message_GroupUin);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助禁言』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助禁言")+"分成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助禁言")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『禁言他人』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助禁言")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}

		if(msg.Message_Content.startsWith("自助踢出 "))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助踢出") == 1)
		{
		String text = msg.Message_Content.substring(6).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『自助踢出🈳QQ』");
			return false;
		}
			if(text.equals("484151048"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"天歌你也敢搞？你是不是飘了");
	MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
			  return false;
			}
			
				if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
     			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功,已将"+text+"踢出!");
MyMsgApi.Group_Kick(msg.Message_GroupUin, text, false);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助踢出』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助踢出』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}



	if(msg.Message_Content.startsWith("自助踢出@"))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助踢出") == 1)
		{
			String strQQ= msg.atList[0];
					if(strQQ.equals("484151048"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"天歌你也敢搞？你是不是飘了");
	MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
			  return false;
			}
			if(strQQ.equals("2794619410"))
			{
	MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[AtQQ="+msg.Message_UserUin+"]\n"+"天歌的女人你也敢禁？滚出QQ");
	MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
			  return false;
			}
				if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
     			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);
//MyMsgApi.Message_Send_Group(msg.Message_GroupUin, " 申请:『自助踢出』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 所需:6r"+"\n 限时:120秒\n 惩罚:禁言10分钟");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功,已将"+strQQ+"踢出");
MyMsgApi.Group_Kick(msg.Message_GroupUin, strQQ, false);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助踢出』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助踢出』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+
pskey+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}


		if(msg.Message_Content.equals("自助全禁"))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助全禁") == 1)
		{
		if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
    			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助全禁")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助全禁")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "支付成功,正在为您全员禁言!");
MyMsgApi.Group_Forbidden_All(msg.Message_GroupUin, true);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助全禁』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助全禁")+"分成功✅");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, msg.Message_UserUin, "尊敬的老板，要解禁的时候记得告诉管理/群主哦，跟你一样的群员还都在被禁着呢");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助全禁")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『全员禁言』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助全禁")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}


		if(msg.Message_Content.startsWith("自助改名@"))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助改名") == 1)
		{
		if(msg.Message_UserUin.equals(mQQ))
		{
			Toast("自己要给自己付钱？");
			return false;
		}
    			

String collection_no = item.GetItemData("cookie", "pay", msg.Message_UserUin, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+msg.Message_UserUin+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助改名")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", msg.Message_UserUin, "collectionno", collection_no);

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 120);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助改名")+"&type=10&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@"+msg.Message_UserUin+"支付成功！");
	for(String Uin: msg.atList)
			{
				int index = msg.Message_Content.lastIndexOf(" ");
				String ChangeName = msg.Message_Content.substring(index + 1);
				item.SetItemData(msg.Message_GroupUin, Uin, "Setting", "MyName", ChangeName);
				MyMsgApi.Group_ChangeName(msg.Message_GroupUin, Uin, ChangeName);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "QQ" + Uin + "的昵称已经改名为:" + ChangeName);
			}
//MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助改名』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助改名")+"分成功✅");
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
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助改名")+"&type=10&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){

MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, 600);
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助改名』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+msg.Message_UserUin+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+msg.Message_UserUin+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq=&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助改名")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}
}



	if(msg.Message_Content.startsWith("自助解禁@"))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助解禁") == 1)
		{
			String strQQ= msg.atList[0];
 			

String collection_no = item.GetItemData("cookie", "pay", strQQ, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", strQQ, "collectionno", collection_no);

boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n自助解禁成功！");
//MyMsgApi.Group_Forbidden(data.Message_GroupUin, text, 0);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助解禁』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n 名称:"+msg.nickName+"\n 账号:"+strQQ+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"分成功✅");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, strQQ, 0);
oki=true;
break;
//结束循环
}
Thread.sleep(1000);
//循环一次之后的延迟
}
//判断,如果超时......
if(!oki){
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助解禁』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n 账号:"+strQQ+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}	
}

	if(msg.Message_Content.startsWith("自助解禁 "))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "群员自助", "自助解禁") == 1)
		{
	String strQQ = msg.Message_Content.substring(5);
 			

String collection_no = item.GetItemData("cookie", "pay", strQQ, "collectionno");
try{
JSONObject url=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")));
String collection_no=url.getString("collection_no");
String retmsg=url.getString("retmsg");
item.SetItemData("cookie", "pay", strQQ, "collectionno", collection_no);
boolean oki=false;
new java.lang.Thread(new Runnable()
{
public void run()
{
for(i=0;i<=120;i++)
{
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
//循环60次
if(code.equals("2")) 
{
//保存内容,这个保存是调用脚本里的
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n自助解禁成功！");
//MyMsgApi.Group_Forbidden(data.Message_GroupUin, text, 0);
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助解禁』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n 账号:"+strQQ+"\n 状态:支付"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"分成功✅");
MyMsgApi.Group_Forbidden(msg.Message_GroupUin, strQQ, 0);
oki=true;
break;
//结束循环
}
Thread.sleep(1000);
//循环一次之后的延迟
}
//判断,如果超时......
if(!oki){
JSONObject data=new JSONObject(http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"&type=1&collection_no="+collection_no));
String code=data.getString("state"); //获取链接内容	
if(code.equals("0")){
MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]支付超时禁言");
MyMsgApi.Message_Send_Private(msg.Message_GroupUin, mQQ, " 申请:『自助解禁』\n[PicUrl="+"https://q.qlogo.cn/headimg_dl?dst_uin="+strQQ+"\n&spec=640"+"]\n 账号:"+strQQ+"\n 状态:支付失败❌");
String code=http.get(域名+"/API/qqgn/qsk.php?data=&skey="+getSkey()+"&pskey="+getPskey("tenpay.com")+"&uin="+mQQ+"&group="+msg.Message_GroupUin+"&qq="+strQQ+"&je="+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"&type=3&collection_no="+collection_no);
}
}
}
}).start();

}catch (Throwable e){}
		}	
}
	if(msg.Message_UserUin.equals(mQQ))
	{
		if(msg.Message_Content.equals("群员自助定价"))
		{
	  Thisactivity = GetActivity();
Thisactivity.runOnUiThread(new Runnable(){
public void run(){
TextView t10 = new TextView(Thisactivity);t10.setText("请输入自助查绑的价格");
t10.setTextSize(15);t10.setTextColor(android.graphics.Color.RED);
final EditText srk0 = new EditText(Thisactivity); srk0.setHint("查绑");	
TextView t11 = new TextView(Thisactivity);t11.setText("请输入自助管理的价格");
t11.setTextSize(15);t11.setTextColor(android.graphics.Color.RED);
final EditText srk1 = new EditText(Thisactivity); srk1.setHint("自助管理");
TextView t12 = new TextView(Thisactivity);t12.setText("请输入自助删管的价格");
t12.setTextSize(15);t12.setTextColor(android.graphics.Color.RED);
final EditText srk2 = new EditText(Thisactivity); srk2.setHint("自助删管");
TextView t13 = new TextView(Thisactivity);t13.setText("请输入自助代管的价格");
t13.setTextSize(15);t13.setTextColor(android.graphics.Color.RED);
final EditText srk3 = new EditText(Thisactivity); srk3.setHint("自助代管");
TextView t14 = new TextView(Thisactivity);t14.setText("请输入自助白名单的价格");
t14.setTextSize(15);t14.setTextColor(android.graphics.Color.RED);
final EditText srk4 = new EditText(Thisactivity); srk4.setHint("自助白名单");
TextView t15 = new TextView(Thisactivity);t15.setText("请输入自助禁言的价格");
t15.setTextSize(15);t15.setTextColor(android.graphics.Color.RED);
final EditText srk5= new EditText(Thisactivity); srk5.setHint("自助禁言");
TextView t16 = new TextView(Thisactivity);t16.setText("请输入自助踢出的价格");
t16.setTextSize(15);t16.setTextColor(android.graphics.Color.RED);
final EditText srk6 = new EditText(Thisactivity); srk6.setHint("自助踢出");
TextView t17= new TextView(Thisactivity);t17.setText("请输入自助全禁的价格");
t17.setTextSize(15);t17.setTextColor(android.graphics.Color.RED);
final EditText srk7= new EditText(Thisactivity); srk7.setHint("自助全禁");
TextView t18= new TextView(Thisactivity);t18.setText("请输入自助改名的价格");
t18.setTextSize(15);t18.setTextColor(android.graphics.Color.RED);
final EditText srk8= new EditText(Thisactivity); srk8.setHint("自助改名");
TextView t19= new TextView(Thisactivity);t19.setText("请输入自助解禁的价格");
t19.setTextSize(15);t19.setTextColor(android.graphics.Color.RED);
final EditText srk9 = new EditText(Thisactivity); srk9.setHint("自助解禁");

LinearLayout layout=new LinearLayout(Thisactivity);
        layout.setOrientation(LinearLayout.VERTICAL);  
	 layout.addView(srk0);    layout.addView(t10);
      layout.addView(srk1);    layout.addView(t11);
      layout.addView(srk2);    layout.addView(t12);
      layout.addView(srk3);    layout.addView(t13);
      layout.addView(srk4);    layout.addView(t14);
	   layout.addView(srk5);    layout.addView(t15);
      layout.addView(srk6);    layout.addView(t16);
      layout.addView(srk7);    layout.addView(t17);
      layout.addView(srk8);    layout.addView(t18);
	  layout.addView(srk9);    layout.addView(t19);
//	  layout.addView(srk10);    layout.addView(t20);
AlertDialog.Builder d1=	new AlertDialog.Builder(Thisactivity, AlertDialog.THEME_HOLO_LIGHT);
		d1.setView(layout);
		d1.setTitle("必须一次性全部定价完，不能单独给一个定价（价格单位默认：分）");
		
				    d1.setPositiveButton("确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialogInterface, int i){ 
new Thread(new Runnable(){public void run(){
String 自助查绑=srk0.getText().toString();
String 自助管理=srk1.getText().toString();
String 自助删管=srk2.getText().toString();
String 自助代管=srk3.getText().toString();
String 自助白名单=srk4.getText().toString();
String 自助禁言=srk5.getText().toString();
String 自助踢出=srk6.getText().toString();  
String 自助全禁=srk7.getText().toString();
String 自助改名=srk8.getText().toString();
String 自助解禁=srk9.getText().toString();
//String 自助轰炸=srk10.getText().toString();
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助查绑", 自助查绑);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助管理", 自助管理);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助删管", 自助删管);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助代管", 自助代管);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助白名单", 自助白名单);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助禁言", 自助禁言);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出", 自助踢出);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助全禁", 自助全禁);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助改名", 自助改名);
item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁", 自助解禁);
//item.SetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助轰炸", 自助轰炸);
initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){
	AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT).create();
	alertDialog.setTitle("请核对费用（单位：分）");
	alertDialog.setMessage("自助查绑:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助查绑")+"\n自助管理:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助管理")+"\n自助删管:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助删管")+"\n自助代管:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助代管")+"\n自助白名单:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助白名单")+"\n自助禁言:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助禁言")+"\n自助踢出:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助踢出")+"\n自助全禁:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助全禁")+"\n自助改名:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助改名")+"\n自助解禁:"+item.GetItemData(msg.Message_GroupUin, "Setting", "自助定价", "自助解禁")+"\n\n—————————————\n如果检查到错误就请重新设置");
alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){}});alertDialog.show();}});
}}).start();}});
				    
				   d1.setNegativeButton("取消", new DialogInterface.OnClickListener()
	{public void onClick(DialogInterface dialogInterface, int i)
				{qptc(hm);}	});d1.show();}});
           }
	if(msg.Message_Content.equals("群员自助设置"))
		{
			qyzz(msg.Message_GroupUin);
		revokeMsg(msg.msg);
 
		}
	}
	return false;
}
public void qyzz(String GroupUin)
{
	initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
			try
			{
				final String[] items = {
					"自助查绑", "自助管理", "自助删管","自助代管","自助白名单","自助禁言","自助踢出","自助全禁","自助改名","自助解禁"
				};
				final boolean[] checkedItems = {
					false, false, false,false,false,false,false, false, false,false
				};
			checkedItems[0] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助查绑") == 1;
			checkedItems[1] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助管理") == 1;
		    checkedItems[2] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助删管") == 1;
			checkedItems[3] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助代管") == 1;
			checkedItems[4] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助白名单") == 1;
			checkedItems[5] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助禁言") == 1;
			 checkedItems[6] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助踢出") == 1;
			checkedItems[7] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助全禁") == 1;
			checkedItems[8] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助改名") == 1;
			checkedItems[9] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助解禁") == 1;
		//	checkedItems[10] = item.GetItemDataInt(GroupUin, "Setting", "群员自助", "自助轰炸") == 1;
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_LIGHT);
				alertDialog.setTitle("群员自助功能开关");
				alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener()
				{
					public void onClick(DialogInterface dialog, int which, boolean isChecked)
					{
						
					}
				});
				alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int which)
					{
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助查绑", checkedItems[0]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助管理", checkedItems[1]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助删管", checkedItems[2]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助代管", checkedItems[3]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助白名单", checkedItems[4]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助禁言", checkedItems[5]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助踢出", checkedItems[6]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助全禁", checkedItems[7]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助改名", checkedItems[8]?1:0);
						item.SetItemData(GroupUin, "Setting", "群员自助", "自助解禁", checkedItems[9]?1:0);
						//item.SetItemData(GroupUin, "Setting", "群员自助", "自助轰炸", checkedItems[10]?1:0);
					}
				});
				alertDialog.show();
			}
			catch(e)
			{
				Toast("" + e);
			}
		}
	});
}