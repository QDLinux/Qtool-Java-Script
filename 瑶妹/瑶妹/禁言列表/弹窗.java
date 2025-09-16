HashMap ForbiddenMap= new HashMap();public class ForbiddenGroup
{
String[] list;
long Time;
}



public String timeDate(long timeStamp) {try 
{
SimpleDateFormat sdf=new SimpleDateFormat("MM月-dd日 HH:mm:ss");
String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));return sd;} catch (ParseException e) {e.printStackTrace();return null;}}

public void 禁言列表(String qun,String qq,int type){if(type!=1){return;}initActivity();ThisActivity.runOnUiThread(new Runnable(){public void run(){try{String UserUin;String UserName;List 解list = new ArrayList();List troops = getForbiddenList(qun);int GroupNumber = troops.size();final String[] items = new String[GroupNumber];final boolean[] checkedItems = new boolean[GroupNumber];int GroupNumber = troops.size();for (int i=0;i<GroupNumber;i++){UserName = troops.get(i).UserName;UserUin = troops.get(i).UserUin;Endtime = troops.get(i).Endtime;items[i] = UserName+"("+UserUin+")\n"+timeDate(Endtime)+"\n";checkedItems[i] = false;}AlertDialog.Builder alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);alertDialog.setTitle("共("+GroupNumber+")人被禁");alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener(){public void onClick(DialogInterface dialog, int which, boolean isChecked){if(isChecked){解list.add(troops.get(which).UserUin);}else{解list.remove(troops.get(which).UserUin);}}});alertDialog.setPositiveButton("解禁选中", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){new Thread(new Runnable(){public void run(){int i = 0;for(String Uin:解list){Forbidden(qun, Uin, 解禁时间);i++;}if(i==0) Toast("没有人被禁言");else Toast("尝试解禁"+i+"人");return;}}).start();}});alertDialog.setNeutralButton("一键解禁", new DialogInterface.OnClickListener(){public void onClick(DialogInterface dialog, int which){new Thread(new Runnable(){public void run(){int i = 0;for(Object mlist:getForbiddenList(qun)){Forbidden(qun, mlist.UserUin, 解禁时间);i++;}if(i==0) Toast("没有人被禁言");else Toast("尝试解禁"+i+"人");return;}}).start();}});alertDialog.show();}catch(e){Toast("好像失败了？" + e);}}});}