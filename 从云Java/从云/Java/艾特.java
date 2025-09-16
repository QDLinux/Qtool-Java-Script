public void 艾特(Object data){
String 如=data.MessageContent;
String qun=data.GroupUin;
String qqh=data.UserUin;
if("1".equals(取(qun,"kg")))
{
if("1".equals(取(qun,"艾特")))
{
if(如.startsWith(""))
{
if(data.MessageType==2||data.MessageType==4||data.MessageType==3||data.MessageType==5||data.MessageType==6) return;
String qxwx=read(AppPath+"/从云/"+qun+"/白名单.txt")+","+read(AppPath+"/从云/全局白名单.txt")+","+read(AppPath+"/从云/"+qun+"/代管.txt")+","+MyUin;
if(qxwx.contains(qqh)) return;
for(String tex: data.mAtList)
{
if(tex.equals(MyUin))
{
String hf=read(AppPath+"/从云/"+qun+"/回复.txt");
if(hf.equals("")){}else{
if("1".equals(取(qun,"atwz2")))
{
hf =hf.replace("[Name]",qqh);
hf =hf.replace("[Group]",qun);
hf =hf.replace("[SendName]",data.SenderNickName);
hf =hf.replace("[At]","[AtQQ="+qqh+"]");
sendMsg(qun,"",hf);
}
}
if("1".equals(取(qun,"atyy2")))
{
if(取(qun,"atyy3")==null)
{
if(判(AppPath+"/从云/"+qun+"/1.mp3").equals("true"))
{
sendVoice(qun,"",AppPath+"/从云/"+qun+"/1.mp3");
}
}else{
sendVoice(qun,"",取(qun,"atyy3"));
}
}
if("1".equals(取(qun,"attp2")))
{
if(取(qun,"attp3")==null){
if(判(AppPath+"/从云/"+qun+"/pic.jpg").equals("true"))
{
sendPic(qun,"",AppPath+"/从云/"+qun+"/pic.jpg");
}
}else{
sendPic(qun,"",取(qun,"attp3"));
}
}
if("1".equals(取(qun,"atjy1")))
{
if(取(qun,"atjy2")==null){}else{
int str2=Integer.parseInt(取(qun,"atjy2"));
Forbidden(qun,qqh,str2*60);
//sendMsg(qun,"",str2+"");
}
}
}
}
}
}
}
}