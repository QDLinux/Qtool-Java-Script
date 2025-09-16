import android.app.Activity;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.graphics.*;
import android.graphics.drawable.*;


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

