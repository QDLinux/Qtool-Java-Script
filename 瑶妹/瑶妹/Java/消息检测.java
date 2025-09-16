public void 检测(Object data)
{
	String quntext = data.MessageContent;
	String qq = data.UserUin;
	String qun = data.GroupUin;
	String GroupUin="";
	String Group="";
	String o="";
/*
   if (quntext.matches("^[QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiop\ud800\udc00-\udbff\udfff\u0020-\u007e\r\n\u4e00-\u9fa5asdfghjklzxcvbnm&\r\n\\w\\-）【—｜】；：（\n,@\"?^=%&:/~+#!.，\n？！～、： （）]+[1-9 ][0-9 ][0-9 ][0-9 ][0-9 ]+[QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiop\ud800\udc00-\udbff\udfff\u0020-\u007e\r\n\u4e00-\u9fa5asdfghjklzxcvbnm&\r\n\\w\\-） 【—｜】；：（\n,@\"?^=%&:/~+#!.，\n？！～、：（）].*$"))
 {
 
 String regex = "([1-9][0-9]{4,20})"; // 修改正则表达式
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(quntext);
String websiteUrl = "";
if (matcher.find()) {
    websiteUrl = matcher.group(1);
}
try{
JSONObject json=new JSONObject(get("https://api.kit9.cn/api/qq_group_way/api.php?gc="+websiteUrl));
            if(json.get("code")==200){
JSONObject data = json.getJSONObject("data");
String 你好=data.getString("state");
if(你好.equals("6"))
{}else{
revokeMsg(data);
Forbidden(qun,qq,60);
sendMsg(qun, "","检测到发送了群号，为维护群内秩序，已自动禁言并撤回该消息");
}
return;
}else{
return;
}
}catch(e){
return;
}
}*/
 for(String 超级权限:超级权限){
		o=超级权限+","+o;
}

 public static boolean 检测管理(String GroupUin) { 
		return isAdmin(GroupUin, data.UserUin); 
}

	String at="[AtQQ="+data.UserUin+"]";
	String 限制=MyUin+","+o;

 if(限制.contains(data.UserUin)||读(qun,"代管",qq)==1)
 {
	if(quntext.equals("开启所有检测"))
	{
		if(是否管理(data.GroupUin)){
			if("1".equals(getString(data.GroupUin,"链接检测"))&&"1".equals(getString(data.GroupUin,"号码检测"))&&"1".equals(getString(data.GroupUin,"字数检测")))
			{
				sendm(qun,"都已经全部开启了,还开个啥?");
				return;
			}
			存(data.GroupUin,"链接检测","1");
			存(data.GroupUin,"号码检测","1");
			存(data.GroupUin,"字数检测","1");
			sendm(qun,"消息检测已全部开启");
		}
		else	{
		sendm(qun,"本账号不是本群管理,无法开启所有检测");
			}
	}


	if(quntext.equals("关闭所有检测"))
	{
		if(是否管理(data.GroupUin))
		{
			if(!"1".equals(getString(data.GroupUin,"链接检测"))&&!"1".equals(getString(data.GroupUin,"号码检测"))&&!"1".equals(getString(data.GroupUin,"字数检测")))
			{
				sendm(qun,"都已经全部关闭了,还关个啥?");
				return;
			}
			存(data.GroupUin,"链接检测",null);
			存(data.GroupUin,"号码检测",null);
			存(data.GroupUin,"字数检测",null);
			sendm(qun,"消息检测已全部关闭");
		}
		else{
			sendm(qun,"本账号都不是管理开都无法开,你还想关?");
		}
	}
}
  
if(!限制.contains(data.GroupUin)||!o.contains(qq)||读(qun,"代管",qq)!=1||读全局("全局白名单",qq)!=1||读(qun,"白名单",qq)!=1)
  {
  if(!检测管理(data.GroupUin))
  {
  int 字数=800;//设置字数上限
  if(("1".equals(getString(data.GroupUin,"字数检测"))))
   {
  if(quntext.length()>字数)
{
Forbidden(qun,qq,60);
sendMsg(qun, "",at+"\n当前字数:"+quntext.length()+"字,已超过"+字数+"字\n已自动禁言并撤回该消息");
revokeMsg(data);
}
}
if(("1".equals(getString(data.GroupUin,"号码检测"))))
   {
  if (quntext.matches("^[\r\\w\\-\n.,\n@?^=%&:/~+# _）() （，。：]+[1-9 ][0-9 ][0-9 ][0-9 ][0-9 ][0-9 ]+[\r\n\n\\w\\-\n ：。， ()（）]+[\n\\w\\-\n. ,\n）： ()（，。@?^=%&:/~+# ].*$")&&!qq.equals(MyUin)&&!o.contains(qq))
  {
  
Forbidden(qun,data.UserUin,60);
  revokeMsg(data);
  
sendMsg(qun, "", at+"\n检测到您发送了广告，为维护群内秩序，已自动禁言并撤回该消息");
 } 

}
 if(("1".equals(getString(data.GroupUin,"链接检测"))))
   {
   if (quntext.matches("^[\n\\w\\-）【】；：（\n,@\"?^=%&:/~+#!.，\n？！～、：（）]+[\n@?^=%&:/\"~+#!.；，\n？！～、：（） _=]+[QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiop\ud800\udc00-\udbff\udfff\u0020-\u007e\r\n\u4e00-\u9fa5asdfghjklzxcvbnm]+(\\.[\n]+)+([\n\\w\\-） QWERTYUIOPASDF\ud800\udc00-\udbff\udfff\u0020-\u007e\r\n\u4e00-\u9fa5GHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm（\n,@?^=%&:/~+#!.，\n？！～、：（）]*[\\w\\-@?^=%&/~；+#\n：（）  ，])?.*$")&&!quntext.contains("https://v.douyin.com/")&&!quntext.contains("https://share.huoshan.com/")&&!quntext.contains("https://weibo.com/")&&!quntext.contains("https://h5.weishi.qq.com/")&&!quntext.contains("https://xsj.qq.com/")&&!quntext.contains("https://www.ixigua.com/")&&!quntext.contains("https://share.izuiyou.com/")&&!quntext.contains("https://kg3.qq.com/")&&!quntext.contains("https://v.kuaishou.com/")&&!qq.equals(MyUin)&&!o.contains(qq)) {
  revokeMsg(data);
  Forbidden(qun,data.UserUin,60);
sendMsg(qun, "",at+ "\n检测到您发送了网址，为维护群内秩序，已自动禁言并撤回该消息");

}
}
if(("1".equals(getString(data.GroupUin,"换行检测"))))
   {
  if (quntext.matches("^[\n]+[\n]+[\n]+[\n].*$")&&!qq.equals(MyUin)&&!o.contains(qq))
  {
  
Forbidden(qun,data.UserUin,60);
  revokeMsg(data);
  
sendMsg(qun, "", at+"\n检测到您多次换行，为维护群内秩序，已自动禁言并撤回该消息");
 } 

}









if(!data.UserUin.equals(MyUin)&&!(data.mAtList!=null&&data.mAtList.size()>0&&data.mAtList.size()<15)){
		//long start = System.currentTimeMillis();
        Map m = new HashMap();
        String quntext = data.MessageContent;
        //转成数组进行遍历获getString到每个字符
        //char[] cArray = quntext.toCharArray();
        String[] cArray = quntext.split("");
        for (int index = 0; index < cArray.length;index++){
            //将获getString到的值作为键
            //计数作为值
            String c = cArray[index];
            //判断集合中是否存在键
            if (m.containsKey(c)){
                //如果存在，那么在值的后面加1
                if(m.get(c)>150){
			if(c.equals("@")||mPaint.measureText(c)==0) {
				String qun=data.GroupUin;
						String qq=data.UserUin;
						revokeMsg(data);
						Forbidden(qun,data.UserUin,2592000);
						if(mPaint.measureText(quntext)<666){
							Forbidden(qun,"",120);
							sendMsg(qun,"","\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n发现可疑消息\n已自动清屏并撤回\nQQ:"+qq+"\n已被禁言:30天\n并开启全体禁言\n两分钟后假全禁\n建议私聊辱骂它");
							Toast("群"+getGroupName(data.GroupUin)+"("+qun+")发现可疑消息\nQQ:"+qq+"\n已自动清屏并撤回");
						}else sendMsg(qun,"","发现可疑消息已自动撤回\nQQ:"+qq+"\n已被禁言:30天");
						Toast("群"+getGroupName(data.GroupUin)+"("+qun+")发现可疑消息\nQQ:"+qq+"\n已自动清屏并撤回");
						return;
                	}
                	m.put(c,0);
                }else{
                m.put(c,m.get(c)+1);
                }
                //如果不存在那么就创建一个键值用于记录
            }else {
                m.put(c,1);
            }
        }
        //m.keySet();返回集合中包含键的Set集合
       /* Set<Character> s1 = m.keySet();
        for (Character key:s1){
            //通过集合遍历得到值
            Integer value = m.get(key);
            System.out.println(key+"有"+value+"个");
        }*/
    //提示("二检测"+(System.currentTimeMillis()-start));
    }
    }
    }
}




public void 开发者(Object data)
{
	String quntext = data.MessageContent;
	String qq = data.UserUin;
	String qun = data.GroupUin;

if(quntext.equals("开"))
{
提示("yes");
}





}
