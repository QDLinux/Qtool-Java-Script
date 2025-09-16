String QsQQ=null;
public void zl_chaQ(Object msg,String mc,String mg,String mu,String mn){
    if(Lshost.contains(mu)){
        if(mc.equals("开启查询")){
            if(开关.读("查询",mg)==1){
                toast(repeat_+"查询",1500);
            }else{
                开关.写("查询",mg,1);
                toast(repeat_t+"查询",1500);
            }
        }if(mc.equals("关闭查询")){
            if(开关.读("查询",mg)==0){
                toast(_repeat+"查询",1500);
            }else{
                开关.写("查询",mg,0);
                toast(t_repeat+"查询",1500);
            }
        }if(mc.equals("开启战力")){
            if(开关.读("战力",mg)==0){
                toast(repeat_+"战力",1500);
            }else{
                开关.写("战力",mg,0);
                toast(repeat_t+"战力",1500);
            }
        }if(mc.equals("关闭战力")){
            if(开关.读("战力",mg)==1){
                toast(_repeat+"战力",1500);
            }else{
                开关.写("战力",mg,1);
                toast(t_repeat+"战力",1500);
            }
        }if(mc.equals("开启天气")){
            if(开关.读("天气",mg)==0){
                toast(repeat_+"天气",1500);
            }else{
                开关.写("天气",mg,0);
                toast(repeat_t+"天气",1500);
            }
        }if(mc.equals("关闭天气")){
            if(开关.读("天气",mg)==1){
                toast(_repeat+"天气",1500);
            }else{
                开关.写("天气",mg,1);
                toast(t_repeat+"天气",1500);
            }
        }
    }if((开关.读("查询",mg)==1)||!msg.IsGroup&&开关.读("私聊","开关")==1){
        if(mc.startsWith("查Q")||mc.startsWith("查q")||mc.startsWith("查询")&&6<mc.length()&&mc.length()<13){
            long t1 =System.currentTimeMillis();
            String Q= mc.substring(2);
            撤回(msg);
            if(Q.equals("")||Q.contains("97162715")||Q.equals(mQQ)){
                return;
            }Q=Q.replaceAll("[^[0-9]{5,10}]","");
            if(!Q.matches("^[0-9]{5,10}$")){
                return;
            }文字(msg,"@"+mn+"\n请稍等几秒...\n私亻言 查丩攵");
            new Thread(new Runnable(){
                public void run(){
                    try{
                        String a=头像(Q,2);
                        //String b=Qs.QID(Q);
                        String c=Qs.访客(Q);
                        //String d=Qs.电脑(Q);
                        String e=Qs.信息(Q);
                        String f=Qs.综合(Q);
                        //String s=Qs.实名(Q);
                        //String j=Qs.空间(Q);
                        String tal="Q Q："+Q+"\n"+e+"\n"+c+"\n"+f;
                        long t2 =System.currentTimeMillis();
                        String t12=(t2-t1)/1000+"秒";
                        //String tis="查询完毕\n私聊已发送！\n耗时："+t12;
                        send(mg,mu,Qs.头像(Q,1),2);
                        //文字(msg,"@"+mn+a+tis);
                        send(mg,mu,tal+"\n耗时："+t12,1);
                    }catch(Exception e){
                        toast("查Q错误："+e,1500);
                    }
                }
            }).start();
        }if(mc.startsWith("查头像")&&7<mc.length()&&mc.length()<14){
            String Q= mc.substring(3);
            if(Q.equals("")){
                return;
            }Q=Q.replaceAll("[^[0-9]{5,10}]","");
            if(!Q.matches("^[0-9]{5,10}$")){
                return;
            }String a=Qs.头像(Q,1);
            图片(msg,a);
        }if(mc.startsWith("反查")&&mc.length()==13){
            long t1 =System.currentTimeMillis();
            String sQ= mc.substring(2);
            if(!sQ.substring(0,1).equals("1")||sQ.contains("8705929"))return;
            String aa=Qs.反查(sQ);
            String Q=QsQQ;
            new Thread(new Runnable(){
                public void run(){
                    try{
                        if(Q.equals("")){
                            回复(msg,Qs.归属(sQ));
                            return;
                        }if(Q.contains("404")){
                            回复(msg,aa);
                        }else{
                            QsQQ="";
                            文字(msg,"@"+mn+"请稍等几秒...");
                            String a=Qs.头像(Q,2);
                            //String b=Qs.QID(Q);
                            String c=Qs.访客(Q);
                            //String d=Qs.电脑(Q);
                            String e=Qs.信息(Q);
                            String f=aa;
                            //String s=Qs.实名(Q);
                            //String j=Qs.空间(Q);
                            String tal="手机："+sQ+"\n"+e+"\n"+c+"\n"+f;
                            long t2 =System.currentTimeMillis();
                            String t12=(t2-t1)/1000+"秒";
                            String tis="查询完毕\n私聊已发送！\n耗时："+t12;
                            send(mg,mu,Qs.头像(Q,1),2);
                            文字(msg,"@"+mn+"[PicUrl="+a+"]"+tis);
                            send(mg,mu,tal,1);
                        }
                    }catch(Exception e){
                        toast("反查错误："+e,1500);
                    }
                }
            }).start();
        }if(mc.startsWith("查电脑")&&7<mc.length()&&mc.length()<14){
            String Q= mc.substring(3);
            if(Q.equals("")){
                return;
            }Q=Q.replaceAll("[^[0-9]{5,10}]","");
            if(!Q.matches("^[0-9]{5,10}$")){
                return;
            }String a=头像(Q,2)+Qs.电脑(Q);
            回复(msg,a);
        }if(mc.startsWith("查资料")&&7<mc.length()&&mc.length()<14){
            String Q= mc.substring(3);
            if(Q.equals("")){
                return;
            }Q=Q.replaceAll("[^[0-9]{5,10}]","");
            if(!Q.matches("^[0-9]{5,10}$")){
                return;
            }String a=Qs.信息(Q);
            回复(msg,头像(Q,2)+a);
        }if(mc.startsWith("查访客")&&7<mc.length()&&mc.length()<14){
            String Q= mc.substring(3);
            if(Q.equals("")){
                return;
            }Q=Q.replaceAll("[^[0-9]{5,10}]","");
            if(!Q.matches("^[0-9]{5,10}$")){
                return;
            }String a=Qs.访客(Q);
            回复(msg,头像(Q,2)+a);
        }/* if(mc.startsWith("查手机")&&7<mc.length()&&mc.length()<14){
            String Q= mc.substring(3);
            if(Q.equals("")||Q.contains("97162715")){
                return;
            }Q=Q.replaceAll("[^[0-9]{5,10}]","");
            if(!Q.matches("^[0-9]{5,10}$")){
                return;
            }String a=Qs.Q绑(Q);
            回复(msg,a);
        }*/
        if(mc.startsWith("QQ估价")||mc.startsWith("qq估价")&&mc.length()<15){
            String Q= mc.substring(4);
            if(Q.equals("")){
                Q=mu;
            }String a=Qs.估价(Q);
            图片(msg,a);
        }
    }if(mc.endsWith("战力")&&mc.length()<7&&2<mc.length()){
        if(开关.读("战力",mg)==1)return;
        String uin = mc.substring(0,mc.length()-2);
        uin = uin.replace("查询","").replace("奶妈","蔡文姬");
        uin = uin.replace("猴子","孙悟空").replace("老虎","裴擒虎").replace("武藏","").replace("爹","").replace("的","");
        try{
            String url="https://www.sapi.run/hero/select.php?hero=";
            String zl = http.get(url+uin+"&type=qq");
            String wxzl = http.get(url+uin+"&type=wx");
            JSONObject xl =new JSONObject(zl);
            JSONObject wxxl =new JSONObject(wxzl);
            String code = xl.getString("code");
            if(code.equals("400")){
                回复(msg,"没有该英雄战力信息");
                return;
            }if(code.equals("200")){
                xl = xl.getJSONObject("data");
                xb = xl.getString("area");
                xbf = xl.getString("areaPower");
                sb = xl.getString("city");
                sbf = xl.getString("cityPower");
                ssb = xl.getString("province");
                ssbf = xl.getString("provincePower");
                gxtime = xl.getString("updatetime");
                wxxl = wxxl.getJSONObject("data");
                wxb = wxxl.getString("area");
                wxbf = wxxl.getString("areaPower");
                wsb = wxxl.getString("city");
                wsbf = wxxl.getString("cityPower");
                wssb = wxxl.getString("province");
                wssbf = wxxl.getString("provincePower");
                wgxtime = wxxl.getString("updatetime");
                String zll = "";
                zll = zll+"┏┅┅┅Q Q区┅┅┅┅☆\n";
                zll = zll+"  县分:"+xbf+"  "+"地区:"+ xb+"\n";
                zll = zll+"  市分:"+sbf+"  "+"地区:"+sb +"\n";
                zll = zll+"  省分:"+ssbf+"  "+"地区:"+ssb+"\n";
                zll = zll+"  更新:"+gxtime+"\n";
                zll = zll+"┗┅┅┅┅┅┅┅┅┅┅┛\n";
                wzll = zll +"┏┅┅┅W X区┅┅┅┅☆\n";
                wzll = wzll+"  县分:"+wxbf+"  "+"地区:"+ wxb+"\n";
                wzll = wzll+"  市分:"+wsbf+"  "+"地区:"+ wsb +"\n";
                wzll = wzll+"  省分:"+wssbf+"  "+"地区:"+wssb+"\n";
                wzll = wzll+"  更新:"+wgxtime+"\n";
                wzll = wzll+"┗┅┅┅┅┅┅┅┅┅┅┛";
                回复(msg,wzll);
                return;
            }
        }catch(Exception e){
            回复(msg,"战力"+Api_404);
        }
    }String tianqi="天气";
    if(mc.startsWith(tianqi)||mc.endsWith(tianqi)&&!mc.startsWith("小爱")&&2<mc.length()&&mc.length()<11&&!mc.contains("我的")){
        if(开关.读(tianqi,mg)==1)return;
        JSONObject a=new JSONObject(http.xiaoai(mc));
        String tts=a.get("directive").get("url");
        语音(msg,tts);
    }
}public msgArr(String txt,int x){
    String si = "";
    String n = "\n";
    int a = txt.length();
    if(x < a){
        String s1 = txt.substring(0,x);
        String s2 = txt.substring(x);
        si = s1 + msgArr(s2,x);
    }else{
        si = txt;
    }return n + si;
}public class strQQport{
    public 估价(String strQQ){
        String api="https://c.51240.com/temp/qqjiazhi/";
        if(!strQQ.matches("^[0-9]{5,10}$")){
            return;
        }else{
            return api+strQQ;
        }
    }public nick(String mu){
        if(!mu.matches("^[0-9]{5,10}$")){
            return "账号不正确";
        }String data=http_get("https://r.qzone.qq.com/fcg-bin/cgi_get_portrait.fcg?g_tk=1518561325&uins="+mu).split("\"")[5];
        return data;
    }public 访客(String strQQ){
        String url="https://h5.qzone.qq.com/p/r/cgi-bin/qzone_dynamic_v7.cgi?uin="+strQQ+"&param=848&format=json";
        try{
            String b= http.get(url).replace("\n","");
            String day=b.substring(b.indexOf("{\"mod\":0,"),b.indexOf(",{\"mod\":8,"));
            JSONObject dt=new JSONObject(day);
            String x=dt.getString("todaycount");
            String z=dt.getString("totalcount");
            String data="访客："+z+"| "+x;
            return data;
        }catch(Exception e){
            return "访客：禁止访问";
        }
    }public 头像(String strQQ,int n){
        String c ="";
        String Q=strQQ+"&spec=";
        String a="https://q.qlogo.cn/headimg_dl?dst_uin=";
        try{
            if(n==0){
                c="140";
            }else if(n==1){
                c="640";
            }else if(n==2){
                c="100";
            }else if(n==3){
                c="40";
            }else if(n!=0||n!=1||n!=2||n!=3){
                c="640";
            }return a+Q+c;
        }catch(Exception e){
            return a+Q+"640";
        }
    }public 信息(String qq){
        try{
            long gtk=GetGTK(Pskey_kj);
            String cookie="p_uin=o0"+mQQ+";skey="+Skey+";p_skey="+Pskey_kj;
            String j=httpget("https://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin="+qq+"&remark=0&g_tk="+gtk,cookie).replace("_Callback(","").replace("});","}");
            JSONObject js=new JSONObject(j);
            String nick="昵称："+js.optString("nickname");
            String xb="\n性别："+js.optString("gender").replace("1","男").replace("2","女");
            String vip="\n      𝙑𝙄𝙋："+js.optString("qqvip");
            String lz="\n      绿钻："+js.optString("greenvip");
            String tx="\n      腾视："+js.optString("bluevip");
            String fr= "\n      居住："+js.optString("from");
            if(xb.length()==4)xb="";
            if(vip.length()==14)vip="";
            if(lz.length()==10)lz="";
            if(tx.length()==10)tx="";
            if(fr.length()==10)fr="";
            String ta=nick+xb;
            String tal="\n业务等级"+vip+lz+tx;
            if(tal.length()==5)tal="";
            String tals=ta+tal+fr;
            return tals;
        }catch(e){
            return "信息：接口异常";
        }
    }public 电脑(String strQQ){
        try{
            String url=http.get("http://api.weboss.hk/qqol/api.php?qq="+strQQ);
            JSONObject d=new JSONObject(url);
            String code=d.getString("code");
            if(code.equals("20")){
                return "电脑：离线";
            }else{
                return "电脑：在线";
            }
        }catch(Exception e){
            return "电脑："+Api_404;
        }
    }/* public 综合(String strQQ){
        try{
            String api="http://cxx.yun7.me/qqcx?qq=";
            JSONObject Q = new JSONObject(http.get(api+strQQ));
            if(Q.getString("status").equals("200")){
                String a=Q.getString("phone");
                String b=Q.getString("phonediqu").replace("中国","");
                String c=Q.getString("lol");
                return "手机："+a+"\n地区："+b+"\nLOL ："+c;
            }else{
                return "手机：没有找到";
            }
        }catch(e){
            return "手机：接口异常";
        }
    }public 综合(String qq){
        try{
            String s="手机：没有找到";
            String data=http.post("http://chaqbang.com","number="+qq);
            int a=data.lastIndexOf("-output");
            String msg=data.substring(a+10,a+24).replace("电话号","手机：");
            if(msg.contains("html"))return s;
            else return msg;
        }catch(e){
            return "手机："+Api_404;
        }
    }*/
    public 综合(String qq){
        try{
            JSONObject json=new JSONObject(http.get("https://zy.xywlapi.cc/qqapi?qq="+qq));
            JSONObject json2=new JSONObject(http.get("https://zy.xywlapi.cc/qqlol?qq="+qq));
            if(json.get("status")==200&&json2.get("status")==200){
                String a=json.getString("phone");
                String b=json.getString("phonediqu");
                String c=json2.getString("name")+"("+json2.getStrimg("daqu")+")";
                JSONObject json3=new JSONObject(http.get("https://zy.xywlapi.cc/wbphone?phone="+a));
                if(json3.get("status")==200)return "手机："+a+"\n地区："+b+"\nLOL ："+c+"\n微博："+json3.getString("id");
                return "手机："+a+"\n地区："+b+"\nLOL ："+c+"\n微博：查询失败("+json3.getString("message")+")";
            }return "手机：没有找到";
        }catch(e){
            return "手机：接口异常"+e;
        }
    }/* public 反查(String h){
        try{
            String api="https://cxx.yun7.me/qqxc?phone=";
            JSONObject Q = new JSONObject(http.get(api+h));
            if(Q.getString("status").equals("200")){
                String a=Q.getString("qq");
                if(!a.contains("没")){
                    QsQQ=a;
                }else{
                    QsQQ="";
                }String b=Q.getString("phonediqu").replace("中国","");
                String c=Q.getString("lol");
                return "Q Q ："+a+"\n地区："+b+"\nLOL ："+c;
            }else if(Q.getString("status").equals("500")){
                QsQQ="";
                return "未查询到";
            }
        }catch(e){
            QsQQ="";
            return "反查：接口异常";
        }
    }*/
    public 反查(String qb){
        try{
            JSONObject json=new JSONObject(http.get("https://api.xywlapi.cc/qqphone?phone="+qb));
            if(json.get("status")==200){
                QsQQ=qb;
                String a=json.getString("qq");
                String b=json.getString("phonediqu");
                return "Q Q ："+a+"\n地区："+b;
            }else{
                QsQQ="";
                return "QQ：没有找到";
            }
        }catch(e){
            QsQQ="404";
            return "反查："+Api_404;
        }
    }public 归属(String h){
        try{
            String api="https://api.vvhan.com/api/phone?tel=";
            JSONObject g= new JSONObject(http.get(api+h));
            if(g.getString("success").equals("true")){
                JSONObject j= g.getJSONObject("info");
                String gs=j.get("local");
                String type=j.get("type");
                String yys=j.get("yys");
                String bz=j.get("bz");
                String tip="此号未泄露绑定QQ\n";
                String tal=tip+ "地区："+gs+"\n卡型："+type+"\n标志："+bz;
                return tal;
            }else{
                return "未查询到任何数据";
            }
        }catch(e){
            return "反查未查询到\n归属地异常";
        }
    }public 空间(String Q){
        Q=Q.replaceAll("[^[0-9]{5,10}]","");
        String k="空间：\nhttp://"+Q+".qzone.qq.com";
        return k;
    }
}strQQport Qs = new strQQport();
public 头像(String strQQ,int n){
    String c ="";
    String Q=strQQ+"&spec=";
    String a="https://q.qlogo.cn/headimg_dl?dst_uin=";
    try{
        if(n==0){
            c="140";
        }else if(n==1){
            c="640";
        }else if(n==2){
            c="100";
        }else if(n==3){
            c="40";
        }else{
            c="640";
        }return "[PicUrl="+a+Q+c+"]";
    }catch(Exception e){
        return "[PicUrl="+a+Q+"640]";
    }
}public msgArrs(String txt,String qian,String ho,int x){
    String si = "";
    String n = "\n";
    String txt=txt.replace("\\n","±±");
    String[] Txt=txt.split("±±");
    for(int i=0;i<Txt.length;i++){
        int a = Txt[i].length();
        if(x <= a){
            String s1 = Txt[i].substring(0,x)+ho;
            String s2 = Txt[i].substring(x);
            si = s1 + msgArrs(s2,qian,ho,x);
        }else{
            si = Txt[i];
        }
    }return n + qian + si;
}public long GetGTK(String pskey){
    int hash = 5381;
    for (int i = 0, len = pskey.length();
    i < len;
    i++){
        hash +=(hash << 5)+(int)(char)pskey.charAt(i);
    }return hash & 0x7fffffff;
}
