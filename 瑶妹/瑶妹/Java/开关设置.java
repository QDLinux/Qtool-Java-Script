
public void 开关(Object data)
{
String quntext = data.MessageContent;
    String qq = data.UserUin;
    String qun = data.GroupUin;
    String GroupUin="";
    String Group="";
    String o="";
for(String 超级权限:超级权限){
o=超级权限+","+o;
}
     String 限制=MyUin+","+o;
if(限制.contains(data.UserUin)||读(qun,"代管",qq)==1)
{

if(data.MessageContent.equals("切换管家发送"))
{
if(!是否管理(data.GroupUin))
{
sendm(qun,"本账号不是本群管理,无法切换管家发送");
return;
}
if("1".equals(取(qun,"管家回复")))
{
sendReply(qun,data,"已经切换为管家发送了");
}else{
存(data.GroupUin, "管家回复", "1");
sendReply(qun,data,"已切换为管家发送");
}
}

if(data.MessageContent.equals("切换文字发送"))
{
if(getString(data.GroupUin,"管家回复")==null)
{
sendm(qun,"已经切换为文字发送了");
}else{
存(data.GroupUin, "管家回复", null);
sendm(qun,"已切换为文字发送");
}
}
if(data.MessageContent.equals("切换图文发送"))
{
if("2".equals(取(qun,"管家回复")))
{

sendm(qun,"已经切换为图文发送了");
}else{
存(data.GroupUin, "管家回复", "2");
sendm(qun,"已切换为图文发送");
}
}
if(data.MessageContent.equals("切换图片发送"))
{
if("3".equals(取(qun,"管家回复")))
{
sendm(qun,"已经切换为图片发送了");
}else{
存(data.GroupUin, "管家回复", "3");
sendm(qun,"已切换为图片发送");
}
}



if(quntext.equals("开启菜单限制"))
{
if("1".equals(getString(data.GroupUin,"菜单限制")))
{
sendm(qun,"已经开启了");
return;
}
存(data.GroupUin,"菜单限制","1");
sendm(qun,"已开启");
}




if(quntext.equals("关闭菜单限制"))
{
if(!"1".equals(getString(data.GroupUin,"菜单限制")))
{
sendm(qun,"还没开呢");
return;
}
存(data.GroupUin,"菜单限制",null);
sendm(qun,"已关闭");
}

if(quntext.equals("开启图片系统"))
{
if("1".equals(getString(data.GroupUin,"图片系统")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"图片系统","1");
sendm(qun,"已开启");
}


if(quntext.equals("关闭图片系统"))
{
if(!"1".equals(getString(data.GroupUin,"图片系统")))
{
sendm(qun,"还没开呢");
return;
}
存(data.GroupUin, "图片系统", null);
sendm(qun,"已关闭");
}




if(quntext.equals("开启音乐系统"))
{
if("1".equals(getString(data.GroupUin,"音乐系统")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"音乐系统","1");
sendm(qun,"已开启");
}


if(quntext.equals("关闭音乐系统"))
{
if(!"1".equals(getString(data.GroupUin,"音乐系统")))
{
sendm(qun,"还没开呢");
return;
}
存(data.GroupUin, "音乐系统", null);
sendm(qun,"已关闭");
}


if(quntext.equals("开启涩图"))
{
if("1".equals(getString(data.GroupUin,"涩图开关")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"涩图开关","1");
sendm(qun,"已启动发送\n涩图+内容即可");
}


if(quntext.equals("关闭涩图"))
  {
  if(!"1".equals(getString(data.GroupUin,"涩图开关")))
  {
sendm(qun,"还没开呢");
return;
  }
存(data.GroupUin, "涩图开关", null);
sendm(qun,"已关闭");
}




if(quntext.equals("开启自身撤回"))
{
if("1".equals(getString(data.GroupUin,"自身撤回")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"自身撤回","1");
sendm(qun,"已开启\n撤回时间:"+自身撤回时间+"秒\n可以发送设置撤回时间来设置");
}

if(quntext.equals("关闭自身撤回"))
{
if(!"1".equals(getString(data.GroupUin,"自身撤回")))
{
sendm(qun,"还没开呢");
return;
}
存(data.GroupUin,"自身撤回", null);
sendm(qun,"已关闭");
}




if(quntext.equals("开启视频系统"))
{
if("1".equals(getString(data.GroupUin,"视频系统")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"视频系统","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭视频系统"))
{
if(!"1".equals(getString(data.GroupUin,"视频系统")))
{
sendm(qun,"还没开呢");
return;
}
存(data.GroupUin, "视频系统", null);
sendm(qun,"已关闭");
}


if(quntext.equals("开启词条系统"))
{
if("1".equals(getString(data.GroupUin,"词条系统")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"词条系统","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭词条系统"))
{
if(!"1".equals(getString(data.GroupUin,"词条系统")))
{
sendm(qun,"还没开呢");
return;
}
存(data.GroupUin, "词条系统", null);
sendm(qun,"已关闭");
}

if(quntext.equals("开启视频解析"))
{
if("1".equals(getString(data.GroupUin,"视频解析")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"视频解析","1");
sendm(qun,"已开启");
}


if(quntext.equals("关闭视频解析"))
{
if(!"1".equals(getString(data.GroupUin,"视频解析")))
{
sendm(qun,"还没开呢");
return;
}
存(data.GroupUin, "视频解析", null);
sendm(qun,"已关闭");
}




if(quntext.equals("开启智能系统"))
{
if("1".equals(getString(data.GroupUin,"智能系统")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"智能系统","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭智能系统"))
{
if(!"1".equals(getString(data.GroupUin,"智能系统")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "智能系统", null);
sendm(qun,"已关闭");
}



 if(quntext.equals("开启查询系统"))
{
if("1".equals(getString(data.GroupUin,"查询系统")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"查询系统","1");
sendm(qun,"已开启");
}

if(quntext.equals("关闭查询系统"))
{
if(!"1".equals(getString(data.GroupUin,"智能系统")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "查询系统", null);
sendm(qun,"已关闭");
}


if(quntext.equals("开启进群提示"))
{
if("1".equals(getString(data.GroupUin,"进群提示")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"进群提示","1");
sendm(qun,"已开启");
}

if(quntext.equals("关闭进群提示"))
{
if(!"1".equals(getString(data.GroupUin,"进群提示")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "进群提示", null);
sendm(qun,"已关闭");
}




if(quntext.equals("开启退群提示"))
{
if("1".equals(getString(data.GroupUin,"退群提示")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"退群提示","1");
sendm(qun,"已开启");
}


if(quntext.equals("关闭退群提示"))
{
if(!"1".equals(getString(data.GroupUin,"退群提示")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "退群提示", null);
sendm(qun,"已关闭");
}





if(quntext.equals("开启退群拉黑"))
{
if(!是否管理(data.GroupUin))
{
sendm(qun,"本账号不是本群管理,无法开启");
return;
}
if("1".equals(getString(data.GroupUin,"退群拉黑")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"退群拉黑","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭退群拉黑"))
{
if(!"1".equals(getString(data.GroupUin,"退群拉黑")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "退群拉黑", null);
sendm(qun,"已关闭");
}




if(quntext.equals("开启私聊回复"))
{
if("1".equals(getString(data.GroupUin,"私聊回复")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"私聊回复","1");
sendm(qun,"已开启");
}

if(quntext.equals("关闭私聊回复"))
{
if(!"1".equals(getString(data.GroupUin,"私聊回复")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "私聊回复", null);
sendm(qun,"已关闭");
}



if(quntext.equals("开启自动回复"))
{
if("1".equals(getString(data.GroupUin,"自动回复")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"自动回复","1");
sendm(qun,"已开启");
}

if(quntext.equals("关闭自动回复"))
{
if(!"1".equals(getString(data.GroupUin,"自动回复")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "自动回复", null);
sendm(qun,"已关闭");
}

if(quntext.equals("开启消息检测"))
{
if("1".equals(getString(data.GroupUin,"消息检测")))
{
sendm(qun,"已经开了");
return;
}


if(是否管理(data.GroupUin))
{
if(getString("第一次","检测")==null)
{
存(data.GroupUin,"链接检测","1");
存(data.GroupUin,"号码检测","1");
存(data.GroupUin,"字数检测","1");
}
}
存(data.GroupUin,"消息检测","1");
sendm(qun,"已开启");

}



if(quntext.equals("关闭消息检测"))
{
if(!"1".equals(getString(data.GroupUin,"消息检测")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "消息检测", null);
sendm(qun,"已关闭");
}


if(quntext.equals("开启链接检测"))
{
if(!是否管理(data.GroupUin))
{
sendm(qun,"本账号不是本群管理,无法开启链接检测");
return;
}
if(!"1".equals(getString(data.GroupUin,"消息检测")))
{
sendm(qun,"请先开启消息检测");
return;
}
if("1".equals(getString(data.GroupUin,"链接检测")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"链接检测","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭链接检测"))
{
if(!"1".equals(getString(data.GroupUin,"链接检测")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "链接检测", null);
sendm(qun,"已关闭");
}

if(quntext.equals("开启号码检测"))
{
if(!是否管理(data.GroupUin))
{
sendm(qun,"本账号不是本群管理,无法开启号码检测");
return;
}
if(!"1".equals(getString(data.GroupUin,"消息检测")))
{
sendm(qun,"请先开启消息检测");
return;
}
if("1".equals(getString(data.GroupUin,"号码检测")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"号码检测","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭号码检测"))
{
if(!"1".equals(getString(data.GroupUin,"号码检测")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "号码检测", null);
sendm(qun,"已关闭");
}




if(quntext.equals("开启字数检测"))
{
if(!是否管理(data.GroupUin))
{
sendm(qun,"本账号不是本群管理,无法开启字数检测");
return;
}
if(!"1".equals(getString(data.GroupUin,"消息检测")))
{
sendm(qun,"请先开启消息检测");
return;
}
if("1".equals(getString(data.GroupUin,"字数检测")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"字数检测","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭字数检测"))
{
if(!"1".equals(getString(data.GroupUin,"字数检测")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "字数检测", null);
sendm(qun,"已关闭");
}





if(quntext.equals("关闭我要头衔"))
{
if(!"1".equals(getString(data.GroupUin,"我要头衔")))
{
sendm(qun,"还没开");
return;
}
存(data.GroupUin, "我要头衔", null);
sendm(qun,"已关闭");
}




if(quntext.equals("开启我要头衔"))
{
if(!是否群主(data.GroupUin))
{
sendm(qun,"本账号不是本群群主,无法开启我要头衔");
return;
}
if("1".equals(getString(data.GroupUin,"我要头衔")))
{
sendm(qun,"已经开了");
return;
}
存(data.GroupUin,"我要头衔","1");
sendm(qun,"已开启\n发送 我要头衔+内容 即可");
}


if(quntext.equals("开启底部一言"))
{
if("1".equals(getString("开关","底部一言")))
{
sendm(qun,"已经开了");
return;
}
存("开关","底部一言","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭底部一言"))
{
if(!"1".equals(getString("开关","底部一言")))
{
sendm(qun,"还没开");
return;
}
存("开关", "底部一言", null);
sendm(qun,"已关闭");
}



if(quntext.equals("开启底部时间"))
{
if("1".equals(getString("开关","底部时间")))
{
sendm(qun,"已经开了");
}
存("开关","底部时间","1");
sendm(qun,"已开启");
}


if(quntext.equals("关闭底部时间"))
{
if(!"1".equals(getString("开关","底部时间")))
{
sendm(qun,"还没开");
return;
}
存("开关", "底部时间", null);
sendm(qun,"已关闭");
}



if(quntext.equals("开启底部尾巴"))
{
if("1".equals(getString("开关","底部尾巴")))
{
sendm(qun,"已经开了");
return;
}
存("开关","底部尾巴","1");
sendm(qun,"已开启");
}



if(quntext.equals("关闭底部尾巴"))
{
if(!"1".equals(getString("开关","底部尾巴")))
{
sendm(qun,"还没开");
return;
}
存("开关", "底部尾巴", null);
sendm(qun,"已关闭");
}



if(quntext.equals("切换模型线路"))
{
if("1".equals(getString("开关","备用模型")))
{
存("开关", "备用模型", null);
sendm(qun,"已切换为主用模型");
return;
}
if(!"1".equals(getString("开关","备用模型")))
{
存("开关","备用模型","1");
sendm(qun,"已切换为备用模型");
}
}

if(quntext.startsWith("设置回复概率"))
{
if(取(qun,"自动回复")==null)
{
sendm(qun,"请先开启自动回复");
return;
}
String text = quntext.substring(6);
if(text.matches("^(?:100|[1-9][0-9]?)$"))
{
存(qun,"回复概率",text);
sendm(qun, "回复概率已设置为" + text + "%");
}
}

if(quntext.equals("恢复默认概率"))
{
if(取(qun,"自动回复")==null)
{
sendm(qun,"请先开启自动回复");
return;
}
存(qun,"回复概率",null);
sendm(qun, "回复概率已恢复为30%");
}




if(quntext.startsWith("设置撤回时间"))
{
if(取(qun,"自身撤回")==null)
{
sendm(qun,"请先开启自身撤回");
return;
}
String text = quntext.substring(6);
if(!是否管理(data.GroupUin))
{
if(text.matches("^(?:120|[1-9][0-9]{0,2})$"))
{
存(qun,"自身撤回时间",text);
sendm(qun, "自身撤回时间已设置为" + text + "秒");
}
}else{
if(text.matches("^(?:520|[1-9][0-9]{0,2})$"))
{
存(qun,"自身撤回时间",text);
sendm(qun, "自身撤回时间已设置为" + text + "秒");
}
}
}

if(quntext.equals("恢复撤回时间"))
{
if(取(qun,"自身撤回")==null)
{
sendm(qun,"请先开启自身撤回");
return;
}
存(qun,"自身撤回时间",null);
sendm(qun, "自身撤回时间已恢复为60秒");
}


}
}



public void sendm(String qun,String text)
{
String[] emojilist={"☘️","🌼","🌸","🍀","🪐","☀️","🌕","⚾","🏀","🥎","🏆","🟥","💥","🔔","🔅","🔆","💫","⭐","🪙","🃏","🔮","🎀","👑","🎪","🎄","🍒","🍧","🍇","🎉","🍁","🍑","🍊","🍓","🍅","🍥","🏵","🎊","🎁","🎃","🍏","🍎","🍐","🍊","🍋","🍌","🍉","🍆","⚽️"};
String e=emojilist[new Random().nextInt(emojilist.length)];
if("1".equals(getString("开关","底部一言")))
{
//String 一言=访问("https://api.mcloc.cn/words/").replace("{\n    \"hitokoto\": \"","").replaceAll("\",\n .*\n\\}","");
String 一言 =访问("https://wxy.fufuya.top/lovewx.php");
text=text+"\n\n"+一言;
}
if("1".equals(getString("开关","底部时间")))
{
SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE");
Calendar calendar = Calendar.getInstance();
String time = df.format(calendar.getTime());
text=text+"\n\n"+time;
}

if("1".equals(getString("开关","底部尾巴")))
{
String 底部尾巴="这是底部尾巴哦";
if(取("开关","底部尾巴内容")==null)
{

}else{
底部尾巴=取("开关","底部尾巴内容")
	.replace("[e]",e)
	.replace("[群名]",getGroupName(qun))
	.replace("[群号]",qun)
	.replace("[手机型号]",phoneModel())
	.replace("[剩余内存]",getAvailMemory())
	.replace("[存储信息]",getAvailableInternalMemorySize()+"/"+getTotalInternalMemorySize())
	.replace("[QQ版本]",getHostInfo())
	.replace("[当前版本]",当前版本);
}
text=text+"\n\n"+底部尾巴;
}



text=text.replace("[e]",e);

String 名字=取("脚本名字","脚本名字");

if(取(qun,"管家回复")==null)
{
sendMsg(qun,"",名字+"\n\n"+text);
}

if("1".equals(getString(qun,"管家回复")))
try {
if(text.length()>5000)
{
sendMsg(qun,"",名字+"\n\n"+text);
Toast("管家发送字数已超过5000字\n已自动转为文字发送");
}else{
管家发送(qun,"\n------\n"+text);
}
} catch (Exception e) {
Toast("错误,已自动切换为文字发送");
存(qun,"管家回复",null);
}


if("2".equals(取(qun,"管家回复")))
try {
String pictp=get("http://171.115.223.160:5555/tp.php");
sendMsg(qun,"","[PicUrl="+pictp+"]"+名字+"\n\n"+text);
} catch (Exception e) {
Toast("错误,已自动切换为文字发送");
存(qun,"管家回复",null);
}

if("3".equals(取(qun,"管家回复")))
try {
new java.lang.Thread(new Runnable(){public void run(){
sendPic(qun,"",MakeTextPhoto(名字+"\n\n"+text));
}}).start();
} catch (Exception e) {
Toast("错误,已自动切换为文字发送");
存(qun,"管家回复",null);
}


}



public void zsch(String qun,String qq,int type)
{

String num=qun;
int type2=1;
if(type!=1)
{num=qq;type2=2;}
if(("1"+type).equals(取(num,"自身撤回")))
	{
	存(num, "自身撤回", null);
      提示("自身撤回已关闭");
	}
	else{
	存(num,"自身撤回","1"+type2);
	提示("自身撤回已开启\n自动撤回时间为:"+xgsj+"秒");
	}
}







public void 管家回复(String qun)
{
if("1".equals(取(qun,"管家回复")))
	{
	存(qun, "管家回复", null);
      提示("已切换为文字发送");
	}
	else{
	if(!是否管理(qun))
	{
	提示("本账号不是本群管理,无法切换管家发送");
	return;
	}
	存(qun,"管家回复","1");
	提示("已切换为管家发送");
	}
}








public void 总开关(String Group)
{
if("1".equals(取(Group,"开关")))
	{
	存(Group, "开关", null);
	{
      提示("已关机");     
      }
      }     
	else{
	存(Group,"开关","1");
	{
	提示("已开机");
	}
	}
	}
	
public void spxt(String Group)
{
if(取(Group,"开关")==null)
{
提示("请先开机");
return;
}
if("1".equals(取(Group,"视频系统")))
	{
	存(Group, "视频系统", null);
	{
      提示("已关闭");     
      }
      }     
	else{
	存(Group,"视频系统","1");
	{
	提示("已开启");
	}
	}
	}
	
	
	public void chat(String Group)
{
if(取(Group,"开关")==null)
{
提示("请先开机");
return;
}
if("1".equals(取(Group,"智能系统")))
	{
	存(Group, "智能系统", null);
	{
      提示("已关闭");     
      }
      }     
	else{
	存(Group,"智能系统","1");
	{
	提示("已开启");
	}
	}
	}
	

public void stkg(String Group)
{
if(取(Group,"开关")==null)
{
提示("请先开机");
return;
}
if("1".equals(取(Group,"涩图开关")))
	{
	存(Group, "涩图开关", null);
	{
      提示("涩图已关闭");     
      }
      }     
	else{
	存(Group,"涩图开关","1");
	{
	提示("涩图已开启");
	}
	}
	}


public void spjx(String Group)
{
if(取(Group,"开关")==null)
{
提示("请先开机");
return;
}
if("1".equals(取(Group,"视频解析")))
{
存(Group, "视频解析", null);
{
提示("视频解析已关闭");

}
}
else{
存(Group,"视频解析","1");
{
提示("视频解析已开启");
}
}
}


public void zztx(String qun)
{
try{
if(取(qun,"zizhu").equals("1"))
{存(qun, "zizhu", "2");提示("已关闭");}
else
{存(qun, "zizhu", "1");提示("已开启");}
}catch(Exception e){
存(qun, "zizhu", "1");
提示("已开启");
}
}

public void 开关设置(String qun)
{
new Thread(new Runnable(){
public void run(){
kgsz(qun);
}}).start();
}
public void kgsz(String qun)
{
public boolean[] chose(){
boolean qd=false;
Activity act= GetActivity();
boolean 开关=true;
boolean 菜单限制=true;
boolean 图片系统=true;
boolean 音乐系统=true;

boolean 涩图开关=true;
boolean 自身撤回=true;
boolean 智能系统=true;
boolean 查询系统=true;
boolean 视频系统=true;
boolean 词条系统=true;
boolean 视频解析=true;
boolean 消息检测=true;
boolean 私聊回复=true;
boolean 自动回复=true;

boolean 图片外显=true;
boolean 底部时间=true;
boolean 底部一言=true;
boolean 底部尾巴=true;
String[] ww={"开/关机","菜单限制","图片系统","音乐系统","涩图开关","自身撤回","智能系统","查询系统","视频系统","词条系统","视频解析","消息检测","私聊回复","自动回复","图片外显","底部时间","底部一言","底部尾巴"};
if(取(qun,"开关")==null){开关=false;}
if(取(qun,"菜单限制")==null){菜单限制=false;}
if(取(qun,"图片系统")==null){图片系统=false;}
if(取(qun,"音乐系统")==null){音乐系统=false;}
if(取(qun,"涩图开关")==null){涩图开关=false;}
if(取(qun,"自身撤回")==null){自身撤回=false;}
if(取(qun,"智能系统")==null){智能系统=false;}
if(取(qun,"查询系统")==null){查询系统=false;}
if(取(qun,"视频系统")==null){视频系统=false;}
if(取(qun,"词条系统")==null){词条系统=false;}
if(取(qun,"视频解析")==null){视频解析=false;}
if(取(qun,"消息检测")==null){消息检测=false;}
if(取(qun,"私聊回复")==null){私聊回复=false;}
if(取(qun,"自动回复")==null){自动回复=false;}

if(取("开关","图片外显")==null){图片外显=false;}
if(取("开关","底部时间")==null){底部时间=false;}
if(取("开关","底部一言")==null){底部一言=false;}
if(取("开关","底部尾巴")==null){底部尾巴=false;}
boolean[] xx={开关,菜单限制,图片系统,音乐系统,涩图开关,自身撤回,智能系统,查询系统,视频系统,词条系统,视频解析,消息检测,私聊回复,自动回复,图片外显,底部时间,底部一言,底部尾巴};
act.runOnUiThread(new Runnable(){
public void run(){
AlertDialog.Builder dialog = new AlertDialog.Builder(act,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
dialog.setTitle("开关设置");
dialog.setMultiChoiceItems(ww, xx, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialog, int which, boolean isChecked){
xx[which]=isChecked;
}});
dialog.setPositiveButton("确定", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
//提示("a");
dialog.dismiss();
qd=true;}});
dialog.setNegativeButton("取消", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
//提示("a");
dialog.dismiss();
qd=false;}});
dialog.setCancelable(false);
dialog.show();
}
});
while(!qd){Thread.sleep(100);} return xx;
}
boolean[] cs=chose();
if(cs[0]){存(qun, "开关","1");}else{存(qun, "开关",null);}
if(cs[1]){存(qun, "菜单限制","1");}else{存(qun, "菜单限制",null);}
if(cs[2]){存(qun, "图片系统","1");}else{存(qun, "图片系统",null);}
if(cs[3]){存(qun, "音乐系统","1");}else{存(qun, "音乐系统",null);}
if(cs[4]){存(qun, "涩图开关","1");}else{存(qun, "涩图开关",null);}
if(cs[5]){存(qun, "自身撤回","1");}else{存(qun, "自身撤回",null);}
if(cs[6]){存(qun, "智能系统","1");}else{存(qun, "智能系统",null);}
if(cs[7]){存(qun, "查询系统","1");}else{存(qun, "查询系统",null);}
if(cs[8]){存(qun, "视频系统","1");}else{存(qun, "视频系统",null);}
if(cs[9]){存(qun, "词条系统","1");}else{存(qun, "词条系统",null);}
if(cs[10]){存(qun, "视频解析","1");}else{存(qun, "视频解析",null);}
if(cs[11]){存(qun, "消息检测","1");}else{存(qun, "消息检测",null);}
if(cs[12]){存(qun, "私聊回复","1");}else{存(qun, "私聊回复",null);}
if(cs[13]){存(qun, "自动回复","1");}else{存(qun, "自动回复",null);}
if(cs[14]){存("开关", "图片外显","1");}else{存("开关", "图片外显",null);}
if(cs[15]){存("开关", "底部时间","1");}else{存("开关", "底部时间",null);}
if(cs[16]){存("开关", "底部一言","1");}else{存("开关", "底部一言",null);}
if(cs[17]){存("开关", "底部尾巴","1");}else{存("开关", "底部尾巴",null);}
}
