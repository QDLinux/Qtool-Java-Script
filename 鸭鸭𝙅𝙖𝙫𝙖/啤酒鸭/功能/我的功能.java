public void my_功能(Object msg,String mc,String mg,String mu,String[] at){
    if(Lshost.contains(mu)){
        if(mc.equals("开机")){
            if(开关.读(GroF,mg)==1){
                文字(msg,"无需重复开启");
                return;
            }OpenTitle(mg);
            s(msg,KaiJi,KJtype);
        }if(mc.equals("关机")){
            if(开关.读(GroF,mg)==0){
                文字(msg,"无需重复关闭");
                return;
            }CloseTitle(mg);
            s(msg,GuanJi,GJtype);
        }if(mc.equals("开启点赞")){
            开关.写("点赞",1);
            回复(msg,"点赞已开启");
        }if(mc.equals("关闭点赞")){
            开关.写("点赞",0);
            回复(msg,"点赞已关闭");
        }if(mc.equals("开机")){
            OpenTitle(mg);
        }if(mc.equals("关机")){
            CloseTitle(mg);
        }if(mc.startsWith("爬")){
            try{
                String u="http://lkaa.top/API/pa/api.php?QQ=";
                for(String uin:at){
                    String a=u+uin;
                    图片(msg,a);
                }
            }catch(e){
                toast("失败");
            }
        }if(mc.startsWith("丢")){
            try{
                String u="http://lkaa.top/API/diu/api.php?QQ=";
                for(String uin:at){
                    String a=u+uin;
                    图片(msg,a);
                }
            }catch(e){
                toast("失败");
            }
        }if(mc.startsWith("赞")){
            try{
                String u="http://lkaa.top/API/zan/api.php?QQ=";
                for(String uin:at){
                    String a=u+uin;
                    图片(msg,a);
                }
            }catch(e){
                toast("失败");
            }
        }if(mc.startsWith("图片")){
            String a=mc.substring(2);
            if(!a.startsWith("http"))return;
            图片(msg,a);
        }if(!mu.equals(mQQ)){
            if(mc.startsWith("get")){
                try{
                    String url=mc.substring(3);
                    回复(msg,http.get(url));
                }catch(e){
                    Toast(Api_403);
                }
            }if(mc.startsWith("post")){
                try{
                    String[] a=mc.substring(4).split(" ");
                    文字(http.post(a[0],a[1]));
                }catch(e){
                    Toast(Api_403);
                }
            }
        }if(mc.startsWith("闪 ")){
            int type=new Random().nextInt(4)+2000;
            sendArk(mg,mc.substring(2),type);
        }if(mc.startsWith("发-")){
            int x=mc.indexOf(" ");
            int l=Integer.parseInt(mc.substring(2,x));
            if(500<l)return;
            String n=mc.substring(x+1);
            for(int i=0;i<l;i++){
                Thread.sleep(10);
                文字(msg,n);
            }
        }if(mc.startsWith("保存图片")&&15<mc.length()){
            try{
                String a = mc.substring(4).replace("H","h").replace("s:",":");
                if(!a.contains("http")){
                    toast("你输入的不是链接",1500);
                    return;
                }String[] aa = a.split("http");
                File dirt = new File(Root+"数据/图片/");
                if(!dirt.exists()){
                    dirt.mkdir();
                }for (int i = 0;i < aa.length;i++){
                    File[] B = new File(Root+"数据/图片/").listFiles();
                    b = B.length+1;
                    http.SFile("http"+ aa[i],Root + "数据/图片/"+getime()+"--"+b+".png");
                    Toast("保存成功"+b);
                }toast("保存完毕\n路径："+Root+"数据/图片/",1500);
            }catch(e){
                toast("不是图片链接",1500);
            }
        }
    }
}public getime(){
    String Now =(new SimpleDateFormat("MM月dd日 HH:mm:ss")).format(new Date());
    return Now;
}public String encryptKaiser(String orignal,String str,int type){
    long key = Long.parseLong(str);
    char[] chars = orignal.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (char aChar : chars){
        long asciiCode = aChar;
        if(type==1)asciiCode += key;
        if(type==0)asciiCode -= key;
        char result =(char)asciiCode;
        sb.append(result);
    }return sb.toString();
}
