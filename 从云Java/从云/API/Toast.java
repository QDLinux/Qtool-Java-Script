
import android.app.Activity;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.graphics.*;
public Bitmap bitmapurl(String url)
{
//Toast(url);
InputStream input = null;
Bitmap original =null;
try{
File file=new File(url);
if(file.exists()) original=BitmapFactory.decodeFile(url).copy(Bitmap.Config.ARGB_8888, true);
else{
            URL urlsssss = new URL(url);
            HttpURLConnection urlConn = (HttpURLConnection) urlsssss.openConnection();
            urlConn.setConnectTimeout(10000);
                urlConn.setReadTimeout(10000);
           input = urlConn.getInputStream(); 
   original = BitmapFactory.decodeStream(input).copy(Bitmap.Config.ARGB_8888, true);
}
           }
           catch (Exception e) {
         //   Toast(e+"");
        }
    return original;
}
public Drawable getDrawable(String filePath) {
	Bitmap bitmap = BitmapFactory.decodeFile(filePath);
	return getDrawable(bitmap);
}
public Drawable getDrawable(Bitmap bitmap) {
	Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);
	return drawable;
}
public Drawable getDrawable(Drawable drawable) {
	return drawable;
}
public void mToast(String text,Object img,boolean iflong,int type,int x,int y)
{
int time;
if(iflong) time=Toast.LENGTH_LONG;
else time=Toast.LENGTH_SHORT;
activity.runOnUiThread(new Runnable()
	{
		public void run()
		{
Toast MyToast = Toast.makeText(context, text, time);
MyToast.setGravity(type, x, y);
if(img!=null&&!img.equals(""))
{
LinearLayout toastView = (LinearLayout) MyToast.getView();
   ImageView imageCodeProject = new ImageView(context);
   imageCodeProject.setImageDrawable(getDrawable(img));
   toastView.addView(imageCodeProject, 0);
   }
MyToast.show();
}
	});
}
import com.tencent.common.app.BaseApplicationImpl;
Object app=BaseApplicationImpl.getApplication().getRuntime();
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
PackageManager pm = context.getPackageManager();
ApplicationInfo sAppInfo = pm.getApplicationInfo("com.tencent.mobileqq",PackageManager.GET_META_DATA);
String UUID = sAppInfo.metaData.getString("com.tencent.rdm.uuid");
String Version_Code = UUID.substring(0,UUID.indexOf("_"));
int QQ_version=Integer.parseInt(Version_Code);
import com.tencent.mobileqq.app.BaseActivity;
BaseActivity activity;
while(activity==null){
activity=BaseActivity.sTopActivity;
}
import com.tencent.mobileqq.troop.api.ITroopInfoService;
ITroopInfoService TroopInfo=app.getRuntimeService(ITroopInfoService.class);

public String quncode(String qun) {
   String code= TroopInfo.getTroopCodeByTroopUin(qun);
   if(code==null||code.equals("")) code=qun;
   return code;
}
public String qunuin(String code) {
   String qun= TroopInfo.getTroopUinByTroopCode(code);
   if(qun==null||qun.equals("")) qun=code;
   return qun;
}