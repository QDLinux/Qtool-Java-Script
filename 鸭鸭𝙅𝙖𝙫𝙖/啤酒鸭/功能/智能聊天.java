public void zl_zhinengAl(Object msg,String mc,String mg,String mu){
    if(Lshost.contains(mu)){
        if(mc.equals("开启小爱")){
            if(开关.读("小爱",mg)==0){
                toast(repeat_+"小爱",1500);
            }else{
                开关.写("小爱",mg,0);
                toast(repeat_t+"小爱",1500);
            }
        }if(mc.equals("关闭小爱")){
            if(开关.读("小爱",mg)==1){
                toast(_repeat+"小爱",1500);
            }else{
                开关.写("小爱",mg,1);
                toast(t_repeat+"小爱",1500);
            }
        }if(mc.equals("开启妲己")){
            if(开关.读("妲己",mg)==0){
                toast(repeat_+"妲己",1500);
            }else{
                开关.写("妲己",mg,0);
                toast(repeat_t+"妲己",1500);
            }
        }if(mc.equals("关闭妲己")){
            if(开关.读("妲己",mg)==1){
                toast(_repeat+"妲己",1500);
            }else{
                开关.写("妲己",mg,1);
                toast(t_repeat+"妲己",1500);
            }
        }if(mc.equals("切文字")){
            开关.写("切换聊天",mg,1);
            文字(msg,"已切换为文字");
        }if(mc.equals("切语音")){
            开关.写("切换聊天",mg,0);
            文字(msg,"已切换为语音");
        }
    }if(mc.startsWith("小爱")&&2<mc.length()){
        if(开关.读("小爱",mg)==1)return;
        String w=mc.substring(0);
        try{
            String p=Root+"数据/小爱.mp3";
            JSONObject a=new JSONObject(http.xiaoai(w));
            String txt="";
            String tts=a.get("directive").get("url");
            if(a.toString().indexOf("responseText")==-1){
                txt=a.get("directive").get("displayText").replace("小爱","(小爱)");
            }else{
                txt=a.get("responseText").replace("小爱","(小爱)");
            }int y=开关.读("切换聊天",mg);
            if(y==0){
                http.File(tts,p);
                语音(msg,p);
            }else 回复(msg,txt);
        }catch(Exception e){
            回复(msg,"(小爱)"+Api_404+e);
        }
    }if(mc.startsWith("妲己")||mc.startsWith("小妲己")){
        if(开关.读("妲己",mg)==1)return;
        String ms = mc.substring(mc.indexOf("妲己")+2);
        if(ms.equals(""))return;
        try{
            String p=Root+"数据/妲己.mp3";
            String da = http.daji(ms);
            JSONObject json=new JSONObject(da);
            String txt=json.get("body").get("msgList").get(0).get("msg").replace("妲己","(妲己)");
            String tts=json.get("body").get("msgList").get(0).get("ttsUrl");
            int y=开关.读("切换聊天",mg);
            if(y==0){
                http.File(tts,p);
                语音(msg,p);
            }else 回复(msg,txt);
        }catch(Exception e){
            文字(msg,"：妲己"+Api_404);
        }
    }
}
