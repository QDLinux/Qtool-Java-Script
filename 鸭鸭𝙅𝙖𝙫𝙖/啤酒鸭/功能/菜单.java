public void javamap(Object msg,String mc,String mg,String mu,String mn){
    if(Lshost.contains(mu)){
        if(mc.equals("开启菜单")){
            if(开关.读("菜单",mg)==0){
                toast(repeat_+"菜单",1500);
            }else{
                开关.写("菜单",mg,0);
                toast(repeat_t+"菜单",1500);
            }
        }if(mc.equals("关闭菜单")){
            if(开关.读("菜单",mg)==1){
                toast(_repeat+"菜单",1500);
            }else{
                开关.写("菜单",mg,1);
                toast(t_repeat+"菜单",1500);
            }
        }
    }if(开关.读("菜单",mg)==1)return;
    if(mc.equals("菜单")){
        String b="◇━菜单━◇\n" +"[e]查询系统[e]\n" +"[e]点歌菜单[e]\n" +"[e]文案菜单[e]\n" +"[e]图片菜单[e]\n" +"[e]休闲娱乐[e]\n" //         +"[e]扫码菜单[e]\n"
        +"[e]智能聊天[e]\n" +"[e]群管系统[e]\n" +"[e]开关状态[e]\n"+"[e]切换消息[e]\n" +"◇━鸭鸭━◇";
        String a="";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        //   String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/主菜单.txt");
        if(Lshost.contains(mu)){
            a = 头像(mu,2)+b.replace("[e]",e);
        }else{
            a=头像(mu,2)+b.replace("\n[e]群管系统[e]","").replace("\n[e]开关状态[e]","").replace("[e]",e);
        }文字(msg,a);
    }if(Lshost.contains(mu)){
        if(mc.startsWith("群管")&&mc.length()<5){
            String b="◇━━━群管系统━━━◇\n" +"\n" +"全体禁言 设置管理(@xx)\n" +"全体解禁 取消管理(@xx)\n" +"全禁+时长（不加则随机）\n" +"全解（解除所有被禁言者）\n" +"\n" +"设置头衔（@xx）+名称\n" +"设置名片（@xx）+名称\n" +"\n" +"禁言（@xx）+（时长）\n" +"如：禁言@张三 1分钟\n" +"解禁（@xx）或\n" +"解禁+账号（多个账号空格）\n" +"\n" +"踢出（@xx）[直接移除群聊]\n" +"踢出+账号（多个账号空格）\n" +"拉黑（@xx）[下次拒绝入群]\n" +"拉黑+账号（多个账号空格）\n" +"\n" +"◇━━━鸭鸭𝙅𝙖𝙫𝙖━━━◇";
            //  String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/群管菜单.txt");
            String a = 头像(mu,2)+b+"\n功能当前："+(开关.读("群管",mg)==0? "✨关闭🌃" : "¶可用🌈");
            文字(msg,a);
        }if(mc.equals("开关状态")){
            String a=头像(mu,2)+ "\n点歌系统 "+(开关.读("点歌",mg)==1? "✨关闭🌃" : "¶可用🌈")+ "\n查询系统 "+(开关.读("查询",mg)==0? "✨关闭🌃" : "¶可用🌈")+ "\n天气查询 "+(开关.读("天气",mg)==1? "✨关闭🌃" : "¶可用🌈")+ "\n战力查询 "+(开关.读("点歌",mg)==1? "✨关闭🌃" : "¶可用🌈")+ "\n小爱智能 "+(开关.读("小爱",mg)==1? "✨关闭🌃" : "¶可用🌈")+ "\n妲己智障 "+(开关.读("妲己",mg)==1? "✨关闭🌃" : "¶可用🌈")+ "\n文案系统 "+(开关.读("文案",mg)==1? "✨关闭🌃" : "¶可用🌈")+ "\n休闲娱乐 "+(开关.读("娱乐",mg)==1? "✨关闭🌃" : "¶可用🌈")+ "\n解析视频 "+(开关.读("视频解析",mg)==0? "✨关闭🌃" : "¶可用🌈")+ "\n群管系统 "+(开关.读("群管",mg)==0? "✨关闭🌃" : "¶可用🌈")+ "\n自助头衔 "+(开关.读("自助头衔",mg)==0? "✨关闭🌃" : "¶可用🌈")+ "\n图片系统 "+(开关.读("图片",mg)==0? "✨关闭🌃" : "¶可用🌈")+ "\n登录系统 "+(开关.读("登录",mg)==0? "✨关闭🌃" : "¶可用🌈")+ "\n进群提示 "+(开关.读("进退群",mg)==0? "✨关闭🌃" : "¶可用🌈")+ "\n点赞赞我 "+(开关.读("点赞",mg)==0? "✨关闭🌃" : "¶可用🌈")+ "\n私聊开关 "+(开关.读("私聊","开关")==0? "✨关闭🌃" : "¶可用🌈")+ "\nPS:调整发送开关设置";
            文字(msg,a);
        }
    }if(mc.equals("点歌")||mc.equals("点歌系统")||mc.equals("点歌菜单")||mc.equals("音乐系统")){
        String b="◇━━点歌系统━━◇\n" +" 𝘿𝙅点歌+歌名\n" +" 𝙌𝙌点歌+歌名\n" +" 酷我点歌+歌名\n" +" 酷狗点歌+歌名\n" +" 铃声点歌+歌名\n" +" 咪咕点歌+歌名\n" +" 𝘿𝙅 随机语音嗨曲\n" +" 网易  随机伤感曲\n" +" 网易云点歌+歌名\n" +" 点歌+歌名(直接发)\n" +" 鸡 (随机坤音乐)\n" +"◇━━鸭鸭𝙅𝙖𝙫𝙖━━◇";
        //String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/点歌菜单.txt");
        String a = 头像(mu,2)+b+"\n功能当前："+(开关.读("点歌",mg)==1? "✨关闭🌃" : "¶可用🌈");
        文字(msg,a);
    }if(mc.equals("查询系统")||mc.equals("查询菜单")||mc.equals("查询")){
        String b="◇━查询━◇\n" +"[e]社工系统[e]\n" +"[e]天气查询[e]\n" +"[e]战力查询[e]\n" +"◇━鸭鸭━◇";
        String a="";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        // String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/查询系统.txt").replace("[e]",e);
        a=头像(mu,2)+b.replace("[e]",e)+"\n功能"+(开关.读("查询",mg)==0? "✨关闭🌃" : "¶可用🌈");
        文字(msg,a);
    }if(mc.equals("社工系统")||mc.equals("社工菜单")||mc.equals("社工")){
        String b="◇━社工━◇\n" +"查Q+账号\n" +"反查+手机号\n" +"查头像+账号\n" +"查资料+账号\n" +"查电脑+账号\n" //        +"查成年+账号\n"
        //         +"查业务+账号\n"
        +"QQ估价+账号\n" +"◇━鸭鸭━◇";
        String a="";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        // String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/社工菜单.txt").replace("[e]",e);
        a=头像(mu,2)+b+"\n功能"+(开关.读("查询",mg)==0? "✨关闭🌃" : "¶可用🌈");
        文字(msg,a);
    }if(mc.equals("登录系统")||mc.equals("扫码菜单")||mc.equals("扫码")||mc.equals("登录")){
        String b="◇━━登录系统━━◇\n" +"特别关心Ħ\n" +"  (查询被多少人关心)\n" +"修改昵称ł\n" +"  (随时随地修改昵称)\n" +"我的业务ĭ\n" +"  (查看业务的保质期)\n" +"一键签到Ľ\n" +"  (大部分订阅号签到)\n" +"设置铭牌ď\n" +"  (此铭牌所有人可见)\n" +"PS：发送:申请二维码\n" +"◇━━鸭鸭𝙅𝙖𝙫𝙖━━◇";
        String a="";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        // String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/扫码菜单.txt").replace("[e]",e);
        a=头像(mu,2)+b+"\n功能"+(开关.读("登录",mg)==0? "✨关闭🌃" : "¶可用🌈");
        文字(msg,a+"\n(抢修中……)仅自己可用");
    }if(mc.equals("智能聊天")||mc.equals("智能")||mc.equals("聊天")){
        String b="◇━━智障━━◇\n" +"小爱\n" +"     (+聊天内容)\n" +"妲己\n" +"     (+王者问答)\n" +"切换聊天\n" +"◇━━聊天━━◇";
        String a="";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        // String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/智能聊天.txt").replace("[e]",e);
        String c="\n功能"+(开关.读("聊天",mg)==1? "✨关闭🌃" : "¶可用🌈");
        if(TubeArr.contains(mu)){
            a=头像(mu,2)+b+c;
        }else{
            a=头像(mu,2)+b.replace("\n切换聊天","")+c;
        }文字(msg,a);
    }if(mc.equals("天气")||mc.equals("天气查询")){
        String a = JavaName + 头像(mu,2)+ "\n发送：你的区名+天气" + "\n功能当前："+(开关.读("天气",mg)==1? "✨关闭🌃" : "¶可用🌈");
        文字(msg,a);
    }if(mc.equals("战力")||mc.equals("战力查询")){
        String a = JavaName + 头像(mu,2)+ "\n发送：王者英雄名+战力" + "\n功能当前：（维护）"+(开关.读("战力",mg)==1? "✨关闭🌃" : "¶可用🌈");
        文字(msg,a);
    }if(mc.equals("文案")||mc.equals("文案系统")||mc.equals("文案菜单")||mc.equals("词条系统")){
        String b=" ◇━文案━◇\n" +"[e]一言 情话[e]\n" +"[e]失恋 暗恋[e]\n" +"[e]伤感 遗憾[e]\n" +"[e]语录 鸡汤[e]\n" +"[e]骚话 笑话[e]\n" +"[e]答案之书 [e]\n" +" ◇━鸭鸭━◇";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        //   String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/文案菜单.txt");
        String c="\n功能"+(开关.读("文案",mg)==1? "✨关闭🌃" : "¶可用🌈");
        String a = 头像(mu,2)+b.replace("[e]",e)+c;
        文字(msg,a);
    }if(mc.equals("图片")||mc.equals("图片系统")||mc.equals("图片菜单")){
        String b="◇━━美图━━◇\n" +"[e]搜图+名称¦\n" +"[e]看涩图(Ł)\n" +"[e]风景图(横 屏)\n" +"[e]随机图(Ļª)\n" +"[e]妹子图(ĕ^)\n" +"◇━鸭鸭𝙅𝙖𝙫𝙖━◇";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        //   String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/图片系统.txt");
        String c="\n功能"+(开关.读("图片",mg)==0? "✨关闭🌃" : "¶可用🌈");
        String a = 头像(mu,2)+b.replace("[e]",e)+c;
        文字(msg,a);
    }if(mc.equals("解析")||mc.equals("解析视频")){
        String a = JavaName + 头像(mu,2)+"\n目前支持解析：" +"\n抖音,快手,皮皮虾" +"\nbilibili,小红书" +"\n直接发送分享文本即可" +msgArr("@"+mn,8)+(开关.读("视频解析",mg)==0? "✨关闭🌃" : "¶可用🌈");
        文字(msg,a);
    }if(mc.equals("头衔")||mc.equals("自助头衔")){
        String a = JavaName + 头像(mu,2)+"\n我要头衔+内容" +"\n我要名片+内容" +msgArr("@"+mn,8)+(开关.读("自助头衔",mg)==0? "✨关闭🌃" : "¶可用🌈");
        文字(msg,a);
    }if(mc.equals("休闲娱乐")||mc.equals("娱乐系统")||mc.equals("娱乐菜单")||mc.equals("娱乐")||mc.equals("休闲")){
        String b="◇━━娱乐━━◇\n" +"[e]生成英文\n" +" (如:生成英文Java)\n" +"[e]我的组成\n" +" (别测,叼毛(Ĺ))\n" +"[e]超长气泡\n" +" (SVIP身份可用)\n" +"[e]翻译+内容\n" +" (自动识别翻译)\n" +"[e]搜索影视\n" +"◇━鸭鸭𝙅𝙖𝙫𝙖━◇";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        //   String b=MyFile.ReadFile(Root+"啤酒鸭/功能/菜单/休闲娱乐.txt")
        String c= "\n功能"+(开关.读("娱乐",mg)==1? "✨关闭🌃" : "¶可用🌈");
        String a = 头像(mu,2)+b.replace("[e]",e)+c;
        文字(msg,a);
    }if(mc.equals("切换消息")){
        String a = "◇━━切换━━◇\n"+"[e]切换+文字/图片/卡片+消息\n"+"◇━鸭鸭𝙅𝙖𝙫𝙖━◇";
        String e=emojilist[new Random().nextInt(emojilist.length)];
        文字(msg,a.replace("[e]",e));
    }
}
