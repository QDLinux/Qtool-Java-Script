public void 听歌时长(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
    if ("2".equals(getString(qun, "刷听歌时长"))) {//判读是否开启
        if(quntext.equals("刷听歌时长"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[AtQQ="+uin+"]"+"\n"+tgsc);
        for(int i=0; i<25; i++){//循环访问下面的接口
        String a=get("https://decode.xiaojieapi.com/api/qqmusic.php?qq="+uin);}
        }
        }
        }