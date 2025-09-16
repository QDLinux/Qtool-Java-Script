/*
由卑微萌新(QQ779412117)开发，使用请保留版权

QQ上传文件接口

通用
upload(String qun,String filepath); 
参数: 类似QT/菜豆发送消息自动判断是群还是频道还是私聊。
群号/频道号&频道ID(data.GroupUin)，QQ号，文件路径

群
sendFile(String qun,String filepath); 
参数: 群号,文件路径

好友
sendFriendFile(String qq,String filepath); 
参数: QQ号,文件路径

群私聊
sendSiLiaoFile(String qun,String qq,String filepath)
参数:群号，QQ号，文件路径

频道
sendGuildFile(String id,String filepath);
参数:频道ID，文件路径

*/

import java.lang.*;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;

FileManagerEngine filemanager=new FileManagerEngine(app);

public void upload(String qun,String qq,String filepath)
{
if(qun==null||qun.equals(""))  sendFriendFile(qq,filepath);
else if(qun.contains("&")) sendGuildFile(qun.replaceAll(".*&(.*)","$1"),filepath);
else if(qq==null||qq.equals("")) sendFile(qun, filepath);
else sendSiLiaoFile(qun,qq,filepath);
}


public Object sendFile(String qun,String filepath)
{
if(QQ_version>=9280) return filemanager.I0(filepath,qun,1,1);
else if(QQ_version>=8845) return filemanager.L0(filepath,qun,1,1);
else if(QQ_version<8000) return filemanager.a(filepath,qun,1,1);
else{
Toast("版本"+QQ_version+"未适配发送群文件!");
return null;
}
}


public Object SendPersonFile(String filepath,String num1,String num2,int numtype)
{
if(QQ_version>=9280) return filemanager.E0(filepath,num1,num2,numtype,true);
else if(QQ_version>=8845) return filemanager.H0(filepath,num1,num2,numtype,true);
else if(QQ_version<8000) return filemanager.a(filepath,num1,num2,numtype,true);
else{
Toast("版本"+QQ_version+"未适配发送个人文件!");
return null;
}
}

public Object sendFriendFile(String qq,String filepath)
{
return SendPersonFile(filepath,qq,qq,0);
}

public Object sendSiLiaoFile(String qun,String qq,String filepath)
{
return SendPersonFile(filepath,quncode(qun),qq,1000);
}

public void sendGuildFile(String id,String filepath)
{
if(QQ_version>=9280) filemanager.K0(filepath,id);
else if(QQ_version>=8845) filemanager.N0(filepath,id);
else if(QQ_version<8000) filemanager.e(filepath,id);
else{
Toast("版本"+QQ_version+"未适配发送频道文件!");
}
}