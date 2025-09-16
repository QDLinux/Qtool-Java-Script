// int info=1;
// //是否发送涩图信息，1为是，0为否

// int pack=0;
// //是否以合并转发形式发送涩图，1为是，0为否



import org.json.*;
import org.json.JSONObject;
import org.json.JSONArray;

AddItem("开启/关闭本群画图功能","kaiguan",PluginID);

public void kaiguan(String qun)
{
if("1".equals(getString(qun,"画图")))
	{
	putString(qun, "画图", null);
      Toast("不能在本群画图了!");
	}
	else{
	putString(qun,"画图","1");
	Toast("可以在本群画图了!(≧ω≦)/");
	}
}

public String httpget(String url){
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try{
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        uc.setConnectTimeout(15000);
        uc.setReadTimeout(15000);
        isr = new InputStreamReader(uc.getInputStream(), "utf-8");
        BufferedReader reader = new BufferedReader(isr);
        String line;while ((line = reader.readLine()) != null){buffer.append(line + "\n");}
    }catch (Exception e){
        e.printStackTrace();
    }finally{
        try{
            if (null != isr){isr.close();}
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    if (buffer.length() == 0) return buffer.toString();
    buffer.delete(buffer.length() - 1, buffer.length());
    return buffer.toString();
}

public void onMsg(Object data){
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
if((data.IsGroup&&("1".equals(getString(data.GroupUin,"画图"))))){
if(quntext.startsWith("画张")&&quntext.endsWith("图片")){
String tag=quntext.substring(2,quntext.length()-4);//文字描述
String typ=quntext.substring(quntext.length()-4,quntext.length()-2);//类型描述
//Toast(tag);
String setu0;
//if(tag.equals("")) 
setu0=httpget("https://api.lolimi.cn/API/AI/sd.php?msg="+tag+"&mode="+typ);
//else setu0=httpget("https://api.lolicon.app/setu/v2?excludeAI=true&r18=1&tag="+tag);
JSONObject setu1=new JSONObject(setu0);
JSONArray setu2=setu1.optJSONArray("data");

String newurl="https://api.lolimi.cn/API/AI/sd.php?msg="+tag+"&mode="+typ;
//Toast(setu2);
// if(setu2==null){
//     sendMsg(qun,"","获取失败！未知错误");
//     return;
// }
// else if(setu2.length()==0){
//     sendMsg(qun,"","[AtQQ="+data.UserUin+"]\n没有找到关于["+tag+"]的涩图喵!");
//     return;
// }
    // JSONObject setu3=setu2.getJSONObject(0);
    // String pid=setu3.getString("pid");
    // String uid=setu3.getString("uid");
    // String title=setu3.getString("title");
    // String author=setu3.getString("author");
    // String width=setu3.getString("width");
    // String height=setu3.getString("height");
    // JSONArray tags1=setu3.getJSONArray("tags");
    // String tagsf="";
    // for(int i=0;i<tags1.length();i++){
    //     String tags2=tags1.getString(i);
    //     tagsf=tagsf+tags2+",";
    // }
    // tagsf=tagsf.substring(0,tagsf.length()-1);
    // JSONObject urls=setu3.getJSONObject("urls");
    // String original=urls.getString("original");
    sendPic(qun,"",newurl);
    // if(info!=0) sendReply(qun,data,"标题:"+title+"\n作者:"+author+"\npid:"+pid+"\nuid:"+uid+"\n大小:"+width+"*"+height+"\n标签:"+tagsf);
    // if(pack==0) sendPic(qun,"",original);
    // else sendPackMsg(qun,"","193095561","2854196320","[PicUrl="+original+"]","点击查看主人要的"+tag+"涩图喵~","光光涩图~");
}
}
}