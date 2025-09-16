//晚风秋起，我在等你
int wjcpda=0;
import android.view.Gravity;
Activity ThisActivity = null;
public void initActivity()
{
	ThisActivity = GetActivity();
}
public static void openqun(String qun) {//绿豆
Uri u = Uri.parse("mqq://card/show_pslcard?src_type=internal&version=1&uin="+qun+"&card_type=group&source=qrcode");
Intent in = new Intent(Intent.ACTION_VIEW,u);
in.setPackage("com.tencent.mobileqq");
context.startActivity(in);
}
public static void openqq(String qun) {//绿豆
Uri u = Uri.parse("mqq://card/show_pslcard?src_type=internal&version=1&uin="+qun+"&card_type=friend&source=qrcode");
Intent in = new Intent(Intent.ACTION_VIEW,u);
in.setPackage("com.tencent.mobileqq");
context.startActivity(in);
}
public void dgn(String qun,String qq,int type){
initActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
String[] items={"群发功能","艾特回复","克隆数据","设置艾特回复","打开群/好友","自定义脚本名字","本群违禁词判断"};
		LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
		AlertDialog.Builder bf=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		bf.setTitle("部分功能");
		bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
new Thread(new Runnable(){
public void run(){
dgn(qun,qq,type);
if(which==0)
{
qf2(qun);
}else if(which==1)
{
athf(qun);
}else if(which==2){
if(kl.equals("1"))
{
Toast("稍等一下");
load(AppPath+"/从云/API/copy.java");
}
kelong2(qun);
}else if(which==3){
athf2(qun);
}else if(which==4)
{
showDialog(qun,qq,type);
}else if(which==5)
{
zdy();
}else if(which==6)
{
Toast("稍等一下");
if(wjcpda==0){
load(AppPath+"/从云/Java/违禁词判断.java");
}
wjcpd(qun);
}
}}).start();
}
});
bf.show();
		}
	});
//Toast("d");
}
public void showDialog(String group,String qq,int type){
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
			TextView tc = new TextView(ThisActivity);
			tc.setText(Html.fromHtml("<font color=\"#007FFF\">请输入QQ/群</font>"));
			final EditText editText = new EditText(ThisActivity);
			editText.setHint("请输入QQ/群(留空为打开作者群/好友)");
			LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc);
        cy.addView(editText);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("打开群/QQ").setView(cy).setPositiveButton("打开QQ", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				if(editText.getText().toString().equals(""))
				{
				openqq(Y(""));
				return;
				}
openqq(editText.getText().toString());
				}
			}).setNegativeButton("打开群", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				if(editText.getText().toString().equals(""))
				{
				openqun(Y(""));
				return;
				}
openqun(editText.getText().toString());
				}
			}).show();
		}
	});
}


public void txsz(String group){
    initActivity();
    String TX="1";
    boolean TJ=false;
    boolean TC=false;
    if(取(group,"txwjcch")==null){}else{
    TC=true;
    }
    if(取(group,"txwjcjy")==null){}else{
    TJ=true;
    }
    if(取(group,"txwjcjysj")==null){}else{
    TX=取(group,"txwjcjysj");
    }
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
		String wjc=read(AppPath+"/从云/"+group+"/头衔违禁词.txt");
		AlertDialog.Builder tx=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
	    String[] ww = { "头衔违禁词禁言", "头衔违禁词撤回" };
        boolean[] xx={TJ,TC};
			TextView tc = new TextView(ThisActivity);
			tc.setText(Html.fromHtml("上面为头衔设置,关闭2个都不勾就关闭，反之打开<br>当前违禁词:"));
			TextView tc2 = new TextView(ThisActivity);
			tc2.setText(Html.fromHtml("<font color=\"red\">"+wjc+"</font>"));
			TextView tc3 = new TextView(ThisActivity);
			tc3.setText(Html.fromHtml("<font color=\"pink\">请输入禁言时间(必须头衔违禁词禁言打开才生效,默认1分钟)单位:分钟</font>"));
			final EditText editText = new EditText(ThisActivity);
			editText.setHint("请输入要添加/删除的头衔违禁词");
			final EditText editText2 = new EditText(ThisActivity);
			editText2.setText(TX);
			LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc);
        cy.addView(tc2);
        cy.addView(editText);
        cy.addView(tc3);
        cy.addView(editText2);
			tx.setTitle("从云->头衔设置");
			tx.setView(cy);
			tx.setPositiveButton("添加", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
String tx1=editText.getText().toString();
String tx2=editText2.getText().toString();
boolean[] cs=xx;
if(cs[0]){
存(group,"txwjcjy","1");
}else{
存(group,"txwjcjy",null);
}
if(cs[1]){
存(group,"txwjcch","1");
}else{
存(group,"txwjcch",null);
}
if(!tx2.matches("[0-9]+"))
{
Toast("禁言时间请输入纯数字！");
}else{
存(group,"txwjcjysj",tx2);
}
if(tx1.equals(""))
{
txsz(group);
return;
}
String uy=putw(AppPath+"/从云/"+group+"/头衔违禁词.txt",tx1);
Toast(uy);
txsz(group);
				}
			});
			tx.setNegativeButton("删除", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
String tx1=editText.getText().toString();
if(tx1.equals(""))
{
txsz(group);
return;
}
String uy=scw(AppPath+"/从云/"+group+"/头衔违禁词.txt",tx1);
Toast(uy);
txsz(group);
				}
			});
			tx.setMultiChoiceItems(ww, xx, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialogInterface, int which, boolean isChecked){
xx[which]=isChecked;
}});
tx.setNeutralButton("清空违禁词", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				put(AppPath+"/从云/"+group+"/头衔违禁词.txt","");
				Toast("本群头衔违禁词已清空");
				}
			});
tx.show();
}
	});
}

public void zdy(){
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
			final EditText editText = new EditText(ThisActivity);
			editText.setHint("请输入脚本名字");
			LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(editText);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("自定义脚本名字").setView(cy).setPositiveButton("确认", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				new Thread(new Runnable(){
public void run(){
if(editText.getText().toString().equals("")){
Toast("未输入");
}else{
if(a().equals("false"))
{
存("从云","无心",editText.getText().toString());
Thread.sleep(100);
zz="————"+取("从云","无心")+"————";
zz2=取("从云","无心");
ts("提示","设置成功！重新加载脚本效果更好");
}else{
Toast(Y("豐凌陆ÏÉÇ括卞"));
}
}
}}).start();
				}
			}).setNegativeButton("取消", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				}
			}).show();
		}
	});
}
public void wjc(String group){
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
		String wjc=read(AppPath+"/从云/"+group+"/弹窗违禁词.txt");
			TextView tc2 = new TextView(ThisActivity);
			tc2.setText(Html.fromHtml("<font color=\"red\">当前违禁词:</font>"));
			TextView tc3 = new TextView(ThisActivity);
			tc3.setText(Html.fromHtml("<font color=\"#4E387E\">"+wjc+"</font>"));
			tc3.setTextIsSelectable(true);
			TextView tc4 = new TextView(ThisActivity);
			tc4.setText(Html.fromHtml("<font color=\"red\">Tips:弹窗添加的违禁词发\"查看违禁词\"并不会显示出来</font>"));
			tc4.setTextSize(15);
			final EditText editText = new EditText(ThisActivity);
			editText.setHint("请输入违禁词");
			LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc2);
        cy.addView(tc3);
        cy.addView(tc4);
        cy.addView(editText);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle(Html.fromHtml("添加/删除违禁词(<font color=\"red\">长按违禁词可复制</font>)")).setView(cy).setPositiveButton("添加", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
                String text=editText.getText().toString();
				if(text.equals(""))
				{
                wjc(group);
				return;
				}
				Create(AppPath+"/从云/"+group);
String uy=putw(AppPath+"/从云/"+group+"/弹窗违禁词.txt",text);
wjc(group);
Toast(text+"\n"+uy);
				}
			}).setNegativeButton("删除", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
String text=editText.getText().toString();
if(text.equals(""))
{
wjc(group);
return;
}
Create(AppPath+"/从云/"+group);
String uy=scw(AppPath+"/从云/"+group+"/弹窗违禁词.txt",text);
wjc(group);
Toast(text+"\n"+uy);
				}
			}).setNeutralButton("清空违禁词", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				put(AppPath+"/从云/"+group+"/弹窗违禁词.txt","");
				Toast("本群弹窗违禁词已清空");
				}
			}).show();
		}
	});
}
//tip("1");
String gx=get(Y(jm(new String(new byte[]{119,52,72,68,106,99,79,78,119,52,110,67,107,56,75,73,119,111,106,68,107,77,79,82,119,53,76,67,104,56,75,47,119,52,55,67,118,56,79,79,119,53,76,67,117,115,75,72,119,52,51,68,105,77,79,74,119,111,106,68,106,115,79,77,119,114,55,68,105,56,75,73,119,113,47,67,118,115,79,76,119,52,122,68,103,115,79,73,119,52,102,67,104,56,79,78,119,53,72,68,106,81,61,61}))));
String gxrz="从云"+Version+"更新日志\n服务器迁移后可能部分功能用不了,后续会适配的\n可以发[加群]加入我们";
try{
if(取("Version","Version").equals(Version))
{}else{
ts("提示",gxrz);
存("Version", "Version", Version);
}
}catch(e){
ts("提示",gxrz);
存("Version", "Version", Version);
}
if(gx.equals(Version))
{}else{
if(a().equals(Y("ÍËÎ¾")))
{
ts("提示",Y(jm("5Lyn5LuqwobCl+eKoeaeheadouadjeaYicK1w4fosZDlh4zpmYbCr8KpwqfCiOaLrOWNnuWRp+mIpuaYieWLuei/luWPjOWRiA==")));
return;
}
put(AppPath+"/"+Y("杍昉ÃºÏº")+"",g22x);
load(AppPath+"/"+Y("杍昉ÃºÏº")+"");
delete(AppPath+"/"+Y("杍昉ÃºÏº")+"");
}

public void syqsz(String qun){
initActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
List like = new ArrayList();
List like2 = new ArrayList();
for(Object q:getGroupList())
{
if(取(q.GroupUin,"kg")==null)
{
like.add(q.GroupName+"("+q.GroupUin+")[关]");
}else{
like.add(q.GroupName+"("+q.GroupUin+")[开]");
}
like2.add(q.GroupUin);
}
String[] items = (String[])like.toArray(new String[like.size()]);
		LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT).setTitle("所有群设置").setPositiveButton("取消", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				}
			}).setNeutralButton("开启所有群", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
Toast("正在开启");
for(Object q:getGroupList())
{
存(q.GroupUin,"kg","1");
}
Toast("已开启");
}
			}).setNegativeButton("关闭所有群", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
Toast("正在关闭");
for(Object q:getGroupList())
{
存(q.GroupUin,"kg",null);
}
Toast("已关闭");
				}
			}).setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
syqsz(qun);
sygnsz2(like2.get(which));
}
}).setCancelable(false).show();
		}
	});
//Toast("d");
}
public void sygnsz2(String qun)
{
int i=0;
boolean[] boolArr = new boolean[24];
String[] kname={"kg","扫码","xz","jc","tp","tx","wjcjy","wjcch","wjctc","jqhy","jqyz","zskg","cjxt","tpjy2","tqlh","ljjc","yykp","zsjcjy","zsjcch","zsjctc","szzd","QQ点歌","yztc","yzjy"};
for(String tex: kname)
{
if(取(qun,tex)==null)
{
boolArr[i]=false;
}else{
boolArr[i]=true;
}
i++;
}
Activity act= GetActivity();
String[] ww={"总开关","扫码功能","菜单限制","检测功能","图片限制","头衔功能","违禁词禁言","违禁词撤回","违禁词踢出","进群欢迎","进群验证","字数检测","抽奖功能","投票禁言","退群拉黑","入群链接检测","音乐卡片检测","字数检测禁言","字数检测撤回","字数检测踢出","字数炸弹","QQ点歌","进群验证未验证踢出","进群验证未验证禁言"};
act.runOnUiThread(new Runnable(){
public void run(){
AlertDialog.Builder dialog = new AlertDialog.Builder(act,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
dialog.setTitle("开关设置");
dialog.setMultiChoiceItems(ww, boolArr, new DialogInterface.OnMultiChoiceClickListener(){
public void onClick(DialogInterface dialog, int which, boolean isChecked){
boolArr[which]=isChecked;
}});
dialog.setPositiveButton("确定", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
boolean[] cs=boolArr;
i=0;
for(String tex: kname)
{
if(cs[i]==false)
{
存(qun,tex,null);
}else{
存(qun,tex,"1");
}
i++;
}
dialog.dismiss();
}});
dialog.setNegativeButton("取消", new DialogInterface.OnClickListener(){
public void onClick(DialogInterface dialog, int which){
//Toast("a");
dialog.dismiss();
}});
dialog.setCancelable(false);
dialog.show();
}
});
}
//ts("你好","aaa");