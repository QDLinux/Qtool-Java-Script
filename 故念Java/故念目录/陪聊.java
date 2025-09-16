keyValueSys pl=new keyValueSys(RootPath+"故念目录/陪聊");
public void 陪聊(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    if(pl.get(new String[]{qun},"开").equals("1")){
        if(t.startsWith("问")){
            JSONObject js = new JSONObject(new httpRequests("https://wenxin110.top/api/chat_gpt?text="+URLEncoder.encode(t.substring(1),"utf-8"),"").get("utf-8"));
            if(js.get("code")!=200){
                发送1(qun,"",js.get("msg"));
                return;
            }发送1(qun,"",js.get("text"));
        }
    }
}public void 设置陪聊(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    if(t.equals("开启陪聊")){
        pl.set(new String[]{qun},"开","1");
        发送(qun,"","开启成功");
    }if(t.equals("关闭陪聊")){
        pl.set(new String[]{qun},"开","0");
        发送(qun,"","关闭成功");
    }
}