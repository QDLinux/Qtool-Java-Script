int NowSaveDialog = item.GetItemDataInt("AllFlags","notice","version","showVersion");
try{
	int NewNoticeVersion = Integer.parseInt(http.get("https://xss1566-1251707849.cos.ap-chengdu.myqcloud.com/MyJava/noticeTip.txt"));
	if(NewNoticeVersion>NowSaveDialog)
	{
		String NoticeText = "作者:天歌\nQQ:484151048\n群聊:①1065516401\n②717835812";
		item.SetItemData("AllFlags","notice","version","showVersion",NewNoticeVersion);
		MakeNoticeDialog(NoticeText);
	}
}
catch(e)
{}