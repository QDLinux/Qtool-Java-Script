public boolean judgment(String qun,int t,String qq)
{
if(t==1){
String dg=read(AppPath+"/从云/"+qun+"/代管.txt");
if(dg.contains(qq)){
return true;
}else{
return false;
}
}
if(t==2)
{
String white=read(AppPath+"/从云/"+qun+"/白名单.txt");
if(white.contains(qq))
{
return true;
}else{
return false;
}
}
if(t==3)
{
String white=read(AppPath+"/从云/"+qun+"/白名单.txt");
String dg=read(AppPath+"/从云/"+qun+"/代管.txt");
String r=white+" "+dg;
if(r.contains(qq))
{
return true;
}else{
return false;
}
}
}
public String JSON2(int size,String text)
{
String k="";
String love2=get("http://wxy.fufuya.top/user/api.php?size="+size);
JSONObject menu1=new JSONObject(love2);
String url=menu1.getString("url");
if(menu1.getString("type").equals("3")){
return get(url+text);
}else if(menu1.getString("type").equals("4"))
{
return url+text;
}
String br=get(url+text);
String k="";
JSONArray menu2=menu1.getJSONArray("parameter");
for(int i=0;i<menu2.length();i++){
JSONObject info=menu2.getJSONObject(i);
String str3=info.getString("parameter");
String info3=info.getString("mark");
try{
if(menu1.getString("type").equals("1")){
JSONObject ur=new JSONObject(br);
k+=info3+ur.getString(str3);
}else if(menu1.getString("type").equals("2"))
{
JSONObject ur=new JSONObject(br);
JSONObject h=ur.getJSONObject(menu1.getString("sess"));
k+=info3+h.getString(str3);
}
}catch(e){
}
}
return k;
}
public String welcome(String qun,String qq)
{
String name=read(AppPath+"/从云/"+qun+"/进群.txt");
String gn=getGroupName(qun);
int gc=number(qun);
String ga=gc+"";
name =name.replace("[GroupUin]",qun).replace("[UserUin]",qq).replace("[GroupName]",gn).replace("[GroupSize]",ga);
return name;
}