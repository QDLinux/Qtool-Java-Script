import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.regex.*;

String ReplyWord = "我可爱我知道，但你不能这么逗我吧？";//别人拍你后发送的内容
int ProhibitionTime = 2;//别人拍你后禁言2秒
int TakeApatNum = 2;//连拍超过2次回复
int TakeApatTime = 60;//检测60秒内的连拍
boolean MyTakeApat = false;//自己拍自己是否触发
boolean MeTakeApat = false;//别人拍别人或自己是否触发
boolean Prohibition = false;//别人拍你是否禁言
boolean Continuous = false;//是否只检测连拍

public void Callback_OnRawMsg(Object data)
{
    String data_qun = data.peerUin.toString();
    String uid1, uid2, uin1, uin2, name1, name2;
    String action, reply, pics, type1, type2;
    String info = data.elements.toString().replace("},}",",");
    Pattern p = Pattern.compile("elementType=(.*?),");
    Pattern p0 = Pattern.compile("busiType=(.*?),");
    Matcher a = p.matcher(info);
    Matcher a0 = p0.matcher(info);
    if(a.find()) type1 = a.group(1);
    if(a0.find()) type2 = a0.group(1);
    if(type1 != null && type1.equals("8") && type2 != null && type2.equals("12"))
    {
        Pattern p1 = Pattern.compile("\"> <qq uin=\"(.*?)\"");
        Pattern p2 = Pattern.compile("/> <qq uin=\"(.*?)\"");
        Pattern p3 = Pattern.compile("uin_str1=(.*?),");
        Pattern p4 = Pattern.compile("uin_str2=(.*?),");
        Pattern p5 = Pattern.compile("action_str=(.*?),");
        Pattern p6 = Pattern.compile("suffix_str=(.*?),");
        Pattern p7 = Pattern.compile("action_img_url=(.*?),");
        Matcher a1 = p1.matcher(info);
        Matcher a2 = p2.matcher(info);
        Matcher a3 = p3.matcher(info);
        Matcher a4 = p4.matcher(info);
        Matcher a5 = p5.matcher(info);
        Matcher a6 = p6.matcher(info);
        Matcher a7 = p7.matcher(info);
        if(a1.find()) uid1 = a1.group(1);
        if(a2.find()) uid2 = a2.group(1);
        if(a3.find()) uin1 = a3.group(1);
        if(a4.find()) uin2 = a4.group(1);
        if(a5.find()) action = a5.group(1);
        if(a6.find()) reply = a6.group(1);
        if(a7.find()) pics = a7.group(1);
        if(uid1 != null)
        {
            Pattern p8 = Pattern.compile(uid1 + "=(.*?),");
            Matcher a8 = p8.matcher(info);
            if(a8.find()) name1 = a8.group(1);
        }
        if(uid2 != null)
        {
            Pattern p9 = Pattern.compile(uid2 + "=(.*?),");
            Matcher a9 = p9.matcher(info);
            if(a9.find()) name2 = a9.group(1);
        }
        if(uin1 != null && uin1.equals(MyUin)) name1 = "我";
        if(uin2 != null && uin2.equals(MyUin)) name2 = "我";
        if(name2 == null) name2 = name1;
        if(uin1 != null && uin2 != null && action != null && pics != null)
        {
            pics = pics.replace("http://","https://");
            if(uin2.equals(MyUin) || MeTakeApat)
            {
                if(ReplyWord.equals(""))
                {
                    if(MyTakeApat && uin1.equals(MyUin) || !uin1.equals(MyUin))
                    {
                        sendMsg(data_qun,"",name1 + action + "[PicUrl=" + pics + "]" + name2 + reply);
                    }
                }
                else if(!ReplyWord.equals("null"))
                {
                    if(MyTakeApat && uin1.equals(MyUin) || !uin1.equals(MyUin))
                    {
                        TakeApat(data_qun,uin2,uin1,1,System.currentTimeMillis());
                    }
                }
            }
        }
    }
}

JSONObject TakeApatJson = new JSONObject();
public void TakeApat(String qun,myqq,uin,int i,long time) throws JSONException
{
    if(!Continuous)
    {
        if(Prohibition) Forbidden(qun,uin,ProhibitionTime);
        sendMsg(qun,"","[AtQQ="+uin+"]\n"+ReplyWord);
    }
    else if(Continuous)
    {
        if(TakeApatJson.has(qun))
        {
            if(TakeApatJson.get(qun).get(myqq).has(uin))
            {
                int Len = Integer.parseInt(getTakeApatJson(qun,myqq,uin,"Num"));
                long time2 = Long.parseLong(getTakeApatJson(qun,myqq,uin,"Time"));
                if(System.currentTimeMillis() - time2 <= (TakeApatTime * 1000))
                {
                    if(Len >= TakeApatNum)
                    {
                        if(Prohibition) Forbidden(qun,uin,ProhibitionTime);
                        sendMsg(qun,"","[AtQQ="+uin+"]\n你"+TakeApatTime+"秒拍了"+(Len + 1)+"次\n我有那么可爱嘛？");
                        setTakeApatJson(qun,myqq,uin,new String[]{"Num","Time"},new Object[]{(Len + i),time2});
                    }
                    else setTakeApatJson(qun,myqq,uin,new String[]{"Num","Time"},new Object[]{(Len + i),time2});
                }
                else setTakeApatJson(qun,myqq,uin,new String[]{"Num","Time"},new Object[]{i,time});
            }
            else setTakeApatJson(qun,myqq,uin,new String[]{"Num","Time"},new Object[]{i,time});
        }
        else setTakeApatJson(qun,myqq,uin,new String[]{"Num","Time"},new Object[]{i,time});
    }
}

public void setTakeApatJson(String qun,myqq,uin,String[] key,Object[] value) throws JSONException
{
    JSONObject recevUin = new JSONObject();
    JSONObject sendUin = new JSONObject();
    JSONObject data = new JSONObject();
    for(int i = 0; i < key.length; i++)
    {
        data.put(key[i],value[i]);
    }
    sendUin.put(uin,data);
    recevUin.put(myqq,sendUin);
    TakeApatJson.put(qun,recevUin);
}

public String getTakeApatJson(String qun,myqq,uin,key) throws JSONException
{
    return TakeApatJson.get(qun).get(myqq).get(uin).optString(key);
}