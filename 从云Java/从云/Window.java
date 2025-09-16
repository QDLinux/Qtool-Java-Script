
public void fz(String text)
   {
   new java.lang.Thread(new Runnable(){
   public void run(){
   int no=0;
Object title=text;
ClipboardManager cmb = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
 cmb.setText(title.trim());
 Toast(title);
no++;
break;
}}).start();
}

//ts2("1","1","1");
if(取(Y("伧仪"),"首次加载")==null){load(AppPath+"/"+Y("伧仪£ºÏº¿ÂËÌÍÃºÏº"));}else{}