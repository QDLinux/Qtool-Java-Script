public boolean G_代管设置(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "代管权限_初始化"))
	{
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "无视违禁词", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "无视刷屏检测", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "无视复读检测", 0);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "禁言解禁", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "全员禁言解禁", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "踢人", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "改名", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "黑名单更改", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "白名单更改", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "违禁词更改", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改头衔", 0);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "警告", 1);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改定时任务", 0);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改进群验证", 0);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改进群欢迎", 0);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改自动回复", 0);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改代码处理", 0);
		item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改名片监测", 0);
		MySwitch.ChangeSwitch(msg.Message_GroupUin, "代管权限_初始化", true);
		
	}
	if(msg.Message_UserUin.equals(MyUin))
	{
		if(msg.Message_Content.equals("设置代管权限"))
		{
			initActivity();
			ThisActivity.runOnUiThread(new Runnable()
			{
				public void run()
				{
					try
					{
						final String[] items = {
							"无视违禁词", "无视刷屏检测", "无视复读检测", "禁言解禁", "全员禁言解禁", "踢人", "改名", "黑名单更改", "白名单更改", "违禁词更改", "修改头衔", "警告", "修改定时任务", "修改进群验证", "修改进群欢迎", "修改自动回复", "修改代码处理", "修改名片监测"
						};
						final boolean[] checkedItems = {
							false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
						};
						checkedItems[0] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视违禁词") == 1;
						checkedItems[1] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视刷屏检测") == 1;
						checkedItems[2] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视复读检测") == 1;
						checkedItems[3] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "禁言解禁") == 1;
						checkedItems[4] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "全员禁言解禁") == 1;
						checkedItems[5] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "踢人") == 1;
						checkedItems[6] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "改名") == 1;
						checkedItems[7] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "黑名单更改") == 1;
						checkedItems[8] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "白名单更改") == 1;
						checkedItems[9] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "违禁词更改") == 1;
						checkedItems[10] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改头衔") == 1;
						checkedItems[11] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "警告") == 1;
						checkedItems[12] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改定时任务") == 1;
						checkedItems[13] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改进群验证") == 1;
						checkedItems[14] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改进群欢迎") == 1;
						checkedItems[15] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改自动回复") == 1;
						checkedItems[16] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改代码处理") == 1;
						checkedItems[17] = item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "修改名片监测") == 1;
						AlertDialog.Builder alertDialog = new AlertDialog.Builder(ThisActivity, AlertDialog.THEME_HOLO_LIGHT);
						alertDialog.setTitle("设置当前群代管拥有的权限");
						alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener()
						{
							public void onClick(DialogInterface dialog, int which, boolean isChecked)
							{}
						});
						alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
						{
							public void onClick(DialogInterface dialog, int which)
							{
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "无视违禁词", checkedItems[0] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "无视刷屏检测", checkedItems[1] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "无视复读检测", checkedItems[2] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "禁言解禁", checkedItems[3] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "全员禁言解禁", checkedItems[4] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "踢人", checkedItems[5] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "改名", checkedItems[6] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "黑名单更改", checkedItems[7] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "白名单更改", checkedItems[8] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "违禁词更改", checkedItems[9] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改头衔", checkedItems[10] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "警告", checkedItems[11] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改定时任务", checkedItems[12] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改进群验证", checkedItems[13] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改进群欢迎", checkedItems[14] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改自动回复", checkedItems[15] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改代码处理", checkedItems[16] ? 1 : 0);
								item.SetItemData(msg.Message_GroupUin, "admin", "guard", "修改名片监测", checkedItems[17] ? 1 : 0);
							}
						});
						alertDialog.show();
					}
					catch(e)
					{
						Toast("" + e);
					}
				}
			});
		}
	}
	return false;
}
