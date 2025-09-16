Activity ThisActivity = null;
public void initActivity()
{
	ThisActivity = GetActivity();
}


public static String getFormattedSize(File folder) {
        if (folder == null || !folder.exists()) {
            return "文件夹不存在或为空";
        }

        long sizeInBytes = getFolderSize(folder);
        double sizeInKB = sizeInBytes / 1024.0; // 文件夹大小（KB）

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        if (sizeInKB < 1024) {
            return decimalFormat.format(sizeInKB) + "KB";
        } else if (sizeInKB < 1024 * 1024) {
            double sizeInMB = sizeInKB / 1024.0; // 文件夹大小（MB）
            return decimalFormat.format(sizeInMB) + "MB";
        } else {
            double sizeInGB = sizeInKB / (1024.0 * 1024.0); // 文件夹大小（GB）
            return decimalFormat.format(sizeInGB) + "GB";
        }
    }
    public static long getFolderSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else if (file.isDirectory()) {
                    size += getFolderSize(file);
                }
            }
        }
        return size;
    }




    
    
    
    
public void 调教管家(String qun){
initActivity();
    String u=getString(qun,"调教");
    rg1=""+u;
    String rg=rg1.replace("null","还没有调教");
	ThisActivity.runOnUiThread(new Runnable()
	{
        public void run()
        {
            final EditText editText = new EditText(ThisActivity);
            editText.setHint("请输入调教的内容");
            TextView tc= new TextView(ThisActivity);
            tc.setText("[长按复制]调教内容:");
            tc.setTextColor(Color.parseColor("#DC143C"));
            TextView textView = new TextView(ThisActivity);
            textView.setText(rg);
            textView.setTextColor(Color.parseColor("#6520E6"));
            textView.setTextIsSelectable(true);

            Button 清空调教 = new Button(ThisActivity);
            清空调教.setText("清空调教");
            清空调教.setOnClickListener(new View.OnClickListener() {
                
                public void onClick(View view) {
                    存(qun, "调教",null);
                    textView.setText("还没有调教");
                    提示("已清空调教");
                }
            });

LinearLayout cy = new LinearLayout(ThisActivity);
cy.setOrientation(LinearLayout.VERTICAL);
cy.setGravity(Gravity.BOTTOM | Gravity.START); // 设置在左下角
cy.addView(tc);

// 创建一个垂直滚动视图，将文本视图包含在其中
ScrollView scrollView = new ScrollView(ThisActivity);
scrollView.setLayoutParams(new LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        0,
        0.8f // 80% 权重，占据 80% 的高度
));
scrollView.addView(textView);

// 设置EditText的高度为动态高度，但不超过800像素
editText.setLayoutParams(new LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT // 设置为WRAP_CONTENT，高度将根据内容自动调整
));
// 设置最大高度为1000像素
int maxEditTextHeight = 1000; // 最大高度为1000像素
editText.setMaxHeight(maxEditTextHeight);

cy.addView(scrollView);

// ... 继续添加其他控件，比如输入框和清空调教按钮
cy.addView(editText);
cy.addView(清空调教); // 添加清空调教按钮



// 在AlertDialog中显示提示信息的TextView
TextView 提示TextView = new TextView(ThisActivity);
LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
);
params.topMargin = 16; // 设置上边距
提示TextView.setLayoutParams(params);
提示TextView.setTextColor(Color.RED);
cy.addView(提示TextView);

// 为输入框添加TextWatcher，用于监测输入内容的变化
editText.addTextChangedListener(new TextWatcher() {
    
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

   
    public void afterTextChanged(Editable editable) {
        // 获取当前输入内容的长度
        int inputLength = editable.length();

      
        if (inputLength > 1000) {
            String limitedText = editable.toString().substring(0, 1000);
            editText.setText(limitedText);
            editText.setSelection(limitedText.length()); // 把光标定位到末尾

            // 显示提示信息
            提示TextView.setText("输入内容限制1000字");
        } else {
            提示TextView.setText(""); // 清空提示信息
        }
    }
});

// ... 在之后的代码继续

            AlertDialog.Builder dialog1=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setTitle("调教管家")
                .setView(cy)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new Thread(new Runnable() {
                            public void run() {
                                String input = editText.getText().toString();
                                if (input.equals("")) {
                                    提示("未输入");
                                } else {
                                    存(qun, "调教", input);
                                    textView.setText(input);
                                    提示("调教成功");
                                }
                            }
                        }).start();
                    }
                });

            dialog1.setCancelable(false);
            dialog1.show();
        }
    });
}


public void 底部尾巴(String qun) {
initActivity();
    String u=getString("开关","底部尾巴内容");
    rg1=""+u;
    String rg=rg1.replace("null","还没有尾巴内容");
	ThisActivity.runOnUiThread(new Runnable()
	{
        public void run()
        {
            final EditText editText = new EditText(ThisActivity);
            editText.setHint("请输入尾巴内容");
            TextView tc= new TextView(ThisActivity);
            tc.setText("[长按复制]尾巴内容:");
            tc.setTextColor(Color.parseColor("#DC143C"));
            TextView textView = new TextView(ThisActivity);
            textView.setText(rg);
            textView.setTextColor(Color.parseColor("#6520E6"));
            textView.setTextIsSelectable(true);

            Button 清空内容 = new Button(ThisActivity);
            清空内容.setText("清空内容");
            清空内容.setOnClickListener(new View.OnClickListener() {
                
                public void onClick(View view) {
                    存("开关","底部尾巴内容",null);
                    textView.setText("还没有尾巴内容");
                    提示("已清空尾巴内容");
                }
            });

LinearLayout cy = new LinearLayout(ThisActivity);
cy.setOrientation(LinearLayout.VERTICAL);
cy.setGravity(Gravity.BOTTOM | Gravity.START); // 设置在左下角
cy.addView(tc);

// 创建一个垂直滚动视图，将文本视图包含在其中
ScrollView scrollView = new ScrollView(ThisActivity);
scrollView.setLayoutParams(new LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        0,
        0.8f // 80% 权重，占据 80% 的高度
));
scrollView.addView(textView);

// 设置EditText的高度为动态高度，但不超过800像素
editText.setLayoutParams(new LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT // 设置为WRAP_CONTENT，高度将根据内容自动调整
));
// 设置最大高度为1000像素
int maxEditTextHeight = 1000; // 最大高度为1000像素
editText.setMaxHeight(maxEditTextHeight);

cy.addView(scrollView);

// ... 继续添加其他控件，比如输入框和清空调教按钮
cy.addView(editText);
cy.addView(清空内容); // 添加清空内容按钮



// 在AlertDialog中显示提示信息的TextView
TextView 提示TextView = new TextView(ThisActivity);
LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
);
params.topMargin = 16; // 设置上边距
提示TextView.setLayoutParams(params);
提示TextView.setTextColor(Color.RED);
cy.addView(提示TextView);

// 为输入框添加TextWatcher，用于监测输入内容的变化
editText.addTextChangedListener(new TextWatcher() {
    
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

   
    public void afterTextChanged(Editable editable) {
        // 获取当前输入内容的长度
        int inputLength = editable.length();

      
        if (inputLength > 200) {
            String limitedText = editable.toString().substring(0, 200);
            editText.setText(limitedText);
            editText.setSelection(limitedText.length()); // 把光标定位到末尾

            // 显示提示信息
            提示TextView.setText("输入内容限制200字");
        } else {
            提示TextView.setText(""); // 清空提示信息
        }
    }
});

// ... 在之后的代码继续

            AlertDialog.Builder dialog1=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setTitle("底部尾巴")
                .setView(cy)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new Thread(new Runnable() {
                            public void run() {
                                String input = editText.getText().toString();
                                if (input.equals("")) {
                                    提示("未输入");
                                } else {
                                    存("开关","底部尾巴内容", input);
                                    textView.setText(input);
                                    提示("设置成功");
                                }
                            }
                        }).start();
                    }
                });

            dialog1.setCancelable(false);
            dialog1.show();
        }
    });
}

public boolean 下载(String url,String filepath) throws Exception
{
		File file = new File(filepath);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs(); 
		}
		InputStream input = null;
		try {
			URL ur = new URL(url);
			HttpURLConnection urlConn = (HttpURLConnection) ur.openConnection();
			input = urlConn.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			FileOutputStream out = new FileOutputStream(filepath, false);
			while((len = input.read(bs)) != -1) {
				out.write(bs, 0, len);
			}
			out.close();
			input.close();
		} catch (IOException e) {
			return false;
		}
		finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
}



//是否在数组中
public static boolean isInList(String targetValue, String[] arr)
{
	if (arr.length <= 0)
		return false;
	for (String s : arr)
		if (s.equals(targetValue))
			return true;
	return false;
}






//继承并改进QQ复读机的判断是否管理函数
public static boolean isAdmin(String GroupUin, String UserUin)
{
	ArrayList groupList = getGroupList();
	for (Object groupInfo : groupList)
if (groupInfo.GroupUin.equals(GroupUin))
			return groupInfo.GroupOwner.equals(UserUin) || isInList(UserUin, groupInfo.AdminList);
	return false;
}




public static boolean 是否管理(String GroupUin) { return isAdmin(GroupUin, MyUin); }

public static boolean isGroupOwner(String GroupUin, String UserUin)
{
	ArrayList groupList = getGroupList();
	for (Object groupInfo : groupList)
		if (groupInfo.GroupUin.equals(GroupUin))
return groupInfo.GroupOwner.equals(UserUin);
	return false;
}

public static boolean 是否群主(String GroupUin) { return isGroupOwner(GroupUin, MyUin); }


public void 提示(String text) {
    new Handler(Looper.getMainLooper()).post(new Runnable() {
        public void run() {
            String text2 = text.replaceAll("\n","<br>");
            Toast toast = android.widget.Toast.makeText(GetActivity(),
                Html.fromHtml("<font color=\"#00FF00\"><b>" + text2 + "</b></font>"),
                Toast.LENGTH_LONG);
            View view = toast.getView();
            view.setBackground(new ColorDrawable(android.graphics.Color.TRANSPARENT)); // 将背景设置为透明色
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(Color.TRANSPARENT); // 设置填充颜色为透明色
            gd.setStroke(5, Color.BLUE); // 设置边框宽度和颜色
            gd.setCornerRadii(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 }); // 设置圆角半径
            // 设置矩形区域，缩小 GradientDrawable 的大小
            gd.setBounds(0, 0, view.getWidth() - view.getPaddingLeft() - view.getPaddingRight(), view.getHeight() - view.getPaddingTop() - view.getPaddingBottom());
            view.setBackground(gd); // 将新的 ShapeDrawable 对象设置为 Toast 的 View 的背景
            // 设置内部填充，使文本与边框的高度匹配
            view.setPadding(20, 20, 20, 20);
            TextView textView = view.findViewById(android.R.id.message);
            textView.setTypeface(Typeface.DEFAULT_BOLD); // 将文本设置为粗体
            toast.setGravity(Gravity.BOTTOM, 0, 700); // 设置 gravity 属性为 Gravity.BOTTOM，并将 Y 轴偏移量设置为 700
            toast.show();
        }
    });
}
public void 存(String a,String b,String c)
{
putString(a,b,c);
}
public String 取(String a,String b)
{
return getString(a,b);
}







//上下管理
public String 设置管理员(String qun,String qq,int type)
{
try{
String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("qun.qq.com");
String put="gc="+qun+"&ul="+qq+"&op="+type+"&bkn="+GetBkn(getSkey());
		JSONObject json = new JSONObject(httppost("https://qun.qq.com/cgi-bin/qun_mgr/set_group_admin",cookie,put));
		int ec=json.get("ec");
		String em=json.get("em");
		if(ec==0) return "操作成功";
		else if(ec==13)	return "失败，管理位置已满";
		else return "失败，原因:\n"+em;
		}
catch(Exception e)
            {
                return "失败，原因:\n"+e;
            } 
}


public void ts3(String Title, String Content)
 {
	Activity ThisActivity = GetActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run() {
			final ProgressDialog pd = new ProgressDialog(ThisActivity);
			pd.setTitle(Title);
			pd.setMessage(Content);
			pd.setCancelable(false);
			pd.show();
			new Thread() {
				public void run() {
					while(true){
						Thread.sleep(3000);
						if(OK2=true)
						{
							// break;
							pd.dismiss();
							break;
						}
					}
				};
			}.start();
		}
	});
}


public void 弹窗(String Title, String Content)
{
	Activity ThisActivity = GetActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run() {
			AlertDialog alertDialog = new AlertDialog.Builder(ThisActivity,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).create();
			alertDialog.setTitle(Title);
			alertDialog.setMessage(Content);
			alertDialog.setCancelable(false);
			alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {}
			});
			alertDialog.show();
		}
	});
}


public long 权限(String qun,String qq)
{
ArrayList AdminList=new ArrayList();
boolean check=false;
for(Object group:getGroupList()){
   if(qun.equals(group.GroupUin)){
    if(group.GroupOwner.equals(qq))
    {return 3;}
    if(Arrays.asList(group.AdminList).contains(qq))
    {return 2; }
    if(读(qun,"代管",qq)==1)
    {return 1;}
    return 0;
    check=true;
    }}
if(!check) {return 0;}
}



import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Enumeration;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import java.net.HttpURLConnection;
import java.io.*;
import java.net.*;
String hre="0/0/0";
import java.text.DecimalFormat;
public String formatFileSize(long fileS) {
DecimalFormat df = new DecimalFormat("#.00");
String fileSizeString = "";
String wrongSize = "0B";
if (fileS == 0) {
return wrongSize;
}
if (fileS < 1024) {
fileSizeString = df.format((double) fileS) + "B";
} else if (fileS < 1048576) {
fileSizeString = df.format((double) fileS / 1024) + "KB";
} else if (fileS < 1073741824) {
fileSizeString = df.format((double) fileS / 1048576) + "MB";
} else {
fileSizeString = df.format((double) fileS / 1073741824) + "GB";
}
return fileSizeString;
}





public void 等待(String Title, String Content) {
    // 获取当前的Activity
    Activity ThisActivity = GetActivity();

    // 在UI线程上运行一个新的Runnable对象
    ThisActivity.runOnUiThread(new Runnable() {
        public void run() {
            // 创建一个新的ProgressDialog实例
            final ProgressDialog pd = new ProgressDialog(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            pd.setTitle(Title); // 设置对话框的标题
            pd.setMessage(Content); // 设置对话框的内容
            pd.setCancelable(false); // 设置对话框不能被取消
            pd.show(); // 显示对话框

            // 创建一个Handler对象，用于在指定的时间后关闭对话框
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    pd.dismiss(); // 关闭对话框
                }
            }, 1000); // time参数表示对话框将会在time毫秒后关闭
        }
    });
}



private static int 更新=0;
   


public void 更新版本() {
    Activity thisActivity = GetActivity();
    thisActivity.runOnUiThread(new Runnable() {
        public void run() {
            // 创建一个LinearLayout来容纳TextView和Button
            LinearLayout layout = new LinearLayout(thisActivity);
            layout.setOrientation(LinearLayout.VERTICAL);

            // 设置对话框标题
            TextView titleTextView = new TextView(thisActivity);
            titleTextView.setText("发现新版本");
            titleTextView.setTextColor(Color.parseColor("#DC143C"));
            titleTextView.setTextSize(20);
            titleTextView.setGravity(Gravity.CENTER);
            layout.addView(titleTextView);

// 创建动态展示更新信息的TextView
final TextView infoTextView = new TextView(thisActivity);
infoTextView.setGravity(Gravity.CENTER); // 设置文本内容居中显示
layout.addView(infoTextView);

            // 创建一个水平的LinearLayout来容纳按钮
            LinearLayout buttonLayout = new LinearLayout(thisActivity);
            buttonLayout.setOrientation(LinearLayout.HORIZONTAL);

            // 创建取消按钮
            Button cancelButton = new Button(thisActivity);
            cancelButton.setText("取消更新");
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.weight = 1;
            cancelButton.setLayoutParams(params);
            buttonLayout.addView(cancelButton);

            // 创建下载按钮
            Button downloadButton = new Button(thisActivity);
            downloadButton.setText("立即更新");
            downloadButton.setLayoutParams(params);
            buttonLayout.addView(downloadButton);

            layout.addView(buttonLayout);

            // 创建对话框并设置内容为LinearLayout
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(thisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            alertDialogBuilder.setView(layout);
            alertDialogBuilder.setCancelable(false);
            final AlertDialog alertDialog = alertDialogBuilder.create();

            // 设置取消按钮的点击事件
            cancelButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });

            // 设置下载按钮的点击事件
            downloadButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // 下载处理逻辑，你的下载代码可以放在这里
                                        new Thread(new Runnable(){
public void run(){
if(更新==4)
{
等待("提示","正在下载，请不要重复点击");
return;
}

if(更新==3)
{
等待("提示","已经更新过,重新加载脚本即可");
return;
}

String saveDir = AppPath+"/更新.zip";
等待("提示","正在开始下载");
try {
URL url = new URL(下载链接);
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
int fileSize = conn.getContentLength();
等待("提示","正在下载\n总大小:" + formatFileSize(fileSize));

BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
FileOutputStream out = new FileOutputStream(saveDir);
更新=4;
byte[] buffer = new byte[1024];
int len;
int downloadedSize = 0;
while ((len = in.read(buffer)) != -1) {
Thread.sleep(100);
 out.write(buffer, 0, len);
 downloadedSize += len;
 hre="总大小:" + formatFileSize(fileSize)+ "\n已下载:" + formatFileSize(downloadedSize)+ "(" + (downloadedSize * 100 / fileSize) + "%)";
 等待("提示","正在下载\n"+hre);
}
in.close();
out.close();
更新=1;
if(更新==1)
{
dealzip(AppPath+"/更新.zip",AppPath+"/瑶妹/");
Delete(AppPath+"/更新.zip");
更新=2;
}
if(更新==2)
{
等待("提示","更新完毕,重新加载脚本即可");
提示("更新完毕,重新加载脚本即可");
更新=3;
}
} catch (IOException e) {
等待("提示","下载失败，可能下载链接失效\n请稍后再试或联系作者");
提示("下载失败");
}
    }}).start();
                }
            });

            alertDialog.show();

            // 动态展示更新信息
            final String updateInfo = "瑶妹\n" + 当前版本 + " → " + 最新版本 + "\n\n更新日志:\n" + 最新版本 + "\n" + 更新日志;
            final int delayInMillis = 50; // 设置每个字符显示的间隔时间（毫秒）
            
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                int charIndex = 0;

                public void run() {
                    if (charIndex < updateInfo.length()) {
                        infoTextView.setText(updateInfo.substring(0, charIndex + 1));
                        infoTextView.setTextSize(15);
                        infoTextView.setTextColor(Color.parseColor("#6520E6"));
                        charIndex++;
                        handler.postDelayed(this, delayInMillis);
                    }
                }
            }, delayInMillis);
        }
    });
}

String Colour = "随机";
//字体颜色可填：红色、黑色、蓝色、蓝绿、白灰、灰色、绿色、深灰、洋红、透明、白色、黄色、随机
String Backgroundcolor = "#FFFFFFFF";//背景色，采用RGB十六进制色码

public String MakeTextPhoto(String text){
text=text.replace("[]","");
String[] word=text.split("\n");

float textsize=40.0f;
float padding=30.0f;

Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
paint.setTypeface(typeface);
paint.setTextSize(textsize);
Bitmap mybitmap;
float text_width=0;
float average_width=0;
float text_height=0; 
String newword="";
for(String line:word){
average_width +=paint.measureText(line);}
average_width=average_width/word.length;

for(String line:word){
float width=paint.measureText(line);
if(width-average_width>700){
int rr=Math.ceil(width/average_width);
int cut=Math.ceil(line.length()/rr);

line=splitString(line,cut);
for(String newl:line.split("\n")){
width=paint.measureText(newl);
if(text_width<width) text_width=width;}}
if(text_width<width) text_width=width;
newword+=line+"\n";}
word=newword.split("\n");

int width=(int)(text_width  + padding * 2f);
int heigth=(int)((textsize+8) * word.length+ padding * 2f)-8;
Bitmap original = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);

Canvas canvas=new Canvas(original);
canvas.drawColor(ParseColor(Backgroundcolor,Color.WHITE));
paint.setColor(getColor(Colour));
float yoffset=textsize+padding;
for(String line:word){
canvas.drawText(line, padding, yoffset, paint);
yoffset += textsize+8;}
String path=AppPath+"/缓存/"+canvas+".jpg";
File end = new File(path);
if(!end.exists()) end.getParentFile().mkdirs();
FileOutputStream out = new FileOutputStream(end);
original.compress(Bitmap.CompressFormat.JPEG, 80, out);
out.close();
return path;}

private static String randomColor(int len){
	try{
		StringBuffer result = new StringBuffer();
			for (int i = 0; i < len; i++){
				result.append(Integer.toHexString(new Random().nextInt(16)));
			}
			return result.toString().toUpperCase();
		}catch (Exception e){
			return "00CCCC";
		}
	};
public static int getColor(String color)
{
	switch(color)
	{
		case "红色":
			return Color.RED;
		case "黑色":
			return Color.BLACK;
		case "蓝色":
			return Color.BLUE;
		case "蓝绿":
			return Color.CYAN;
		case "白灰":
			return Color.LTGRAY;
		case "灰色":
			return Color.GRAY;
		case "绿色":
			return Color.GREEN;
		case "深灰":
			return Color.DKGRAY;
		case "洋红":
			return Color.MAGENTA;
		case "透明":
			return Color.TRANSPARENT;
		case "白色":
			return Color.WHITE;
		case "黄色":
			return Color.YELLOW;
		case "随机":
			return Color.parseColor("#"+randomColor(6));
		default:
			return Color.parseColor("#"+color);
	}
};