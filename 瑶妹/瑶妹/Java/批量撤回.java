


int 帮我撤回条数 = 300;
// 任何人可发送：帮我撤回+条数
// 这里设置的是条数 为0则不帮他人撤回

List sList = Arrays.asList(超级权限);
public boolean ok(String QQ)
{
	for(String str : sList)
	{
		if(str.equals(QQ)) return true;
	}
	return false;
}
public String Tips()
{
return;
}
ArrayList UserCheHuiList = new ArrayList();

public void Callback_OnRawMsg(Object data){
if(!data.senderuin.equals("1000")&&data.msgtype!=-5040){UserCheHuiList.add(data);}
}



public void 撤回(Object data)
{
String quntext = data.MessageContent;
    String qq = data.UserUin;
    String qun = data.GroupUin;
    String GroupUin="";
    String Group="";
    String o="";
for(String u:超级权限){
o=u+","+o;
}
if(帮我撤回条数!=0&&data.MessageContent.matches("帮我撤回[0-99]+"))
{
new Thread(new Runnable()
{
public void run()
{
Object Dai;
int setCount = Integer.parseInt(data.MessageContent.substring(4));
String UserUin = data.UserUin;
int count = 0;
ArrayList RemoveUserUin = new ArrayList();
for(int i = UserCheHuiList.size() - 1; i >= 0; i--)
{
Dai = UserCheHuiList.get(i);
if(Dai.senderuin.equals(UserUin) && Dai.frienduin.equals(data.GroupUin) && count < setCount)
{
revokeMsg(Dai);
RemoveUserUin.add(Dai);
Thread.sleep(1000*1);
count++;
}
}
UserCheHuiList.removeAll(RemoveUserUin);

sendm(qun,"撤回完毕");


}
}).start();
}
if(qq.equals(MyUin))
{
if(data.MessageContent.matches("^撤[0-99]+$"))
{
new Thread(new Runnable()
{
public void run()
{
Object Dai;
int setCount = 1 + Integer.parseInt(data.MessageContent.substring(1));
if(setCount >= 帮我撤回条数) return;
int count = 0;
ArrayList RemoveUserUin = new ArrayList();
for(int i = UserCheHuiList.size() - 1; i >= 0; i--)
{
Dai = UserCheHuiList.get(i);
if(!Dai.getClass().getSimpleName().equals("MessageForTroopFile") && Dai.senderuin.equals(MyUin) &&Dai.frienduin.equals(data.GroupUin) && count < setCount)
{
revokeMsg(Dai);
RemoveUserUin.add(Dai);
Thread.sleep(1000*1);
count++;
}
}
UserCheHuiList.removeAll(RemoveUserUin);
sendm(qun,"撤回完毕");
}
}).start();
}
if(data.MessageContent.matches("^撤回[0-99]+$"))
{
new Thread(new Runnable()
{
public void run()
{
Object Dai;
int setCount = 1 + Integer.parseInt(data.MessageContent.substring(2));
if(setCount >= 帮我撤回条数) return;
int count = 0;
ArrayList RemoveUserUin = new ArrayList();
for(int i = UserCheHuiList.size() - 1; i >= 0; i--)
{
Dai = UserCheHuiList.get(i);
if(!Dai.getClass().getSimpleName().equals("MessageForTroopFile") && Dai.senderuin.equals(MyUin) &&Dai.frienduin.equals(data.GroupUin) && count < setCount)
{
revokeMsg(Dai);
RemoveUserUin.add(Dai);
Thread.sleep(1000*1);
count++;
}
}
UserCheHuiList.removeAll(RemoveUserUin);
sendm(qun,"撤回完毕");
}
}).start();
}

}




if(o.contains(qq)||qq.equals(MyUin))
{
//批量撤回






if(data.MessageContent.startsWith("撤")&&data.mAtList.size()>=1)
{
new Thread(new Runnable()
{
public void run()
{
Object Dai;
int setCount = Integer.parseInt(data.MessageContent.substring(1,data.MessageContent.indexOf("@")));
String UserUin = data.mAtList.get(0);
int count = 0;
ArrayList RemoveUserUin = new ArrayList();

for(int i = UserCheHuiList.size() - 1; i >= 0; i--)
{
Dai = UserCheHuiList.get(i);
if(Dai.senderuin.equals(UserUin) && Dai.frienduin.equals(data.GroupUin) && count < setCount)
{
revokeMsg(Dai);
RemoveUserUin.add(Dai);
Thread.sleep(1000*1);
count++;
}
}
UserCheHuiList.removeAll(RemoveUserUin);

sendm(qun,"撤回完毕");

}
}).start();
}

if(data.MessageContent.startsWith("撤回")&&data.mAtList.size()>=1)
{
new Thread(new Runnable()
{
public void run()
{
Object Dai;
int setCount = Integer.parseInt(data.MessageContent.substring(2,data.MessageContent.indexOf("@")));
String UserUin = data.mAtList.get(0);
int count = 0;
ArrayList RemoveUserUin = new ArrayList();

for(int i = UserCheHuiList.size() - 1; i >= 0; i--)
{
Dai = UserCheHuiList.get(i);
if(Dai.senderuin.equals(UserUin) && Dai.frienduin.equals(data.GroupUin) && count < setCount)
{
revokeMsg(Dai);
RemoveUserUin.add(Dai);
Thread.sleep(1000*1);
count++;
}
}
UserCheHuiList.removeAll(RemoveUserUin);

sendm(qun,"撤回完毕");

}
}).start();
}
if(data.MessageContent.matches("^撤回该群[0-99]+$")||data.MessageContent.matches("^撤回本群[0-99]+$"))
{
new Thread(new Runnable()
{
public void run()
{
Object Dai;
int setCount = 1 + Integer.parseInt(data.MessageContent.substring(4));
int count = 0;
ArrayList RemoveUserUin = new ArrayList();

for(int i = UserCheHuiList.size() - 1; i >= 0; i--)
{
Dai = UserCheHuiList.get(i);
if(Dai.frienduin.equals(data.GroupUin) && count < setCount)
{
revokeMsg(Dai);
RemoveUserUin.add(Dai);
Thread.sleep(1000*1);
count++;
}
}
UserCheHuiList.removeAll(RemoveUserUin);

sendm(qun,"撤回完毕");

}
}).start();
}
}
}