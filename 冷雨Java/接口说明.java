//以下是接口说明，记得留版权，大部分来自原创
/*
void sendTextPic(String text)发送文字转图片
String getVipInfo(String qq)获取ta的会员信息
String getUserInfo(String qq)获取ta的账号信息
String getQzoneVisiters(String qq)获取ta的QQ空间访客
String getGroupName(String qun)获取群名
String getGroupOwner(String qun)获取群主账号
String getUserName(String qq)获取ta的昵称(不是群名片，不是备注)
String getUserRealName(String qq)获取自己给ta的备注，为空是没有
String getIntimacyScore(String qq)获取与ta的亲密度
String getGender(String qq)获取ta的性别，为空是保密
String getCommfrd(String qq)获取与ta的共同好友数量
String getGreenVipLevel(String qq)获取ta的绿钻等级，为空是0级
String getVipLevel(String qq)获取ta的普通会员/超级会员等级，为空是0级
long getTime(long time)获取时间戳的日期
String 邀请移除管家(String qun,String qq,String skey,String pskey,int type) type(0移除1邀请)
String 管家设置(String qun,String qq,String skey,String pskey,String type,String status) type(1链接3红包2二维码) status(0关闭1开启)
void 链接处理方式(String qun,String qq,String skey,String pskey,String status) status(1撤回3撤回并警告)
String 添加问答(String qun,String qq,String skey,String pskey,String question,String answer) questio(问题不能大于20字) answer(回答不能大于500字) 不支持链接(.cn/.com其他随缘)图片 \n换行
String 删除问答(String qun,String qq,String skey,String pskey,String id) id(删除第几个)
String 触发问答(String qun,String qq,String skey,String pskey,String question,String token) question(问题) token(Q群管家 自助问答卡片里面的token)
Object getbusinesslist(String qq,String skey)获取会员到期时间
String countdown(String time,String time2)分割时间戳
void 转发(String qun,String qq,String uin,String quntext,String menu)
static void 视频.下载视频(String videoUrl, String savePath)
String 视频.真实地址(String shortUrl)
boolean 视频.删除文件(String filePath)
视频.发视频(String qun,String file)
String 随机文件名() 随机文件名
String 年月日() 获取当时日期，具体至天
String 卡片签名(String Card) 卡片签名的，已经寄了
String speakingList(String qun,int time) 获取群的发言
String JSON解析(String data,String a,String b)json解析
void 卡片发送2(String qun,String qq,String text,String name)已寄
void 卡片发送(String qun,String qq,String text,String name)已寄
void sendVedio(String qun,String url)发送视频
String DownloadToFile(String url,String filepath)下载文件
void setTips(String title,String text)发送提示框
void sendVedio1(String qun,String url)免解压发送视频
int getGroupNumber(String qun)获取群人数
void sendFiles(String qun,String filepath)发送群文件
String getMaxGroupMembers(String qun)获取群最大人数
String getGroupMembers(String qun)获取群人数(官方接口)
*/