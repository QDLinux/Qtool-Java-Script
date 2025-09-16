public void 图片功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
    if ("6".equals(getString(qun, "图片功能")))
    {
        if (quntext.equals("COS图")||quntext.equals("cos图"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"http://pic.aaa.ski/cos.php"+"]");
        }
        if (quntext.equals("风景图"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"https://api.gmit.vip/Api/FjImg?format=image"+"]");
        }
        if (quntext.equals("汽车图"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"https://api.gmit.vip/Api/QcImg?format=image"+"]");
        }
        if (quntext.equals("二次元头像"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"https://api.yimian.xyz/img?type=head"+"]");
        }
        if (quntext.equals("滑稽表情"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"http://api.caonm.net/api/huac/h?key=2iOiHwTr6oS76KTufMw0xAWoXX"+"]");
        }
        if (quntext.equals("猫猫表情"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"http://api.caonm.net/api/chai/c?key=2iOiHwTr6oS76KTufMw0xAWoXX"+"]");
        }
        if (quntext.equals("猫娘图")||quntext.equals("猫雨雫"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"http://shanhe.kim/api/tu/mao.php"+"]");
        }
        if (quntext.equals("JK图")||quntext.equals("jk图"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"http://shanhe.kim/api/tu/jk.php"+"]");
        }
        if (quntext.equals("二次元图"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"https://imgapi.xl0408.top/index.php"+"]");
        }
        if (quntext.equals("二次元猫娘图"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E7%8C%AB%E5%A8%981"+"]");
        }
        if (quntext.equals("原神图"))
        {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E8%87%AA%E9%80%82%E5%BA%94%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E5%8E%9F%E7%A5%9E"+"]");
        }        
       if("看美腿".equals(quntext))
        {
/*       String url="http://pi.xn  7gqa009h.top/api/sjmt?type=";
       String js=get(url);
        try{
        JSONObject json = new JSONObject(js);
        String txt=lfmm+"\n"+"[PicUrl="+json.getString("pic")+"]";
        sendMsg(qun,"",txt);
        }catch(JSONException e){
        sendMsg(qun,"",e.getMessage());
        }*/
        sendMsg(qun,"",lfmm+"\n"+"接口🐔了，你看个🐔");
        }
       if(quntext.equals("看涩图"))
       {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"http://api.yujn.cn/api/sese.php?"+"]");
       }
       if(quntext.equals("诱惑图"))
       {
        sendMsg(qun,"",lfmm+"\n"+"[PicUrl="+"http://api.yujn.cn/api/yht.php?"+"]");
       }
       }
      }
      