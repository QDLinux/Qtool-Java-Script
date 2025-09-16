String mQQ = MyUin.substring(0)+"";
public class MessageObject
{
	String Message_Content;
	int Message_Type;
	long Message_Time;
	String Message_UserUin;
	String Message_GroupUin;
	boolean isGroup;
	String[] atList;
	String nickName;
	Object msg;
	boolean atMe;
	String[] PicList;
	String QRResult;
	int mRedPackType;
}
public class ld_MsgApi
{
	public void OnMsgMessage(MessageObject msg)
	{
		CallAllModules(msg);
	}
	public void Message_Send_Group(String GroupUin, String Message)
	{
		sendMsg(GroupUin, "", Message);
	}
	public void Message_Send_Group(String GroupUin, String Message, String[] AtList)
	{
		sendMsg(GroupUin, "", Message);
	}
	public void Message_Send_Friend(String FriendUin, String Message)
	{
		sendMsg("", FriendUin, Message);
	}
	public void Message_Send_Private(String GroupUin, String QQUin, String Message)
	{
		sendMsg(GroupUin, QQUin, Message);
	}
	public void Message_Send_Group_image(String GroupUin, String Message)
	{
		sendPic(GroupUin, "", Message);
	}
	public void Message_Send_Friend_image(String FriendUin, String Message)
	{
		sendPic("", FriendUin, Message);
	}
	public void Message_Send_Private_image(String GroupUin, String QQUin, String Message)
	{
		sendPic(GroupUin, QQUin, Message);
	}
	public void Message_Send_Group_voice(String GroupUin, String Message)
	{
		sendVoice(GroupUin, "", Message);
	}
	public void Message_Send_Friend_voice(String FriendUin, String Message)
	{
		sendVoice("", FriendUin, Message);
	}
	public void Message_Send_Private_voice(String GroupUin, String QQUin, String Message)
	{
		sendVoice(GroupUin, QQUin, Message);
	}
	public void Message_Send_Group_Card(String GroupUin, String Message)
	{
		sendCard(GroupUin, "", Message);
	}
	public void Message_Send_Friend_Card(String Frienduin, String Message)
	{
		sendCard("", Frienduin, Message);
	}
	public void Message_Send_Private_Card(String GroupUin, String QQUin, String Message)
	{
		sendCard(GroupUin, QQUin, Message);
	}
	public void Group_Forbidden(String GroupUin, String QQUin, long time)
	{
		Forbidden(GroupUin, QQUin, (int)time);
	}
	public void Group_Forbidden_All(String GroupUin, boolean flag)
	{
		Forbidden(GroupUin, "", flag ? 1 : 0);
	}
	public void Group_Kick(String GroupUin, String QQUin, boolean black)
	{
		Kick(GroupUin, QQUin, black);
	}
	public void Group_ChangeName(String GroupUin, String QQUin, String Name)
	{
		setCard(GroupUin, QQUin, Name);
	}
	public void Group_SetTitle(String GroupUin, String QQUin, String Title)
	{
		setTitle(GroupUin, QQUin, Title);
	}
	public void Group_Send_Mix_P_Text(String GroupUin, String Title, String PicLink, String Text)
	{
		sendMsg(GroupUin, "", Title + "[PicUrl=" + PicLink + "]" + Text);
	}
}
ld_MsgApi MyMsgApi = new ld_MsgApi();
public void Callback_OnRawMsg(Object data)
{
	Object MessageRecord = data;
	if(MessageRecord.getClass().getSimpleName().equals("MessageForQQWalletMsg"))
	{
		int mMsgType = MessageRecord.messageType;
		/*
		口令红包  6
		普通红包  2
		画图红包  22
		GOLD_REDPACKET 23
		一笔画红包  20
		拼手气红包  3
		语音红包  13
		接龙红包  成语接龙21英文接龙24飞花令25诗词27
		专属红包  8
		
		*/
		if(mMsgType == 6 || mMsgType == 2 || mMsgType == 22 || mMsgType == 23 || mMsgType == 20 || mMsgType == 3 || mMsgType == 13 || mMsgType == 21 || mMsgType == 24 || mMsgType == 25 || mMsgType == 27)
		{
			MessageObject obj = new MessageObject();
			//只处理群聊红包,私聊不处理
			if(MessageRecord.istroop == 1)
			{
				obj.Message_Content = MessageRecord.msg;
				obj.Message_Type = 5;
				obj.Message_Time = MessageRecord.time;
				obj.Message_UserUin = MessageRecord.senderuin;
				obj.Message_GroupUin = MessageRecord.frienduin;
				obj.isGroup = true;
				obj.nickName = "";
				obj.msg = data;
				obj.mRedPackType = mMsgType;
				MyMsgApi.OnMsgMessage(obj);
			}
		}
	}
}
public void onMsg(Object data)
{
	MessageObject obj = new MessageObject();
	if(data.MessageType == 1)
	{
		obj.atMe = data.mAtList.contains(MyUin);
		if(data.MessageContent.startsWith("[PicUrl=") && data.MessageContent.endsWith("]"))
		{
			if(data.IsGroup)
			{
				obj.Message_Content = data.MessageContent.substring(8,data.MessageContent.length()-1);
				obj.Message_Type = 1;
				obj.Message_Time = data.MessageTime;
				obj.Message_UserUin = data.UserUin;
				obj.Message_GroupUin = data.GroupUin;
				obj.isGroup = true;
				obj.atList = data.AtList;
				obj.nickName = data.SenderNickName;
				obj.msg = data;
			}
			else
			{
				obj.Message_Content = data.MessageContent.substring(8,data.MessageContent.length()-1);
				obj.Message_Type = 1;
				obj.Message_Time = data.MessageTime;
				obj.Message_UserUin = data.UserUin;
				obj.Message_GroupUin = data.GroupUin;
				obj.isGroup = false;
				obj.atList = data.AtList;
				obj.nickName = data.SenderNickName;
				obj.msg = data;
			}
		}
		else
		{
			if(data.IsGroup)
			{
				obj.Message_Content = data.MessageContent;
				obj.Message_Type = 0;
				obj.Message_Time = data.MessageTime;
				obj.Message_UserUin = data.UserUin;
				obj.Message_GroupUin = data.GroupUin;
				obj.isGroup = true;
				obj.atList = data.AtList;
				obj.nickName = data.SenderNickName;
				obj.msg = data;
			}
			else
			{
				obj.Message_Content = data.MessageContent;
				obj.Message_Type = 0;
				obj.Message_Time = data.MessageTime;
				obj.Message_UserUin = data.UserUin;
				obj.Message_GroupUin = data.GroupUin;
				obj.isGroup = false;
				obj.atList = data.AtList;
				obj.nickName = data.SenderNickName;
				obj.msg = data;
			}
		}
		MyMsgApi.OnMsgMessage(obj);
	}
	if(data.MessageType==2)
	{
		if(data.IsGroup)
			{
				obj.Message_Content = data.MessageContent;
				obj.Message_Type = 2;
				obj.Message_Time = data.MessageTime;
				obj.Message_UserUin = data.UserUin;
				obj.Message_GroupUin = data.GroupUin;
				obj.isGroup = true;
				obj.atList = data.AtList;
				obj.nickName = data.SenderNickName;
				obj.msg = data;
			}
			else
			{
				obj.Message_Content = data.MessageContent;
				obj.Message_Type = 2;
				obj.Message_Time = data.MessageTime;
				obj.Message_UserUin = data.UserUin;
				obj.Message_GroupUin = data.GroupUin;
				obj.isGroup = false;
				obj.atList = data.AtList;
				obj.nickName = data.SenderNickName;
				obj.msg = data;
			}
			MyMsgApi.OnMsgMessage(obj);
	}
	if(data.MessageType==3)
	{
		
	}
	
}
public void OnChangedMixMsg(Object data)
{
	MessageObject obj = new MessageObject();
	obj.Message_Content = data.MessageContent;
	obj.Message_Type = 4;
	obj.Message_Time = data.MessageTime;
	obj.Message_UserUin = data.UserUin;
	obj.Message_GroupUin = data.GroupUin;
	obj.isGroup = false;
	obj.atList = data.AtList;
	obj.nickName = data.SenderNickName;
	obj.PicList = data.PicList;
	obj.msg = data;
}
public void OnTroopEvent(String GroupUin, String QQUin, int EventType)
{
	if(EventType == 2)
	{
		MessageObject obj = new MessageObject();
		obj.Message_Content = "";
		obj.Message_Type = 3;
		obj.Message_Time = System.currentTimeMillis() / 1000;
		obj.Message_UserUin = QQUin;
		obj.Message_GroupUin = GroupUin;
		obj.isGroup = true;
		obj.nickName = "";
		MyMsgApi.OnMsgMessage(obj);
	}
}