String lfmm="————林枫妹妹————";//版权信息，更改或删除会导致脚本失效
String xlfmm="——林枫妹妹——";//版权信息，更改或删除会导致脚本失效
String gzs="2511407204";
String lf="2763942871";//版权QQ，更改或删除会导致脚本失效
String lfxh="1022286783";//版权QQ，更改或删除会导致脚本失效
String gzszs="郭子生你扣屁6";
//String gfqhm="817693974";
String cd ="——林枫妹妹——\n点赞功能  文案功能\n估价功能  查询功能\n听歌时长  图片功能\n清屏功能  作图功能\n点歌功能  天气功能\n身份功能  检测功能\n测速功能  头衔功能\n  IP功能      Ai 功能\nAPI 功能  解密功能\n卡屏功能  运行状态";
//String cd="————林枫妹妹————\n赞我\n赞你\n一言\n骚话\n毒鸡汤\n舔狗文案\n伤感文案\nQ Q估价\n查Q+QQ号\n估价+QQ号\n刷听歌时长\n发送“加群”了解更多\n使用前请确保开关已打开";
String  tgsc="林枫已为您刷了24小时的听歌时长，点击此处查看排行榜:https://y.qq.com/m/client/vipexchange/index.html";
String gfq="坤坤真爱粉交流群:783317274";
AddItem("发送开机即可解锁玩法\n-发送开启+功能名即可开启功能", "提示", PluginID);

public void 菜单(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
           if(uin.equals(MyUin)||uin.equals(lf)||uin.equals(lfxh))
      {
             if ("kaiji".equals(getString(qun, "开关"))){
        if (quntext.equals("加群"))
       {
       sendMsg(qun, "",lfmm+"\n"+gfq); 
       }
       if (quntext.equals("菜单"))
       {
       sendMsg(qun, "",cd);
       }
       if (quntext.equals("点赞功能"))
       {
       sendMsg(qun,"",xlfmm+"\n"+"赞我\n赞你");
       }
       if (quntext.equals("文案功能"))
       {
       sendMsg(qun,"",xlfmm+"\n"+"一言\n骚话\n伤感文案\n舔狗文案\n涩涩语录\n动漫语录\n励志语录\n早安语录\n晚安语录\n文学语录\n失恋语录\n土味情话\n土豆情话\n随机骚话\n趣味笑话\n骂人语录\n网易云热评\n十宗罪语录\n长型伤感文案");
       }
       if (quntext.equals("估价功能"))
       {
       sendMsg(qun,"",xlfmm+"\n"+"QQ估价\n估Q+QQ号");
       }
       if (quntext.equals("查询功能"))
       {
       sendMsg(qun,"",xlfmm+"\n"+"查Q+QQ号");
       }
       if (quntext.equals("听歌时长"))
       {
       sendMsg(qun,"",xlfmm+"\n"+"刷听歌时长");
       }
       if (quntext.equals("图片功能"))
       {
       sendMsg(qun,"",xlfmm+"\n"+"JK图\nCOS图\n看美腿\n诱惑图\n风景图\n汽车图\n猫娘图\n原神图\n滑稽表情\n猫猫表情\n二次元图\n二次元头像\n二次元猫娘图");
       } 
       if (quntext.equals("作图功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+" 凯蒂猫@  随机颜色@  走路@  进群协议@  女装协议@  没涩图看了@  一顿乱亲@  按钮@  收下哥的花@  寄@  换脸@  okk@  求婚@  群最帅@  滚@  我儿子@  我直接拒绝@  我女儿@  我老婆@  我要黑化@  耍帅@  广告牌@  我好脆弱啊@  本公主让着你@  给你来一下@  坤投球@  变魔术@  圈钱愉快@  罗小黑@  要钱钱@  什么东东@烧火@  舔冰淇淋@  绿帽子@  勾引@  入群宣誓@  美女举牌@  帅哥举牌@  坤坤police@  注意身份@  托马斯回旋@  蹭大腿@  我直接就是一脚@  紫砂了@  诈尸@  踢足球@  撸管冠军@  男同@  陪睡券  画画@  麻豆演员@  大佬关注了你@  大佬关注了你@  发生了什么@  发生了什么@ 原神启动@  原神启动@  安全感@  安全感@  麻豆摄影师@  麻豆摄影师@  榨精卡@  榨精卡@  坤巴卡@  坤巴卡@  涩涩卡@  涩涩卡@  没有什么是完美的@  没有什么是完美的@  骗子@  骗子@  啊@  啊@  床上@  床上@  本群沙雕@  本群沙雕@  GKD卡@ 卧倒@ 毒瘾发作@ 基友证@ 高富帅证@ 白富美证@ 订婚证@ 首富证@ 帅哥证@ 美女证@ 屌丝证@ 仙女证@ 光棍证@ 女子汉证@ 好老公好老婆@ 泡妞证@ 处男证@ 背刺@ 美女电视@ 求婚@ 啾啾@ 感动@ 高质量@ 咸鱼@ 摸脑袋@ 膜拜@ 想看@ 咬@ 捣@ 吃掉@ 玩@ 拍@ 撕@ 可莉吃@ 爬开@ 丢@ 点赞@ 想@ 相思@ 看电视@ 这是我的人@ 美女拿手机@ 从删库到跑路@ 美女看电视@ 美女抬@ 没钱很难办事啊@ 美女拿@ 看戏@ 拍屎你个憨批@ 无所谓看蛋了@ 举@ 快溜@ 怒@ 滑稽捶@ 突然露脸@ 不想上学@ 毛毛虫咬@ 心碎碎@ 中国地图@ 滚出QQ@ 单身狗证@ 亲@ 抱着哭@ 我好羡慕@ 牵@ 警察证@ 小黑子拍篮球@ 好评@ 差评@ 我是萌新@ 我tm直接教你做事@ 甘雨爱心@ 需要@ 捶@ 听音乐@ 掀墙纸@ 胡桃咬@ 啃@ 吃@ 屏幕@ 推雪球@ 无法加载@ 顶@ 贴贴@ 踹@ 老实点@ 赞@ 想2@ 要亲亲@ 动态爬@ 击剑@ 宝可梦@ 可爱@ 为什么艾特@ 舔狗日记@ 画家@ 蒙娜丽莎@ 随心@ 妻子@ 可达鸭@ 拳击@ 精神涣散@ 寻狗启事@ 搬砖@ 摩擦@ 不幸@ 警官证@ 猎手@ 没业务@ 坤斗罗@ 蔡徐坤@\n不能用就是接口🐔了");
       }
       if (quntext.equals("敬请期待"))
       {
       sendMsg(qun,"",lfmm+"\n"+"都说了敬请期待了，你急勾巴？");
       }
       if (quntext.equals("清屏功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"清屏\n爱腾讯");
       }
       
       if (quntext.equals("天气功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"天气查询+地区");
       }
       if (quntext.equals("头衔功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"林枫在画饼呢，什么时候写就不知道了");
       }
       if (quntext.equals("身份功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"随机信息\n随机网易小号\n随机身份证图片"+"\n\n"+"注:由API提供 与林枫本人没关系");
       }
       if (quntext.equals("检测功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"QQ检测\nQQ检测+QQ号");
       }
       if (quntext.equals("测速功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"ping+网址");
       }
       if (quntext.equals("IP功能")||quntext.equals("ip功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"IP信息+IP地址");
       }
       if (quntext.equals("ai功能")||quntext.equals("Ai功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"GPT+问题\n小爱同学+问题\n问+问题(人工智障)\n夸克AI+名词(例如水果名)");
       }
       if (quntext.equals("API功能")||quntext.equals("api功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"神回复\n挑战古诗\n人口时钟\n历史今天\n涩涩小说\n测名字+名字");
       }
       if (quntext.equals("解密功能")||quntext.equals("加密功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"u加+字符(uincode加密)\nu解+uincode(uincode解密)\nb加+字符(base64加密)\nb解+base64(base64解密)\ny解+加密代码(例:ÁÍÍÉ)\nCT解+加密代码(例:剽瘞)\n萌新解+加密代码(例:㟐㟎㟔)");
       }
       if (quntext.equals("查询次数"))
       {
       String cxcs=get("http://api.311i.cn/api/tj.php?name=林枫开机&a=2");
       sendMsg(qun,"",lfmm+"\n"+"林枫Java开机次数"+"\n"+cxcs);
       }
       if (quntext.equals("点歌功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"点歌+歌名\n网易点歌+歌名\n网易云点歌+歌名");
       }
       if (quntext.equals("卡屏功能"))
       {
       sendMsg(qun,"",lfmm+"\n"+"林枫\n大家好\n提示:大概率卡不到人");
       }
       if (quntext.equals("开启点赞功能"))
       {
       putString(qun, "点赞功能", "1");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启点赞功能");
       }
       if (quntext.equals("关闭点赞功能"))
       {
       putString(qun, "点赞功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭点赞功能");
       }
       if (quntext.equals("开启听歌时长"))
       {
       putString(qun, "刷听歌时长", "2");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启听歌时长");
       }
       if (quntext.equals("关闭听歌时长"))
       {
       putString(qun, "刷听歌时长", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭听歌时长");
       }
       if (quntext.equals("开启估价功能"))
       {
       putString(qun, "QQ估价", "3");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启估价功能");
       }
       if (quntext.equals("关闭估价功能"))
       {
       putString(qun, "QQ估价", null);
       sendMsg(qun,"",lfmm+"\n"+"本群关闭估价功能");
       }
       if (quntext.equals("开启查询功能"))
       {
       putString(qun, "查Q", "4");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启查询功能");
       }
       if (quntext.equals("关闭查询功能"))
       {
       putString(qun, "查Q", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭查询功能");
       }
       if (quntext.equals("开启文案功能"))
       {
       putString(qun, "文案功能", "5");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启文案功能");
       }
       if (quntext.equals("关闭文案功能"))
       {
       putString(qun, "文案功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭文案功能功能");
       }
       if (quntext.equals("开启图片功能"))
       {
       putString(qun, "图片功能", "6");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启图片功能");
       }
       if (quntext.equals("关闭图片功能"))
       {
       putString(qun, "图片功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭图片功能");
       }
       if (quntext.equals("开启清屏功能"))
       {
       putString(qun, "清屏功能", "7");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启清屏功能");
       }
       if (quntext.equals("关闭清屏功能"))
       {
       putString(qun, "清屏功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭清屏功能");
       }
       if (quntext.equals("开启作图功能"))
       {
       putString(qun, "作图功能", "8");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启作图功能");
       }
       if (quntext.equals("关闭作图功能"))
       {
       putString(qun, "作图功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭作图功能");
       }
       if (quntext.equals("开启天气功能"))
       {
       putString(qun, "天气功能", "9");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启天气功能");
       }
       if (quntext.equals("关闭天气功能"))
       {
       putString(qun, "天气功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭天气功能");
       }
       if (quntext.equals("开启身份功能"))
       {
       putString(qun, "身份功能", "11");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启身份功能");
       }
       if (quntext.equals("关闭身份功能"))
       {
       putString(qun, "身份功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭身份功能功能");
       }
       if (quntext.equals("开启检测功能"))
       {
       putString(qun, "检测功能", "12");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启检测功能");
       }
       if (quntext.equals("关闭检测功能"))
       {
       putString(qun, "检测功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭检测功能");
       }
       if (quntext.equals("开启测速功能"))
       {
       putString(qun, "测速功能", "13");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启测速功能");
       }
       if (quntext.equals("关闭测速功能"))
       {
       putString(qun, "测试功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭测速功能");
       }
       if (quntext.equals("开启IP功能")||quntext.equals("开启ip功能"))
       {
       putString(qun, "IP功能", "14");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启IP功能");
       }
       if (quntext.equals("关闭IP功能")||quntext.equals("关闭ip功能"))
       {
       putString(qun, "IP功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭IP功能");
       }
       if (quntext.equals("开启ai功能")||quntext.equals("开启AI功能"))
       {
       putString(qun, "gpt功能", "15");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启AI功能");
       }
       if (quntext.equals("关闭ai功能")||quntext.equals("关闭AI功能"))
       {
       putString(qun, "gpt功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭AI功能");
       }
       if (quntext.equals("开启API功能")||quntext.equals("开启api功能"))
       {
       putString(qun, "API功能", "15");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启API功能");
       }
       if (quntext.equals("关闭API功能")||quntext.equals("关闭api功能"))
       {
       putString(qun, "API功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭API功能");
       }
       if (quntext.equals("开启点歌功能")||quntext.equals("开启点歌"))
       {
       putString(qun, "点歌功能", "16");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启点歌功能");
       }
       if (quntext.equals("关闭点歌功能")||quntext.equals("关闭点歌"))
       {
       putString(qun, "点歌功能", null);
       sendMsg(qun,"",lfmm+"\n"+"本群已关闭点歌功能");
       }
       if(quntext.equals("开启解密功能")||quntext.equals("开启加密功能"))
       {
       putString(qun, "解密功能", "17");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启解密功能");
       }
      if(quntext.equals("关闭解密功能")||quntext.equals("关闭加密功能")) 
      {
      putString(qun, "解密功能", null);
      sendMsg(qun,"",lfmm+"\n"+"本群已关闭解密功能");
      }
       if(quntext.equals("开启卡屏功能"))
       {
       putString(qun, "卡屏功能", "18");
       sendMsg(qun,"",lfmm+"\n"+"本群已开启卡屏功能");
       }
      if(quntext.equals("关闭卡屏功能"))
      {
      putString(qun, "卡屏功能", null);
      sendMsg(qun,"",lfmm+"\n"+"本群已关闭卡屏功能");
      }      
       }
       }
       }
       