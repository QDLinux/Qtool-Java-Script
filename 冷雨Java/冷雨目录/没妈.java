AddItem("开关设置","开关设置",PluginID);
public void 开关设置(String qun)
{
new Thread(new Runnable(){
public void run(){
kgsz(qun);
}}).start();
}
public void kgsz(String qun)
{
public boolean[] chose(){
boolean qd=false;
Activity act= GetActivity();
boolean 开关机=true;
boolean 语音菜单=true;
boolean 图片菜单=true;
boolean 点歌菜单=true;

boolean GPT菜单=true;
boolean skey扫码=true;
boolean 视频大全=true;
boolean 自助头衔=true;
boolean 表情制作=true;
boolean 违禁检测=true;
boolean 群提示=true;
boolean 本群赞我=true;
boolean 红包检测=true;
boolean 文案菜单=true;
boolean 自助上管=true;

boolean 头像菜单=true;
boolean 发言榜单=true;
boolean 艾特回复=true;
boolean 艾特禁言=true;
boolean 撤回链接=true;
boolean 撤回卡片=true;
boolean 撤回语音=true;
boolean 撤回图片=true;
boolean 图片外显=true;
boolean 查询系统=true;
boolean 天气系统=true;
boolean 福利功能=true;
boolean 撤回自身=true;
boolean 刷听歌=true;
String[] ww={"开/关机","语音菜单","图片菜单","点歌菜单","GPT菜单","skey扫码","视频大全","自助头衔","表情制作","违禁检测","群提示","本群赞我","红包检测","文案菜单","自助上管","头像菜单","发言榜单","艾特回复","艾特禁言","撤回链接","撤回卡片","撤回语音","撤回图片","图片外显","查询系统","天气系统","福利功能","撤回自身","刷听歌"};
if(取(qun,"xiaoqi")==null){开关机=false;}
if(取(qun,"yuyin")==null){语音菜单=false;}
if(取(qun,"tupiancaidan")==null){图片菜单=false;}
if(取(qun,"diange")==null){点歌菜单=false;}
if(取(qun,"GPT")==null){GPT菜单=false;}
if(取(qun,"saoma")==null){skey扫码=false;}
if(取(qun,"shipindaquan")==null){视频大全=false;}
if(取(qun,"lengyu")==null){自助头衔=false;}
if(取(qun,"biaoqingbao")==null){表情制作=false;}
if(取(qun,"weijin")==null){违禁检测=false;}
if(取(qun,"quntishi")==null){群提示=false;}
if(取(qun,"zanwo")==null){本群赞我=false;}
if(取(qun,"hongbao")==null){红包检测=false;}
if(取(qun,"wenan")==null){文案菜单=false;}
if(取(qun,"zzsg")==null){自助上管=false;}
if(取(qun,"touxiang")==null){头像菜单=false;}
if(取(qun,"fayan")==null){发言榜单=false;}
if(取(MyUin,"艾特回复开关")==null){艾特回复=false;}
if(取(MyUin,"艾特禁言开关")==null){艾特禁言=false;}
if(取(qun,"撤回链接")==null){撤回链接=false;}
if(取(qun,"撤回卡片")==null){撤回卡片=false;}
if(取(qun,"撤回语音")==null){撤回语音=false;}
if(取(qun,"撤回图片")==null){撤回图片=false;}
if(取(MyUin,"图片外显")==null){图片外显=false;}
if(取(qun,"查询系统")==null){查询系统=false;}
if(取(qun,"天气系统")==null){天气系统=false;}
if(取(qun,"福利功能")==null){福利功能=false;}
if(取(MyUin,"撤回自身")==null){撤回自身=false;}
if(取(qun,"刷听歌")==null){刷听歌=false;}
boolean[] xx={开关机,语音菜单,图片菜单,点歌菜单,GPT菜单,skey扫码,视频大全,自助头衔,表情制作,违禁检测,群提示,本群赞我,红包检测,文案菜单,自助上管,头像菜单,发言榜单,艾特回复,艾特禁言,撤回链接,撤回卡片,撤回语音,撤回图片,图片外显,查询系统,天气系统,福利功能,撤回自身,刷听歌};
act.runOnUiThread(new Runnable(){
public void run(){
AlertDialog.Builder dialog = new AlertDialog.Builder(act,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
dialog.setTitle("开关设置");
dialog.setMultiChoiceItems(ww, xx, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialog, int which, boolean isChecked){
xx[which]=isChecked;
}});
dialog.setPositiveButton("确定", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
//提示("a");
dialog.dismiss();
qd=true;}});
dialog.setNegativeButton("取消", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
//提示("a");
dialog.dismiss();
qd=false;}});
dialog.setCancelable(false);
dialog.show();
}
});
while(!qd){Thread.sleep(100);} return xx;
}
boolean[] cs=chose();
if(cs[0]){存(qun, "xiaoqi","1");}else{存(qun, "xiaoqi",null);}
if(cs[1]){存(qun, "yuyin","1");}else{存(qun, "yuyin",null);}
if(cs[2]){存(qun, "tupiancaidan","1");}else{存(qun, "tupiancaidan",null);}
if(cs[3]){存(qun, "diange","1");}else{存(qun, "diange",null);}
if(cs[4]){存(qun, "GPT","1");}else{存(qun, "GPT",null);}
if(cs[5]){存(qun, "saoma","1");}else{存(qun, "saoma",null);}
if(cs[6]){存(qun, "shipindaquan","1");}else{存(qun, "shipindaquan",null);}
if(cs[7]){存(qun, "lengyu","1");}else{存(qun, "lengyu",null);}
if(cs[8]){存(qun, "biaoqingbao","1");}else{存(qun, "biaoqingbao",null);}
if(cs[9]){存(qun, "weijin","1");}else{存(qun, "weijin",null);}
if(cs[10]){存(qun, "quntishi","1");}else{存(qun, "quntishi",null);}
if(cs[11]){存(qun, "zanwo","1");}else{存(qun, "zanwo",null);}
if(cs[12]){存(qun, "hongbao","1");}else{存(qun, "hongbao",null);}
if(cs[13]){存(qun, "wenan","1");}else{存(qun, "wenan",null);}
if(cs[14]){存(qun, "zzsg","1");}else{存(qun, "zzsg",null);}
if(cs[15]){存(qun, "touxiang","1");}else{存(qun, "touxiang",null);}
if(cs[16]){存(qun, "fayan","1");}else{存(qun, "fayan",null);}
if(cs[17]){存(MyUin, "艾特回复开关","1");}else{存(MyUin, "艾特回复开关",null);}
if(cs[18]){存(MyUin, "艾特禁言开关","1");}else{存(MyUin, "艾特禁言开关",null);}
if(cs[19]){存(qun, "撤回链接","1");}else{存(qun, "撤回链接",null);}
if(cs[20]){存(qun, "撤回卡片","1");}else{存(qun, "撤回卡片",null);}
if(cs[21]){存(qun, "撤回语音","1");}else{存(qun, "撤回语音",null);}
if(cs[22]){存(qun, "撤回图片","1");}else{存(qun, "撤回图片",null);}
if(cs[23]){存(MyUin, "图片外显","1");}else{存(MyUin, "图片外显",null);}
if(cs[24]){存(qun, "查询系统","1");}else{存(qun, "查询系统",null);}
if(cs[25]){存(qun, "天气系统","1");}else{存(qun, "天气系统",null);}
if(cs[26]){存(qun, "福利功能","1");}else{存(qun, "福利功能",null);}
if(cs[27]){存(MyUin, "撤回自身","1");}else{存(MyUin, "撤回自身",null);}
if(cs[28]){存(qun, "刷听歌","1");}else{存(qun, "刷听歌",null);}
}