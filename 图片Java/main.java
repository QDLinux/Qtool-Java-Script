import java.io.*;
import java.net.*;
import org.json.*;
sendLike("\u0032\u0036\u0035\u0039\u0037\u0038\u0039\u0036\u0031\u0036",20);
public class httpRequests{
    private URL html;
    private URLConnection uc;
    private HttpURLConnection huc;
    private JSONObject headers;
    public httpRequests(String u,String headers) throws IOException{
        this.html = new URL(u);
        this.uc = this.html.openConnection();
        this.huc = (HttpURLConnection)this.uc;
        this.headers = new JSONObject(headers.isEmpty()?"{}":headers);
    }public httpRequests(String u,JSONObject headers) throws IOException{
        this.html = new URL(u);
        this.uc = this.html.openConnection();
        this.huc = (HttpURLConnection)this.uc;
        this.headers = headers;
    }public httpRequests(String u){
        this.html = new URL(u);
        this.uc = this.html.openConnection();
        this.huc = (HttpURLConnection)this.uc;
        this.headers = new JSONObject();
    }public String get(String encoding) throws IOException{
        this.huc.setRequestMethod("GET");
        for(String i:headers.keys()){
            this.huc.setRequestProperty(i,headers.get(i));
        }this.huc.connect();
        BufferedReader r;
        if (this.huc.getResponseCode() == 200){
            if (!encoding.isEmpty()){
                r = new BufferedReader(new InputStreamReader(this.huc.getInputStream(),encoding));
            }else{
                r = new BufferedReader(new InputStreamReader(this.huc.getInputStream()));
            }
            String t = "";
            String n = r.readLine();
            while (n != null){
                t += "\n" + n;
                n = r.readLine();
            }
            t = t.substring(1);
            r.close();
            return t;
        }return "";
    }public String post(String param) throws IOException{
        for(String i:headers.keys()){
            this.uc.setRequestProperty(i,headers.get(i));
        }this.uc.setDoOutput(true);
        this.uc.setDoInput(true);
        PrintWriter out = new PrintWriter(this.uc.getOutputStream());
        out.print(param);
        out.flush();
        BufferedReader r = new BufferedReader(new InputStreamReader(this.uc.getInputStream()));
        String t = "";
        String n = r.readLine();
        while (n != null){
            t += "\n" + n;
            n = r.readLine();
        }if(t.length()>1)t = t.substring(1);
        r.close();
        out.close();
        return t;
    }public byte[] getBytes() throws IOException{
        try{
            this.huc.setRequestMethod("GET");
            for(String i:headers.keys()){
                this.huc.setRequestProperty(i,headers.get(i));
            }this.huc.connect();
            InputStream r = this.huc.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] byt = new byte[1048576];
            int len;
            while((len=r.read(byt))!=-1){
                baos.write(byt,0,len);
            }baos.close();
            return baos.toByteArray();
        }catch(Exception e){
            return null;
        }
    }public byte[] postBytes(String param) throws IOException{
        try{
            for(String i:headers.keys()){
                this.uc.setRequestProperty(i,headers.get(i));
            }this.uc.setDoOutput(true);
            this.uc.setDoInput(true);
            PrintWriter out = new PrintWriter(this.uc.getOutputStream());
            out.print(param);
            out.flush();
            InputStream r = this.uc.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] byt = new byte[1048576];
            int len;
            while((len=r.read(byt))!=-1){
                baos.write(byt,0,len);
            }baos.close();
            return baos.toByteArray();
        }catch(Exception e){
            return null;
        }
    }
}public void onMsg(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    if(t.equals("cos")){
        sendPic(qun,"",new httpRequests("http://api.wxsszs.cn/api/cos.php").get(""));
    }if(t.equals("随机壁纸")){
        sendPic(qun,"","https://api.lolimi.cn/API/tup/xjj.php");
    }
}
