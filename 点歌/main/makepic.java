import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.*;
import android.graphics.Paint;
import android.media.MediaScannerConnection;
import java.io.File;
import java.io.FileOutputStream;
import android.graphics.BitmapFactory;
import java.io.IOException;
import android.graphics.Typeface;
import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

Object mttf;
mttf2=mttf2.replace("{Path}",Mpath+"/");
if(!mttf2.equals("")){
try{
mttf=Typeface.createFromFile(mttf2);
}
catch(e){
Toastm("字体路径错误\n调用本地字体");
mttf=Typeface.DEFAULT_BOLD;
}
}else{
mttf=Typeface.DEFAULT_BOLD;
}
public String makepic(String text, String filePath,int type,boolean mpd) {
int padding;
int x = 0, y = 0,ke=0;
String[] word=text.split("\n");
int kuan=0,gao=0;
for(String line:word){
ke++;
}
try{
if(type==1){
 download(mdgapi,filePath);
 kuan=1700;
 gao=1300;
 }else{
 download(mgcapi,filePath);
 kuan=1000;
 gao=2000;
 }
 }catch(e){
 Toastm("获取图片错误\n"+e);
 }
 Bitmap transparentBitmap = BitmapFactory.decodeFile(filePath);
 transparentBitmap=blurBitmap(transparentBitmap,transparentBitmap,Vague);
Bitmap image =transparentBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Canvas canvas = new Canvas();
    Bitmap bit=Bitmap.createBitmap(image.getWidth(), image.getHeight(), Bitmap.Config.ARGB_8888);
    Paint bgPaint=new Paint();
    bgPaint.setAlpha(mengban);
    canvas.setBitmap(bit);
    canvas.drawColor(Color.WHITE);
    canvas.drawBitmap(image,0,0,bgPaint);
    Paint paint = new Paint();
    paint.setColor(Color.BLACK);
    paint.setTypeface(mttf);
    int size=getsize(transparentBitmap.getHeight(),ke);
    padding=size-5;
    paint.setTextSize(size);
    paint.setAntiAlias(true);
    Rect bounds = new Rect();
    y = bounds.height() + padding;
    if(mpd){
    float xx=(transparentBitmap.getWidth()/4f)/2f-transparentBitmap.getWidth()/8.5f;
    x=transparentBitmap.getWidth()/4+(int)xx;
    }else{
    x=10;
    }
    paint.getTextBounds(text, 0, text.length(), bounds);
    for(String line:word){
    canvas.drawText(line, x,y, paint);
    y= y+size;
    }
    bit=compressBitmap(bit,kuan,gao);
    try {
        File file = new File(filePath);
        FileOutputStream fos = new FileOutputStream(file);
        bit.compress(Bitmap.CompressFormat.PNG, 100, fos);
        fos.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return filePath;
}
public int getsize(int imageHeight,int line){
int ke=imageHeight/line;
return ke;
}
public Bitmap compressBitmap(Bitmap bia, int maxWidth, int maxHeight) {
    int originalWidth = bia.getWidth();
    int originalHeight = bia.getHeight();
    if (originalWidth <= maxWidth && originalHeight <= maxHeight) {
        return bia;
    }
    float scale = Math.min((float) maxWidth / originalWidth, (float) maxHeight / originalHeight);
    Matrix matrix = new Matrix();
    matrix.postScale(scale, scale);
    Bitmap compressedBitmap = Bitmap.createBitmap(bia, 0, 0, originalWidth, originalHeight, matrix, true);

    return compressedBitmap;
}
public static Bitmap blurBitmap(Bitmap bitmap, Bitmap outBitmap, float radius) {
    RenderScript rs = RenderScript.create(context);
    ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
    Allocation allIn = Allocation.createFromBitmap(rs, bitmap);
    Allocation allOut = Allocation.createFromBitmap(rs, outBitmap);
    blurScript.setRadius(radius);
    blurScript.setInput(allIn);
    blurScript.forEach(allOut);
    allOut.copyTo(outBitmap);
    rs.destroy();
    return outBitmap;
}
