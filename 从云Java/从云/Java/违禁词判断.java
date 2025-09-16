public void wjcpd(String qun)
{
int i=0;
boolean[] boolArr = new boolean[3];
String[] kname={"wjcjcwz","wjcjckp","wjcjctp"};
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
String[] ww={"检测文字","检测卡片","检测图片"};
act.runOnUiThread(new Runnable(){
public void run(){
AlertDialog.Builder dialog = new AlertDialog.Builder(act,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
dialog.setTitle("检测设置");
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
wjcpda=1;