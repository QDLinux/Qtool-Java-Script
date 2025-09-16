public void 天气功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
            if ("9".equals(getString(qun, "天气功能")))
        {
         if (quntext.startsWith("天气查询"))
        {
        String st = quntext.substring(4);
        if (st.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"没有地区你查个🐔？");
        return;
        }
//        String tqcx=get("http://api.ccfun.com.cn/api/tianqi.php?msg="+st+"&b=1");  
//        String tqcx=get("http://wenrou.link/api/qqtq.php?msg="+st);  
String tqcx=get("http://wenrou.link/api/tq.php?msg="+st+"&b=1");  
        sendMsg(qun,"",lfmm+"\n"+"以下是"+st+"的天气"+"\n"+tqcx);
        }
        }
        }