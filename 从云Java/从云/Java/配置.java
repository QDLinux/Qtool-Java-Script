public void sess1(String qun,String qq,int type)
{
initActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
String[] items={"登录QQ音乐设置","点歌违禁词设置","点歌列表设置","点歌列表格式设置","选歌列表设置","其他杂项设置"};
		AlertDialog.Builder bf=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		bf.setTitle("功能设置");
		bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
sess1(qun,qq,type);
if(which==0)
{
String zt="没设置";
if(取("点歌","dlqqyy")==null)
{}else{
zt=取("点歌","dlqqyy");
}
sess3("设置登录QQ音乐时候的QQ\n当前QQ:"+zt,"请输入QQ","dlqqyy");
}else if(which==1)
{
String zt="开启";
if(取("点歌","dgwjc")==null)
{
zt="关闭";
}
sess2("点歌违禁词是否开启\n当前状态:"+zt,"dgwjc");
}else if(which==2)
{
String zt="10";
if(取("点歌","dglbsz")==null)
{}else{
zt=取("点歌","dglbsz");
}
sess3("点歌列表设置\n当前列表发送个数:"+zt,"1-50","dglbsz");
}else if(which==3)
{
String zt="1";
if(取("点歌","dglbgs")==null)
{}else{
zt=取("点歌","dglbgs");
}
sess3("点歌列表格式设置\n当前格式:"+zt,"1文字,2图片,3合并转发(合并转发仅支持qtool,彩豆无效),4卡片点歌(如果过多可能发出去了别人看不到,如果卡片发不出去就自动发送文字,建议每次点歌列表最大数量设置10)","dglbgs");
}else if(which==4)
{
String zt="0";
if(取("点歌","xglbsz")==null)
{}else{
zt=取("点歌","xglbsz");
}
sess3("选歌列表设置\n当前列表:"+zt,"选歌列表超过1时自动选第几个(默认模式)，0不自动选(发送列表选)。","xglbsz");
}else if(which==5)
{
String hr=read(AppPath+"/配置.java");
sess4("杂项设置",hr);
}
}
});
bf.show();
		}
	});
//Toast("d");
}
public void sess2(String title,String key)
{
initActivity();
ThisActivity.runOnUiThread(new Runnable()
{
public void run()
{
String zt="开启";
if(取("点歌",key)==null)
{
zt="关闭";
}
String[] items={"开启","关闭"};
AlertDialog.Builder bf=new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		bf.setTitle(title+"\n当前状态:"+zt);
		bf.setItems(items, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int which) {
if(which==0)
{
存("点歌",key,"1");
dgwjc=1;
Toast("开启成功");
}else{
存("点歌",key,null);
dgwjc=2;
Toast("关闭成功");
}
}
});
bf.show();
		}
	});
}
public void sess3(String title,String title2,String key)
{
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
			TextView tc = new TextView(ThisActivity);
			tc.setText(title);
			tc.setTextColor(Color.parseColor("#8B4513"));
			tc.setTextSize(20);
			final EditText editText = new EditText(ThisActivity);
			editText.setHint(title2);
			LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc);
        cy.addView(editText);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("功能设置").setView(cy).setPositiveButton("确认", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
				String txt=editText.getText().toString();
                if(!txt.matches("[0-9]+"))
                {
                Toast("请输入纯数字！");
                }else{
                存("点歌",key,txt);
                if(key.equals("dglbsz"))
                {
                listnum=Integer.parseInt(取("点歌","dglbsz"));
                }else if(key.equals("dlqqyy"))
                {
                LoginUin=txt;
                }else if(key.equals("dglbgs"))
                {
                listtype=Integer.parseInt(取("点歌","dglbgs"));
                }else if(key.equals("xglbsz"))
                {
                autoset=Integer.parseInt(取("点歌","xglbsz"));
                }else{
                Toast("没有这个功能！");
                }
                Toast("设置成功");
                }
				}
			}).setNegativeButton("取消", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{

				}
			}).show();
		}
	});
	}
public void sess4(String title,String title2)
{
    initActivity();
	ThisActivity.runOnUiThread(new Runnable()
	{
		public void run()
		{
			TextView tc = new TextView(ThisActivity);
			tc.setText(title);
			final EditText editText = new EditText(ThisActivity);
			editText.setText(title2);
			LinearLayout cy=new LinearLayout(ThisActivity);
        cy.setOrientation(LinearLayout.VERTICAL);
        cy.addView(tc);
        cy.addView(editText);
			new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("功能设置").setView(cy).setPositiveButton("确认", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
                String txt=editText.getText().toString();
                put(AppPath+"/配置.java",txt);
                ts("提示","设置成功！重新加载脚本即可生效。");
				}
			}).setNegativeButton("恢复默认", new DialogInterface.OnClickListener()
			{
				public void onClick(DialogInterface dialogInterface, int i)
				{
                String pz=read(AppPath+"/从云/勿动勿删/不要动不要删");
               put(AppPath+"/配置.java",pz);
				ts("提示","完成！配置已恢复默认\n重新加载脚本即可生效");
				}
			}).show();
		}
	});
	}
dgkey=2;