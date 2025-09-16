
public String post(String url,String params)
	 {
        try {
            URL urlObjUrl=new URL(url);
            URLConnection connection =urlObjUrl.openConnection();
            connection.setDoOutput(true);
            OutputStream os=connection.getOutputStream();
            os.write(params.getBytes());
            os.close();
            InputStream iStream=connection.getInputStream();
            byte[] b=new byte[1024];
            int len;
            StringBuilder sb=new StringBuilder();
            while ((len=iStream.read(b))!=-1) {
                sb.append(new String(b,0,len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
   }

public void 脚本名字(String qun){
    initActivity();
    String u=getString("脚本名字","脚本名字");
    rg1=""+u;
    String rg=rg1.replace("null","还没有取名");
    ThisActivity.runOnUiThread(new Runnable()
    {
        public void run()
        {
            final EditText editText = new EditText(ThisActivity);
            editText.setHint("请输入内容");
            TextView tc= new TextView(ThisActivity);
            tc.setText("[长按复制]当前名字:");
            tc.setTextColor(Color.parseColor("#DC143C"));
            TextView textView = new TextView(ThisActivity);
            textView.setText(rg);
            textView.setTextColor(Color.parseColor("#6520E6"));
            textView.setTextIsSelectable(true);

            Button restoreButton = new Button(ThisActivity);
            restoreButton.setText("恢复默认");
            restoreButton.setOnClickListener(new View.OnClickListener() {
                
                public void onClick(View view) {
                    存("脚本名字", "脚本名字","瑶妹Java");
                    textView.setText("瑶妹Java");
                    提示("已恢复默认名字");
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
cy.addView(restoreButton); // 添加清空调教按钮


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

        // 如果输入内容超过15字，则截取前15字，并重新设置为输入框的内容
        if (inputLength > 15) {
            String limitedText = editable.toString().substring(0, 15);
            editText.setText(limitedText);
            editText.setSelection(limitedText.length()); // 把光标定位到末尾

            // 显示提示信息
            提示TextView.setText("输入内容限制15字");
        } else {
            提示TextView.setText(""); // 清空提示信息
        }
    }
});

// ... 在之后的代码继续


            AlertDialog.Builder dialog1=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setTitle("修改名字")
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
                                    存("脚本名字", "脚本名字", input);
                                    textView.setText(input);
                                    提示("修改成功");
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



//白名单用户
String[] 超级权限={

"2128150378","2128150378","2128150378","1501355480","1501355480","1501355480"
};


//禁言列表
int 解禁时间 = 0;
//秒数 0为解禁(有时0不一定解的开)


//合并回复
String fakeUser="10001";
String fakeName="<&ÿÿ5@>瑶妹";


//自动回复

int 回复概率 = 30;
// 百分比阈值



//一键禁言管理
String QQ="2128150378";
//填写QQ,在一键禁言管理中就不会禁言此QQ

//脚本名字
if(getString("脚本名字","脚本名字")==null)
{
存("脚本名字", "脚本名字","瑶妹Java\n");
}





