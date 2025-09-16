public void 解析(Object data)
{
	String quntext = data.MessageContent;
	String qq = data.UserUin;
	String qun = data.GroupUin;


if(("1".equals(getString(qun,"视频解析"))))
{

if(quntext.contains("https://v.douyin.com/")||quntext.contains("https://share.huoshan.com/")||quntext.contains("https://weibo.com/")||quntext.contains("https://h5.weishi.qq.com/")||quntext.contains("https://xsj.qq.com/")||quntext.contains("https://www.ixigua.com/")||quntext.contains("https://share.izuiyou.com/")||quntext.contains("https://kg3.qq.com/"))
{
String regex = "(https?://[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(quntext);
String websiteUrl = "";
if(matcher.find()) {
websiteUrl = matcher.group(1);
}
new Thread(new Runnable() {
public void run() {
try {
String tt = get("https://api.kit9.cn/api/aggregate_videos/api.php?link=" + websiteUrl);
JSONObject jsonObject = new JSONObject(tt);
if(jsonObject.get("code")==200)
{
JSONObject dataObject = jsonObject.getJSONObject("data");
JSONObject authorObject = dataObject.getJSONObject("author");
String video_title = dataObject.getString("video_title");//视频标题
String video_link = dataObject.getString("video_link");//视频链接
//String video_cover = dataObject.getString("video_cover");//视频封面
String nameUrl = authorObject.getString("name");//用户名称
//String avatarUrl = authorObject.getString("avatar");//用户头像
sendm(qun,"标题:"+video_title+"\n用户:"+nameUrl+"\n直链:"+video_link);
下载(video_link, AppPath + "/视频/" + video_title + ".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/" + video_title + ".mp4");
提示("发送成功");
}else{
sendm(qun,"解析失败！");
}
} catch (Exception e) {
sendm(qun,"解析失败！"+e);
}
}
}).start();
}


if (quntext.contains("https://v.kuaishou.com/")) {
String regex = "(https?://[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(quntext);
String websiteUrl = "";
if (matcher.find()) {
websiteUrl = matcher.group(1);
}
new Thread(new Runnable() {

public void run() {
try {
String tt = get("http://xinnai.521314.love/API/dspjx.php?url=" + websiteUrl);
JSONObject jsonObject = new JSONObject(tt);
if(jsonObject.get("code")==200)
{
JSONObject dataObject = jsonObject.getJSONObject("data");
String titleUrl = dataObject.getString("title");
String videoUrl = dataObject.getString("videourl");
String authorUrl = dataObject.getString("author");
sendm(qun,"标题:"+titleUrl+"\n用户:"+authorUrl+"\n直链:"+videoUrl);
下载(videoUrl, AppPath + "/视频/" + titleUrl + ".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/" + titleUrl + ".mp4");
提示("发送成功");
}else{
sendm(qun,"解析失败！");
}
} catch (Exception e) {
sendm(qun,"解析失败！"+e);
}}
}).start();
}



if (quntext.contains("https://m.v.qq.com/")) {
String regex = "(https?://[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(quntext);
String websiteUrl = "";
if (matcher.find()) {
websiteUrl = matcher.group(1);
}

new Thread(new Runnable() {
public void run() {
try {
String tt = get("https://xiaoapi.cn/API/jx_tx2.php?url=" + websiteUrl);
JSONObject jsonObject = new JSONObject(tt);
if("200".equals(jsonObject.get("code")))
{
String title=jsonObject.getString("title");
String director=jsonObject.getString("director");
String actor=jsonObject.getString("actor");
String url=jsonObject.getString("url");
sendm(qun,"标题:"+title+"\n导演:"+director+"\n演员:"+actor+"\n直链:"+url);
}else{
sendm(qun,"解析失败！");
}
} catch (Exception e) {
sendm(qun,"解析失败！"+e);
}
}}).start();
}

}


}