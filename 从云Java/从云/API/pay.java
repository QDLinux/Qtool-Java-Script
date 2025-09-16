//无心
public String gmk(String qun,String qq,String id,String size)
{
String jyk=取(qun,id+qq);
String jyk=jyk+"";
jyk2=jyk.replace("null","0");
int str2=Integer.parseInt(jyk2);
int str3=Integer.parseInt(size);
int str4=str2+str3;
存(qun,id+qq,str4+"");
}
public void sendPay(String qq,String s,String ps,String mqq,String title,String qun,String money)
{
new java.lang.Thread(new Runnable()
{
public void run()
{
boolean 成功=false;
try{
String payid=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_create.cgi?type=1&memo="+title+"&amount="+money+"&payer_list=[{\"uin\":"+qq+",\"amount\":"+money+"}]&num=1&recv_type=1&group_id="+qun+"&uin="+mqq+"&pskey="+ps+"&skey="+s);
//sendMsg(qun,"",payid);
JSONObject b=new JSONObject(payid);
String id=b.getString("collection_no");
for(int i = 0;i<60;i++)
{
Thread.sleep(1000);
String hj=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_detail.cgi?collection_no="+id+"&uin="+mqq+"&pskey="+ps+"&skey="+s+"&skey_type=2");
if(hj.contains("\"state\":\"2\""))
{
Toastb("QQ"+qq+"支付成功",tt());
小号收费3="true";
成功=true;
break;
}else{
//return "";
}
}
}catch(e){
sendMsg(qun,"","未知错误"+e);}
if(!成功){Toastb("QQ"+qq+"支付失败",tt());}
}}).start();
}

public void sendPay2(String qq,String s,String ps,String mqq,String title,String qun,String money)
{
new java.lang.Thread(new Runnable()
{
public void run()
{
boolean 成功=false;
try{
String payid=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_create.cgi?type=1&memo="+title+"&amount="+money+"&payer_list=[{\"uin\":"+qq+",\"amount\":"+money+"}]&num=1&recv_type=1&group_id="+qun+"&uin="+mqq+"&pskey="+ps+"&skey="+s);
//sendMsg(qun,"",payid);
JSONObject b=new JSONObject(payid);
String id=b.getString("collection_no");
for(int i = 0;i<60;i++)
{
Thread.sleep(1000);
if(小号收费取消.equals(qq))
{
sendMsg(qun,"","("+qq+")取消成功");
//小号收费取消="";
成功=true;
break;
小号收费取消="";
}
String hj=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_detail.cgi?collection_no="+id+"&uin="+mqq+"&pskey="+ps+"&skey="+s+"&skey_type=2");
if(hj.contains("\"state\":\"2\""))
{
sendMsg(qun,"","QQ"+qq+"支付成功");
Forbidden(qun,qq,0);
成功=true;
break;
}else{
//return "";
}
}
}catch(e){
sendMsg(qun,"","未知错误"+e);}
if(!成功){sendMsg(qun,"","QQ"+qq+"支付失败,已请出群聊");
//Forbidden(qun,qq,60*60*24*30);
Kick(qun,qq,false);
}
}}).start();
}
public void sendPay3(String qq,String s,String ps,String mqq,String title,String qun,String money,String size,String pd)
{
new java.lang.Thread(new Runnable()
{
public void run()
{
boolean 成功=false;
try{
String payid=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_create.cgi?type=1&memo="+title+"&amount="+money+"&payer_list=[{\"uin\":"+qq+",\"amount\":"+money+"}]&num=1&recv_type=1&group_id="+qun+"&uin="+mqq+"&pskey="+ps+"&skey="+s);
//sendMsg(qun,"",payid);
JSONObject b=new JSONObject(payid);
String id=b.getString("collection_no");
for(int i = 0;i<60;i++)
{
Thread.sleep(1000);
String hj=get("https://mqq.tenpay.com/cgi-bin/qcollect/qpay_collect_detail.cgi?collection_no="+id+"&uin="+mqq+"&pskey="+ps+"&skey="+s+"&skey_type=2");
if(hj.contains("\"state\":\"2\""))
{
sendMsg(qun,"","QQ"+qq+"支付成功");
if(pd.equals("1"))
{
gmk(qun,qq,"jyk",size);
}else if(pd.equals("2"))
{
gmk(qun,qq,"jjk",size);
}else{
gmk(qun,qq,"mjyk",size);
}
成功=true;
break;
}else{
//return "";
}
}
}catch(e){
sendMsg(qun,"","未知错误"+e);}
if(!成功){sendMsg(qun,"","QQ"+qq+"支付失败");
}
}}).start();
}
