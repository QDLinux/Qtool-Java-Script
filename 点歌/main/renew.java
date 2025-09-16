String MyVerstion="1.0.4";
public boolean renew(){
try{
String data=get("http://wuxinya.top/qqmusic/getlist.php");
JSONObject json=new JSONObject(data);
boolean ok=json.getBoolean("boolean");
if(ok){
JSONArray jsonArray = json.getJSONArray("data");
for(int i = 0;i<jsonArray.length();i++){
JSONObject item = jsonArray.getJSONObject(i);
String url=item.getString("url");
String path=item.getString("path");
if(!url.equals("")&&!path.equals("")&&url.startsWith("http")){
String path2=path.replace("{$Path}",Mpath);
File f1=new File(path2);
if(path2.contains("配置菜单.java")||path2.contains("main.java")||path2.contains("mydialog.java")){
if(f1.exists()){
}else{
download(url,path2);
}
}else{
download(url,path2);
}
}
}
}
return true;
}catch(e){
return false;
}
}
if(!renew()){
//Toastm("云更新错误");
}
String versiondata=get("http://wuxinya.top/qqmusic/getversiondata.php");
try{
JSONObject b=new JSONObject(versiondata);
//{"data":"暂无内容","version":"1.0.1","url":"https://wuxinya.top/qqmusic/QQmusic.zip"}
String data=b.getString("data");
String version=b.getString("version");
String url=b.getString("url");
if(!version.equals(MyVerstion)){
load(Mpath+"/main/Detection.java");
Detection(data,url,version);
}
}catch(e){
//Toastm("检测更新失败\n"+e);
}