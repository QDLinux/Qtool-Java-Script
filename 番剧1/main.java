//作者:光(1478950015)
//交流群:193095561



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.File;
import org.json.*;
import org.json.JSONObject;
import org.json.JSONArray;
// import java.nio.ByteBuffer; 
// import java.nio.charset.Charset;
import java.util.Date;

AddItem("开启/关闭本群番剧搜索","soufan",PluginID);

public void soufan(String qun)
{
if("1".equals(getString(qun,"番剧搜索")))
	{
	putString(qun, "番剧搜索", null);
      Toast("本群番剧搜索已关闭");
	}
	else{
	putString(qun,"番剧搜索","1");
	Toast("本群番剧搜索已开启");
	}
}

load(AppPath+"/api/DownloadFile.java");

public String httpget(String url) {
		StringBuffer buffer = new StringBuffer();
		InputStreamReader isr = null;
		try {
		URL urlObj = new URL(url);
		URLConnection uc = urlObj.openConnection();
		uc.setConnectTimeout(15000);
		uc.setReadTimeout(15000);
		uc.setRequestProperty("build-time", Long.toString(new Date().getTime()));
		isr = new InputStreamReader(uc.getInputStream(), "utf-8");
		BufferedReader reader = new BufferedReader(isr);
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
		if (buffer.length() == 0) return buffer.toString();
		buffer.delete(buffer.length() - 1, buffer.length());
		return buffer.toString();
		}

public void 绘制图片(String file,String outfile,String name,String title,String tags,String actor){
// 图片宽度
        int width = 1300;
        // 图片高度
        int height = 375;

        // 读取图片文件
        Bitmap src = BitmapFactory.decodeFile(new File(file).getAbsolutePath());
        // 缩放图片
        Bitmap scaled = Bitmap.createScaledBitmap(src, width / 5, height, false);
        // 创建背景白色的图片
        Bitmap background = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(background);
        canvas.drawColor(Color.WHITE);
        // 绘制图片和文本
        canvas.drawBitmap(scaled, 0, 0, null);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);
        canvas.drawText(title, width / 5 + 42, 106, paint);
        paint.setColor(Color.GRAY);
        paint.setTextSize(38);
        canvas.drawText(tags, width / 5 + 44, 213, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(44);
        canvas.drawText(actor, width / 5 + 44, 325, paint);
        // 保存图片
        File output = new File(outfile+"/"+name+".jpg");
        background.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(output));
}

public void 拼接图片(String path1,String path2,String outpath,String name){
// 解码图片
        Bitmap image1 = BitmapFactory.decodeFile(path1);
        Bitmap image2 = BitmapFactory.decodeFile(path2);

        // 计算拼接后图片的高度
        int totalHeight = image1.getHeight() + image2.getHeight();

        // 创建新图片
        Bitmap newImage = Bitmap.createBitmap(image1.getWidth(), totalHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newImage);

        // 绘制第一张图片
        canvas.drawBitmap(image1, 0, 0, null);

        // 绘制黑线
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5); // 设置线条宽度为5像素
        canvas.drawLine(0, image1.getHeight(), image1.getWidth(), image1.getHeight(), paint);

        // 绘制第二张图片
        canvas.drawBitmap(image2, 0, image1.getHeight()+1, null);

        // 保存新图片
        newImage.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(outpath+"/"+name+".jpg"));
}

public void onMsg(Object data){
String quntext=data.MessageContent;
String qun=data.GroupUin;
String uin=data.UserUin;
if((data.IsGroup&&("1".equals(getString(data.GroupUin,"番剧搜索"))))){
if(quntext.startsWith("搜番")||quntext.equals("番剧排行榜")){
    String 番名=quntext.substring(2);
    if(番名.equals("")) sendMsg(qun,"","[AtQQ="+uin+"]\n未输入搜索内容");
else{
String menu0="";
	if(quntext.equals("番剧排行榜")) 
	 menu0=httpget("https://app.95189371.cn/ciyuancheng.php/v6/rank_video_list?id=1");
    else menu0=httpget("https://app.95189371.cn/ciyuancheng.php/v6/search?pg=1&text="+番名);
    JSONObject menu1=new JSONObject(menu0);
    JSONArray menu2=menu1.getJSONArray("data");
    if(menu2.length()==0){
        sendMsg(qun,"","[AtQQ="+uin+"]\n未搜到");
        return;
    }
    JSONArray 番=new JSONArray();
    sendMsg(qun,"","正在下载封面并合成图片，可能会等待较长时间，请稍等...");
    for(int i=0;i<menu2.length();i++){
        JSONObject info=menu2.getJSONObject(i);
        String name=info.getString("vod_name");
        String pic=info.getString("vod_pic");
        String year=info.getString("vod_year");
        String area=info.getString("vod_area");
        String actor=info.getString("vod_actor");
        String tag=info.getString("vod_class");
        番.put(new JSONObject().put("name",name).put("id",info.getString("vod_id")));
        String path;
        try{
            DownloadToFile(pic,AppPath+"/封面缓存/"+番名+i+".jpg");
            path=AppPath+"/封面缓存/"+番名+i+".jpg";
        }
        catch(Exception e){
            path=AppPath+"/下载失败.png";
        }
        int j=i+1;
        int k=i-1;
        绘制图片(path,AppPath+"/缓存/",番名+i,j+". "+name,year+"/"+area+"/"+tag,actor);
        if(k>=0) 拼接图片(AppPath+"/缓存/"+番名+k+".jpg",AppPath+"/缓存/"+番名+i+".jpg",AppPath+"/缓存/",番名+i);
        delete(AppPath+"/封面缓存/"+番名+i+".jpg");
        delete(AppPath+"/缓存/"+番名+k+".jpg");
    }
    int 长=menu2.length()-1;
//    Toast(AppPath+"/缓存/"+番名+长+".jpg");
    sendPic(qun,"",AppPath+"/缓存/"+番名+长+".jpg");
    sendMsg(qun,"","请发送序号来选择：");
    putString(qun,uin,番.toString());
    //Toast(getString(qun,uin));
    // Thread.sleep(10000);     //删除过快会导致图片发不出来
    // delete(AppPath+"/缓存/"+番名+长+".jpg");
}
}
// 绘制图片(AppPath+"/下载.jpeg",AppPath,"测试2","Angel Beats","2010/日本/麻枝准,key,AngleBeats!,P.A.WORKS","actor");
// 拼接图片(AppPath+"/测试.png",AppPath+"/测试2.png",AppPath,"合成测试");


if(quntext.matches("^[0-9]*$")&&getString(qun,uin)!=null){
    //Toast(getString(qun,uin));
    // String 结果=httpget("https://api.cycjson.xyz/ciyuancheng.php/v4/search?pg=1&text="+getString(qun,uin));
    // JSONObject 结果1=new JSONObject(结果);
    // JSONArray 结果2=结果1.getJSONArray("data");
    // int cl=Integer.parseInt(quntext);
    // if(cl>结果2.length()) return;
    // JSONObject info=结果2.getJSONObject(cl-1);
    // String id=info.getString("vod_id");
    // String name=info.getString("vod_name");
    // String pic=info.getString("vod_pic");
    // String year=info.getString("vod_year");
    // String area=info.getString("vod_area");
    // String actor=info.getString("vod_actor");
    // String tag=info.getString("vod_class");
    // String card="{\"app\":\"com.tencent.structmsg\",\"desc\":\"新闻\",\"view\":\"news\",\"ver\":\"0.0.0.1\",\"prompt\":\"[番剧]"+name+"\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"news\":{\"action\":\"\",\"android_pkg_name\":\"\",\"app_type\":1,\"appid\":101726879,\"ctime\":1674703307,\"desc\":\""+year+"/"+area+"/"+tag+"\\n"+actor+"\",\"jumpUrl\":\"https://www.cycdm01.top/bangumi/"+id+".html\",\"preview\":\""+pic+"\",\"source_icon\":\"\",\"source_url\":\"\",\"tag\":\"请使用浏览器打开\",\"title\":\""+name+"\",\"uin\":1478950015}},\"config\":{\"ctime\":1674703307,\"forward\":true,\"token\":\"7cdb89a3dfc8a814f5fff7c1f8870bc8\",\"type\":\"normal\"},\"text\":\"\",\"extraApps\":[],\"sourceAd\":\"\",\"extra\":\"\"}";
    // //sendMsg(qun,"",card);
    // \u0063\u0061\u0072\u0064\u003d\u0068\u0074\u0074\u0070\u0070\u006f\u0073\u0074\u0028\u0022\u0068\u0074\u0074\u0070\u0073\u003a\u002f\u002f\u0061\u0070\u0069\u002e\u0063\u0061\u006f\u006e\u006d\u002e\u006e\u0065\u0074\u002f\u0061\u0070\u0069\u002f\u006b\u0061\u0070\u002f\u006b\u002e\u0070\u0068\u0070\u003f\u0071\u0071\u003d\u0022\u002b\u004d\u0079\u0055\u0069\u006e\u002b\u0022\u0026\u0073\u006b\u0065\u0079\u003d\u0022\u002b\u0067\u0065\u0074\u0053\u006b\u0065\u0079\u0028\u0029\u002b\u0022\u0026\u0070\u0073\u006b\u0065\u0079\u003d\u0022\u002b\u0067\u0065\u0074\u0050\u0073\u006b\u0065\u0079\u0028\u0022\u0064\u006f\u0063\u0073\u002e\u0071\u0071\u002e\u0063\u006f\u006d\u0022\u0029\u002c\u0063\u0061\u0072\u0064\u0029\u003b
    // //Toast(card1);
    // sendCard(qun,"",card);
    JSONArray 结果=new JSONArray(getString(qun,uin));
    int cl=Integer.parseInt(quntext);
    if(cl>结果.length()) return;
    JSONObject 结果2=结果.optJSONObject(cl-1);
    sendMsg(qun,"","【"+结果2.getString("name")+"】请复制到浏览器打开\nhttps://www.cycdm01.top/watch/"+结果2.getString("id")+"/1/1.html");
    putString(qun,uin,null);
}
//if(quntext.contains("打不开")) sendPic(qun,"",AppPath+"/打不开.png");
}
}

//if(getSkey().equals("")) Toast("Skey用于发送JSON卡片补全token，请重新加载脚本以授权Skey");


public String httppost(String urlPath, String data)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            CookieManager cookieManager = new CookieManager();
CookieHandler.setDefault(cookieManager);
            try {
                URL url = new URL(urlPath);
			uc = (HttpURLConnection) url.openConnection();
			uc.setDoInput(true);
			uc.setDoOutput(true);
			uc.setConnectTimeout(2000000);// 设置连接主机超时（单位：毫秒）
			uc.setReadTimeout(2000000);// 设置从主机读取数据超时（单位：毫秒）
			uc.setRequestMethod("POST");
			uc.setRequestProperty("Content-Type", "application/json");
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
                    Toast("错误:\n"+e);
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
}


delAllFile(AppPath+"/缓存/");