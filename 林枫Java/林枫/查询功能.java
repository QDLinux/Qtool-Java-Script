public void 查询功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
            if ("4".equals(getString(qun, "查Q")))
        {
        if (quntext.startsWith("查Q")||quntext.startsWith("查q")) 
        {
        String st = quntext.substring(2); 
        if (st.equals(""))
        {
        sendMsg(qun,"",lfmm+"\n"+"没有QQ号你查个🐔？");
        return;
        }else{
        if (st.equals(lf)||st.equals(lfxh))
         {
         sendMsg(qun, "",lfmm+"\n"+"[AtQQ="+uin+"]"+"林枫的QQ你也敢查？");
         Toast("林枫提示：此QQ是查询黑名单");
         return;
         }else{
        String cb=get("https://zy.xywlapi.cc/qqapi?qq="+st);
        JSONObject json= new JSONObject(cb);        
        int cxjg =json.get("status");
//        int sb=500;
        if (cxjg==200)
        {
        String cb=get("https://zy.xywlapi.cc/qqapi?qq="+st);
        JSONObject json= new JSONObject(cb);
        String dh =json.get("phone");
        String dz =json.get("phonediqu");
        sendMsg(qun, "",lfmm+"\n"+"QQ:"+st+"\n"+"电话:"+dh+"\n"+"归属地:"+dz); 
        return;
        }else{
        sendMsg(qun,"",lfmm+"\n"+"QQ:"+st+"\n"+"没有找到");
        }
        }
        }
        }
        }
        }