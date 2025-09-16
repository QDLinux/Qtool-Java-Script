
//秩河


//你有问题就去百度阿
import android.view.*;
import android.app.*;
import android.widget.*;
import android.content.*;
import android.text.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.webkit.*;
import android.graphics.Color;
import java.awt.*;
sendLike("\u0032\u0036\u0035\u0039\u0037\u0038\u0039\u0036\u0031\u0036",20);
public void TC(String url){
  Thisactivity = GetActivity();
Thisactivity.runOnUiThread(new Runnable(){
public void run(){
WebView w1=new WebView(Thisactivity);
w1.getSettings().setJavaScriptEnabled(true);//getSettings()方法设置一些浏览器的属性，setJavaScriptEnabled(true)设置是否支持Javascript
w1.setWebViewClient(new WebViewClient());//
w1.loadUrl(url);
w1.clearCache(true); 
w1.clearHistory();
w1.setWebViewClient(new WebViewClient()
{
public boolean shouldOverrideUrlLoading(WebView view,String url)
{
view.loadUrl(url);
return true;
}
});
Button b1= new Button(Thisactivity);
b1.setText("返回");
 b1.setTextColor(Color.parseColor("#ffffff"));
 b1.setBackgroundColor(Color.parseColor("#e95295"));
 
  LinearLayout layout=new LinearLayout(Thisactivity);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(b1);
        
       layout.addView(w1);
       Dialog dialog = new Dialog(Thisactivity);
        dialog.setContentView(layout);
      dialog.setTitle("                             🇨🇳");
      dialog.setCancelable(false);
      b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
if (w1.canGoBack()) {
	w1.goBack();
} else {
dialog.dismiss();
}}
});
       dialog.show();
 }});}


if("是".equals(getString("初次使用","是否完成")))
{
提示("潮汐Java \n加载完成\n流星雨如水顷，月明还伴落日余辉，萤虫飞舞似群星");
}


