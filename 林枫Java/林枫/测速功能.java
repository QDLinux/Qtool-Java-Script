public void 测速功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
    if ("13".equals(getString(qun, "测速功能")))
        {
        if (quntext.startsWith("ping"))
        {
        String st = quntext.substring(4);
        if (st.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"没有网址你ping个🐔？");
        return;
        }
        String wzcs= get("http://api.wxsszs.cn/api/ping.php?url="+st);
        sendMsg(qun,"",lfmm+"\n"+wzcs);
        }
        }
        }