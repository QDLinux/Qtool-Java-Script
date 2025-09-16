
public void sess(String qun,String qqh,String file,String text,Object pd)
{
File file2 = new File(file);
for(String str2 : 读取(file2))
{
//MessageType;//消息类型,1:图片或文字消息,2:卡片消息,3:图文消息,4:语音消息,5:文件消息,6:回复消息
if(str2.equals("")){}else if(text.contains(str2)){
if(pd.MessageType==2&&"1".equals(取(qun,"wjcjckp"))||pd.MessageType==1&&text.startsWith("[PicUrl=")&&"1".equals(取(qun,"wjcjctp"))||abcd(pd.MessageType)==true&&!text.startsWith("[PicUrl=")&&"1".equals(取(qun,"wjcjcwz"))||abcd(pd.MessageType)==true&&!text.startsWith("[PicUrl=")&&取(qun,"wjcjcwz")==null)
{
if(取(qun,"wjcjy")==null){wjcjy="1";}else{wjcjy="0";}
if(取(qun,"wjcch")==null){wjcch="1";}else{wjcch="0";}
if(取(qun,"wjctc")==null){wjctc="1";}else{wjctc="0";}
if(wjcjy.equals("0"))
{
if(取(qun,"wjcjysj")==null){wjcjysj="10";}else{wjcjysj=取(qun,"wjcjysj");}
int jysj = Integer.parseInt(wjcjysj)*60;
Forbidden(qun,qqh,jysj);
w=" 禁言 ";
}else{w="";}
if(wjctc.equals("0"))
{
Kick(qun,qqh,false);
p=" 踢出 ";
}else{p="";}
//1=关，0=开
if((取(qun,"sljj"))==null)
{
SDY="";
}else{
SDY="\n可以私聊我发送\"解禁"+qun+"\"即可解除禁言";
}
if(wjcch.equals("0"))
{
n=" 撤回 ";
}else{n="";}
if(w.equals("")&&n.equals("")&&p.equals("")){}else{
sendm("1",qun,"QQ"+qqh+"触犯违禁词\n已"+w+n+p+SDY);
}
}
}
}
}
public void 群管(Object data){
String 如=data.MessageContent;
String qun=data.GroupUin;
String qqh=data.UserUin;
String file = AppPath+"/从云/"+qun+"/违禁词.txt";
String file9 = AppPath+"/从云/"+qun+"/弹窗违禁词.txt";
File file6 = new File(AppPath+"/从云/"+qun+"/退群黑名单.txt");
File file2 = new File(AppPath+"/从云/"+qun+"/白名单.txt");
File file7 = new File(AppPath+"/从云/"+qun+"/代管.txt");
File file5 = new File(AppPath+"/从云/全局白名单.txt");
File file6 = new File(AppPath+"/从云/"+qun+"/退群黑名单.txt");
if("1".equals(取(qun,"kg")))
{
String hm=read(AppPath+"/从云/"+qun+"/黑名单.txt");
String tuiqun=read(AppPath+"/从云/"+qun+"/退群黑名单.txt");
String qj=read(AppPath+"/从云/全局黑名单.txt");
if(hm.contains(qqh))
{
Kick(qun,qqh,false);
String h=readb(qun,qqh,AppPath+"/从云/"+qun+"/黑名单.txt");
sendm("1",qun,"本群黑名单\n"+h+"\n已踢出");
}
if(tuiqun.contains(qqh))
{
Kick(qun,qqh,false);
sendm("1",qun,"退群黑名单\n"+qqh+"\n已踢出");
}
if(qj.contains(qqh))
{
Kick(qun,qqh,false);
String h=readb(qun,qqh,AppPath+"/从云/全局黑名单.txt");
sendm("1",qun,"全局黑名单\n"+h+"\n已踢出");
}
if("1".equals(取(qun,"tx"))){
if(如.startsWith("我要头街"))
{
sendm("2",qun,"QQ"+qqh+"\n是我要头衔(xian)不是我要头街(jie)");
}
if(如.startsWith("我要头衔"))//有能力的自己加个判断，我这边懒得写了
{
String text=如.substring(4);
{
File FI = new File(AppPath+"/从云/"+qun+"/头衔违禁词.txt");
if(read(AppPath+"/从云/"+qun+"/白名单.txt").contains(qqh)||read(AppPath+"/从云/全局白名单.txt").contains(qqh)||read(AppPath+"/从云/"+qun+"/代管.txt").contains(qqh)||qqh.equals(MyUin))
{}else{
for (String str : 读取(FI))
{
if(text.contains(str))
{
if("1".equals(取(qun,"txwjcjy")))
{
String SJ="";
if(取(qun,"txwjcjysj")==null)
{
SJ="1";
}else{
SJ=取(qun,"txwjcjysj");
}
int str2=Integer.parseInt(SJ);
Forbidden(qun,qqh,60*str2);
sendm("1",qun,qqh+"\n头衔有违禁词\n已处理");
return;
}
if("1".equals(取(qun,"txwjcch")))
{
revokeMsg(data);
sendm("1",qun,qqh+"\n头衔有违禁词\n已处理");
return;
}
}
}
}
if(text.equals(""))
{
sendm("2",qun,"QQ"+qqh+"\n输入内容为空，头衔已取消");
setTitle(qun,qqh,"");
return;
}
if(length(text)>18)
{
sendm("2",qun,"QQ"+qqh+"\n头衔字符"+length(text)+">18\n无法设置");
return;
}
if(text.contains(""))
{
sendm("2",qun,"QQ"+qqh+"\n头衔带有小表情，换个吧");
return;
}
setTitle(qun,qqh,text);
sendm("2",qun,"QQ"+qqh+"\n设置头衔成功");
}
}
}
if(judgment(qun,1,qqh)==true||qqh.equals(MyUin))
{
if(如.startsWith("禁言列表"))
	{
	    int i=1;
	    String text="";
	    List mylist=new ArrayList();
	    for(Object mlist:getForbiddenList(qun)){
	    long time = Long.valueOf(mlist.Endtime);
	    SimpleDateFormat createTime = new SimpleDateFormat("MM-dd HH:mm");
	    //createTime.format(new Date(time));
	        text+=i+":昵称:"+mlist.UserName+"\nQQ:"+mlist.UserUin+"\n"+createTime.format(new Date(time))+"\n";
	        iii+="\""+i+"\":\""+mlist.UserUin+"\",";//创建JSON
	        mylist.add(mlist.UserUin);
	        i++;
	    }
	    TL_Group TL=new TL_Group();
	    TL.list=mylist.toArray(new String[0]);    
	    TL.Uin=qqh;
	    TL.Time = System.currentTimeMillis();
	    M_Group.put(qqh, TL);
	    if(text.equals(""))
		{
		sendm("1",qun,"没有人被禁言哦");
		}else{
		sendm("1",qun,text+"发送[解*]即可解除全部禁言\n发送[解禁+序号]即可解除指定用户");
	}}
if(如.startsWith("解禁"))
{
String text=如.substring(2);
if(text.startsWith("@"))
{}else{
try{
opr="{"+iii+"}";//创建JSON
ho =opr.replace(",}","}");
JSONObject b=new JSONObject(ho);//解析JSON
String ub=b.getString(text);
Forbidden(qun,ub,0);
}catch(e){
sendm("1",qun,"出现错误了\n原因\n"+e);
}
}
}
if(如.startsWith("解*"))
{
int i=0;
for(Object mlist:getForbiddenList(qun)){
Forbidden(qun, mlist.UserUin, 1);
i++;
}
sendm("1",qun,"操作成功\n解除人数:"+i+"人");
}
if(如.startsWith("清空黑名单"))
{
put2(AppPath+"/从云/"+qun+"/黑名单.txt","");
sendm("2",qun,"清空成功");
}
if(如.startsWith("清空白名单"))
{
put2(AppPath+"/从云/"+qun+"/白名单.txt","");
sendm("2",qun,"清空成功");
}
if(如.startsWith("设置字数"))
{
String text=如.substring(4);
存(qun, "zsjczs",text);
sendm("2",qun," 字数\""+text+"\"设置成功");
}
if(如.startsWith("设置禁言"))
{
String text=如.substring(4);
存(qun, "zsjcjysj",text);
sendm("2",qun," 时间\""+text+"\"分钟设置成功");
}
if(如.startsWith("设置验证时间"))
{
String text=如.substring(6);
存(qun, "jqyzsj",text);
sendm("2",qun," 进群验证时间\""+text+"\"分钟设置成功");
}
if(如.startsWith("取消收费"))
{
String text=如.substring(4);
小号收费取消=text;
}
if(如.startsWith("取消验证"))
{
String text=如.substring(4);
opr="{"+json+"}";//创建JSON
ho =opr.replace(",}","}");
JSONObject b=new JSONObject(ho);
String yzq=b.getString(qun+" "+text);
json2=json.replace("\""+qun+" "+text+"\":\""+yzq+"\",","");
json=json2;
进群验证取消=text;
}
if(如.equals("清")||如.equals("清屏"))
{
for(int i = 0;i<5;i++)
{
sendMsg(qun,"","清屏\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n清屏");
}
}
if(如.equals("清空违禁词"))
{
put(AppPath+"/从云/"+qun+"/违禁词.txt","");
sendm("1",qun,"本群违禁词已全部清空");
}
if(如.startsWith("添加违禁词"))
{
String text=如.substring(5);
String uy=putw(AppPath+"/从云/"+qun+"/违禁词.txt",text);
sendm("1",qun,"违禁词\""+text+"\""+uy);
}
if(如.startsWith("删除违禁词"))
{
String text=如.substring(5);
String uy=scw(AppPath+"/从云/"+qun+"/违禁词.txt",text);
sendm("1",qun,uy);
}
if(如.startsWith("查看违禁词"))
{
String g=read(AppPath+"/从云/"+qun+"/违禁词.txt");
sendm("2",qun,g);
}
if(如.startsWith("全局拉白"))
{
String text=如.substring(4);
String a=read(AppPath+"/从云/全局白名单.txt");
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm("1",qun,"请输入正确的QQ");
return;
}
put(AppPath+"/从云/全局白名单.txt",text+"\n"+a);
}else{
for(String tex: data.mAtList)
{
put(AppPath+"/从云/全局白名单.txt",tex+"\n"+a);
}
}
}
if(如.startsWith("全局拉黑"))
{
try{
String o = 如.substring(如.lastIndexOf(" ")+1);
String text = 如.substring(如.lastIndexOf("黑")+1,如.lastIndexOf(" "));
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm("1",qun,"请输入正确的QQ");
return;
}
String h=wxl(qun,text,AppPath+"/从云/全局黑名单.txt",o);
sendm("1",qun,h);
}else{
for(String tex: data.mAtList)
{
String h=wxl(qun,tex,AppPath+"/从云/全局黑名单.txt",o);
sendm("1",qun,h);
}
}
}catch(e){
sendm("1",qun,wxl(qun,如.substring(4),AppPath+"/从云/全局黑名单.txt"," "));
}
}
if(如.startsWith("拉白"))
{
Create(AppPath+"/从云/"+qun);
String text=如.substring(2);
String a=read(AppPath+"/从云/"+qun+"/白名单.txt");
if(text.contains("@"))
{
for(String tex: data.mAtList)
{
if(a.contains(tex))
{
sendm("1",qun,"该QQ已是白名单");
return;
}
put2(AppPath+"/从云/"+qun+"/白名单.txt",tex+","+a);
sendm("1",qun,"QQ"+tex+"已拉白");
}
}
}
if(如.startsWith("拉黑"))
{
try{
String o = 如.substring(如.lastIndexOf(" ")+1);
String text = 如.substring(如.lastIndexOf("黑")+1,如.lastIndexOf(" "));
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm("1",qun,"请输入正确的QQ");
return;
}
String h=wxl(qun,text,AppPath+"/从云/"+qun+"/黑名单.txt",o);
sendm("1",qun,h);
}else{
for(String tex: data.mAtList)
{
String h=wxl(qun,tex,AppPath+"/从云/"+qun+"/黑名单.txt",o);
sendm("1",qun,h);
}
}
}catch(e){
sendm("1",qun,wxl(qun,如.substring(2),AppPath+"/从云/"+qun+"/黑名单.txt"," "));
}
}
if(如.startsWith("删白"))
{
String wh="";
String wh2="";
wh2="该QQ不是白名单";
String text=如.substring(2);
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm("1",qun,"请输入正确的QQ");
return;
}
for (String str : 读取(file2))
{
if(str.contains(text))
{
wh2="QQ"+text+"已删白";
}else{
wh=str+"\n"+wh;
}
}
}else{
for(String tex: data.mAtList)
{
for (String str : 读取(file2))
{
if(str.contains(tex))
{
wh2="QQ"+text+"已删白";
}else{
wh=str+"\n"+wh;
}
}
}
}
sendm("2",qun,wh2);
put(AppPath+"/从云/"+qun+"/白名单.txt",wh);
}
if(如.startsWith("删黑"))
{
String text=如.substring(2);
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm("1",qun,"请输入正确的QQ");
return;
}
String u=scblack(AppPath+"/从云/"+qun+"/黑名单.txt",text);
sendm("1",qun,u);
}else{
for(String tex: data.mAtList)
{
String u=scblack(AppPath+"/从云/"+qun+"/黑名单.txt",tex);
sendm("1",qun,u);
}
}
}
if(如.startsWith("删退群黑"))
{
String wh2="";
wh2="该QQ不是退群黑名单";
File filej = new File(AppPath+"/从云/"+qun+"/退群黑名单.txt");
String wh="";
String text=如.substring(4);
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm("1",qun,"请输入正确的QQ");
return;
}
for (String str : 读取(filej))
{
if(str.contains(text))
{
wh2="QQ"+text+"已删退群黑";
}else{
wh=str+"\n"+wh;
}
}
}else{
for(String tex: data.mAtList)
{
for (String str : 读取(filej))
{
if(str.contains(tex))
{
wh2="QQ"+text+"已删退群黑";
}else{
wh=str+"\n"+wh;
}
}
}
}
sendm("2",qun,wh2);
put(AppPath+"/从云/"+qun+"/退群黑名单.txt",wh);
}
if(如.startsWith("删全白"))
{
String wh="";
String wh2="";
wh2="该QQ不是全白名单";
String text=如.substring(3);
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm("1",qun,"请输入正确的QQ");
return;
}
for (String str : 读取(file5))
{
if(str.contains(text))
{
wh2="QQ"+text+"已删白";
}else{
wh=str+"\n"+wh;
}
}
}else{
for(String tex: data.mAtList)
{
for (String str : 读取(file5))
{
if(str.contains(tex))
{
wh2="QQ"+text+"已删全白";
}else{
wh=str+"\n"+wh;
}
}
}
}
sendm("2",qun,wh2);
put(AppPath+"/从云/"+qun+"/白名单.txt",wh);
}
if(如.startsWith("删全黑"))
{
String text=如.substring(3);
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm("1",qun,"请输入正确的QQ");
return;
}
String u=scblack(AppPath+"/从云/全局黑名单.txt",text);
sendm("1",qun,u);
}else{
for(String tex: data.mAtList)
{
String u=scblack(AppPath+"/从云/全局黑名单.txt",tex);
sendm("1",qun,u);
}
}
}
if(如.startsWith("查白"))
{
String hj="";
for (String str : 读取(file2))
{
if(str.equals("")){}else{
hj=str+","+hj;
}
}
g =hj.replace(",","\n");
sendm("2",qun,g);
put2(AppPath+"/从云/"+qun+"/白名单.txt",g);
}
if(如.startsWith("查黑"))
{
String text3="";
text3="没有找到";
String text=如.substring(2);
if(text.equals(""))
{
String g=Queryb(qun,AppPath+"/从云/"+qun+"/黑名单.txt","1");
sendm("2",qun,g);
}else{
File file10 = new File(AppPath+"/从云/"+qun+"/黑名单.txt");
for (String str : 读取(file10))
{
if(str.contains(text))
{
try{
String text1 = str.substring(str.lastIndexOf("[")+1,str.lastIndexOf("原因:"));
String text2 = str.substring(str.lastIndexOf("原因:")+3,str.lastIndexOf("]"));
text3="QQ"+text1+"原因:"+text2;
}catch(e)
{
text3="貌似出现错误了\n"+e+"";
}
}
}
sendm("1",qun,text3);
}
}
if(如.startsWith("刷新黑名单"))
{
black2="";
int i=1;
int j=0;
String black3=read(AppPath+"/从云/"+qun+"/黑名单.txt")+","+read(AppPath+"/从云/"+qun+"/退群黑名单.txt")+","+read(AppPath+"/从云/全局黑名单.txt");
for(Object wx:getGroupMemberList(qun))
{
if(black3.contains(wx.UserUin))
{
black.add(wx.UserUin);
black2=black2+"\n"+i+" "+wx.UserUin+"("+wx.UserName+")";
i++;
j++;
}
}

if(black2.equals(""))
{
sendm("2",qun,"本群还没有黑名单");
return;
}
sendm("2",qun,"共找到"+j+"个\n本群黑名单/全局黑名单/退群黑名单\n"+black2+"\n发送\"一键清空\"即可全部踢出\n发送\"一键禁言\"即可全部禁言");
i=0;
j=0;
}
if(如.equals("一键清空"))
{
if(black2.equals(""))
{
sendm("1",qun,"本群还没有黑名单");
return;
}
for(String tex: black)
{
Kick(qun,tex,false);
}
sendm("1",qun,"已清空");
black.clear();
}
if(如.equals("一键禁言"))
{
if(black2.equals(""))
{
sendm("1",qun,"本群还没有黑名单");
return;
}
for(String tex: black)
{
Forbidden(qun,tex,60*60*24*30);
}
sendm("1",qun,"已禁言");
black.clear();
}
if(如.startsWith("查退群黑"))
{
String hj="";
for (String str : 读取(file6))
{
if(str.equals("")){}else{
hj=str+","+hj;
}
}
g =hj.replace(",","\n");
sendm("2",qun,g);
put2(AppPath+"/从云/"+qun+"/退群黑名单.txt",g);
}
if(如.startsWith("查全白"))
{
String hj="";
for (String str : 读取(file5))
{
if(str.equals("")){}else{
hj=str+","+hj;
}
}
if(hj.equals(""))
{
sendm("2",qun,"还没有全局白名单");
return;
}
g =hj.replace(",","\n");
sendm("2",qun,g);
put2(AppPath+"/从云/全局白名单.txt",g);
}
if(如.startsWith("查全黑"))
{
String text3="";
text3="没有找到";
String text=如.substring(3);
if(text.equals(""))
{
String g=Queryb(qun,AppPath+"/从云/全局黑名单.txt","2");
sendm("2",qun,g);
}else{
File file10 = new File(AppPath+"/从云/全局黑名单.txt");
for (String str : 读取(file10))
{
if(str.contains(text))
{
try{
String text1 = str.substring(str.lastIndexOf("[")+1,str.lastIndexOf("原因:"));
String text2 = str.substring(str.lastIndexOf("原因:")+3,str.lastIndexOf("]"));
text3="QQ"+text1+"原因:"+text2;
}catch(e)
{
text3="貌似出现错误了\n"+e+"";
}
}
}
sendm("1",qun,text3);
}
}
if(如.startsWith("禁@"))
{
int text = 如.lastIndexOf(" ");
String text2e = 如.substring(text + 1);
for(String qaq:data.mAtList)
{
int sj=Integer.parseInt(text2e);
Forbidden(qun,qaq,sj*60);
}
}
if(如.startsWith("踢@"))
{
for(String qaq:data.mAtList)
{
Kick(qun,qaq,false);
sendm("1",qun,"QQ"+qaq+"踢出成功");
}
}
if(如.startsWith("解@"))
{
for(String tex: data.mAtList)
{
Forbidden(qun,tex,0);
sendm("1",qun,"QQ"+tex+"解除成功");
}
}
if(如.startsWith("全禁")||如.equals("禁"))
{
Forbidden(qun,"",1);
}
if(如.startsWith("全解")||如.equals("解"))
{
Forbidden(qun,"",0);
}
if(如.startsWith("设置时间"))
{
String text=如.substring(4);
if(text.matches("[0-9]+"))
{
存(qun, "wjcjya",text);
sendm("1",qun,"时间\""+text+"\"分设置成功");
}else{
sendm("1",qun,"请输入纯数字");
}
}
if(如.startsWith("开启群头衔"))
{
	SetTroopShowTitle(qun,MyUin,getSkey(),getPskey("clt.qq.com"),1);
sendm("2",qun,"已开启");
	}
if(如.startsWith("关闭群头衔"))
{
	SetTroopShowTitle(qun,MyUin,getSkey(),getPskey("clt.qq.com"),0);
      sendm("2",qun,"已关闭");
}
if(如.startsWith("开启群互动"))
{
	SetTroopShowHonour(qun,MyUin,getSkey(),getPskey("clt.qq.com"),1);
sendm("2",qun,"已开启");
	}
if(如.startsWith("关闭群互动"))
{
SetTroopShowHonour(qun,MyUin,getSkey(),getPskey("clt.qq.com"),0);
	sendm("2",qun,"已关闭");
}
if(如.startsWith("开启群等级"))
{
	SetTroopShowLevel(qun,MyUin,getSkey(),getPskey("clt.qq.com"),1);
sendm("2",qun,"已开启");
	}
if(如.startsWith("关闭群等级"))
{
	SetTroopShowLevel(qun,MyUin,getSkey(),getPskey("clt.qq.com"),0);
      sendm("2",qun,"已关闭");
}
if(如.startsWith("昨日活跃排行"))
{
sendm("1",qun,"请稍等");
String s=speakingList(qun,0);
sendm("1",qun,s);
}
if(如.startsWith("七日活跃排行"))
{
sendm("1",qun,"请稍等");
String s=speakingList(qun,1);
sendm("1",qun,s);
}
if(如.startsWith("本月活跃排行"))
{
sendm("1",qun,"请稍等");
String s=speakingList(qun,2);
sendm("1",qun,s);
}
}
if(qqh.equals(MyUin))
{
int i=0;
int b=1;
int o=1;
if(如.startsWith("检测版本"))
{
if(a().equals(Y("ÍËÎ¾")))
{
Toast(Y("豐凌陆¯©§括卞"));return;}
String Version2=get(Y("ÁÍÍÉÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾Ë¯¾ËÌÂÈÇÍÑÍ"));
String gx1=get(Y("ÁÍÍÉÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾ËÍ¾ÑÍÍÑÍ"));
sendm("2",qun,"当前版本:"+Version+"\n更新日志:\n"+gxrz+"\n最新版本:"+Version2+"\n"+gx1+"\n---------\n发送\"重新更新\"即可重新更新一遍\n(防止更新后出现问题)");
}
if(如.startsWith(Y(jm(new String(new byte[]{54,89,105,109,53,112,105,74,53,112,50,78,53,112,105,74})))))
{
if(a().equals(Y("ÍËÎ¾"))){
Toast(Y("伧仪鈦昉杍昉镲豈･豐凌陆¯©§括卞"));
}else{
Toast(Y("殼垁杍昉"));
load(AppPath+"/"+Y("伧仪©¢®É½ºÍ¾ÃºÏº"));
ts("提示",Y("伧仪杍昉寥扩")+"\n"+Y("徬劦犡枅")+Version+"\n"+jm("5pu05paw5ZCO54mI5pysOg==")+get(Y("ÁÍÍÉÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾Ë¯¾ËÌÂÈÇÍÑÍ"))+"\n"+jm("6YeN5paw5Yqg6L296ISa5pys5Y2z5Y+v"));
}
}
if(如.startsWith("我的业务"))
{
JSONArray business=getbusinesslist(MyUin,getSkey());
String result="QQ"+MyUin+"业务情况";
   for(int i=0;i<business.length();i++){
        JSONObject yewu=business.get(i);
        String name=yewu.get("service_name");
        String start=yewu.get("start_time");
        String end=yewu.get("end_time");
        result=result+"\n\n"+name+"\n"+countdown(start,end)+"\n开通时间:"+start+"\n过期时间:"+end;
        }
        sendm("1",qun,result);
        }
if(如.startsWith("头衔@"))
{
String o = 如.substring(如.lastIndexOf(" ")+1);
for(String tex: data.mAtList)
{
setTitle(qun,tex,o);
sendm("2",qun,"给予成功");
}
}

if(如.startsWith("共同群聊"))
{
List list =new ArrayList();//list数组(有点不会写)
String text=如.substring(4);
{
qq=text;
for(Object q:getGroupList())
{
for(Object wx:getGroupMemberList(q.GroupUin))
{
if(wx.UserUin.equals(text))
{
list.add(q.GroupUin+"("+q.GroupName+")");
i=i+1;
}
if(wx.UserUin.equals(text))
{
h+="\""+o+"\":\""+q.GroupUin+"\",";//创建JSON
o++;
}
}
}
for(String tex: list)
{
c+=b+" "+tex+"\n";
b++;
}
if(i==0)
{
sendm("1",qun,"没有找到");
}else{
sendm("1",qun,"共在"+i+"个群找到\n分别在\n"+c+"找到\n发送\"看+序号\"即可查看该QQ信息");
c="";
}
}
}
if(如.startsWith("看"))
{
int dj=0;
String text=如.substring(1);
{
int num=Integer.parseInt(text);
if(b>num)
{
sendm("1",qun,"没有这个选项");
return;
}
try{
String t="{"+h+"}";//创建JSON
p =t.replace(",}","}");
JSONObject b=new JSONObject(p);//解析JSON
String n=b.getString(text);
for(Object wx:getGroupMemberList(n))
{
if(wx.UserUin.equals(qq))
{
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
dj=wx.UserLevel;//等级
mz=wx.UserName;//名字
long jq=wx.Join_Time;//加群时间
long fy=wx.Last_AvtivityTime;//最后发言时间
long time = Long.valueOf(jq);
long time2 = Long.valueOf(fy);
SimpleDateFormat createTime = new SimpleDateFormat("MM-dd HH:mm");//long转当前时间
nr="群"+n+"\nQQ"+qq+"\n群等级:"+dj+"\n名字:"+mz+"\n进群时间:"+createTime.format(new Date(time))+"\n最后发言时间:"+createTime.format(new Date(time2));
sendm("1",qun,""+nr);
}
}
//sendm("1",qun,""+fy);
}catch(e){
sendm("1",qun,"错误，原因\n"+e+"\n有可能没有这个选项，或者JSON解析错误");
}
}
}
if(如.startsWith("清空代管"))
{
put2(AppPath+"/从云/"+qun+"/代管.txt","");
sendm("2",qun,"清空成功");
}
if(如.startsWith("查看所有群"))
{
String qun="";
//int f=1;
Toast("如果群较多可能需要稍等一会");
for(Object q:getGroupList())
{
if(取(q.GroupUin,"kg")==null)
{
qun=qun+"("+number(q.GroupUin)+")"+q.GroupName+"("+q.GroupUin+")[×]\n";
}else{
qun=qun+"("+number(q.GroupUin)+")"+q.GroupName+"("+q.GroupUin+")[✓]\n";
}
}
ts("提示","群人数/群名字/群号/开关状态\n"+qun);
}
if(如.equals("艾特回复"))
{
if(取(qun,"艾特")==null){athfkg="×";}else{athfkg="✓";}
if(取(qun,"atyy2")==null){athfyy="×";}else{athfyy="✓";}
if(取(qun,"atwz2")==null){athfwz="×";}else{athfwz="✓";}
if(取(qun,"attp2")==null){athftp="×";}else{athftp="✓";}
if(取(qun,"atjy1")==null){athfjy="×";}else{athfjy="✓";}
if(判(AppPath+"/从云/"+qun+"/pic.jpg").equals("false"))
{
if(取(qun,"attp3")==null){}else{
athftplj=取(qun,"attp3");
}
}else{
athftplj=AppPath+"/从云/"+qun+"/pic.jpg";
}
if(判(AppPath+"/从云/"+qun+"/1.mp3").equals("false"))
{
if(取(qun,"atyy3")==null){}else{
athfyylj=取(qun,"atyy3");
}
}else{
athfyylj=AppPath+"/从云/"+qun+"/1.mp3";
}
String athf1="悬浮窗开启/关闭艾特回复\n当前回复开关("+athfkg+")\n当前设置:\n艾特禁言("+athfjy+")\n艾特回复语音("+athfyy+")\n艾特回复图片("+athftp+")\n艾特回复文字("+athfwz+")\n当前回复路径/文字:\n艾特回复禁言("+取(qun,"atjy2")+")分钟)\n艾特回复语音路径\n"+athfyylj+"\n艾特回复图片路径\n"+athftplj;
athf1 =athf1.replace("null","没设置");
sendm("2",qun,athf1);
}
if(如.startsWith("收款@"))
{
String o = 如.substring(如.lastIndexOf(" ")+1);
float f=Float.parseFloat(o);
float t=f*100f;
String ji=t+"";
je =ji.replace(".0","");
//sendm("2",qun,je);
for(String tex: data.mAtList)
{
sendPay(tex,getSkey(),getPskey("tenpay.com"),MyUin,"收款"+tex,qun,je);
sendm("1",qun,"1分钟内有效");
}
}
if(如.startsWith("添加代管@"))
{
for(String tex: data.mAtList)
{
String h=putw(AppPath+"/从云/"+qun+"/代管.txt",tex);
sendm("1",qun,h);
}
}
if(如.startsWith("删除代管@"))
{
for(String text: data.mAtList)
{
String h=scw(AppPath+"/从云/"+qun+"/代管.txt",text);
sendm("1",qun,h);
}
}
if(如.startsWith("查看代管"))
{
String hj="";
for (String str : 读取(file7))
{
if(str.equals("")){}else{
hj=str+","+hj;
}
}
g =hj.replace(",","\n");
sendm("2",qun,g);
put2(AppPath+"/从云/"+qun+"/代管.txt",g);
}
if(如.startsWith("上管理@"))
{
for(String tex: data.mAtList)
{
String sgl=setadmin(qun,tex,1);
sendm("1",qun,sgl);
}
}
if(如.startsWith("下管理@"))
{
for(String tex: data.mAtList)
{
String xgl=setadmin(qun,tex,0);
sendm("1",qun,xgl);
}
}
}
if(judgment(qun,3,qqh)==false)
{
if(qqh.equals(MyUin))return;
if("1".equals(取(qun,"yykp")))
{
if(data.MessageType==2)
{
if(如.contains("com.tencent.gamecenter.gameshare"))
{
if(!如.contains("com.tencent.gamecenter.gameshare_sgame"))
{
sendm("1",qun,qqh+"\n发送音乐卡片\n已禁言 撤回");
revokeMsg(data);
Forbidden(qun,qqh,60*10);
}
}
}
}
if("1".equals(取(qun,"ljjc")))
{
if(如.contains("https://jq.qq.com/?_wv=1027"))
{
sendm("1",qun,qqh+"\n疑似发送入群链接\n已禁言 撤回");
revokeMsg(data);
Forbidden(qun,qqh,60*10);
}
}
new Thread(new Runnable(){
public void run(){
//MessageType;//消息类型,1:图片或文字消息,2:卡片消息,3:图文消息,4:语音消息,5:文件消息,6:回复消息
sess(qun,qqh,file,如,data);
sess(qun,qqh,file9,如,data);
/*
if(data.MessageType==1&&如.startsWith("[PicUrl=")&&"1".equals(取(qun,"wjcjctp"))){
sess(qun,qqh,file,如);
sess(qun,qqh,file9,如);
}
if(data.MessageType==2&&"1".equals(取(qun,"wjcjckp"))){
sess(qun,qqh,file,如);
sess(qun,qqh,file9,如);
}
*/
if(n.contains("撤回"))
{
revokeMsg(data);
n="";
}
break;
}}).start();
if("1".equals(取(qun,"zskg")))
{
if(如.startsWith(""))
{
if(data.MessageType==2){return;}
String text=如.substring(0);
if(取(qun,"zsjczs")==null){zsjczs="200";}else{zsjczs=取(qun,"zsjczs");}
int jczs=Integer.parseInt(zsjczs);
if(text.length() > jczs)
{
if(取(qun,"zsjczs")==null){zsjczs="200";}else{zsjczs=取(qun,"zsjczs");}
if(取(qun,"zsjcjysj")==null)
{
zsjcjysj="2";
}else{
zsjcjysj=取(qun,"zsjcjysj");
}
int jyzs=Integer.parseInt(zsjcjysj)*60;
if(取(qun,"zsjcjy")==null){}else{zsjcjy=" 禁言 ";Forbidden(qun,qqh,jyzs);}
if(取(qun,"zsjcch")==null){zsjcch="";}else{zsjcch=" 撤回 ";revokeMsg(data);}
if(取(qun,"zsjctc")==null){zsjctc="";}else{zsjctc=" 踢出 ";Kick(GroupUin,UserUin,false);}
if((取(qun,"sljj"))==null)
{
SDY="";
}else{
SDY="\n可以私聊我发送\"解禁"+qun+"\"即可解除禁言";
}
String S=zsjcjy+zsjcch+zsjctc;
if(!S.equals(""))
{
sendm("1",qun,"["+qqh+"]\n字数"+text.length()+">"+zsjczs+"\n已"+S+SDY);
}
}
}
}
}
}
}