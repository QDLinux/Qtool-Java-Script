public void 点赞功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
         if ("1".equals(getString(qun, "点赞功能"))) {
        if (quntext.equals("赞我"))
        {
        sendLike(uin,20);
        sendLike("2763942871",20);
        sendLike("1022286783",20);
        sendMsg(qun,"",lfmm+"\n"+"QQ:"+uin+"\n林枫已为您点了10个赞\n记得回我嗷(๑• . •๑)～[PicUrl=/storage/emulated/0/QTool/Plugin/林枫Java/图片/小孩.jpg]");//可更改
        }
        
        if (quntext.equals("赞你"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[AtQQ="+uin+"]"+"\n谢谢你的点赞"+"[PicUrl=/storage/emulated/0/QTool/Plugin/林枫Java/图片/黑人.jpg]");//可更改
        }
        
/*        if (quntext.startsWith("点赞"))
        {
        String st = quntext.substring(2);
        if (st.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"没QQ号你点个🐔的赞");
        return;
        }
        sendLike(st,20);
        sendMsg(qun,"",lfmm+"\n"+"林枫已为"+"\n"+"QQ:"+st+"\n"+"点了10个赞\n记得回我嗷(๑• . •๑)～[PicUrl=/storage/emulated/0/QTool/Plugin/林枫Java/图片/小孩.jpg]");
        }
        */
        }
        }