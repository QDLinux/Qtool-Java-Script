//无心
import android.content.*;
import android.graphics.*;
import java.io.*;
import android.os.Environment;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.common.app.BaseApplicationImpl;
import java.text.SimpleDateFormat;
String RootPath2 = Environment.getExternalStorageDirectory().getAbsoluteFile()+"/QTool/Plugin/冷雨Java/头像/";
public static String getTime()
{
	SimpleDateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日"), df2 = new SimpleDateFormat("E", Locale.CHINA), df3 = new SimpleDateFormat("HH:mm:ss");
	Calendar calendar = Calendar.getInstance();
	String TimeMsg1 = df1.format(calendar.getTime()), TimeMsg2 = df2.format(calendar.getTime()), TimeMsg3 = df3.format(calendar.getTime());
	if (TimeMsg1.contains("年0"))
		TimeMsg1 = TimeMsg1.replace("年0", "年");
	if (TimeMsg1.contains("月0"))
		TimeMsg1 = TimeMsg1.replace("月0", "月");
	if (TimeMsg2.contains("周"))
		TimeMsg2 = TimeMsg2.replace("周", "星期");
	String ied= TimeMsg1 + TimeMsg2 +TimeMsg3+"创建";
	jes =ied.replace(":","点");
	return jes;
	}
public Bitmap shangchuan(String 链接)
{
InputStream input = null;
Bitmap original =null;
try{
            URL urlsssss = new URL(链接);
            HttpURLConnection urlConn = (HttpURLConnection) urlsssss.openConnection();
            urlConn.setConnectTimeout(1000);
                urlConn.setReadTimeout(1000);
           input = urlConn.getInputStream(); 
   original = BitmapFactory.decodeStream(input).copy(Bitmap.Config.ARGB_8888, true);
           }
           catch (Exception e) {
            Toast(e+"");
        }
    return original;
}

public void bitmaptofile(Bitmap original,String filepath)
{
        File file = new File(filepath);
        if(!file.exists())
        {
        file.getParentFile().mkdirs();
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(filepath);
            original.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
        } catch (Exception e) {
            Toast(e+"");
        }
        }
}
public void uploadAvatar(String path)
{
TransferRequest transferRequest = new TransferRequest();
transferRequest.mIsUp = true;
transferRequest.mLocalPath = path;
transferRequest.mFileType = 22;
control.transferAsync(transferRequest);
}
ITransFileController control=BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(ITransFileController.class);
String QQ="";
String 链接="";
