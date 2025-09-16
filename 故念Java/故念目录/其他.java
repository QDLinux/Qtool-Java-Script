JSONObject 天气 = new JSONObject();
public void 天气(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    if(t.startsWith("天气选")){
        if(!天气.has(qun)){
            发送(qun,"","还没指定要查询的地区呢");
            return;
        }JSONObject js = new JSONObject(new httpRequests("https://jhapi.rjk66.cn/api/qqtq/qqtq?key="+token+"&msg="+天气.get(qun)+"&b="+t.substring(3),"").get("utf-8"));
        if(js.get("code")!=1){
            发送(qun,"",js.get("text"));
            return;
        }JSONArray data = js.get("data").get("data");
        String text = "获取成功！\n";
        for(int i = 0;i < data.length();i++){
            text+="————————————\n"+data.get(i).get("Time")+"\n天气："+data.get(i).get("weather")+"\n温度："+data.get(i).get("temperature")+"\n风："+data.get(i).get("bearing")+"\n空气质量："+data.get(i).get("air_quality")+"\n";
        }发送(qun,"",text);
    }else if(t.startsWith("天气")){
        if(t.equals("天气功能"))return;
        JSONObject js = new JSONObject(new httpRequests("https://jhapi.rjk66.cn/api/qqtq/qqtq?key="+token+"&msg="+t.substring(2),"").get("utf-8"));
        if(js.get("code")!=1){
            发送(qun,"",js.get("text"));
            return;
        }String text = "请再发送“天气选[序号]”\n";
        JSONArray ja = js.get("data");
        for(int i = 0;i < ja.length();i++){
            text += (i+1)+"."+ja.get(i).get("city")+ja.get(i).get("city_t")+"\n";
        }天气.put(qun,t.substring(2));
        发送(qun,"",text);
    }if(t.equals("发言日榜")){
        JSONObject js = new JSONObject(new httpRequests("https://api.xingzhige.com/API/group_speak?qq="+MyUin+"&skey="+(issq?getSkey():"")+"&pskey="+(issq?getPskey("qun.qq.com"):"")+"&group="+qun,"").get("utf-8"));
        if(js.get("code")!=0){
            发送(qun,"",js.get("msg"));
            return;
        }JSONObject data = js.get("data");
        String s = data.get("group")+data.get("days")+"内的发言榜：\n";
        for(int i = 0;i < data.get("data").length();i++){
            s+=data.get("data").get(i).get("Ranking")+"."+data.get("data").get(i).get("name")+"(发言"+data.get("data").get(i).get("speak")+"条，连续发言"+data.get("data").get(i).get("day")+"天)\n";
        }发送(qun,"",s);
    }
}