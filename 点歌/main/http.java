import java.net.*;
import java.io.*;
public String get(String url)
{
StringBuffer buffer = new StringBuffer();
InputStreamReader isr = null;
try {
URL urlObj = new URL(url);
URLConnection uc = urlObj.openConnection();
uc.setRequestProperty("User-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36");
uc.setConnectTimeout(10000);
uc.setReadTimeout(10000);
isr = new InputStreamReader(uc.getInputStream(), "utf-8");
BufferedReader reader = new BufferedReader(isr); //缓冲
String line;
while ((line = reader.readLine()) != null) {
    buffer.append(line + "\n");
}
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
    if (null != isr) {
isr.close();
    }
} catch (IOException e) {
    e.printStackTrace();
}
}
if(buffer.length()==0)return buffer.toString();
buffer.delete(buffer.length()-1,buffer.length());
return buffer.toString();
}
public String getreferer(String url)
{
StringBuffer buffer = new StringBuffer();
InputStreamReader isr = null;
try {
URL urlObj = new URL(url);
URLConnection uc = urlObj.openConnection();
uc.setRequestProperty("User-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36");
uc.setRequestProperty("Referer", "https://y.qq.com/portal/player.html");
uc.setConnectTimeout(10000);
uc.setReadTimeout(10000);
isr = new InputStreamReader(uc.getInputStream(), "utf-8");
BufferedReader reader = new BufferedReader(isr); //缓冲
String line;
while ((line = reader.readLine()) != null) {
    buffer.append(line + "\n");
}
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
    if (null != isr) {
isr.close();
    }
} catch (IOException e) {
    e.printStackTrace();
}
}
if(buffer.length()==0)return buffer.toString();
buffer.delete(buffer.length()-1,buffer.length());
return buffer.toString();
}
public String post(String url,String params) {
    try {
        URL urlObjUrl=new URL(url);
        URLConnection connection =urlObjUrl.openConnection();
        connection.setDoOutput(true);
        OutputStream os=connection.getOutputStream();
        os.write(java.net.URLDecoder.decode(params, "UTF-8").getBytes());
        os.close();
        InputStream iStream=connection.getInputStream();
        byte[] b=new byte[1024];
        int len;
        StringBuilder sb=new StringBuilder();
        while ((len=iStream.read(b))!=-1) {
            sb.append(new String(b,0,len));
        }
        return sb.toString();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
public String postWithAgentCookie(String url,String params,String cookie) {
    try {
        URL urlObjUrl=new URL(url);
        URLConnection connection =urlObjUrl.openConnection();
        connection.setRequestProperty("Cookie",cookie);
        connection.setRequestProperty("User-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.105 Safari/537.36");
        connection.setDoOutput(true);
        OutputStream os=connection.getOutputStream();
        os.write(java.net.URLDecoder.decode(params, "UTF-8").getBytes());
        os.close();
        InputStream iStream=connection.getInputStream();
        byte[] b=new byte[1024];
        int len;
        StringBuilder sb=new StringBuilder();
        while ((len=iStream.read(b))!=-1) {
            sb.append(new String(b,0,len));
        }
        return sb.toString();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
public String getWithAgentCookie(String url,String Agent,String Cookie) {
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL urlObj = new URL(url);
                URLConnection uc = urlObj.openConnection();
				uc.setRequestProperty("User-agent",Agent);
				uc.setRequestProperty("Cookie",Cookie);
                uc.setConnectTimeout(10000);
                uc.setReadTimeout(10000);
                isr = new InputStreamReader(uc.getInputStream(), "utf-8");
                BufferedReader reader = new BufferedReader(isr); //缓冲
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != isr) {
                        isr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
	}
public String getLocation(String downloadUrl) 
{
String na;
		  if(downloadUrl == null || "".equals(downloadUrl)){
			  na= "不存在"; 
		  }
		  else{
	      URL url = new URL(downloadUrl);
	      HttpURLConnection conn = null;
	      try {
	          conn = (HttpURLConnection) url.openConnection();
	          conn.setConnectTimeout(5000);
              conn.setReadTimeout(5000);
	          conn.setFollowRedirects(true);
	          conn.getResponseCode();
	          na=conn.getHeaderField("Location");
	          //Toastm(na);
	         // conn.setFollowRedirects(false);
	          //if(na.equals(downloadUrl)) ;
	          if(na==null) na=conn.getURL().toString();
	          //Toastm(na);
	      } catch (IOException e) {
	          na= "未知";
	      } finally {
	          conn.disconnect();
	    }
	    }
	    return na;
     }
     public String getWithAgentReferer(String url,String Agent,String Referer) {
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL urlObj = new URL(url);
                URLConnection uc = urlObj.openConnection();
				uc.setRequestProperty("User-agent",Agent);
				uc.setRequestProperty("Referer",Referer);
                uc.setConnectTimeout(10000);
                uc.setReadTimeout(10000);
                isr = new InputStreamReader(uc.getInputStream(), "utf-8");
                BufferedReader reader = new BufferedReader(isr); //缓冲
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != isr) {
                        isr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
	}
public void download(String url,String filepath) throws Exception
    {
        InputStream input = null;
        try {
            URL urlsssss = new URL(url);
            HttpURLConnection urlConn = (HttpURLConnection) urlsssss.openConnection();
            input = urlConn.getInputStream();
            maxsize=urlConn.getContentLength();
            byte[] bs = new byte[1024];
            int len;
            FileOutputStream out = new FileOutputStream(filepath, false);
            while((len = input.read(bs)) != -1)
            {
                out.write(bs, 0, len);
            }
            out.close();
            input.close();

        } catch (IOException e) {
            return;
        }
        finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
    public String post(String urlPath, String cookie,String data)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL url = new URL(urlPath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);
			uc.setDoOutput(true);
			uc.setConnectTimeout(2000000);// 设置连接主机超时（单位：毫秒）
			uc.setReadTimeout(2000000);// 设置从主机读取数据超时（单位：毫秒）
			uc.setRequestMethod("POST");
			if(cookie != null) {
			CookieManager cookieManager = new CookieManager();
CookieHandler.setDefault(cookieManager);
			uc.setRequestProperty("Cookie",cookie);
			}
			//uc.setRequestProperty("Referer","https://music.163.com");
            uc.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 10; ELE-AL00 Build/HUAWEIELE-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/98.0.4758.102 MQQBrowser/6.2 TBS/046403 Mobile Safari/537.36 V1_AND_SQ_8.9.33_3772_YYB_D QQ/8.9.33.10335 NetType/4G WebP/0.3.0 AppId/537151682 Pixel/1080 StatusBarHeight/75 SimpleUISwitch/0 QQTheme/2031753 StudyMode/0 CurrentMode/0 CurrentFontScale/1.0 GlobalDensityScale/0.90000004 AllowLandscape/false InMagicWin/0");
	uc.getOutputStream().write(data.getBytes("UTF-8"));
			uc.getOutputStream().flush();
			uc.getOutputStream().close();
                isr = new InputStreamReader(uc.getInputStream(), "utf-8");
                BufferedReader reader = new BufferedReader(isr); //缓冲
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != isr) {
                        isr.close();
                    }
                } catch (IOException e) {
                    Toastm("错误:\n"+e);
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
}
//download("http://q1.qlogo.cn/g?b=qq&nk="+Mqq+"&s=640",Mpath+"/图片/my.jpg");