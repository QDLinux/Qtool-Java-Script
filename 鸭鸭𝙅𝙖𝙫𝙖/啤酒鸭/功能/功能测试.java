public void 功能测试(Object msg,String mc,String mg,String mu,String mn,long mt){
    if(mu.equals(mQQ)){
        if(mc.startsWith("进群测试")){
            String qq=null;
            qq=mc.substring(4);
            if(qq.length()<5||10<qq.length())qq=mQQ;
            OnTroopEvent(mg,qq,2);
        }if(mc.startsWith("退群测试")){
            String qq=null;
            qq=mc.substring(4);
            if(qq.length()<5||10<qq.length())qq=mQQ;
            OnTroopEvent(mg,qq,1);
        }/* if(mc.startsWith("窥屏")){
            new Thread(new Runnable(){
                public void run(){
                    try{
                        String sj=mg+"b"+(int)(1000+Math.random()*9999);
                        String a="<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><msg serviceID=\"14\" templateID=\"1\" action=\"plugin\" actionData=\"AppCmd://OpenContactInfo/?uin=2354452553\" a_actionData=\"mqqapi://card/show_pslcard?src_type=internal&amp;source=sharecard&amp;version=1&amp;uin=\" i_actionData=\"mqqapi://card/show_pslcard?src_type=internal&amp;source=sharecard&amp;version=1&amp;uin=\" brief=\"推荐了\" sourceMsgId=\"0\" url=\"\" flag=\"1\" adverSign=\"0\" multiMsgFlag=\"0\"><item layout=\"0\" mode=\"1\" advertiser_id=\"0\" aid=\"0\"><summary>推荐联系人</summary><hr hidden=\"false\" style=\"0\" /></item><item layout=\"2\" mode=\"1\" advertiser_id=\"0\" aid=\"0\"><picture cover=\"http://lkaa.top/API/kuiping/api.php?a="+sj+"&amp;type=1\" w=\"0\" h=\"0\" /><title>窥屏检测</title><summary>检测中，请等待5秒钟</summary></item><source name=\"\" icon=\"\" action=\"\" appid=\"-1\" /></msg>";
                        卡片(msg,a);
                        Thread.sleep(5000);
                        文字(msg,http.get("http://lkaa.top/API/kuiping/api.php?a="+sj));
                    }catch(Throwable e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }*/
    }
}
