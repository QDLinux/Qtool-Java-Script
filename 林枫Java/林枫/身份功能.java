public void 身份功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
           if ("11".equals(getString(qun, "身份功能")))
       {
       if (quntext.equals("随机身份证"))
       {
       String sfz=get("http://sszs.wxsszs.cn/api/jk/sfz.php");
       sendMsg(qun,"",lfmm+"\n"+sfz+"\n\n"+"注:由API提供 与林枫本人没关系");
       }
       if (quntext.equals("随机身份证图片"))
       {
//       String sfztp=get("http://101.34.11.25/a1apapi/sfz/");
//       sendPic(qun,"","http://101.34.11.25/a1apapi/sfz/");
       sendMsg(qun,"",lfmm+"\n"+"注:由API提供 与林枫本人没关系"+"[PicUrl="+"http://101.34.11.25/a1apapi/sfz/"+"]");
       }
       if(quntext.equals("随机网易小号"))
       {
       String wyxh=get("http://sszs.wxsszs.cn/api/jk/wyy.php");
       sendMsg(qun,"",lfmm+"\n"+wyxh);
       }
       }
       }