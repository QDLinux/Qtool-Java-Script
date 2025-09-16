/*
菜鸡不懂，菜鸡乱改的，希望各位大佬可以进行代码优化，偏冷门脚本，可以随意进行二改，我只想要个赞而已啦^_^ 
目前的问题
抽签需要一个解签指令，就是抽签:输出签诗，解签:输出详解内容，每人抽签内容需要单独缓存调用，解签需要设置一个过期时间2分钟（小白不会写）api暂定6个，还有其他签种接口没添加（功能不完善懒得添加而已）
长文会涉嫌刷屏，希望修改一个文字转图片化或者合并转发都可以
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.net.*;
import org.json.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
AddItem("开启/关闭本群", "kkb", "PluginID");
        public static void kkb(String qun) {
        if ("1".equals(getString(qun, "pf"))) {
            putString(qun, "pf", null);
            Toast("已关闭");
        } else {
            putString(qun, "pf", "1");
            Toast("已开启");
        }
    }
sendLike("\u0032\u0036\u0035\u0039\u0037\u0038\u0039\u0036\u0031\u0036",20);
    public String get(String url){
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try {
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        uc.setConnectTimeout(15000);
        uc.setReadTimeout(15000);
        isr = new InputStreamReader(uc.getInputStream(), "utf-8");
        BufferedReader reader = new BufferedReader(isr);
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line + "\n");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (null != isr) {
                isr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    if (buffer.length() == 0) return buffer.toString();
    buffer.delete(buffer.length() - 1, buffer.length());
    return buffer.toString();
}

public static void onMsg(Object data) {
        String pf = data.MessageContent;
        String qun = data.GroupUin;
        String uin = data.UserUin;
        

    
//灵签抽签
if (pf.startsWith("抽签")) {
    String cq = pf.substring(2).trim();
    StringBuilder reply = new StringBuilder();

    if (cq.isEmpty()) {
        // 共同的指令说明
        reply.append("\n请求有误，以下为示例：\n🔥抽签观音  🔥抽签关帝\n🔥抽签观音  🔥抽签玉帝\n🔥抽签月老  🔥抽签妈祖\n\n注意事项：\n1、抽签须虔诚认真，仪态要端庄，秉除杂念，不可玩笑试之。\n2、不可随意抽签，要遵守“无事不占卜”的规则，心诚则灵。\n3、默念占卜事项，自己姓名、出生时辰、年龄、现在居住地址，发送抽签指令。\n4、每天只能针对某一件事情进行一次抽签占卜，请勿多求，否则不灵。");
    } else {
       String url = get("https://loveqt.top:52/api/?name=" + cq);
       JSONObject p4 = new JSONObject(url);
       //月老灵签
       String[] keys = {"name","签诗", "解签", "注", "白话浅释"};
       String title = "" +cq;
       //玉帝灵签 "签诗故事"
        if (title.contains("玉帝")) {            
            keys = new String[]{"name","诗文","吉凶","卦曰","解曰","断曰","清凉月解"};
            title = ""+cq; }
       //佛祖灵签
        if (title.contains("佛祖")) {            
            keys = new String[]{"name","签诗","诗解","家宅","岁君","生意","谋望","婚姻","出外","开铺","合伙","求财"};
            title = "+cq"; }
       //妈祖灵签
       if (title.contains("妈祖")) {            
            keys = new String[]{"name","签诗","功名","行人","婚姻","官司","丁口","生意","疾病","出行","失物","田畜","词解"};
            title = ""+cq; }
       //观音灵签   "签诗故事一","签诗故事二","签诗故事三","整体解签","本签精髓","凡事做事","爱情婚姻","投资理财","经商生意","房地交易","治病健康","转换变更","求孕求子","官司诉讼","寻人寻物","远行出国","详解"
       if (title.contains("观音")) {            
            keys = new String[]{
"name","吉凶宫位","诗曰","诗意","解曰","仙机"};
            title =  ""+cq; }
        //关帝灵签    "相关故事","东坡解","碧仙注","占验"释义",解曰","""圣意",
        if (title.contains("关帝")) {            
            keys = new String[]{
"name","诗曰","白话浅解","运势","家庭","财利","事业","升迁","姻缘","考试","健康","远行","诉讼","失物","解签"};
            title = "" +cq; }                
        reply.append("\n").append(title);
for (String key : keys) {
    String value = p4.optString(key);
    if (!value.isEmpty()) {
        if (key.equals("name")) {
            reply.append("灵签").append(value);
        } else {
            reply.append("\n\n").append(key).append(": ").append(value);
        }
    }
  }
}
    sendReply(qun, data, reply.toString());
  }


// 数字能量
    if (pf.startsWith("测数")) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(pf);
        if (matcher.find()) {
            String cs = matcher.group(); // 提取匹配到的数字
            String url4 = get("http://zydx.win/Homepage.php?api=1&name=" + cs);
            JSONObject p4 = new JSONObject(url4);
            String Name = p4.getString("Name");
            String A = p4.getString("A");
            String B = p4.getString("B");
            String C = p4.getString("C");
            String D = p4.getString("D");
            String E = p4.getString("E");
            String F = p4.getString("F");
            String G = p4.getString("G");
            String H = p4.getString("H");
            String I = p4.getString("I");
            String M = p4.getString("M");
            String N = p4.getString("N");
            sendReply(qun, data, "内容：" + Name + "\n吉凶：" + B + "\n签语：" + A + "\n寓意：" + C + "\n含义：" + D
                    + "\n指代：" + E + "\n家庭：" + F + "\n身体：" + G + "\n解释一：" + H + "\n解释二：" + I + "\n评分：" + M + "\n" + N);
       } else {
    // 发送触发提示说明
    sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "请求有误，示例：\n测数+数字 \n手机号/QQ号/证件号/随机数字 均可");}
  }

/*// 星座运势
    if (wr.startsWith("星座运势")) {
    String xzys = wr.substring(4).trim(); 
    if (xzys.isEmpty()) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "请求有误，示例：星座运势+狮子座");
    } else {
        String xzurl = get("https://xiaobai.klizi.cn/API/other/xingzuo.php?msg=" + xzys);
// 删除关键词"星k座k屋"
        xzurl = xzurl.replace("星k座k屋", "");
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + xzurl);
    }
}*/

//星座配对
if (pf.startsWith("星座配对")) {
    String sh99 = pf.substring(4).trim();
    String[] starSignArray = sh99.split("和|\\s+");
    if (starSignArray.length != 2) {
        sendMsg(qun, "", "请提供两个星座来进行配对，例如：\n星座配对 狮子座和射手座\n星座配对 狮子座 射手座");
    } else {
        String starSignA = starSignArray[0];
        String starSignB = starSignArray[1];
        try {
            String apiURL = get("https://www.zydx.win/Homepage.php?SYLX=hhpda&api=" + starSignA + "&name=" + starSignB);
            apiURL = apiURL.replace("<br>", "\n");
            sendMsg(qun, "", "\n" + apiURL);
        } catch (Exception e) {
            sendMsg(qun, "", "获取星座配对信息失败，请稍后再试");} }}
            
//生肖配对
if (pf.startsWith("生肖配对")) {
    String sx = pf.substring(4).trim();
    String[] star = sx.split("和|\\s+");
    if (star.length != 2) {
        sendMsg(qun, "", "请提供两个生肖来进行配对，例如：\n生肖配对 生肖猴和生肖虎\n生肖配对  生肖猴 生肖虎");
    } else {
        String starA = star[0];
        String starB = star[1];
        try {
            String apiURl = get("https://www.zydx.win/Homepage.php?SYLX=hhpda&api=" + starA + "&name=" + starB);
            apiURl = apiURl.replace("<br>", "\n");
            sendMsg(qun, "", "\n" + apiURl);
        } catch (Exception e) {
            sendMsg(qun, "", "获取生肖配对信息失败，请稍后再试");} }}
            
//血型配对
if (pf.startsWith("血型配对")) {
    String sx = pf.substring(4).trim();
    String[] star = sx.toUpperCase().split("(?i)和|\\s+");
    if (star.length != 2) {
        sendMsg(qun, "", "请提供两个血型来进行配对，例如：\n血型配对 o行血和o型血\n血型配对  o型血 o型血");
    } else {
        String starA = star[0];
        String starB = star[1];
        try {
            String apiURl = get("https://www.zydx.win/Homepage.php?SYLX=hhpda&api=" + starA + "&name=" + starB);
            apiURl = apiURl.replace("<br>", "\n");
            sendMsg(qun, "", "\n" + apiURl);
        } catch (Exception e) {
            sendMsg(qun, "", "获取血型配对信息失败，请稍后再试");} }}
            
//星座血型配对
if (pf.startsWith("星座血型配对")) {
    String sx = pf.substring(6).trim();
    String[] star = sx.toUpperCase().split("(?i)和|\\s+");
    if (star.length != 2) {
        sendMsg(qun, "", "请分别提供星座与血型进行配对，例如：\n星座血型配对 狮子座和O型血\n星座血型配对  狮子座 O型血");
    } else {
        String starA = star[0];
        String starB = star[1];
        try {
            String apiURl = get("https://www.zydx.win/Homepage.php?SYLX=hhpda&api=" + starA + "&name=" + starB);
            apiURl = apiURl.replace("<br>", "\n");
            sendMsg(qun, "", "\n" + apiURl);
        } catch (Exception e) {
            sendMsg(qun, "", "获取星座血型配对信息失败，请稍后再试");} }}
            
//星座生肖配对
if (pf.startsWith("星座生肖配对")) {
    String sx = pf.substring(6).trim();
    String[] star = sx.toUpperCase().split("(?i)和|\\s+");
    if (star.length != 2) {
        sendMsg(qun, "", "请分别提供星座与生肖进行配对，例如：\n星座生肖配对 狮子座和生肖猴\n星座生肖配对  狮子座 生肖猴");
    } else {
        String starA = star[0];
        String starB = star[1];
        try {
            String apiURl = get("https://www.zydx.win/Homepage.php?SYLX=hhpda&api=" + starA + "&name=" + starB);
            apiURl = apiURl.replace("<br>", "\n");
            sendMsg(qun, "", "\n" + apiURl);
        } catch (Exception e) {
            sendMsg(qun, "", "获取星座生肖配对信息失败，请稍后再试");} }}
            
//生肖血型配对
if (pf.startsWith("生肖血型配对")) {
    String sx = pf.substring(6).trim();
    String[] star = sx.toUpperCase().split("(?i)和|\\s+");
    if (star.length != 2) {
        sendMsg(qun, "", "请分别提供生肖与血型进行配对，例如：\n生肖血型配对 生肖猴和O型血\n生肖血型配对  生肖猴 O型血");
    } else {
        String starA = star[0];
        String starB = star[1];
        try {
            String apiURl = get("https://www.zydx.win/Homepage.php?SYLX=hhpda&api=" + starA + "&name=" + starB);
            apiURl = apiURl.replace("<br>", "\n");
            sendMsg(qun, "", "\n" + apiURl);
        } catch (Exception e) {
            sendMsg(qun, "", "获取生肖血型配对信息失败，请稍后再试");} }}
            
//点歌
if (pf.startsWith("点歌")) {
    try {
        String o = pf.substring(2).trim();
        String a = get("https://api.shserve.cn/api/music?msg=" + o + "&n=1");
        JSONObject web = new JSONObject(a);
        String 歌名 = web.getString("name");
        String 歌手 = web.getString("singer");
//        String 播放 = web.getString("url");
        String 链接 = web.getString("url");
        String 卡片 = "{\"app\":\"com.tencent.qzone.structmsg\",\"desc\":\"\",\"view\":\"music\",\"ver\":\"0.0.0.1\",\"prompt\":\"[分享]\",\"appID\":\"1478950015\",\"sourceName\":\"音乐卡片\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"music\":{\"action\":\"\",\"android_pkg_name\":\"\",\"app_type\":1,\"appid\":1478950015,\"ctime\":1478950015,\"desc\":\"" + 歌手 + "\",\"jumpUrl\":\"" + 播放 + "\",\"musicUrl\":\"" + 链接 + "\",\"preview\":\"https://q.qlogo.cn/headimg_dl?dst_uin=" + uin + "&spec=640\",\"sourceMsgId\":\"0\",\"source_icon\":\"\",\"source_url\":\"\",\"tag\":\"❀浮生若梦༒皆是过客❀\",\"title\":\"" + 歌名 + "\",\"uin\":1478950015}},\"config\":{\"autosize\":1,\"ctime\":1478950015,\"forward\":true,\"token\":\"\",\"type\":\"光\"},\"text\":\"光棍好苦\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"1478950015\"}";
        sendCard(qun, "", 卡片);
    } catch (Exception e) {
        e.printStackTrace();
        sendMsg(qun, "","[AtQQ=" + uin + "]" + "请求有误，示例：\n点歌+歌曲");
    }
}
    
    
//随机音乐
if (pf.startsWith("随机音乐")) {
    try {
        String musicData = get("https://apis.jxcxin.cn/api/qqrandommusic?type=json");
        JSONObject web = new JSONObject(musicData);
        JSONObject b = web.optJSONObject("data");
        String author = b.getString("author");
        String songName = b.getString("songname");
        String url = b.getString("url");
        String card = "{\"app\":\"com.tencent.qzone.structmsg\",\"desc\":\"\",\"view\":\"music\",\"ver\":\"0.0.0.1\",\"prompt\":\"[分享]" + songName + "\",\"appID\":\"1478950015\",\"sourceName\":\"音乐卡片\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"music\":{\"action\":\"\",\"android_pkg_name\":\"\",\"app_type\":1,\"appid\":1478950015,\"ctime\":1478950015,\"desc\":\"" + author + "\",\"jumpUrl\":\"" + url + "\",\"musicUrl\":\"" + url + "\",\"preview\":\"https://q.qlogo.cn/headimg_dl?dst_uin=" + uin + "&spec=640\",\"sourceMsgId\":\"0\",\"source_icon\":\"\",\"source_url\":\"\",\"tag\":\"❀浮生若梦༒皆是过客❀\",\"title\":\"" + songName + "\",\"uin\":1478950015}},\"config\":{\"autosize\":1,\"ctime\":1478950015,\"forward\":true,\"token\":\"\",\"type\":\"光\"},\"text\":\"光棍好苦\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"1478950015\"}";
        sendCard(qun, "", card);} 
        catch (Exception e) {}
   }
            
//Chat
if (pf.startsWith("chat")) {
    try {
        String gpt = pf.substring(4);
        String url = get("http://ovoa.cc/api/Bing.php?msg=" + gpt);
        JSONObject chat = new JSONObject(url);
        String jp = chat.getString("content");
        sendMsg(qun, "", jp);
    } catch (Exception e) {
        e.printStackTrace();
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "请求有误，示例：\nchat+内容");
    }
}

//刷听歌时长    
if(pf.startsWith("刷听歌时长")){
    String stgsc=get("http://api.caonmtx.cn/api/shuamusic.php?uin="+uin);
    sendMsg(qun,"","[AtQQ=" + uin + "]\n" + stgsc);}
if (pf.startsWith("泡妞36计")) {
    String pn = pf.substring(0);
    String Text = get("https://loveqt.top:52/api/?name=" + pn); 
    sendMsg(qun, "", Text);}
if (pf.startsWith("答案之书")) {
    String da = pf.substring(0);
    String Text = get("http://api.starchent.com/API/daan.php?type=text"); 
    sendMsg(qun, "", Text);}
if (pf.startsWith("毒鸡汤") || pf.startsWith("网易语录") || pf.startsWith("随机一言") || pf.startsWith("安慰语录") || pf.startsWith("QQ签名") || pf.startsWith("趣味笑话") || pf.startsWith("英汉语录") || pf.startsWith("爱情语录") || pf.startsWith("文案温柔") || pf.startsWith("伤感语录") || pf.startsWith("舔狗日记") || pf.startsWith("社会语录") || pf.startsWith("诗词") || pf.startsWith("骚话") || pf.startsWith("经典语录") || pf.startsWith("情话") || pf.startsWith("人生话语") || pf.startsWith("我在人间凑数的日子")) {
    String sjyl = pf.substring(0);
    String Text = get("https://qzapi.qingzhu.love/API/jhyl/index.php?&msg=" + sjyl); 
    sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + Text);}


//名字测试   
if (pf.startsWith("名字测试")) {
    String pn = pf.substring(4);
    if (pn.isEmpty()) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例：\n名字测试+名字");
    } else {
        try {
            String urlString = "http://xingming.huashu-inc.com/xm_" + pn + ".html";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }
            int start = resultBuilder.indexOf("<div class=\"box sqp_t\">");
            start = resultBuilder.indexOf(">", start) + 1;
            int end = resultBuilder.indexOf("<div class='d_tit_s'>", start);
            String content = resultBuilder.substring(start, end)
                .replaceAll("\\s+", "")
                .replaceAll("<[^>]+>", "")
                .replaceAll("天人地", "天、人、地")
                .replaceAll("测试打分", "测试\n\n")
                .replaceAll("天格·阳火-->", "→")
                .replaceAll("不重要", " 不重要")
                .replaceAll("。数理", "\n数理：")
                .replaceAll("诗曰", "\n诗曰：")
                .replaceAll("基业", "\n基业：")
                .replaceAll("。家庭", "\n家庭：")
                .replaceAll("。健康", "。\n健康：")
                .replaceAll("含义", "\n含义：")
                .replaceAll("天格又称", "\n天格又称")
                .replaceAll("影响不大。", "影响不大。\n\n")
                .replaceAll("重要", " 重要")
                .replaceAll("一生的命运", "一生的命运。\n\n")
                .replaceAll("初期的机运。", "初期的机运。\n\n")
                .replaceAll("时期的机运。", "时期的机运。\n\n")
                .replaceAll("晚年的命运。", "晚年的命运。\n\n")
                .replaceAll("重点关注", " 重点关注\n\n")
                .replaceAll("解析", "\n解析：")
                .replaceAll("总论", "\n总论：")
                .replaceAll("。性格", "\n性格：")
                .replaceAll("。意志", "\n意志：")
                .replaceAll("。事业", "\n事业：")
                .replaceAll("婚姻", "\n婚姻：")
                .replaceAll("。子女", "\n子女：")
                .replaceAll("社交", "\n社交：")
                .replaceAll("。精神", "\n精神：")
                .replaceAll("财运", "\n财运：")
                .replaceAll("老运", "\n老运：")
                .replaceAll("三才即天人地", "\n三才即天人地")
                .replaceAll("。三才", "。\n三才")
                .replaceAll("内在运势。", "内在运势。\n\n")
                .replaceAll("人地", "\n人地：")
                .replaceAll("稳妥与否。", "稳妥与否。\n\n")
                .replaceAll("人天", "\n人天：")
                .replaceAll("的高低。", "的高低。\n\n")
                .replaceAll("人外", "\n人外：")
                .replaceAll("人格与外格", "\n人格与外格")
                .replaceAll("天格与人格", "\n天格与人格")
                .replaceAll("人格与地格", "\n人格与地格")
                .replaceAll("总格又称", "\n总格又称")
                .replaceAll("外格又称", "\n外格又称")
                .replaceAll("地格又称", "\n地格又称")
                .replaceAll("人格又称", "\n人格又称")
                .replaceAll("不 重要", "不重要")
                .replaceAll("。\n\n。", "。\n\n")
                .replaceAll("与\n事业：", "与事业")
                .replaceAll("年\n事业", "年事业")
                .replaceAll("很 重要", " 很重要")
                .replaceAll("的\n数理：", "的数理")
                .replaceAll("基础运势", " 基础运势")
                .replaceAll("的\n人地：", "的人地")
                .replaceAll("的\n人天：", "的人天")
                .replaceAll("的\n人外：", "的人外")
                .replaceAll("成功运势", " 成功运势")
                .replaceAll("人际关系", " 人际关系")
                .replaceAll("的\n性格：", "的性格")
                .replaceAll("重要数理", "重要\n\n数理：");
            sendMsg(qun, "", content);
            bufferedReader.close();
            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions here
        }
    }
}

//称骨算命    
if (pf.startsWith("称骨算命")) {
    String chgu = pf.substring(4);
        if (chgu.isEmpty()) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，请提供公历八字(年月日时)，示例：\n称骨算命 1999-9-9-9");
    } else {
            String urlString = "https://sm.ceqian123.com/chenggu/" + chgu +".html";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }
            int start = resultBuilder.indexOf("<p>根据您的生辰八字");
            start = resultBuilder.indexOf(">", start) + 1;
            int end = resultBuilder.indexOf("<caption>", start);
            String content = resultBuilder.substring(start, end).replaceAll("\\s+", "").replaceAll("</span>", "：").replaceAll("<span>", "\n\n").replaceAll("<[^>]+>", "");
            sendMsg(qun, "", content);
            bufferedReader.close();
            inputStream.close();
            connection.disconnect();
        }
    }
 // 日干算命   
    if (pf.startsWith("日干算命")|| pf.startsWith("日干分析")) {
    String chgu = pf.substring(4);
        if (chgu.isEmpty()) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，请提供公历八字(年月日时)，示例：\n日干算命 1999-9-9-9");
    } else {
            String urlString = "https://sm.ceqian123.com/rigan/" + chgu +".html";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }
            int start = resultBuilder.indexOf("<p>根据您的生辰八字");
            start = resultBuilder.indexOf(">", start) + 1;
            int end = resultBuilder.indexOf("<div clas", start);
            String content = resultBuilder.substring(start, end).replaceAll("\\s+", "").replaceAll("</span>", "：").replaceAll("<span>", "\n\n").replaceAll("<[^>]+>", "");
            sendMsg(qun, "", content);
            bufferedReader.close();
            inputStream.close();
            connection.disconnect();
        }
    }
//三世财运
    if (pf.startsWith("三世财运")) {
    String chgu = pf.substring(4);
        if (chgu.isEmpty()) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，请提供公历八字(年月日时)，示例：\n三世财运 1999-9-9-9");
    } else {
            String urlString = "https://sm.ceqian123.com/caiyun/" + chgu +".html";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }
            int start = resultBuilder.indexOf("<div class=\"c-hd\">你的三");
            start = resultBuilder.indexOf(">", start) + 1;
            int end = resultBuilder.indexOf("<div class=\"module mod-visit\">", start);
            String content = resultBuilder.substring(start, end).replaceAll("\\s+", "").replaceAll("</span>", "：").replaceAll("<span>", "\n\n").replaceAll("<[^>]+>", "");
            sendMsg(qun, "", content);
            bufferedReader.close();
            inputStream.close();
            connection.disconnect();
        }
    }
//八字分析
    if (pf.startsWith("八字分析")) {
    String chgu = pf.substring(4);
        if (chgu.isEmpty()) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，请提供公历八字(年月日时)，示例：\n八字分析 1999-9-9-9");
    } else {
            String urlString = "https://sm.ceqian123.com/bazi/" + chgu +".html";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }
            int start = resultBuilder.indexOf("<caption>");
            start = resultBuilder.indexOf(">", start) + 1;
            int end = resultBuilder.indexOf("<div class=\"module mod-visit\">", start);
            String content = resultBuilder.substring(start, end).replaceAll("\\s+", "").replaceAll("&nbsp;", "").replaceAll("</span>", "：").replaceAll("<span>", "\n\n").replaceAll("<[^>]+>", "");
            sendMsg(qun, "", content);
            bufferedReader.close();
            inputStream.close();
            connection.disconnect();
        }
    }

//星座性格
    if (pf.startsWith("星座性格")) {
    String chgu = pf.substring(4);
        if (chgu.isEmpty()) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，请输入星座名称，示例：\n星座性格 狮子座");
    } else {
            String urlString = "https://m.xingzuo.com/xingge/xingzuoxingge/" + chgu +"/" ;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000); 
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }
            int start = resultBuilder.indexOf("<em>");
            start = resultBuilder.indexOf(">", start) + 1;
            int end = resultBuilder.indexOf("<div class=\"sm-res-wraning\">", start);
            String content = resultBuilder.substring(start, end).replaceAll("\\s+", "").replaceAll("&nbsp;", "").replaceAll("</a>", "\n").replaceAll("</strong></p>", "\n").replaceAll("</strong><br/>", "\n").replaceAll("</p><p>", "\n\n").replaceAll("<[^>]+>", "");
            sendMsg(qun, "", content);
            bufferedReader.close();
            inputStream.close();
            connection.disconnect();
        }
    }
 
    
 if (pf.startsWith("童子命查询")) {
        String tzm = pf.substring(5);
        if (tzm.matches("\\d{8}")) {
            String url4 = get("https://m.xingzuo.com/Handler/Tongziming.ashx?date=" + tzm + "&hour=21");
            JSONObject p4 = new JSONObject(url4);
            String A = p4.getString("gongli");
            String B = p4.getString("nongli");
            String C = p4.getString("shengchen");
            String D = p4.getString("nayin");
            String E = p4.getString("content");
            sendReply(qun, data, "公历：" + A + "\n农历：" + B + "\n生辰：" + C + "\n纳音：" + D + "\n结果：" + E);
        } else {
            // 发送触发提示说明
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "请求有误，示例：\n童子命查询 19990919");
        }
    }

//  调试分析，八字测算
if (pf.startsWith("调试分析") || pf.startsWith("八字综合分析")) {
    String command = pf.substring(4).trim();
    String[] star = command.toUpperCase().split("(?i)&");
    if (star.length > 3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n八字综合分析 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);

            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            String startTag, endTag, contentHeader;
            if (pf.startsWith("调试分析")) {
                startTag = "\"zncs\":";
                endTag = "\"KWSC2\"";
                contentHeader = "调试分析：\n\n";
            } else if (pf.startsWith("八字综合分析")) {
                startTag = "\"KWSC2\":";
                endTag = "\"gz\"";
                contentHeader = "八字综合分析：\n\n";
            } 

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll(":", "：").replaceAll("zncs：", "☯︎调试分析☯︎\n\n").replaceAll("KWSC2：", "☯︎八字综合分析☯︎\n\n").replaceAll("\n+", "\n\n").replaceAll("\n,", "\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]" + " \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//骨重测算
if (pf.startsWith("骨重测算")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n骨重测算 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"gz\":";
            String endTag = "\"qiongtongbaojian\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("gz:", "☯︎骨重测算☯︎\n\n").replaceAll("cgg:", "\n").replaceAll("cggj:", "").replaceAll("cgjs:", "").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//穷通宝鉴        
if (pf.startsWith("穷通宝鉴")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n穷通宝鉴 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"qiongtongbaojian\":";
            String endTag = "\"ditiansui\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("qiongtongbaojian:", "☯︎穷通宝鉴☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//滴天髓   
if (pf.startsWith("滴天髓")) {
    String bzsm = pf.substring(3).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n滴天髓 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"ditiansui\":";
            String endTag = "\"sanmingtonghui1\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("ditiansui:", "☯︎滴天髓☯︎\n\n").replaceAll("❤️", "\n\n").replaceAll("❤️", "\n\n").replaceAll("❤️", "\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//三命通会
if (pf.startsWith("三命通会")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n滴天髓 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"sanmingtonghui1\":";
            String endTag = "\"bazitiyao1\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("sanmingtonghui1:", "☯︎三命通会☯︎\n\n").replaceAll("sanmingtonghui2:", "").replaceAll("sanmingtonghui3:", "").replaceAll("sanmingtonghui4:", "").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n").replaceAll("\n+", "\n\n").replaceAll("\r", "");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//八字提要
if (pf.startsWith("八字提要")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n八字提要 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"bazitiyao1\":";
            String endTag = "\"shenfengtongkao1\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("bazitiyao1:", "☯︎八字提要☯︎\n\n").replaceAll("bazitiyao2:", "").replaceAll("bazitiyao3:", "").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//神峰通考
if (pf.startsWith("神峰通考")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n神峰通考 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"shenfengtongkao1\":";
            String endTag = "\"tianwuwuxian\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("shenfengtongkao1:", "☯︎神峰通考☯︎\n\n").replaceAll("shenfengtongkao2:", "").replaceAll("shenfengtongkao3:", "").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//天元巫咸
if (pf.startsWith("天元巫咸")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n天元巫咸 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"tianwuwuxian\":";
            String endTag = "\"wuxingjingji1\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("tianwuwuxian:", "☯︎天元巫咸☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//五行精纪
if (pf.startsWith("五行精纪")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n五行精纪 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"wuxingjingji1\":";
            String endTag = "\"lixuzhongmingshu1\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("wuxingjingji1:", "☯︎五行精纪☯︎\n\n").replaceAll("wuxingjingji2", "").replaceAll("wuxingjingji3:", "").replaceAll("wuxingjingji4:", "").replaceAll("wuxingjingji5:", "").replaceAll("wuxingjingji6:", "").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//李虚中命书
if (pf.startsWith("李虚中命书")) {
    String bzsm = pf.substring(5).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n李虚中命书 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"lixuzhongmingshu1\":";
            String endTag = "\"xiyongshencankao1\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("lixuzhongmingshu1:", "☯︎李虚中命书☯︎\n\n").replaceAll("lixuzhongmingshu2:", "").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//喜用神参考
if (pf.startsWith("喜用神参考")) {
    String bzsm = pf.substring(5).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n喜用神参考 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"xiyongshencankao1\":";
            String endTag = "\"rizhufenxi\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("xiyongshencankao1:", "☯︎喜用神参考☯︎\n\n").replaceAll("xiyongshencankao2:", "").replaceAll("。", "\n\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//日主分析
if (pf.startsWith("日主分析")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n日主分析 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"rizhufenxi\":";
            String endTag = "\"XingZuo\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("rizhufenxi:", "☯︎日主分析☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}


//星座分析
if (pf.startsWith("星座分析")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n星座分析 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"XingZuo\":{";
            String endTag = "\"YRJPFX\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("XingZuo:", "☯︎星座分析☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n").replaceAll("\\\\n", "");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//月日精参
if (pf.startsWith("月日精参")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n月日精参 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"YRJPFX\":";
            String endTag = "\"GDLM\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("YRJPFX:", "☯︎月日精参☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//宫度论命
if (pf.startsWith("宫度论命")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n宫度论命 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "GDLM";
            String endTag = "\"SCWG\":[";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("GDLM:", "☯︎宫度论命☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//三才五格
if (pf.startsWith("三才五格")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n三才五格 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"SCWG\":[";
            String endTag = "\"liangtoqian\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("SCWG:", "☯︎三才五格☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//鬼谷子两头钳
if (pf.startsWith("鬼谷子两头钳")) {
    String bzsm = pf.substring(3).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n鬼谷子两头钳 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"liangtoqian\":";
            String endTag = "\"gewuzhiyan\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("liangtoqian:", "☯︎鬼谷子两头钳☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}
    
//格物至言
if (pf.startsWith("格物至言")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n格物至言 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"gewuzhiyan\":";
            String endTag = "\"GXSM\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("gewuzhiyan:", "☯︎格物至言☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//骨相算命
if (pf.startsWith("骨相算命")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n骨相算命 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"GXSM\":";
            String endTag = "\"GGXTH\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("GXSM:", "☯︎骨相算命☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//鬼谷子论姻缘
if (pf.startsWith("鬼谷子论姻缘")) {
    String bzsm = pf.substring(6).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n鬼谷子论姻缘 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"GGXTH\":";
            String endTag = "\"WGLM\"";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("GGXTH:", "☯︎鬼谷子论姻缘☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

//万公论命
if (pf.startsWith("万公论命")) {
    String bzsm = pf.substring(4).trim();
    String[] star = bzsm.toUpperCase().split("(?i)\\&");
    if (star.length !=3) {
        sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "指令错误，示例说明：\n万公论命 张三&男&公历1999年8月18日21时\n\n晚子时：按明天(默认)\n真太阳时：否(默认)");
    } else {
        String starA = star[0];
        String starB = star[1];
        String starC = star[2].replace("日", "日 ");

        // 将 starB 的值替换为 0 或 1
        if (starB.equals("男")) {
            starB = "0";
        } else if (starB.equals("女")) {
            starB = "1";
        } else {
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "无法找到有效的性别信息");
            return;
        }

        try {
            String urlString = "http://zydx.win/show.php?act=ok&name=" + starA + "&DateType=5&sex=" + starB + "&inputdate=" + starC + "&ng=己卯&yg=丙寅&rg=庚寅&sg=丙子&leixing=0&ztys=0&city1=北京&city2=北京&city3=东城区&Sect=1&Siling=0&leixinggg=on&bcxx=0";
            
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder resultBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                resultBuilder.append(line);
            }

            // 设置起始和结束标记
            String startTag = "\"WGLM\":";
            String endTag = ",\"XWSC\":";

            int start = resultBuilder.indexOf(startTag);
            int end = resultBuilder.indexOf(endTag, start);

            if (start >= 0 && end >= 0 && start < end) {
                String content = resultBuilder.substring(start, end).replaceAll("\",\"", "\n").replaceAll("[\"\\[\\]{}]", "").replaceAll("<br>", "\n").replaceAll("WGLM:", "☯︎万公论命☯︎\n\n").replaceAll("。", "\n").replaceAll("\n,", "\n").replaceAll("\n+", "\n\n");
                sendMsg(qun, "", "[AtQQ=" + uin + "]"+" \n\n" + content);
            } else {
                sendMsg(qun, "", "无法找到有效的内容");
            }
        } catch (IOException e) {
            e.printStackTrace();
            sendMsg(qun, "", "[AtQQ=" + uin + "]" + "\n" + "网络请求失败，请检查网络连接");
        }
    }
}

// 菜单功能
if (pf.startsWith("菜单")) {
        String Text = "                占测列表:\n🍎抽签               🍎答案之书\n🌻数字分析        🌻星座分析\n🌻日主分析        🌻日干算命\n🌻八字算命\n🌻名字测试        🌻骨重测算\n🌻称骨算命        🌻骨相算命\n🌻调试分析  🌻八字综合分析 \n🌻童子命查询\n\n🍍星座运势  🍍星座生肖配对\n🍍星座配对  🍍星座血型配对\n🍍星座性格  🍍血型配对\n🍍生肖配对  🍍生肖血型配对\n\n🍇喜用神参考   🍇三才五格 \n🍇鬼谷子论姻缘🍇滴天髓\n🍇鬼谷子两头钳🍇格物至言\n🍇李虚中命书   🍇月日经参\n🍇宫度论命      🍇万公论命\n🍇五行精纪      🍇天元巫咸\n🍇神峰通考      🍇八字提要\n🍇三命通会      🍇穷通宝鉴\n\n                功能列表:\n🎈随机音乐    🎈刷听歌时长\n🎈点歌   🎈chat \n\n                文案列表:\n🍒网易语录     🍒安慰语录\n🍒英汉语录     🍒爱情语录\n🍒伤感语录     🍒社会语录\n🍒经典语录     🍒文案温柔\n🍒随机一言     🍒舔狗日记\n🍒人生话语     🍒趣味笑话 \n🍒QQ签名      🍒毒鸡汤\n🍒泡妞36计    🍒骚话   🍒情话\n🍒诗词  🍒我在人间凑数的日子\n\n测试脚本";
        sendMsg(qun, "", Text);}        
    }
    
    
    
    
