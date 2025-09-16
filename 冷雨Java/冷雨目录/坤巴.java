//卑微萌新

import java.util.Calendar;
import java.text.SimpleDateFormat;
public String countdown(String time,String time2)
{

   try
   {
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
    /*天数差*/
      Date fromDate = simpleFormat.parse(simpleFormat.format(calendar.getTime()));
      Date toDate = simpleFormat.parse(time);
     long from = fromDate.getTime();  
    long to = toDate.getTime();  
     int days = (int) ((to - from) / (1000 * 60 * 60 * 24));  
     
     /*小时差*/
     int hours = (int) ((to- from) / (1000 * 60 * 60));
     int hours2=hours-days*24;
     /*分钟差*/
     int minutes = (int) ((to- from) / (1000 * 60));  
     int minutes2=minutes-hours*60;
   //  int sec = (int) ((to2-to) / 1000 );  
     //int sec2=sec-minutes*60;
     String re;
     if(days<0||hours2<0||minutes2<0) 
     {
     Date toDate2 = simpleFormat.parse(time2);
    long to2 = toDate2.getTime();  
     int days3 = (int) ((to2 - from) / (1000 * 60 * 60 * 24));  
     
     /*小时差*/
     int hours3 = (int) ((to2-from) / (1000 * 60 * 60));
     int hours4=hours3-days3*24;
     /*分钟差*/
     int minutes3 = (int) ((to2-from) / (1000 * 60));  
     int minutes4=minutes3-hours3*60;
     if(days3<0||hours4<0||minutes4<0) 
     {
     re="❌已过期:"+Math.abs(days3)+"天"+Math.abs(hours4)+"小时"+Math.abs(minutes4)+"分钟"/*"+sec4+"秒"*/;
     }
     else {
     re="✅已开通:"+Math.abs(days)+"天"+Math.abs(hours2)+"小时"+Math.abs(minutes2)+"分钟"/*"+sec2+"秒"*/+"\n🕗还剩:"+Math.abs(days3)+"天"+Math.abs(hours4)+"小时"+Math.abs(minutes4)+"分钟";
     }
     }
     else re="距离开通还有:"+days+"天"+hours2+"小时"+minutes2+"分钟"/*"+sec2+"秒"*/;
       return re;
   }
   catch (Throwable e)
   {//Toast(e+" ");
   return time+"或"+time2+"\n不是标准时间格式\n"+e;}
}


public Object getbusinesslist(String QQ,String skey)
{
try{
String cookie="uin=o0"+QQ+";skey="+skey;
		JSONObject json = new JSONObject(httpget("https://api.unipay.qq.com/v1/r/1450000172/wechat_query?cmd=7&pfkey=pfkey&openid="+QQ+"&openkey="+skey+"&session_id=uin&session_type=skey",cookie));
		//return json+"";
		int ret=json.get("ret");
		String msg="";
		if(json.has("msg")) msg=json.get("msg");
		//JSONObject data;
		if(ret==0) {
		return json.get("service");
		}
		else return "获取失败,原因:\n"+msg;
		}
catch(Exception e)
            {
                return "获取失败,原因:\n"+e;
            } 
}