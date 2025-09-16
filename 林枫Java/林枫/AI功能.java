public void AI功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
           if ("15".equals(getString(qun, "gpt功能"))) {
       if (quntext.startsWith("gpt")||quntext.startsWith("GPT"))
        {
        String st = quntext.substring(3);
        if (st.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"[AtQQ="+uin+"]"+"\n"+"没问题你问个🐔？");
        return;
        }else{
//        String gpt=get("http://api.youzai.love/API/NewGPT.php?msg="+st);
        String gpt=get("http://y.ovoa.cc/api/ChatGPT.php?msg="+st+"&id=5200&type"+uin+"=&mode=");
//       String gpt=get("http://43.139.36.221/chat.php?q="+st);
       JSONObject json= new JSONObject(gpt);
       JSONObject data= json.getJSONObject("data");
        String gptfh=data.get("content");
//        sendReply(uin,data.msg,lfmm+"\n"+gptfh);
        sendMsg(qun,"",lfmm+"\n"+"[AtQQ="+uin+"]"+"\n"+"问题:"+st+"\n"+"回复:"+gptfh);
       }
       }
       }
       if (quntext.startsWith("问"))
        {
        String st = quntext.substring(1);
        if (st.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"没问题你问个🐔？");
        return;
        }else{
        String ai=get("http://apis.liaomengyun.top/API/qing_chat.php?msg="+st);
        JSONObject json= new JSONObject(ai);
        String hf =json.get("msg");
        sendMsg(qun,"",lfmm+"\n"+"[AtQQ="+uin+"]"+"\n"+"问题:"+st+"\n"+"回复:"+hf);
       }
       }
       if (quntext.startsWith("小爱同学"))
       {
       String st = quntext.substring(4);
       if (st.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"没问题你问个🐔？");
        return;
        }else{
       String xatx=get("https://api.xiaolanx.cn/API/xiaoai?msg="+st);
       sendMsg(qun,"",lfmm+"\n"+"[AtQQ="+uin+"]"+"\n"+"问题:"+st+"\n"+"回答:"+xatx);
       }
       }
       if (quntext.startsWith("夸克ai")||quntext.startsWith("夸克AI"))
       {
       String st=quntext.substring(4);
       if (st.equals(""))
       {
       sendMsg(qun,"",lfmm+"\n"+"没问题你发个🐔？");
       return;
       }else{
       String kkai=get("http://api.ccfun.com.cn/api/quark_ai.php?msg="+st);
       JSONObject json= new JSONObject(kkai);
       String hf =json.get("text");
//       sendMsg(qun,"",lfmm+"\n"+hf);
       sendMsg(qun,"",lfmm+"\n"+"[AtQQ="+uin+"]"+"\n"+"问题:"+st+"\n"+"回答:"+hf);
       }
       }
       }
/*        if (quntext.startsWith("猫娘"))
        {
        String jj="请扮演猫娘回答我的问题。";
        String st = quntext.substring(2);
        if (st.equals(""))
        {
        sen*/