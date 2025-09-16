import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DecimalFormat;
public void zl_jiexi(Object msg,String mc,String mg,String mu){
    if(Lshost.contains(mu)){
        if(mc.equals("开启视频解析")){
            if(开关.读("视频解析",mg)==1){
                toast(repeat_+"视频解析",1500);
            }else{
                开关.写("视频解析",mg,1);
                toast(repeat_t+"视频解析",1500);
            }
        }if(mc.equals("关闭视频解析")){
            if(开关.读("视频解析",mg)==0){
                toast(_repeat+"视频解析",1500);
            }else{
                开关.写("视频解析",mg,0);
                toast(t_repeat+"视频解析",1500);
            }
        }if(mc.equals("切换解析")){
            if(开关.读("切换解析",mg)==0){
                开关.写("切换解析",mg,1);
            }else{
                开关.写("切换解析",mg,0);
            }toast("切换解析发送格式成功",1500);
        }
    }if(开关.读("视频解析",mg)==0)return;
    if((mc.contains("https://v.kuaishou")||mc.contains("https://h5.pipix.com")||mc.contains("https://v.douyin")||mc.contains("https://b23.tv")||mc.contains("http://xhslink.com/")||mc.startsWith("解析"))&&!mc.startsWith("存")){
        String data=mc.substring(mc.lastIndexOf("http"));
        String ul=filterUrl(data);
        new Thread(new Runnable(){
            public void run(){
                try{
                    String urlss=http.get("https://api.wya6.cn/api/analysis?apiKey=a2a953ba457e1ed06844377f031aee88&url="+ul);
                    JSONObject dat=new JSONObject(urlss).get("data");
                    String a=dat.get("cover");
                    String b=dat.get("title");
                    String c=dat.optString("url");
                    if(c.equals("")){
                        String poth=Root+"数据/解析图片/"+b+"/";
                        File file = new File(poth);
                        if(!file.exists())file.mkdir();
                        JSONArray arr=dat.get("images");
                        for(int i=0;i<arr.length();
                        i++){
                            c+="\n"+(i+1)+"."+arr.get(i);
                        }sendMsg(mg,mu,a+"\n"+b+c);
                        String tal="[PicUrl="+a+"]\n标题:\n"+msgARR(b,10)+"\nPS:图链已私发";
                        文字(msg,tal);
                        return;
                    }String tal="[PicUrl="+a+"]\n标题:"+b+"\n视频:"+c+"\nPS:建议浏览器打开";
                    文字(msg,tal);
                    if(开关.读("切换解析",mg)==1&&c.length()!=0){
                        URL du = new URL(c);
                        URLConnection uc = du.openConnection();
                        float size = uc.getContentLength();
                        if(jiexisizemax<size){
                            toast("视频文件大于"+formatSize(jiexisizemax)+"\n已经停止进行下载",1600);
                            return;
                        }String poth=Root+"数据/解析视频/";
                        String pott=poth+b+".mp4";
                        File file = new File(poth);
                        if(!file.exists())file.mkdir();
                        http.File(du.toString(),pott);
                        if(4<mg.length())mu="";
                        upload(mg,mu,pott);
                    }
                }catch(Exception e){
                    Toast(e+"");
                }
            }
        }).start();
        return;
    }/* if((mc.contains("https://v.kuaishou")||mc.startsWith("解析"))&&!mc.startsWith("存")){
        String tips="链接没有视频\n（极速版不完全支持）\n";
        if(!mc.contains("v.kuaishou")||mc.contains(tips))return;
        String ul=filterUrl(mc);
        new Thread(new Runnable(){
            public void run(){
                try{
                    String urlss=DouYinParse.kuaishou(ul);
                    if(urlss.length()==0){
                        回复(msg,Api_403);
                        return;
                    }JSONObject dat=new JSONObject(urlss);
                    String a=dat.get("a");
                    String c=dat.get("c");
                    String d=dat.get("d");
                    String e=dat.get("e");
                    String f=dat.get("f");
                    String fl="";
                    if(f.length()==0)fl="该链接属于图片合集";
                    else fl=f;
                    String tal="快手解析\n[PicUrl="+a+"]\n作者:"+c+"\n标题:"+d+"\n音乐:"+e+"\n视频:"+fl+"\nPS:建议浏览器打开";
                    文字(msg,tal);
                    if(e.length()!=0){
                        URL urp =new URL(e);
                        HttpURLConnection urlCon =(HttpURLConnection)urp.openConnection();
                        InputStream inputr = urlCon.getInputStream();
                        String ptt="/storage/emulated/0/LD_Module/Voice/快手最后解析音频.mp3";
                        byte[] ms= toByteArray(inputr);
                        if(ms.length <1048576){
                            http.hFile(ptt,ms);
                        }else{
                            byte[] ys=new byte[1048576];
                            for (int s=0;s<1;s++) System.arraycopy(ms,0,ys,0,1048576);
                            http.hFile(ptt,ys);
                        }语音(msg,ptt);
                    }if(开关.读("切换解析",mg)==1){
                        if(f.length()==0)return;
                        URL du = new URL(f);
                        URLConnection uc = du.openConnection();
                        float size = uc.getContentLength();
                        if(jiexisizemax<size){
                            toast("视频文件大于"+formatSize(jiexisizemax)+"\n已经停止进行下载",1600);
                            return;
                        }String poth=Root+"数据/解析视频/";
                        if(d.length()<4)d=c+d;
                        String pott=poth+d+".mp4";
                        File file = new File(poth);
                        if(!file.exists())file.mkdir();
                        http.File(f,pott);
                        sendVideo(mg,pott,false);
                    }
                }catch(e){
                    回复(msg,tips+ul+"\n"+e);
                }
            }
        }).start();
        return;
    }*/
}package pers.LovelyBunny;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class DouYinParse{
    public static String parseDouYinVideo(String httpURL){
        try{
            String result = null;
            String itemIDs = getRedirectsURL(httpURL).split("/")[5];
            String jsonString = getJSON("https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=" + itemIDs);
            JSONObject json = new JSONObject(jsonString);
            Object videoURL = json.getJSONArray("item_list").getJSONObject(0).getJSONObject("video").getJSONObject("play_addr").getJSONArray("url_list").get(0);
            result = videoURL.toString().replace("/playwm/","/play/");
            JSONObject js=json.get("item_list").get(0);
            String mp3=js.get("music").get("play_url").get("uri");
            String back=js.get("video").get("origin_cover").get("url_list").getString(0);
            String nana=js.get("author").get("nickname");
            String like=js.get("statistics").getString("digg_count");
            String title=js.get("desc");
            String i=js.get("author").opt("avatar_larger").opt("url_list").optString(0);
            JSONObject jso=new JSONObject();
            jso.put("a",back).put("b",like).put("c",nana).put("d",title).put("e",mp3).put("f",result).put("i",i);
            return jso.toString();
        }catch(e){
            return e+"";
        }
    }public static kuaishou(String url){
        String ur=null;
        String song=null;
        JSONObject jso = new JSONObject();
        try{
            String ua2="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36";
            String ua1="Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Mobile Safari/537.36";
            String ua3="Mozilla/5.0 (iPhone; CPU iPhone OS 13_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1 Mobile/15E148 Safari/604.1";
            String ua4="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36";
            ur=getWithAgent2(url,ua3,"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            //			try{
            String d=ur.split("APOLLO_STATE__=")[1].split("</script><script>")[0];
            //			 }catch(e){	  String d=ur.split("\"")[1];		 }
            String[] x={"user_videos","rawPhoto","music","audioUrls","soundTrack","url","video","srcNoMark","poster","caption","user","name","tagShowBottom","imageUrls"};JSONObject e=new JSONObject(d);
            String result=e.getJSONObject(x[6]).optString(x[7]);
            String back=e.getJSONObject(x[6]).getString(x[8]);
            String title=e.getJSONObject(x[6]).getString(x[9]);
            String nana=e.get(x[10]).get(x[11]);
            try{
                song=e.get(x[6]).get(x[12]).optString(x[11]);
            }catch(e){
                song=nana+"的作品原声";
            }String mp3=null;
            String mpd=e.opt(x[1]).optString(x[2]);
            if(mpd.length()!=0){
                mp3=e.get(x[1]).get(x[2]).get(x[3]).get(0).getString(x[5]);
            }else if(e.get(x[1]).optString(x[4]).length()!=0){
                mp3=e.get(x[1]).get(x[4]).get(x[3]).get(0).getString(x[5]);
            }else if(e.get(x[0]).get(0).optString(x[2]).length()!=0){
                mp3=e.get(x[0]).get(0).get(x[2]).get(x[3]).get(0).getString(x[5]);
            }else{
                mp3=e.get(x[0]).get(0).get(x[4]).get(x[3]).get(0).getString(x[5]);
            }JSONObject jso=new JSONObject();
            jso.put("a",back).put("c",nana).put("d",title).put("e",mp3).put("f",result).put("s",song).put("i",mp3.replace("m4a","jpg"));
            return jso.toString();
        }catch(e){
            try{
                String b="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36";
                String url=http.getWithAgent(url,b);
                String web=new JSONObject(url.split("<script>window.__APOLLO_STATE__=")[1].split(";")[0]).toString().replace("\\/","/");
                String nana=web.split("\"name\":\"")[1].split("\"")[0];
                //作者
                String title=web.split("\"caption\":\"")[1].split("\"")[0];
                //标题
                String back=web.split("\"coverUrl\":\"")[1].split("\"")[0];
                //图片
                String result=web.split("\"photoUrl\":\"")[1].split("\"")[0];
                //链接
                JSONObject jso=new JSONObject();
                jso.put("a",back).put("c",nana).put("d",title).put("e","").put("f",result).put("s","").put("i",back);
                return jso.toString();
            }catch(Exception e){
                return "";
            }
        }
    }public static kuais(String url){
        try{
            String b="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36";
            String url=http.getWithAgent(url,b);
            String web=url.split("<script>window.__APOLLO_STATE__=")[1].split(";")[0];
            String nana=web.split("\"name\":\"")[1].split("\"")[0];
            //作者
            String title=web.split("\"caption\":\"")[1].split("\"")[0];
            //标题
            String back=web.split("\"coverUrl\":\"")[1].split("\"")[0];
            //图片
            String result=web.split("\"photoUrl\":\"")[1].split("\"")[0];
            //链接
            JSONObject jso=new JSONObject();
            jso.put("a",back).put("c",nana).put("d",title).put("e","").put("f",result).put("s","").put("i",back);
            return jso.toString();
        }catch(Exception e){}
    }public static String getRedirectsURL(String httpURL){
        String result = null;
        HttpURLConnection conn = null;
        try{
            conn =(HttpURLConnection)new URL(httpURL).openConnection();
            conn.setInstanceFollowRedirects(false);
            result = conn.getHeaderField("Location");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.disconnect();
        }return result;
    }public static String getJSON(String httpURL){
        HttpURLConnection connection = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String result = null;
        try{
            URL url = new URL(httpURL);
            connection =(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if(connection.getResponseCode()== 200){
                is = connection.getInputStream();
                isr = new InputStreamReader(is,"UTF8");
                br = new BufferedReader(isr);
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while((temp = br.readLine())!= null){
                    sbf.append(temp);
                }result = sbf.toString();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(null != br){
                    br.close();
                }if(null != isr){
                    isr.close();
                }if(null != is){
                    is.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }connection.disconnect();
        }return result;
    }
}public static String filterUrl(String url){
    String regex = "https?://(\\w|-)+(\\.(\\w|-)+)+(/(\\w+(\\?(\\w+=(\\w|%|-)*(\\&\\w+=(\\w|%|-)*)*)?)?)?)+";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(url);
    if(m.find()){
        return url.substring(m.start(),m.end());
    }return "";
}public urlength(String url){
    String s=null;
    URL data = new URL(url);
    URLConnection uc = data.openConnection();
    float size = uc.getContentLength();
    if(size >= 1024){
        s = "KB";
        size /= 1024;
        if(size >= 1024){
            s = "MB";
            size /= 1024;
        }if(size >= 1024){
            s = "GB";
            size /= 1024;
        }
    }String c = size+s;
    return c;
}public String formatSize(float size){
    String suffix = null;
    if(size >= 1024){
        suffix = "KB";
        size /= 1024;
        if(size >= 1024){
            suffix = "MB";
            size /= 1024;
        }if(size >= 1024){
            suffix = "GB";
            size /= 1024;
        }
    }DecimalFormat format=new DecimalFormat(".00");
    String p=format.format(size);
    StringBuilder resultBuffer = new StringBuilder(p);
    if(suffix != null)resultBuffer.append(suffix);
    return resultBuffer.toString();
}public static String getWithAgent2(String url,String Agent,String Accept){
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try{
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        uc.setRequestProperty("User-agent",Agent);
        uc.setRequestProperty("Accept",Accept);
        uc.setConnectTimeout(10000);
        uc.setReadTimeout(10000);
        isr = new InputStreamReader(uc.getInputStream(),"utf-8");
        BufferedReader reader = new BufferedReader(isr);
        String line;
        while((line = reader.readLine())!= null){
            buffer.append(line + "\n");
        }
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try{
            if(null != isr){
                isr.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }if(buffer.length()==0)return buffer.toString();
    buffer.delete(buffer.length()-1,buffer.length());
    return buffer.toString();
}public static String getWithAgent4(String url,String Agent){
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try{
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        uc.setRequestProperty("user-agent",Agent);
        //uc.setRequestProperty("Cookie",cookie);
        uc.setConnectTimeout(10000);
        uc.setReadTimeout(10000);
        isr = new InputStreamReader(uc.getInputStream(),"utf-8");
        BufferedReader reader = new BufferedReader(isr);
        //缓冲
        String line;
        while((line = reader.readLine())!= null){
            buffer.append(line + "\n");
        }
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try{
            if(null != isr){
                isr.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }if(buffer.length()==0)return buffer.toString();
    buffer.delete(buffer.length()-1,buffer.length());
    return buffer.toString();
}
