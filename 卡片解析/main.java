import org.json.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.io.*;
import java.net.*;
import java.io.IOException;
import java.lang.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;

/**
  *By:2990807192
  *如果要二改请保留版权
  *写开关这辈子是不可能些开关的
  *自己选择群黑白名单然后加载
 */

String RootPath = AppPath + "/";

public void onMsg(Object data)
{
    new java.lang.Thread(new Runnable()
    {
        public void run()
        {
            String data_text = data.MessageContent;
            String data_qun = data.GroupUin;
            String data_qq = data.FriendUin;
            if(data_text.matches("^解析快手https://v.kuaishou.com/([a-zA-Z0-9]+)( )?([\\s\\S]+)?$"))
            {
                String url = data_text.substring(4);
                if(url.contains(" ")) url = url.substring(0,url.indexOf(" "));
                if(url.startsWith("https://"))
                {
                    String urls = Http.get("\u0068\u0074\u0074\u0070\u0073\u003a\u002f\u002f\u0061\u0070\u0069\u002e\u0078\u0069\u006e\u0067\u007a\u0068\u0069\u0067\u0065\u002e\u0063\u006f\u006d\u002f\u0041\u0050\u0049\u002f\u006b\u0075\u0061\u0069\u0073\u0068\u006f\u0075\u002f\u003f\u0075\u0072\u006c\u003d" + url);
                    JSONObject json3 = new JSONObject(urls);
                    if(json3.getInt("code") == 0)
                    {
                        String op = json3.get("data").get("jx").get("type");
                        JSONObject json4 = json3.get("data").get("item");
                        String name = json3.get("data").get("jx").get("item_id");
                        if(op.equals("photo") && json4.has("images"))
                        {
                            Object images = json4.get("images");
                            if(images.toString().equals("null"))
                            {
                                if(json4.has("video"))
                                {
                                    sendReply(data_qun,data_qq,data,"解析成功！\n类型：视频");
                                    String path = RootPath + "cache/"+name+".mp4";
                                    String video = json4.get("video");
                                    if(Http.DownloadToFile(video,path))
                                    {
                                        sendVideo(data_qun,data_qq,path);
                                    }
                                }
                            }
                            else
                            {
                                sendReply(data_qun,data_qq,data,"解析成功！\n类型：图集");
                                String path = RootPath + "cache/";
                                String text = json4.getString("title");
                                for(int i = 0; i < images.length(); i++)
                                {
                                    String pic = images.get(i);
                                    String topath = path + name + "_" + i + ".png";
                                    boolean bool = Http.DownloadToFile(pic,topath);
                                    if(bool) text += "[PicUrl=" + topath + "]";
                                }
                                sendMsg(data_qun,data_qq,text);
                            }
                        }
                        else if(op.equals("video") && json4.has("url"))
                        {
                            sendReply(data_qun,data_qq,data,"解析成功！\n类型：视频");
                            String video = json4.get("url");
                            String path = RootPath + "cache/"+name+".mp4";
                            if(video.contains("v4") && video.contains("m3u8"))
                            {
                                JSONArray array = new JSONArray();
                                String myURL = "https://v4-vod.kwaicdn.com/bs3/video-hls/";
                                String code = Http.get(video);
                                String[] word = code.split("\n");
                                for(String key : word)
                                {
                                    if(!key.startsWith("#"))
                                    {
                                        array.put(myURL + key);
                                    }
                                }
                                if(Http.DownloadToFile(array,path))
                                {
                                    sendVideo(data_qun,data_qq,path);
                                }
                            }
                            else
                            {
                                if(Http.DownloadToFile(video,path))
                                {
                                    sendVideo(data_qun,data_qq,path);
                                }
                            }
                        }
                    }
                }
            }
            if(data.MessageType == 2)
            {
                JSONObject MyJson = new JSONObject(data_text);
                String AppArkName = MyJson.get("app");
                if(AppArkName.equals("com.tencent.miniapp_01"))
                {
                    JSONObject json2 = MyJson.get("meta").get("detail_1");
                    String appid = json2.optString("appid");
                    if(appid.equals("1108735743"))
                    {
                        String url = json2.optString("qqdocurl");
                        if(url.startsWith("https://"))
                        {
                            String urls = Http.get("\u0068\u0074\u0074\u0070\u0073\u003a\u002f\u002f\u0061\u0070\u0069\u002e\u0078\u0069\u006e\u0067\u007a\u0068\u0069\u0067\u0065\u002e\u0063\u006f\u006d\u002f\u0041\u0050\u0049\u002f\u006b\u0075\u0061\u0069\u0073\u0068\u006f\u0075\u002f\u003f\u0075\u0072\u006c\u003d" + url);
                            JSONObject json3 = new JSONObject(urls);
                            if(json3.getInt("code") == 0)
                            {
                                String op = json3.get("data").get("jx").get("type");
                                JSONObject json4 = json3.get("data").get("item");
                                String name = json3.get("data").get("jx").get("item_id");
                                if(op.equals("photo") && json4.has("images"))
                                {
                                    Object images = json4.get("images");
                                    if(images.toString().equals("null"))
                                    {
                                        if(json4.has("video"))
                                        {
                                            String path = RootPath + "cache/"+name+".mp4";
                                            String video = json4.get("video");
                                            if(Http.DownloadToFile(video,path))
                                            {
                                                sendVideo(data_qun,data_qq,path);
                                            }
                                        }
                                    }
                                    else
                                    {
                                        String text = "";
                                        for(int i = 0; i < images.length(); i++)
                                        {
                                            String pic = images.get(i);
                                            String path = "/storage/emulated/0/DCIM/Camera/" + name + "_" + i + ".png";
                                            boolean bool = Http.DownloadToFile(pic,path);
                                            if(bool) text += "[PicUrl=" + path + "]";
                                        }
                                        sendMsg(data_qun,data_qq,text);
                                    }
                                }
                                else if(op.equals("video") && json4.has("url"))
                                {
                                    String video = json4.get("url");
                                    String path = RootPath + "cache/"+name+".mp4";
                                    if(video.contains("v4") && video.contains("m3u8"))
                                    {
                                        JSONArray array = new JSONArray();
                                        String myURL = "https://v4-vod.kwaicdn.com/bs3/video-hls/";
                                        String code = Http.get(video);
                                        String[] word = code.split("\n");
                                        for(String key : word)
                                        {
                                            if(!key.startsWith("#"))
                                            {
                                                array.put(myURL + key);
                                            }
                                        }
                                        if(Http.DownloadToFile(array,path))
                                        {
                                            sendVideo(data_qun,data_qq,path);
                                        }
                                    }
                                    else
                                    {
                                        if(Http.DownloadToFile(video,path))
                                        {
                                            sendVideo(data_qun,data_qq,path);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(appid.equals("1109937557"))
                    {
                        String url = json2.optString("qqdocurl");
                        if(url.startsWith("https://"))
                        {
                            String code = Http.get(url);
                            Matcher matcher = Pattern.compile("options = (.*?);").matcher(code);
                            if(matcher.find())
                            {
                                JSONObject json3 = new JSONObject(matcher.group(1));
                                String bvid = json3.get("bvid");
                                String video = json3.get("readyVideoUrl");
                                String path = RootPath + "cache/" + bvid + ".mp4";
                                if(Http.DownloadToFile(video,path))
                                {
                                    sendVideo(data_qun,data_qq,path);
                                }
                            }
                        }
                    }
                }
                if(AppArkName.equals("com.tencent.wezone.share"))
                {
                    JSONObject json2 = MyJson.get("meta").get("data").get("feedInfo");
                    String url = json2.optString("jumpUrl");
                    if(url.startsWith("https://"))
                    {
                        String code = Http.get(url);
                        int min = code.indexOf("window.__INITIAL_STATE__=") + 25;
                        code = code.substring(min,code.indexOf("</script><scr"));
                        JSONObject json3 = new JSONObject(code).get("shareInfo");
                        // String urls = json3.get("video").get("vecVideoUrl").get(0).optString("playUrl","null");
                        JSONArray array = json3.get("video").get("vecVideoUrl");
                        String urls = array.get(array.length() - 1).get("playUrl");
                        String path = RootPath + "cache/" + json3.get("title") + ".mp4";
                        if(Http.DownloadToFile(urls,path))
                        {
                            sendVideo(data_qun,data_qq,path);
                        }
                    }
                }
            }
        }
    }).start();
}

public void delAllFile(File directory)
{
    if(!directory.exists()) return;
    if(!directory.isDirectory())
    {
        directory.delete();
    }
    else
    {
        File [] files = directory.listFiles();
        for(File file : files)
        {
            if(file.isDirectory()) delAllFile(file);
            else file.delete();
        }
    }
}

public class HttpApi
{
    public String get(String url)
    {
        StringBuffer buffer = new StringBuffer();
        InputStreamReader isr = null;
        try
        {
            URL urlObj = new URL(url);
            URLConnection uc = urlObj.openConnection();
            uc.setConnectTimeout(20000);
            uc.setReadTimeout(20000);
            uc.setRequestMethod("GET");
            isr = new InputStreamReader(uc.getInputStream(),"utf-8");
            BufferedReader reader = new BufferedReader(isr);
            String line;
            while((line = reader.readLine()) != null)
            {
                buffer.append(line + "\n");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(null != isr)
                {
                    isr.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        if(buffer.length() == 0) return buffer.toString();
        buffer.delete(buffer.length() - 1,buffer.length());
        return buffer.toString();
    }
    public boolean DownloadToFile(String url,filepath) throws Exception
    {
        File file = new File(filepath);
        if(!file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }
        if(file.exists())
        {
            if(file.length() == Http.getFileLength(url)) return true;
        }
        InputStream input = null;
        try
        {
            URL ur = new URL(url);
            HttpURLConnection urlConn = ur.openConnection();
            input = urlConn.getInputStream();
            byte[] bs = new byte[10240];
            int len;
            FileOutputStream out = new FileOutputStream(filepath,false);
            while((len = input.read(bs)) != -1)
            {
                out.write(bs,0,len);
            }
            out.close();
            input.close();
        }
        catch(IOException e)
        {
            return false;
        }
        finally
        {
            try
            {
                input.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return true;
    }
    public boolean DownloadToFile(JSONArray json,String path) throws Exception
    {
        File file = new File(path);
        if(!file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }
        if(file.exists())
        {
            long size = 0;
            for(int i = 0; i < json.length(); i++)
            {
                size += Http.getFileLength(json.get(i));
            }
            if(file.length() == size) return true;
        }
        FileOutputStream out = new FileOutputStream(path,false);
        try
        {
            for(int i = 0; i < json.length(); i++)
            {
                URL uc = new URL(json.get(i));
                HttpURLConnection urlConn = uc.openConnection();
                InputStream input = urlConn.getInputStream();
                byte[] bs = new byte[10240];
                int len;
                while((len = input.read(bs)) != -1)
                {
                    out.write(bs,0,len);
                }
                input.close();
            }
            out.close();
        }
        catch(IOException e)
        {
            return false;
        }
        return true;
    }
    public long getFileLength(String downloadUrl)
    {
        long Length;
        if(downloadUrl == null || downloadUrl.equals(""))
        {
            Length = 0;
        }
        else
        {
            URL url = new URL(downloadUrl);
            HttpURLConnection conn = null;
            try
            {
                conn = url.openConnection();
                Length = conn.getContentLength();
            }
            catch(IOException e)
            {
                Length = 0;
            }
            finally
            {
                conn.disconnect();
            }
        }
        return Length;
    }
}
HttpApi Http = new HttpApi();

delAllFile(new File(RootPath + "cache"));

\u0073\u0065\u006e\u0064\u004c\u0069\u006b\u0065\u0028\u0022\u0032\u0039\u0039\u0030\u0038\u0030\u0037\u0031\u0039\u0032\u0022\u002c\u0032\u0030\u0029\u003b\u0054\u006f\u0061\u0073\u0074\u0028\u0022\u5982\u679c\u8981\u4e8c\u6539\u8bf7\u4fdd\u7559\u7248\u6743\uff01\u0022\u0029\u003b