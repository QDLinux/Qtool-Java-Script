public void zl_xiuxian(Object msg,String mc,String mg,String mu,String mn,long mt,int type){
    if(Lshost.contains(mu)){
        if(mc.equals("开启娱乐")){
            if(开关.读("娱乐",mg)==1){
                toast(repeat_+"娱乐",1500);
            }else{
                开关.写("娱乐",mg,1);
                toast(repeat_t+"娱乐",1500);
            }
        }if(mc.equals("关闭娱乐")){
            if(开关.读("娱乐",mg)==0){
                toast(_repeat+"娱乐",1500);
            }else{
                开关.写("娱乐",mg,0);
                toast(t_repeat+"娱乐",1500);
            }
        }
    }if(开关.读("娱乐",mg)==0){
        String sansanj="https://ovooa.com/API/";
        if(mc.startsWith("生成英文")||mc.startsWith("英文")){
            try{
                if(mc.equals("英文")||mc.equals("生成英文")){
                    回复(msg,头像(mu,2)+"如：英文1Java\n1-8种 没序号生成全部");
                    return;
                }String s="";
                int d=2;
                mc=mc.replace("生成","");
                String t=mc.substring(2,mc.length());
                String a=t.substring(0,1);
                if(!a.matches("^[0-9]*$")){
                    if(isChinese(t))t=Fanyi(t);
                    if(t.length()<9)d=3;
                    else if(12<t.length())d=1;
                    for(int i=1;i<9;i++){
                        s+="\n"+i+"."+minia1(t,i);
                    }t="["+t+"]"+s;
                }else{
                    int x=Integer.parseInt(a);
                    t=t.substring(1);
                    if(8<x||x<1)x=1;
                    if(isChinese(t))t=Fanyi(t);
                    t=minia1(t,x);
                    if(t.length()<9)d=3;
                    else if(12<t.length())d=1;
                    if(x==8)t=t+"\n(倒过来看)";
                }文字(msg,头像(mu,d)+t);
            }catch(e){
                e.printStackTrace();
                回复(msg,e+"");
            }
        }if(mc.startsWith("生成遗照")){
            String pic=mc.substring(4);
            if(type==2){}
        }if(mc.equals("我的组成")){
            String u=mn;
            try{
                if(mn.equals(""))u=getnick(mu);
                String api=sansanj+"name/api.php?msg="+u;
                String i=http.get(api);
                JSONObject y=new JSONObject(i);
                String t=y.get("text");
                String a="╔═♡══♡══♡═╗" + msgArrs(t,"  ","",10)+"\n" +"╚═♡══♡══♡═╝";
                回复(msg,a);
            }catch(e){}
        }if(mc.startsWith("超长气泡")){
            //原
            String ck="[PicUrl=http://gchat.qpic.cn/gchatpic_new/0/0-0-541CBCD8302FF70170ECB99F7128197B/0?term=2]";
            try{
                撤回(msg);
                String t=",无法生成";
                String w="\n𝙎𝙑𝙄𝙋点击链接设置哦";
                int k=mc.indexOf(" ");
                if(k==-1){
                    回复(msg,"没有空格,请参考：\n"+ck);
                    return;
                }int x=Integer.parseInt(mc.substring(4,k));
                if(x==0||23<x){
                    回复(msg,"输入有误请参考：\n"+ck);
                    return;
                }String txt=mc.substring(k+1);
                if(57<txt.length()){
                    回复(msg,"内容超长"+t);
                    return;
                }String[] id={"","2271","2551","2514","2516","2493","2494","2464","2465","2428","2427","2426","2351","2319","2320","2321","2232","2239","2240","2276","2275","2274","2273","2272","纯白蕾丝","环游太空","萌系虫虫","折纸","热气球","忍者","香甜西瓜","小小动物","火龙果","海盗船","传送门","浪漫星云","冰淇淋","可爱小动物","紫色梦幻","简约金属","梦幻之红","清新绿色","雨蛙呱呱","颜文字","天使之翼","黑色蕾丝","恶魔之翼"};String url="https://zb.vip.qq.com/collection/aio?diyText="+URLEncoder.encode(txt,"UTF-8")+"&-wv=16778243&id="+id[x]+"&adtag=mvip.gongneng.android.bubble.collection_aio&_preload=1&type=bubble&_wvx=3&adtag=mvip.gongneng.android.bubble.index_dynamic_tab";
                回复(msg,id[x+23]+url+w);
            }catch(e){
                回复(msg,"格式错误，请参考：\n"+ck);
            }
        }if(mc.startsWith("搜索影视")){
            if(mc.length()==4)回复(msg,"请后续输入名称");
            try{
                JSONArray a=new JSONArray(http.get("http://119.29.7.157:7755/ssszz.php?top=10&q="+mc.substring(4).replace(" ","")+"&other_kkk217=%2568%2574%2574%2570%253a%252f%252f%2577%2577%2577%252e%2579%2568%2564%256d%2530%2531%252e%2563%256f%256d&dect=0"));
                MusicMax trv = new MusicMax();
                trv.time = mt;
                trv.type = 20;
                String b="";
                int ii=a.length();
                if(ii==0){
                    回复(msg,"没有搜到哦");
                    return;
                }if(10<ii)ii=10;
                for(int i=0;i<ii;i++){
                    String ll="";
                    String l=a.get(i).getString("lianzaijs");
                    if(l.length()!=0)ll=" "+l+"集--";
                    String n=a.get(i).get("title")+ll+a.get(i).get("area");
                    b+=(i+1)+"."+n+"\n";
                    String url=a.get(i).get("url").replaceAll("\\D","");
                    String thl=a.getJSONObject(i).getString("thumb");
                    trv.min[i]=n;
                    trv.mid[i]=url;
                    trv.mip[i]=thl;
                    trv.mig[i]=l;
                }MusicMap.put(mu,trv);
                回复(msg,b+"发送序号选择");
            }catch(e){
                文字(msg,"发生错误"+e);
            }
        }
    }
}public static boolean isChinese(char c){
    return c >= 0x4E00 && c <= 0x9FA5;
}public static boolean isChinese(String str){
    if(str == null)return false;
    for (char c : str.toCharArray()){
        if(isChinese(c))return true;
    }return false;
}public minia1(String a,int x){
    String[][] M={{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"},{"𝒶","𝒷","𝒸","𝒹","𝑒","𝒻","𝑔","𝒽","𝒾","𝒿","𝓀","𝓁","𝓂","𝓃","𝑜","𝓅","𝓆","𝓇","𝓈","𝓉","𝓊","𝓋","𝓌","𝓍","𝓎","𝓏","𝒜","ℬ","𝒞","𝒟","ℰ","ℱ","𝒢","ℋ","ℐ","𝒥","𝒦","ℒ","ℳ","𝒩","𝒪","𝒫","𝒬","ℛ","𝒮","𝒯","𝒰","𝒱","𝒲","𝒳","𝒴","𝒵"},{"𝓪","𝓫","𝓬","𝓭","𝓮","𝓯","𝓰","𝓱","𝓲","𝓳","𝓴","𝓵","𝓶","𝓷","𝓸","𝓹","𝓺","𝓻","𝓼","𝓽","𝓾","𝓿","𝔀","𝔁","𝔂","𝔃","𝓐","𝓑","𝓒","𝓓","𝓔","𝓕","𝓖","𝓗","𝓘","𝓙","𝓚","𝓛","𝓜","𝓝","𝓞","𝓟","𝓠","𝓡","𝓢","𝓣","𝓤","𝓥","𝓦","𝓧","𝓨","𝓩"},{"𝒂","𝒃","𝒄","𝒅","𝒆","𝒇","𝒈","𝒉","𝒊","𝒋","𝒌","𝒍","𝒎","𝒏","𝒐","𝒑","𝒒","𝒓","𝒔","𝒕","𝒖","𝒗","𝒘","𝒙","𝒚","𝒛","𝑨","𝑩","𝑪","𝑫","𝑬","𝑭","𝑮","𝑯","𝑰","𝑱","𝑲","𝑳","𝑴","𝑵","𝑶","𝑷","𝑸","𝑹","𝑺","𝑻","𝑼","𝑽","𝑾","𝑿","𝒀","𝒁"},{"𝐚","𝐛","𝐜","𝐝","𝐞","𝐟","𝐠","𝐡","𝐢","𝐣","𝐤","𝐥","𝐦","𝐧","𝐨","𝐩","𝐪","𝐫","𝐬","𝐭","𝐮","𝐯","𝐰","𝐱","𝐲","𝐳","𝐀","𝐁","𝐂","𝐃","𝐄","𝐅","𝐆","𝐇","𝐈","𝐉","𝐊","𝐋","𝐌","𝐍","𝐎","𝐏","𝐐","𝐑","𝐒","𝐓","𝐔","𝐕","𝐖","𝐗","𝐘","𝐙"},{"𝘢","𝘣","𝘤","𝘥","𝘦","𝘧","𝘨","𝘩","𝘪","𝘫","𝘬","𝘭","𝘮","𝘯","𝘰","𝘱","𝘲","𝘳","𝘴","𝘵","𝘶","𝘷","𝘸","𝘹","𝘺","𝘻","𝘈","𝘉","𝘊","𝘋","𝘌","𝘍","𝘎","𝘏","𝘐","𝘑","𝘒","𝘓","𝘔","𝘕","𝘖","𝘗","𝘘","𝘙","𝘚","𝘛","𝘜","𝘝","𝘞","𝘟","𝘠","𝘡"},{"𝙖","𝙗","𝙘","𝙙","𝙚","𝙛","𝙜","𝙝","𝙞","𝙟","𝙠","𝙡","𝙢","𝙣","𝙤","𝙥","𝙦","𝙧","𝙨","𝙩","𝙪","𝙫","𝙬","𝙭","𝙮","𝙯","𝘼","𝘽","𝘾","𝘿","𝙀","𝙁","𝙂","𝙃","𝙄","𝙅","𝙆","𝙇","𝙈","𝙉","𝙊","𝙋","𝙌","𝙍","𝙎","𝙏","𝙐","𝙑","𝙒","𝙓","𝙔","𝙕"},{"𝗮","𝗯","𝗰","𝗱","𝗲","𝗳","𝗴","𝗵","𝗶","𝗷","𝗸","𝗹","𝗺","𝗻","𝗼","𝗽","𝗾","𝗿","𝘀","𝘁","𝘂","𝘃","𝘄","𝘅","𝘆","𝘇","𝗔","𝗕","𝗖","𝗗","𝗘","𝗙","𝗚","𝗛","𝗜","𝗝","𝗞","𝗟","𝗠","𝗡","𝗢","𝗣","𝗤","𝗥","𝗦","𝗧","𝗨","𝗩","𝗪","𝗫","𝗬","𝗭"},{"ɐ","⑦","ɔ","⑥","ǝ","ɟ","ƃ","ɥ","ı̣","ɾ","̣ʞ","ן","ɯ","⑧","o","d","b","ɹ","s","ʇ","n","ʌ","ʍ","x","ʎ","z","Ɐ","ꓭ","Ɔ","ꓷ","Ǝ","Ⅎ","ꓨ","H","I","ſ","ꓘ","ꓶ","W","N","O","Ԁ","Ò","ꓤ","S","ꓕ","ꓵ","ꓥ","M","X","⅄","Z"}};for(int i=0;i<52;i++){
        a=a.replace(M[0][i],M[x][i]);
    }a=a.replace("⑧","u").replace("⑦","q").replace("⑥","p");
    if(x==8)a=new StringBuffer(a).reverse().toString();
    return a;
}public 短网址(String url){
    if(url.length()==0){
        return "null";
    }String ur=filterUrl(url);
    String a = http.get("http://api.suowo.cn/api.htm?url="+URLEncoder.encode(ur,"UTF-8")+"&key=60f0a777dac4436d4bed9f64@51c8335f654079007bae8ccc3e9a1517&expireDate=2022-03-31&domain=0");
    return a;
}public Fanyi(String t){
    try{
        String a=http.get("http://fanyi.youdao.com/openapi.do?keyfrom=yfhknnvt&key=457617074&type=data&doctype=json&version=1.1&q="+t);
        String tt=a.split("tion\":\\[\"")[1].split("\"\\]")[0];
        return tt;
    }catch(e){
        return t;
    }
}/*
𝑎𝑏𝑐𝑑𝑒𝑓𝑔ℎ𝑖𝑗𝑘𝑙𝑚𝑛𝑜𝑝𝑞𝑟𝑠𝑡𝑢𝑣𝑤𝑥𝑦𝑧
𝐴𝐵𝐶𝐷𝐸𝐹𝐺𝐻𝐼𝐽𝐾𝐿𝑀𝑁𝑂𝑃𝑄𝑅𝑆𝑇𝑈𝑉𝑊𝑋𝑌𝑍

𝐚𝐛𝐜𝐝𝐞𝐟𝐠𝐡𝐢𝐣𝐤𝐥𝐦𝐧𝐨𝐩𝐪𝐫𝐬𝐭𝐮𝐯𝐰𝐱𝐲𝐳
𝐀𝐁𝐂𝐃𝐄𝐅𝐆𝐇𝐈𝐉𝐊𝐋𝐌𝐍𝐎𝐏𝐐𝐑𝐒𝐓𝐔𝐕𝐖𝐗𝐘𝐙

𝒂𝒃𝒄𝒅𝒆𝒇𝒈𝒉𝒊𝒋𝒌𝒍𝒎𝒏𝒐𝒑𝒒𝒓𝒔𝒕𝒖𝒗𝒘𝒙𝒚𝒛
𝑨𝑩𝑪𝑫𝑬𝑭𝑮𝑯𝑰𝑱𝑲𝑳𝑴𝑵𝑶𝑷𝑸𝑹𝑺𝑻𝑼𝑽𝑾𝑿𝒀𝒁

𝘢𝘣𝘤𝘥𝘦𝘧𝘨𝘩𝘪𝘫𝘬𝘭𝘮𝘯𝘰𝘱𝘲𝘳𝘴𝘵𝘶𝘷𝘸𝘹𝘺𝘻
𝘈𝘉𝘊𝘋𝘌𝘍𝘎𝘏𝘐𝘑𝘒𝘓𝘔𝘕𝘖𝘗𝘘𝘙𝘚𝘛𝘜𝘝𝘞𝘟𝘠𝘡

𝗮𝗯𝗰𝗱𝗲𝗳𝗴𝗵𝗶𝗷𝗸𝗹𝗺𝗻𝗼𝗽𝗾𝗿𝘀𝘁𝘂𝘃𝘄𝘅𝘆𝘇
𝗔𝗕𝗖𝗗𝗘𝗙𝗚𝗛𝗜𝗝𝗞𝗟𝗠𝗡𝗢𝗣𝗤𝗥𝗦𝗧𝗨𝗩𝗪𝗫𝗬𝗭

𝙖𝙗𝙘𝙙𝙚𝙛𝙜𝙝𝙞𝙟𝙠𝙡𝙢𝙣𝙤𝙥𝙦𝙧𝙨𝙩𝙪𝙫𝙬𝙭𝙮𝙯
𝘼𝘽𝘾𝘿𝙀𝙁𝙂𝙃𝙄𝙅𝙆𝙇𝙈𝙉𝙊𝙋𝙌𝙍𝙎𝙏𝙐𝙑𝙒𝙓𝙔𝙕



🄰🄱🄲🄳🄴🄵🄶🄷🄸🄹🄺🄻🄼🄽🄾🄿🅀🅁🅂🅃🅄🅅🅆🅇🅈🅉
🅰🅱🅲🅳🅴🅵🅶🅷🅸🅹🅺🅻🅼🅽🅾🅿🆀🆁🆂🆃🆄🆅🆆🆇🆈🆉

ⓐⓑⓒⓓⓔⓕⓖⓗⓘⓙⓚⓛⓜⓝⓞⓟⓠⓡⓢⓣⓤⓥⓦⓧⓨⓩ
🅐🅑🅒🅓🅔🅕🅖🅗🅘🅙🅚🅛🅜🅝🅞🅟🅠🅡🅢🅣🅤🅥🅦🅧🅨🅩

ɐqɔpǝɟƃɥı̣ɾ̣ʞןɯuodbɹsʇnʌʍxʎz
ⱯꓭƆꓷƎℲꓨHIſꓘꓶWNOԀÒꓤSꓕꓵꓥMX⅄Z

𝒶𝒷𝒸𝒹𝑒𝒻𝑔𝒽𝒾𝒿𝓀𝓁𝓂𝓃𝑜𝓅𝓆𝓇𝓈𝓉𝓊𝓋𝓌𝓍𝓎𝓏
𝒜ℬ𝒞𝒟ℰℱ𝒢ℋℐ𝒥𝒦ℒℳ𝒩𝒪𝒫𝒬ℛ𝒮𝒯𝒰𝒱𝒲𝒳𝒴𝒵
𝓪𝓫𝓬𝓭𝓮𝓯𝓰𝓱𝓲𝓳𝓴𝓵𝓶𝓷𝓸𝓹𝓺𝓻𝓼𝓽𝓾𝓿𝔀𝔁𝔂𝔃
𝓐𝓑𝓒𝓓𝓔𝓕𝓖𝓗𝓘𝓙𝓚𝓛𝓜𝓝𝓞𝓟𝓠𝓡𝓢𝓣𝓤𝓥𝓦𝓧𝓨𝓩

𝔞𝔟𝔠𝔡𝔢𝔣𝔤𝔥𝔦𝔧𝔨𝔩𝔪𝔫𝔬𝔭𝔮𝔯𝔰𝔱𝔲𝔳𝔴𝔵𝔶𝔷
𝔄𝔅ℭ𝔇𝔈𝔉𝔊ℌℑ𝔍𝔎𝔏𝔐𝔑𝔒𝔓𝔔ℜ𝔖𝔗𝔘𝔙𝔚𝔛𝔜ℨ
𝖆𝖇𝖈𝖉𝖊𝖋𝖌𝖍𝖎𝖏𝖐𝖑𝖒𝖓𝖔𝖕𝖖𝖗𝖘𝖙𝖚𝖛𝖜𝖝𝖞𝖟
𝕬𝕭𝕮𝕯𝕰𝕱𝕲𝕳𝕴𝕵𝕶𝕷𝕸𝕹𝕺𝕻𝕼𝕽𝕾𝕿𝖀𝖁𝖂𝖃𝖄𝖅

𝕒𝕓𝕔𝕕𝕖𝕗𝕘𝕙𝕚𝕛𝕜𝕝𝕞𝕟𝕠𝕡𝕢𝕣𝕤𝕥𝕦𝕧𝕨𝕩𝕪𝕫
𝔸𝔹ℂ𝔻𝔼𝔽𝔾ℍ𝕀𝕁𝕂𝕃𝕄ℕ𝕆ℙℚℝ𝕊𝕋𝕌𝕍𝕎𝕏𝕐ℤ

ᴀʙᴄᴅᴇғɢʜɪᴊᴋʟᴍɴᴏᴘǫʀsᴛᴜᴠᴡxʏᴢ
ᴀʙᴄᴅᴇғɢʜɪᴊᴋʟᴍɴᴏᴘǫʀsᴛᴜᴠᴡxʏᴢ

🇦 🇧 🇨 🇩 🇪 🇫 🇬 🇭 🇮 🇯 🇰 🇱 🇲 🇳 🇴 🇵 🇶 🇷 🇸 🇹 🇺 🇻 🇼 🇽 🇾 🇿
*/