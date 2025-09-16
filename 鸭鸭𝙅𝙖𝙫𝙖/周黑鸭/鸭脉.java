public class HttpApi{
    public String get(String url){
        StringBuffer buffer = new StringBuffer();
        InputStreamReader isr = null;
        try{
            URL urlObj = new URL(url);
            URLConnection uc = urlObj.openConnection();
            uc.setConnectTimeout(30000);
            uc.setReadTimeout(30000);
            isr = new InputStreamReader(uc.getInputStream(),"utf-8");
            BufferedReader reader = new BufferedReader(isr);
            String line;
            while((line = reader.readLine())!= null){
                buffer.append(line + "\n");
            }
        }catch(Exception e){
            //    Toast("错误链接："+url);
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
    }public static String pet(String url){
        try{
            URL u = new URL(url);
            HttpURLConnection conn =(HttpURLConnection)u.openConnection();
            conn.setRequestProperty("Accept-Encoding","gzip");
            conn.setRequestProperty("Connection","Keep-Alive");
            conn.setRequestProperty("User-Agent","Apache-HttpClient/UNAVAILABLE (java 1.4)");
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String temp;
            StringBuffer buf = new StringBuffer();
            while((temp = reader.readLine())!= null){
                buf.append(temp);
            }is.close();
            return buf.toString();
        }catch(Exception e){}
        return null;
    }public String post(String url,String params){
        try{
            URL urlObjUrl=new URL(url);
            URLConnection connection =urlObjUrl.openConnection();
            connection.setDoOutput(true);
            OutputStream os=connection.getOutputStream();
            os.write(params.getBytes());
            os.close();
            InputStream iStream=connection.getInputStream();
            byte[] b=new byte[1024];
            int len;
            StringBuilder sb=new StringBuilder();
            while((len=iStream.read(b))!=-1){
                sb.append(new String(b,0,len));
            }return sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        }return null;
    }public static String getWithAgent(String url,String Agent){
        StringBuffer buffer = new StringBuffer();
        InputStreamReader isr = null;
        try{
            URL urlObj = new URL(url);
            URLConnection uc = urlObj.openConnection();
            uc.setRequestProperty("User-agent",Agent);
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
    }public String xiaoai(String ticket){
        String data="{\"requestText\":\""+ticket+"\"}";
        StringBuffer buffer = new StringBuffer();
        InputStreamReader isr = null;
        try{
            URL url = new URL("https://ai-voice.api.xiaomi.net/aivs/v2.2/text?erequestId=&token=&userId=de5eb5e5-00ba-4a3a-8b34-4e5f4b956a91&latitude=&longitude=");
            uc =(HttpURLConnection)url.openConnection();
            uc.setDoInput(true);
            uc.setDoOutput(true);
            uc.setConnectTimeout(2000000);
            uc.setReadTimeout(2000000);
            uc.setRequestMethod("POST");
            uc.setRequestProperty("User-Agent","Mozilla/5.0 (Linux; Android 4.4.4; vivo Y13L Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Mobile Safari/537.36");
            uc.getOutputStream().write(data.getBytes("UTF-8"));
            uc.getOutputStream().flush();
            uc.getOutputStream().close();
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
                Toast("错误:\n"+e);
            }
        }if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
    }public String daji(String text){
        try{
            String params="{\"head\":{\"businessId\":\"wzry\",\"callbackPara\":\"\",\"nonce\":1621825658,\"timestamp\":20000,\"userId\":\"78B4DF93D839865AFFD6D3EB1D59A178\",\"userType\":3,\"level\":\"至尊星耀III\"},\"body\":{\"query\":\""+text+"\"}}";
            URL urlObjUrl=new URL("https://starrobotwzry.3g.qq.com/ai");
            URLConnection connection =urlObjUrl.openConnection();
            connection.setDoOutput(true);
            OutputStream os=connection.getOutputStream();
            os.write(params.getBytes());
            os.close();
            InputStream iStream=connection.getInputStream();
            byte[] b=new byte[1024];
            int len;
            StringBuilder sb=new StringBuilder();
            while((len=iStream.read(b))!=-1){
                sb.append(new String(b,0,len));
            }return sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        }return null;
    }public diy(String gtk,String cookie,String data){
        StringBuffer buffer = new StringBuffer();
        InputStreamReader isr = null;
        try{
            URL url = new URL("https://club.vip.qq.com/api/trpc/diy_business_card/SetMaterial?g_tk="+gtk);
            uc =(HttpURLConnection)url.openConnection();
            uc.setDoInput(true);
            uc.setDoOutput(true);
            uc.setConnectTimeout(2000000);
            uc.setReadTimeout(2000000);
            uc.setRequestMethod("POST");
            uc.setRequestProperty("accept","*/*");
            uc.setRequestProperty("connection","Keep-Alive");
            uc.setRequestProperty("user-agent","Mozilla/5.0 (Linux; Android 10; V1914A Build/QP1A.190711.020; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/78.0.3904.96 Mobile Safari/537.36 V1_AND_SQ_8.4.8_1492_YYB_D QQ/8.4.8.4810 NetType/4G WebP/0.4.1 Pixel/1080 StatusBarHeight/85 SimpleUISwitch/0 QQTheme/1000 InMagicWin/0");
            uc.setRequestProperty("Content-Type","application/json");
            uc.setRequestProperty("Cookie",cookie);
            uc.setRequestProperty("Referer","https://club.vip.qq.com/profile/custom?_wv=131072&_fv=0&from=shop&templateId=3807");
            uc.setRequestProperty("Content-Type","application/json;charset=UTF-8");
            uc.getOutputStream().write(data.getBytes("UTF-8"));
            uc.getOutputStream().flush();
            uc.getOutputStream().close();
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
                Toast("错误:\n"+e);
            }
        }if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
    }public void File(String url,String filepath)throws Exception{
        InputStream input = null;
        try{
            URL urlsssss = new URL(url);
            HttpURLConnection urlConn =(HttpURLConnection)urlsssss.openConnection();
            input = urlConn.getInputStream();
            byte[] bs = new byte[1024];
            int len;
            FileOutputStream out = new FileOutputStream(filepath,false);
            while((len = input.read(bs))!= -1){
                out.write(bs,0,len);
            }out.close();
            input.close();
        }catch(IOException e){
            return;
        }finally{
            try{
                input.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }return;
    }public hFile(String path,byte[] Filedata)throws Exception{
        InputStream is=new ByteArrayInputStream(Filedata);
        byte[] bs = new byte[1024];
        int len;
        FileOutputStream out=new FileOutputStream(path,false);
        while((len = is.read(bs))!= -1){
            out.write(bs,0,len);
        }out.close();
        is.close();
    }public void SFile(String url,String filepath)throws Exception{
        InputStream input = null;
        try{
            URL ans = new URL(url);
            HttpURLConnection urlConn =(HttpURLConnection)ans.openConnection();
            input = urlConn.getInputStream();
            byte[] bs = new byte[1024];
            int len;
            FileOutputStream out = new FileOutputStream(filepath,false);
            while((len = input.read(bs))!= -1){
                out.write(bs,0,len);
            }out.close();
            input.close();
        }catch(IOException e){
            return;
        }finally{
            try {}
            catch(IOException e){
                e.printStackTrace();
            }
        }return;
    }public boolean FFile(String e,String filepath){
        try{
            int ss=819200;
            if(开关.读("语音","时长")==1)ss=157028640;
            URL urp =new URL(e);
            HttpURLConnection urlCon =(HttpURLConnection)urp.openConnection();
            InputStream inputr = urlCon.getInputStream();
            byte[] ms= toByteArray(inputr);
            if(ms.length <ss){
                http.hFile(filepath,ms);
                return true;
            }else{
                byte[] ys=new byte[819200];
                System.arraycopy(ms,0,ys,0,819200);
                http.hFile(filepath,ys);
                return true;
            }
        }catch(e){
            return false;
        }
    }public QQget(String url,String Agent,String Referer){
        StringBuffer buffer = new StringBuffer();
        InputStreamReader isr = null;
        try{
            URL urlObj = new URL(url);
            URLConnection uc = urlObj.openConnection();
            uc.setRequestProperty("User-agent",Agent);
            uc.setRequestProperty("referer",Referer);
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
}HttpApi http = new HttpApi();
public byte[] toByteArray(InputStream input)throws IOException{
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    byte[] buffer = new byte[4096];
    int n = 0;
    while(-1 !=(n = input.read(buffer))){
        output.write(buffer,0,n);
    }return output.toByteArray();
}public static String http_get(String url){
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try{
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        isr = new InputStreamReader(uc.getInputStream(),"GBK");
        BufferedReader reader = new BufferedReader(isr);
        String line = null;
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
    }String data = buffer.toString();
    data=data.substring(0,data.length()-1);
    return data;
}String hoerMiadm=ApiHost+"mRfYCQYR";
public void getcookie(Object msg,String Domain){
    try{
        import org.json.JSONObject;
        String apiurl="http://lkaa.top/API/Skey/api.php";
        String k=http.get(apiurl+"?type="+Domain);
        JSONObject aa = new JSONObject(k);
        JSONObject a = aa.getJSONObject("data");
        String q = a.getString("qrsig");
        String b = a.getString("url");
        String c = "\n请在60秒内扫码";
        if(msg.UserUin.equals(mQQ)){
            文字(msg,"@"+msg.SenderNickName+c+"\n"+b);
        }else{
            文字(msg,"@"+msg.SenderNickName+c+"[PicUrl="+b+"]当前登录"+Domain);
        }new Thread(new Runnable(){
            public void run(){
                while(true){
                    try{
                        HttpApi http = new HttpApi();
                        Thread.sleep(getcookieing);
                        //qzone.qq.com，qun.qq.com，vip.qq.com，connect.qq.com，docs.qq.com，id.qq.com。
                        JSONObject sw=new JSONObject(http.get(apiurl+"?type="+Domain+"&qrsig="+q));
                        String code = sw.getString("code");
                        if(code.equals("-3"))continue;
                        if(code.equals("-4"))continue;
                        if(code.equals("1"))try{
                            JSONObject ws=sw.getJSONObject("data");
                            String uin = ws.getString("uin");
                            String poth=Root+"数据/"+Domain+"/";
                            File flle = new File(poth);
                            if(!flle.exists()){
                                flle.mkdir();
                            }flle.createNewFile();
                            File file=new File(poth+uin+".txt");
                            BufferedWriter to = new BufferedWriter(new FileWriter(file));
                            String datas=sw.getString("data");
                            to.write(datas);
                            to.flush();
                            to.close();
                            文字(msg,uin+" 扫码成功");
                            return;
                        }catch(Exception e){
                            e.printStackTrace();
                        }if(code.equals("-2")){
                            return;
                        }if(code.equals("-5")){
                            回复(msg,"拒绝了登录");
                            return;
                        }if(code.equals("-7")){
                            回复(msg,"未知错误");
                            return;
                        }if(code.equals("-6")){
                            回复(msg,"获取cookie失败");
                            return;
                        }
                    }catch(Exception e){
                        回复(msg,"登录接口失效！"+e);
                    }return;
                }
            }
        }).start();
    }catch(Exception e){
        回复(msg,"获取失败"+e);
    }
}public String httpget(String url,String cookie){
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try{
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        uc.setRequestProperty("Cookie",cookie);
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
}public String httppost(String urlPath,String cookie,String data){
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try{
        URL url = new URL(urlPath);
        uc =(HttpURLConnection)url.openConnection();
        uc.setDoInput(true);
        uc.setDoOutput(true);
        uc.setConnectTimeout(2000000);
        uc.setReadTimeout(2000000);
        uc.setRequestMethod("POST");
        uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        uc.setRequestProperty("Cookie",cookie);
        uc.getOutputStream().write(data.getBytes("UTF-8"));
        uc.getOutputStream().flush();
        uc.getOutputStream().close();
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
            Toast("错误:\n"+e);
        }
    }if(buffer.length()==0)return buffer.toString();
    buffer.delete(buffer.length()-1,buffer.length());
    return buffer.toString();
}public String sendEmail(String MyQQ,String MyName,String skey,String pskey,String toWho,String subject,String content){
    try{
        String cookie="uin=o0"+MyQQ+";skey="+skey+";p_skey="+pskey;
        String result=httpget("https://w.mail.qq.com/cgi-bin/login?vt=passport&vm=wsk&delegate_url=&f=xhtml&target=&ss=1",cookie);
        int st=result.indexOf("https://w.mail.qq.com/cgi-bin/today?sid=");
        int end=result.indexOf("&first=1");
        String sid="sid获取失败"+result.substring(result.length()-50);
        if(st!=-1&&end!=-1){
            sid=result.substring(st+40,end);
            String put="RedirectY29tcG9zZV9zZW5kP21vYmlsZXNlbmQ9MSZzPQ__=%E5%8F%91%E9%80%81&showto=&to=%22"+toWho+"%22%3C"+toWho+"%3E%3B&subject="+subject+"&content="+content+"&frommobile=frommobile&sendname="+MyName+"&sid="+sid;
            String re2=httppost("https://w.mail.qq.com/cgi-bin/cgi_redirect",cookie,put);
            String error=toWho+" 发送成功";
            if(re2==null||re2.equals(""))error="发送失败，请检查sid("+sid+")是否正确";
            if(re2.contains("composed_success"))return error;
            int st=re2.indexOf("<div class=\"system_error_tips_cnt\">");
            if(st!=-1)error="发送失败:"+re2.substring(st+38);
            error=error.substring(0,error.indexOf("</b>"));
            return error;
        }else return sid;
    }catch(Exception e){
        return "发送失败,原因:\n"+e;
    }
}