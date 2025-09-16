String Ver_Name = "当前版本:天歌Java8.8内测"+ "\n"+"作者QQ:484151048"+"\n"+"官方群1065516401"+"\n"+"当前开启群聊数量:"+OpenGroupList.size();
public static String getMD5(String str) throws NoSuchAlgorithmException
{
	MessageDigest md5 = null;
	md5 = MessageDigest.getInstance("MD5");
	byte[] bs = md5.digest(str.getBytes());
	StringBuilder sb = new StringBuilder(40);
	for(byte x: bs)
	{
		if((x & 0xff) >> 4 == 0)
		{
			sb.append("0").append(Integer.toHexString(x & 0xff));
		}
		else
		{
			sb.append(Integer.toHexString(x & 0xff));
		}
	}
	return sb.toString();
}
public boolean isTopActivity(String packageName)
{
	ActivityManager __am = (ActivityManager) context.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
	List __list = __am.getRunningAppProcesses();
	if(__list.size() == 0) return false;
	for(ActivityManager.RunningAppProcessInfo __process: __list)
	{
		if(__process.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && __process.processName.equals(packageName))
		{
			return true;
		}
	}
	
	return false;
}
Step_Time3 = System.currentTimeMillis()-Step_Time3;
if(isTopActivity("com.tencent.mobileqq"))
{
	new Handler(Looper.getMainLooper()).post(new Runnable()
	{
		public void run()
		{
			String TString = Ver_Name;
			TString = TString + "\n本次加载耗时:" + (System.currentTimeMillis() - StartTime) + "毫秒";
			TString = TString + "\n过程1耗时:" + Step_Time1 + "毫秒";
			TString = TString + "\n过程2耗时:" + Step_Time2 + "毫秒";
			TString = TString + "\n过程3耗时:" + Step_Time3 + "毫秒";
			Toast MyToast = android.widget.Toast.makeText(context, TString, Toast.LENGTH_LONG);
			MyToast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 10);
			MyToast.show();
		}
	});
}
else
{
	return;
}

