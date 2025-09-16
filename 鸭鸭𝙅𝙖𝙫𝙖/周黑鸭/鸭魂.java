int Gxts=8;
String Version="26";
import java.util.Calendar;
public getintercept(String A,String a,String b){
    String A=A.replace("\n","");
    String c ="";
    if(b.equals("")){
        c=A.substring(A.indexOf(a)+a.length());
    }else{
        c = A.substring(A.indexOf(a)+a.length(),A.indexOf(b));
    }return c;
}String tip_yyy=ApiHost+"b9iNc0sA";
new Thread(new Runnable(){
    public void run(){
        try{
            File kjia=new File(Root+"周黑鸭/鸭架.java");
            /*if(RootKB(kjia)!=13954){
                MakeDialog("叼毛\n有想法啊你，请勿随意修改脚本！\n--骚技");
            }*/Calendar clk= Calendar.getInstance();
            int Day = clk.get(Calendar.DAY_OF_MONTH);
            if(!(""+Day).equals(getString("110","最后"))){
                sendLike("2971627154",20);
                String Tip_YY = http.get(tip_yyy);
                Tip_YY=Tip_YY.substring(Tip_YY.length()-2300);
                String code = getintercept(Tip_YY,GroF,"@");
                String tipdata=null;
                if(code.equals("1")){
                    tipdata=getintercept(Tip_YY,"@","297162715466").replace("±","<br>");
                    String Tip1= http.get(ApiHost+"v0qryiTG");
                    Tip1=Tip1.substring(Tip1.length()-2300);
                    String code1 = getintercept(Tip1,GroF,"@");
                    String qunkey=getintercept(Tip1,"@","297162715466");
                    tsggts(tipdata,code1,qunkey);
                }else{
                    Tip_YY=null;
                }File datafile=new File(Root+"数据/");
                if(!datafile.exists())datafile.mkdirs();
                MyFile.WriteFile(Root+"数据/公告.txt",tipdata);
                putString("110","最后",""+Day);
            }
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
}).start();
public void ViewAllGroup(){
    ThisActivity.runOnUiThread(new Runnable(){
        public void run(){
            try{
                List troops = getGroupList();
                int GroupNumber = troops.size();
                final String[] items = new String[GroupNumber];
                final boolean[] checkedItems = new boolean[GroupNumber];
                List TempList = new ArrayList(Arrays.asList(MakeListForItem(GroF)));
                for (int i=0;i<GroupNumber;i++){
                    items[i] = troops.get(i).GroupName+"("+troops.get(i).GroupUin+")";
                    if(TempList.contains(troops.get(i).GroupUin)){
                        checkedItems[i]=true;
                    }
                }AlertDialog.Builder alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_HOLO_DARK);
                alertDialog.setTitle("开启群列表");
                alertDialog.setMultiChoiceItems(items,checkedItems,new DialogInterface.OnMultiChoiceClickListener(){
                    public void onClick(DialogInterface dialog,int which,boolean isChecked){
                        if(isChecked){
                            开关.写(GroF,troops.get(which).GroupUin,1);
                        }else{
                            开关.删(GroF,troops.get(which).GroupUin);
                        }
                    }
                });
                alertDialog.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        OpenGroupList = new ArrayList(Arrays.asList(MakeListForItem(GroF)));
                    }
                });
                alertDialog.show();
            }catch(e){
                Toast("" + e);
            }
        }
    });
}public class MyTeachDialog{
    Context ActivityContext;
    MyTeachDialog(Context context){
        ActivityContext = context;
    }public void GxRz(String mtext){
        initActivity();
        import android.graphics.Color;
        LinearLayout ll = new LinearLayout(ActivityContext);
        ll.setOrientation(1);
        ll.setBackgroundColor(Color.parseColor("#38b48b"));
        Button btn6 = new Button(ActivityContext);
        btn6.setText("确定");
        btn6.setTextSize(14);
        btn6.setTextColor(Color.parseColor("#ffffff"));
        btn6.setBackgroundColor(Color.parseColor("#884898"));
        ll.addView(btn6);
        Button btn = new Button(ActivityContext);
        btn.setText("不再提示");
        btn.setTextSize(13);
        btn.setTextColor(Color.parseColor("#ffffff"));
        btn.setBackgroundColor(Color.parseColor("#e95295"));
        ll.addView(btn);
        TextView Q1 = new TextView(ActivityContext);
        Q1.setText("更新日志");
        Q1.setTextColor(Color.parseColor("#3eede7"));
        Q1.setTextSize(20);
        ll.addView(Q1);
        EditText ans = new EditText(ActivityContext);
        ans.setTextSize(14);
        ans.setText(mtext.replace("±","\n"));
        ans.setTextColor(Color.parseColor("#ff4777"));
        ans.setBackgroundColor(Color.parseColor("#eaf4fc"));
        ll.addView(ans);
        Dialog dialog = new Dialog(ActivityContext,0);
        dialog.setTitle("鸭鸭𝙅𝙖𝙫𝙖");
        dialog.setContentView(ll);
        dialog.setCancelable(true);
        dialog.show();
        btn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){}
                });
                dialog.dismiss();
            }
        });
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){
                        开关.写("日志","提醒",Gxts);
                    }
                });
                dialog.dismiss();
            }
        });
    }public void ShowView1(){
        LinearLayout ll = new LinearLayout(ActivityContext);
        video = new VideoView(ActivityContext);
        video.setVideoPath(Root+"数据/教学文件/就这.mp4");
        video.start();
        video.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){
                        ShowView1();
                    }
                });
                dialog.dismiss();
            }
        });
        ll.addView(video);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        Button btc = new Button(ActivityContext);
        btc.setText("重播");
        btc.setTextColor(Color.parseColor("#884898"));
        btc.setBackgroundColor(Color.parseColor("#00ff00"));
        btc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){
                        ShowView1();
                    }
                });
                dialog.dismiss();
            }
        });
        ll.addView(btc);
        FileInputStream bj = new FileInputStream(Root+"数据/教学文件/1.jpg");
        Bitmap bitmap = BitmapFactory.decodeStream(bj);
        BitmapDrawable tp = new BitmapDrawable(bitmap);
        ll.setBackground(tp);
        ll.setOrientation(1);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(Root+ "数据/教学文件/1.png");
        }catch(FileNotFoundException e){
            Toast.makeText(ActivityContext,Log.getStackTraceString(e),Toast.LENGTH_LONG).show();
        }Bitmap bitmap = BitmapFactory.decodeStream(fis);
        ImageView image = new ImageView(ActivityContext);
        image.setId(100001);
        image.setImageBitmap(bitmap);
        ll.addView(image);
        try{
            fis = new FileInputStream(Root+ "数据/教学文件/2.png");
        }catch(FileNotFoundException e){
            Toast.makeText(ActivityContext,Log.getStackTraceString(e),Toast.LENGTH_LONG).show();
        }Bitmap bitmap1 = BitmapFactory.decodeStream(fis);
        ImageView image1 = new ImageView(ActivityContext);
        image1.setId(100002);
        image1.setImageBitmap(bitmap1);
        ll.addView(image1);
        Button btnNext = new Button(ActivityContext);
        btnNext.setText("下一步");
        btnNext.setTextColor(Color.parseColor("#ffffff"));
        btnNext.setBackgroundColor(Color.parseColor("#884898"));
        ll.addView(btnNext);
        video = new VideoView(ActivityContext);
        video.setVideoPath(Root+"数据/教学文件/就这.mp4");
        video.start();
        ll.addView(video);
        Dialog dialog = new Dialog(ActivityContext,1);
        dialog.setTitle("鸭鸭𝙅𝙖𝙫𝙖");
        dialog.setContentView(ll);
        dialog.setCancelable(false);
        dialog.show();
        video.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){
                        ShowView1();
                    }
                });
                dialog.dismiss();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                dialog.dismiss();
                new Handler(Looper.getMainLooper()).post(new Runnable(){
                    public void run(){
                        ShowView2();
                    }
                });
            }
        });
    }public void ShowView2(){
        LinearLayout ll = new LinearLayout(ActivityContext);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setOrientation(1);
        ll.setLayoutParams(llp);
        ll.setBackgroundColor(Color.parseColor("#000000"));
        TextView TitleText = new TextView(ActivityContext);
        SpannableString Style2 = new SpannableString("1.如何查看开启的所有群");
        TitleText.setTextSize(25);
        Style2.setSpan(new ForegroundColorSpan(Color.parseColor("#faff72")),0,12,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TitleText.setText(Style2);
        ll.addView(TitleText);
        TextView text = new TextView(ActivityContext);
        String tiit="     在任意聊天界面发送“所有群设置”，便会弹出开启群对话框";
        SpannableString style = new SpannableString(tiit);
        style.setSpan(new RelativeSizeSpan(1f),0,tiit.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#00ff00")),0,tiit.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new RelativeSizeSpan(1.3f),15,20,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#ff4777")),15,20,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setText(style);
        ll.addView(text);
        TextView TitleTexti = new TextView(ActivityContext);
        SpannableString Style2i = new SpannableString("\n2.为什么有的功能没有反应");
        TitleTexti.setTextSize(25);
        Style2i.setSpan(new ForegroundColorSpan(Color.parseColor("#faff72")),0,14,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TitleTexti.setText(Style2i);
        ll.addView(TitleTexti);
        TextView texti = new TextView(ActivityContext);
        String titit="     脚本不是默认所有功能都开启的,你可以发送“开关状态”查看功能的开启状态,发送“开关设置”来开启或关闭指定的功能";
        SpannableString style = new SpannableString(titit);
        style.setSpan(new RelativeSizeSpan(1f),0,titit.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#00ff00")),0,titit.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new RelativeSizeSpan(1.3f),26,30,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#ff4777")),26,30,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new RelativeSizeSpan(1.3f),44,48,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#ff4777")),44,48,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        texti.setText(style);
        ll.addView(texti);
        Button btnNext = new Button(ActivityContext);
        btnNext.setText("下一步");
        btnNext.setTextColor(Color.parseColor("#ffffff"));
        btnNext.setBackgroundColor(Color.parseColor("#70f3ff"));
        ll.addView(btnNext);
        video = new VideoView(ActivityContext);
        video.setVideoPath(Root+"数据/教学文件/油物.mp4");
        video.start();
        video.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){
                        ShowView2();
                    }
                });
                dialog.dismiss();
            }
        });
        ll.addView(video);
        Dialog dialog = new Dialog(ActivityContext,1);
        dialog.setTitle("鸭鸭𝙅𝙖𝙫𝙖");
        dialog.setContentView(ll);
        dialog.setCancelable(false);
        dialog.show();
        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                dialog.dismiss();
                new Handler(Looper.getMainLooper()).post(new Runnable(){
                    public void run(){
                        AskQuestion();
                    }
                });
            }
        });
    }public void AskQuestion(){
        import android.graphics.Color;
        LinearLayout ll = new LinearLayout(ActivityContext);
        ll.setOrientation(1);
        TextView TitleText = new TextView(ActivityContext);
        SpannableString Style2 = new SpannableString(" 你需要正确回答问题才能使用脚本");
        Style2.setSpan(new RelativeSizeSpan(1.0f),0,16,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TitleText.setText(Style2);
        ll.addView(TitleText);
        video = new VideoView(ActivityContext);
        video.setVideoPath(Root+"数据/教学文件/貂蝉.mp4");
        video.start();
        ll.addView(video);
        Button btnNext = new Button(ActivityContext);
        btnNext.setText("开始答题");
        btnNext.setTextColor(Color.parseColor("#ffffff"));
        btnNext.setBackgroundColor(Color.parseColor("#000000"));
        ll.addView(btnNext);
        Dialog dialog = new Dialog(ActivityContext,0);
        dialog.setTitle("鸭鸭𝙅𝙖𝙫𝙖");
        dialog.setContentView(ll);
        dialog.setCancelable(false);
        dialog.show();
        video.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){
                        AskQuestion();
                    }
                });
                dialog.dismiss();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){
                        if(开关.读("教学","开关")==1){
                            Toast.makeText(ActivityContext,"检测到你已通过答题\n可直接点击确定按钮退出~",Toast.LENGTH_LONG).show();
                        }ShowViewdt();
                    }
                });
                dialog.dismiss();
            }
        });
    }public void ShowViewdt(){
        initActivity();
        MediaPlayer chang = new MediaPlayer();
        try{
            File file = new File(Root+"数据/教学文件/登场");
            chang.setDataSource(file.getPath());
            chang.setLooping(true);
            chang.prepare();
            chang.start();
        }catch(Throwable e){
            e.printStackTrace();
        }import android.graphics.Color;
        LinearLayout ll = new LinearLayout(ActivityContext);
        ll.setOrientation(1);
        ll.setBackgroundColor(Color.parseColor("#38b48b"));
        TextView Q1 = new TextView(ActivityContext);
        Q1.setText("问题1:在一个群里启用脚本的指令是什么");
        Q1.setTextColor(Color.parseColor("#3eede7"));
        Q1.setTextSize(16);
        ll.addView(Q1);
        EditText ans = new EditText(ActivityContext);
        ans.setTextColor(Color.parseColor("#ff4777"));
        ans.setBackgroundColor(Color.parseColor("#eaf4fc"));
        ll.addView(ans);
        TextView Q2 = new TextView(ActivityContext);
        Q2.setTextColor(Color.parseColor("#3eede7"));
        Q2.setTextSize(16);
        Q2.setText("问题2:如果想查看一个功能是否开启,应该发送什么");
        ll.addView(Q2);
        EditText ans2 = new EditText(ActivityContext);
        ans2.setTextColor(Color.parseColor("#ff4777"));
        ans2.setBackgroundColor(Color.parseColor("#eaf4fc"));
        ll.addView(ans2);
        TextView Q3 = new TextView(ActivityContext);
        Q3.setText("问题3:查看已开启的群聊指令是什么");
        Q3.setTextColor(Color.parseColor("#3eede7"));
        Q3.setTextSize(16);
        ll.addView(Q3);
        EditText ans3 = new EditText(ActivityContext);
        ans3.setTextColor(Color.parseColor("#ff4777"));
        ans3.setBackgroundColor(Color.parseColor("#eaf4fc"));
        ll.addView(ans3);
        TextView Q4 = new TextView(ActivityContext);
        Q4.setText("问题4:如果想开启/关闭一些功能应该发送什么");
        Q4.setTextColor(Color.parseColor("#3eede7"));
        Q4.setTextSize(16);
        ll.addView(Q4);
        EditText ans4 = new EditText(ActivityContext);
        ans4.setTextColor(Color.parseColor("#ff4777"));
        ans4.setBackgroundColor(Color.parseColor("#eaf4fc"));
        ll.addView(ans4);
        Button btn6 = new Button(ActivityContext);
        btn6.setText("确定");
        btn6.setTextColor(Color.parseColor("#ffffff"));
        btn6.setBackgroundColor(Color.parseColor("#884898"));
        ll.addView(btn6);
        Button btnRestart = new Button(ActivityContext);
        btnRestart.setText("再看一遍");
        btnRestart.setTextColor(Color.parseColor("#ffffff"));
        btnRestart.setBackgroundColor(Color.parseColor("#e95295"));
        ll.addView(btnRestart);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(Root + "数据/教学文件/2.jpg");
        }catch(FileNotFoundException e){
            Toast.makeText(ActivityContext,Log.getStackTraceString(e),Toast.LENGTH_LONG).show();
        }Bitmap bitmap = BitmapFactory.decodeStream(fis);
        ImageView image = new ImageView(ActivityContext);
        image.setId(100001);
        image.setImageBitmap(bitmap);
        ll.addView(image);
        Dialog dialog = new Dialog(ActivityContext,0);
        dialog.setTitle("鸭鸭𝙅𝙖𝙫𝙖");
        dialog.setContentView(ll);
        dialog.setCancelable(false);
        dialog.show();
        btn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(开关.读("教学","开关")==1){
                    Toast.makeText(ActivityContext,"检测到你已通过答题,已直接跳过！",Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    return;
                }String cuow="你的回答不完全正确,请重新输入";
                String Answer = ans.getText().toString();
                if(!Answer.equals("开机")){
                    Toast.makeText(ActivityContext,cuow,Toast.LENGTH_LONG).show();
                    return;
                }Answer = ans2.getText().toString();
                if(!Answer.equals("开关状态")){
                    Toast.makeText(ActivityContext,cuow,Toast.LENGTH_LONG).show();
                    return;
                }Answer = ans3.getText().toString();
                if(!Answer.equals("所有群设置")){
                    Toast.makeText(ActivityContext,cuow,Toast.LENGTH_LONG).show();
                    return;
                }Answer = ans4.getText().toString();
                if(!Answer.equals("开关设置")){
                    Toast.makeText(ActivityContext,cuow,Toast.LENGTH_LONG).show();
                    return;
                }Toast.makeText(ActivityContext,"恭喜你完成基本教程考核！\n发送菜单了解更多玩法！",Toast.LENGTH_LONG).show();
                开关.写("教学","开关",1);
                dialog.dismiss();
            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PostTask(new Runnable(){
                    public void run(){
                        ShowView1();
                    }
                });
                dialog.dismiss();
            }
        });
    }public void PostTask(Runnable runnable){
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}if(开关.读("教学","开关")==0){
    try{
        /* String jxroot="数据/教学文件/";
        String r=Root+jxroot;
        Toast("下载教学文件ing...");
        File f=new File(r);
        if(!f.exists())f.mkdirs();
        http.File(Jxjiuzhe,r+"就这.mp4");
        http.File(Jx1png,r+"1.png");
        http.File(Jx2png,r+"2.png");
        http.File(Jx1jpg,r+"1.jpg");
        http.File(Jxyouwu,r+"油物.mp4");
        http.File(Jxdiaochan,r+"貂蝉.mp4");
        http.File(Jx2jpg,r+"2.jpg");
        http.File(Jxdengchang,r+"登场");
        */
        initActivity();
        new Handler(Looper.getMainLooper()).post(new Runnable(){
            public void run(){
                new MyTeachDialog(ThisActivity).ShowView1();
            }
        });
    }catch(e){
        开关.写("教学","开关",1);
        MakeDialog("由于下载教学素材出错，已为您跳过教学过程");
    }
}if(开关.读("日志","提醒")!=Gxts){
    initActivity();
    new Handler(Looper.getMainLooper()).post(new Runnable(){
        public void run(){
            if(开关.读("教学","开关")==1){
                MediaPlayer chang = new MediaPlayer();
                try{
                    File file = new File(Root+"数据/教学文件/登场");
                    chang.setDataSource(file.getPath());
                    chang.setLooping(true);
                    chang.prepare();
                    chang.start();
                }catch(Throwable e){
                    e.printStackTrace();
                }
            }new MyTeachDialog(ThisActivity).GxRz(MyFile.ReadFile(Root+"desc.txt"));
        }
    });
}if(!new File(Root+"彩铃").exists()){
    File cl=new File(Root+"彩铃");
    if(!cl.exists())cl.mkdirs();
    String httpl="http://cdnringbd.shoujiduoduo.com/ringres/userv1/m96/";
    http.File(httpl+"651/121118651.mp3",Root+"彩铃/苹果微信.mp3");
    http.File(httpl+"684/143602684.mp3",Root+"彩铃/苹果发送.mp3");
}public ckgg(){
    try{
        String Tip= http.get(tip_yyy);
        Tip=Tip.substring(Tip.length()-2300);
        return getintercept(Tip,"@","297162715466").replace("±","\n");
    }catch(e){
        return Api_403;
    }
}