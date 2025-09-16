public void API功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
      if ("15".equals(getString(qun, "API功能")))
      {
       if(quntext.equals("人口时钟"))
       {
       String rksz=get("http://api.yujn.cn/api/sjrk.php?type=text");
       sendMsg(qun,"",lfmm+"\n"+rksz+"\n");
       }
       if(quntext.equals("涩涩小说"))
       {
       String ssxs=get("http://api.yujn.cn/api/fuli.php?");
       sendMsg(qun,"",lfmm+"\n"+ssxs);
       }
       if(quntext.equals("神回复"))
       {
       String shf=get("http://api.yujn.cn/api/shf.php?");
       sendMsg(qun,"",lfmm+"\n"+shf);
       }
       if (quntext.startsWith("测名字"))
       {
       String st=quntext.substring(3);
       if (st.equals(""))
       {
       sendMsg(qun,"",lfmm+"\n"+"没名字你测个🐔？");
       return;
       }else{
       String cmz=get("http://api.ccfun.com.cn/api/Ren.php?name="+st);
       JSONObject json= new JSONObject(cmz);
       String hf =json.get("text");
       sendMsg(qun,"",lfmm+"\n"+"名字:"+st+"\n"+hf);
       }
       }
       if(quntext.equals("历史今天"))
       {
       String lsjt=get("http://ovoa.cc/api/lishi.php");
       sendMsg(qun,"",lfmm+"\n"+lsjt);
       }
/*       if (quntext.startsWith("访问"))
       {
       String st=quntext.substring(2);
       String fw=get("st");
       sendMsg(qun,"",lfmm+"\n"+fw);
       }*/
/*       if (quntext.startsWith("查成语"))
       {
       String st=quntext.substring(3);
       String ccy =get("http://api.yujn.cn/api/idiom.php?msg="+st+"&b=1");
       sendMsg(qun,"",lfmm+"\n"+cyy);
       }*/
/*       if (quntext.equals("挑战古诗"))
       {
       String gs=get("http://api.yujn.cn/api/tzgsc.php?msg=&id="+uin);
       sendMsg(qun,"",lfmm+"\n"+"作答QQ:"+uin+"\n\n"+gs+"\n"+"回复作答+序号即可作答\n回复提示即可获得提示(暂时有bug)");
       }
       if (quntext.startsWith("作答"))
       {
       String st=quntext.substring(2);
       String gs=get("http://api.yujn.cn/api/tzgsc.php?msg="+st+"&id="+uin);
       sendMsg(qun,"",lfmm+"\n"+gs);
       }
       if (quntext.equals("提示"))
       {
       String gs=get("http://api.yujn.cn/api/tzgsc.php?msg="+"提示"+"&id="+uin);
       sendMsg(qun,"",lfmm+"\n"+gs+"\n"+"暂时有bug");
       }*/
       }
       }