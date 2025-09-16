public void 视频(Object data)
{
String quntext = data.MessageContent;
    String qq = data.UserUin;
    String qun = data.GroupUin;
if(("1".equals(getString(data.GroupUin,"视频系统"))))
   {




if(quntext.equals("随机小姐姐"))
{
String 视频=("http://api.yujn.cn/api/xjj.php");
try {
下载(视频, AppPath + "/视频/"+quntext+".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/"+quntext+".mp4");
提示("发送成功");
} catch (Exception e) {
Toast("错误");
}
}
if(quntext.equals("动漫视频"))
{
String 视频=("http://api.yujn.cn/api/dmsp.php");
try {
下载(视频, AppPath + "/视频/"+quntext+".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/"+quntext+".mp4");
提示("发送成功");
} catch (Exception e) {
Toast("错误");
}
}
if(quntext.equals("翻唱视频"))
  {
视频=("http://api.yujn.cn/api/fanchang.php");
try {
下载(视频, AppPath + "/视频/"+quntext+".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/"+quntext+".mp4");
提示("发送成功");
} catch (Exception e) {
Toast("错误");
}
}
if(quntext.equals("风景视频"))
  {
视频=("http://api.yujn.cn/api/haibian.php");
try {
下载(视频, AppPath + "/视频/"+quntext+".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/"+quntext+".mp4");
提示("发送成功");
} catch (Exception e) {
Toast("错误");
}
}
if(quntext.equals("足球视频"))
  {
视频=("http://api.yujn.cn/api/zuqiu.php");
try {
下载(视频, AppPath + "/视频/"+quntext+".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/"+quntext+".mp4");
提示("发送成功");
} catch (Exception e) {
Toast("错误");
}
}
if(quntext.equals("抖音潇潇"))
  {
视频=("http://api.yujn.cn/api/xiaoxiao.php");
try {
下载(视频, AppPath + "/视频/"+quntext+".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/"+quntext+".mp4");
提示("发送成功");
} catch (Exception e) {
Toast("错误");
}
}

if(quntext.equals("各类小姐姐"))
  {
视频=("http://api.yujn.cn/api/juhexjj.php");
try {
下载(视频, AppPath + "/视频/"+quntext+".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/"+quntext+".mp4");
提示("发送成功");
} catch (Exception e) {
Toast("错误");
}
}


if(quntext.equals("快手小姐姐"))
  {
视频=("http://api.yujn.cn/api/sbkl.php");
try {
下载(视频, AppPath + "/视频/"+quntext+".mp4");
提示("下载完毕，正在发送");
发送视频(qun, AppPath + "/视频/"+quntext+".mp4");
提示("发送成功");
} catch (Exception e) {
Toast("错误");
}
}





}
}