String OpenItemID = "";
String CloseItemID = "";
import java.util.Calendar;
setItemCallback("ItemCallBack");
setFlag("骚技_QQ2971627154");
public void ItemCallBack(String mg){
    RemoveItem(PluginID,OpenItemID);
    RemoveItem(PluginID,CloseItemID);
    if(开关.读(GroF,mg)==1){
        CloseItemID = AddItem("关机","CloseTitle",PluginID);
        RemoveItem(PluginID,OpenItemID);
    }else{
        OpenItemID = AddItem("开机","OpenTitle",PluginID);
        RemoveItem(PluginID,CloseItemID);
    }
}AddItem("功能开关","Allfunctionsettings",PluginID);
public void OpenTitle(String mg){
    /*if(guanfq.contains(mg)&&!guanfq.contains(mQQ)){
        toast(Jck,1700);
        return;
    }*/开关.写(GroF,mg,1);
    toast("开机成功",120);
}public void CloseTitle(String mg){
    开关.删(GroF,mg);
    toast("关机成功",120);
}public String getMsg(String mc,String me,int pe){
    mxtMpbF(Root+"彩铃/苹果发送.mp3");
    if(mc.startsWith(" ")){
        return mc.substring(1);
    }if(mc.equals("开机")){
        if(pe==2){
            开关.写("私聊","开关",1);
            Toast("私聊使用开启");
            return"StopToSend";
        }if(guanfq.contains(me)&&!guanfq.contains(mQQ)&&me.length()!=0){
            toast(Jck+guanfq,1700);
            return"StopToSend";
        }int te= GetChatType();
        if(te==1000){
            return mc;
        }if(开关.读(GroF,me)==1){
            toast("无需重复开启",120);
        }else{
            开关.写(GroF,me,1);
            toast("开机成功",120);
        }return"StopToSend";
    }if(mc.equals("关机")){
        if(pe==2){
            开关.写("私聊","开关",0);
            Toast("私聊使用关闭");
            return"StopToSend";
        }if(开关.读(GroF,me)==0){
            toast("该群尚未开机",120);
        }else{
            开关.删(GroF,me);
            toast("关机成功",120);
        }return"StopToSend";
    }if(mc.startsWith("发-")){
        int x=mc.indexOf(" ");
        int l=Integer.parseInt(mc.substring(2,x));
        String n=mc.substring(x+1);
        Toast(l+" "+n);
        for(int i=0;i<l;i++){
            //Thread.sleep(15);
            get_msg(n);
        }return"StopToSend";
    }if(mc.equals("开关设置")){
        Allfunctionsettings(me);
        return"StopToSend";
    }if(mc.equals("所有群设置")){
        initActivity();
        ViewAllGroup();
        return"StopToSend";
    }if(mc.equals("查看公告")){
        try{
            String Tip= http.get(tip_yyy);
            Tip=Tip.substring(Tip.length()-2300);
            tipdata=getintercept(Tip,"@","297162715466").replace("±","\n");
            MakeNoticeDialog(tipdata);
            return"StopToSend";
        }catch(e){
            return"StopToSend";
        }
    }if(mc.equals("我的天气")){
        try{
            String api="https://api.vvhan.com/api/weather";
            JSONObject tal=new JSONObject(http.get(api));
            String city=tal.get("city");
            JSONObject i=tal.getJSONObject("info");
            String date=i.get("date");
            String type=i.get("type");
            String high=i.get("high");
            String low=i.get("low");
            String fx=i.get("fengxiang");
            String fl=i.get("fengli");
            String tip=i.get("tip");
            String tl=city+"天气\n"+date+"\n有"+type+"\n"+high+"  "+low+"\n"+fx+fl+msgArr(tip,14);
            MakeDialog(tl);
        }catch(e){}
        return"StopToSend";
    }if(mc.equals("更新日志")){
        initActivity();
        new Handler(Looper.getMainLooper()).post(new Runnable(){
            public void run(){
                new MyTeachDialog(ThisActivity).GxRz(YYhistory);
            }
        });
        return"StopToSend";
    }if(mc.startsWith("唱")||mc.startsWith("试听 ")&&1<mc.length()&&mc.length()<20){
        String url = "http://lkaa.top/API/yydg/api.php?msg=";
        String s = mc.substring(1).replace("听 ","");
        String i = "&n=1";
        String i = url+s+i;
        new Thread(new Runnable(){
            public void run(){
                try{
                    String o =http.get(i);
                    o=JSON解析(o,"data","url");
                    String t = Root+"数据/唱.mp3";
                    http.File(o,t);
                    initActivity();
                    MediaPlayer chang = new MediaPlayer();
                    try{
                        File file = new File(t);
                        chang.setDataSource(file.getPath());
                        chang.setLooping(false);
                        chang.prepare();
                        chang.start();
                    }catch(e){
                        chang.stop();
                        chang.release();
                    }
                }catch(Exception e){
                    Toast(Api_403+e);
                }
            }
        }).start();
        return"StopToSend";
    }if(mc.startsWith("点歌 ")&&1<mc.length()&&mc.length()<20){
        String url = "http://lkaa.top/API/yydg/api.php?msg=";
        String s = mc.substring(3);
        String i = "&n=1";
        String i = url+s+i;
        String o =http.get(i);
        o=JSON解析(o,"data","url");
        String t = Root+"数据/唱.mp3";
        if(http.FFile(o,t))get_voice(t);
        return"StopToSend";
    }if(mc.startsWith("get")){
        try{
            Toast(mc);
            String url=mc.substring(3);
            String l=http.get(url);
            get_msg(l);
            写入(l,Root+"get.json");
        }catch(e){
            Toast(Api_403);
        }return mc;
    }if(mc.startsWith("post")){
        try{
            int x=mc.indexOf(" ");
            String url=mc.substring(4,x);
            String data=mc.substring(x+1);
            get_msg(http.post(url,data));
            写入(l,Root+"post.json");
        }catch(e){
            Toast(Api_403);
        }return mc;
    }if(mc.startsWith("闪 ")){
        int type=new Random().nextInt(5)+2000;
        get_shan(mc.substring(2),type);
        return"StopToSend";
    }if(mc.startsWith("语音 ")){
        get_voice(mc.substring(3));
        return"StopToSend";
    }if(mc.startsWith("图片 ")){
        String a=mc.substring(3);
        get_pic(a);
        return"StopToSend";
    }if(mc.equals("看教学")){
        Toast("若无法播放请发送“下载教学素材”");
        initActivity();
        new Handler(Looper.getMainLooper()).post(new Runnable(){
            public void run(){
                new MyTeachDialog(ThisActivity).ShowView1();
            }
        });
        return"StopToSend";
    }if(mc.equals("下载教学素材")){
        try{
            String jxroot="数据/教学文件/";
            String r=Root+jxroot;
            Toast("下载教学文件ing...\n官方群号：1037983710");
            File f=new File(r);
            if(!f.exists())f.mkdirs();
            http.File(Jxjiuzhe,r+"就这.mp4");
            http.File(Jx1png,r+"1.png");
            http.File(Jx2png,r+"2.png");
            http.File(Jx1jpg,r+"1.jpg");
            http.File(Jxyouwu,r+"油物.mp4");
            http.File(Jxdiaochan,r+"貂蝉.mp4");
            http.File(Jx2jpg,r+"2.jpg");
            http.File(Jxdengchang,r+"登场");
            Toast("下载完成，可以看教学了！");
            initActivity();
            new Handler(Looper.getMainLooper()).post(new Runnable(){
                public void run(){
                    new MyTeachDialog(ThisActivity).ShowView1();
                }
            });
            return"StopToSend";
        }catch(e){
            Toast("下载失败了..."+e);
        }
    }return mc;
}public static String formtime(long a){
    long b = System.currentTimeMillis();
    long c =(b-a)/1000;
    long d = c/(60*60);
    long e =(c-d*60*60)/(60);
    long f =(c-d*60*60 - e*60);
    return d + "时 "+ e + "分 "+ f + "秒 ";
}public void onUnload(){
    Toast("--鸭鸭Java--\n本次运行时长："+formtime(Javabegin));
}public JSON解析(String data,String a,String b){
    try{
        String s="";
        JSONObject j =new JSONObject(data);
        if(a.equals("")){
            s=j.getString(b);
        }else if(b.equals("")){
            s=j.getString(a);
        }else{
            s=j.getJSONObject(a).getString(b);
        }return s;
    }catch(e){
        return "";
        Toast("解析错误"+e);
    }
}//QQversion.java
import com.tencent.common.app.BaseApplicationImpl;
Object app=BaseApplicationImpl.getApplication().getRuntime();
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
PackageManager pm = context.getPackageManager();
ApplicationInfo sAppInfo = pm.getApplicationInfo("com.tencent.mobileqq",PackageManager.GET_META_DATA);
String UUID = sAppInfo.metaData.getString("com.tencent.rdm.uuid");
String Version_Code = UUID.substring(0,UUID.indexOf("_"));
int QQ_version=Integer.parseInt(Version_Code);
import com.tencent.mobileqq.app.BaseActivity;
BaseActivity activity;
while(activity==null){
    activity=BaseActivity.sTopActivity;
}import com.tencent.mobileqq.troop.api.ITroopInfoService;
ITroopInfoService TroopInfo=app.getRuntimeService(ITroopInfoService.class);
public String quncode(String qun){
    String code= TroopInfo.getTroopCodeByTroopUin(qun);
    if(code==null||code.equals(""))code=qun;
    return code;
}public String qunuin(String code){
    String qun= TroopInfo.getTroopUinByTroopCode(code);
    if(qun==null||qun.equals(""))qun=code;
    return qun;
}/*QQ闪字接口 由卑微萌新(QQ779412117)开发，使用请保留版权 QQ闪字接口 群 sendArk(String qun,String word,int type);
参数: 群号,文字内容,闪字类型 好友 sendFriendArk(String qq,String word,int type);
参数: QQ号,文字内容,闪字类型 闪字类型(QQ小表情会自动转成文字)2000,随机字(滚动显示很多字后再显示，不是随机效果，旧版不支持emoji表情，新版字少时表情显示有问题)2001,颤动(旧版不支持emoji表情)2002,爆闪(旧版不支持emoji表情)2003,黑客帝国 2004,快闪(旧版emoji表情停止后才能显示)*/
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQManagerFactory;
Object flashchatmanager =app.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
import org.json.JSONObject;
JSONObject items = new JSONObject("{\"-100000\":{\"appDesc\":\"随机\"},\"2000\":{\"appMinVersion\":\"1.0.0.16\",\"appName\":\"com.tencent.randomwords\",\"appView\":\"main\",\"appDesc\":\"随机字\"},\"2001\":{\"appMinVersion\":\"1.0.0.15\",\"appName\":\"com.tencent.vibrate\",\"appView\":\"main\",\"appDesc\":\"颤动\"},\"2002\":{\"appMinVersion\":\"1.0.0.12\",\"appName\":\"com.tencent.flash\",\"appView\":\"main\",\"appDesc\":\"爆闪\"},\"2003\":{\"appMinVersion\":\"1.0.0.12\",\"appName\":\"com.tencent.hacker\",\"appView\":\"main\",\"appDesc\":\"黑客帝国\"},\"2004\":{\"appMinVersion\":\"1.0.0.12\",\"appName\":\"com.tencent.scale\",\"appView\":\"main\",\"appDesc\":\"快闪\"}}");
//Toast(items);
public void ArkFlash(String num,String word,int numtype,int wordtype){
    ArkFlashChatMessage ark;
    Object base;
    if(QQ_version<8000){
        ark= flashchatmanager.a(word,0,wordtype);
        base=new com.tencent.mobileqq.activity.aio.BaseSessionInfo();
        base.a=numtype;
        base.b=num;
        ChatActivityFacade.a(app,new SessionInfo(base),ark,0);
    }else{
        ark= flashchatmanager.q(word,0,wordtype);
        //Toast(""+flashchatmanager.D+flashchatmanager.J(app)+ark);
        if(ark==null){
            ark=new ArkFlashChatMessage();
            Object flashChatItem =items.get(wordtype+"");
            if(flashChatItem==null){
                Toast("闪字ID"+wordtype+"不存在!");
                return;
            }// Toast(flashChatItem);
            ark.appMinVersion = flashChatItem.get("appMinVersion");
            ark.appName = flashChatItem.get("appName");
            ark.appView = flashChatItem.get("appView");
            ark.appDesc = flashChatItem.get("appDesc");
            ark.appResId = wordtype;
            ark.promptText = word;
            ark.config = "config";
        }base=new com.tencent.mobileqq.activity.aio.t();
        base.e=numtype;
        base.f=num;
        ChatActivityFacade.j1(app,new SessionInfo(base),ark,0);
    }
}public void sendArk(String qun,String word,int type){
    ArkFlash(qun,word,1,type);
}public void sendFriendArk(String qq,String word,int type){
    ArkFlash(qq,word,0,type);
}