int sz=1000;
int sz2=20000;

String tex="";
String KS="false";
String text="";
int size2=0;
int size3=0;
int over=0;
public void 数字炸弹(Object data){
String 如=data.MessageContent;
String qun=data.GroupUin;
String qq=data.UserUin;
if("1".equals(取(qun,"kg")))
{
if("1".equals(取(qun,"szzd")))
{
if(取(qun,"xz")==null){qx=qq;}else{qx=MyUin+","+read(AppPath+"/从云/"+qun+"/代管.txt");}if(qx.contains(qq)){
if(如.startsWith("邀请成员@"))
{
if(text.contains(qun)){
sendm("2",qun,"已经开始了");
}else{
for(String texu: data.mAtList)
{
tex=tex+","+texu;
}
sendm("2",qun,"邀请成功\n当前QQ\n["+tex+"]\n发送\"开始数字炸弹\"开始");
}
}
if(如.startsWith("开始数字炸弹"))
{
if(tex.equals(""))
{
sendm("2",qun,"还没有邀请人,发送\n邀请成员@xx\n即可\nTips:可以邀请多个人哦比如\n邀请成员@a @b @c");
return;
}
if(size2==0)
{
int size1 = (int) ( sz* Math.random() + sz2);
size2=size1;
sendm("2",qun,"数字炸弹开始\n当前数字\n"+sz+"～"+size1+"\n发送\"我猜+数字\"即可");
KS="true";
}else{
sendm("2",qun,"已经开始了");
}
}
if(tex.contains(qq)){
if(如.startsWith("我猜"))
{
if(KS.equals("false"))
{
sendm("2",qun,"还没有开始，发送\"开始数字炸弹\"开始");
return;
}
try{
String text=如.substring(2);
int str2=Integer.parseInt(text);
if(str2>size2)
{
sendm("2",qun,"你猜的太大了\n请猜比"+size2+"小的");
return;
}
if(str2<sz)
{
sendm("2",qun,"你猜的太小了\n请猜比"+sz+"大的");
return;
}
if(str2==over){
sendm("2",qun,""+qq+"\n你猜对了，恭喜禁言5分钟");
Forbidden(qun,qq,500);
text =text.replace(qun,"");
KS="false";
size2=0;
tex="";
return;
}
int size4=size2-4000;//6000
if(size4>str2)
{
sendm("2",qun,"请不要一来就往过小的数字猜");
return;
}
size2 = (int) ( sz* Math.random()+str2-sz);//1000-数字
over = (int) (sz*Math.random() + size2-sz);//
if(sz>size2)
{
sendm("2",qun,"由于"+size2+"<"+sz+"恭喜禁言5分钟");
Forbidden(qun,qq,300);
text =text.replace(qun,"");
KS="false";
size2=0;
tex="";
return;
}
sendm("2",qun,"下一个数字\n"+sz+"～"+size2+"\n发送\"我猜+数字\"即可");
}catch(e){
sendm("2",qun,"请输入纯数字");
}
}
}
if(qq.equals(MyUin)||read(AppPath+"/从云/"+qun+"/代管.txt").contains(qq)){
if(如.startsWith("结束数字炸弹"))
{
sendm("2",qun,"\n结束成功");
text =text.replace(qun,"");
KS="false";
size2=0;
tex="";
}
}
}
}
}
}