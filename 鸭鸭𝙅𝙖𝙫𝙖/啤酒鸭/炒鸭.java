String[] functionName ={"我的功能.java","查询系统.java","点歌系统.java","菜单.java","智能聊天.java","视频解析.java","文案系统.java","群管系统.java","图片系统.java","登录系统.java","休闲娱乐.java","功能测试.java","其他功能.java","ZipUtil.java","消息切换.java"};
public void LoadfunctionName(){
    for(String Name: functionName){
        try{
            load(Root + "啤酒鸭/功能/"+ Name);
        }catch(e){
            MakeDialog("加载"+ Name + "时发生错误:"+ e);
        }
    }
}LoadfunctionName();
import android.media.MediaPlayer;
String TubeArr= "2995665793"+mQQ+Lshost;
public void onMsg(Object msg){
    try{
        String mc = msg.MessageContent;
        int type = msg.MessageType;
        long mt = msg.MessageTime;
        String mu = msg.UserUin;
        String mg = msg.GroupUin;
        String[] at = msg.AtList;
        String mn = msg.SenderNickName;
        if(mu.length()<5)return;
        if(mc.equals(""))return;
        功能测试(msg,mc,mg,mu,mn,mt);
        my_功能(msg,mc,mg,mu,at);
        if(msg.IsGroup){
            if(开关.读(GroF,mg)==1){
                消息切换(msg);
                javamap(msg,mc,mg,mu,mn);
                zl_群管(msg,mc,mg,mu,mn,at);
                zl_wenan(msg,mc,mg,mu,mn);
                zl_xiuxian(msg,mc,mg,mu,mn,mt,type);
                zl_jiexi(msg,mc,mg,mu);
                zl_zhinengAl(msg,mc,mg,mu);
                zl_diange(msg,mc,mg,mu,mt);
                zl_chaQ(msg,mc,mg,mu,mn);
                zl_tupian(msg,mc,mg,mu,mt);
                zl_playskey(msg,mc,mg,mn,mu);
                otherzl(msg,mc,mg,mu,mn,mt);
                if(llilllli.contains(mu)&&mQQ.equals("2995665793")){
                    文字(msg,"云黑账号\n"+头像(mu,1)+"QQ\n"+mu+"\n是鸭鸭黑名单人员\n请及时处理！");
                }
            }
        }else{
            if(开关.读("私聊","开关")==1){
                //String mg="";
                javamap(msg,mc,mg,mu,mn);
                zl_wenan(msg,mc,mg,mu,mn);
                zl_xiuxian(msg,mc,mg,mu,mn,mt,type);
                zl_jiexi(msg,mc,mg,mu);
                zl_zhinengAl(msg,mc,mg,mu);
                zl_diange(msg,mc,mg,mu,mt);
                zl_chaQ(msg,mc,mg,mu,mn);
                zl_tupian(msg,mc,mg,mu,mt);
                zl_playskey(msg,mc,mg,mn,mu);
                otherzl(msg,mc,mg,mu,mn,mt);
            }
        }putong(msg);
        zl_dzJava(msg,mc,mg,mu);
        if(!msg.IsGroup&&!mu.equals(mQQ)&&开关.读("私信","收到")==0){
            xtMpbF(Root+"彩铃/苹果微信.mp3");
        }
    }catch(e){}
}public void Allfunctionsettings(String mg){
    initActivity();
    ThisActivity.runOnUiThread(new Runnable(){
        public void run(){
            try{
                final String[] items ={"菜单","文案","小爱","妲己","天气","点歌","查询","战力","群管","视频解析[去水印]","发送无水印视频","自助头衔/名片","休闲娱乐","图片系统","登录系统(抢修中)","彩铃功能","进退群提示","点赞(赞我)","脚本私聊使用","点歌语音发送原时长大小" };final boolean[] checkedItems ={false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false };checkedItems[0] = 开关.读("菜单",mg)== 0;
                checkedItems[1] = 开关.读("文案",mg)== 0;
                checkedItems[2] = 开关.读("小爱",mg)== 0;
                checkedItems[3] = 开关.读("妲己",mg)== 0;
                checkedItems[4] = 开关.读("天气",mg)== 0;
                checkedItems[5] = 开关.读("点歌",mg)== 0;
                checkedItems[6] = 开关.读("查询",mg)== 1;
                checkedItems[7] = 开关.读("战力",mg)== 0;
                checkedItems[8] = 开关.读("群管",mg)== 1;
                checkedItems[9] = 开关.读("视频解析",mg)== 1;
                checkedItems[10] = 开关.读("切换解析",mg)== 1;
                checkedItems[11] = 开关.读("自助头衔",mg)== 1;
                checkedItems[12] = 开关.读("娱乐",mg)== 0;
                checkedItems[13] = 开关.读("图片",mg)== 1;
                checkedItems[14] = 开关.读("登录",mg)== 1;
                checkedItems[15] = 开关.读("私信","收到")== 0;
                checkedItems[16] = 开关.读("进退群",mg)== 1;
                checkedItems[17] = 开关.读("点赞",mg)== 1;
                checkedItems[18] = 开关.读("私聊","开关")== 1;
                checkedItems[19] = 开关.读("语音","时长")== 1;
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_DARK);
                alertDialog.setTitle("本群功能开关");
                alertDialog.setMultiChoiceItems(items,checkedItems,new DialogInterface.OnMultiChoiceClickListener(){
                    public void onClick(DialogInterface dialog,int which,boolean isChecked){}
                });
                alertDialog.setPositiveButton(Html.fromHtml("<font color=\"#00ff00\">【确定】</font><br>提示:以上功能均可指令控制如(关闭/开启菜单)"),new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        开关.写("菜单",mg,checkedItems[0]?0:1);
                        开关.写("文案",mg,checkedItems[1]?0:1);
                        开关.写("小爱",mg,checkedItems[2]?0:1);
                        开关.写("妲己",mg,checkedItems[3]?0:1);
                        开关.写("天气",mg,checkedItems[4]?0:1);
                        开关.写("点歌",mg,checkedItems[5]?0:1);
                        开关.写("查询",mg,checkedItems[6]?1:0);
                        开关.写("战力",mg,checkedItems[7]?0:1);
                        开关.写("群管",mg,checkedItems[8]?1:0);
                        开关.写("视频解析",mg,checkedItems[9]?1:0);
                        开关.写("切换解析",mg,checkedItems[10]?1:0);
                        开关.写("自助头衔",mg,checkedItems[11]?1:0);
                        开关.写("娱乐",mg,checkedItems[12]?0:1);
                        开关.写("图片",mg,checkedItems[13]?1:0);
                        开关.写("登录",mg,checkedItems[14]?1:0);
                        开关.写("私信","收到",checkedItems[15]?0:1);
                        开关.写("进退群",mg,checkedItems[16]?1:0);
                        开关.写("点赞",mg,checkedItems[17]?1:0);
                        开关.写("私聊","开关",checkedItems[18]?1:0);
                        开关.写("语音","时长",checkedItems[19]?1:0);
                    }
                });
                alertDialog.show();
            }catch(e){
                Toast("" + e);
            }
        }
    });
}toast("加载完成",1700);
