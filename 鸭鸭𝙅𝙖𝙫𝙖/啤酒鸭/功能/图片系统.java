long setutime=0;
public void zl_tupian(Object msg,String mc,String mg,String mu,long mt){
    if(Lshost.contains(mu)){
        if(mc.equals("开启图片")){
            if(开关.读("图片",mg)==1){
                toast(repeat_+"图片",1500);
            }else{
                开关.写("图片",mg,1);
                toast(repeat_t+"图片",1500);
            }
        }if(mc.equals("关闭图片")){
            if(开关.读("图片",mg)==0){
                toast(_repeat+"图片",1500);
            }else{
                开关.写("图片",mg,0);
                toast(t_repeat+"图片",1500);
            }
        }
    }if(开关.读("图片",mg)==0)return;
    if(mc.startsWith("搜图")){
        try{
            String y=mc.substring(2);
            String t=http.get("https://ovooa.com/API/sgst/api.php?msg="+y+"&type=text");
            回复(msg,"[PicUrl="+t+"]");
        }catch(e){}
    }if(mc.equals("看涩图")||mc.equals("cos图")){
        if(!Lshost.contains(mu)){
            回复(msg,"你不是主人，不给看哦");
        }else{
            String t="";
            try{
                JSONObject a=new JSONObject(http.get("https://ovooa.com/API/cosplay/api.php")).get("data");
                JSONArray j=a.getJSONArray("data");
                //String title=a.getString("Title");
                for(int i=0;i<4;i++){
                    t+="[PicUrl="+j.getString(i)+"]\n";
                }回复(msg,t);
            }catch(e){
                回复(msg,""+e);
            }
        }
    }if(mc.equals("风景图")||mc.equals("看风景")){
        try{
            String api="https://api.vvhan.com/api/view";
            图片(msg,api);
        }catch(e){
            toast("风景图接口失效,请反馈",1600);
        }
    }if(mc.equals("妹子图")||mc.equals("看妹子")){
        String t="";
        try{
            String api="http://ovooa.com/API/meizi/api.php";
            for(int i=0;i<2;i++){
                JSONObject j=new JSONObject(http.get(api));
                String l=j.get("text");
                t+="\n[PicUrl="+l+"]";
            }文字(msg,t);
        }catch(e){
            toast("随机图接口失效,请反馈",1600);
        }
    }if(mc.equals("随机图")||mc.equals("动漫图")){
        String t="";
        try{
            String api="http://ovooa.com/API/dmt/api.php";
            for(int i=0;i<2;i++){
                JSONObject j=new JSONObject(http.get(api));
                String l=j.get("text");
                t+="\n[PicUrl="+l+"]";
            }文字(msg,t);
        }catch(e){
            toast("随机图接口失效,请反馈",1600);
        }
    }
}
