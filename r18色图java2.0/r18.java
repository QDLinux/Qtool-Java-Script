/*
作者:天如
作者qq:3291691454
指令:开启r18，关闭r18，r18
*/
import android.os.Environment;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;

Toast("r18色图脚本已加载\n使用方法:\n1.进入群聊界面\n2.长按右上角三条杠进入便携菜单\n3.单击开启r18后在群内发送\"r18\"即可");

String RootPath = Environment.getExternalStorageDirectory().getAbsoluteFile()+"/LD_Module/Plugin/data/";

load(RootPath + "api/ItemCore.java");

String OpenItemID = "";
String CloseItemID = "";

setItemCallback("ItemCallBack");
setFlag("LD_QQ3291691454_r18");
public void ItemCallBack(String GroupUin)
{
RemoveItem(PluginID,OpenItemID);
RemoveItem(PluginID,CloseItemID);
String isopen=item.GetItemData("data", "r18开关", GroupUin);
	if("1".equals(isopen))
	{
		CloseItemID = AddItem("关闭本群r18","Close",PluginID);
		RemoveItem(PluginID,OpenItemID);
	}
	else
	{
		OpenItemID = AddItem("开启本群r18","Open",PluginID);
		RemoveItem(PluginID,CloseItemID);
	}
}

public void Open(String GroupUin,String qq,int type)
{
if(type==1){
	Toast("本群r18已开启");
		item.SetItemData("data", "r18开关", GroupUin, 1);
}
else Toast("该功能暂时只能在群里使用");
}

public void Close(String GroupUin,String qq,int type)
{
if(type==1){
	Toast("本群r18已关闭");
		item.DeleteItem("data", "r18开关", GroupUin);
}
}

public void onMsg(Object data)
{
String text=data.MessageContent;
String qq=data.UserUin;
String qun=data.GroupUin;


if(text.matches("(r|R)18"))
{
if("1".equals(item.GetItemData("data", "r18开关", qun)))
{
JSONObject json1 = new JSONObject(httpget("https://api.lolicon.app/setu/v2?r18=1&num=1&proxy=i.pixiv.re",""));
String text1=json1.getString("data");
String text2="𒑜"+text1+"𒑜";
String text3=text2.replaceAll("𒑜\\[|\\]𒑜","");
JSONObject json = new JSONObject(text3);
String text4=json.getString("urls");
JSONObject json2 = new JSONObject(text4);
String r18="pid:"+json.get("pid")+"\n"+"uid:"+json.get("uid")+"\n"+"标题:"+json.get("title")+"\n"+"作品名:"+json.get("author")+"\n"+"标签:"+json.getString("tags").replaceAll("[\\[\\]\"]","").replace(",","、")+"\n"+"规格:"+json.get("width")+" * :"+json.get("height")+"\n"+"图片格式:"+json.get("ext")+"\n"+"图片链接:"+json2.get("original");
sendMsg(qun,"",r18);
} else {
if(qq.equals(MyUin)) Toast("请先长按群右上角三条杠进入便捷菜单后开启此功能再使用");
}
}
}

public String httpget(String url,String cookie)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL urlObj = new URL(url);
                URLConnection uc = urlObj.openConnection();
                uc.setRequestProperty("Cookie",cookie);
                uc.setConnectTimeout(10000);
                uc.setReadTimeout(10000);
                isr = new InputStreamReader(uc.getInputStream(), "utf-8");
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