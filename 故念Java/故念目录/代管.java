public void 代管(Object msg){
    String t = msg.MessageContent;
    if(t.startsWith("设置代管@")){
        代管.setKeyValue(new String[]{msg.GroupUin},msg.AtList[0],"1");
        发送(msg.GroupUin,"","代管已设置");
    }if(t.startsWith("取消代管@")){
        代管.setKeyValue(new String[]{msg.GroupUin},msg.AtList[0],"0");
        发送(msg.GroupUin,"","代管已取消");
    }
}