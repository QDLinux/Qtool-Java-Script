public void 群管(Object data)
{
	String quntext = data.MessageContent;
	String qq = data.UserUin;
	String qun = data.GroupUin;
	String GroupUin="";
	String Group="";
	String at="[AtQQ="+data.UserUin+"]";
	String o="";
	for(String 超级权限:超级权限)
	{
		o=超级权限+","+o;
	}
	String 检测=MyUin+","+o;
if(检测.contains(data.UserUin)||读(qun,"代管",qq)==1)
{
public String 名称(String qq)
 {
	String x=get("http://api.tangdouz.com/qqname.php?qq="+qq);
	return x;
 }
if(quntext.startsWith("全局拉黑"))
{
String o = quntext.substring(quntext.lastIndexOf(" ")+1);
String n = quntext.substring(4);
try{
if(n.matches("^[1-9][0-9]{4,12}$"))
{
if (n.matches(MyUin)) {
        sendm(qun, "请不要全局拉黑自己");
        return;
      }
if(读全局("全局黑名单",n)==1)
{
sendm(qun,"QQ"+n+"已经全局黑名单了");
return;
}
      写全局("全局黑名单", n, 1);
      Kick(qun, n, false);
      sendm(qun, "全局拉黑成功\nQQ:" + n);
return;
}
String text = quntext.substring(quntext.lastIndexOf("黑")+1,quntext.lastIndexOf(" "));
if (text.matches(MyUin)) {
        sendm(qun, "请不要全局拉黑自己");
        return;
      }

if(读全局("全局黑名单",text)==1)
{
sendm(qun,"QQ"+text+"已经全局黑名单了");
return;
}
 
if(text.matches("[0-9]+"))
{
if(text.length() < 5||text.length() > 13)
{
sendm(qun,"请输入正确的QQ");
return;
}
      写全局("全局黑名单", text, 1);
      写全局("全局拉黑原因", text,o);
      Kick(qun, text, false);
      sendm(qun, "全局拉黑成功\nQQ:" + text + "\n拉黑原因:" + o);
      
}else{
for(String tex: data.mAtList)
{

if (tex.matches(MyUin)) {
        sendm(qun, "请不要全局拉黑自己");
        return;
      }
if(读全局("全局黑名单",tex)==1)
{
sendm(qun,"QQ"+tex+"已经全局黑名单了");
return;
}
      写全局("全局黑名单", tex, 1);
      写全局("全局拉黑原因", tex,o);
      Kick(qun, tex, false);
      sendm(qun, "全局拉黑成功\nQQ:" + tex + "\n拉黑原因:" + o);
      
      

}
}
}catch(e){
      sendm(qun, "全局拉黑失败");
}
}
if(quntext.startsWith("全局删黑"))
{
String q=quntext.substring(4).replace(" ","");
if(q.matches("^[1-9][0-9]{4,10}$")){
if(读全局("全局黑名单",q)!=1){
sendm(qun,"黑名单里没有此QQ");
return;}
String s=全局文字("全局理由",q);
清除全局("全局黑名单",q);
清除全局("全局拉黑原因",q);
sendm(qun,"删除成功\nQQ:"+q+"\n拉黑原因:"+s);
}
if(q.matches("^[1-9][0-9]{0,3}$")){
String[] c=全局列表("全局黑名单");
long x=Long.parseLong(q);
long e=0;
for(String d:c){e++;}
if(x>e){sendm(qun,"序号大于黑名单人数");return;}
String m=c[x-1];
if(读全局("全局黑名单",m)!=1){
sendm(qun,"黑名单里没有此QQ");
return;}
String a=全局文字("全局拉黑原因",m);
清除全局("全局黑名单",m);
清除全局("全局拉黑原因",m);
sendm(qun,"删除成功\nQQ:"+m+"\n拉黑原因:"+a);
}
}

if(quntext.equals("全局黑名单")||quntext.equals("全局黑名单")||quntext.equals("查看全局黑名单"))
{
try{
String[] s=全局列表("全局黑名单");
String a="全局黑名单有:";String b=a;long c=0;
for(String q:s)
{
c++;
String 拉黑原因=全局文字("全局拉黑原因",q);
a=a+"\n"+c+"、"+名称(q)+"("+q+")"+拉黑原因;
}
if(a.equals(b)){sendm(qun,"无全局黑名单");return;}
sendm(qun,a);
}
catch(Exception e)
{
sendm(qun,"出错了哦\n"+e);
}
}

if(quntext.equals("清空全局黑名单"))
{
删除全局("全局黑名单");
删除全局("全局拉黑原因");
sendm(qun,"已清空");
}

if(quntext.startsWith("全局拉白"))
{
String text=quntext.substring(4);
if(text.matches("^[1-9][0-9]{4,12}$"))
{
if(读全局("全局白名单",text)==1)
{
sendm(qun,"QQ"+text+"已经全局白名单了");
return;
}
写全局("全局白名单",text, 1);
sendm(qun,"已添加"+text+"为全局白名单");
return;
}
if(text.contains("@"))
{
for(String tex: data.mAtList)
{
if(读全局("全局白名单",tex)==1)
{
sendm(qun,"QQ"+tex+"已经是全局白名单了");
return;
}
写全局("全局白名单",tex,1);
sendm(qun,"已添加"+tex+"为全局白名单");
}
}
}
if(quntext.startsWith("全局删白"))
{
String text=quntext.substring(4);
if(text.matches("^[1-9][0-9]{4,12}$"))
{
if(读全局("全局白名单",text)!=1)
{
sendm(qun,"QQ"+text+"不在全局白名单列表中");
return;
}
清除全局("全局白名单",text);
sendm(qun,"已删除"+text+"的全局白名单");
return;
}
if(text.contains("@"))
{
for(String tex: data.mAtList)
{
if(读全局("全局白名单",tex)!=1)
{
sendm(qun,"QQ"+tex+"不在全局白名单列表中");
return;
}
清除全局("全局白名单",tex);
sendm(qun,"已删除"+tex+"的全局白名单");
}
}
}
if(quntext.equals("全局白名单")||quntext.equals("全局白名单列表")||quntext.equals("查看全局白名单"))
{
String[] 全局白名单=全局列表("全局白名单");
String x="全局白名单有:";
String a=x;
long i=0;
for(String s:全局白名单) {
i++;
x=x+"\n"+i+"、"+名称(s)+"("+s+")";
}
if(x.equals(a))x="目前还没有全局白名单";
sendm(qun,x);
}

if(quntext.equals("清空全局白名单")) {
删除全局("全局白名单");
sendm(qun,"已清空");
}


if(quntext.startsWith("拉黑"))
 {
	String o = quntext.substring(quntext.lastIndexOf(" ")+1);
	String n = quntext.substring(2);
	try{
		if(n.matches("^[1-9][0-9]{4,12}$"))
		{
			if (n.matches(MyUin))
			{
				sendm(qun, "请不要拉黑自己");
				return;
			}
			if(读(qun,"黑名单",n)==1)
			{
				sendm(qun,"QQ"+n+"已经黑名单了");
				return;
			}
			写(qun, "黑名单", n, 1);
			写(qun, "拉黑原因", n,"\n由" + who + qq + "拉黑");
			Kick(qun, n, false);
			sendm(qun, "拉黑成功\nQQ:" + n);
			return;
		}
		String text = quntext.substring(quntext.lastIndexOf("黑")+1,quntext.lastIndexOf(" "));
		if (text.matches(MyUin))
		{
			sendm(qun, "请不要拉黑自己");
			return;
		}
		if(读(qun,"黑名单",text)==1)
		{
			sendm(qun,"QQ"+text+"已经黑名单了");
			return;
		}
		if(text.matches("[0-9]+"))
		{
			if(text.length() < 5||text.length() > 13)
			{
				sendm(qun,"请输入正确的QQ");
				return;
			}
			写(qun, "黑名单", text, 1);
			写(qun, "拉黑原因", text,"\n"+ o);
			Kick(qun, text, false);
			sendm(qun, "拉黑成功\nQQ:" + text + "\n拉黑原因:" + o);
		}
		else{
			for(String tex: data.mAtList)
			{
				if (tex.matches(MyUin))
				{
					sendm(qun, "请不要拉黑自己");
					return;
				}
				if(读(qun,"黑名单",tex)==1)
				{
					sendm(qun,"QQ"+tex+"已经黑名单了");
					return;
				}
				写(qun, "黑名单", tex, 1);
				写(qun, "拉黑原因", tex,o);
				Kick(qun, tex, false);
				sendm(qun, "拉黑成功\nQQ:" + tex + "\n拉黑原因:" + o);
			}
		}
	}
	catch(e){
		sendm(qun, "拉黑失败");
	}
}


if(quntext.startsWith("删黑"))
{
String q=quntext.substring(2).replace(" ","");
if(q.matches("^[1-9][0-9]{4,10}$")){
if(读(qun,"黑名单",q)!=1){
sendm(qun,"黑名单里没有此QQ");
return;}
String s=文字(qun,"拉黑原因",q);
清除(qun,"黑名单",q);
清除(qun,"拉黑原因",q);
sendm(qun,"删除成功\nQQ:"+q+"\n拉黑原因:"+s);
}
if(q.matches("^[1-9][0-9]{0,3}$")){
String[] c=列表(qun,"黑名单");
long x=Long.parseLong(q);
long e=0;
for(String d:c){e++;}
if(x>e){sendm(qun,"序号大于黑名单人数");return;}
String m=c[x-1];
if(读(qun,"黑名单",m)!=1){
sendm(qun,"黑名单里没有此QQ");
return;}
String a=文字(qun,"拉黑原因",m);
清除(qun,"黑名单",m);
清除(qun,"拉黑原因",m);
sendm(qun,"删除成功\nQQ:"+m+"\n拉黑原因:"+a);
}
}
if(quntext.equals("黑名单列表")||quntext.equals("查看黑名单"))
{
try{

String[] s=列表(qun,"黑名单");
String a="本群黑名单有:";String b=a;long c=0;
for(String q:s)
{
c++;
String 拉黑原因=文字(qun,"拉黑原因",q);
a=a+"\n"+c+"、"+名称(q)+"("+q+")"+拉黑原因;
}

if(a.equals(b)){sendm(qun,"无黑名单");return;}
/*a=a.replace("\n","__");
String t="https://xiaobai.klizi.cn/API/tw/Image-text.php?text="+a+"&font_size=&form=centre&hh=__";
sendPic(qun,"",t);*/

sendm(qun,a);
}
catch(Exception e)
{
sendm(qun,"出错了哦\n"+e);
}
}
if(quntext.equals("清空黑名单"))
{
删除(qun,"黑名单");
删除(qun,"拉黑原因");
sendm(qun,"已清空");
}





if(quntext.startsWith("拉白"))
{
String text=quntext.substring(2);

if(text.matches("^[1-9][0-9]{4,12}$"))
{
if(读(qun,"白名单",text)==1)
{
sendm(qun,"QQ"+text+"已经白名单了");
return;
}
写(qun, "白名单",text, 1);
sendm(qun,"已添加"+text+"为白名单");
return;
}
if(text.contains("@"))
{
for(String tex: data.mAtList)
{
if(读(qun,"白名单",tex)==1)
{
sendm(qun,"QQ"+tex+"已经是白名单了");
return;
}
写(qun,"白名单",tex,1);
sendm(qun,"已添加"+tex+"为白名单");
}
}
}
if(quntext.startsWith("删白"))
{
String text=quntext.substring(2);

if(text.matches("^[1-9][0-9]{4,12}$"))
{
if(读(qun,"白名单",text)!=1)
{
sendm(qun,"QQ"+text+"不在白名单列表中");
return;
}
清除(qun,"白名单",text);
sendm(qun,"已删除"+text+"的白名单");
return;
}
if(text.contains("@"))
{
for(String tex: data.mAtList)
{
if(读(qun,"白名单",tex)!=1)
{
sendm(qun,"QQ"+tex+"不在白名单列表中");
return;
}
清除(qun,"白名单",tex);
sendm(qun,"已删除"+tex+"的白名单");
}
}
}
if(quntext.equals("白名单列表")||quntext.equals("查看白名单")) {
String[] 白名单=列表(qun,"白名单");
String x="本群白名单有:";
String a=x;
long i=0;
for(String s:白名单) {
i++;
x=x+"\n"+i+"、"+群昵称(qun,s)+"("+s+")";
}
if(x.equals(a))x="目前还没有白名单";
sendm(qun,x);
}

if(quntext.equals("清空白名单")) {
删除(qun,"白名单");
sendm(qun,"已清空");
}




if(quntext.startsWith("添加代管@"))
{
for(String tex: data.mAtList)
{
if(读(qun,"代管",tex)==1)
{
sendm(qun,"QQ"+tex+"已经是代管了");
return;
}
写(qun,"代管",tex,1);
sendm(qun,"已添加"+tex+"为代管");
}
}


if(quntext.startsWith("删除代管@"))
{
for(String tex: data.mAtList)
{
if(读(qun,"代管",tex)!=1)
{
sendm(qun,"QQ"+tex+"不在代管列表中");
return;
}
清除(qun,"代管",tex);
sendm(qun,"已删除"+tex+"的代管权限");
}
}




if(quntext.equals("代管列表")||quntext.equals("查看代管")) {
String[] 代管=列表(qun,"代管");
String x="本群代管权限有:";
String a=x;
long i=0;
for(String s:代管) {
i++;
x=x+"\n"+i+"、"+群昵称(qun,s)+"("+s+")";
}
if(x.equals(a))x="目前还没有代管";
sendm(qun,x);
}
if(quntext.equals("清空代管列表")) {
删除(qun,"代管");
sendm(qun,"已清空");
}

if(quntext.startsWith("禁@")||quntext.startsWith("禁言@"))
{
if(是否管理(data.GroupUin))
{
int text = quntext.lastIndexOf(" ");
String text2 = quntext.substring(text + 1);
for(String qq:data.mAtList)
{
int sj=Integer.parseInt(text2);
Forbidden(qun,qq,sj*60);
}
}
else
{
sendm(qun,"本账号不是本群管理,无法进行此操作");
}
}

if(quntext.startsWith("踢@")||quntext.startsWith("踢出@"))
{
if(是否管理(data.GroupUin))
{
for(String qq:data.mAtList)
{
Kick(qun,qq,false);
sendm(qun,"已将"+qq+"踢出");
}
}
else
{
sendm(qun,"本账号不是本群管理,无法进行此操作");
}
}

if(quntext.startsWith("解@")||quntext.startsWith("解禁@"))
{

if(是否管理(data.GroupUin))
{
for(String tex: data.mAtList)
{
Forbidden(qun,tex,0);
sendm(qun,"已将"+tex+"解除禁言");
}
}
else
{
sendm(qun,"本账号不是本群管理,无法进行此操作");
}
}

if(quntext.equals("全禁")||quntext.equals("禁")||quntext.equals("全体禁言"))
{

if(是否管理(data.GroupUin))
{
Forbidden(qun,"",1);
}
else
{
sendm(qun,"本账号不是本群管理,无法进行此操作");
}
}

if(quntext.equals("全解")||quntext.equals("解")||quntext.equals("全体解禁"))
{

if(是否管理(data.GroupUin))
{
Forbidden(qun,"",0);
}
else
{
sendm(qun,"本账号不是本群管理,无法进行此操作");
}
}

if(quntext.startsWith("上管理@"))
{
if(是否群主(data.GroupUin))
{
for(String tex: data.mAtList)
{
String sgl=设置管理员(qun,tex,1);
sendm(qun,sgl);
}
}
else
{
sendm(qun,"本账号不是本群群主,无法进行此操作");
}
}

if(quntext.startsWith("下管理@"))
{
if(是否群主(data.GroupUin))
{
for(String tex: data.mAtList)
{
String xgl=设置管理员(qun,tex,0);
sendm(qun,xgl);
}
}
else
{
sendm(qun,"本账号不是本群群主,无法进行此操作");
}
}
if(quntext.equals("解*"))
{

if(是否管理(data.GroupUin))
{
                Object list=getForbiddenList(data.GroupUin);
              if(list==null||list.size()==0) 
              sendm(qun, "当前没有人被禁言");
                else
                {
                    for(Object ForbiddenList:list)
                    {
                    	Forbidden(data.GroupUin, ForbiddenList.UserUin+"", 0);
                    }
                    sendm(qun,"禁言列表已解禁");
                    return;
                }
}
else
{
sendm(qun,"本账号不是本群管理,无法进行此操作");
}
}

}

if(("1".equals(getString(data.GroupUin,"我要头衔"))))
{
if(quntext.startsWith("我要头衔")){
String a=quntext.substring(4);
setTitle(qun,qq,""+a);
sendm(qun,at+"\n设置成功");

}
}

}


















