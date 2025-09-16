public void 私聊解禁(Object data){
String qun=data.GroupUin;
String qq=data.UserUin;
String quntext=data.MessageContent;
if(!data.IsGroup&&quntext.startsWith("解禁")&&!data.IsSend&&quntext.length()<15)
{
Calendar now = Calendar.getInstance();
String W="";
String text=quntext.substring(2);
if(text.equals(""))
{
sendMsg(qun,qq,"请输入被禁言的群号");
return;
}
if("1".equals(取(text,"kg")))
{
if((取(text,"sljj"))==null)
{
sendMsg(qun,qq,"群("+text+")未开启私聊解禁");
return;
}
try{
for(String u:GL(text))
{
W=u+","+W;
}
for(Object v:getGroupList())
{
W=v.GroupOwner+","+W;
}
if(W.contains(MyUin))
{
String day=now.get(Calendar.YEAR)+" "+(now.get(Calendar.MONTH) + 1)+" "+now.get(Calendar.DAY_OF_MONTH);//获取年 月 日
String sljj=取(text,"sljj"+day+qq);
String size0=sljj+"";
size0=size0.replace("null","0");
int size=Integer.parseInt(size0);
if(解禁次数<=size)
{
sendMsg(qun,qq,"QQ("+qq+")今天解禁次数"+size+"=>"+解禁次数+"\n请明天再来");
return;
}
int size3=size+1;
int size2=解禁次数-size3;
sendMsg(qun,qq,"当天第"+size3+"次解禁\n已解除\n你还可以解禁"+size2+"次");
存(text,"sljj"+day+qq,size3+"");
Forbidden(text,qq,0);
}else{
sendMsg(qun,qq,"("+MyUin+")不是("+text+")的管理/群主，无法解除");
}
}catch(e)
{
sendMsg(qun,qq," 私聊解禁->错误\n"+e);
}
}else{
sendMsg(qun,qq,"群("+text+")没有开机");
}
}
}