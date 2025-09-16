
import java.util.*;
import java.lang.*;
import java.text.*;
import org.json.JSONArray;
import org.json.JSONObject;

//旧版QQ有合并发送，新版没有，看你自己能不能用合并，不能就改

//如果是分段发送，则指令为：功能1，功能2……
//如果是合并发送，直接“功能”就行了
//感谢一只戏鸢大佬提供的思路

//合并发送：2      直接发送：1
int sendtype = 1;

//设置隔多少个分一个页，合并发送不用管
int fenye = 50;





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
public static final Map tumap = new HashMap();
static {//看起来高端一点
//收录接口也很辛苦的好吗
// List 爬了=Arrays.asList(new String[]{"http://ovooa.caonm.net/API/pa/api.php?QQ=","https://yysk.yitzu.cn.qingf.top/api/xb/api/pa.php?qq="});
// String 爬=爬了.get(new Random().nextInt(爬了.size()));
// List 瞧了=Arrays.asList(new String[]{"http://xiaobapi.top/api/xb/api/kan_7.php?qq=","http://xiaobapi.top/api/xb/api/kan_2.php?qq="});
// String 瞧=瞧了.get(new Random().nextInt(瞧了.size()));
// List 气泡了=Arrays.asList(new String[]{"http://yysk.yitzu.cn.qingf.top/api/xb/api/xiang_4.php?qq=","http://yysk.yitzu.cn.qingf.top/api/xb/api/xiang_5.php?qq=","http://yysk.yitzu.cn.qingf.top/api/xb/api/xiang_6.php?qq="});
// String 气泡=气泡了.get(new Random().nextInt(气泡了.size()));
// List 猫举了=Arrays.asList(new String[]{"http://xiaobapi.top/api/xb/api/kan_10.php?qq=","https://yysk.yitzu.cn.qingf.top/api/xb/api/ju_3.php?qq="});
// String 猫举=猫举了.get(new Random().nextInt(猫举了.size()));
// List 想了=Arrays.asList(new String[]{"http://ovooa.caonm.net/API/face_thsee/?QQ=","http://yysk.yitzu.cn.qingf.top/api/xb/api/xiang_2.php?qq="});
// String 想=想了.get(new Random().nextInt(想了.size()));//两个接口不一样哦
tumap.put("看这个","https://api.xingzhige.com/API/Lookatthis/?qq=");
tumap.put("小黄","https://api.andeer.top/API/lieshou2.php?qq=");
tumap.put("日漫证","https://api.andeer.top/API/jc_badge.php?qq=");
tumap.put("高质量","https://api.andeer.top/API/gzl.php?qq=");
tumap.put("抱","https://api.xingzhige.com/API/baororo/?qq=");
tumap.put("咬","https://api.xingzhige.com/API/bite/?qq=");
tumap.put("拍","https://api.xingzhige.com/API/paigua/?qq=");
tumap.put("抓","https://api.xingzhige.com/API/grab/?qq=");
tumap.put("顶","https://api.xingzhige.com/API/dingqiu/?qq=");
tumap.put("一起笑","https://api.xingzhige.com/API/LaughTogether/?qq=");
tumap.put("搂","https://api.xingzhige.com/API/FortuneCat/?qq=");
tumap.put("摇摇","https://api.xingzhige.com/API/DanceChickenLeg/?qq=");
tumap.put("打拳","https://api.andeer.top/API/gif_beat.php?qq=");
tumap.put("捣","https://api.xingzhige.com/API/pound/?qq=");
tumap.put("丢","https://api.lolimi.cn/API/diu/api.php?QQ=");
tumap.put("爬","https://api.xingzhige.com/API/pa/?qq=");
tumap.put("冰淇淋","https://api.xingzhige.com/API/bql/?qq=");
tumap.put("舞鸡腿","https://api.xingzhige.com/API/DanceChickenLeg/?qq=");
tumap.put("牵","https://api.andeer.top/API/img_qian.php?bqq="+MyUin+"&cqq=");
tumap.put("击剑","https://api.andeer.top/API/gif_beat_j.php?bqq="+MyUin+"&cqq=");
tumap.put("坏","http://api.tangdouz.com/wz/py.php?q=");
tumap.put("需要","https://api.andeer.top/API/img_need.php?qq=");
tumap.put("我老婆","https://api.tangdouz.com/wz/wife.php?q=");
tumap.put("捶","https://api.andeer.top/API/gif_thump.php?qq=");
tumap.put("老实点","https://api.andeer.top/API/img_lsd.php?qq=");
tumap.put("羡慕","https://api.andeer.top/API/xianmu.php?qq=");
tumap.put("掀墙纸","https://api.andeer.top/API/gif_wallpaper.php?qq=");
tumap.put("胡桃咬","https://api.andeer.top/API/gif_hutao_bite.php?qq=");
tumap.put("可莉吃","https://api.andeer.top/API/gif_klee_eat.php?qq=");
tumap.put("崇拜","https://api.andeer.top/API/gif_worship.php?qq=");
tumap.put("嘎达","https://api.andeer.top/API/img_tr.php?qq=");
tumap.put("要亲亲","https://api.andeer.top/API/img_kiss_1.php?qq=");
tumap.put("宝可梦","https://api.andeer.top/API/img_pokemon.php?qq=");
tumap.put("可爱","https://api.andeer.top/API/img_cute.php?qq=");
tumap.put("蒙娜丽莎","https://api.andeer.top/API/img_mnls.php?qq=");
tumap.put("精神涣散","https://api.andeer.top/API/no_attention.php?qq=");
tumap.put("贴贴","https://api.andeer.top/API/img_kiss1.php?bqq="+MyUin+"&cqq=");
tumap.put("击剑","https://api.andeer.top/API/gif_beat_j.php?bqq="+MyUin+"&cqq=");
tumap.put("过来洗头","https://api.andeer.top/API/moca.php?bqq="+MyUin+"&cqq=");
tumap.put("正在加载","https://api.andeer.top/API/img_loading.php?qq=");
tumap.put("啾啾","https://api.lolimi.cn/API/face_kiss/?QQ=");
tumap.put("摸摸","https://api.lolimi.cn/API/face_petpet/?QQ=");
tumap.put("吃掉","https://api.lolimi.cn/API/face_bite/?QQ=");
tumap.put("听音乐","https://api.andeer.top/API/img_listen_music.php?qq=");
tumap.put("电脑屏幕","https://api.andeer.top/API/img_screen.php?qq=");

// tumap.put("瞧",瞧);
// tumap.put("气泡",气泡);
// tumap.put("猫举",猫举);
// tumap.put("想",想);
// tumap.put("需要","http://yysk.yitzu.cn.qingf.top/api/xb/api/need.php?qq=");
// tumap.put("鄙视","http://xiaobai.klizi.cn/API/ce/bishi.php?qq=");
// tumap.put("遗照","http://lkaa.top/API/yi/?QQ=");
// tumap.put("撕","https://xiaobapi.top/api/xb/api/si.php/?qq=");
// tumap.put("登记","http://bh.ayud.top/img/jh.php?qq=");
// tumap.put("背刺","https://xiaobapi.top/api/xb/api/tong.php?qq="+MyUin+"&qq2=");
// tumap.put("吞","https://bg.suol.cc/API/chi/?uin=");
// tumap.put("顶一顶","http://bg.suol.cc/API/ding/?uin=");
// tumap.put("加框","http://ovooa.caonm.net/API/head/?QQ=");
// tumap.put("小马赞","http://ovooa.caonm.net/API/zan/api.php?QQ=");
// tumap.put("丢","http://ovooa.caonm.net/API/diu/api.php?QQ=");
// tumap.put("猫猫赞","http://xiaobapi.top/api/xb/api/zan_2.php?qq=");
// tumap.put("彩遗","https://xiaobapi.top/api/xb/api/ji.php?qq=");
// tumap.put("捶","http://xiaobai.klizi.cn/API/gif/hammer.php?qq=");
// tumap.put("报时","http://xiaobai.klizi.cn/API/ce/msg.php?qq=");
// tumap.put("忘了他","https://xiaobapi.top/api/xb/api/bqb_1.php?qq=");
// tumap.put("儿子","https://xiaobapi.top/api/xb/api/bqb_2.php?qq=");
// tumap.put("拒绝","https://xiaobapi.top/api/xb/api/bqb_3.php?qq=");
// tumap.put("原谅","https://xiaobapi.top/api/xb/api/bqb_4.php?qq=");
// tumap.put("我老婆","https://xiaobapi.top/api/xb/api/bqb_5.php?qq=");
// tumap.put("女儿","https://xiaobapi.top/api/xb/api/bqb_6.php?qq=");
// tumap.put("让你","https://xiaobapi.top/api/xb/api/bqb_7.php?qq=");
// tumap.put("广告牌","https://xiaobapi.top/api/xb/api/bqb_8.php?qq=");
// tumap.put("嗨","http://xiaobapi.top/api/xb/api/bqb_9.php?qq=");
// tumap.put("黑化","http://xiaobapi.top/api/xb/api/bqb_10.php?qq=");
// tumap.put("脆弱","http://xiaobapi.top/api/xb/api/bqb_11.php?qq=");
// tumap.put("精神","http://xiaobapi.top/api/xb/api/bqb_12.php?qq=");
// tumap.put("寄","http://xiaobapi.top/api/xb/api/ji_2.php?qq=");
// tumap.put("坤坤","https://xiaobapi.top/api/xb/api/kunkun.php?qq=");
// tumap.put("处男","https://xiaobapi.top/api/xb/api/chunan.php?qq=");
// tumap.put("安妮亚","https://xiaobapi.top/api/xb/api/any.php?qq=");
// tumap.put("估价","https://xiaobapi.top/api/xb/api/qq_gujia.php?qq=");
// tumap.put("宣誓","https://xiaobapi.top/api/xb/api/xuanshi.php?qq=");
// tumap.put("洗衣机","http://xiaobapi.top/api/xb/api/xiyiji.php?qq=");
// tumap.put("单身狗","http://xiaobapi.top/api/xb/api/single_idcard.php?qq=");
// tumap.put("心碎","https://xiaobapi.top/api/xb/api/xinsuisui.php?qq=");
// tumap.put("最帅","https://xiaobapi.top/api/xb/api/zuishuai.php?qq=");
// tumap.put("嫁我","https://xiaobapi.top/api/xb/api/qiuhun.php?qq=");
// tumap.put("要这个","https://xiaobapi.top/api/xb/api/this.php?qq=");
// tumap.put("敲","https://xiaobapi.top/api/xb/api/qiao.php?qq=");
// tumap.put("okk","https://xiaobapi.top/api/xb/api/okk.php?qq=");
// tumap.put("鄙视2","https://xiaobapi.top/api/xb/api/bishi.php?qq=");
// tumap.put("勾引","https://xiaobapi.top/api/xb/api/gouyin.php?qq=");
// tumap.put("笔芯","https://xiaobapi.top/api/xb/api/bixinxin.php?qq=");
// tumap.put("偷瞄","https://xiaobapi.top/api/xb/api/toumiao.php?qq=");
// tumap.put("JOJO","http://xiaobapi.top/api/xb/api/jojo.php?qq="+MyUin+"&qq2=");
// tumap.put("比心","http://xiaobai.klizi.cn/API/ce/xin.php?qq=");
// tumap.put("踹门","https://yysk.yitzu.cn.qingf.top/api/xb/api/ti_2.php?qq=");
// tumap.put("跟我处对象","http://api.klizi.cn/API/ce/xie.php?qq=");
// tumap.put("圈钱跑路","http://xiaobai.klizi.cn/API/ce/pao.php?qq=");
// tumap.put("膜拜","http://ovooa.caonm.net/API/face_worship/?QQ=");
// tumap.put("摸","http://ovooa.caonm.net/API/face_petpet/?QQ=");
// tumap.put("幻想","http://xiaobapi.top/api/xb/api/xiang_3.php?qq=");
// tumap.put("抱着哭","https://yysk.yitzu.cn.qingf.top/api/xb/api/ku.php?qq=");
// tumap.put("什么东西","http://yysk.yitzu.cn.qingf.top/api/xb/api/peng.php?qq=");
// tumap.put("精神支柱","https://yysk.yitzu.cn.qingf.top/api/xb/api/jingshenzhizhu.php?qq=");
// tumap.put("慢慢吃","http://xiaobapi.top/api/xb/api/eat_2.php?qq=");
// tumap.put("咀嚼","http://xiaobapi.top/api/xb/api/eat.php?qq=");
// tumap.put("来一下","http://xiaobapi.top/api/xb/api/chui.php?qq=");
// tumap.put("看完干活","http://xiaobapi.top/api/xb/api/back_to_work.php?qq=");
// tumap.put("有害垃圾","http://xiaobapi.top/api/xb/api/youhailaji.php?qq=");
// tumap.put("平板","http://xiaobapi.top/api/xb/api/play_game_2.php?qq=");
// tumap.put("玩游戏","http://xiaobapi.top/api/xb/api/play_game.php?qq=");
// tumap.put("拿着","http://xiaobapi.top/api/xb/api/kan_3.php?qq=");
// tumap.put("举2","http://xiaobapi.top/api/xb/api/kan_4.php?qq=");
// tumap.put("举3","http://xiaobapi.top/api/xb/api/kan_5.php?qq=");
// tumap.put("叽","http://xiaobapi.top/api/xb/api/kan_6.php?qq=");
// tumap.put("道歉","http://xiaobapi.top/api/xb/api/kan_8.php?qq=");
// tumap.put("手机","http://xiaobapi.top/api/xb/api/kan_9.php?qq=");
// tumap.put("举3","http://xiaobapi.top/api/xb/api/kan_11.php?qq=");
// tumap.put("拿牌","http://xiaobapi.top/api/xb/api/kan.php?qq=");
// tumap.put("举","http://xiaobapi.top/api/xb/api/ju.php?qq=");
// tumap.put("警察","http://xiaobapi.top/api/xb/api/police2.php?qq=");
// tumap.put("警官","http://xiaobapi.top/api/xb/api/police.php?qq=");
// tumap.put("嘴","http://xiaobapi.top/api/xb/api/jiujiu.php?qq=");
// tumap.put("舔","https://yysk.yitzu.cn.qingf.top/api/xb/api/tian.php?qq=");
// tumap.put("遮脸","https://yysk.yitzu.cn.qingf.top/api/xb/api/cover_face.php?qq=");
// tumap.put("可达鸭","https://xiaobapi.top/api/xb/api/cover_face_2.php?qq=");
// tumap.put("疑问","https://yysk.yitzu.cn.qingf.top/api/xb/api/wenhao.php?qq=");
// tumap.put("上电视","https://yysk.yitzu.cn.qingf.top/api/xb/api/kandianshi.php?qq=");
// tumap.put("这像画吗","https://yysk.yitzu.cn.qingf.top/api/xb/api/hua.php?qq=");
// tumap.put("推","http://yysk.yitzu.cn.qingf.top/api/xb/api/roll.php?qq=");
// tumap.put("垃圾","https://api.klizi.cn/API/gif/garbage.php?qq=");
// tumap.put("为什么艾特我","https://yysk.yitzu.cn.qingf.top/api/xb/api/whyatme.php?qq=");
// tumap.put("墙纸","https://yysk.yitzu.cn.qingf.top/api/xb/api/wallpaper.php?qq=");
// tumap.put("变黑","http://yysk.yitzu.cn.qingf.top/api/xb/api/h.php?qq=");
// tumap.put("求婚","http://ovooa.caonm.net/API/face_propose/?QQ=");
// tumap.put("感动哭了","http://ovooa.caonm.net/API/face_touch/?QQ=");
// tumap.put("高质量","http://ovooa.caonm.net/API/face_gao/?QQ=");
// tumap.put("咸鱼","http://ovooa.caonm.net/API/face_yu/?QQ=");
// tumap.put("快逃","http://xiaobai.klizi.cn/API/gif/escape.php?qq=");
// tumap.put("基友","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate.php?qq=");
// tumap.put("高富帅","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_2.php?qq=");
// tumap.put("白富美","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_3.php?qq=");
// tumap.put("订婚","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_4.php?qq=");
// tumap.put("首富","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_5.php?qq=");
// tumap.put("帅哥","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_6.php?qq=");
// tumap.put("美女","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_7.php?qq=");
// tumap.put("屌丝","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_8.php?qq=");
// tumap.put("小仙女","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_9.php?qq=");
// tumap.put("老司机","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_10.php?qq=");
// tumap.put("光棍","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_11.php?qq=");
// tumap.put("女汉子","http://yysk.yitzu.cn.qingf.top/api/xb/api/stickers_certificate_12.php?qq=");
// tumap.put("要钱钱","http://yysk.yitzu.cn.qingf.top/api/xb/api/want_get_money.php?qq=");
// tumap.put("瑟瑟","https://xiaobai.klizi.cn/API/gif/erotic.php?qq=");
// tumap.put("随机证书","https://xiaobai.klizi.cn/API/ce/zs.php?qq=");
// tumap.put("滚出","http://api.caonm.net/api/gun/index.php?qq=");
// tumap.put("教你做事","http://api.fc520.top/API/bqb/jnzs/api.php?qq=");
// tumap.put("摸狗狗","http://api.caonm.net/api/wus/w.php?qq=");
// tumap.put("猎手","http://api.fc520.top/API/bqb/ls/api.php?qq=");
// tumap.put("网络公主","http://api.caonm.net/api/yyy/y.php?qq=");
// tumap.put("删库","http://h.xiaocha.fun/api/pao.php?qq=");
// tumap.put("看电视","http://h.xiaocha.fun/api/kan.php?qq=");
// tumap.put("美女抬","http://h.xiaocha.fun/api/tai.php?qq=");
// tumap.put("难办","http://h.xiaocha.fun/api/ban.php?qq=");
// tumap.put("女拿","http://h.xiaocha.fun/api/na.php?qq=");
// tumap.put("拍死你","http://h.xiaocha.fun/api/pai.php?qq=");
// tumap.put("4举","http://h.xiaocha.fun/api/ju.php?qq=");
// tumap.put("快溜","http://h.xiaocha.fun/api/liu/liu.php?QQ=");
// tumap.put("怒","http://h.xiaocha.fun/api/nu/nu.php?QQ=");
// tumap.put("不想上学","http://h.xiaocha.fun/api/xue/xue.php?QQ=");
// tumap.put("露脸","http://h.xiaocha.fun/api/lou/lou.php?QQ=");
// tumap.put("滑稽捶","http://h.xiaocha.fun/api/chui/chui.php?QQ=");
// tumap.put("咬2","http://h.xiaocha.fun/api/yao/yao.php?QQ=");
// tumap.put("心碎2","http://h.xiaocha.fun/api/sui/sui.php?QQ=");
// tumap.put("乡下人","http://api.caonm.net/api/txmb/6.php?qq=");
// tumap.put("看这个","http://api.caonm.net/api/txmb/5.php?qq=");
// tumap.put("灵动岛","http://api.caonm.net/api/txmb/3.php?qq=");
// tumap.put("流汗","http://api.caonm.net/api/txmb/1.php?qq=");
// tumap.put("纱雾举牌","http://api.caonm.net/api/wus/w.php?qq=");
// tumap.put("整一个","http://apicaonm.net/api/zyg/gei.php?qq=");
// tumap.put("老干妈","http://api.caonm.net/api/lgm/index.php?qq=");
// tumap.put("纳西妲抱","http://yysk.yitzu.cn.qingf.top/api/xb/api/naxidabao.php?qq=");
// tumap.put("摸擦","http://ovooa.caonm.net/API/face_moca/?QQ=");//很慢很慢
// tumap.put("拿手机","http://h.xiaocha.fun/api/sj.php?qq=");
// tumap.put("我的人","http://h.xiaocha.fun/api/wode.php?qq=");
// tumap.put("喝饮料","http://h.xiaocha.fun/api/xi.php?qq=");
// tumap.put("看淡了","http://h.xiaocha.fun/api/dan.php?qq=");
// tumap.put("坤证","http://api.caonm.net/api/txmb/7.php?qq=");
// tumap.put("懒羊羊","http://api.caonm.net/api/lyy/l.php?qq=");
// tumap.put("防诱拐","http://class1.fun/cn/Dragon-API/API/anti_kidnap.php?qq=");
// tumap.put("一直","http://class1.fun/cn/Dragon-API/API/yizhi.php?qq=");
// tumap.put("阿尼亚","http://class1.fun/cn/Dragon-API/API/anyasuki.php?qq=");
// tumap.put("一样","http://class1.fun/cn/Dragon-API/API/allike.php?qq=");
// tumap.put("开枪","http://class1.fun/cn/Dragon-API/API/Gun.php?qq=");
// tumap.put("上下","http://class1.fun/cn/Dragon-API/API/duichen_up.php?qq=");
// tumap.put("左右","http://class1.fun/cn/Dragon-API/API/duichen.php?qq=");
// tumap.put("摇摆","http://api.caonm.net/api/ajl/y.php?qq=");
// tumap.put("颜色","http://api.caonm.net/api/sjbc/y.php?qq=");
// tumap.put("走路","http://api.caonm.net/api/zoul/y.php?qq=");
// tumap.put("女装协议","http://api.caonm.net/api/jqxy/n.php?qq=");
// tumap.put("进群协议","http://api.caonm.net/api/jqxy/j.php?qq=");
// tumap.put("拿来吧你","http://xiaobapi.top/api/xb/api/give_me_that.php?qq=");
// tumap.put("颜值高","http://xiaobapi.top/api/xb/api/error.php?qq=");
// tumap.put("亲亲","http://api.caonm.net/api/ddqq/y.php?qq=");
// tumap.put("按下","http://api.caonm.net/api/anniu/a.php?qq=");
// tumap.put("50","http://api.caonm.net/api/v50/b.php?qq=");
// tumap.put("涩图","http://api.caonm.net/api/mstl/s.php?qq=");
// tumap.put("杜蕾斯","http://api.caonm.net/api/byt/b.php?qq=");
// tumap.put("打篮球","http://api.caonm.net/api/txmb/3.php?qq=");
// tumap.put("挥拳","http://api.caonm.net/api/hq/chui.php?qq=");
// tumap.put("拿框","https://yysk.yitzu.cn.qingf.top/api/xb/api/kan_11.php?qq=");
// tumap.put("写代码","http://api.wqwlkj.cn/wqwlapi/jwxdm.php?qq=");
// tumap.put("安排","http://api.wqwlkj.cn/wqwlapi/anpai.php?qq=");
// tumap.put("萌新一个","http://api.wqwlkj.cn/wqwlapi/wsmx.php?qq=");
// tumap.put("差评","http://api.wqwlkj.cn/wqwlapi/cp.php?qq=");
// tumap.put("好评","http://api.wqwlkj.cn/wqwlapi/hp.php?qq=");
// tumap.put("羡慕","http://api.wqwlkj.cn/wqwlapi/xianmu.php?qq=");
// tumap.put("坤举旗","http://api.wqwlkj.cn/wqwlapi/kunjuqi.php?qq=");
// tumap.put("开始摆烂","http://api.luanmo.top/API/tu_bailan?qq=");
// tumap.put("保护","http://api.luanmo.top/API/tu_dog2?qq=");
// tumap.put("地图头像","http://api.wqwlkj.cn/wqwlapi/zgdt.php?qq=");
// tumap.put("找老婆","http://api.fc520.top/API/bqb/zlaopo/api.php?qq=");
// tumap.put("大帅哥","http://api.fc520.top/API/bqb/sg/api.php?qq=");
// tumap.put("摆烂","http://api.fc520.top/API/bqb/bailan/api.php?qq=");
// tumap.put("小c酱","http://api.caonm.net/api/xc/index.php?");
// tumap.put("mc酱","http://api.caonm.net/api/mc/index.php?");
// tumap.put("兽猫酱","http://api.caonm.net/api/smj/index.php?");
// tumap.put("柴郡","http://api.caonm.net/api/chai/c.php?");
// tumap.put("ikun","http://api.caonm.net/api/kun/k.php?");
// tumap.put("龙图","http://api.caonm.net/api/long/l.php?");
// tumap.put("变魔术","http://api.caonm.net/api/tax/y.php?qq=");
// tumap.put("⭕","http://api.caonm.net/api/qqyk/q.php?qq="+MyUin+"&qq2=");
// tumap.put("结婚","https://api.caonm.net/api/jhzz/j.php?qq="+MyUin+"&qq2=");
// tumap.put("两只猫","https://api.caonm.net/api/xmmz/y.php?qq=");
// tumap.put("煮","https://api.caonm.net/api/huos/y.php?qq=");
// tumap.put("画画","https://api.caonm.net/api/huaa/h.php?qq=");
// tumap.put("打鸡蛋","https://api.caonm.net/api/chaof/y.php?qq=");
// tumap.put("2舔","https://api.caonm.net/api/chixg/y.php?qq=");
// tumap.put("枕头","https://api.caonm.net/api/zhent/y.php?qq=");
// tumap.put("IKUN","http://api.caonm.net/api/ikz/i.php?qq=");
// tumap.put("滚","http://api.caonm.net/api/gund/g.php?qq=");
// tumap.put("注意身份","http://api.caonm.net/api/zynsf/z.php?qq=");
// tumap.put("翻画板","http://api.caonm.net/api/dakai/a.php?qq=");
// tumap.put("街舞","https://api.caonm.net/api/tmcw/y.php?qq=");
// tumap.put("蹭","https://api.caonm.net/api/cence/y.php?qq=");
// tumap.put("2拍","https://api.caonm.net/api/paid/y.php?qq=");
// tumap.put("装高手","http://www.xiaoqiandtianyi.tk/api/z.php?qq=");
// tumap.put("打篮球","http://www.xiaoqiandtianyi.tk/api/cxk.php?QQ=");
// tumap.put("追","https://api.caonm.net/api/zhuid/y.php?qq=");
// tumap.put("2敲","https://api.caonm.net/api/qiaod/y.php?qq=");
// tumap.put("上吊","https://api.caonm.net/api/shangd/y.php?qq=");
// tumap.put("跳舞","http://api.caonm.net/api/tiaow/y.php?qq=");
// tumap.put("诈尸","http://api.caonm.net/api/zhas/y.php?qq=");
// tumap.put("踢球","https://api.caonm.net/api/tiqiu/y.php?qq=");
// tumap.put("骗子","https://api.caonm.net/api/pianzi/c.php?qq=");
// tumap.put("导管","https://api.caonm.net/api/daoguan/c.php?qq=");
// tumap.put("强行瑟瑟","https://api.caonm.net/api/kapian/c.php?qq=");
// tumap.put("我牛子呢","https://api.caonm.net/api/kapian/c2.php?qq=");
// tumap.put("恶魔","https://api.caonm.net/api/kapian/c3.php?qq=");
// tumap.put("演员","https://api.caonm.net/api/madou/c2.php?qq=");
// tumap.put("狗呢","https://api.caonm.net/api/asc/c.php?qq=");
// tumap.put("不幸","https://api.caonm.net/api/asc/c2.php?qq=");
// tumap.put("动漫画画","https://api.caonm.net/api/asc/c4.php?qq=");
// tumap.put("木鱼","https://api.caonm.net/api/muyu/y.php?qq=");
// tumap.put("金钱攻击","https://api.caonm.net/api/jingq/y.php?qq=");
// tumap.put("安全感","http://api.caonm.net/api/anqg/c.php?qq=");
// tumap.put("陪睡券","https://api.caonm.net/api/asc/c5.php?qq=");
// tumap.put("男同","https://api.caonm.net/api/asc/c6.php?qq=");
// tumap.put("体操服","http://api.caonm.net/api/jupai/m.php?qq=");
// tumap.put("技能","http://api.caonm.net/api/jineng/y.php?qq=");
// tumap.put("GKD","http://api.caonm.net/api/kapian/c5.php?qq=");
// tumap.put("无法瑟瑟","http://api.caonm.net/api/kapian/c4.php?qq=");
// tumap.put("目录","http://api.caonm.net/api/asc/c9.php?qq=");
// tumap.put("床上一躺","http://api.caonm.net/api/asc/c8.php?qq=");
// tumap.put("啊！","http://api.caonm.net/api/asc/c7.php?qq=");
// tumap.put("包夜","http://api.caonm.net/api/guoy/g.php?qq=");
// tumap.put("报警了","http://api.caonm.net/api/baon/1.php?qq=");
// tumap.put("超市","http://api.caonm.net/api/chaop/j.php?qq="+MyUin+"&qq2=");
// tumap.put("星期四","http://api.caonm.net/api/kfc/50.php?qq=");
// tumap.put("女同","http://api.caonm.net/api/asc/c66.php?qq=");

tumap.put("阿尼亚看","https://api.andeer.top/API/aniyasuki.php?qq=");
tumap.put("狗","https://api.andeer.top/API/dog.php?qq=");
tumap.put("单身狗证","https://api.andeer.top/API/dsg.php?qq=");
tumap.put("你怎么和","https://api.tangdouz.com/wz/yy.php?q=");
tumap.put("芙蓉王","http://api.caonm.net/api/yan/y.php?qq=");//没用，用来垫底防最后一个

}









//类似的使用接口的一言之类都可以使用这种写法
Set keys=tumap.keySet();
public String kk(String a,Set list){//如果以key开始则返回key值
String result="";
for(String b:list){
if(a.startsWith(b)){
result=b;
break;}
}
return result;
}
public static boolean iss(String str){//判断是否数字
for (int i = str.length();--i>=0;){
 if (!Character.isDigit(str.charAt(i))){
return false;
}
}
return true;
}

AddItem("开启/关闭限制","开关",PluginID);

public void 开关(String qun,String qqq,int type)
{
	if("1".equals(getString(qun,"脚本"))||"1".equals(getString(qqq,"脚本")))
	{
	putString(qun, "脚本", null);putString(qqq,"脚本",null);
      Toast("限制已开启,本聊天仅自己可用");
	}
	else{
	putString(qun,"脚本","1");putString(qqq,"脚本","1");
	Toast("限制已关闭,本聊天他人也可使用");
	}
}





public void onMsg(Object msg)
{
String text=msg.MessageContent;
String qq=msg.UserUin;
String qun=msg.GroupUin;
public void sendpic(p){
if(msg.IsGroup){sendPic(qun,"",p);}
else{sendPic("",msg.msg.frienduin,p);}}
public void fc(String s,String q){//匹配key值,获取相应接口
new Thread(new Runnable(){//新线程防止延迟过长
public void run()
{sendpic(tumap.get(s)+q);
}}).start();
}

if(msg.IsSend||"1".equals(getString(qun,"脚本"))||"1".equals(getString(GetFriendUin(),"脚本"))){//限制
if(!"".equals(kk(text,keys))){
String s=kk(text,keys);//指令key值
String uin=text.replace(s,"");//非key值部分
if(uin.equals("我")  || uin.equals("自己")){
try{//使用快捷方式
fc(s,qq);}catch(e){return;}
}
if(msg.IsGroup)
{//群聊且艾特

if(msg.mAtList.size()>=1){
if(!uin.startsWith("@"))return;
try{String q=msg.mAtList.get(0);
fc(s,q);}catch(e){return;}
}}
if(uin.equals("") && !s.equals("ikun") && !s.equals("兽猫酱") && !s.equals("小c酱") && !s.equals("mc酱") && !s.equals("猫猫表情")) {
return;
}
if(iss(uin)){
try{//输入了qq号
fc(s,uin);
return;
}catch(e){return;}
}
if(!msg.IsGroup){
try{//私聊
String q=MyUin;
// if(iss(uin))return;
if(uin.equals("我") || uin.equals("自己")){
q=qq;
fc(s,q);
}
if(uin.equals("你")){
if(qq.equals(MyUin))q=msg.msg.frienduin;else q=MyUin; 
fc(s,q);
}
// if(iss(uin))return;
}catch(e){return;}
}
}//我还不知道有msg.msg.frienduin这个东西


if(msg.MessageContent.startsWith("资料卡一"))
{
String text=msg.MessageContent.substring(2);
{
if(text.contains("1")||text.contains("2")||text.contains("3")||text.contains("4")||text.contains("5")||text.contains("6")||text.contains("7")||text.contains("8")||text.contains("9"))
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+text);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_1.php?qq="+text+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,GetFriendUin(),ae);
}
}
}
if(msg.MessageContent.startsWith("资料卡一@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_1.php?qq="+strQQ+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡一我"))
{
if(msg.UserUin.equals(MyUin))
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+MyUin);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_1.php?qq="+MyUin+"&name="+nc+"&qid=1314520";
sendPic("",GetFriendUin(),ae);
return;
}
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+GetFriendUin());
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_1.php?qq="+GetFriendUin()+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,GetFriendUin(),ae);
}
if(msg.MessageContent.startsWith("资料卡一你"))
{
if(msg.UserUin.equals(MyUin))
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+GetFriendUin());
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_1.php?qq="+GetFriendUin()+"&name="+nc+"&qid=1314520";
sendPic("",GetFriendUin(),ae);
return;
}
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+MyUin);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_1.php?qq="+MyUin+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,GetFriendUin(),ae);
}
if(msg.MessageContent.startsWith("资料卡二@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String ae="http://xiaobai.klizi.cn/API/ce/qqcard.php?qq="+strQQ+"&msg="+txt+"&nick="+nc+"&name="+nc;
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡三@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_2.php?qq="+strQQ+"&msg="+txt+"&nick="+nc+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡四@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_3.php?qq="+strQQ+"&msg="+txt+"&nick="+nc+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡五@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_4.php?qq="+strQQ+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡六@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_5.php?qq="+strQQ+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡七@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_6.php?qq="+strQQ+"&msg="+txt+"&name="+nc;
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡八@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_7.php?qq="+strQQ+"&msg="+txt+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡九@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_8.php?qq="+strQQ+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,"",ae);
}
}
if(msg.MessageContent.startsWith("资料卡十@"))
{
for(String strQQ: msg.mAtList)
{
String qqh=get("https://res.abeim.cn/api-qq.name?qq="+strQQ);
JSONObject b=new JSONObject(qqh);
String nc=b.getString("name");
String ae="http://xiaobai.klizi.cn/API/ce/qqcard_9.php?qq="+strQQ+"&name="+nc+"&qid=1314520";
sendPic(msg.GroupUin,"",ae);
}
}


if(msg.MessageContent.startsWith("拽@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="http://api.tangdouz.com/wz/zhuai.php?q="+strQQ+"&nr="+txt;
sendPic(msg.GroupUin,"",huai);
}
}
if(msg.MessageContent.startsWith("什么档次@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="http://api.caonm.net/api/jupai/dc.php?msg="+txt;
sendPic(msg.GroupUin,"",huai);
}
}

if(msg.MessageContent.startsWith("粉丝@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="http://xiaobapi.top/api/xb/api/fans_jupai.php?msg="+txt;
sendPic(msg.GroupUin,"",huai);
}
}
if(msg.MessageContent.startsWith("诺基亚@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="https://xiaobapi.top/api/xb/api/nokia.php?msg="+txt;
sendPic(msg.GroupUin,"",huai);
}
}

if(msg.MessageContent.startsWith("鲁迅说过@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="https://api.andeer.top/API/img_luxun.php?text="+txt;
sendPic(msg.GroupUin,"",huai);
}
}


if(msg.MessageContent.startsWith("管理员@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="http://api.tangdouz.com/wz/qunshuo.php?qq="+strQQ+"&nr="+txt+"&sf=管理员";
sendPic(msg.GroupUin,"",huai);
}
}

if(msg.MessageContent.startsWith("群主@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="http://api.tangdouz.com/wz/qunshuo.php?qq="+strQQ+"&nr="+txt+"&sf=群主";
sendPic(msg.GroupUin,"",huai);
}
}
if(msg.MessageContent.startsWith("群员@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="http://api.tangdouz.com/wz/qunshuo.php?qq="+strQQ+"&nr="+txt+"&sf=群员";
sendPic(msg.GroupUin,"",huai);
}
}
if(msg.MessageContent.startsWith("朋友@"))
{
for(String strQQ: msg.mAtList)
{
int index = msg.MessageContent.lastIndexOf(" ");
String txt = msg.MessageContent.substring(index + 1);
String huai="http://api.tangdouz.com/wz/py.php?q="+strQQ+"&nr="+txt;
sendPic(msg.GroupUin,"",huai);
}
}

//if(text.equals("功能")){
//sendMsg(qun,GetFriendUin(),"功能列表：\n"+keys.toString().replace(",","@  ").replaceAll("[\\[\\]]","")+"@\n\n快捷方式\n+我 例：摸我 \n+qq 例：摸10001\n其中:ikun 龙图 兽猫酱 小c酱 柴郡 mc酱不需要加艾特");}

if(text.startsWith("功能")){
    StringBuilder sb=new StringBuilder();
    String[] karr = keys.toString().replaceAll("[\\[\\]]","").replace(" ","").split(",");
    if(sendtype == 1){
        if(text.equals("功能")){
            sb.append("查看作图请：功能1，功能2...\n使用方法：关键词+@某人\n");
            sb.append("\n\n其中:ikun 兽猫酱 小c酱  mc酱 猫猫表情不需要加艾特\n若没有反应有可能是接口出问题，等图片源站站长修复即可\n\n其中：\n资料卡一 资料卡二 ... 资料卡十 拽 粉丝 诺基亚 鲁迅说过 管理员 群员 群主 朋友 什么档次 \n用法较为特殊\n需要在@后追加文字");
            sendMsg(qun,GetFriendUin(),sb.toString());
            return;
        }
        int page = Integer.parseInt(text.replace("功能",""));
        int maxpage = karr.length/fenye + 1;
        int start,end;
        for(int i = 0; i < karr.length; i++){
            String k = i+"";
            StringBuilder sb2=new StringBuilder();
            sb2.append(k).append(".").append(karr[i]);
            karr[i] = sb2.toString();
        }
        start = (page-1)*fenye + 1;
        if (page < maxpage && page > 0) 
            end = page*fenye + 1;
        else if (page == maxpage)
            end = karr.length + 1;
        else return;
        if(page <= maxpage && page > 0){
            for(int i = start; i < end; i++){
                if(i%2 != 0) {
                    sb.append(karr[i-1]).append(" \t\t\t\t");
                }else{
                    sb.append(karr[i-1]);
                }
                if(i%2 == 0 && i+1 != end)
                    sb.append("\n");
            }
        }else return;
        //sendPackMsg(msg.GroupUin,"",msg.GroupUin,msg.UserUin,sb.toString(),"作图功能列表");
        sendMsg(qun,GetFriendUin(),sb.toString());
        return;
    }else if(sendtype == 2){
        if(!text.equals("功能")) return;
        sb.append("使用方法：关键词+@某人\n功能列表：\n");
        for(int i = 0; i < karr.length; i++){
            String k = i+"";
            StringBuilder sb2=new StringBuilder();
            sb2.append(k).append(".").append(karr[i]);
            karr[i] = sb2.toString();
        }
        for(int i = 1; i < karr.length+1; i++){
            if(i%2 != 0) {
                sb.append(karr[i-1]).append(" \t\t\t\t");
            }else {
                sb.append(karr[i-1]).append("\n");
            }
        }
        sb.append("\n\n其中:ikun 兽猫酱 小c酱  mc酱 猫猫表情不需要加艾特\n若没有反应有可能是接口出问题，等图片源站站长修复即可\n\n其中：\n资料卡一 资料卡二 ... 资料卡十 拽 粉丝 诺基亚 鲁迅说过 管理员 群员 群主 朋友 什么档次 \n用法较为特殊\n需要在@后追加文字");
	    sendPackMsg(msg.GroupUin,"",msg.GroupUin,msg.UserUin,sb.toString(),"作图功能列表");
	    return;
    }
}



}}


Toast("发送 功能 查看功能\n三杠可控制是否他人可用\n有素材可以加群投放做接口");