public void IP功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
    if ("14".equals(getString(qun, "IP功能"))) 
       {
        if (quntext.startsWith("IP信息")||quntext.startsWith("ip信息"))
        {
        String st = quntext.substring(4);
        if (st.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"没有IP你获取个🐔的信息？");
        return;
        }
        String ipxx=get("http://api.wxsszs.cn/api/ip_info.php?ip="+st);
        sendMsg(qun,"",lfmm+"\n"+ipxx);
        }
        }
        }