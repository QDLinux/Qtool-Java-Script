int dgwjc=1;
int listnum=10;
int autoset=0;
int listtype=1;
String LoginUin=MyUin;
if(取("点歌","dgwjc")==null)
{
dgwjc=2;
}
if(取("点歌","dglbsz")==null)
{}else{
listnum=Integer.parseInt(取("点歌","dglbsz"));
}
if(取("点歌","xglbsz")==null)
{}else{
autoset=Integer.parseInt(取("点歌","xglbsz"));
}
if(取("点歌","dglbgs")==null)
{}else{
listtype=Integer.parseInt(取("点歌","dglbgs"));
}
if(取("点歌","dlqqyy")==null)
{}else{
LoginUin=取("点歌","dlqqyy");
}
String wjcjy="";
String wjcch="";
String wjctc="";
String keyuin="";
String json3="";
String w="";
String n="";
String p="";
String qq="";
String h="";
String mz="";
String nr="";
String c="";
String QQ="";
String xz="";
String qx="";
String xz="";
String tp="";
String jc="";
String tx="";
String yl="";
String iii="";
String jyyzsj="";
String jqyzsj="";
String yztc="";
String yzjy="";
String jqyz="";
String json="";
String atjc="";
String zsjc="";
String zsjcjy="";
String zsjcch="";
String zsjctc="";
String zsjcjysj="";
String zsjczs="";
String zsjczkg="";
String zkg1="";
String wjcjysj="";
String wjcjya="";
String cyjl="";
String tpjykg="";
String tpjyq="";
String piao="";
String shijian="";
String jlqq="";
String tpqun="";
String dgkg="";
String cjkg="";
String SDY="";
String sljj2="";
String qhmd="";
String smgn="";
String black2="";
String athfwz="";
String athftplj="";
String athfyylj="";
String athftp="";
String athfyy="";
String athfjy="";
String athfkg="";
String kl="1";
int piao2=0;
public void 清空(){
piao2=0;
tpjyq="";
piao="";
shijian="";
}
String xhsf2="";
String 小号收费取消="";
String 进群验证取消="";
public void kgsz2(String qun)
{
if(取(qun,"wjcjysj")==null){wjcjysj="10";}else{wjcjysj=取(qun,"wjcjysj");}
if(取(qun,"kg")==null){zkg1="×";}else{zkg1="✓";}
if(取(qun,"jc")==null){jc="×";}else{jc="✓";}
if(取(qun,"zskg")==null){zsjc="×";}else{zsjc="✓";}
if(取(qun,"xz")==null){yl="×";}else{yl="✓";}
if(取(qun,"tp")==null){tp="×";}else{tp="✓";}
if(取(qun,"tx")==null){tx="×";}else{tx="✓";}
if(取(qun,"wjcjy")==null){wjcjy="×";}else{wjcjy="✓";}
if(取(qun,"wjcch")==null){wjcch="×";}else{wjcch="✓";}
if(取(qun,"wjctc")==null){wjctc="×";}else{wjctc="✓";}
if(取(qun,"jqyz")==null){jqyz="×";}else{jqyz="✓";}
if(取(qun,"xhsf")==null){xhsf2="×";}else{xhsf2="✓";}
if(取(qun,"jqyzsj")==null){jqyzsj="43200";}else{jqyzsj=取(qun,"jqyzsj");}
if(取(qun,"cjxt")==null){cjkg="×";}else{cjkg="✓";}
if(取(qun,"sljj")==null){sljj2="×";}else{sljj2="✓";}
if(取(qun,"扫码")==null){smgn="×";}else{smgn="✓";}
}