public void 限制(Object msg){
    String t = msg.MessageContent;
    if(t.equals("限制点歌")){
        限制.setKeyValue(new String[]{msg.GroupUin},"点歌","1");
        发送(msg.GroupUin,"","限制已开启");
    }if(t.equals("开放点歌")){
        限制.setKeyValue(new String[]{msg.GroupUin},"点歌","0");
        发送(msg.GroupUin,"","限制已关闭");
    }
}