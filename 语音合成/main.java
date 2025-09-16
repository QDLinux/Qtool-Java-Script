import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URLEncoder;
import java.util.Base64;

String RootPath = AppPath+"/";
load(RootPath+"HttpClient.java");
load(RootPath+"FileManage.java");
load(RootPath+"配置文件.java");

public class HttpApi{
    public String get(String url)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL urlObj = new URL(url);
                HttpURLConnection uc = urlObj.openConnection();
                uc.setConnectTimeout(100000);
                uc.setReadTimeout(100000);
                isr = new InputStreamReader(uc.getInputStream(), "utf-8");
                BufferedReader reader = new BufferedReader(isr); //缓冲
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
            } catch (Exception e) {
            if (null != isr) {
                        isr.close();
                    }
                e.printStackTrace();
            } finally {
                try {
                    if (null != isr) {
                        isr.close();
                    }
                } catch (IOException e) {
                if (null != isr) {
                        isr.close();
                    }
                    e.printStackTrace();
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
	}
}
HttpApi http = new HttpApi();

public void onMsg(Object data)
{
String quntext=data.MessageContent;
String qun=data.GroupUin;
String qq=data.UserUin;
String nick=data.SenderNickName;
if(quntext.matches("#(.*)说(.*)")){
    quntext = quntext.substring(1);
    String r;
        for(str : quntext.split("说")){
            r = str;
            break;
        }
    String y = quntext.substring(quntext.indexOf("说")+1);
    //变量 r 角色名
    //变量 y 角色说的话
    String url = "https://api.lolimi.cn/api/yyhc/y.php?msg="+y+"&speaker="+r;
    JSONObject response = new JSONObject(http.get(url));
    if(response.get("code").equals(200)){
        //GET 200 Success
        String path = RootPath+"/缓存/来自"+r+"的话-"+y+".mp3";
        url = response.get("music");
            boolean A = httpa.DownloadToFile(url,path,2);
            if(!A){
                sendMsg(qun,"","GET "+response.get("code")+" 1error(mp3 download fail)");
            }
            else{
                sendVoice(qun,"",path);
                delAllFile(new File(RootPath+"/缓存"),0);
            }
    }
    else{
        sendMsg(qun,"","GET "+response.get("code")+" 0error");
    }
}
}


