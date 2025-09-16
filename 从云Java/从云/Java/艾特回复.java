
public void bmptofile(Bitmap bmp,String path){
File f= new File(path);
if(f.exists()){f.delete();}
if(!f.exists()){f.getParentFile().mkdirs();}
FileOutputStream   fs = new FileOutputStream(path);
bmp.compress(Bitmap.CompressFormat.PNG,100,fs);
fs.flush();
}
public Bitmap getbitmap(String path){
if(path.startsWith("http")){
try{
URL url1 = new URL(path);
HttpURLConnection urlc = url1.openConnection();
InputStream   inst = urlc.getInputStream();
Bitmap bmp = BitmapFactory.decodeStream(inst).copy(Bitmap.Config.ARGB_8888, true);
return bmp;
}catch(e){Toastb(e,tt()); return Bitmap.createBitmap(800,800,Bitmap.Config.ARGB_8888);}
}else{
try{
Bitmap  bmp= BitmapFactory.decodeStream(new FileInputStream(path)).copy(Bitmap.Config.ARGB_8888, true);
return bmp;
}catch(e){Toastb(e,tt());return Bitmap.createBitmap(800,800,Bitmap.Config.ARGB_8888);}
}
}
public void urltofile(String url,String path){
Bitmap  bmp= getbitmap(url);
bmptofile(bmp,path);
}
public void huifu(String qun){
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
		TextView tc = new TextView(ThisActivity);
			tc.setText(Html.fromHtml("<font color=\"#151B54\">发送\"艾特回复\"可了解更多</font>"));
			TextView tc1 = new TextView(ThisActivity);
			tc1.setText(Html.fromHtml("<font color=\"#151B54\">请输入回复语,留空为不设置(变量[Group]=群号;[Name]=发送者QQ;[At]=艾特发送者;[SendName]=发送者昵称)</font>"));
			TextView tc2 = new TextView(ThisActivity);
			tc2.setText(Html.fromHtml("<font color=\"#C11B17\">请输入禁言时间(分钟),留空为不设置</font>"));
			TextView tc3 = new TextView(ThisActivity);
			tc3.setText(Html.fromHtml("<font color=\"#C25A7C\">请输入语音链接/本地路径,留空为不设置</font>"));
			TextView tc4 = new TextView(ThisActivity);
			tc4.setText(Html.fromHtml("<font color=\"#4CC417\">请输入图片链接/本地路径,留空为不设置</font>"));
			final EditText sr1 = new EditText(ThisActivity);
			sr1.setHint("这边输入,变量自己看上面,输入时候要把中括号加上(换行直接回车就可以)");
			final EditText sr2 = new EditText(ThisActivity);
			sr2.setHint("这边输入,禁言时间（1-43200）");
			final EditText sr3 = new EditText(ThisActivity);
			sr3.setHint("这边输入,可以是语音链接，也可以是本地路径(2个都存在情况下优先选择本地路径)");
			final EditText sr4 = new EditText(ThisActivity);
			sr4.setHint("这边输入,可以是图片链接，也可以是本地路径(2个都存在情况下优先选择本地路径)");
			LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc);
        cy.addView(tc1);
        cy.addView(sr1);
        cy.addView(tc2);
        cy.addView(sr2);
        cy.addView(tc3);
        cy.addView(sr3);
        cy.addView(tc4);
        cy.addView(sr4);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("艾特回复").setView(cy).setPositiveButton(Html.fromHtml("<font color=\"#893BFF\">确认</font>"), new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
public void run(){
if(sr1.getText().toString().equals("")){
}else{
put(AppPath+"/从云/"+qun+"/回复.txt",sr1.getText().toString());
}
if(sr2.getText().toString().equals("")){
}else{
boolean result=sr2.getText().toString().matches("[0-9]+");
if(result==true){
int str2=Integer.parseInt(sr2.getText().toString());
if(str2>43200){
Toast("请输入比43200小的(禁言时间最多1个月(43200分钟))");
return;
}
if(str2<=0){
Toast("请输入比0大的");
return;
}
存(qun,"atjy2",sr2.getText().toString());
}else{
Toast("请输入纯数字");
}
}
if(sr3.getText().toString().equals("")){
}else{
if(sr3.getText().toString().startsWith("http"))
{
xz(sr3.getText().toString(),AppPath+"/从云/"+qun+"/1.mp3");
Toast("语音下载完成，已存储到"+AppPath+"/从云/"+qun+"/1.mp3");
//return;
}
String p=判(sr3.getText().toString());
if(p.equals("false"))
{
Toast("你输入的语音路径不存在");
}else{
存(qun,"atyy3",sr3.getText().toString());
}
}
if(sr4.getText().toString().equals("")){
}else{
if(sr4.getText().toString().startsWith("http"))
{
urltofile(sr4.getText().toString(),AppPath+"/从云/"+qun+"/pic.jpg");
Toast("图片下载完成，已存储到"+AppPath+"/从云/"+qun+"/pic.jpg");
//return;
}
String p=判(sr4.getText().toString());
if(p.equals("false"))
{
Toast("你输入的图片路径不存在");
}else{
存(qun,"attp3",sr4.getText().toString());
}
}
Toast("设置成功");
}}).start();
				}
			}).setNegativeButton(Html.fromHtml("<font color=\"#E3319D\">取消</font>"), new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
			    
				}
			}).show();
		}
	});
}
public void atsz1(String qun)
{
public boolean[] chose(){
boolean qd=false;
Activity act= GetActivity();
boolean atyy=true;
boolean atwz=true;
boolean attp=true;
boolean atjy=true;
boolean 艾特=true;
String[] ww={"艾特总开关","艾特语音回复","艾特文字回复","艾特图片回复","艾特禁言"};
if(取(qun,"atyy2")==null){atyy=false;}
if(取(qun,"atwz2")==null){atwz=false;}
if(取(qun,"attp2")==null){attp=false;}
if(取(qun,"atjy1")==null){atjy=false;}
if(取(qun,"艾特")==null){艾特=false;}
boolean[] xx={艾特,atyy,atwz,attp,atjy};
act.runOnUiThread(new Runnable(){
public void run(){
AlertDialog.Builder dialog = new AlertDialog.Builder(act,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
dialog.setTitle("艾特设置");
dialog.setMultiChoiceItems(ww, xx, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialog, int which, boolean isChecked){
xx[which]=isChecked;
}});
dialog.setPositiveButton("确定", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
//Toast("a");
dialog.dismiss();
qd=true;}});
dialog.setNegativeButton("取消", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
//Toast("a");
dialog.dismiss();
qd=false;}});
//dialog.setPositiveButton("取消", new DialogInterface.OnClickListener(){
//public void onClick(DialogInterface dialog, int which){
//Toast("a");
//dialog.dismiss();
//qd=false;}});
dialog.setCancelable(false);
dialog.show();
}
});
while(!qd){Thread.sleep(100);} return xx;
}
boolean[] cs=chose();
if(cs[0]){存(qun, "艾特","1");}else{存(qun, "艾特",null);}
if(cs[1]){存(qun, "atyy2","1");}else{存(qun, "atyy2",null);}
if(cs[2]){存(qun, "atwz2","1");}else{存(qun, "atwz2",null);}
if(cs[3]){存(qun, "attp2","1");}else{存(qun, "attp2",null);}
if(cs[4]){存(qun, "atjy1","1");}else{存(qun, "atjy1",null);}
}
wxy="2";
//huifu(qun);
//wxy="2";