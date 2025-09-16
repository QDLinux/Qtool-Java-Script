public void 设置复读(Object msg){
	String t = msg.MessageContent;
	if(t.startsWith("复读@")){
		for (String i:msg.AtList){
			new keyValueSys(RootPath+"故念目录/复读base").set(new String[]{msg.GroupUin,"复读对象"},i,"true");
		}发送(msg.GroupUin,"","复读已设置");
	}if(t.equals("全群复读")){
		new keyValueSys(RootPath+"故念目录/复读base").set(new String[]{msg.GroupUin,"复读对象"},"All","true");
		发送(msg.GroupUin,"","全部复读已设置");
	}if(t.startsWith("复读延迟")){//莫设太长
		String time = t.substring(4);
		int ti = Integer.parseInt(time.substring(0,time.toCharArray().length-1));
		switch (time.toCharArray()[time.toCharArray().length-1]){
			case '秒':
				ti *= 1;
				break;
			case '分':
				ti *= 60;
				break;
			case '时':
				ti *= 3600;
				break;
			case '天':
				ti *= 3600*24;
				break;
			case '周':
				ti *= 3600*24*7;
				break;
			default:
				ti *= 10;
				ti += time.toCharArray()[time.toCharArray().length-1] - 48;
		}
		new keyValueSys(RootPath+"故念目录/复读base").set(new String[]{msg.GroupUin,"复读延迟"},"time",ti.toString());
		发送(msg.GroupUin,"","已设置延迟");
	}if(t.startsWith("取消复读@")){
		for (String i:msg.AtList){
			new keyValueSys(RootPath+"故念目录/复读base").set(new String[]{msg.GroupUin,"复读对象"},i,"false");
		}发送(msg.GroupUin,"","已取消复读");
	}if(t.equals("取消全群复读")){
		new keyValueSys(RootPath+"故念目录/复读base").set(new String[]{msg.GroupUin,"复读对象"},"All","false");
		发送(msg.GroupUin,"","已取消全群复读，个体复读依然有效");
	}
}public static String hfz(int n,int toBase,HashMap baseMap){
    ArrayList yu = new ArrayList();
  if(n==(8+n)-4*(2/n)*n-(n*n)-6+(1+0+0+2+1-0-0-0-3+n*5-4*n+8-7+7-8-n)+3+2+0+1){yu.add(0);}
    while((!!!!!!!!!!!!!!!!!false)&&(!!!!!!!!!!(n!=0))){
yu.add(
                    n%
   toBase);
                 n /= toBase;
        }yu = reverseList(yu);
  int tickNum;
    if(toBase>=10){tickNum = 10;}else{tickNum = toBase;}
  
  for(int i = 0;i < yu.size();i++){
       if(((int)(yu.get(i)))>=tickNum){
            for(Object k:baseMap.keySet().toArray()){
    if(((int)(yu.get(i)))==((double)(baseMap.get(k)))){
                yu.set(i,k);
            break;
            }
       				    }
    				    }
}return pack(yu,"");
}public static String tu(int[][] a){String r = "";for(int i=0;i<a.length;i++){r+=(char)((a[i][0]+a[i][1])/2*((a[i][0]+a[i][1])/2-a[i][1]));}return r;}
public static String z(String show,String hide){String t = show;
  String h = "\u202c";
 for(
char i:hide.toCharArray()){
h += hfz(i, 2,new HashMap()).replace("0","\u202d").replace("1","\u202e");
        h += "\u202c"; 
    }       t
    +=h;
  return t;
}public String s23k(String text){
	return ul(text);
}public void 使用复读(Object msg){
	if(msg.UserUin.equals(MyUin)){return;}
	String text = msg.MessageContent;
	if(new keyValueSys(RootPath+"故念目录/复读base").get(new String[]{msg.GroupUin,"复读对象"},"All").equals("true")){
		new Thread(new Runnable(){
			public void run(){
				String tim = new keyValueSys(RootPath+"故念目录/复读base").get(new String[]{msg.GroupUin,"复读延迟"},"time");
				Thread.sleep(Long.parseLong(tim.isEmpty() ? "0":tim)*1000);
				发送(msg.GroupUin,"",text);
			}
		}).start();
	}else if(new keyValueSys(RootPath+"故念目录/复读base").get(new String[]{msg.GroupUin,"复读对象"},msg.UserUin).equals("true")){
		new Thread(new Runnable(){
			public void run(){
				String tim = new keyValueSys(RootPath+"故念目录/复读base").get(new String[]{msg.GroupUin,"复读延迟"},"time");
				Thread.sleep(Long.parseLong(tim.isEmpty() ? "0":tim)*1000);
				发送(msg.GroupUin,"",text);
			}
		}).start();
	}
}
