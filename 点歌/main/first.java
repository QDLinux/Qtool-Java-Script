
public Activity GetAct(){
if(index){
return getNowActivity();
}else{
return GetActivity();
}
}
public void load(String path){
String a=path.replace("//","/");
loadJava(a);
}
public void sendImage(Object data,String msg){
if(index){
sendPic(data.contact,msg);
}else{
String qq=data.UserUin;
String qun=data.GroupUin;
if(qun.equals("")){
sendPic("",qq,msg);
}else{
sendPic(qun,"",msg);
}
}
}
public void sendMp3(Object data,String msg){
if(index){
sendPtt(data.contact,msg);
}else{
String qq=data.UserUin;
String qun=data.GroupUin;
if(qun.equals("")){
sendVoice("",qq,msg);
}else{
sendVoice(qun,"",msg);
}
}
}
public void sendMcard(Object data,String msg){
if(index){
sendCard(data.contact,msg);
}else{
String qq=data.UserUin;
String qun=data.GroupUin;
if(qun.equals("")){
sendCard("",qq,msg);
}else{
sendCard(qun,"",msg);
}
}
}
public void sendCont(Object data,String msg){
if(index){
sendMsg(data.contact,msg);
}else{
String qq=data.UserUin;
String qun=data.GroupUin;
if(qun.equals("")){
sendMsg("",qq,msg);
}else{
sendMsg(qun,"",msg);
}
}
}
public void AddItems(String msg,String ff,String id){
if(index){
addItem(msg,ff);
}else{
AddItem(msg,ff,id);
}
}