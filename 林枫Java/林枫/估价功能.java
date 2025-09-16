public void 估价功能(Object data) {    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
    if ("3".equals(getString(qun, "QQ估价")))
        {
        if(quntext.equals("QQ估价")||quntext.equals("qq估价"))
        {
        String gj="https://c.51240.com/temp/qqjiazhi/";
         sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+gj+uin+"]");
        }
        if (quntext.startsWith("估Q")||quntext.equals("估q")) 
        {
        String gj="https://c.51240.com/temp/qqjiazhi/";
        String gq = quntext.substring(2); //截取quntext中2字符以后的字符(注意是字符而不是字节)
        if (gq.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"没有QQ号你估个🐔？");
        return;
        }
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+gj+gq+"]"); 
        }
        }
        }