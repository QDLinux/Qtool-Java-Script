public void 抽奖(Object data){
String 如=data.MessageContent;
String qun=data.GroupUin;
String qq=data.UserUin;
public String zr(String qun,String qq,String pd,String qq2,String jykzr)
{
int jykzr2=Integer.parseInt(jykzr);
String tu=取(qun,pd+qq2)+"";
String tu2=取(qun,pd+qq)+"";
zrz=tu.replace("null","0");
bzrz=tu2.replace("null","0");
int kdo=Integer.parseInt(zrz);//转让者现在
int kdo2=Integer.parseInt(bzrz);//被转让者现在的
if(jykzr2>kdo)
{
return"QQ"+qq2+"\n你目前的卡"+kdo+"<"+jykzr+"\n无法转让";
}
int nd=kdo-jykzr2;//转让后的
int nd2=kdo2+jykzr2;
存(qun,pd+qq2,""+nd);//转让者转让后的
存(qun,pd+qq,""+nd2);//被转让者后的
return "[AtQQ="+qq2+"]\n转让成功";
}
if("1".equals(取(qun,"kg")))
{
if(如.startsWith("抽奖菜单"))
{
if(取(qun,"cjxt")==null){
sendm("2",qun,"还没有开启，主人或代管发送\"开启抽奖\"开启");
}
}
if("1".equals(取(qun,"cjxt")))
{
if(取(qun,"xz")==null){qx=qq;}else{qx=MyUin+","+read(AppPath+"/从云/"+qun+"/代管.txt");}if(qx.contains(qq)){
if(如.equals("抽奖"))
{
CT=data.SenderNickName;
uin2=qq;
if(Math.random()<0.2){
sendm("2",qun,"[AtQQ="+qq+"]\n你抽到了禁言卡\n发送\"禁言@xx\"即可禁言");
if(取(qun,"jyk"+qq)==null)
{
存(qun,"jyk"+qq,"1");
}else{
int str2=Integer.parseInt(取(qun,"jyk"+qq))+1;
存(qun,"jyk"+qq,""+str2);
}
return;
}
if(Math.random()<0.2){
sendm("2",qun,"[AtQQ="+qq+"]\n你抽到了免禁言卡\n下次别人禁言你时候将免掉");
if(取(qun,"mjyk"+qq)==null)
{
存(qun,"mjyk"+qq,"1");
}else{
int str2=Integer.parseInt(取(qun,"mjyk"+qq))+1;
存(qun,"mjyk"+qq,""+str2);
}
return;
}
if(Math.random()<0.2){
sendm("2",qun,"[AtQQ="+qq+"]\n你抽到了解禁卡\n发送\"解禁@xx\"即可解除禁言");
if(取(qun,"jjk"+qq)==null)
{
存(qun,"jjk"+qq,"1");
}else{
int str2=Integer.parseInt(取(qun,"jjk"+qq))+1;
存(qun,"jjk"+qq,""+str2);
}
return;
}
if(Math.random()<0.4){
int miao= (int)(Math.random()*100+50);
Forbidden(qun,qq,miao);
sendm("2",qun,"[AtQQ="+qq+"]\n你在抽奖路上被打劫了\n需要"+miao+"秒才可以继续");
return;
}
sendm("2",qun,"[AtQQ="+qq+"]\n你什么也没有抽到");
}
if(如.startsWith("解禁@"))
{
if(取(qun,"jjk"+qq)==null)
{
sendm("2",qun,"[AtQQ="+qq+"]\n你没有解禁卡\n发\"抽奖\"即可\n或者\n购买解禁卡+张");
return;
}
int str2=Integer.parseInt(取(qun,"jjk"+qq));
if(str2<=0)
{
sendm("2",qun,"[AtQQ="+qq+"]\n你没有解禁卡\n发\"抽奖\"即可\n或者\n购买解禁卡+张");
return;
}
for(String tex: data.mAtList)
{
int str2=Integer.parseInt(取(qun,"jjk"+qq));
int str3=str2-1;
存(qun,"jjk"+qq,""+str3);
Forbidden(qun,tex,0);
sendm("2",qun,"["+tex+"]\n解禁成功");
}
}
if(如.startsWith("禁言@"))
{
if(取(qun,"jyk"+qq)==null)
{
sendm("2",qun,"[AtQQ="+qq+"]\n你没有禁言卡\n发\"抽奖\"即可\n或者\n购买禁言卡+张");
return;
}
int str2=Integer.parseInt(取(qun,"jyk"+qq));
if(str2<=0)
{
sendm("2",qun,"[AtQQ="+qq+"]\n你没有禁言卡\n发\"抽奖\"即可或者\n购买禁言卡+张");
return;
}

for(String tex: data.mAtList)
{
if(取(qun,"mjyk"+tex)==null){}else {
String m=取(qun,"mjyk"+tex);
int str2=Integer.parseInt(m);
if(str2<=0)
{}else{
int str3=str2-1;
存(qun,"mjyk"+tex,str3+"");
int str4=Integer.parseInt(取(qun,"jyk"+qq));
int str5=str4-1;
存(qun,"jyk"+qq,""+str5);
sendm("1",qun,"由于"+tex+"有免禁言卡,本次禁言无效\n还剩下"+str3+"次");
return;
}
}
if(tex.equals("0"))
{}else{
int str2=Integer.parseInt(取(qun,"jyk"+qq));
int str3=str2-1;
存(qun,"jyk"+qq,""+str3);
int miao= (int)(Math.random()*100+50);
Forbidden(qun,tex,miao);
sendm("2",qun,"QQ"+tex+"已被禁言"+miao+"秒");
}
}
}
if(如.startsWith("转让禁言卡@"))
{
String jykzr = 如.substring(如.lastIndexOf(" ")+1);
for(String tex: data.mAtList)
{
if(tex.equals(qq))
{
sendm("2",qun,"无法对自己转让");
return;
}
if(tex.equals("0"))
{}else{
String ze=zr(qun,tex,"jyk",qq,jykzr);
sendm("1",qun,ze);
}
}
}
if(如.startsWith("购买禁言卡"))
{
try{
String text=如.substring(5);
if(text.equals(""))
{
sendm("2",qun,"请输入张数");
return;
}
float f=Float.parseFloat(text);
if(0>=f)
{
sendm("2",qun,"请输入比0大的数字");
return;
}
float t=f*10f;
String ji=t+"";
je =ji.replace(".0","");
sendPay3(qq,getSkey(),getPskey("tenpay.com"),MyUin,"收款"+f/10,qun,je,text,"1");
sendm("2",qun,"1分钟内有效");
}catch(e){
sendm("2",qun,"请输入纯数字比如\n购买禁言卡1");
}
}
if(如.startsWith("购买解禁卡"))
{
try{
String text=如.substring(5);
if(text.equals(""))
{
sendm("2",qun,"请输入张数");
return;
}
float f=Float.parseFloat(text);
if(0>=f)
{
sendm("2",qun,"请输入比0大的数字");
return;
}
float t=f*10f;
String ji=t+"";
je =ji.replace(".0","");
sendPay3(qq,getSkey(),getPskey("tenpay.com"),MyUin,"收款"+f/10,qun,je,text,"2");
sendm("2",qun,"1分钟内有效");
}catch(e){
sendm("2",qun,"请输入纯数字比如\n购买解禁卡1");
}
}
if(如.startsWith("购买免禁卡"))
{
try{
String text=如.substring(5);
if(text.equals(""))
{
sendm("2",qun,"请输入张数");
return;
}
float f=Float.parseFloat(text);
if(0>=f)
{
sendm("2",qun,"请输入比0大的数字");
return;
}
float t=f*10f;
String ji=t+"";
je =ji.replace(".0","");
sendPay3(qq,getSkey(),getPskey("tenpay.com"),MyUin,"收款"+f/10,qun,je,text,"3");
sendm("2",qun,"1分钟内有效");
}catch(e){
sendm("2",qun,"请输入纯数字比如\n购买免禁卡1");
}
}
if(如.startsWith("转让解禁卡@"))
{
String jykzr = 如.substring(如.lastIndexOf(" ")+1);
for(String tex: data.mAtList)
{
if(tex.equals(qq))
{
sendm("2",qun,"无法对自己转让");
return;
}
if(tex.equals("0"))
{}else{
String ze=zr(qun,tex,"jjk",qq,jykzr);
sendm("1",qun,ze);
}
}
}
if(如.startsWith("转让免禁卡@"))
{
String jykzr = 如.substring(如.lastIndexOf(" ")+1);
for(String tex: data.mAtList)
{
if(tex.equals(qq))
{
sendm("2",qun,"无法对自己转让");
return;
}
if(tex.equals("0"))
{}else{
String ze=zr(qun,tex,"mjyk",qq,jykzr);
sendm("1",qun,ze);
}
}
}
if(如.startsWith("抽奖菜单"))
{
if(取(qun,"cjxt")==null){cjkg="×";}else{cjkg="✓";}
sendm("2",qun,"抽奖\n我的卡\n查看卡@xx\n转让解禁卡@xx +张\n转让禁言卡@xx +张\n转让免禁卡@xx +张\n购买禁言/解禁卡+张\n开启/关闭抽奖("+cjkg+")\n给禁言/解禁/免禁卡@xx +张(代管/主人可用)");
}
if(如.startsWith("查看卡@"))
{
String fa="";
for(String tex: data.mAtList)
{
if(tex.equals("0"))
{}else{
 jyk=取(qun,"jyk"+tex);
 jjk=取(qun,"jjk"+tex);
 mjyk=取(qun,"mjyk"+tex);
 fa+="\n["+tex+"]\n禁言卡:"+jyk+"\n解禁卡:"+jjk+"\n免禁言卡:"+mjyk;
 }
 }
fa=fa.replace("null","0");
sendm("2",qun,fa);
fa="";
}
if(如.startsWith("我的卡"))
{
String jyk=取(qun,"jyk"+qq);
String mjyk=取(qun,"mjyk"+qq);
String jjk=取(qun,"jjk"+qq);
String fa="\n["+qq+"]\n禁言卡:"+jyk+"\n解禁卡:"+jjk+"\n免禁言卡:"+mjyk+"\n发送购买免禁卡/禁言卡/解禁卡+张可以购买";
fa =fa.replace("null","0");
sendm("2",qun,fa);
}
if(qq.equals(MyUin)||read(AppPath+"/从云/"+qun+"/代管.txt").contains(qq)){
if(如.startsWith("给禁言卡@"))
{
for(String tex: data.mAtList)
{
String jykzr = 如.substring(如.lastIndexOf(" ")+1);
存(qun,"jyk"+tex,jykzr);
sendm("2",qun,"给予成功");
}
}
if(如.startsWith("给解禁卡@"))
{
for(String tex: data.mAtList)
{
String jykzr = 如.substring(如.lastIndexOf(" ")+1);
存(qun,"jjk"+tex,jykzr);
sendm("2",qun,"给予成功");
}
}
if(如.startsWith("给免禁卡@"))
{
for(String tex: data.mAtList)
{
String jykzr = 如.substring(如.lastIndexOf(" ")+1);
存(qun,"mjyk"+tex,jykzr);
sendm("2",qun,"给予成功");
}
}
}
}
}
}
}