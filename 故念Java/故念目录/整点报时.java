keyValueSys zdbs = new keyValueSys(RootPath+"故念目录/整点报时");
new Thread(new Runnable(){
        public void run(){
            while(true){
                String d = new Date().toString();
                if(d.split(" ")[3].split(":")[1].equals("00")&&d.split(" ")[3].split(":")[2].equals("00")){
                    for(File f:new File(RootPath+"故念目录/整点报时").listFiles()){
                    	String i = f.getPath().split("/")[f.getPath().split("/").length-1].replace(".txt","");
                        if(zdbs.get(new String[]{i},"开").equals("1")){
                            发送(i,"","整点啦！"+d.split(" ")[3]+"\r————————————\r"+文案());
                            sendVoice(i,"",RootPath+"故念目录/music/"+rand(0,14)+".mp3");
                        }
                    }Thread.sleep(rand(100,1000)*10);
                }
            }
        }
}).start();
public void 整点报时(Object msg){
    String t = msg.MessageContent;
    if(t.equals("开启整点报时")){
    	zdbs.set(new String[]{msg.GroupUin},"开","1");
    	发送(msg.GroupUin,"","好嘞，已开启");
    }if(t.equals("关闭整点报时")){
    	zdbs.set(new String[]{msg.GroupUin},"开","0");
    	发送(msg.GroupUin,"","好嘞，已关闭");
    }if(t.equals("测试整点报时")){
        String d = new Date().toString();
    	发送(msg.GroupUin,"","整点啦！"+d.split(" ")[3]+"\r————————————\r"+文案());
        sendVoice(msg.GroupUin,"",RootPath+"故念目录/music/"+rand(0,6)+".mp3");
    }
}