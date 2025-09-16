addItem("开启/关闭本聊天图片视频脚本总开关", "powerSwitch");
addItem("开启/关闭本聊天图片视频脚本他人可用开关", "powerOther");
public String get(String url)
{
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try
    {
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        uc.setConnectTimeout(10000);
        uc.setReadTimeout(10000);
        isr = new InputStreamReader(uc.getInputStream(), "utf-8");
        BufferedReader reader = new BufferedReader(isr); //缓冲
        String line;
        while((line = reader.readLine()) != null)
        {
            buffer.append(line + "\n");
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
        try
        {
            if(null != isr)
            {
                isr.close();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    if(buffer.length() == 0) return buffer.toString();
    buffer.delete(buffer.length() - 1, buffer.length());
    return buffer.toString();
}
public void onMsg(Object msg) {
    int contactType = msg.type;
    String t = msg.msg;
    String uin = msg.peerUid;
    String qq = msg.user;
    
    if ("0".equals(getString(contactType+"-"+uin, "图片视频脚本总开关")) && (qq.equals(myUin) || "0".equals(getString(contactType+"-"+uin, "图片视频脚本他人可用开关")))) {
    
  //图片类//
  
        if (t.equals("白丝")) {
            sendPic(msg.contact, "http://api.yujn.cn/api/baisi.php?"); 
        }
        if (t.equals("快手小姐姐")) {
            sendPic(msg.contact, "http://api.caonmtx.cn/api/ksxjj.php?"); 
        }
        if (t.equals("黑丝")) {
            sendPic(msg.contact, "http://api.yujn.cn/api/heisi.php?");
        }
        if(t.equals("美女")) {
            sendPic(msg.contact, "https://v2.api-m.com/api/meinvpic?return=302");
        }
        if(t.equals("女头")) {
            sendPic(msg.contact, "https://v.api.aa1.cn/api/api-tx/index.php?wpon=aosijur75fi5huyty5f");
        }   
        if(t.equals("随机壁纸")) {
            sendPic(msg.contact, "https://v2.api-m.com/api/wallpaper?return=302");
         }
        if(t.equals("动漫小姐姐")) {
            sendPic(msg.contact, "https://img.xjh.me/random_img.php?return=302");
         }
        if(t.equals("三次元")) {
            sendPic(msg.contact, "https://v2.api-m.com/api/meinvpic?return=302");
        }
        if(t.equals("二次元风景")) {
            sendPic(msg.contact, "https://api.asxe.vip/scenery.php?return=302");
        }
        if(t.equals("随机小姐姐")) {
            sendPic(msg.contact, "https://api.linhun.vip/api/Littlesister?&apiKey=45fa329fe5edc178e4dc40156e42fb77");
        }
        if(t.equals("二次元")) {
            sendPic(msg.contact, "https://v2.api-m.com/api/randomAcgPic?type=pc&return=302");
        }
        if(t.equals("诱惑图")) {
            sendPic(msg.contact, "http://dsyai.club/api/youhuotu.php?return=302");
        }
        if(t.equals("自拍")) {
            sendPic(msg.contact, "http://api.yujn.cn/api/hlx_zipai.php?");
        }
        if(t.equals("帅哥")) {
            sendPic(msg.contact, "https://api.lolimi.cn/API/boy/api.php?");
        }
        if(t.equals("看美腿")) {
            sendPic(msg.contact, "http://api.yujn.cn/api/hlx_tui.php?");
        }
        if(t.equals("原神")) {
            sendPic(msg.contact, "https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E8%87%AA%E9%80%82%E5%BA%94%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E5%8E%9F%E7%A5%9E");
        }
        if(t.equals("猫娘")) {
            sendPic(msg.contact, "https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E7%8C%AB%E5%A8%981");
        }
        if(t.equals("少女写真")) {
            sendPic(msg.contact, "https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E5%B0%91%E5%A5%B3%E5%86%99%E7%9C%9F1");
        }
        if(t.equals("明日方舟")) {
            sendPic(msg.contact, "https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E6%98%8E%E6%97%A5%E6%96%B9%E8%88%9F1");
        }
        if(t.equals("随机赛马娘")) {
            sendPic(msg.contact, "https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E8%87%AA%E9%80%82%E5%BA%94%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E8%B5%9B%E9%A9%AC%E5%A8%98");
        }
        if(t.equals("进击的巨人")) {
            sendPic(msg.contact, "https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E8%87%AA%E9%80%82%E5%BA%94%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E8%BF%9B%E5%87%BB%E7%9A%84%E5%B7%A8%E4%BA%BA");
        }
        if(t.equals("少女前线")) {
            sendPic(msg.contact, "https://api.r10086.com/%E6%A8%B1%E9%81%93%E9%9A%8F%E6%9C%BA%E5%9B%BE%E7%89%87api%E6%8E%A5%E5%8F%A3.php?%E5%9B%BE%E7%89%87%E7%B3%BB%E5%88%97=%E5%B0%91%E5%A5%B3%E5%89%8D%E7%BA%BF1");
        }
        if(t.equals("抖音美女")) {
            sendPic(msg.contact, "https://jkapi.com/api/dymm_img?&apiKey=9e7215e01d0584a1dfad6c5cda01d782");
        }
        if(t.equals("快手美女")) {
            sendPic(msg.contact, "http://api.caonmtx.cn/api/ksxjj.php?");
        }
        if(t.equals("你的名字")) {
            sendPic(msg.contact, "https://api.yujn.cn/api/ndmz.php?");
        }
        if(t.equals("随机鲜花")) {
            sendPic(msg.contact, "https://api.yujn.cn/api/xianhua.php?");
        }
        if(t.equals("夕阳图")) {
            sendPic(msg.contact, "https://api.yujn.cn/api/xiyang.php?");
        }
        if(t.equals("蛇姐图片")) {
            sendPic(msg.contact, "https://api.yujn.cn/api/she.php?");
        }
        if(t.equals("jk小姐姐")) {
            sendPic(msg.contact, "https://api.yujn.cn/api/jk.php??");
        }
        if(t.equals("原神cos")) {
            sendPic(msg.contact, "https://api.yujn.cn/api/yscos.php??");
        }
        if(t.equals("随机女生")) {
            sendPic(msg.contact, "https://api.yujn.cn/api/sjvs.php?");
        }
        if(t.equals("萌宠图片")) {
            sendPic(msg.contact, "https://api.yujn.cn/api/mc.php??");
        }
        if(t.equals("猫羽雫")) {
            sendPic(msg.contact, "http://api.liangx.link/API/myn.php?");
        }
        
  //视频类//
        if(t.equals("美女视频")) {
            sendVideo(msg.contact, "https://api.linhun.vip/api/Littlesistervideo?&apiKey=bd37b1c1f6dc27db1fea40aa82972923");
        }
        if(t.equals("小姐姐视频")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/zzxjj.php?type=video");
        }
        if(t.equals("小姐姐视频2")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/xjj.php?type=video");  
        }
        if(t.equals("翻唱视频")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/ks_fc.php?");
        }
        if(t.equals("懒洋洋翻唱")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/lyy.php?");
        }
        if(t.equals("吊带视频")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/diaodai.php?");
        }
        if(t.equals("清纯视频")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/qingchun.php?");
        }
        if(t.equals("小哥哥视频")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/xgg.php?");
        }
        if(t.equals("变装视频")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/ksbianzhuang.php?");
        }
        if(t.equals("美女玉足")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/jpmt.php?");
        }
        if(t.equals("JK视频")) {
            sendVideo(msg.contact, "https://api.yujn.cn/api/jksp.php?");
        }
        if(t.equals("铁岭刘辉商店")) {
            sendVideo(msg.contact, "http://api.caonmtx.cn/api/ksliuhui.php?");
        }
        if(t.equals("热舞")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/rewu.php?type=video");
        }
        if(t.equals("汉服系列")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/hanfu.php?type=video");
        } 
        if(t.equals("漫画芋")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/manhuay.php?type=video");
        } 
        if(t.equals("小新翻唱")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/xiaoxin.php?type=video");
        }
        if(t.equals("随机萝莉")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/luoli.php?type=video");
        }
        if(t.equals("双倍快乐")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/sbkl.php?type=video");
        }
        if(t.equals("纯情高中")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/nvgao.php?type=video");
        }
        if(t.equals("鞠婧祎视频")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/jjy.php?type=video");
        }
        if(t.equals("周杰伦电台")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/jay.php?type=video");
       }
        if(t.equals("穿搭系列")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/chuanda.php?type=video");
       }
        if(t.equals("丝滑舞蹈")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/shwd.php?type=video");
       }
        if(t.equals("完美身材")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/wmsc.php?type=video");
       }
        if(t.equals("蛇姐视频")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/shejie.php?type=video");
       }
        if(t.equals("章若楠视频")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/zrn.php?type=video");
       }
        if(t.equals("萌娃视频")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/mengwa.php?type=video");
       }
        if(t.equals("慢摇系列")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/manyao.php?type=video");
       }
        if(t.equals("动漫cos")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/COS.php?type=video");
        }
        if(t.equals("你的欲梦呀")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/ndym.php?type=video");
        }
        if(t.equals("甜妹视频")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/tianmei.php?type=video");
        }
        if(t.equals("海边晚霞")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/haibian.php?");    
        }
        if(t.equals("足球混剪")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/zuqiu.php?"); 
        }
        if(t.equals("抖音潇潇")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/xiaoxiao.php?");    
        }
        if(t.equals("抖音变装")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/bianzhuang.php?");
        }
        if(t.equals("各类小姐姐")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/juhexjj.php?type=video");
        }
        if(t.equals("二次元房间")){
            sendVideo(msg.contact,"https://api.yujn.cn/api/pcfjsp.php?");
        }
         if(t.equals("西施视频")){
            sendVideo(msg.contact,"https://api.cmvip.cn/API/xishi.php?");
        }   
    //语音类//
        if(t.equals("怼人语音")) {
            sendPtt(msg.contact, "http://api.yujn.cn/api/duiren.php?");
        }
        if(t.equals("御姐撒娇")) {
            sendPtt(msg.contact, "http://api.yujn.cn/api/yujie.php?");
        }
        if(t.equals("原神KFC")) {
            sendPtt(msg.contact, "http://api.yujn.cn/api/yskfc.php?");
        }
        if(t.equals("随机骂人")) {
            sendPtt(msg.contact, "http://api.yujn.cn/api/maren.php?");
        }
        if(t.equals("随机DJ")) {
            sendPtt(msg.contact, "http://api.yujn.cn/api/dj.php?");
        }
        if(t.equals("随机网易云")) {
            sendPtt(msg.contact, "http://api.yujn.cn/api/sjwyy.php?type=mp3");
        }
        if(t.equals("随机坤坤")) {
            sendPtt(msg.contact, "http://api.yujn.cn/api/sjkunkun.php?");
        }
        if(t.equals("随机绿茶")) {
            sendPtt(msg.contact, "http://api.yujn.cn/api/lvcha.php?");
        }
        if(t.equals("随机翻唱")) {
            sendPtt(msg.contact, "https://api.yujn.cn/api/ks_fc.php?");
        }  
        
    //文案类//
        if (t.equals("绿茶语录")) {
        String response = get("http://api.yujn.cn/api/lvchayy.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("随机美句")) {
        String response = get("http://api.yujn.cn/api/wenan.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("爱情公寓")) {
        String response = get("https://api.lolimi.cn/API/aiqing/api.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("土味情话")) {
        String response = get("http://api.tangdouz.com/love.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("发病文案")) {
        String response = get("http://api.tangdouz.com/love.php?name=我&type=text?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("口吐芬芳")) {
        String response = get("https://api.lolimi.cn/API/kout/k.php?msg=3&type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("疯狂星期四")) {
        String response = get("http://api.caonmtx.cn/api/fkxqs.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("我在人间凑数")) {
        String response = get("tp://api.caonmtx.cn/api/rjcs.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("网易云语录")) {
        String response = get("http://api.caonmtx.cn/api/wyyl.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("随机一言")) {
        String response = get("http://api.caonmtx.cn/api/yiyan.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("趣味笑话")) {
        String response = get("http://api.caonmtx.cn/api/qwxh.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("随机签名")) {
        String response = get("http://api.caonmtx.cn/api/qianming.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("安慰语录")) {
        String response = get("http://api.caonmtx.cn/api/anwei.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("十宗罪语录")) {
        String response = get("http://api.caonmtx.cn/api/szz.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("动漫一言")) {
        String response = get("https://ybapi.cn/API/acgyiyan.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("保安日记")) {
        String response = get("http://api.yujn.cn/api/baoan.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("朋友圈文案")) {
        String response = get("http://api.yujn.cn/api/pyq.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("幽默对话")) {
        String response = get("http://api.yujn.cn/api/ymdh.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("生活常识")) {
        String response = get("http://api.yujn.cn/api/shcs.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("知乎热门话题")) {
        String response = get("http://api.yujn.cn/api/zhihu.php?type=text");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("新春祝福")) {
        String response = get("http://api.yujn.cn/api/zhufu.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("随机诗经")) {
        String response = get("http://api.yujn.cn/api/shijing.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("随机段子")) {
        String response = get("http://api.yujn.cn/api/duanzi.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("原神语录")) {
        String response = get("http://api.yujn.cn/api/ysyl.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("伤感语录")) {
        String response = get("http://api.yujn.cn/api/sgyl.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("污语录")) {
        String response = get("http://api.yujn.cn/api/text_wu.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("毒鸡汤")) {
        String response = get("http://api.yujn.cn/api/dujitang.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
     if (t.equals("温柔语录")) {
        String response = get("http://api.yujn.cn/api/dujitang.php?");
        if (response != null) {
        sendMsg(msg.contact, response);
        }
     }
   }
}


public void powerSwitch(int type, String num, String name) {
    if ("0".equals(getString(type+"-"+num, "图片视频脚本总开关"))) {
        putString(type+"-"+num, "图片视频脚本总开关", null);
        Toast("本聊天图片视频脚本总开关已关闭");
    } else {
        putString(type+"-"+num, "图片视频脚本总开关", "0");
        Toast("本聊天图片视频脚本总开关已开启");
    }
}

public void powerOther(int type, String num, String name) {
    if ("0".equals(getString(type+"-"+num, "图片视频脚本他人可用开关"))) {
        putString(type+"-"+num, "图片视频脚本他人可用开关", null);
        Toast("本聊天图片视频脚本他人可用开关已关闭");
    } else {
        putString(type+"-"+num, "图片视频脚本他人可用开关", "0");
        Toast("本聊天图片视频脚本他人可用开关已开启");
    }
}