public void 开关(Object data){
String 如=data.MessageContent;
String qun=data.GroupUin;
if(data.UserUin.equals(MyUin)||judgment(qun,1,data.UserUin)==true){
if("1".equals(取(qun,"kg")))
{
if(如.equals("开启进群欢迎"))
{
if("1".equals(取(qun,"jqhy")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "jqhy", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭进群欢迎"))
{
if(取(qun,"jqhy")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "jqhy", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启入群链接检测"))
{
if("1".equals(取(qun,"ljjc")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "ljjc", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭入群链接检测"))
{
if(取(qun,"ljjc")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "ljjc", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启音乐卡片检测"))
{
if("1".equals(取(qun,"yykp")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "yykp", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭音乐卡片检测"))
{
if(取(qun,"yykp")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "yykp", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("切换等级1"))
{
if(取("xh","sf")==null)
{
sendm("2",qun,"已经是1了");
}else{
存("xh", "sf", null);
sendm("2",qun,"已切换1");
}
}
if(如.equals("切换等级2"))
{
if("1".equals(取("xh","sf")))
{
sendm("2",qun,"已经是2了");
}else{
存("xh", "sf", "1");
sendm("2",qun,"已切换");
}
}

if(如.equals("开启图片模式"))
{
if("2".equals(取(qun,"图文")))
{
sendm("2",qun,"你已经开启了图文模式，请先关闭");
return;
}
if("3".equals(取(qun,"图文")))
{
sendm("2",qun,"你已经开启了卡片模式，请先关闭");
return;
}
if("1".equals(取(qun,"图文")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "图文", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭图片模式"))
{
if(取(qun,"图文")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "图文", null);
sendm("2",qun,"已关闭");
}
}

if(如.equals("开启图文模式"))
{
if("1".equals(取(qun,"图文")))
{
sendm("2",qun,"你已经开启了图片模式，请先关闭");
return;
}
if("3".equals(取(qun,"图文")))
{
sendm("2",qun,"你已经开启了卡片模式，请先关闭");
return;
}
if("2".equals(取(qun,"图文")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "图文", "2");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭图文模式"))
{
if(取(qun,"图文")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "图文", null);
sendm("2",qun,"已关闭");
}
}


if(如.equals("开启卡片模式"))
{
if("1".equals(取(qun,"图文")))
{
sendm("2",qun,"你已经开启了图片模式，请先关闭");
return;
}
if("2".equals(取(qun,"图文")))
{
sendm("2",qun,"你已经开启了图文模式，请先关闭");
return;
}
if("3".equals(取(qun,"图文")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "图文", "3");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭卡片模式"))
{
if(取(qun,"图文")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "图文", null);
sendm("2",qun,"已关闭");
}
}


if(如.equals("开启验证禁言"))
{
if("1".equals(取(qun,"yzjy")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "yzjy", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭验证禁言"))
{
if(取(qun,"yzjy")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "yzjy", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启扫码"))
{
if("1".equals(取(qun,"扫码")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "扫码", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭扫码"))
{
if(取(qun,"扫码")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "扫码", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启数字炸弹"))
{
if("1".equals(取(qun,"szzd")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "szzd", "1");
sendm("2",qun,"已开启\n发送\"邀请成员@xx\"即可");
}
}
if(如.equals("关闭数字炸弹"))
{
if(取(qun,"szzd")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "szzd", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启退群拉黑"))
{
if("1".equals(取(qun,"tqlh")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "tqlh", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭退群拉黑"))
{
if(取(qun,"tqlh")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "tqlh", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启点歌"))
{
if("11".equals(取(qun,"QQ点歌")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "QQ点歌", "11");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭点歌"))
{
if(取(qun,"QQ点歌")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "QQ点歌", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启小号收费"))
{
if("1".equals(取(qun,"xhsf")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "xhsf", "1");
sendm("2",qun,"已开启\n默认等级:16，金额:0.5\n可到java内修改");
}
}
if(如.equals("关闭小号收费"))
{
if(取(qun,"xhsf")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "xhsf", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启私聊解禁"))
{
if("1".equals(取(qun,"sljj")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "sljj", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭私聊解禁"))
{
if(取(qun,"sljj")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "sljj", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启投票禁言"))
{
if("1".equals(取(qun,"tpjy2")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "tpjy2", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭投票禁言"))
{
if(取(qun,"tpjy2")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "tpjy2", null);
sendm("2",qun,"已关闭");
}
}

if(如.equals("开启抽奖"))
{
if("1".equals(取(qun,"cjxt")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "cjxt", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭抽奖"))
{
if(取(qun,"cjxt")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "cjxt", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启验证踢出"))
{
if("1".equals(取(qun,"yztc")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "yztc", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭验证踢出"))
{
if(取(qun,"yztc")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "yztc", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启进群验证"))
{
if("1".equals(取(qun,"jqyz")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "jqyz", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭进群验证"))
{
if(取(qun,"jqyz")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "jqyz", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启违禁词禁言"))
{
if("1".equals(取(qun,"wjcjy")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "wjcjy", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭违禁词禁言"))
{
if(取(qun,"wjcjy")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "wjcjy", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启违禁词撤回"))
{
if("1".equals(取(qun,"wjcch")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "wjcch", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭违禁词撤回"))
{
if(取(qun,"wjcch")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "wjcch", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启违禁词踢出"))
{
if("1".equals(取(qun,"wjctc")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "wjctc", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭违禁词踢出"))
{
if(取(qun,"wjctc")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "wjctc", null);
sendm("2",qun,"已关闭");
}
}
if(如.startsWith("设置时间"))
{
String text=如.substring(4);
put(AppPath+"/从云/禁言时间.txt",text);
sendm("2",qun,"时间\""+text+"\"分设置成功");
}
if(如.equals("开启头衔"))
{
if("1".equals(取(qun,"tx")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "tx", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭头衔"))
{
if(取(qun,"tx")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "tx", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启检测"))
{
if("1".equals(取(qun,"jc")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "jc", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭检测"))
{
if(取(qun,"jc")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "jc", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启限制"))
{
if("1".equals(取(qun,"xz")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "xz", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭限制"))
{
String text=如.substring(4);
if(text.length() == 0)
{
if(取(qun,"xz")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "xz", null);
sendm("2",qun,"已关闭");
}
}
}
if(如.equals("关闭图片"))
{
if("1".equals(取(qun,"tp")))
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "tp", "1");
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启图片"))
{
if(取(qun,"tp")==null)
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "tp", null);
sendm("2",qun,"已开启");
}
}
if(如.equals("开启字数禁言"))
{
if("1".equals(取(qun,"zsjcjy")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "zsjcjy", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭字数禁言"))
{
if(取(qun,"zsjcjy")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "zsjcjy", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启字数撤回"))
{
if("1".equals(取(qun,"zsjcch")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "zsjcch", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭字数撤回"))
{
if(取(qun,"zsjcch")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "zsjcch", null);
sendm("2",qun,"已关闭");
}
}
if(如.equals("开启字数踢出"))
{
if("1".equals(取(qun,"zsjctc")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "zsjctc", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭字数踢出"))
{
if(取(qun,"zsjctc")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "zsjctc", null);
sendm("2",qun,"已关闭");
}
}

if(如.equals("开启字数检测"))
{
if("1".equals(取(qun,"zskg")))
{
sendm("2",qun,"已经开启了");
}else{
存(qun, "zskg", "1");
sendm("2",qun,"已开启");
}
}
if(如.equals("关闭字数检测"))
{
if(取(qun,"zskg")==null)
{
sendm("2",qun,"已经关闭了");
}else{
存(qun, "zskg", null);
sendm("2",qun,"已关闭");
}
}
}
if(如.equals("开机"))
{
if("1".equals(取(qun,"kg")))
{
sendm("2",qun,"已经开启了");
}else{
String kg=Switch(qun,data.UserUin,getGroupName(qun),"1");
sendm("1",qun,kg);
}
}
if(如.equals("关机"))
{
if(取(qun,"kg")==null)
{
sendm("2",qun,"已经关闭了");
}else{
String kg=Switch(qun,data.UserUin,getGroupName(qun),"12");
sendm("1",qun,kg);
}
}
}
}