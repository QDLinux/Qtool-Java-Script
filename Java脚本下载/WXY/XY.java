



























//有一种红线叫爱情，有一种错过叫缘分。




























































































String yue="";
List like = new ArrayList();
List like2 = new ArrayList();
import java.nio.charset.StandardCharsets;
boolean OK2=false;
List file3 = new ArrayList();
String url3="";
String WXY="";
String file2="";
String id="";
List like0 = new ArrayList();
List like3 = new ArrayList();
List like4 = new ArrayList();
List like5 = new ArrayList();
List like6 = new ArrayList();
List like7 = new ArrayList();
List time = new ArrayList();
List like10 = new ArrayList();
Activity ThisActivity = null;
public void initActivity()
{
	ThisActivity = GetActivity();
}
public void showDialog(){
OK2=false;
//Toast("a");
initActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
//比较笨的方法，每次打开清空list，防止重复
like0.clear();
like4.clear();
like5.clear();
like6.clear();
like7.clear();
like.clear();
time.clear();
jb="";
try{
yu =yu.replace(",]","]");
JSONObject menu1=new JSONObject(yu);
JSONArray menu2=menu1.getJSONArray("huzan");//json解析
String uin2="";
//Toast("b");
for(int i=0;i<menu2.length();i++){//解析json数据并list存储
JSONObject info=menu2.getJSONObject(i);
String uin=info.getString("name");
String bb=info.getString("version");
like.add(uin+"("+bb+")");
like0.add(info.getString("zz"));//作者
time.add(info.getString("time"));//下载
like4.add(info.getString("size"));//大小
like5.add(info.getString("ms"));//描述
like7.add(info.getString("id"));
like6.add(bb);//版本
}
}catch(e){
Toast("错误\n"+e);
}
String[] items = (String[])like.toArray(new String[like.size()]);  
		LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle("脚本下载->主页面(下滑查看更多)").setView(cy).setPositiveButton("QTool脚本", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
                public void run(){
				ts3("提示","正在加载，请稍候");
				yue=get("https://qtool.haonb.cc/getList");
				qtool();
				OK2=true;
				}}).start();
				}
			}).setNeutralButton("刷新列表", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
                public void run(){
                ts3("提示","正在刷新，请稍候");
                yu=get("http://171.115.223.160:5555/ScriptList.php");
                showDialog();
                OK2=true;
                }}).start();
				}
			}).setNegativeButton("取消", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{

				}
			}).setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
int str2=which;
WXY=which+"";
showDialog2( items[which]+"\n作者:"+like0.get(str2)+"\n大小:"+like4.get(str2)+"\n版本:"+like6.get(str2)+"\n上传时间:\n"+time.get(str2)+"\n---------\n"+like5.get(str2)+"");
}
}).setCancelable(false).show();
		}
	});
}
public void qtool(){
OK2=false;
initActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
like0.clear();
like4.clear();
like5.clear();
like6.clear();
like7.clear();
like.clear();
time.clear();
jb="";
try{
yue="{\"huzan\":"+yue+"}";
JSONObject menu1=new JSONObject(yue);
JSONArray menu2=menu1.getJSONArray("huzan");//json解析
String uin2="";
//Toast("b");
for(int i=0;i<menu2.length();i++){
JSONObject info=menu2.getJSONObject(i);
String uin=info.getString("PluginName");
String bb=info.getString("PluginVersion");
like.add(uin+"("+bb+")");
like0.add(info.getString("PluginAuthor"));//作者
time.add(info.getString("UploadTime"));//下载
like4.add(info.getString("Size"));//大小
like5.add(info.getString("Desc"));//描述
like7.add(info.getString("PluginID"));
like6.add(bb);//版本
like10.add(uin);
}
}catch(e){
Toast("错误\n"+e);
}
String[] items = (String[])like.toArray(new String[like.size()]);  
		LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle("脚本下载->QTOOL(下滑查看更多)").setView(cy).setPositiveButton("返回上一级", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
public void run(){
ts3("提示","正在获取，请稍候");
yu=get("http://171.115.223.160:5555/ScriptList.php");
showDialog();
OK2=true;
}}).start();
				}
			}).setNeutralButton("刷新列表", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
                public void run(){
				ts3("提示","正在获取，请稍候");
                yue=get("https://qtool.haonb.cc/getList");
                qtool();
                OK2=true;
                }}).start();
				}
			}).setNegativeButton("取消", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{

				}
			}).setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
WXY=which+"";
int str2=which;
long HY=Long.parseLong(like4.get(str2));
String LO=formatSize(HY);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String TI = sdf.format(new Date(Long.parseLong(time.get(str2))));
qtool2( items[which]+"\n作者:"+like0.get(str2)+"\n大小:"+LO+"\n版本:"+like6.get(str2)+"\n上传时间:\n"+TI+"\n---------\n"+like5.get(str2)+"");
}
}).setCancelable(false).show();
		}
	});
//Toast("d");
}

public void ts3(String Title, String Content)
{
	Activity ThisActivity = GetActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
	public void run() {
			//final ProgressDialog pd = new ProgressDialog(ThisActivity);
			ProgressDialog pd = new ProgressDialog(ThisActivity,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
			pd.setTitle(Title);
			pd.setMessage(Content);
			pd.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which)
				{
				
				}
			});
			pd.setCancelable(false);
			pd.show();
            new Thread() {
            public void run() {
            while(true){
            Thread.sleep(500);
                if(OK2==true)
                {
               // break;
                pd.dismiss();
               break;
                }
                }
            };
        }.start();
		}
	});
}
public void ts(String title,String text){
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
		LinearLayout cy=new LinearLayout(ThisActivity);
		TextView tc = new TextView(ThisActivity);
		text=text.replaceAll("\n","<br>");
		tc.setText(Html.fromHtml("<font color=\"#F9A7B0\">"+text+"</font"));
		tc.setTextSize(15);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle(title).setView(cy).setPositiveButton("上传", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
                public void run(){
                OK2=false;
                ts3("提示","正在上传，请稍候");
                File file = new File(file2);
                String he=url3.replace("\"","”");
                get(he);
                sendPost("http://171.115.223.160:5555/abc.php?id="+id,fileConvertToByteArray(file));
                ts2("提示","上传成功,等待完成审核即可");
                OK2=true;
				}}).start();
				}
			}).setNegativeButton("取消", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
                public void run(){
				//取消自动删除打包好的文件，防止占用空间
				Delete(file2);
				}}).start();
				}
			}).setCancelable(false).show();
		}
	});
}
public void showDialog2(String text){
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
		LinearLayout cy=new LinearLayout(ThisActivity);
		TextView tc = new TextView(ThisActivity);
			tc.setText(text);
			tc.setTextSize(20);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc);
        
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle("下载脚本").setView(cy).setPositiveButton("下载", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
                public void run(){
                try{
                OK2=false;
                ts3("提示","正在下载，请稍候...");
				int str2=Integer.parseInt(WXY);
				String uy=like7.get(str2);
				//Toast(uy);
                download("http://171.115.223.160:5555/Script/zip/"+uy+".zip",AppPath+"/a.zip");
                Thread.sleep(500);
                dealUnZip(AppPath+"/a.zip",FILE);
                Delete(AppPath+"/a.zip");
			    ts2("提示","下载完成，可以到QTool本地脚本查看该脚本(彩豆用户无效的。目前只适配qtool)");
			    OK2=true;
			    //Delete(AppPath+"/"+zipname+".zip");
			    }catch(e){
			    ts2("提示","下载脚本时候发生错误了\n"+e);
			    OK2=true;
			    break;
			    }
			    }}).start();
				}
			}).setNegativeButton("返回", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
new Thread(new Runnable(){
public void run(){
ts3("提示","正在刷新，请稍候");
yu=get("http://171.115.223.160:5555/ScriptList.php");
showDialog();
OK2=true;
}}).start();
				}
			}).setCancelable(false).show();
		}
	});
}
public void qtool2(String text){
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
		LinearLayout cy=new LinearLayout(ThisActivity);
		TextView tc = new TextView(ThisActivity);
			tc.setText(text);
			tc.setTextSize(20);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc);
        
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle("下载脚本").setView(cy).setPositiveButton("下载", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
                public void run(){
                try{
                OK2=false;
                ts3("提示","正在下载，请稍候...");
				int str2=Integer.parseInt(WXY);
				String uy=like7.get(str2);
				//Toast(uy);
				String ub=get("https://qtool.haonb.cc/reqDL?key="+uy);
				JSONObject b=new JSONObject(ub);
                String uc=b.getString("url");
                download(uc,AppPath+"/a.zip");
                Thread.sleep(500);
                Create(FILE+like10.get(str2));
                dealUnZip(AppPath+"/a.zip",FILE+like10.get(str2)+"/");
                Delete(AppPath+"/a.zip");
			    ts2("提示","下载完成，可以到QTool本地脚本查看该脚本(彩豆用户无效的。目前只适配qtool)");
			    OK2=true;
			    }catch(e){
			    ts2("下载脚本时候错误了。原因\n"+e);
			    OK2=true;
			    break;
			    }
			    }}).start();
				}
			}).setNegativeButton("返回", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
new Thread(new Runnable(){
public void run(){
ts3("提示","正在获取，请稍候");
yue=get("https://qtool.haonb.cc/getList");
qtool();
OK2=true;
}}).start();
				}
			}).setCancelable(false).show();
		}
	});
}

//showDialog();

public void ts2(String Title, String Content)
{
	Activity ThisActivity = GetActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run() {
			AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).create();
			alertDialog.setTitle(Title);
			alertDialog.setMessage(Content);
			alertDialog.setCancelable(false);
			alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {}
			});
			alertDialog.show();
		}
	});
}
import java.io.File;
public void file2(String path,String name){
File folder = new File(path);  // 文件夹路径
File[] files = folder.listFiles();  // 获取文件夹中的所有文件和文件夹
for (File file : files) {
    if (file.isDirectory()) {  // 判断是否为文件夹
    if(file.getName().contains(name)||name.equals(""))
    {
        file3.add(file.getName());  // 输出文件夹名
        }
    }
}
  }
  public void showDialog3(){
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
 EditText editText = new EditText(ThisActivity);
editText.setHint("Search...");
        String[] items = (String[])file3.toArray(new String[file3.size()]);  
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setView(editText).setTitle("选择要上传的Java脚本").setPositiveButton("搜索", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
new Thread(new Runnable(){
public void run(){
OK2=false;
file3.clear();
ts3("提示","正在搜索...");
file2(FILE,editText.getText().toString());
showDialog3();
OK2=true;
}}).start();
				}
			}).setNegativeButton("取消", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{

				}
			}).setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
new Thread(new Runnable(){
public void run(){
try{
OK2=false;
Toast("正在验证文件...");
String file4=FILE+items[which];
ts3("提示","正在打包,请稍候...");
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date1 = new Date();
String currentTime = dateFormat.format(date1);
File file10 = new File(file4+"/info.prop");
if(!Judge(file4+"/info.prop").equals("true"))
{
ts2("提示",file4+"\n脚本不存在info.prop,重新改改吧");
OK2=true;
break;
}
if(!Judge(file4+"/desc.txt").equals("true"))
{
ts2("提示",file4+"\n脚本不存在desc.txt,重新改改吧");
OK2=true;
break;
}
if(!Judge(file4+"/main.java").equals("true"))
{
ts2("提示",file4+"\n脚本不存在main.java,重新改改吧");
OK2=true;
break;
}
String ms=read(file4+"/desc.txt");
String App=file4+"/info.prop";
long time= System.currentTimeMillis();
//long time2= time/1000;
File ner = new File(AppPath+"/文件/"+time+".zip");
Toast("正在打包...");
ys(AppPath+"/文件/"+time+".zip",file4);
Toast("正在收集信息...");
String name=readprop(App,"name");
String ver=readprop(App,"version");
String aut=readprop(App,"author");
String jbid=readprop(App,"id");
id=time+"";
long h=getFileSize(ner);
String dx= formatSize(h);
String uy="脚本名字:"+name+"\n版本:"+ver+"\n作者:"+aut+"\n脚本大小:"+dx+"\n脚本ID:"+jbid;
String ms2=ms.replaceAll("\n","\n");
ts("上传提示",uy+"\n上传时间:\n"+currentTime+"\n脚本描述\n"+ms2);
String ms3=ms.replaceAll("\n","\\\\n");
url3="http://171.115.223.160:5555/Upload.php?name="+name+"&size="+dx+"&time="+currentTime+"&zuozhe="+aut+"&ms="+ms3+"&id="+time+"&version="+ver;
url3 =url3.replace("+","%2B");
file2=AppPath+"/文件/"+time+".zip";
OK2=true;
}catch(e){
ts2("提示","打包文件时候错误了\n"+e);
OK2=true;
break;
}
}}).start();
}
}).setCancelable(false).show();
		}
	});
}