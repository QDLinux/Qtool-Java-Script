public void 文案功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
       if ("5".equals(getString(qun, "文案功能")))
        {
        if (quntext.equals("一言"))
        {
        String yy=get("https://v1.hitokoto.cn/?encode=text");
        sendMsg(qun,"",lfmm+"\n"+yy);
        }
        if (quntext.equals("舔狗文案"))
        {
         String tgwa=get("https://api.anyfan.top/hitokoto/?type=dog");
         sendMsg(qun,"",lfmm+"\n"+tgwa);
         }
        if (quntext.equals("伤感文案"))
        {
         String sgwa=get("https://v1.hitokoto.cn/?c=f&encode=text");
         sendMsg(qun,"",lfmm+"\n"+sgwa);
         }
        if (quntext.equals("毒鸡汤"))
        {
         String djt=get("https://api.anyfan.top/hitokoto/?type=jitang");
         sendMsg(qun,"",lfmm+"\n"+djt); 
        }
        if (quntext.equals("骚话"))
        {
        String sh=get("https://api.vvhan.com/api/sao");
        sendMsg(qun,"",lfmm+"\n"+sh);
        }
        if("动漫语录".equals(quntext))
        {
       String nb=get("https://api.andeer.top/API/comic1.php");
       String nbb=nb.replaceAll(" ","");
       JSONObject json1 = new JSONObject(nbb);
       String nbbb=json1.get("content");
       sendMsg(qun,"",lfmm+"\n"+nbbb);
        }

        if("励志语录".equals(quntext)){
        String nb=get("https://api.andeer.top/API/lizhi.php");
        String nbb=nb.replaceAll(" ","");
        JSONObject json1 = new JSONObject(nbb);
        String nbbb=json1.get("content");
        sendMsg(qun,"",lfmm+"\n"+nbbb);
        }

        if("早安语录".equals(quntext)){
        String nb=get("https://api.andeer.top/API/morning.php");
        String nbb=nb.replaceAll(" ","");
        JSONObject json1 = new JSONObject(nbb);
        String nbbb=json1.get("data");
        sendMsg(qun,"",lfmm+"\n"+nbbb);
        }

        if("晚安语录".equals(quntext)){
        String nb=get("https://api.andeer.top/API/night.php");
        String nbb=nb.replaceAll(" ","");
        JSONObject json1 = new JSONObject(nbb);
        String nbbb=json1.get("data");
        sendMsg(qun,"",lfmm+"\n"+nbbb);
        }

        if("失恋语录".equals(quntext)){
        String nb=get("https://api.andeer.top/API/shilian.php");
        sendMsg(qun,"",lfmm+"\n"+nb);
        }

        if("文学语录".equals(quntext)){
        String nb=get("https://api.andeer.top/API/wenxue.php");
        String nbb=nb.replaceAll(" ","");
        JSONObject json1 = new JSONObject(nbb);
        String nbbb=json1.get("content");
        sendMsg(qun,"",lfmm+"\n"+nbbb);
        }

        if("土味情话".equals(quntext)){
        String nb=get("https://api.andeer.top/API/twqh.php");
        String nbb=nb.replaceAll(" ","");
        JSONObject json1 = new JSONObject(nbb);
        String nbbb=json1.get("content");
        sendMsg(qun,"",lfmm+"\n"+nbbb);
        }

        if("土豆情话".equals(quntext)){
        String nb=get("http://dsyai.club/api/qinghua.php");
        sendMsg(qun,"",lfmm+"\n"+nb);
        }

        if("随机骚话".equals(quntext)){
        String nb=get("http://dsyai.club/api/saohua.php");
        sendMsg(qun,"",lfmm+"\n"+nb);
        }

        if("趣味笑话".equals(quntext)){
        String nb=get("http://dsyai.club/api/qwxh.php");
        sendMsg(qun,"",lfmm+"\n"+nb);
        }

        if("长型伤感文案".equals(quntext)){
        String nb=get("http://dsyai.club/api/sgyl.php");
        sendMsg(qun,"",lfmm+"\n"+nb);
        } 
        if (quntext.equals("骂人语录"))
        {
        String mr=get("http://api.wxsszs.cn/api/Ridicule.php?msg=5");
        sendMsg(qun,"",lfmm+"\n"+mr);
        }
        if (quntext.equals("网易云热评"))
        {
        String rp=get("https://free.wqwlkj.cn/wqwlapi/wyy_rp.php?type=text");
        sendMsg(qun,"",lfmm+"\n"+rp);
        }
        if(quntext.equals("十宗罪语录"))
        {
        String szz=get("http://api.yujn.cn/api/szz.php?");
        sendMsg(qun,"",lfmm+"\n"+szz);
        }
        if(quntext.equals("涩涩语录"))
        {
        String ssyl=get("http://api.yujn.cn/api/text_wu.php?");
        sendMsg(qun,"",lfmm+"\n"+ssyl);
        }
        }
        }