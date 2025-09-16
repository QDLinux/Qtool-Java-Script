

public boolean Call_Game(Object msg)
{
	if(!MySwitch.CheckSwitch(msg.Message_GroupUin, "娱乐系统")) return false;
	if(!IsGroupAdmin(msg.Message_GroupUin,msg.Message_UserUin) && MySwitch.CheckSwitch(msg.Message_GroupUin,"菜单限制")) return false;
	
	if(G_炸弹(msg)) return false;
	if(G_签到(msg)) return false;
	if(G_称号(msg)) return false;
	if(G_坐骑(msg)) return false;
	if(G_打劫(msg)) return false;
	if(G_钓鱼(msg)) return false;
	if(G_对决(msg)) return false;
    if(G_其它(msg)) return false;
	if(T_抢楼指令(msg)) return false;
	if(G_个人信息(msg)) return false;
	if(G_商城(msg)) return false;
	if(G_排行(msg)) return false;
	if(G_卡片(msg)) return false;
	if(G_尾随(msg)) return false;
	if(G_银行(msg)) return false;
	if(G_红包(msg)) return false;
	if(G_管理(msg)) return false;
	return false;
	
}
public void Call_Game_Private(Object msg)
{
	G_卡片(msg);
}
