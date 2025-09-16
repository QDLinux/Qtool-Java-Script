public void 图片外显(Object data)
{
	String quntext = data.MessageContent;
	String qq = data.UserUin;
	String qun = data.GroupUin;
	String 发布者名称 =data.SenderNickName;

if(qq.equals(MyUin))
{
if(quntext.equals("开启图片外显"))
{
	if("1".equals(取("开关","图片外显")))
	{
		sendm(qun,"已经开了");
		return;
	}
	存("开关","图片外显","1");
	String c="已开启图片外显";
	sendm(qun,c);
}

if(quntext.equals("关闭图片外显"))
{
	if(!"1".equals(取("开关","图片外显")))
	{
		sendm(qun,"还没开呢");
		return;
	}
	存("开关", "图片外显", null);
	String c= "已关闭图片外显";
	sendm(qun,c);
}

if(quntext.equals("切换自定义外显"))
{
if(!"1".equals(取("开关","图片外显")))
	{
		sendm(qun,"图片外显还没开呢");
		return;
	}
	if(取("图片外显","模式")==null)
	{
		sendm(qun,"已经切换为自定义外显了");
		return;
	}
	存("图片外显","模式",null);
	String c="已切换为自定义外显";
	sendm(qun,c);
}


if(quntext.startsWith("自定义外显"))
{
String text=quntext.substring(5);
if(text.equals(""))
{
sendm(qun,"请输入外显的内容");
return;
}
存("图片外显","自定义外显",text);
sendm(qun,"已写入");
}

if(quntext.equals("查看自定义外显"))
{
String c="还没有内容呢，赶快设置一个吧";
if(取("图片外显","自定义外显")==null)
{}else{
c=取("图片外显","自定义外显");
}
sendm(qun,"外显内容:\n"+c);
}

if(quntext.equals("清空自定义外显"))
{
存("图片外显","自定义外显",null);
sendm(qun,"已清空");
}



if(quntext.equals("切换一言外显"))
{
if(!"1".equals(取("开关","图片外显")))
	{
		sendm(qun,"图片外显还没开呢");
		return;
	}
	if("1".equals(取("图片外显","模式")))
	{
		sendm(qun,"已经切换为一言外显了");
		return;
	}
	存("图片外显","模式","1");
	String c="已切换为一言外显";
	sendm(qun,c);
}


if(quntext.equals("切换骚话外显"))
{
if(!"1".equals(取("开关","图片外显")))
	{
		sendm(qun,"图片外显还没开呢");
		return;
	}
	if("2".equals(取("图片外显","模式")))
	{
		sendm(qun,"已经切换为骚话外显了");
		return;
	}
	存("图片外显","模式","2");
	String c="已切换为骚话外显";
	sendm(qun,c);
}


if(quntext.equals("切换滚刀外显"))
{
if(!"1".equals(取("开关","图片外显")))
	{
		sendm(qun,"图片外显还没开呢");
		return;
	}
	if("3".equals(取("图片外显","模式")))
	{
		sendm(qun,"已经切换为滚刀外显了");
		return;
	}
	存("图片外显","模式","3");
	String c="已切换为滚刀外显";
	sendm(qun,c);
}




import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
if("1".equals(取("开关","图片外显")))
{
if(data.IsSend&&data.msg instanceof MessageForPic)
{
String 图片外显="这是一个图片外显";
	try{
		if(取("图片外显","模式")==null)
		{
		if(取("图片外显","自定义外显")==null)
		{}else{
		图片外显=取("图片外显","自定义外显");
		}
		} else if("1".equals(取("图片外显","模式")))
		{
		图片外显=取("图片外显","内容");
		new Thread(new Runnable() {
			public void run() {
		String 外显=访问("https://api.mcloc.cn/words/").replace("{\n    \"hitokoto\": \"","").replaceAll("\",\n .*\n\\}","");
		存("图片外显","内容",外显);
		}
		}).start();
		}else if("2".equals(取("图片外显","模式")))
		{
		图片外显=取("图片外显","内容");
		new Thread(new Runnable() {
			public void run() {
		String 外显=访问("http://api.yujn.cn/api/saohua.php");
		存("图片外显","内容",外显);
		}
		}).start();
		}else if("3".equals(取("图片外显","模式")))
		{
		图片外显=取("图片外显","内容");
		new Thread(new Runnable() {
			public void run() {
		String 外显=访问("http://api.yujn.cn/api/Ridicule.php?msg=1");
		存("图片外显","内容",外显);
		}
		}).start();
		}
		}catch (e) {
	Toast(e);
	}

		if(data.msg.picExtraData==null)data.msg.picExtraData=new PicMessageExtraData();
		data.msg.picExtraData.textSummary=图片外显;
}
}

}

}