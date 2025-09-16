import androidx.appcompat.app.AppCompatActivity;
import android.webkit.*;
import android.graphics.Color;
public void setWindow(String url){
 Thisactivity = GetActivity();
Thisactivity.runOnUiThread(new Runnable(){
public void run(){
WebView w1=new WebView(Thisactivity);
WebSettings webSettings =w1.getSettings();
webSettings.setJavaScriptEnabled(true);
webSettings.setDomStorageEnabled(true);
//花里胡哨的自适配
webSettings.setUseWideViewPort(true);
webSettings.setLoadWithOverviewMode(true);
webSettings.setSupportZoom(false);
webSettings.setBuiltInZoomControls(false);
webSettings.setDisplayZoomControls(false);
w1.loadUrl(url);
w1.clearCache(true);
w1.clearHistory();
w1.setWebViewClient(new WebViewClient()
{
public boolean shouldOverrideUrlLoading(WebView view,String url)
{
view.loadUrl(url);
return false;
}
});
Button b1= new Button(Thisactivity);
b1.setText("取消");
 b1.setTextColor(Color.parseColor("#5A5AAD"));
 b1.setBackgroundColor(Color.parseColor("#66B3FF"));
LinearLayout layout=new LinearLayout(Thisactivity);
layout.setOrientation(LinearLayout.VERTICAL);
layout.addView(b1);
layout.addView(w1);
Dialog dialog = new Dialog(Thisactivity);
b1.setOnClickListener(new View.OnClickListener()
{
public void onClick(View v)
{
dialog.dismiss();
}
});
dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
dialog.setContentView(layout);
dialog.setCancelable(false);
dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
dialog.show();
 }}
 );
 }
if(取("冷雨Java","首次加载")==null){
setWindow("http://ly.aaa.vin/welcome");
存("冷雨Java","首次加载","1");
}else{}