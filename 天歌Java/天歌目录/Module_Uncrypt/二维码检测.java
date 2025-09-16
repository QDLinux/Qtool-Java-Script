public boolean M_二维码(Object msg)
{
	if(msg.Message_Type == 0)
	{
		if(msg.Message_UserUin.equals(mQQ))
		{
			if(msg.Message_Content.equals("开启二维码检测"))
			{
				MySwitch.ChangeSwitch(msg.Message_GroupUin, "群二维码检测", true);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启该群二维码检测,二维码内容将进行违禁词检测");
			}
			if(msg.Message_Content.equals("关闭二维码检测"))
			{
				MySwitch.ChangeSwitch(msg.Message_GroupUin, "群二维码检测", false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭该群二维码检测");
			}
			if(msg.Message_Content.equals("开启二维码违禁"))
			{
				MySwitch.ChangeSwitch(msg.Message_GroupUin, "群二维码违禁", true);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已开启该群二维码违禁,发现二维码将等同于违禁词");
			}
			if(msg.Message_Content.equals("关闭二维码违禁"))
			{
				MySwitch.ChangeSwitch(msg.Message_GroupUin, "群二维码违禁", false);
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "已关闭该群二维码违禁");
			}
		}
	}
	if(msg.Message_Type == 1)
	{
		if(msg.Message_UserUin.equals(mQQ)) return false;
		if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", msg.Message_UserUin) == 1)
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视违禁词")==1)
			{
				return false;
			}
		}
		if(MySwitch.CheckSwitch(msg.Message_GroupUin, "群二维码检测"))
		{
			new Thread(new Runnable()
			{
				public void run()
				{
					String CheckResule = http.get(ServiceRoot + "jx/qrcode?link=" + java.net.URLEncoder.encode(msg.Message_Content));
					if(CheckResule.equals("null")) return;
					if(CheckResule.equals("调用失败"))return;
					msg.QRResult = CheckResule;
					CheckQrCode(msg);
				}
			}).start();
		}
		else if(MySwitch.CheckSwitch(msg.Message_GroupUin, "群二维码违禁"))
		{
			new Thread(new Runnable()
			{
				public void run()
				{
					String CheckResule = http.get(ServiceRoot + "jx/qrcode?link=" + java.net.URLEncoder.encode(msg.Message_Content));
					if(CheckResule.equals("null")) return;
					if(CheckResule.equals("调用失败"))return;
					msg.QRResult = CheckResule;
					CheckQrCode(msg);
				}
			}).start();
		}
	}
	if(msg.Message_Type == 4)
	{
		if(msg.Message_UserUin.equals(mQQ)) return false;
		if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "list", msg.Message_UserUin) == 1)
		{
			if(item.GetItemDataInt(msg.Message_GroupUin, "admin", "guard", "无视违禁词")==1)
			{
				return false;
			}
		}
		for(String PicLink : msg.PicList)
		{
			final String thrLink = PicLink;
			if(MySwitch.CheckSwitch(msg.Message_GroupUin, "群二维码检测"))
			{
				new Thread(new Runnable()
			{
				public void run()
				{
					String CheckResule = http.get(ServiceRoot + "jx/qrcode?link=" + java.net.URLEncoder.encode(thrLink));
					if(CheckResule.equals("null")) return;
					if(CheckResule.equals("调用失败"))return;
					msg.QRResult = CheckResule;
					CheckQrCode(msg);
				}
			}).start();
			}
			else if(MySwitch.CheckSwitch(msg.Message_GroupUin, "群二维码违禁"))
			{
				new Thread(new Runnable()
			{
				public void run()
				{
					String CheckResule = http.get(ServiceRoot + "jx/qrcode?link=" + java.net.URLEncoder.encode(thrLink));
					if(CheckResule.equals("null")) return;
					if(CheckResule.equals("调用失败"))return;
					msg.QRResult = CheckResule;
					CheckQrCode(msg);
				}
			}).start();
			}
		}
	}
	return false;
}
public void CheckQrCode(Object msg)
{
	if(MySwitch.CheckSwitch(msg.Message_GroupUin, "群二维码检测"))
	{
		msg.Message_Content = msg.QRResult;
		msg.Message_Type = 0;
		Module_消息监控(msg);
	}
	if(MySwitch.CheckSwitch(msg.Message_GroupUin, "群二维码违禁"))
	{
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRecall") == 1)
		{
			record(msg.msg);
		}
		int aaa = 0;
		String text = "@" + msg.nickName + " 你触犯了违禁词";
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbid") == 1)
		{
			text = text + ",禁言" + secondToTime(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime"));
			MyMsgApi.Group_Forbidden(msg.Message_GroupUin, msg.Message_UserUin, item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckForbidTime"));
			aaa = 1;
		}
		if(item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemove") == 1)
		{
			item.SetItemData(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数", item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") + 1);
			text = text + ",被警告一次,你一共被警告" + item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") + "次,被警告" + item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum") + "次就会被踢出群";
			if(item.GetItemDataInt(msg.Message_GroupUin, msg.Message_UserUin, "Setting", "警告次数") >= item.GetItemDataInt(msg.Message_GroupUin, "Setting", "GroupGuard", "WordCheckRemoveNum"))
			{
				MyMsgApi.Message_Send_Group(msg.Message_GroupUin, "@" + msg.nickName + " 你的警告次数已达到限制,将被踢出群");
				MyMsgApi.Group_Kick(msg.Message_GroupUin, msg.Message_UserUin, false);
				aaa = 1;
				return;
			}
			aaa = 1;
		}
		if(aaa == 1)
		{
			MyMsgApi.Message_Send_Group(msg.Message_GroupUin, text);
		}
	}
}
