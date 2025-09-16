import java.lang.*;
public void Create(String Path){
File dir = null;
try{
dir = new File(Path);
if(!dir.exists()){
dir.mkdirs();
}
}catch(Exception e){
Toastm(e);
}
}
HashMap FileMemCache = new HashMap();
public void put(String Path,String WriteData){
try{
FileMemCache.put(Path,WriteData);
File file = new File(Path);
FileOutputStream fos = new FileOutputStream(file);
if(!file.exists()){
file.createNewFile();}
byte[] bytesArray = WriteData.getBytes();fos.write(bytesArray);fos.flush();}catch(IOException ioe){}
}
public void putdata(String data,String file){
String jsondata=readdata2(file);
try{
if(jsondata==null){
JSONObject json = new JSONObject();
JSONObject json2 = new JSONObject();
JSONArray json1 = new JSONArray();
json.put("myuindata",data);
json1.put(json);
json2.put("数据存储",json1);
put(file,json2+"");
}else{
String mydata=data.replace("\"","\\\"");
if(jsondata.contains("\""+mydata+"\""))return;
JSONObject json=new JSONObject(jsondata);
JSONArray jsonArray = json.getJSONArray("数据存储");
JSONObject item = new JSONObject();
item.put("myuindata",data);
jsonArray.put(item);
json.put("数据存储",jsonArray);
put(file,json+"");
}
}catch(e){
ts("写入路径\""+file+"\"错误\n"+e);
}
}
public String readdata2(String path) {
try {
File file = new File(path);
StringBuilder content = new StringBuilder();
Scanner scanner = new Scanner(file);
while (scanner.hasNextLine()) {
content.append(scanner.nextLine()).append("\n");
}
scanner.close();
return content.toString();
} catch (Exception e) {
e.printStackTrace();
return null;
}
}
public List readdata(String file){
String mydata=readdata2(file);
List mynum = new ArrayList();
try{
JSONObject json=new JSONObject(mydata);
JSONArray jsonArray = json.getJSONArray("数据存储");
for(int i = 0;i<jsonArray.length();i++){
JSONObject item = jsonArray.getJSONObject(i);
String msg=item.getString("myuindata");
mynum.add(msg);
}
return mynum;
}catch(e){
return null;
}}
public void removefolderdocument(String path){
File folder = new File(path);
File[] files = folder.listFiles();
for (File file2 : files) {
if (!file2.isDirectory()) {
file2.delete();
}
}
}
new Thread(new Runnable(){
public void run(){
Create(Mpath+"/下载语音");
Create(Mpath+"/图片");
removefolderdocument(Mpath+"/下载语音/");
removefolderdocument(Mpath+"/图片/");
}}).start();