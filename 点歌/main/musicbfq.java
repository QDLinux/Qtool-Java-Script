import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.widget.SeekBar;
import android.media.MediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import java.util.regex.*;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Path;
import android.graphics.drawable.ClipDrawable;
import android.widget.HorizontalScrollView;
import android.graphics.PixelFormat;
import android.view.LayoutInflater;
import android.view.MotionEvent;

WindowManager windowManager;
LinearLayout mainlayout;
MediaPlayer mp3;
Timer timer2;
Timer timer;
boolean myqjpd=true;
int x=0;
int y=0;
int initialX=0;
int initialY=0;
float initialTouchX;
float initialTouchY;
public Bitmap addShadowToBitmap(Bitmap originalBitmap) {
        Bitmap shadowBitmap = Bitmap.createBitmap(originalBitmap.getWidth(), originalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(shadowBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setMaskFilter(new BlurMaskFilter(25, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(originalBitmap, 0, 0, paint);
        return shadowBitmap;
    }
public Bitmap getpicshape(Bitmap originalBitmap,int radius,boolean shadow) {
Bitmap roundedBitmap = Bitmap.createBitmap(originalBitmap.getWidth(), originalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundedBitmap);
        Path path = new Path();
        float[] radii = { radius, radius, radius, radius, radius, radius, radius, radius };
        RectF rect = new RectF(0, 0, originalBitmap.getWidth(), originalBitmap.getHeight());
        path.addRoundRect(rect, radii, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(originalBitmap, 0, 0, null);
if(shadow){
return addShadowToBitmap(roundedBitmap);
}
return roundedBitmap;
}
public String modifyTimeStamps(String input) {
        Pattern pattern = Pattern.compile("\\[(\\d{2}):(\\d{2})\\.(\\d{2})\\]");
        Matcher matcher = pattern.matcher(input);
        StringBuffer modifiedOutput = new StringBuffer();
        while (matcher.find()) {
        try{
            int minutes = Integer.parseInt(matcher.group(1));
            int seconds = Integer.parseInt(matcher.group(2));
            int milliseconds = Integer.parseInt(matcher.group(3));
            int modifiedValue = minutes * 1;
            int modifiedValue2= seconds * 1;
            int modifiedValue3= milliseconds * 1;
            String msg=""+modifiedValue2+modifiedValue3;
            if(modifiedValue>0){
            int mt=modifiedValue*60;
            mt=mt+modifiedValue2;
            msg=""+mt+modifiedValue3;
            }
            matcher.appendReplacement(modifiedOutput, "["+msg+"]");
            }catch(e){}
        }
        matcher.appendTail(modifiedOutput);
        return modifiedOutput.toString();
    }
public String matchText(String inputText, int value) {
List util = new ArrayList();
int k=0;
        Pattern pattern = Pattern.compile("\\[(\\d+)](.*?)\n");
        Matcher matcher = pattern.matcher(inputText);
   //     String util="";
        while (matcher.find()) {
        util.add(matcher.group(2));
            int currentNumber = Integer.parseInt(matcher.group(1));
            if(value==currentNumber){
            return util.get(k);
            }else
            if (value < currentNumber) {
            return util.get(k-1);
            }
            k++;
        }
        return "未找到匹配的内容(可能纯音乐)";
    }
public String formatTime(int totalSeconds) {
if (totalSeconds < 0) {
            return "Invalid input";
        }

        int hours = totalSeconds / 3600;
        int remainingMinutes = (totalSeconds % 3600) / 60;
        int remainingSeconds = totalSeconds % 60;

        if (hours > 0) {
            String formattedHours = (hours < 10) ? "0" + hours : String.valueOf(hours);
            return formattedHours + ":" + ((remainingMinutes < 10) ? "0" + remainingMinutes : String.valueOf(remainingMinutes))
                    + ":" + ((remainingSeconds < 10) ? "0" + remainingSeconds : String.valueOf(remainingSeconds));
        } else {
            return ((remainingMinutes < 10) ? "0" + remainingMinutes : String.valueOf(remainingMinutes))
                    + ":" + ((remainingSeconds < 10) ? "0" + remainingSeconds : String.valueOf(remainingSeconds));
        }
}
public void processImage(String inputImagePath, String outputImagePath, int targetWidth, int targetHeight) {
        Bitmap originalBitmap = BitmapFactory.decodeFile(inputImagePath);
        if (originalBitmap != null) {
            int originalWidth = originalBitmap.getWidth();
            int originalHeight = originalBitmap.getHeight();
            float scaleWidth = (float) targetWidth / originalWidth;
            float scaleHeight = (float) targetHeight / originalHeight;
            float scaleFactor = Math.max(scaleWidth, scaleHeight);
            int finalWidth = (int) (originalWidth * scaleFactor);
            int finalHeight = (int) (originalHeight * scaleFactor);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, finalWidth, finalHeight, true);
            int cropStartX = (finalWidth - targetWidth) / 2;
            int cropStartY = (finalHeight - targetHeight) / 2;
            Bitmap croppedBitmap = Bitmap.createBitmap(scaledBitmap, cropStartX, cropStartY, targetWidth, targetHeight);
try {
        File file = new File(outputImagePath);
        FileOutputStream fos = new FileOutputStream(file);
        croppedBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        fos.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
            originalBitmap.recycle();
            scaledBitmap.recycle();
            croppedBitmap.recycle();
        }
    }
    public Bitmap convertLocalImageToBitmap(String imagePath,int radius) {
        Bitmap b1= BitmapFactory.decodeFile(imagePath);
        b1=getpicshape(b1,radius,false);
        return b1;
    }
public void mybfq(String singer,String name,String url,String picurl,String geci){
//Toastm(geci);
Toastm("点击图片关闭弹窗");
boolean bofang=false;
boolean mpd=false;
myqjpd=true;
int mtime2=0;
processImage(Mpath+"/图片/0.jpg",Mpath+"/图片/2.jpg",1000,300);
Bitmap b1= BitmapFactory.decodeFile(Mpath+"/图片/2.jpg");
b1=blurBitmap(b1,b1,5);
b1=getpicshape(b1,25,true);
BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), b1);

Bitmap ibitmap=convertLocalImageToBitmap(Mpath+"/图片/1.jpg",16);
ibitmap=compressBitmap(ibitmap,150,150);

Bitmap zt=convertLocalImageToBitmap(Mpath+"/mpic/zt.png",0);
zt=compressBitmap(zt,50,50);
Bitmap ks=convertLocalImageToBitmap(Mpath+"/mpic/ks.png",0);
ks=compressBitmap(ks,50,50);

Bitmap thumb= BitmapFactory.decodeFile(Mpath+"/mpic/thumb.jpg");
thumb=compressBitmap(thumb,40,40);
BitmapDrawable thumbDrawable = new BitmapDrawable(context.getResources(), thumb);
GetAct().runOnUiThread(new Runnable()
	{
		public void run(){
 windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        // 创建悬浮窗口的布局参数
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
        WindowManager.LayoutParams.MATCH_PARENT,
        WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
        PixelFormat.TRANSLUCENT
);
        params.gravity = Gravity.TOP | Gravity.START;
        if(x==0&&y==0){
        params.x = 0;
        params.y = 0;
        }else{
        params.x = x;
        params.y = y;
        }
        // params.flags=56;
        // params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
LinearLayout.LayoutParams param2= new LinearLayout.LayoutParams(6000, 0);

         mainlayout = new LinearLayout(GetAct());
         mainlayout.setOrientation(0);
         mainlayout.setPadding(15,15,15,15);
   //      mainlayout.setBackground(bitmapDrawable);
         LinearLayout l1=new LinearLayout(GetAct());
         l1.setOrientation(0);
         l1.setPadding(15,15,15,15);
         l1.setBackground(bitmapDrawable);
         LinearLayout l2=new LinearLayout(GetAct());
         l2.setOrientation(1);
         LinearLayout l3=new LinearLayout(GetAct());
         l3.setOrientation(1);
         LinearLayout l4=new LinearLayout(GetAct());
         l4.setOrientation(0);
         HorizontalScrollView horizontalScrollView = new HorizontalScrollView(GetAct());
         horizontalScrollView.setHorizontalScrollBarEnabled(false);
//smoothScrollBy(scrollAmount, 0);
     //    l3.setLayoutParams(new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,0.1f));
     ImageView i2=new ImageView(GetAct());
    // i2.setGravity(Gravity.CENTER_HORIZONTAL);
     i2.setImageBitmap(zt);
         ImageView i1=new ImageView(GetAct());
         i1.setImageBitmap(ibitmap);
         TextView t0=new TextView(GetAct());
         t0.setLayoutParams(param2);
         TextView t1=new TextView(GetAct());
         t1.setTypeface(mttf);
         t1.setEllipsize(TextUtils.TruncateAt.END);
         t1.setSingleLine(true);
         t1.setText(name);
         t1.setPadding(20,0,0,0);
         t1.setTextSize(20);
         t1.setTextColor(Color.parseColor("#FAFAFA"));
         TextView t2=new TextView(GetAct());
         t2.setTypeface(mttf);
         t2.setEllipsize(TextUtils.TruncateAt.END);
         t2.setSingleLine(true);
         t2.setText(singer);
         t2.setPadding(20,0,0,0);
         t2.setTextSize(13);
         t2.setTextColor(Color.parseColor("#FAFAFA"));
         TextView mgeci=new TextView(GetAct());
         mgeci.setTypeface(mttf);
         mgeci.setTextColor(Color.parseColor("#FAFAFA"));
         mgeci.setGravity(Gravity.CENTER_HORIZONTAL);
         mgeci.setTextSize(16);
         mgeci.setText("歌词demo");
         mp3=new MediaPlayer();
         mp3.setDataSource(url);//播放器准备
         mp3.setVolume(1F);
         mp3.prepare();
         TextView time1=new TextView(GetAct());
         time1.setTypeface(mttf);
         time1.setTextColor(Color.parseColor("#FAFAFA"));
         time1.setText("00:00");
         time1.setPadding(0,0,10,0);
         TextView time2=new TextView(GetAct());
         time2.setTypeface(mttf);
         time2.setTextColor(Color.parseColor("#FAFAFA"));
         time2.setText("00:00");
         time2.setPadding(10,0,0,0);
         SeekBar jd = new SeekBar(GetAct());
         jd.setMaxHeight(10);
 
         // ClipDrawable clipDrawable = new ClipDrawable(jd.getProgressDrawable(), Gravity.START, ClipDrawable.HORIZONTAL);
         // clipDrawable.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
         // jd.setProgressDrawable(clipDrawable);
          jd.setThumb(thumbDrawable);
        jd.getProgressDrawable().setColorFilter(Color.parseColor("#80D3D3D3"), PorterDuff.Mode.SRC_IN);
         
         
// ColorMatrix matrix = new ColorMatrix();
// matrix.setSaturation(0); // 0表示灰色，1表示原色
// ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
// jd.getProgressDrawable().setColorFilter(colorFilter);
//jd.getThumb().setColorFilter(colorFilter);
// jd.setProgressDrawable(getShape("#AAAAAA","#AAAAAA",5,10,20,false));
// //jd.setThumb(getShape("#FFFFFF","#F2F1F6",5,20,200,false));
// ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
         LinearLayout.LayoutParams param= new LinearLayout.LayoutParams(600,LinearLayout.LayoutParams.WRAP_CONTENT);
    param.gravity = Gravity.CENTER_HORIZONTAL;
         jd.setLayoutParams(param);
 timer2 = new Timer();
TimerTask task2 = new TimerTask() {
public void run() {
if(!mpd&&myqjpd){
mainlayout.post(new Runnable() {
public void run() {
//Toastm("c");
int mint=mtime2*100;
mgeci.setText(matchText(geci,mint));
}});
}
}};
timer = new Timer();
TimerTask task = new TimerTask() {
public void run() {
if(!mpd&&myqjpd){
mainlayout.post(new Runnable() {
public void run() {
time1.setText(formatTime(mtime2));
jd.setProgress(mtime2*1000);
mtime2++;
}});
}
}};
i1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
timer2.cancel();
timer.cancel();
myqjpd=false;
windowManager.removeView(mainlayout);
mp3.reset();
mp3.pause();
}});
//==========
mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {//播放完成监听
public void onCompletion(MediaPlayer mediaPlayer) {
mainlayout.post(new Runnable() {
public void run() {
jd.setProgress(0);
i2.setImageBitmap(ks);
bofang=true;
mpd=true;
mtime2=0;
jd.setProgress(0);
time1.setText("00:00");
// windowManager.removeView(mainlayout);
// mp3.reset();
// //mp3.reset();
}
});
}
});

//==========
int duration = mp3.getDuration();
jd.setMax(duration);
time2.setText(formatTime(duration/1000));
timer.scheduleAtFixedRate(task, 0, 1000);
timer2.scheduleAtFixedRate(task2, 0, 300);
mp3.start();
jd.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
public void onProgressChanged(SeekBar jd, int progress, boolean fromUser) {//滑动在哪里
if (fromUser) {
mp3.seekTo(progress);
mainlayout.post(new Runnable() {
public void run() {
time1.setText(formatTime(progress/1000));
}
});
}
}
public void onStartTrackingTouch(SeekBar jd) {//在滑动
mp3.pause();
i2.setImageBitmap(ks);
mpd=true;
}
public void onStopTrackingTouch(SeekBar jd3) {//离开滑动条
//jd.seekTo(jd3.getProgress());
mp3.start();
mtime2=jd3.getProgress()/1000;
i2.setImageBitmap(zt);
mpd=false;
}
});
         l4.setPadding(20,0,0,0);
         l1.addView(i1);
         l1.addView(l2);
         horizontalScrollView.addView(t1);
         l2.addView(horizontalScrollView);
         l2.addView(t2);
         l2.addView(t0);
         l4.addView(time1);
         l4.addView(jd);
         l4.addView(time2);
         l2.addView(mgeci);
         l2.addView(l4);
         l2.addView(i2);
      //   l2.addView(l3);
         mainlayout.addView(l1);
         // if(horizontalScrollView.isHorizontalScrollBarEnabled()){
         // Toastm("启用");
         // }
i2.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
if(!bofang){
i2.setImageBitmap(ks);
bofang=true;
mp3.pause();
mpd=true;
}else{
i2.setImageBitmap(zt);
bofang=false;
mpd=false;
mp3.start();
}
}});
        windowManager.addView(mainlayout, params);
mainlayout.setOnTouchListener(new View.OnTouchListener() {
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = params.x;
                initialY = params.y;
                initialTouchX = event.getRawX();
                initialTouchY = event.getRawY();
                return true;
            case MotionEvent.ACTION_MOVE:
                int deltaX = (int) (event.getRawX() - initialTouchX);
                int deltaY = (int) (event.getRawY() - initialTouchY);
                params.x = initialX + deltaX;
                params.y = initialY + deltaY;
                x=initialX + deltaX;
                y=initialY + deltaY;
                windowManager.updateViewLayout(mainlayout, params);
                return true;
            default:
                return false;
        }
    }
});
        }});
        }
