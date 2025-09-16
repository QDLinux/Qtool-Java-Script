
ArrayList pic_flag11 = new ArrayList();
ArrayList pic_flag12 = new ArrayList();
ArrayList pic_flag13 = new ArrayList();
public boolean module_图片系统(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "图片系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	String 域名 = item.GetItemData("Api", "域名", "地址", "1");

		 if(msg.Message_Content.startsWith("图片识字"))
	  {
	   	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入图片识字+图片链接");
			return false;
		}
		String url = http.get(域名+"API/img/ocr.php?url="+text);
JSONObject b=new JSONObject(url);//json解析
		String data=b.getString("data");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, data,DefInfo.CardDefImages,false);
			return false;
		}
	
			 if(msg.Message_Content.startsWith("点字阵 "))
	  {
	   String s1 = msg.Message_Content.split(" ")[1];
	   String s2 = msg.Message_Content.split(" ")[2];
	   String url=http.get("https://xiaobapi.top/api/xb/api/dot_matrix_word_chen.php?msg="+s1+"&fill="+s2);
	   JSONObject b=new JSONObject(url);//json解析
		String data=b.getString("data");
		MyMsg.FixAndSendMsg(msg.Message_GroupUin, data,DefInfo.CardDefImages,false);
			return false;
		}
		if(msg.Message_UserUin.equals(mQQ))
	{
	if(msg.Message_Content.equals("cos图"))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÁÅÑ¼ÈÌÉÁÉÒÎÇÍÉ")));
		}
	if(msg.Message_Content.equals("看美腿"))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, http.get(X("ÁÍÍÉºÉÂÍºÇÀ½ÈÎÓ¼ÈÆÁÅÑÆÍÉÁÉÒÎÇÍÉ")));
		}
		}
	
		if(msg.Message_Content.equals("绘画列表"))
	{
	JSONObject json=new JSONObject(http.get(域名+"/API/img/draw.php?id="));   
JSONArray jsonArray=json.getJSONArray("data");
String id = "";
String name = "";
String s ="\n";
for(int i = 0;i<jsonArray.length();i++)
{
	JSONObject x = jsonArray.getJSONObject(i);
	String id = String.valueOf(x.get("id"));
	name = x.get("name");
      s=s+"\n"+id+"\n";
    s=s+name+"\n";
}
MyMsg.FixAndSendMsg(msg.Message_GroupUin, s+"\n发送『绘画id+id号』",DefInfo.CardDefImages,false);
	}
	 if(msg.Message_Content.startsWith("绘画id"))
	  {
	   	String text = msg.Message_Content.substring(4).replace(" ","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入绘画id+id号");
			return false;
		}
		String url = 域名+"/API/img/draw.php?id="+text;
		 MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("合并情头 "))
		{
		try{
		   String s1 = msg.Message_Content.split(" ")[1];
		   String s2 = msg.Message_Content.split(" ")[2];
         new java.lang.Thread(new Runnable(){
			public void run(){
        String 男 = http.get("http://v.ipyingshe.net/api/Sweet/?q1="+s1+"&q2="+s2);
       String  Result_男 = 男.substring(男.indexOf("http"), 男.indexOf("png")).replace("：","");
	    String 女 = http.get("http://v.ipyingshe.net/api/Sweet/?q1="+s2+"&q2="+s1);
	     String  Result_女 = 女.substring(女.indexOf("http"), 女.indexOf("png")).replace("：","");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+Result_男+"png]\n[PicUrl="+Result_女+"png]");
			}}).start();
		}catch(Exception e){
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入合并情头[空格]qq[空格]qq");
		}
		}
if(msg.Message_Content.equals("情侣头像"))
		{
  String  a = http.get(域名+"/API/other/sweethearts.php");
  JSONObject b=new JSONObject(a);//json解析
		String url1=b.getString("url1");
		String url2=b.getString("url2");
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+url1+"]\n[PicUrl="+url2+"]");
	
		}
			if(msg.Message_Content.startsWith("装逼名片1 "))
		{
			String text = msg.Message_Content.substring(5);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『装逼名片1🈳QQ』");
			return false;
		}
			String a = "https://3g.gljlw.com/diy/zb/qqmphc/toutu.php?name="+text;
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, AppPath+"/天歌目录/图片素材/天歌Java1.png");
		}
		if(msg.Message_Content.startsWith("装逼名片1@"))
		{
			String strQQ= msg.atList[0];
			String a = "https://3g.gljlw.com/diy/zb/qqmphc/toutu.php?name="+strQQ;
					MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, AppPath+"/天歌目录/图片素材/天歌Java1.png");
		}
		if(msg.Message_Content.startsWith("装逼名片2 "))
		{
			String text = msg.Message_Content.substring(5);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『装逼名片2🈳QQ』");
			return false;
		}
			String a = "https://3g.gljlw.com/diy/zb/qqmp4/toutu.php?name="+text;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, AppPath+"/天歌目录/图片素材/天歌Java2.png");
		}
		if(msg.Message_Content.startsWith("装逼名片2@"))
		{
			String strQQ= msg.atList[0];
			String a = "https://3g.gljlw.com/diy/zb/qqmp4/toutu.php?name="+strQQ;
					MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, AppPath+"/天歌目录/图片素材/天歌Java2.png");
		}
		if(msg.Message_Content.startsWith("装逼名片3 "))
		{
			String text = msg.Message_Content.substring(5);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『装逼名片3🈳QQ』");
			return false;
		}
		   String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
		String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
			String a = "https://3g.gljlw.com/diy/zb/qqmp9/toutu.php?name="+text+"&qqid="+url;
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, AppPath+"/天歌目录/图片素材/天歌Java3.png");
		}
		if(msg.Message_Content.startsWith("装逼名片3@"))
		{
			String strQQ= msg.atList[0];
			   String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
			String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+strQQ);
			String a = "https://3g.gljlw.com/diy/zb/qqmp9/toutu.php?name="+strQQ+"&qqid="+url;
					MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, AppPath+"/天歌目录/图片素材/天歌Java3.png");
		}
			if(msg.Message_Content.startsWith("装逼名片4 "))
		{
			String text = msg.Message_Content.substring(5);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『装逼名片4🈳QQ』");
			return false;
		}
			String a = "https://3g.gljlw.com/diy/zb/qqmpfc/toutu.php?name="+text;
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, AppPath+"/天歌目录/图片素材/天歌Java4.png");
		}
		if(msg.Message_Content.startsWith("装逼名片4@"))
		{
			String strQQ= msg.atList[0];
			String a = "https://3g.gljlw.com/diy/zb/qqmpfc/toutu.php?name="+strQQ;
							MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, AppPath+"/天歌目录/图片素材/天歌Java4.png");
		}
		
		if(msg.Message_Content.startsWith("朋友说@"))
	{
		String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.tangdouz.com/wz/py.php?q="+strQQ+"&nr="+ChangeName);
	}
	
			if(msg.Message_Content.startsWith("拽 "))
		{
		   String str = msg.Message_Content.substring(2);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『拽🈳QQ🈳文字』");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
			String a = "http://api.tangdouz.com/wz/zhuai.php?q="+text+"&nr="+text2;
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
			if(msg.Message_Content.startsWith("拽@"))
	{
		String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
			String a = "http://api.tangdouz.com/wz/zhuai.php?q="+strQQ+"&nr="+ChangeName;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
				if(msg.Message_Content.startsWith("群友说 "))
		{
		   String str = msg.Message_Content.substring(4);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『群友说🈳QQ🈳文字』");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
        String a="";
for(Object group:getGroupList()){
   if(msg.Message_GroupUin.equals(group.GroupUin)){
    if(group.GroupOwner.equals(text))
    {
    	a += "http://api.tangdouz.com/wz/qunshuo.php?qq="+text+"&nr="+text2+"&sf=群主";
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
				return false;
				}
}}
		   String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
       	String group = msg.Message_GroupUin;
       String 判断管理 =http.get(域名+"/API/qqgn/qgl.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+mQQ+"&group="+group);
       if(判断管理.contains(text))
       {
       String a = "http://api.tangdouz.com/wz/qunshuo.php?qq="+text+"&nr="+text2+"&sf=管理员";
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
				return false;
       }
            String a = "http://api.tangdouz.com/wz/qunshuo.php?qq="+text+"&nr="+text2+"&sf=";
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
			if(msg.Message_Content.startsWith("群友说@"))
	{
		String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
			        String a="";
for(Object group:getGroupList()){
   if(msg.Message_GroupUin.equals(group.GroupUin)){
    if(group.GroupOwner.equals(strQQ))
    {
    	a += "http://api.tangdouz.com/wz/qunshuo.php?qq="+strQQ+"&nr="+ChangeName+"&sf=群主";
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
				return false;
				}
}} 
  String skey = getSkey();		
       String pskey = getPskey("qun.qq.com");
       	String group = msg.Message_GroupUin;
       String 判断管理 =http.get(域名+"/API/qqgn/qgl.php?data=&skey="+skey+"&pskey="+pskey+"&uin="+mQQ+"&group="+group);
       if(判断管理.contains(strQQ))
       {
       String a = "http://api.tangdouz.com/wz/qunshuo.php?qq="+strQQ+"&nr="+ChangeName+"&sf=管理员";
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
				return false;
       }
            String a = "http://api.tangdouz.com/wz/qunshuo.php?qq="+strQQ+"&nr="+ChangeName+"&sf=";
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
			if(msg.Message_Content.startsWith("资料① "))
		{
		   String str = msg.Message_Content.substring(4);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『资料①🈳QQ🈳文字(30字之内)』");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
        String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
			String a = 域名+"/API/ce/qqcard.php?qq="+text+"&name="+name+"&nick="+name+"&msg="+text2;
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
			if(msg.Message_Content.startsWith("资料①@"))
	{
		String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
			   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+strQQ);
			String a = 域名+"/API/ce/qqcard.php?qq="+strQQ+"&name="+name+"&nick="+name+"&msg="+ChangeName;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
				if(msg.Message_Content.startsWith("资料② "))
		{
		String text = msg.Message_Content.substring(4).replace(" ","").replace("+","").replace("＋","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『资料②🈳QQ』");
			return false;
		}
		   String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
		 String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
	     String data = 域名+"/API/ce/qqcard_1.php?qq="+text+"&name="+name+"&qid="+url;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
		}
			if(msg.Message_Content.startsWith("资料②@"))
		{
			String text= msg.atList[0];
	        String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
			String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
		 String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
	     String data = 域名+"/API/ce/qqcard_1.php?qq="+text+"&name="+name+"&qid="+url;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
		}
			if(msg.Message_Content.startsWith("资料③ "))
		{
		   String str = msg.Message_Content.substring(4);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『资料③🈳QQ🈳文字(30字之内)』");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
        String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
			String a = 域名+"/API/ce/qqcard_2.php?qq="+text+"&name="+name+"&nick="+name+"&msg="+text2;
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
			if(msg.Message_Content.startsWith("资料③@"))
	{
		String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
			   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+strQQ);
			String a = 域名+"/API/ce/qqcard_2.php?qq="+strQQ+"&name="+name+"&nick="+name+"&msg="+ChangeName;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
			if(msg.Message_Content.startsWith("资料④ "))
		{
		   String str = msg.Message_Content.substring(4);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『资料④🈳QQ🈳文字(30字之内)』");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
           String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
       	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
        String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
			String a = 域名+"/API/ce/qqcard_3.php?qq="+text+"&name="+name+"&qid="+url+"&msg="+text2;
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
			if(msg.Message_Content.startsWith("资料④@"))
	{
		String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
			   String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
				String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
			   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+strQQ);
			String a = 域名+"/API/ce/qqcard_3.php?qq="+strQQ+"&name="+name+"&qid="+url+"&msg="+ChangeName;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, a);
		}
			if(msg.Message_Content.startsWith("资料⑤ "))
		{
		String text = msg.Message_Content.substring(4).replace(" ","").replace("+","").replace("＋","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『资料⑤🈳QQ』");
			return false;
		}
		   String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
		 String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
	     String data = 域名+"/API/ce/qqcard_4.php?qq="+text+"&name="+name+"&qid="+url;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
		}
			if(msg.Message_Content.startsWith("资料⑤@"))
		{
			String text= msg.atList[0];
	        String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
			String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
		 String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
	     String data = 域名+"/API/ce/qqcard_4.php?qq="+text+"&name="+name+"&qid="+url;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
		}
				if(msg.Message_Content.startsWith("资料⑥ "))
		{
		String text = msg.Message_Content.substring(4).replace(" ","").replace("+","").replace("＋","");
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『资料⑥🈳QQ』");
			return false;
		}
		   String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
		 String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
	     String data = 域名+"/API/ce/qqcard_5.php?qq="+text+"&name="+name+"&qid="+url;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
		}
			if(msg.Message_Content.startsWith("资料⑥@"))
		{
			String text= msg.atList[0];
	        String skey = getSkey();		
           String pskey = getPskey("vip.qq.com");
			String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
		 String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
	     String data = 域名+"/API/ce/qqcard_5.php?qq="+text+"&name="+name+"&qid="+url;
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
		}
		 if(msg.Message_Content.startsWith("资料⑦ "))
  {
   String str = msg.Message_Content.substring(4);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入资料⑦🈳QQ🈳自定义文字");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
   
   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
      String data = 域名+"/API/ce/qqcard_6.php?qq="+text+"&msg="+text2+"&name="+name;
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
  }
   if(msg.Message_Content.startsWith("资料⑦@"))
  {
   	String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
       
   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
      String data = 域名+"/API/ce/qqcard_6.php?qq="+strQQ+"&msg="+ChangeName+"&name="+name;
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
  }
		 	 if(msg.Message_Content.startsWith("资料⑧ "))
  {
   String str = msg.Message_Content.substring(4);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入资料⑧🈳QQ🈳自定义文字");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
   	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
      String data = 域名+"/API/ce/qqcard_7.php?qq="+text+"&msg="+text2+"&name="+name+"&qid="+url;
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
  }
   if(msg.Message_Content.startsWith("资料⑧@"))
  {
   	String strQQ= msg.atList[0];
		int index = msg.Message_Content.lastIndexOf(" ");
			String  ChangeName = msg.Message_Content.substring(index + 1);
       	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+strQQ);
   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+strQQ);
      String data = 域名+"/API/ce/qqcard_7.php?qq="+strQQ+"&msg="+ChangeName+"&name="+name;
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
  }
  		 	 if(msg.Message_Content.startsWith("资料⑨ "))
  {
String text = msg.Message_Content.substring(4);
	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『资料⑨[空格]QQ』");
			return false;
		}
   	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
      String data = 域名+"/API/ce/qqcard_8.php?qq="+text+"&name="+name+"&qid="+url;
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
  }
   if(msg.Message_Content.startsWith("资料⑨@"))
  {
   	String strQQ= msg.atList[0];
       	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+strQQ);
   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+strQQ);
  String data = 域名+"/API/ce/qqcard_8.php?qq="+strQQ+"&name="+name+"&qid="+url;
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
  }
  
   if(msg.Message_Content.startsWith("资料⑩ "))
  {
String text = msg.Message_Content.substring(4);
	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入资料⑩[空格]QQ");
			return false;
		}
   	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+text);
   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+text);
     String data = 域名+"/API/ce/qqcard_9.php?qq="+text+"&name="+name+"&qid="+url;
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
  }
   if(msg.Message_Content.startsWith("资料⑩@"))
  {
   	String strQQ= msg.atList[0];
       	String url =http.get("https://xiaobapi.top/api/xb/api/QID.php?qq="+mQQ+"&skey="+skey+"&pskey="+pskey+"&qq2="+strQQ);
   String name = http.get("http://api.tangdouz.com/qqname.php?qq="+strQQ);
  String data = 域名+"/API/ce/qqcard_9.php?qq="+strQQ+"&name="+name+"&qid="+url;
  MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, data);
  }
  
  
		if(msg.Message_Content.startsWith("加水印 "))
		{
		   String str = msg.Message_Content.substring(4);
        int index=str.indexOf(" ");  
         if (index == -1)
        {
        MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『加水印🈳图片链接🈳QQ2』");
			return false;
         }
        String text=str.substring(0, index);
        String text2=str.substring(index + 1);
		String url = http.get(域名+"/API/tw/shuiyin.php?url="+text+"&msg="+text2);
		JSONObject b=new JSONObject(url);//json解析
		String img=b.getString("url");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, img);
		}
	
		if(msg.Message_Content.startsWith("你大爷"))
		{
		String text = msg.Message_Content.substring(3).replace(" ","").replace("+","").replace("＋","");
		if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『你大爷+3个字』");
			return false;
		}
	
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, 域名+"/API/gif/mdm.php?name="+text);
		}
				
		if(msg.Message_Content.startsWith("九宫切图"))
		{
			String text = msg.Message_Content.substring(4).replace(" ","");
				if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『九宫切图+图片链接』");
			return false;
		}
		String url = http.get(域名+"/API/ce/jiugg.php?url="+text);
	   JSONObject b=new JSONObject(url);//json解析
JSONObject b=b.getJSONObject("img");
String a=b.getString("1");
String c=b.getString("2");
String d=b.getString("3");
String e=b.getString("4");
String f=b.getString("5");
String g=b.getString("6");
String h=b.getString("7");
String i=b.getString("8");
String j=b.getString("9");
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "[PicUrl="+a+"][PicUrl="+j+"][PicUrl="+c+"][PicUrl="+d+"][PicUrl="+e+"][PicUrl="+f+"][PicUrl="+g+"][PicUrl="+h+"][PicUrl="+i+"]");
		}
		
			if(msg.Message_Content.startsWith("头像加框"))
			{
				String text = msg.Message_Content.substring(4).replace(" ","");
					if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『头像加框+0~120』"+"\n—————————————\n"+"头像最好是原图(注：方形化、缩小化、抠图化的头像体验感极差，不建议使用)");
			return false;
		}
		
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://ovooa.com/API/head/?QQ="+msg.Message_UserUin+"&format="+text);
		}	
			
			if(msg.Message_Content.startsWith("多字单闪签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+txet+"&lx=多字单闪签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}if(msg.Message_Content.startsWith("一笔商务签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=一笔商务签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}if(msg.Message_Content.startsWith("连笔商务签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=连笔商务签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}if(msg.Message_Content.startsWith("花鸟艺术签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=花鸟艺术签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("可爱艺术签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=可爱艺术签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("浪漫艺术签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=浪漫艺术签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("小丸子艺术签名"))
		{
		String text = msg.Message_Content.substring(7);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=小丸子艺术签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("彩色蝴蝶签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=彩色蝴蝶签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("炫酷背景签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=炫酷背景签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("明星艺术签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=明星艺术签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
		if(msg.Message_Content.startsWith("透明闪动签名"))
		{
		String text = msg.Message_Content.substring(6);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入需要的文字");
			return false;
		}
		String url = http.get(域名+"/API/img/ysqm.php?data=&msg="+text+"&lx=透明闪动签名");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, url);
		}
	
			
	  if(msg.Message_Content.startsWith("颜值鉴定"))
	{
		String text = msg.Message_Content.substring(4).replace(" ","");	if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『颜值鉴定+图片链接』");
			return false;
		}
		try
		{
		String retext =http.get("http://so.lkaa.top/image/y.php?url="+text);
	JSONObject b=new JSONObject(retext);//json解析
JSONObject b=b.getJSONObject("data");
String rep_image=b.getString("rep_image");
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, rep_image);
		}
	    catch(Exception e)
		{
		MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "无法鉴定的原因如下:\n①使用了特效\n②画质模糊\n③没露正脸\n④图片大小超过1MB\n⑤长得太丑\n—————————————\n⑤的可能性最大;\n丑是万恶之源！");
		}
	}	
		
		if(msg.Message_Content.startsWith("抠图"))
		{
		String text = msg.Message_Content.substring(2);
			if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入『抠图+图片链接』\n—————————————\n仅限白底背景的图片！");
			return false;
		}
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.tangdouz.com/wz/tm.php?lj="+text);
		}
	
		
		if(msg.Message_Content.startsWith("制作二维码"))
		{
			String text = msg.Message_Content.substring(5);
				if(text.equals(""))
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "请输入制作二维码+内容文字");
			return false;
		}
			MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://tianyi.qrspeed.pro/api/qrcode.php?text="+text+"&size=180");
		}
		if(msg.Message_Content.startsWith("v我50 "))
		{
		String text = msg.Message_Content.substring(5);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"v50/b.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("v我50@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"v50/b.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("按下 "))
		{
		String text = msg.Message_Content.substring(3);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"anniu/a.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("按下@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"anniu/a.php?qq="+text);
		}
			if(msg.Message_Content.startsWith("生无可恋 "))
		{
		String text = msg.Message_Content.substring(5);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"ddqq/y.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("生无可恋@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"ddqq/y.php?qq="+text);
		}
			if(msg.Message_Content.startsWith("没图看了 "))
		{
		String text = msg.Message_Content.substring(5);

		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"mstl/s.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("没图看了@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"mstl/s.php?qq="+text);
		}
				if(msg.Message_Content.startsWith("进群协议 "))
		{
		String text = msg.Message_Content.substring(5);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"jqxy/j.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("进群协议@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"jqxy/j.php?qq="+text);
		}
					if(msg.Message_Content.startsWith("女装协议 "))
		{
		String text = msg.Message_Content.substring(5);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"jqxy/n.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("女装协议@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"jqxy/n.php?qq="+text);
		}
					if(msg.Message_Content.startsWith("走路 "))
		{
		String text = msg.Message_Content.substring(3);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"zoul/y.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("走路@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"zoul/y.php?qq="+text);
		}
						if(msg.Message_Content.startsWith("左右摇摆 "))
		{
		String text = msg.Message_Content.substring(5);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"ajl/y.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("左右摇摆@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"ajl/y.php?qq="+text);
		}
						if(msg.Message_Content.startsWith("蜜雪冰城 "))
		{
		String text = msg.Message_Content.substring(5);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"mxbc/m.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("蜜雪冰城@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"mxbc/m.php?qq="+text);
		}
							if(msg.Message_Content.startsWith("懒羊羊 "))
		{
		String text = msg.Message_Content.substring(4);
	
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"lyy/l.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("懒羊羊@"))
		{
		 	String text= msg.atList[0];
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"lyy/l.php?qq="+text);
		}
								if(msg.Message_Content.startsWith("杜蕾斯 "))
		{
		String text = msg.Message_Content.substring(4);
		
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"byt/b.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("杜蕾斯@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"byt/b.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("身份证 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/7.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("身份证@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/7.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("看电脑 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"jupai/d.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("看电脑@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"jupai/d.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("乡下人 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/6.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("乡下人@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/6.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("电话邀请 "))
		{
		String text = msg.Message_Content.substring(5);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/3.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("电话邀请@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/3.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("入群宣誓 "))
		{
		String text = msg.Message_Content.substring(5);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/2.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("入群宣誓@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/2.php?qq="+text);
		}
			if(msg.Message_Content.startsWith("流汗豆 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/1.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("流汗豆@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"txmb/1.php?qq="+text);
		}
			if(msg.Message_Content.startsWith("泉纱雾 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"wus/w.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("泉纱雾@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"wus/w.php?qq="+text);
		}
				if(msg.Message_Content.startsWith("网络公主 "))
		{
		String text = msg.Message_Content.substring(5);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"yyy/y.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("网络公主@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://api.caonm.net/api/"+"yyy/y.php?qq="+text);
		}
				if(msg.Message_Content.startsWith("我的人 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun//"+"api/wode.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("我的人@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun//"+"api/wode.php?qq="+text);
		}
				if(msg.Message_Content.startsWith("拿手机 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun"+"/api/sj.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("拿手机@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun"+"/api/sj.php?qq="+text);
		}
				if(msg.Message_Content.startsWith("删库跑路 "))
		{
		String text = msg.Message_Content.substring(5);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun"+"/api/pao.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("删库跑路@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun"+"/api/pao.php?qq="+text);
		}
			if(msg.Message_Content.startsWith("看电视 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun"+"/api/kan.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("看电视@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun"+"/api/kan.php?qq="+text);
		}
				if(msg.Message_Content.startsWith("美女抬 "))
		{
		String text = msg.Message_Content.substring(4);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun"+"/api/tai.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("美女抬@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun"+"/api/tai.php?qq="+text);
		}
				if(msg.Message_Content.startsWith("很难办事 "))
		{
		String text = msg.Message_Content.substring(5);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun//"+"api/ban.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("很难办事@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun//"+"api/ban.php?qq="+text);
		}
			if(msg.Message_Content.startsWith("溜了 "))
		{
		String text = msg.Message_Content.substring(3);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun//"+"api/liu/liu.php?QQ="+text);
		}
		if(msg.Message_Content.startsWith("溜了@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun//"+"api/liu/liu.php?QQ="+text);
		}
				if(msg.Message_Content.startsWith("锤 "))
		{
		String text = msg.Message_Content.substring(2);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun//"+"api/chui/chui.php?QQ="+text);
		}
		if(msg.Message_Content.startsWith("锤@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "http://h.xiaocha.fun//"+"api/chui/chui.php?QQ="+text);
		}
			if(msg.Message_Content.startsWith("追 "))
		{
		String text = msg.Message_Content.substring(2);
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "https://api.caonm.net/api/zhuid/y.php?qq="+text);
		}
		if(msg.Message_Content.startsWith("追@"))
		{
		 	String text= msg.atList[0];
		MyMsgApi.Message_Send_Group_image(msg.Message_GroupUin, "https://api.caonm.net/api/zhuid/y.php?qq="+text);
		}
	return false;
}