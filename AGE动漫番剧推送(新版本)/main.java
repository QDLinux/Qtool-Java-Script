import java.io.*; 
import java.net.*;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

String RootPath = AppPath+"/";
load(RootPath +"util.java");
loadJar(RootPath+"jsoup-1.13.1.jar");


//作者:TKゞ刺痛

//使用方法:
//群内发送:开启/关闭番剧推送  即可
//更新:每日推荐

//官方群:676360846
//官方群:158183435

    
//age动漫番剧推送,有番剧更新时,会自动推送内容
//一般番剧会在晚上更新,他更新了才会推送

//如有bug，请及时反馈
    
    
    
    
    
    public static String url="https://www.agemys.com";
    public static List everyday=new ArrayList();
    
	new Thread(new Runnable() {
            //@Override
            public void run() {
                int num=1;
                while (true){
                    int time_radom=1000*60;
                    try {
                        List list_data=new ArrayList();
                        Document parse = Jsoup.parse(new URL(url),10000);
                        Element div_left_baseblock = parse.getElementsByClass("div_left baseblock").first();
                        Elements blockcontent = div_left_baseblock.select("div.blockcontent");
                        for(int i=0;i<blockcontent.size();i++){
                            Elements select=blockcontent.get(i).select("ul.ul_li_a5 > li");
                            if(i==0){
                                List every=new ArrayList();
                                for (Element li:select){
                                    JSONObject jsonObject=new JSONObject();
                                    jsonObject.put("url",url+li.select(".anime_icon1_name_a").attr("href"));
                                    String img = li.select("[src]").attr("src");
                                    if(!img.contains("http")&&!img.contains("https")) img="https:"+img;
                                    jsonObject.put("img",img);
                                    jsonObject.put("name",li.select(".anime_icon1_name").first().text());
                                    jsonObject.put("title",li.select(".anime_icon1_name1").first().text());
                                    every.add(jsonObject);
                                }
                                if(!everyday.equals(every)){
                                    everyday=every;
                                }
                            }
                            if(i==1){
                                for (Element li:select){
                                    JSONObject jsonObject=new JSONObject();
                                    jsonObject.put("url",url+li.select(".anime_icon1_name_a").attr("href"));
                                    String img = li.select("[src]").attr("src");
                                    if(!img.contains("http")&&!img.contains("https")) img="https:"+img;
                                    jsonObject.put("img",img);
                                    jsonObject.put("name",li.select(".anime_icon1_name").first().text());
                                    jsonObject.put("title",li.select(".anime_icon1_name1").first().text());
                                    list_data.add(jsonObject);
                                }
                            }
                        }

                        String data = item.GetItemData("番剧推送", "番剧数据", "data");
                        if (data.equals("")) {
                            item.SetItemData("番剧推送", "番剧数据", "data", list_data);
                            continue;
                        }
                        JSONArray get_bd_data = new JSONArray(data);                      
                        StringBuilder text = new StringBuilder("◇有新番更新啦!◇");
                        int fan_xh = 1;

                        for(JSONObject jsonObject:list_data){                        
                            String newtitle=jsonObject.getString("title");
                            String newname=jsonObject.getString("name");
                            boolean flag_pd = false;
                            for (int j = 0; j < get_bd_data.length(); j++) {
                                JSONObject get_now_data = get_bd_data.getJSONObject(j);
                                String nowtitle = get_now_data.getString("title");
                                String nowname = get_now_data.getString("name");
                                if (newtitle.equals(nowtitle)&&newname.equals(nowname)){
                                    
                                    flag_pd = true;
                                    break;
                                }
                            }
                            if(!flag_pd){                                              
                                text.append("\n\n").append(fan_xh).append("番名 : ").append(jsonObject.getString("name")).append("\n").append("图片 : ").append(jsonObject.getString("img")).append("\n").append(jsonObject.getString("title")).append("\n").append("地址 : ").append(jsonObject.getString("url"));                             
                                fan_xh++;
                            }

                        }
                        if (!String.valueOf(text).equals("◇有新番更新啦!◇")) {
                            String send_group = item.GetItemData("番剧推送", "番剧数据", "switch");
                            if (!send_group.equals("")) {
                                JSONArray group_data = new JSONArray(send_group);
                                for (int i = 0; i < group_data.length(); i++) {
                                    JSONObject mun = group_data.getJSONObject(i);
                                    if (mun.getString("Group_switch").equals("true")) {
                                        //new Robot_send().TL_send(mun.getString("Group"), String.valueOf(text), "", "", new String[]{});
                                        sendMsg(mun.getString("Group"),"",String.valueOf(text));
                                    }
                                }
                            }                            
                            item.SetItemData("番剧推送", "番剧数据", "data", list_data);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        if(num%5==0) {
                            Thread.sleep(time_radom*10L);
                        }else {
                            Thread.sleep(time_radom* 3L);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num++;
                }
            }
        }).start();
        
	public void setGroup_data(String Group,boolean bl) throws JSONException {
        String text=item.GetItemData("番剧推送", "番剧数据", "switch");
        JSONObject json = new JSONObject();
        JSONArray js=new JSONArray();
        if(!text.equals("")) {
            JSONArray data = new JSONArray(text);
            boolean flag = true;
            int flag2 = -1;
            for (int i = 0; i < data.length(); i++) {
                JSONObject mun = data.getJSONObject(i);
                if (mun.getString("Group").equals(Group)) {
                    flag = false;
                    flag2 = i;
                    break;
                }
            }
            if (!flag) {
                json.put("Group", Group);
                json.put("Group_switch", bl);
                data.put(flag2, json);
                item.SetItemData("番剧推送", "番剧数据", "switch", data);
            } else {
                json.put("Group", Group);
                json.put("Group_switch", bl);
                data.put(json);
                item.SetItemData("番剧推送", "番剧数据", "switch", data);
            }
        }else {
            json.put("Group", Group);
            json.put("Group_switch", bl);
            js.put(json);
            item.SetItemData("番剧推送", "番剧数据", "switch", js);
        }
    }
    public String getGroup_data(String Group) throws JSONException {
        String text=item.GetItemData("番剧推送", "番剧数据", "switch");
        String flag = "1";
        if(!text.equals("")){
            JSONArray data = new JSONArray(text);
            for (int i = 0; i < data.length(); i++) {
                JSONObject mun = data.getJSONObject(i);
                if (mun.getString("Group").equals(Group)) {
                    flag = String.valueOf(mun.get("Group_switch"));
                    break;
                }
            }
        }
        return flag;
    }	
public void onMsg(Object data){
    if(!data.UserUin.equals(MyUin)) return;
    
    if(data.MessageContent.equals("每日推荐")){
            String text="";
            for(JSONObject jsonObject:everyday){
                text=text+"番名:"+jsonObject.get("name")+"\n标题:"+jsonObject.get("title")+"\n图片:"+jsonObject.get("img")+"\n地址:"+jsonObject.get("url")+"\n\n";
            }
            sendMsg(data.GroupUin,"",text);
    }
     
	if(data.MessageContent.equals("开启番剧推送")){
        String flag=getGroup_data(data.GroupUin);
        if(!flag.equals("1")&&flag.equals("true")){
            sendMsg(data.GroupUin,"","番剧推送已经处于开启状态");
            return;
        }
        setGroup_data(data.GroupUin,true);
        sendMsg(data.GroupUin,"","番剧推送开启成功\n有新番剧更新时会自动为您推送");
    }
    if(data.MessageContent.equals("关闭番剧推送")){
        String flag=getGroup_data(data.GroupUin);
        if(!flag.equals("1")&&flag.equals("false")){
            sendMsg(data.GroupUin,"","番剧推送已经处于关闭状态");
            return;
        }
        setGroup_data(data.GroupUin,false);
        sendMsg(data.GroupUin,"","番剧推送关闭成功");
    }
        
}