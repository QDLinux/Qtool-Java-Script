//无心
//2877566722
//群547784622


String[] 头衔违禁词 = {"傻逼","cnm"
};//设置头衔违禁词，上面这个是例子，格式为[违禁词,违禁词]

int jy=60;//设置头衔禁言时间
String[] 白名单 = {"000000"};//设置头衔白名单，格式跟违禁词一样(白名单是直接无视违禁词的)

String[] 黑名单 = {"2877566722"};//设置黑名单(黑名单将直接无法设置头衔)

HashMap TroopMap = new HashMap();
public String GroupOwner(String qun)
{
if(TroopMap.containsKey(qun)) return TroopMap.get(qun);
else{
for(Object group:getGroupList())
	{
    TroopMap.put(group.GroupUin,group.GroupOwner);
	}
	}
	}
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
AddItem("开启/关闭本群自助头衔","zztx",PluginID);
AddItem("开启/关闭本群随机头衔","sjtx",PluginID);
public void zztx(String qun)
{
try{
if(getString(qun,"zizhu").equals("1"))
{
putString(qun, "zizhu", "2");
Toast("已关闭");
}else{
putString(qun, "zizhu", "1");
Toast("已开启");
}
}catch(Exception e){
putString(qun, "zizhu", "1");
Toast("已开启");
}
}
public void sjtx(String qun)
{
try{
if(getString(qun,"sjtx").equals("1"))
{
putString(qun, "sjtx", "2");
Toast("已关闭");
}else{
putString(qun, "sjtx", "1");
Toast("已开启\n发送\"我要随机头衔\"即可");
}
}catch(Exception e){
putString(qun, "sjtx", "1");
Toast("已开启\n发送\"我要随机头衔\"即可");
}
}
public void onMsg(Object data){
if(data.MessageContent.startsWith("我要随机头衔"))
{
try{
if(getString(data.GroupUin,"sjtx").equals("1")){
if(GroupOwner(data.GroupUin).equals(MyUin)){
if(Arrays.asList(黑名单).contains(data.UserUin))
{
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"\n是黑名单，无法设置");
return;
}
String sj=get("https://api.mcloc.cn/words/");
setTitle(data.GroupUin,data.UserUin,sj);
}else{
sendMsg(data.GroupUin,"","QQ"+MyUin+"\n不是本群群主，无法设置头衔");
}
}
}catch(Exception e){}
}
if(data.UserUin.equals(MyUin)){
if(data.MessageContent.startsWith("头衔@"))
{
if(GroupOwner(data.GroupUin).equals(MyUin))
{
String coun = data.MessageContent.substring(data.MessageContent.lastIndexOf(" ")+1);
for(String tex: data.mAtList)
{
setTitle(data.GroupUin,tex,coun);
}
}else{sendMsg(data.GroupUin,"","QQ"+MyUin+"\n不是本群群主，无法设置头衔");}
}
}
try{
if(getString(data.GroupUin,"zizhu").equals("1")){
if(data.MessageContent.startsWith("我要头街"))
{
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"\n是我要头衔(xian)不是我要头街(jie)");
}
if(data.MessageContent.startsWith("我要头衔"))
{
if(GroupOwner(data.GroupUin).equals(MyUin)){
String texl=data.MessageContent.substring(4);
if(Arrays.asList(黑名单).contains(data.UserUin))
{
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"\n是黑名单，无法设置");
return;
}
cb =texl.replace("⁡","");
cd=cb.replace("'","");
cf =cb.replace(" ","");
cg =cf.replace(".","");
ch =cg.replace("•","");
op =ch.replace(",","");
if(data.UserUin.equals(MyUin)||Arrays.asList(白名单).contains(data.UserUin))
{setTitle(data.GroupUin,data.UserUin,texl);
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"白名单\n设置成功");
return;}
for(String u:头衔违禁词){
if(op.contains(u))
{
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"\n头衔有违禁词，无法设置");
revokeMsg(data);
Forbidden(data.GroupUin,data.UserUin,jy);
return;
}
}
if(texl.length() > 10)
{
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"\n头衔字数＞10无法设置");
return;
}
if(texl.equals(""))
{
setTitle(data.GroupUin,data.UserUin,texl);
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"输入内容为空，头衔已被收回");
return;
}
if(texl.contains("")||texl.contains("ĕ"))
{
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"头衔带有小表情，换个头衔吧");
return;
}
if(texl.contains("代挂"))
{
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"\n头衔包含代挂，无法设置");
return;
}
if(texl.contains("http")||texl.contains(".com")||texl.contains(".cn")||texl.contains("www."))
{
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"\n有网站\n设置失败");
return;
}
else{
setTitle(data.GroupUin,data.UserUin,texl);
sendMsg(data.GroupUin,"","QQ"+data.UserUin+"\n无违规词\n设置成功");
return;
}
}else{sendMsg(data.GroupUin,"","QQ"+MyUin+"\n不是本群群主，无法设置头衔");}
}
}
}catch(Exception e){putString(data.GroupUin, "zizhu", "2");}
}
Toast("加载后先看脚本描述，不然不知道用别怪我");