public void zl_群管(Object msg,String mc,String mg,String mu,String mn,String[] at){
    if(Lshost.contains(mu)){
        if(mc.equals("开启群管")){
            if(开关.读("群管",mg)==1){
                toast(repeat_+"群管",1500);
            }else{
                开关.写("群管",mg,1);
                toast(repeat_t+"群管",1500);
            }
        }if(mc.equals("关闭群管")){
            if(开关.读("群管",mg)==0){
                toast(_repeat+"群管",1500);
            }else{
                开关.写("群管",mg,0);
                toast(t_repeat+"群管",1500);
            }
        }if(开关.读("群管",mg)==0)return;
        if(mc.startsWith("禁言@")){
            int x=mc.lastIndexOf(" ");
            String ge=mc.substring(x+1);
            long time = FormTimeToSecond(ge);
            String qq= "";
            for(String uin: at){
                禁言(mg,uin,time);
                qq +="\n"+uin;
            }send(mg,"","账号："+qq+"\n禁言时长：\n"+secondToTime(time),1);
        }if(mc.startsWith("解禁")){
            String qq="";
            String[] At;
            if(mc.contains("@")){
                At=at;
            }else{
                At=mc.substring(2).split(" ");
            }for(String uin: At){
                解禁(mg,uin);
                qq+="\n"+uin;
            }send(mg,"","账号："+qq+"\n已解除禁言",1);
        }if(mc.startsWith("踢出")){
            String qq="";
            String[] At;
            if(mc.contains("@")){
                At=at;
            }else{
                At=mc.substring(2).split(" ");
            }for(String uin: At){
                踢出(mg,uin);
                qq+="\n"+uin;
            }send(mg,"","账号："+qq+"\n已移出群聊",1);
        }if(mc.startsWith("拉黑")){
            String qq="";
            String[] At;
            if(mc.contains("@")){
                At=at;
            }else{
                At=mc.substring(2).split(" ");
            }for(String uin: At){
                拉黑(mg,uin);
                qq+="\n"+uin;
            }send(mg,"","账号："+qq+"\n成功拉黑",1);
        }if(mc.equals("全体禁言")){
            全体禁言(mg);
        }if(mc.equals("全体解禁")){
            全体解禁(mg);
        }if(mc.startsWith("全禁")){
            if(mc.length()==2){
                long time = FormTimeToSecond("");
                for(Object qun:getGroupMemberList(mg)){
                    禁言(mg,qun.UserUin,time);
                    Thread.sleep(10);
                }
            }else{
                String ge=mc.substring(2);
                long time = FormTimeToSecond(ge);
                for(Object qun:getGroupMemberList(mg)){
                    禁言(mg,qun.UserUin,time);
                    Thread.sleep(10);
                }
            }
        }if(mc.equals("全解")){
            for(Object qun:getGroupMemberList(mg)){
                解禁(mg,qun.UserUin);
                Thread.sleep(10);
            }
        }if(mc.startsWith("设置管理")){
            String qq="";
            String[] At;
            String ti="";
            if(mc.contains("@")){
                At=at;
            }else{
                At=mc.substring(2).split(" ");
            }for(String uin: At){
                ti=setadmin(mg,uin,1);
                qq+="\n"+uin+ti;
            }send(mg,"","结果"+qq,1);
        }if(mc.startsWith("取消管理")){
            String qq="";
            String[] At;
            String ti="";
            if(mc.contains("@")){
                At=at;
            }else{
                At=mc.substring(2).split(" ");
            }for(String uin: At){
                ti=setadmin(mg,uin,0);
                qq+="\n"+uin+ti;
            }send(mg,"","结果"+qq,1);
        }if(mc.startsWith("设置头衔@")||mc.startsWith("修改头衔@")){
            String qq="";
            String name=mc.substring(mc.lastIndexOf(" ")+1);
            if(name.equals("")){
                send(mg,"","请后续输入名称",1);
            }for(String uin: at){
                群头衔(mg,uin,name);
                qq+="\n"+uin;
            }send(mg,"","账号"+qq+"\n头衔已修改",1);
        }if(mc.startsWith("设置名片@")||mc.startsWith("修改名片@")){
            String qq="";
            int k=mc.lastIndexOf(" ")+1;
            String name=mc.substring(k);
            for(String uin: at){
                群名片(mg,uin,name);
                qq+="\n"+uin;
            }send(mg,"","账号"+qq+"\n名片已修改",1);
        }String Rootd=Root+"数据/代管/"+mg+".txt";
        if(mc.startsWith("设置代管@")||mc.startsWith("添加代管@")){
            String qq="";
            for(String uin: at){
                qq+="\n"+uin;
            }写入(MyFile.ReadFile(Rootd)+qq+"\n",Rootd);
            send(mg,"","账号"+qq+"\n成功添加为代管",1);
        }if(mc.startsWith("取消代管@")||mc.startsWith("删除代管@")){
            String qq="";
            for(String uin: at){
                写入(MyFile.ReadFile(Rootd).replace("\n"+uin,""),Rootd);
                qq+="\n"+uin;
            }send(mg,"","账号"+qq+"\n成功取消",1);
        }if(mc.equals("代管列表")||mc.equals("查看代管")){
            String qq=MyFile.ReadFile(Rootd);
            send(mg,"","代管列表:"+qq,1);
        }
    }if(Lshost.contains(mu)){
        if(mc.equals("开启自助头衔")){
            开关.写("自助头衔",mg,1);
            send(mg,"","自助(头衔/名片)已开启\n群员可以发送：\n我要(头衔/名片)+内容 获取",1);
        }if(mc.equals("关闭自助头衔")){
            开关.写("自助头衔",mg,0);
            send(mg,"","自助头衔已关闭",1);
        }
    }if(开关.读("自助头衔",mg)==1){
        if(mc.startsWith("我要头衔")){
            String tit=mc.substring(4);
            群头衔(mg,mu,tit);
        }if(mc.startsWith("我要名片")){
            String tit=mc.substring(4);
            群名片(mg,mu,tit);
        }
    }
}public void OnTroopEvent(String mg,String mu,int type){
    if(开关.读(GroF,mg)==1&&开关.读("进退群",mg)==1){
        if(type == 1&&tuiqunTS==1){
            String t1 = "退群提示" +头像(mu,2)+ "\n昵称：" +Qs.nick(mu)+ "\nQQ ：(" + mu +")" + "\n时间："+getime()+ "\n"+tuiqunmsg;
            sendMsg(mg,"",t1);
            if(tuiquntts==1){
                try{
                    String pt="/storage/emulated/0/LD_Module/Voice/鸭鸭网易云/";
                    File[] by=new File(pt).listFiles();
                    String byd=by[ new Random().nextInt(by.length)].toString();
                    群语音(mg,byd);
                }catch(e){}
            }
        }if(type == 2&&ruqunTS==1){
            String t1 = "进群提示" +	头像(mu,2)+ "\n昵称："+ Qs.nick(mu)+ "\nQ Q：(" + mu +")" + "\n时间："+getime()+ "\n"+ruqunmsg;
            sendMsg(mg,"",t1);
            if(ruquntts==1&&ruquntts!=null){
                try{
                    String pt="/storage/emulated/0/LD_Module/Voice/鸭鸭DJ/";
                    File[] by=new File(pt).listFiles();
                    String byd=by[ new Random().nextInt(by.length)].toString();
                    群语音(mg,byd);
                }catch(e){}
            }
        }
    }
}public void zl_dzJava(Object msg,String mc,String mg,String mu){
    //改写绿逗
    try{
        if(开关.读(GroF,mg)==1&&开关.读("点赞",mg)==1){
            if((mc.startsWith("赞我")||mc.startsWith("互赞"))&&!mu.equals(mQQ)){
                Calendar cl = Calendar.getInstance();
                int Day = cl.get(Calendar.DAY_OF_MONTH);
                if((""+Day).equals(getString(mu,"最后点赞"))){
                    if(!likereply.equals(""))回复(msg,likereply);
                    if(!likevoices.equals(""))语音(msg,likevoices);
                }else{
                    点赞(mu,20);
                    putString(mu,"最后点赞",""+Day);
                    if(!likereplys.equals(""))回复(msg,likereplys);
                    if(!likevoice.equals(""))语音(msg,likevoice);
                }
            }
        }
    }catch(e){}
}public long FormTime(String TextTime){
    if(TextTime.contains("秒")){
        long time = Long.parseLong(TextTime.replaceAll("\\D",""));
        return time;
    }if(TextTime.contains("分")){
        long time = Long.parseLong(TextTime.replaceAll("\\D",""))* 60;
        return time;
    }if(TextTime.contains("时")){
        long time = Long.parseLong(TextTime.replaceAll("\\D",""))* 60 * 60;
        return time;
    }if(TextTime.contains("天")|| TextTime.contains("日")){
        long time = Long.parseLong(TextTime.replaceAll("\\D",""))* 60 * 60 * 24;
        return time;
    }if(TextTime.replaceAll("\\D","").isEmpty()){
        return(long)(Math.random()* 30 + 1)*60;
    }long time = Long.parseLong(TextTime.replaceAll("\\D",""));
    if(time == 0){
        return(long)(Math.random()* 30 + 1)* 60;
    }else{
        return time * 60;
    }
}public long FormTimeToSecond(String TextTime){
    if(TextTime.contains("秒")){
        long time = Long.parseLong(TextTime.replaceAll("\\D",""));
        return time;
    }if(TextTime.contains("分")){
        long time = Long.parseLong(TextTime.replaceAll("\\D",""))* 60;
        return time;
    }if(TextTime.contains("时")){
        long time = Long.parseLong(TextTime.replaceAll("\\D",""))* 60 * 60;
        return time;
    }if(TextTime.contains("天")|| TextTime.contains("日")){
        long time = Long.parseLong(TextTime.replaceAll("\\D",""))* 60 * 60 * 24;
        return time;
    }if(TextTime.replaceAll("\\D","").isEmpty()){
        return(long)(Math.random()* 29 + 1)* 360 * 24;
    }long time = Long.parseLong(TextTime.replaceAll("\\D",""));
    if(time == 0){
        return(long)(Math.random()*(24 * 30)* 60);
    }else{
        return time * 60;
    }
}public String secondToTime(long second){
    if(second == 0)return "0秒";
    long days = second / 86400;
    second = second % 86400;
    long hours = second / 3600;
    second = second % 3600;
    long minutes = second / 60;
    second = second % 60;
    return(days == 0 ? "" : days + "天")+(hours == 0 ? "" : hours + "小时")+(minutes == 0 ? "" : minutes + "分")+(second == 0 ? "" : second + "秒");
}public long GetBkn(String skey){
    int hash = 5381;
    for (int i = 0, len = skey.length();i < len;i++)hash +=(hash << 5)+(int)(char)skey.charAt(i);
    return hash & 2147483647;
}public String setadmin(String qun,String qq,int type){
    //卑微萌新
    try{
        String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+Pskey_qun;
        String put="gc="+qun+"&ul="+qq+"&op="+type+"&bkn="+GetBkn(getSkey());
        JSONObject json = new JSONObject(httppost("https://qun.qq.com/cgi-bin/qun_mgr/set_group_admin",cookie,put));
        int ec=json.get("ec");
        String em=json.get("em");
        if(ec==0)return "操作成功";
        else if(ec==13)	return "管理已满";
        else return "操作失败";
    }catch(Exception e){
        return "操作失败";
    }
}
