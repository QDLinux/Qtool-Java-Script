int jy=60;//设置违禁词禁言时间
int SendinGroup=5000;//群发延迟，单位是毫秒(ms)
String CardDisplay="[闪照]";//卡片显示内容
String PicDisplay="[QQ红包]恭喜发财";//图转卡显示内容
int ATF=10;//艾特我禁言时间，单位是分
int 自身撤回=30;//自身撤回时间
String 菜单头="————冷雨𝒥𝒶𝓋𝒶————";//修改菜单头
String 菜单尾="————欢迎使用————";//修改菜单尾
//更新完记得重新加载本脚本，否则无效！(重点！！！)
int aiForbidden=getInt(MyUin,"管家艾特禁言",0);//被Q群管家艾特是否禁言
int atbotshut=1;//被Q群管家艾特禁言时间(分)
String Colour="随机";
//图片模式的字体颜色可填：红色、黑色、蓝色、蓝绿、白灰、灰色、绿色、深灰、洋红、透明、白色、黄色、随机
String Backgroundcolor="#FFFFFFFF";//图片模式的背景色，采用RGB十六进制色码
String PictureDisplay="[闪照]";//图片外显
String key="2iOiHwTr6oS76KTufMw0xAWoXX";//去https://api.caonm.net免费注册获取key，别用我的key！！！
String headline="冷雨Java";//图转卡大标题
String Subtitle="图转卡";//图转卡小标题