public void 消息切换(Object msg){
    String t=msg.MessageContent,qq=msg.UserUin,qun=msg.GroupUin;
    if(!qq.equals(MyUin))return;
    if(t.matches("切换(文字|图片|卡片)(模式|消息)")){
        String mod=匹配("切换(文字|图片|卡片)(模式|消息)",t,1);
        模式.set(E,"模式",mod);
        文字(msg,"切换成功");
    }
}