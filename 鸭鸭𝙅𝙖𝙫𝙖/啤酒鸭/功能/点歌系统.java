//原创
String StringDJ="/storage/emulated/0/LD_Module/Voice/鸭鸭DJ/";
String StringWY="/storage/emulated/0/LD_Module/Voice/鸭鸭网易云/";
int musicList=2000;
import java.util.regex.*;
HashMap MusicMap = new HashMap();
HashMap TVmap = new HashMap();
ArrayList DJlist=new ArrayList();
public class MusicMax{
    String name;
    long time;
    int type;
    String id;
    String[] mid=new String[musicList];
    String[] mig=new String[musicList];
    String[] min=new String[musicList];
    String[] mip=new String[musicList];
}public class TvMap{
    String name;
    long time;
    int type;
    String pic;
    String[] mid=new String[1200];
}public void zl_diange(Object msg,String mc,String mg,String mu,long mt){
    if(Lshost.contains(mu)){
        if(mc.equals("开启点歌")){
            if(开关.读("点歌",mg)==0){
                toast(repeat_+"点歌",1500);
            }else{
                开关.写("点歌",mg,0);
                toast(repeat_t+"点歌",1500);
            }
        }if(mc.equals("关闭点歌")){
            if(开关.读("点歌",mg)==1){
                toast(_repeat+"点歌",1500);
            }else{
                开关.写("点歌",mg,1);
                toast(t_repeat+"点歌",1500);
            }
        }
    }if(开关.读("点歌",mg)==0){
        if(mc.contains("DJ")&&mc.length()<4){
            try{
                String pt="/storage/emulated/0/LD_Module/Voice/鸭鸭DJ/";
                String wp3=http.get("http://api.miquanbao.com/API/a.php");
                String nm=wp3.substring(wp3.lastIndexOf("/")+1);
                String mp3=pt+nm;
                File ptt=new File(pt);
                if(!ptt.exists())ptt.mkdirs();
                File ptm=new File(mp3);
                boolean ok=true;
                if(!ptm.exists()){
                    ok=http.FFile(wp3,mp3);
                }if(ok){
                    语音(msg,mp3);
                    文字(msg,nm.replace(nm.substring(nm.lastIndexOf(".")),""));
                }
            }catch(e){
                Toast(""+e);
            }
        }if(mc.contains("鸡")&&mc.length()<2){
            try{
                String pt="/storage/emulated/0/LD_Module/Voice/鸭鸭鲲/";
                String wp3=http.get("http://api.miquanbao.com/API/kun.php");
                String nm=wp3.substring(wp3.lastIndexOf("/")+1);
                String mp3=pt+nm;
                File ptt=new File(pt);
                if(!ptt.exists())ptt.mkdirs();
                File ptm=new File(mp3);
                boolean ok=true;
                if(!ptm.exists()){
                    ok=http.FFile(wp3,mp3);
                }if(ok){
                    语音(msg,mp3);
                    文字(msg,nm.replace(nm.substring(nm.lastIndexOf(".")),""));
                }
            }catch(e){
                Toast(""+e);
            }
        }if(mc.contains("网易云")&&mc.length()<6){
            try{
                String pt="/storage/emulated/0/LD_Module/Voice/鸭鸭网易云/";
                String wp3=http.get("http://api.miquanbao.com/API/wyy.php");
                String nm=wp3.substring(wp3.lastIndexOf("/")+1);
                String mp3=pt+nm;
                File ptt=new File(pt);
                if(!ptt.exists())ptt.mkdirs();
                File ptm=new File(mp3);
                boolean ok=true;
                if(!ptm.exists()){
                    ok=http.FFile(wp3,mp3);
                }if(ok){
                    语音(msg,mp3);
                    文字(msg,nm.replace(nm.substring(nm.lastIndexOf(".")),""));
                }
            }catch(e){
                Toast(""+e);
            }
        }/*if(mc.contains("DJ")&&mc.length()<6&&!(mc.startsWith("存")||mc.startsWith("搜")||mc.startsWith("点歌"))){
            try{
                File[] by=new File(StringDJ).listFiles();
                String byd=by[ new Random().nextInt(by.length)].toString();
                语音(msg,byd);
            }catch(e){
                if(new File(StringDJ).listFiles().length==0)回复(msg,"DJ目录为空\n路径："+StringDJ);
            }
        }if(mc.contains("网易")&&mc.length()<6&&!(mc.startsWith("存")||mc.startsWith("搜")||mc.startsWith("点歌"))){
            try{
                File[] by=new File(StringWY).listFiles();
                String byd=by[ new Random().nextInt(by.length)].toString();
                语音(msg,byd);
            }catch(e){
                if(new File(StringWY).listFiles().length==0)回复(msg,"网易云目录为空\n路径："+StringWY);
            }
        }*/
        String music_tip="发送序号选歌";
        if(mc.startsWith("语音点歌")||mc.startsWith("点歌")){
            try{
                String m=mc.substring(mc.indexOf("点歌")+2);
                if(15<m.length()||m.length()==0)return;
                String wjcs="菜单,系统,功能";
                if(wjcs.contains(m))return;
                String url=http.get("http://antiserver.kuwo.cn/anti.s?type=convert_url&rid="+new JSONObject(http.get("http://search.kuwo.cn/r.s?client=kt&pn=0&rn=10&uid=1179647890&ver=kwplayer_ar_9.2.7.1&vipver=1&show_copyright_off=1&newver=1&correct=1&ft=music&cluster=0&strategy=2012&encoding=utf8&rformat=json&vermerge=1&mobi=1&issubtitle=1&all="+m)).get("abslist").get(0).getString("MUSICRID").replace("MUSIC_","")+"&format=aac|mp3&response=url");
                语音(msg,url);
            }catch(e){
                回复(msg,Api_403);
                return;
            }
        }if(mc.startsWith("QQ点歌")||mc.startsWith("qq点歌")){
            String id = mc.substring(4).replace(" ","");
            if(id.equals("")){
                return;
            }else{
                MusicMax musicMax = new MusicMax();
                musicMax.name = id;
                musicMax.time = mt;
                musicMax.type = 1;
                try{
                    String url="https://shc.y.qq.com/soso/fcgi-bin/search_for_qq_cp?_=1642511968971&g_tk=5381&uin=&format=json&inCharset=utf-8&outCharset=utf-8&notice=0&platform=h5&needNewCode=1&w="+id+"&zhidaqu=1&catZhida=1&t=0&flag=1&ie=utf-8&sem=1&aggr=0&perpage=20&n=10&p=1&remoteplace=txt.mqq.all";
                    String bbj="Mozilla/5.0 (Linux; U; Android 11; zh-cn; PEAM00 Build/RP1A.200720.011) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/70.0.3538.80 Mobile Safari/537.36 HeyTapBrowser/40.7.34.1";
                    String c="https://i.y.qq.com/n2/m/";
                    String urll=http.QQget(url,bbj,"https://i.y.qq.com/n2/m/");
                    JSONObject web=new JSONObject(urll);
                    JSONArray b=web.get("data").get("song").get("list");
                    String h="";
                    for(int i=0;i<b.length();
                    i++){
                        JSONObject c=b.get(i);
                        String n1=c.opt("songname");
                        if(n1.length()==0)n1=id;
                        String n2=c.get("singer").get(0).opt("name");
                        musicMax.min[i]=n1;
                        musicMax.mig[i]=n2;
                        musicMax.mid[i]=c.get("songmid");
                        h+=(i+1)+"."+n1+"-"+n2+"\n";
                    }MusicMap.put(mu,musicMax);
                    回复(msg,h+music_tip);
                }catch(e){
                    文字(msg,Api_404+e);
                }
            }
        }if(mc.startsWith("网易云点歌")&&5<mc.length()){
            try{
                String id=mc.substring(5).replace(" ","");
                MusicMax musicMax = new MusicMax();
                musicMax.name = id;
                musicMax.time = mt;
                musicMax.type = 2;
                String h="";
                String b="";
                try{
                    JSONObject js=new JSONObject(http.get("http://music.163.com/api/search/get/web?csrf_token=hlpretag=&hlposttag=&s="+id+"&type=1&offset=0&total=true&limit=10"));
                    JSONArray ja=js.get("result").getJSONArray("songs");
                    for(int i=0;i<ja.length();
                    i++){
                        String a=ja.get(i).getString("id");
                        String b=ja.get(i).get("name");
                        String c=ja.get(i).get("artists").get(0).get("name");
                        h+=(i+1)+"."+b+"—"+c+"\n";
                        musicMax.mid[i]=a;
                        musicMax.min[i]=b;
                        musicMax.mig[i]=c;
                    }
                }catch(e){
                    Toast(e+"");
                    return;
                }回复(msg,h+music_tip);
                MusicMap.put(mu,musicMax);
            }catch(e){
                Toast(e+"");
            }
        }if(mc.startsWith("酷我点歌")&&4<mc.length()){
            try{
                String mname=mc.substring(4).replace(" ","");
                if(mname.equals(""))return;
                MusicMax musicMax = new MusicMax();
                musicMax.name = mname;
                musicMax.time = mt;
                musicMax.type = 3;
                String url="http://search.kuwo.cn/r.s?client=kt&pn=0&rn=10&uid=1179647890&ver=kwplayer_ar_9.2.7.1&vipver=1&show_copyright_off=1&newver=1&correct=1&ft=music&cluster=0&strategy=2012&encoding=utf8&rformat=json&vermerge=1&mobi=1&issubtitle=1&all="+mname;
                JSONObject js=new JSONObject(http.get(url));
                JSONArray ja=js.getJSONArray("abslist");
                String hy="";
                for(int i=0;i<ja.length();
                i++){
                    JSONObject js2=ja.getJSONObject(i);
                    musicMax.mid[i]=js2.getString("MUSICRID").replace("MUSIC_","");
                    String f2=js2.getString("FARTIST").replace("&","");
                    //歌手
                    musicMax.mig[i]=f2;
                    String f3=js2.getString("SONGNAME").replace("&","");
                    //歌名
                    musicMax.min[i]=f3;
                    String b=(i+1)+"."+f3+"--"+f2+"\n";
                    hy+=b;
                }回复(msg,hy+music_tip);
                MusicMap.put(mu,musicMax);
            }catch(e){
                回复(msg,Api_403);
                return;
            }
        }if(mc.startsWith("DJ点歌")||mc.startsWith("dj点歌")){
            String id = mc.substring(4).replace(" ","");
            if(id.equals("")){
                return;
            }else{
                MusicMax musicMax = new MusicMax();
                musicMax.name = id;
                musicMax.time = mt;
                musicMax.type = 4;
                MusicMap.put(mu,musicMax);
                try{
                    JSONObject y=new JSONObject(http.post("http://app.y2002.com/API/Processer.ashx?v=v3","m=v3_f_m&sortway=1&st=0&key="+id+"&flag=2&pi=1&pz=10&uid=10637437&username=t_202006071227364347&ticket=7C25AC41535FC720"));
                    if(y.get("status")){
                        JSONArray ja=y.get("data");
                        String hy="";
                        String[] hard={"http://y2-a-p.qq190.net","http://y2002-img.qq190.net"};for(int i=0;i<ja.length();
                        i++){
                            JSONObject js2=ja.getJSONObject(i);
                            musicMax.mid[i]=hard[0]+js2.getString("songurl");
                            String f2=js2.getString("nickname").replace("&","");
                            //歌手
                            musicMax.min[i]=f2;
                            String f3=js2.getString("songname").replace("&","");
                            //歌名
                            musicMax.mig[i]=f3;
                            musicMax.mip[i]=hard[1]+js2.getString("headpic");
                            String b=(i+1)+"."+f2+"--"+f3+"\n";
                            hy+=b;
                        }回复(msg,hy+music_tip);
                        MusicMap.put(mu,musicMax);
                    }else{
                        回复(msg,Api_403);
                    }
                }catch(e){
                    回复(msg,Api_404+e);
                    return;
                }
            }
        }if(mc.startsWith("酷狗点歌")){
            String id = mc.substring(4).replace(" ","");
            if(id.equals("")){
                return;
            }else{
                MusicMax musicMax = new MusicMax();
                musicMax.name = id;
                musicMax.time = mt;
                musicMax.type = 5;
                MusicMap.put(mu,musicMax);
                try{
                    String api="http://mobilecdn.kugou.com/api/v3/search/song?format=json&keyword=";
                    String apid="&page=0&pagesize=10&showtype=1";
                    JSONArray ja=new JSONObject(http.get(api+id+apid)).get("data").getJSONArray("info");
                    String tal="";
                    for(int i=0;i<ja.length();
                    i++){
                        JSONObject jso=ja.getJSONObject(i);
                        String b=jso.get("songname");
                        String c=jso.get("singername");
                        int d=jso.get("pay_type_320");
                        String ff="(付费)";
                        if(d==0)ff="(免费)";
                        tal+=(i+1)+"."+b+"—"+c+ff+"\n";
                        String a1=jso.get("hash");
                        String a2=jso.get("album_id");
                        musicMax.min[i]=b;
                        musicMax.mig[i]=c;
                        musicMax.mid[i]=a1;
                        musicMax.mip[i]=a2;
                    }回复(msg,tal+music_tip);
                }catch(Exception e){
                    回复(msg,Api_403+e);
                }
            }
        }if(mc.startsWith("铃声多多")||mc.startsWith("铃声点歌")){
            try{
                String a=mc.substring(4).replace(" ","");
                if(a.equals(""))return;
                MusicMax musicMax = new MusicMax();
                musicMax.time = mt;
                musicMax.type = 6;
                musicMax.name =a;
                String web=http.get("http://main.shoujiduoduo.com/ring.php?type=searchwp&keyword="+a+"&page=0&randnum=0.36860401838230716");
                String[] req={"lurl=\"(.*?)\"","name=\"(.*?)\"","artist=\"(.*?)\"","head_url=\"(.*?)\""};Pattern a1=Pattern.compile(req[0]);
                Pattern a2=Pattern.compile(req[1]);
                Pattern a3=Pattern.compile(req[2]);
                Pattern a4=Pattern.compile(req[3]);
                Matcher matcher1=a1.matcher(web);
                Matcher matcher2=a2.matcher(web);
                Matcher matcher3=a3.matcher(web);
                Matcher matcher4=a4.matcher(web);
                String j="";
                String n="";
                String m="";
                String p="";
                while(matcher1.find()){
                    j+="±http://cdnringbd.shoujiduoduo.com"+matcher1.group(1);
                }while(matcher2.find()){
                    n+="±"+matcher2.group(1);
                }while(matcher3.find()){
                    m+="±"+matcher3.group(1);
                }while(matcher4.find()){
                    p+="±"+matcher4.group(1);
                }String[] nl=n.substring(1).split("±");
                String[] jl=j.substring(1).split("±");
                String[] ml=m.substring(1).split("±");
                String[] pl=p.substring(1).split("±");
                int ii=10;
                if(jl.length<10)ii=jl.length;
                String ln="";
                String lj="";
                String lp="";
                for(int i=0;i<ii;i++){
                    musicMax.min[i]=nl[i];
                    musicMax.mig[i]=ml[i];
                    ln+=(i+1)+"."+nl[i]+"--"+ml[i]+"\n";
                }for(int i=0;i<ii;i++){
                    musicMax.mid[i]=jl[i];
                    lj+=(i+1)+"."+jl[i]+"\n";
                }for(int i=0;i<ii;i++){
                    musicMax.mip[i]=pl[i];
                    lp+=(i+1)+"."+pl[i]+"\n";
                }回复(msg,ln+music_tip);
                MusicMap.put(mu,musicMax);
            }catch(e){
                回复(msg,"鸭！未搜到哦~");
            }
        }if(mc.startsWith("咪咕点歌")){
            String a=mc.substring(4).replace(" ","");
            if(a.equals(""))return;
            MusicMax musicMax = new MusicMax();
            musicMax.time = mt;
            musicMax.type = 7;
            musicMax.name =a;
            MusicMap.put(mu,musicMax);
            String jdo=http.get("https://pd.musicapp.migu.cn/MIGUM2.0/v1.0/content/search_all.do?&ua=Android_migu&version=5.0.1&text="+a+"&pageNo=1&pageSize=10&searchSwitch={\"song\":1,\"album\":0,\"singer\":0,\"tagSong\":0,\"mvSong\":0,\"songlist\":0,\"bestShow\":1}").replace("ftp://218.200.160.122:21","http://freetyst.nf.migu.cn");
            JSONArray ja=new JSONObject(jdo).get("songResultData").get("result");
            String tal="";
            try{
                int ii=10;
                if(ja.length()<10)ii=ja.length();
                for(int i=0;i<ii;i++){
                    JSONObject js=ja.get(i);
                    String sis=js.get("name");
                    //歌名
                    JSONArray sing=js.get("singers");
                    String sig="";
                    if(sing.length()!=0)sig=sing.get(0).get("name");
                    //歌手
                    String sif=js.get("imgItems").get(0).get("img");
                    //封面 
                    String sid=js.get("copyrightId");
                    musicMax.mid[i]=sid;
                    musicMax.mip[i]=sif;
                    musicMax.min[i]=sis;
                    musicMax.mig[i]=sig;
                    tal+=(i+1)+"."+sis+"—"+sig+"\n";
                }回复(msg,tal+music_tip);
            }catch(Exception e){
                回复(msg,Api_403+e);
            }
        }
    }if(mc.matches("^[0-9]*$")){
        try{
            int x=Integer.parseInt(mc.replaceAll("\\D",""));
            if(x==0)return;
            if(MusicMap.containsKey(mu)){
                MusicMax in = MusicMap.get(mu);
                String m = in.name;
                long tm = in.time;
                String a=in.mid[x-1];
                String b=in.min[x-1];
                String c=in.mig[x-1];
                String d=in.mip[x-1];
                if(300<mt-tm){
                    MusicMap.remove(mu);
                    return;
                }if(in.type==1){
                    String urlii="";
                    try{
                        String url="https://y.qq.com/n/ryqq/songDetail/"+a;
                        String web=http.get(url);
                        urlii=url;
                        String src=web.split("picurl\":\"")[1].split("\"")[0].substring(52);
                        String xs=http.get("http://u6.y.qq.com/cgi-bin/musicu.fcg?data={\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"358840384\",\"songmid\":[\""+a+"\"],\"songtype\":[0],\"uin\":\"\",\"loginflag\":1,\"platform\":\"20\"}}}");
                        JSONObject zz=new JSONObject(xs);
                        String sip=zz.getJSONObject("req_0").getJSONObject("data").getJSONArray("sip").getString(0);
                        String purl=zz.getJSONObject("req_0").getJSONObject("data").getJSONArray("midurlinfo").getJSONObject(0).getString("purl");
                        if(purl.equals("")){
                            String url="https://i.y.qq.com/v8/playsong.html?songmid="+a+"&ADTAG=myqq&from=myqq&channel=10007100";
                            String web=http.get(url);
                            String pic="http:"+web.split("<meta itemprop=\"image\" content=\"")[1].split("\" />")[0];
                            String mus=web.split("\"m4aUrl\":\"")[1].split("\"")[0];
                            String xml = musicxml.replace("页面","").replace("歌名",c).replace("封面",pic).replace("直链",musi).replace(new String(new byte[]{-26,-113,-113,-24,-65,-80,}),c+"-"+b+new String(new byte[]{10,81,81,-23,-97,-77,-28,-71,-112,-30,-128,-108,-30,-128,-108,-23,-72,-83,-23,-72,-83,74,97,118,97,}));
                            String json=musicjson(b,c,urlii,mus,mu,"QQ音乐——鸭鸭𝙅𝙖𝙫𝙖");
                            卡片(msg,json);
                        }String json=musicjson(b,c,urlii,sip+purl,mu,"QQ音乐——鸭鸭𝙅𝙖𝙫𝙖");
                        卡片(msg,json);
                    }catch(e){
                        回复(msg,"付费音乐不可听！\n版权音乐不可听！"+urlii);
                        return;
                    }
                }if(in.type==2){
                    String url="http://music.163.com/song/media/outer/url?id="+a+".mp3";
                    String uri="http://music.163.com/#/song?id="+a;
                    String e=http.get("http://music.163.com/api/song/detail/?id="+a+"&ids=["+a+"]");
                    String f=e.split("blurPicUrl\":\"")[1].split("\"")[0];
                    String json=musicjson(b.replace("&",""),c,uri,url,mu,"网易云音乐——鸭鸭𝙅𝙖𝙫𝙖");
                    卡片(msg,json);
                }if(in.type==3){
                    try{
                        String p=http.get("http://artistpicserver.kuwo.cn/pic.web?user=867401041651110&android_id=f243cc2225eac3c9&prod=kwplayer_ar_9.2.8.1&corp=kuwo&source=kwplayer_ar_9.2.8.1_qq.apk&type=rid_pic&pictype=url&content=list&size=320&rid="+a);
                        String u=http.get("http://antiserver.kuwo.cn/anti.s?type=convert_url&rid="+a+"&format=aac|mp3&response=url");
                        String json=musicjson(b,c,u,u,mu,"酷我音乐——鸭鸭𝙅𝙖𝙫𝙖");
                        卡片(msg,json);
                    }catch(e){
                        回复(msg,Api_403);
                    }
                }if(in.type==4){
                    try{
                        String json=musicjson(b,c,a,a,mu,"𝘿𝙅电音——鸭鸭𝙅𝙖𝙫𝙖");
                        卡片(msg,json);
                    }catch(e){
                        回复(msg,Api_403+e);
                        return;
                    }
                }if(in.type==5){
                    String q=http.get("http://m.kugou.com/api/v1/song/get_song_info?cmd=playInfo&hash="+a+"&from=mkugou&apiver=2&mid=8c8f5fad1e1283aa4a531bccdcf990cc&userid=0&platid=4&dfid=334jIp1XJJf512BOcP1x5Ztq");
                    if(q.contains("需要付费")){
                        回复(msg,"付费不可听！");
                        return;
                    }String mp3=new JSONObject(q).get("url");
                    String json=musicjson(b,c,mp3,mp3,mu,"酷狗音乐——鸭鸭𝙅𝙖𝙫𝙖");
                    卡片(msg,json);
                }if(in.type==6){
                    try{
                        String json=musicjson(b,c,a,a,mu,"铃声多多——鸭鸭𝙅𝙖𝙫𝙖");
                        卡片(msg,json);
                    }catch(e){
                        回复(msg,"没有音乐链接");
                    }
                }if(in.type==7){
                    JSONObject aa=new JSONObject(http.get("http://c.musicapp.migu.cn/MIGUM2.0/v1.0/content/resourceinfo.do?copyrightId="+a+"&resourceType=2").replace("ftp://218.200.160.122:21","https://freetyst.nf.migu.cn"));
                    //  String t=aa.get("resource").get(0).get("rateFormats").get(0).get("url");
                    String t="";
                    String yz="[无损]";
                    JSONArray i=aa.get("resource").get(0).get("newRateFormats");
                    if(i.length()==2){
                        t=aa.get("resource").get(0).get("rateFormats").get(0).get("url");
                        yz="";
                    }else t=i.get(i.length()-1).get("androidUrl");
                    String json=musicjson(b,c+yz,t,t,mu,"咪咕音乐——鸭鸭𝙅𝙖𝙫𝙖");
                    卡片(msg,json);
                }
            }
        }catch(Throwable e){
            e.printStackTrace();
            Toast(e+"");
        }
    }if(mc.startsWith("看")){
        String csx=mc.substring(1);
        if(csx.length()==0)return;
        if(csx.matches("^[0-9]*$")){
            try{
                int x=Integer.parseInt(csx);
                if(x==0)return;
                if(TVmap.containsKey(mu)){
                    TvMap in = TVmap.get(mu);
                    String b = in.name;
                    long tm = in.time;
                    String a=in.mid[x-1];
                    String d=in.pic;
                    if(6000<mt-tm){
                        TVmap.remove(mu);
                        return;
                    }if(in.type==21){
                        String xml="[PicUrl="+d+"]\n"+b+"\n"+a+"\n总有"+in.mid.length/2+"集，当前第"+x+"集\n发送看+序号选集";
                        文字(msg,xml);
                    }
                }
            }catch(Throwable e){
                e.printStackTrace();
            }
        }
    }//if(mc.startsWith("语音"))
    if(mc.matches("^语音[0-9]*$")||mc.matches("^语音[0-9]*$")){
        String mp3=null;
        String pat=Root+"数据/";
        //   if(mc.substring(2).matches("^[0-9]*$")){标记
        try{
            //int x=Integer.parseInt(mc.substring(2));
            int x=Integer.parseInt(mc.replaceAll("\\D",""));
            if(x==0)return;
            if(MusicMap.containsKey(mu)){
                MusicMax in = MusicMap.get(mu);
                String m = in.name;
                long tm = in.time;
                String a=in.mid[x-1];
                String b=in.min[x-1];
                String c=in.mig[x-1];
                String d=in.mip[x-1];
                if(300<mt-tm){
                    MusicMap.remove(mu);
                    return;
                }if(in.type==99){
                    语音(msg,in.mid[x]);
                    return;
                }if(10<x)return;
                if(in.type==1){
                    String we=null;
                    String url=null;
                    try{
                        we="https://y.qq.com/n/ryqq/songDetail/"+a;
                        String wee=http.get(we);
                        JSONObject zz=new JSONObject(http.get("http://u6.y.qq.com/cgi-bin/musicu.fcg?data={\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"358840384\",\"songmid\":[\""+a+"\"],\"songtype\":[0],\"uin\":\"\",\"loginflag\":1,\"platform\":\"20\"}}}"));
                        String sip=zz.get("req_0").get("data").get("sip").getString(0);
                        String purl=zz.get("req_0").get("data").get("midurlinfo").get(0).getString("purl");
                        url=sip+purl;
                        if(purl.equals("")){
                            String web=http.get("https://i.y.qq.com/v8/playsong.html?songmid="+a+"&ADTAG=myqq&from=myqq&channel=10007100");
                            url=web.split("\"m4aUrl\":\"")[1].split("\"")[0];
                        }mp3=url;
                        pat+="QQ音乐.mp3";
                    }catch(e){
                        回复(msg,"付费音乐不可听！\n版权音乐不可听！\n"+we);
                        return;
                    }
                }if(in.type==2){
                    mp3="http://music.163.com/song/media/outer/url?id="+a+".mp3";
                    pat+="网易云音乐.mp3";
                }if(in.type==3){
                    try{
                        mp3=http.get("http://antiserver.kuwo.cn/anti.s?type=convert_url&rid="+a+"&format=aac|mp3&response=url");
                        pat+="酷我音乐.mp3";
                    }catch(e){
                        回复(msg,Api_403);
                    }
                }if(in.type==4){
                    mp3=a;
                    pat+="DJ电音.mp3";
                }if(in.type==5){
                    String q=http.get("http://m.kugou.com/api/v1/song/get_song_info?cmd=playInfo&hash="+a+"&from=mkugou&apiver=2&mid=8c8f5fad1e1283aa4a531bccdcf990cc&userid=0&platid=4&dfid=334jIp1XJJf512BOcP1x5Ztq");
                    if(q.contains("需要付费")){
                        回复(msg,"付费不可听！");
                        return;
                    }mp3=new JSONObject(q).get("url");
                    pat+="酷狗音乐.mp3";
                }if(in.type==6){
                    mp3=a;
                    pat+="铃声点歌.mp3";
                }if(in.type==7){
                    JSONObject aa=new JSONObject(http.get("http://c.musicapp.migu.cn/MIGUM2.0/v1.0/content/resourceinfo.do?copyrightId="+a+"&resourceType=2").replace("ftp://218.200.160.122:21","https://freetyst.nf.migu.cn"));
                    mp3=aa.get("resource").get(0).get("rateFormats").get(0).get("url");
                    pat+="咪咕点歌.mp3";
                }if(in.type==20){
                    try{
                        String js=http.get("http://d.gqyy8.com:8077/ne2/s"+a+".js");
                        if(c.length()==0){
                            String url="\nhttps://jx.parwix.com:4433/player/?url="+js.split("\"")[1].split(",")[0];
                            String xml="[PicUrl="+d+"]\n"+b+url;
                            文字(msg,xml);
                        }else{
                            // int ll=Integer.parseInt(c);
                            String Mi="";
                            TvMap tv = new TvMap();
                            tv.time = mt;
                            tv.type = 21;
                            tv.name =b;
                            tv.pic=d;
                            Pattern p=Pattern.compile("]=\"(.*?),");
                            Matcher M=p.matcher(js);
                            while(M.find()){
                                Mi+="±"+M.group(1);
                            }String[] mi=Mi.substring(1).split("±");
                            int cc=mi.length;
                            for(int i=0;i<cc;i++){
                                tv.mid[i]=mi[i];
                            }TVmap.put(mu,tv);
                            String xml="[PicUrl="+d+"]\n"+b+"\n"+mi[0]+"\n总有"+cc/2+"集，当前第1集\n发送看+序号选集";
                            文字(msg,xml);
                        }
                    }catch(e){
                        回复(msg,Api_403+"\n重新选一个吧");
                    }
                }
            }
        }catch(Throwable e){
            e.printStackTrace();
        }//标记 }
        if(mp3.length()==0)回复(msg,"没有音乐链接");
        boolean ok=http.FFile(mp3,pat);
        if(ok)语音(msg,pat);
        else 文字(msg,Api_403);
    }if(mc.startsWith("链接")){
        String mp3=null;
        if(mc.substring(2).matches("^[0-9]*$")){
            try{
                int x=Integer.parseInt(mc.substring(2));
                if(x==0)return;
                if(MusicMap.containsKey(mu)){
                    MusicMax in = MusicMap.get(mu);
                    String m = in.name;
                    long tm = in.time;
                    String a=in.mid[x-1];
                    String b=in.min[x-1];
                    String c=in.mig[x-1];
                    String d=in.mip[x-1];
                    if(300<mt-tm){
                        MusicMap.remove(mu);
                        return;
                    }if(in.type==1){
                        String we=null;
                        String url=null;
                        try{
                            we="https://y.qq.com/n/ryqq/songDetail/"+a;
                            JSONObject zz=new JSONObject(http.get("http://u6.y.qq.com/cgi-bin/musicu.fcg?data={\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"358840384\",\"songmid\":[\""+a+"\"],\"songtype\":[0],\"uin\":\"\",\"loginflag\":1,\"platform\":\"20\"}}}"));
                            String sip=zz.get("req_0").get("data").get("sip").getString(0);
                            String purl=zz.get("req_0").get("data").get("midurlinfo").get(0).getString("purl");
                            url=sip+purl;
                            if(purl.equals("")){
                                String web=http.get("https://i.y.qq.com/v8/playsong.html?songmid="+a+"&ADTAG=myqq&from=myqq&channel=10007100");
                                url=web.split("\"m4aUrl\":\"")[1].split("\"")[0];
                            }mp3=url;
                        }catch(e){
                            回复(msg,"付费音乐不可听！\n版权音乐不可听！\n"+we);
                            return;
                        }
                    }if(in.type==2){
                        mp3="http://music.163.com/song/media/outer/url?id="+a+".mp3";
                    }if(in.type==3){
                        try{
                            mp3=http.get("http://antiserver.kuwo.cn/anti.s?type=convert_url&rid="+a+"&format=aac|mp3&response=url");
                        }catch(e){
                            回复(msg,Api_403);
                        }
                    }if(in.type==4){
                        mp3=a;
                    }if(in.type==5){
                        String q=http.get("http://m.kugou.com/api/v1/song/get_song_info?cmd=playInfo&hash="+a+"&from=mkugou&apiver=2&mid=8c8f5fad1e1283aa4a531bccdcf990cc&userid=0&platid=4&dfid=334jIp1XJJf512BOcP1x5Ztq");
                        if(q.contains("需要付费")){
                            回复(msg,"付费不可听！");
                            return;
                        }mp3=new JSONObject(q).get("url");
                    }if(in.type==6){
                        mp3=a;
                    }if(in.type==7){
                        JSONObject aa=new JSONObject(http.get("http://c.musicapp.migu.cn/MIGUM2.0/v1.0/content/resourceinfo.do?copyrightId="+a+"&resourceType=2").replace("ftp://218.200.160.122:21","https://freetyst.nf.migu.cn"));
                        //mp3=aa.get("resource").get(0).get("rateFormats").get(0).get("url");
                        JSONArray i=aa.get("resource").get(0).get("newRateFormats");
                        if(i.length()==2)mp3=aa.get("resource").get(0).get("rateFormats").get(0).get("url");
                        else mp3=i.get(i.length()-1).get("androidUrl");
                    }
                }
            }catch(Throwable e){
                e.printStackTrace();
            }
        }if(mp3.length()==0)回复(msg,"没有音乐链接");
        else 回复(msg,mp3);
    }if(mc.startsWith("封面")||mc.startsWith("图片")){
        String img=null;
        if(mc.substring(2).matches("^[0-9]*$")){
            try{
                int x=Integer.parseInt(mc.substring(2));
                if(x==0)return;
                if(MusicMap.containsKey(mu)){
                    MusicMax in = MusicMap.get(mu);
                    String m = in.name;
                    long tm = in.time;
                    String a=in.mid[x-1];
                    String b=in.min[x-1];
                    String c=in.mig[x-1];
                    String d=in.mip[x-1];
                    if(300<mt-tm){
                        MusicMap.remove(mu);
                        return;
                    }if(in.type==1){
                        String we=null;
                        String url=null;
                        try{
                            we="https://y.qq.com/n/ryqq/songDetail/"+a;
                            String wee=http.get(we);
                            String src=wee.split("picurl\":\"")[1].split("\"")[0].substring(52);
                            img="https://y.qq.com/music/photo_new/"+src;
                        }catch(e){
                            回复(msg,Api_403);
                            return;
                        }
                    }if(in.type==2){
                        String e=http.get("http://music.163.com/api/song/detail/?id="+a+"&ids=["+a+"]");
                        img=e.split("blurPicUrl\":\"")[1].split("\"")[0];
                    }if(in.type==3){
                        try{
                            img=http.get("http://artistpicserver.kuwo.cn/pic.web?user=867401041651110&android_id=f243cc2225eac3c9&prod=kwplayer_ar_9.2.8.1&corp=kuwo&source=kwplayer_ar_9.2.8.1_qq.apk&type=rid_pic&pictype=url&content=list&size=320&rid="+a);
                        }catch(e){
                            回复(msg,Api_403);
                            return;
                        }
                    }if(in.type==4){
                        img=d;
                    }if(in.type==5){
                        String q=http.get("http://tools.mobile.kugou.com/api/v1/singer_header/get_by_hash?hash=7789b770ef3f0869badf8a8fe21cce79&size=200&format=jsonp&callback=kgJSONP657499853").replace("\\","");
                        img=q.split("\"url\":\"")[1].split("\"")[0];
                    }if(in.type==6){
                        img=d;
                    }if(in.type==7){
                        img=d;
                    }
                }
            }catch(Throwable e){
                e.printStackTrace();
            }
        }if(img.length()==0)回复(msg,"没有封面链接");
        else 回复(msg,"[PicUrl="+img+"]");
    }if(mc.matches("^文件[0-9]*$")){
        String mp3=null;
        String pat=Root+"数据/点歌文件/";
        //   if(mc.substring(2).matches("^[0-9]*$")){标记
        try{
            //int x=Integer.parseInt(mc.substring(2));
            int x=Integer.parseInt(mc.replaceAll("\\D",""));
            if(x==0)return;
            if(MusicMap.containsKey(mu)){
                MusicMax in = MusicMap.get(mu);
                String m = in.name;
                long tm = in.time;
                String a=in.mid[x-1];
                String b=in.min[x-1];
                String c=in.mig[x-1];
                String d=in.mip[x-1];
                if(300<mt-tm){
                    MusicMap.remove(mu);
                    return;
                }if(10<x)return;
                if(in.type==1){
                    String we=null;
                    String url=null;
                    try{
                        we="https://y.qq.com/n/ryqq/songDetail/"+a;
                        String wee=http.get(we);
                        JSONObject zz=new JSONObject(http.get("http://u6.y.qq.com/cgi-bin/musicu.fcg?data={\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"358840384\",\"songmid\":[\""+a+"\"],\"songtype\":[0],\"uin\":\"\",\"loginflag\":1,\"platform\":\"20\"}}}"));
                        String sip=zz.get("req_0").get("data").get("sip").getString(0);
                        String purl=zz.get("req_0").get("data").get("midurlinfo").get(0).getString("purl");
                        url=sip+purl;
                        if(purl.equals("")){
                            String web=http.get("https://i.y.qq.com/v8/playsong.html?songmid="+a+"&ADTAG=myqq&from=myqq&channel=10007100");
                            url=web.split("\"m4aUrl\":\"")[1].split("\"")[0];
                        }mp3=url;
                    }catch(e){
                        回复(msg,"付费音乐不可听！\n版权音乐不可听！\n"+we);
                        return;
                    }
                }if(in.type==2){
                    mp3="http://music.163.com/song/media/outer/url?id="+a+".mp3";
                }if(in.type==3){
                    try{
                        mp3=http.get("http://antiserver.kuwo.cn/anti.s?type=convert_url&rid="+a+"&format=aac|mp3&response=url");
                    }catch(e){
                        回复(msg,Api_403);
                    }
                }if(in.type==4){
                    mp3=a;
                }if(in.type==5){
                    String q=http.get("http://m.kugou.com/api/v1/song/get_song_info?cmd=playInfo&hash="+a+"&from=mkugou&apiver=2&mid=8c8f5fad1e1283aa4a531bccdcf990cc&userid=0&platid=4&dfid=334jIp1XJJf512BOcP1x5Ztq");
                    if(q.contains("需要付费")){
                        回复(msg,"付费不可听！");
                        return;
                    }mp3=new JSONObject(q).get("url");
                }if(in.type==6){
                    mp3=a;
                }if(in.type==7){
                    JSONObject aa=new JSONObject(http.get("http://c.musicapp.migu.cn/MIGUM2.0/v1.0/content/resourceinfo.do?copyrightId="+a+"&resourceType=2").replace("ftp://218.200.160.122:21","https://freetyst.nf.migu.cn"));
                    //  mp3=aa.get("resource").get(0).get("rateFormats").get(0).get("url");
                    JSONArray i=aa.get("resource").get(0).get("newRateFormats");
                    if(i.length()==2)mp3=aa.get("resource").get(0).get("rateFormats").get(0).get("url");
                    else mp3=i.get(i.length()-1).get("androidUrl");
                }if(mp3.length()==0)回复(msg,"没有音乐链接");
                String[] hz={".m4a",".aac",".mp3",".flac"};String ghz=b+"--"+c;
                String ghz="";
                for(int i=0;i<hz.length;i++){
                    if(mp3.contains(hz[i])){
                        ghz=hz[i];
                        break;
                    }
                }if(ghz.length()==0)ghz=hz[2];
                pat+=b+"--"+c+ghz;
                File file = new File(Root+"数据/点歌文件/");
                if(!file.exists())file.mkdir();
                File file1 = new File(pat);
                if(!file1.exists())http.File(mp3,pat);
                if(msg.IsGroup)sendFile(mg,pat);
                else sendFriendFile(mu,pat);
            }
        }catch(Throwable e){
            回复(msg,Api_403);
            e.printStackTrace();
        }
    }if(DJWyygl.contains(mu)){
        if(mc.startsWith("存DJ")||mc.startsWith("存dj")||mc.startsWith("存网易")){
            String mp3=null;
            String img=null;
            String song=null;
            String mpRo=StringDJ;
            if(mc.contains("网易"))mpRo=StringWY;
            try{
                if(mc.substring(3).matches("^[0-9]*$")){
                    int x=Integer.parseInt(mc.substring(3));
                    if(x==0)return;
                    if(MusicMap.containsKey(mu)){
                        MusicMax in = MusicMap.get(mu);
                        String m = in.name;
                        long tm = in.time;
                        String a=in.mid[x-1];
                        String b=in.min[x-1];
                        String c=in.mig[x-1];
                        String d=in.mip[x-1];
                        if(300<mt-tm){
                            MusicMap.remove(mu);
                            return;
                        }if(in.type==1){
                            String we=null;
                            String url=null;
                            try{
                                we="https://y.qq.com/n/ryqq/songDetail/"+a;
                                JSONObject zz=new JSONObject(http.get("http://u6.y.qq.com/cgi-bin/musicu.fcg?data={\"req_0\":{\"module\":\"vkey.GetVkeyServer\",\"method\":\"CgiGetVkey\",\"param\":{\"guid\":\"358840384\",\"songmid\":[\""+a+"\"],\"songtype\":[0],\"uin\":\"\",\"loginflag\":1,\"platform\":\"20\"}}}"));
                                String sip=zz.get("req_0").get("data").get("sip").getString(0);
                                String purl=zz.get("req_0").get("data").get("midurlinfo").get(0).getString("purl");
                                url=sip+purl;
                                String wee=http.get(we);
                                String src=wee.split("picurl\":\"")[1].split("\"")[0].substring(52);
                                img="https://y.qq.com/music/photo_new/"+src;
                                if(purl.equals("")){
                                    String web=http.get("https://i.y.qq.com/v8/playsong.html?songmid="+a+"&ADTAG=myqq&from=myqq&channel=10007100");
                                    url=web.split("\"m4aUrl\":\"")[1].split("\"")[0];
                                }mp3=url;
                            }catch(e){
                                回复(msg,"付费音乐不可听！\n版权音乐不可听！\n"+we);
                                return;
                            }
                        }if(in.type==2){
                            mp3="http://music.163.com/song/media/outer/url?id="+a+".mp3";
                            String e=http.get("http://music.163.com/api/song/detail/?id="+a+"&ids=["+a+"]");
                            img=e.split("blurPicUrl\":\"")[1].split("\"")[0];
                        }if(in.type==3){
                            try{
                                mp3=http.get("http://antiserver.kuwo.cn/anti.s?type=convert_url&rid="+a+"&format=aac|mp3&response=url");
                                img=http.get("http://artistpicserver.kuwo.cn/pic.web?user=867401041651110&android_id=f243cc2225eac3c9&prod=kwplayer_ar_9.2.8.1&corp=kuwo&source=kwplayer_ar_9.2.8.1_qq.apk&type=rid_pic&pictype=url&content=list&size=320&rid="+a);
                            }catch(e){
                                回复(msg,Api_403);
                            }
                        }if(in.type==4){
                            mp3=a;
                            img=d;
                        }if(in.type==5){
                            String e="kg_mid=d72af2ee191fa7475ec71468b16f1861; kg_dfid=3vVHxI1HqB5r0Tntrk46QJ5G; kg_dfid_collect=d41d8cd98f00b204e9800998ecf8427e";
                            String q=httpget("http://www.kugou.com/yy/index.php?r=play/getdata&hash="+a+"&album_id="+d,e);
                            mp3=new JSONObject(q).getJSONObject("data").get("play_url");
                            img=ja1.get("img");
                        }if(in.type==6){
                            mp3=a;
                            img=d;
                        }if(in.type==7){
                            JSONObject aa=new JSONObject(http.get("http://c.musicapp.migu.cn/MIGUM2.0/v1.0/content/resourceinfo.do?copyrightId="+a+"&resourceType=2").replace("ftp://218.200.160.122:21","https://freetyst.nf.migu.cn"));
                            mp3=aa.get("resource").get(0).get("rateFormats").get(0).get("url");
                            img=d;
                        }song=c+"--"+b+".mp3";
                    }
                }else{
                    if(mc.contains("https://v.kuaishou")){
                        String ul=filterUrl(mc);
                        String urlss=DouYinParse.kuaishou(ul);
                        JSONObject dat=new JSONObject(urlss);
                        song=dat.get("s")+".m4a";
                        mp3=dat.get("e");
                        img=dat.get("i");
                    }if(mc.contains("https://v.douyin")){
                        String ul=filterUrl(mc);
                        String urlss=DouYinParse.parseDouYinVideo(ul);
                        JSONObject dat=new JSONObject(urlss);
                        song=dat.get("d")+".mp3";
                        mp3=dat.get("e");
                        img=dat.get("i");
                    }if(mc.substring(3).startsWith("http")&&18<mc.length()){
                        mp3=mc.substring(3);
                        song=mc.substring(11).replace("/","&");
                        img=Qs.头像(mu,2);
                    }
                }if(mp3.length()==0)回复(msg,"没有音乐链接");
                boolean ok=http.FFile(mp3,mpRo+song);
                if(ok){
                    File[] by=new File(mpRo).listFiles();
                    回复(msg,"[PicUrl="+img+"]\n添加成功\n目前共"+(by.length-1)+"首！");
                    语音(msg,mpRo+song);
                }else 文字(msg,"保存失败，请重试\n"+mp3+"\n"+mpRo+song+"\n");
            }catch(Throwable e){
                e.printStackTrace();
            }
        }if(mc.startsWith("删")){
            if(MusicMap.containsKey(mu)){
                MusicMax in = MusicMap.get(mu);
                String m = in.name;
                long tm = in.time;
                if(300<mt-tm){
                    MusicMap.remove(mu);
                    return;
                }if(in.type==99){
                    String a=mc.substring(1);
                    if(a.length()==0)return;
                    if(a.matches("^[0-9]*$")){
                        deleteDirectory(new File(in.mid[Integer.parseInt(a)].toString()));
                        if(mu.equals(MyUin))Toast("已删除");
                        else 回复(msg,"删除成功");
                    }
                }
            }
        }
    }if(mc.startsWith("搜DJ")||mc.startsWith("搜dj")||mc.startsWith("搜网易")){
        String a=mc.substring(3);
        if(a.length()==0)return;
        if(DJWyygl.contains(mu)){
            String[] DJss=null;
            String mpRo=StringDJ;
            if(mc.contains("网易"))mpRo=StringWY;
            File[] ar=new File(mpRo).listFiles();
            String arg="";
            int ii=0;
            String g="";
            for(int i=0;i<ar.length;i++){
                if(ar[i].toString().replace(".mp3","").replace(".m4a","").contains(a)){
                    arg+="±±"+ar[i];
                }
            }MusicMax musicMax = new MusicMax();
            musicMax.time = mt;
            musicMax.type = 99;
            musicMax.name =a;
            MusicMap.put(mu,musicMax);
            DJss=arg.split("±±");
            int ii=DJss.length;
            for(int i=0;i<ii;i++){
                musicMax.mid[i]=DJss[i];
            }if(10<ii)ii=10;
            if(ii==1){
                回复(msg,"没有搜到哦");
                return;
            }for(int i=1;i<ii;i++){
                g+=i+"."+DJss[i]+"\n";
            }if(DJss.length==2)语音(msg,DJss[1].toString());
            String tal=g.replace(mpRo,"").replace(".mp3","").replace(".m4a","")+"\n共搜到"+(DJss.length-1)+"首相关“"+a+"”；\n发送序号选歌\n发送删+序号删除";
            回复(msg,tal);
        }
    }
}public musicjson(String 歌名,作者,页面,链接,qq,app){
    return "{\"app\":\"com.tencent.qzone.structmsg\",\"desc\":\"音乐\",\"view\":\"music\",\"ver\":\"0.0.0.1\",\"prompt\":\"[分享]"+歌名+"\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"music\":{\"action\":\"\",\"android_pkg_name\":\"\",\"app_type\":1,\"appid\":2971627154,\"ctime\":868486,\"desc\":\""+作者+"\",\"jumpUrl\":\""+页面+"\",\"musicUrl\":\""+链接+"\",\"preview\":\"https://q.qlogo.cn/headimg_dl?dst_uin="+qq+"&spec=140\",\"sourceMsgId\":\"0\",\"source_icon\":\"\",\"source_url\":\"\",\"tag\":\""+app+"\",\"title\":\""+歌名+"\",\"uin\":2971627154}},\"config\":{\"autosize\":0,\"ctime\":868486,\"forward\":false,\"token\":\"\",\"type\":\"normal\"},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
}public QQmusicget(String url,String cookies,HashMap String,String requestMap){
    if(url==null || url.equalsIgnoreCase(""))return "";
    BufferedReader reader=null;
    try{
        URL url1=new URL(url);
        URLConnection connection=url1.openConnection();
        connection.setRequestProperty("accept","*/*");
        connection.setRequestProperty("connection","keep-Alive");
        connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        if(cookies!=null)connection.setRequestProperty("Cookie",cookies);
        if(requestMap!=null){
            Iterator iterator=requestMap.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry entry=(Map.Entry)iterator.next();
                connection.setRequestProperty(entry.getKey(),entry.getValue());
            }
        }connection.connect();
        reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer sb=new StringBuffer();
        String temp=null;
        while((temp=reader.readLine())!=null){
            sb.append(temp);
        }return sb.toString();
    }catch(Exception e){
        e.printStackTrace();
        return "";
    }finally{
        if(reader!=null){
            try{
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}private static void deleteDirectory(File file){
    if(file.isFile()){
        file.delete();
    }else{
        String[] childFilePaths = file.list();
        for (String childFilePath : childFilePaths){
            File childFile = new File(file.getAbsolutePath()+ "/" + childFilePath);
            deleteDirectory(childFile);
        }file.delete();
    }
}
