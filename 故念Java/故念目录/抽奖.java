int 禁言卡=5;
int 解禁卡=7;
int 禁言=15;
int 免禁卡=7;
int 收回禁言卡=8;
int 任意卡=1;
int 撤回卡=17;
int n=100;


int[] p = {禁言卡,解禁卡,禁言,免禁卡,收回禁言卡,任意卡,撤回卡};
keyValueSys 抽奖=new keyValueSys(RootPath+"故念目录/抽奖");
public boolean 概率(int n,n2){
    int p = rand(1,n2);
    return p<=n;
}public int[][] sort(int[] a){
    int[] index = new int[a.length];
    index[0]=0;
    for(int i = 1;i < a.length;i++){
        index[i]=index[i-1]+1;
    }boolean f=true;
    int x,y;
    for(int i = 0;i < a.length-1;i++){
        for(int j = 0;j < a.length-1-i;j++){
            if(a[j]>a[j+1]){
                x=a[j];
                a[j]=a[j+1];
                a[j+1]=x;
                y=index[j];
                index[j]=index[j+1];
                index[j+1]=y;
                f=false;
            }
        }if(f)return new int[][]{a,index};
        f=true;
    }return new int[][]{a,index};
}public int 概率抽选(int[] p,int n){
    int[][] newP=sort(p);
    for(int i = p.length-1;i >= 0;i--){
        if(概率(newP[0][i],n))return newP[1][i];
    }return -1;
}public void 加卡(String 卡,qun,qq,n){
    抽奖.set(new String[]{qun,qq},卡,(抽奖.get(new String[]{qun,qq},卡).isEmpty()?""+n:""+(Integer.parseInt(抽奖.get(new String[]{qun,qq},卡))+n)));
}public void 减卡(String 卡,qun,qq,n){
    抽奖.set(new String[]{qun,qq},卡,(抽奖.get(new String[]{qun,qq},卡).isEmpty()?"0":""+(Math.max(0,Integer.parseInt(抽奖.get(new String[]{qun,qq},卡))-n))));
}public int 取卡(String 卡,qun,qq){
    return Integer.parseInt(抽奖.get(new String[]{qun,qq},卡).isEmpty()?"0":抽奖.get(new String[]{qun,qq},卡));
}public void 抽奖(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    if(t.equals("抽奖")&&抽奖.get(new String[]{qun,"开关"},"开").equals("1")){
        switch(概率抽选(p,n)){
            case 0:
                加卡("禁言卡",qun,qq,1);
                发送(qun,"","[AtQQ="+qq+"]你抽到了禁言卡，当前禁言卡"+取卡("禁言卡",qun,qq)+"张");
                break;
            case 1:
                加卡("解禁卡",qun,qq,1);
                发送(qun,"","[AtQQ="+qq+"]你抽到了解禁卡，当前解禁卡"+取卡("解禁卡",qun,qq)+"张");
                break;
            case 2:
                ForBidden(qun,qq,rand(1,1200));
                发送(qun,"","[AtQQ="+qq+"]你抽到了禁言！");
                break;
            case 3:
                加卡("免禁卡",qun,qq,1);
                发送(qun,"","[AtQQ="+qq+"]你抽到了免禁卡，当前免禁卡"+取卡("免禁卡",qun,qq)+"张");
                break;
            case 4:
                减卡("禁言卡",qun,qq,1);
                发送(qun,"","[AtQQ="+qq+"]你被收回了禁言卡，当前禁言卡"+取卡("禁言卡",qun,qq)+"张");
                break;
            case 5:
                加卡("任意卡",qun,qq,1);
                发送(qun,"","[AtQQ="+qq+"]你抽到了任意卡，任意卡可以转换成任何其他的卡，当前任意卡"+取卡("任意卡",qun,qq)+"张");
                break;
            case 6:
                加卡("撤回卡",qun,qq,1);
                发送(qun,"","[AtQQ="+qq+"]你抽到了撤回卡，当前撤回卡"+取卡("撤回卡",qun,qq)+"张");
                break;
            default:
                发送(qun,"","[AtQQ="+qq+"]你什么也没抽到");
        }
    }
}public void 使用卡(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    if(!抽奖.get(new String[]{qun,"开关"},"开").equals("1"))return;
    if(t.startsWith("查看卡@")){
        发送(qun,"","[AtQQ="+qq+"]\n"+msg.AtList[0]+"信息如下：\n禁言卡："+取卡("禁言卡",qun,msg.AtList[0])+"\n解禁卡："+取卡("解禁卡",qun,msg.AtList[0])+"\n免禁卡："+取卡("免禁卡",qun,msg.AtList[0])+"\n撤回卡："+取卡("撤回卡",qun,msg.AtList[0])+"\n任意卡："+取卡("任意卡",qun,msg.AtList[0]));
    }if(isJavaOp(qun,qq))return;
    if(t.startsWith("禁言@")){
        if(取卡("禁言卡",qun,qq)<=0){
            发送(qun,"","[AtQQ="+qq+"]你的卡还不够哦！");
            return;
        }减卡("禁言卡",qun,qq,1);
        if(取卡("免禁卡",qun,qq)>0){
            减卡("免禁卡",qun,qq,1);
            发送(qun,"","[AtQQ="+qq+"]对方用一张免禁卡抵消了你的禁言卡");
            return;
        }ForBidden(qun,msg.AtList[0],rand(1,120));
        发送(qun,"","[AtQQ="+qq+"]禁言成功");
    }if(t.startsWith("解禁@")){
        if(取卡("解禁卡",qun,qq)<=0){
            发送(qun,"","[AtQQ="+qq+"]你的卡还不够哦！");
            return;
        }ForBidden(qun,msg.AtList[0],0);
        发送(qun,"","[AtQQ="+qq+"]解禁成功");
    }if(t.equals("撤回")){
        if(取源(msg)!=null){
            if(取卡("撤回卡",qun,qq)<=0){
                发送(qun,"","[AtQQ="+qq+"]你的卡还不够哦！");
                return;
            }减卡("撤回卡",qun,qq,1);
            revokeMsg(取源(msg));
            发送(qun,"","[AtQQ="+qq+"]撤回成功");
        }
    }if(t.matches("转换[\\d]+张(禁言卡|解禁卡|免禁卡|撤回卡)")){
        int n = Integer.parseInt(t.substring(2).split("张")[0]);
        if(取卡("任意卡",qun,qq)>=n){
            减卡("任意卡",qun,qq,n);
            加卡(t.split("张")[1],qun,qq,n);
            发送(qun,"","[AtQQ="+qq+"]转换成功");
            return;
        }发送(qun,"","[AtQQ="+qq+"]任意卡张数不够");
    }
}public void 设置抽奖(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    if(t.equals("开启抽奖")){
        抽奖.set(new String[]{qun,"开关"},"开","1");
        发送(qun,"","开启成功");
    }if(t.equals("关闭抽奖")){
        抽奖.set(new String[]{qun,"开关"},"开","0");
        发送(qun,"","关闭成功");
    }if(t.matches("@[^的]+的(禁言卡|解禁卡|免禁卡|撤回卡|任意卡)\\+[\\d]+")){
        String 卡 = 匹配("@[^的]+的(禁言卡|解禁卡|免禁卡|撤回卡|任意卡)\\+[\\d]+",t,1);
        int n = Integer.parseInt(匹配("@[^的]+的(禁言卡|解禁卡|免禁卡|撤回卡|任意卡)\\+([\\d]+)",t,2));
        加卡(卡,qun,msg.AtList[0],n);
        发送(qun,"","加卡成功，"+msg.AtList[0]+"的"+卡+"数量为"+取卡(卡,qun,msg.AtList[0]));
    }if(t.matches("@[^的]+的(禁言卡|解禁卡|免禁卡|撤回卡|任意卡)-[\\d]+")){
        String 卡 = 匹配("@[^的]+的(禁言卡|解禁卡|免禁卡|撤回卡|任意卡)-[\\d]+",t,1);
        int n = Integer.parseInt(匹配("@[^的]+的(禁言卡|解禁卡|免禁卡|撤回卡|任意卡)-([\\d]+)",t,2));
        减卡(卡,qun,msg.AtList[0],n);
        发送(qun,"","减卡成功，"+msg.AtList[0]+"的"+卡+"数量为"+取卡(卡,qun,msg.AtList[0]));
    }
}public void 抽管理(Object msg){
    String t=msg.MessageContent;
    String qun=msg.GroupUin;
    String qq=msg.UserUin;
    if(t.equals("抽管理")){
        ArrayList m = getGroupMemberList(qun);
        int[] levels = new int[m.size()];
        int i = 0;
        for(Object k:m){
            if(isOp(qun,k.UserUin))levels[i]=0;
            else levels[i] = Math.max(1,k.UserLevel);
            i++;
        }int r;
        if(levels.length==0){
            发送(qun,"","没有普通群员了");
            return;
        }else if(levels.length==1)r=0;
        else while((r = 概率抽选(levels,100))==-1);
        new httpRequests("http://api.caonmtx.cn/api/qq_guanli.php?uin="+MyUin+"&skey="+(issq?getSkey():"")+"&pskey="+(issq?getPskey("qun.qq.com"):"")+"&qh="+qun+"&qq="+m.get(r).UserUin+"&msg=上管理","").get("");
        发送(qun,"","恭喜[AtQQ="+m.get(r).UserUin+"]成功上管！");
    }
}