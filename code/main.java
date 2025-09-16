//作者：一只野生天如(QQ3291691454)


//总有些憨憨恶意利用脚本，黑名单群该加的加
//违禁词也该加的加，字数限制啥的也该设置就设置
//或者最好打开"仅自己可用"开关（默认开启）


//是否仅自己可用
boolean 仅自己用 = true;

//违禁词，有这个词的话就不会发出来，在大括号里加，英文逗号隔开，用英文引号包住
//比如{"傻逼","草泥马","nmsl","rnm"}
String[] 违禁词 = {"傻逼","草泥马"};

//最大输出字数限制
int 最大输出 = 150;


String OpenItemID = "";
String CloseItemID = "";

setItemCallback("ItemCallBack");
setFlag("LD_QQ3291691454_code");
public void ItemCallBack(String GroupUin)
{
String isopen=getString("code开关", GroupUin);
	if("开".equals(isopen))
	{
		CloseItemID = AddItem("关闭本群code","Close",PluginID);
		RemoveItem(PluginID,OpenItemID);
	}
	else
	{
		OpenItemID = AddItem("开启本群code","Open",PluginID);
		RemoveItem(PluginID,CloseItemID);
	}
}

public void Open(String GroupUin,String qq,int type)
{
if(type==1){
	Toast("本群code已开启");
	putString("code开关", GroupUin, "开");
}
else Toast("该功能暂时只能在群里使用");
}

public void Close(String GroupUin,String qq,int type)
{
if(type==1){
	Toast("本群code已关闭");
	putString("code开关", GroupUin, null);
}
}

import org.json.JSONObject;

public void onMsg(Object data)
{
String text=data.MessageContent;
String qq=data.UserUin;
String qun=data.GroupUin;
long sendtime=data.MessageTime*1000;
long nowtime=System.currentTimeMillis();

if(nowtime - sendtime>60000)
{
return;
}

if(data.IsSend&&text.matches("开启?code")){
if(data.IsGroup){
	Toast("本群code已开启");
	putString("code开关", qun, "开");
}
else Toast("该功能暂时只能在群里使用");
}

if(data.IsSend&&text.matches("关闭?code")){
if(data.IsGroup){
	Toast("本群code已关闭");
	putString("code开关", qun, null);
}}

if(text.startsWith("code ")&&getString("code开关",qun) != null){
if(仅自己用 && !data.IsSend) return;
a=text.indexOf("\n");
if(a == -1) return;
lang=text.substring(0,a).substring(5).toLowerCase();
command=text.substring(a+1).replaceAll("\\\\","\\\\\\\\").replaceAll("\n","\\\\n").replaceAll("\"","\\\\\"");
//sendMsg(qun,"",a+lang+command);

String FileName="";
switch(lang){
case "bash":
lang="bash";
FileName="sh";
break;
case "sh":
lang="bash";
FileName="sh";
break;
case "py":
lang="python";
FileName="py";
break;
case "python":
lang="python";
FileName="py";
break;
case "c":
lang="c";
FileName="c";
break;
case "c++":
lang="cpp";
FileName="cpp";
break;
case "cpp":
lang="cpp";
FileName="cpp";
break;
case "js":
lang="javascript";
FileName="js";
break;
case "javascript":
lang="javascript";
FileName="js";
break;
case "kt":
lang="kotlin";
FileName="kt";
break;
case "kotlin":
lang="kotlin";
FileName="kt";
break;
case "lua":
lang="lua";
FileName="lua";
break;
case "go":
lang="go";
FileName="go";
break;
case "golang":
lang="go";
FileName="go";
break;
case "c#":
lang="csharp";
FileName="cs";
break;
case "java":
lang="java";
FileName="java";
break;
case "php":
lang="php";
FileName="php";
break;
case "groovy":
lang="groovy";
FileName="groovy";
break;
case "rust":
lang="rust";
FileName="rs";
break;
case "typescript":
lang="typescript";
FileName="ts";
break;
case "ts":
lang="typescript";
FileName="ts";
break;
case "perl":
lang="perl";
FileName="pl";
break;
case "nix":
lang="nix";
FileName="nix";
break;
default:
sendMsg(qun,"","未知语言"+lang);
break;
}


String postData=httppost("https://glot.io/run/"+lang+"?version=latest","","{\"files\":[{\"name\":\"main."+FileName+"\",\"content\":\""+command+"\"}],\"stdin\":\"\",\"command\":\"\"}");
//sendMsg(qun,"",postData);
if(postData.equals("")) postData="{\"message\":\"访问接口失败\"}";
JSONObject data=new JSONObject(postData);
if(!data.optString("message").equals("")){
sendMsg(qun,"",data.optString("message"));
return;
}
out=data.optString("stdout")+data.optString("stderr")+data.optString("error");
if(out.equals("")) out="执行成功，但是没有输出";
int l=out.length();
if(l > 最大输出) out=out.substring(0,最大输出-1) + "\n为防止刷屏，已省略" + (l - 最大输出) + "字";
if(isContain(out,违禁词)) out="输出结果包含违禁词，我不想回答";
sendMsg(qun,"",out.replaceAll("\\\\n","\n"));
}}



public boolean isContain(String str,String[] keywords)
{
str=str.toLowerCase();
for(String keyword : keywords){
  keyword=keyword.toLowerCase();
  if(str.contains(keyword)) return true;
  }
return false;
}


public String httppost(String urlPath, String cookie,String data)
	{
		StringBuffer buffer = new StringBuffer();
        InputStreamReader isr = null;
        try {
            URL url = new URL(urlPath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);
			uc.setDoOutput(true);
			uc.setConnectTimeout(10000);// 设置连接主机超时（单位：毫秒）
			uc.setReadTimeout(20000);// 设置从主机读取数据超时（单位：毫秒）
			uc.setRequestMethod("POST");
			uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			uc.setRequestProperty("Cookie",cookie);
	        uc.getOutputStream().write(data.getBytes("UTF-8"));
			uc.getOutputStream().flush();
			uc.getOutputStream().close();
			if (uc.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) isr = new InputStreamReader(uc.getErrorStream(), "utf-8");
            else isr = new InputStreamReader(uc.getInputStream(), "utf-8");
            BufferedReader reader = new BufferedReader(isr); //缓冲
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != isr) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    if(buffer.length()==0)return buffer.toString();
    buffer.delete(buffer.length()-1,buffer.length());
    return buffer.toString();
}
