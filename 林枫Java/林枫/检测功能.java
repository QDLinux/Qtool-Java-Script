public void 检测功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
           if ("12".equals(getString(qun, "检测功能")))
       {
       if (quntext.equals("QQ检测")||quntext.equals("qq检测"))
       {
       String jc=get("http://api.ccfun.com.cn/api/xiangji.php?qq="+uin);
       sendMsg(qun,"",lfmm+"\n"+jc);
       }
       if (quntext.startsWith("QQ检测")||quntext.startsWith("qq检测"))
        {
        String st = quntext.substring(4);
        if (st.equals(""))
        {
        return;
        }else{
        String jc=get("ttp://api.ccfun.com.cn/api/xiangji.php?qq="+st);        
        sendMsg(qun,"",lfmm+"\n"+jc+"\n"+"坏了，不知道为啥");
        
        }
        }
        }
        }