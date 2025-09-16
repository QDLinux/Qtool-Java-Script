

public String 名称(String qq)
{
String x=get("http://api.tangdouz.com/qqname.php?qq="+qq);
return x;
}


public int 群人数(String Uin)
{
int ui=0;
for(Object wx:getGroupMemberList(Uin))
{
ui++;
}
return ui;
}

public void OnTroopEvent(String qun,String qq,int t)
//群号,成员号,消息类型1为退群,2为加群
{

SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Calendar calendar = Calendar.getInstance();
    String time = df.format(calendar.getTime());
if(("1".equals(getString(qun,"开关"))))
{
if(t==2)
{
String text="";
String o="";
for(String 超级权限:超级权限){
o=超级权限+","+o;
}

if(是否管理(qun))
{
String 限制=MyUin+","+o;
if(!限制.contains(qq)||读(qun,"代管",qq)!=1||读全局("全局白名单",qq)!=1||读(qun,"白名单",qq)!=1)
  {
if(读全局("全局黑名单",qq)==1)
{
String s=全局文字("全局拉黑原因",qq);
String text="╔═╗╔═╗╔═╗╔═╗╔═╗\n╟全╢╟局╢╟黑╢╟名╢╟单╢\n╚═╝╚═╝╚═╝╚═╝╚═╝\n全局黑名单用户已踢出\nQQ:"+qq+"\n拉黑原因:"+s;
Kick(qun,qq,false);
return;
}
if(读(qun,"黑名单",qq)==1)
{
String s=文字(qun,"拉黑原因",qq);
text=text+"╔═╗╔═╗╔═╗\n╟黑╢╟名╢╟单╢\n╚═╝╚═╝╚═╝\n黑名单用户已踢出\nQQ:"+qq+"\n拉黑原因:"+s;
Kick(qun,qq,false);
}
}
}


if("1".equals(getString(qun,"进群提示")))
{
text="╔═╗╔═╗╔═╗╔═╗\n╟欢╢╟迎╢╟新╢╟人╢\n╚═╝╚═╝╚═╝╚═╝\n欢迎新人进群\n进群时间:"+time+"\n名称:[名称]\nQQ:[QQ]\n群号:[群号]\n群名:[群名]\n当前人数:[群人数]\n"+text;
text = text.replace("[QQ]", qq);
text = text.replace("[名称]", 名称(qq));
text = text.replace("[群号]", qun);
text = text.replace("[群名]", getGroupName(qun));
text = text.replace("[时间]", time);
//text = text.replace("[群人数]", 群人数(qun));
}



if("1".equals(getString(qun,"进群提示"))||是否管理(qun)&&读(qun,"黑名单",qq)==1||是否管理(qun)&&读全局("全局黑名单",qq)==1)
{
sendm(qun,text);
}


}




if(t==1)
{
String text="";
if("1".equals(getString(qun,"退群拉黑")))
{
if(读(qun,"黑名单",qq)==1)return;
写(qun,"黑名单",qq,1);
写(qun,"拉黑原因",qq,"退群拉黑");
text=text+"╔═╗╔═╗╔═╗╔═╗\n╟退╢╟群╢╟拉╢╟黑╢\n╚═╝╚═╝╚═╝╚═╝\n已将"+qq+"加入黑名单\n再次进群将自动踢出";
}


if("1".equals(getString(qun,"退群提示")))
{
text = "╔═╗╔═╗╔═╗╔═╗\n╟退╢╟群╢╟提╢╟示╢\n╚═╝╚═╝╚═╝╚═╝\n这个人不知好歹退出了本群\n退群时间:[时间]\n名称:[名称]\nQQ:[QQ]\n群号:[群号]\n群名:[群名]\n当前人数:[群人数]\n"+text;
text = text.replace("[QQ]", qq);
text = text.replace("[名称]", 名称(qq));
text = text.replace("[群号]", qun);
text = text.replace("[群名]", getGroupName(qun));
text = text.replace("[时间]", time);
//text = text.replace("[群人数]", 群人数(qun));
}




if("1".equals(getString(qun,"退群提示"))||"1".equals(getString(qun,"退群拉黑")))
{
sendm(qun,text);
}

}



}


}