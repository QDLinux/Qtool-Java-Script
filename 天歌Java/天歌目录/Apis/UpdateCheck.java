public class MyTeachDialog
{
	Context ActivityContext;
	MyTeachDialog(Context context)
	{
		ActivityContext = context;
	}
	public void ShowView1()
	{
		LinearLayout ll = new LinearLayout(ActivityContext);
		LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		ll.setOrientation(1);
		ll.setLayoutParams(llp);
		Button btnNext = new Button(ActivityContext);
		btnNext.setText("下一步");
		ll.addView(btnNext);
		TextView TitleText = new TextView(ActivityContext);
		SpannableString Style2 = new SpannableString("脚本的作者是谁");
		Style2.setSpan(new RelativeSizeSpan(3.0f), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		TitleText.setText(Style2);
		ll.addView(TitleText);
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(RootPath + "data/1.jpg");
		}
		catch(FileNotFoundException e)
		{
			Toast.makeText(ActivityContext, Log.getStackTraceString(e), Toast.LENGTH_LONG).show();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(fis);
		ImageView image = new ImageView(ActivityContext);
		image.setId(100001);
		image.setImageBitmap(bitmap);
		ll.addView(image);
		try
		{
			fis = new FileInputStream(RootPath + "data/2.jpg");
		}
		catch(FileNotFoundException e)
		{
			Toast.makeText(ActivityContext, Log.getStackTraceString(e), Toast.LENGTH_LONG).show();
		}
		Bitmap bitmap1 = BitmapFactory.decodeStream(fis);
		ImageView image1 = new ImageView(ActivityContext);
		image1.setId(100002);
		image1.setImageBitmap(bitmap1);
		ll.addView(image1);
		TextView text = new TextView(ActivityContext);
		SpannableString style = new SpannableString("在群里发送启动功能即可在发送该消息的群启动脚本,发送关闭功能即可关闭该群的脚本");
		style.setSpan(new RelativeSizeSpan(1.3f), 5, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.RED), 5, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.RED), 12, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new RelativeSizeSpan(1.3f), 26, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.RED), 26, 30, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		text.setText(style);
		ll.addView(text);
		Dialog dialog = new Dialog(ActivityContext, 1);
		dialog.setContentView(ll);
		dialog.setCancelable(false);
		dialog.show();
		btnNext.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				dialog.dismiss();
				new Handler(Looper.getMainLooper()).post(new Runnable()
				{
					public void run()
					{
						ShowView2();
					}
				});
			}
		});
	}
	public void ShowView2()
	{
		LinearLayout ll = new LinearLayout(ActivityContext);
		LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		ll.setOrientation(1);
		ll.setLayoutParams(llp);
		
		Button btnNext = new Button(ActivityContext);
		btnNext.setText("下一步");
		ll.addView(btnNext);
		TextView TitleText = new TextView(ActivityContext);
		SpannableString Style2 = new SpannableString("稍后回答脚本作者的QQ号");
		Style2.setSpan(new RelativeSizeSpan(3.0f), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		TitleText.setText(Style2);
		ll.addView(TitleText);
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(RootPath + "data/3.jpg");
		}
		catch(FileNotFoundException e)
		{
			Toast.makeText(ActivityContext, Log.getStackTraceString(e), Toast.LENGTH_LONG).show();
		}
		Bitmap bitmap = BitmapFactory.decodeStream(fis);
		ImageView image = new ImageView(ActivityContext);
		image.setId(100001);
		image.setImageBitmap(bitmap);
		ll.addView(image);
		TextView text = new TextView(ActivityContext);
	SpannableString style = new SpannableString("脚本不是默认所有功能都开启的,发送开关设置来开启或关闭指定的功能");
		style.setSpan(new RelativeSizeSpan(1.3f), 20, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.RED), 20, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new RelativeSizeSpan(1.3f), 36, 40, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		style.setSpan(new ForegroundColorSpan(Color.RED), 36, 40, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		text.setText(style);
		ll.addView(text);
		Dialog dialog = new Dialog(ActivityContext, 1);
		dialog.setContentView(ll);
		dialog.setCancelable(false);
		dialog.show();
		btnNext.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				dialog.dismiss();
				new Handler(Looper.getMainLooper()).post(new Runnable()
				{
					public void run()
					{
						AskQuestion();
					}
				});
			}
		});
	}

	public void AskQuestion()
	{
		import android.graphics.Color;
		LinearLayout ll = new LinearLayout(ActivityContext);
		ll.setOrientation(1);
		TextView TitleText = new TextView(ActivityContext);
		SpannableString Style2 = new SpannableString("你需要回答正确问题才能使用天歌脚本");
		Style2.setSpan(new RelativeSizeSpan(2.0f), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		TitleText.setText(Style2);
		ll.addView(TitleText);
		TextView Q1 = new TextView(ActivityContext);
		Q1.setText("问题1:作者是谁");
		Q1.setTextColor(Color.RED);
        Q1.setTextSize(32);
		ll.addView(Q1);
		EditText ans = new EditText(ActivityContext);
		ll.addView(ans);
		TextView Q2 = new TextView(ActivityContext);
		Q2.setTextColor(Color.RED);
        Q2.setTextSize(32);
		Q2.setText("问题2:作者QQ");
		ll.addView(Q2);
		EditText ans2 = new EditText(ActivityContext);
		ll.addView(ans2);
		Button btnNext = new Button(ActivityContext);
		btnNext.setText("确定");
		ll.addView(btnNext);
		Button btnRestart = new Button(ActivityContext);
		btnRestart.setText("不知道？问问别人吧");
		ll.addView(btnRestart);
		Dialog dialog = new Dialog(ActivityContext, 0);
		dialog.setContentView(ll);
		dialog.setCancelable(false);
		dialog.show();
		btnNext.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				String Answer = ans.getText().toString();
				if(!Answer.equals("天上人歌"))
				{
					Toast.makeText(ActivityContext, "回答错误", Toast.LENGTH_LONG).show();
					return;
				}
				Answer = ans2.getText().toString();
				if(!Answer.equals("484151048"))
				{
					Toast.makeText(ActivityContext, "回答错误", Toast.LENGTH_LONG).show();
					return;
				}
			
				item.SetItemData("Flags", "FirstUse", "IsFirst", "IsUsed4", 1);
				dialog.dismiss();
				
			}
		});
		btnRestart.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				PostTask(new Runnable()
				{
					public void run()
					{
						ShowView1();
					}
				});
				dialog.dismiss();
			}
		});
	}
	public void PostTask(Runnable runnable)
	{
		new Handler(Looper.getMainLooper()).post(runnable);
	}
}
if(item.GetItemDataInt("Flags", "FirstUse", "IsFirst", "IsUsed4") != 1)
{
	File f=new File(RootPath + "data");
	if(!f.exists()) f.mkdirs();
	http.DownloadToFile("http://gchat.qpic.cn/gchatpic_new/0/0-0-BDC603D0DF7C49F45FFC1FF0108E5A73/0?term=2",RootPath + "data/1.jpg");
	http.DownloadToFile("http://gchat.qpic.cn/gchatpic_new/0/0-0-ADF29AD63D863D042179F393B2AE543E/0?term=2",RootPath + "data/2.jpg");
	http.DownloadToFile("http://gchat.qpic.cn/gchatpic_new/0/0-0-3FFB149C0B8B90FB986E416746C1DDF5/0?term=2",RootPath + "data/3.jpg");
	initActivity();
	new Handler(Looper.getMainLooper()).post(new Runnable()
	{
		public void run()
		{
			new MyTeachDialog(ThisActivity).ShowView1();
		}
	});
}
