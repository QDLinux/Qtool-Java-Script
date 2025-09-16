public void 词条(Object data)
{
	String quntext = data.MessageContent;
	String qq = data.UserUin;
	String qun = data.GroupUin;

if(("1".equals(getString(qun,"词条系统"))))
{


if(quntext.equals("随机一言"))
{
String y=get("http://ffy.fufuya.top/api/yiyan2.php");
c=y.replace("——","\n——");
sendm(qun,c);
}

if(quntext.equals("随机毒鸡汤"))
{
String c=get("https://xiaobai.klizi.cn/API/other/djt.php");
sendm(qun,c);
}


if(quntext.startsWith("字数检测"))
{
text = quntext.substring(4);
String c=get("https://v.api.aa1.cn/api/api-zishu/cha.php?msg="+text);
sendm(qun,"结果:"+c+"个字");
}


}

}