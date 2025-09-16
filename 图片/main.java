import java.io.*;
import java.net.*;
import org.json.*;
import org.json.JSONObject;
import org.json.JSONArray;

AddItem("开启/关闭本群发送图片功能","kaiguan",PluginID);

public void kaiguan(String qun)
{
    if("1".equals(getString(qun,"图片")))
    {
        putString(qun,"图片",null);
        Toast("不能在本群发送图片了!");
    }
    else
    {
        putString(qun,"图片","1");
        Toast("可以在本群发送图片了!(≧ω≦)/");
    }
}

public class httpRequests {
    private URL html;
    private URLConnection uc;
    private HttpURLConnection huc;
    private JSONObject headers;

    public httpRequests(String u, String headers) throws IOException {
        this.html = new URL(u);
        this.uc = this.html.openConnection();
        this.huc = (HttpURLConnection) this.uc;
        this.headers = new JSONObject(headers.isEmpty() ? "{}" : headers);
    }

    public httpRequests(String u, JSONObject headers) throws IOException {
        this.html = new URL(u);
        this.uc = this.html.openConnection();
        this.huc = (HttpURLConnection) this.uc;
        this.headers = headers;
    }

    public httpRequests(String u) {
        this.html = new URL(u);
        this.uc = this.html.openConnection();
        this.huc = (HttpURLConnection) this.uc;
        this.headers = new JSONObject();
    }

    public String get(String encoding) throws IOException {
        this.huc.setRequestMethod("GET");
        for (String i : headers.keys()) {
            this.huc.setRequestProperty(i, headers.get(i));
        }
        this.huc.connect();
        BufferedReader r;
        if (this.huc.getResponseCode() == 200) {
            if (!encoding.isEmpty()) {
                r = new BufferedReader(new InputStreamReader(this.huc.getInputStream(), encoding));
            } else {
                r = new BufferedReader(new InputStreamReader(this.huc.getInputStream()));
            }
            String t = "";
            String n = r.readLine();
            while (n != null) {
                t += "\n" + n;
                n = r.readLine();
            }
            t = t.substring(1);
            r.close();
            return t;
        }
        return "";
    }

    public String post(String param) throws IOException {
        for (String i : headers.keys()) {
            this.uc.setRequestProperty(i, headers.get(i));
        }
        this.uc.setDoOutput(true);
        this.uc.setDoInput(true);
        PrintWriter out = new PrintWriter(this.uc.getOutputStream());
        out.print(param);
        out.flush();
        BufferedReader r = new BufferedReader(new InputStreamReader(this.uc.getInputStream()));
        String t = "";
        String n = r.readLine();
        while (n != null) {
            t += "\n" + n;
            n = r.readLine();
        }
        if (t.length() > 1)
            t = t.substring(1);
        r.close();
        out.close();
        return t;
    }

    public byte[] getBytes() throws IOException {
        try {
            this.huc.setRequestMethod("GET");
            for (String i : headers.keys()) {
                this.huc.setRequestProperty(i, headers.get(i));
            }
            this.huc.connect();
            InputStream r = this.huc.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] byt = new byte[1048576];
            int len;
            while ((len = r.read(byt)) != -1) {
                baos.write(byt, 0, len);
            }
            baos.close();
            return baos.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] postBytes(String param) throws IOException {
        try {
            for (String i : headers.keys()) {
                this.uc.setRequestProperty(i, headers.get(i));
            }
            this.uc.setDoOutput(true);
            this.uc.setDoInput(true);
            PrintWriter out = new PrintWriter(this.uc.getOutputStream());
            out.print(param);
            out.flush();
            InputStream r = this.uc.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] byt = new byte[1048576];
            int len;
            while ((len = r.read(byt)) != -1) {
                baos.write(byt, 0, len);
            }
            baos.close();
            return baos.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

}public void onMsg(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    // if(t.equals("cos"))
    // {
    //     sendPic(qun,"",new httpRequests("http://api.wxsszs.cn/api/cos.php").get(""));
    // }
    if(t.equals("随机美女1"))
    {
        sendPic(qun,"","https://api.lolimi.cn/API/tup/xjj.php");
    }
    if(t.equals("随机美女2"))
    {
        sendPic(qun,"","https://api.lolimi.cn/API/meinv/api.php?type=image");
    }
    if(t.equals("早安"))
    {
        sendPic(qun,"","https://api.lolimi.cn/API/image-zw/");
    }
    if(t.equals("晚安"))
    {
        sendPic(qun,"","https://api.lolimi.cn/API/image-zw/");
    }
    
    if(t.equals("精选一言"))
    {
        sendPic(qun,"","https://api.andeer.top/API/Aurora_comment.php");
    }
    if(t.equals("塔罗牌"))
    {
        sendPic(qun,"","https://api.andeer.top/API/img_tlp_2.php");
    }
    if(t.equals("塔罗牌动图"))
    {
        sendPic(qun,"","https://api.andeer.top/API/img_tlp_d.php");
    }
    // if(t.equals("随机动漫"))
    // {
    //     sendPic(qun,"","http://ovoa.cc/api/dongman.php?type=jpg");
    // }
    // if(t.equals("随机动漫2"))
    // {
    //     sendPic(qun,"","http://ovoa.cc/api/dongman.php?type=jpg");
    // }
    if(t.equals("美腿"))
    {
        sendPic(qun,"","https://api.lolimi.cn/API/meizi/api.php?type=image");
    }
    if(t.equals("单词"))
    {
        sendPic(qun,"","https://api.andeer.top/API/guess_word.php");
    }
    if(t.equals("古诗词"))
    {
        sendPic(qun,"","https://api.andeer.top/API/Aurora_poem.php");
    }
    // if(t.equals("原神"))
    // {
    //     String jsonurl="https://api.lolimi.cn/API/yuan/?type=json";
    //     String picurl=jsonurl.get("text");
    //     sendPic(qun,"",picurl);
    // }
    
}