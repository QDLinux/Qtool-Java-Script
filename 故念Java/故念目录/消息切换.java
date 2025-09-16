public void 消息切换(Object msg){
    String qun = msg.GroupUin,t = msg.MessageContent;
    if(t.matches("切换(普通|图片|卡片)消息")){
        String mod = 匹配("切换(普通|图片|卡片)消息",t,1);
        globals.set(new String[]{"模式"},"消息",mod.equals("图片")?"1":(mod.equals("卡片")?"2":"3"));
        发送(qun,"","切换成功！");
    }
}