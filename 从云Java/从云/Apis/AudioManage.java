public void SendLing(String filepath,String qun,String qq,int type)
{
new java.lang.Thread(new Runnable()
{
public void run()
{
int i=1;
if(type==0) sendVoice(qun,qq,filepath);
else{
Toast("音频处理请稍后");
String cut=cutFile(filepath);
//Toast(cut);
if(cut.equals("错误")) {Toast("裁剪压缩出错");return ;}
else{
if(!cut.contains("/*")) sendVoice(qun,qq,cut);
else{
File file = new File(cut.replace("/*","/1"));
String[] files = file.getParentFile().list();
if(files==null) return ;
i=files.length;
//Toast(i+cut);
//if(type==2) sendVoice(qun,qq,cut.replace("/*","/1"));
if(yuyin==0) {
for(int b=0;b<i;b++){
sendVoice(qun,qq,cut.replace("/*","/"+b));
}
}
else if(yuyin>i) sendVoice(qun,qq,cut.replace("/*","/"+i));
else sendVoice(qun,qq,cut.replace("/*","/"+yuyin));
  }
  }
   }
//   sendMsg(qun,""," "+filepath);
}
}).start();
}




import java.util.regex.*;


public int getduration(String path){
MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    retriever.setDataSource(path);
    String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
    retriever.release();
    return Integer.parseInt(time);
}



				
public String cutFile(String sourcePath) {
File start = new File(sourcePath);
String name=start.getName();
String end =RootPath+"/缓存/";
int type=0;
String filetype=filetype(sourcePath);
//Toast(filetype);
 if(filetype.contains("mp3")) type=1;
 else if(filetype.contains("m4a")) type=2;
 else if(filetype.contains("aac")) type=2;
 //else if(filetype.contains("silk")) type=0;
// else type=;
 if(type==1){
 boolean tt=RemoveID3V2(sourcePath,end+"去id3/"+name);
 if(tt)sourcePath=end+"去id3/"+name;
 type=2;
 }
 else {
 if(!name.endsWith("."+filetype))
{
int r=name.lastIndexOf(".");
if(r!=-1) name=name.substring(0,r+1)+filetype;
else name=name+"."+filetype;
copyFile(sourcePath,end+name);
sourcePath=end+name;
}
 }
File start = new File(sourcePath);
long filesize=start.length();
String name=start.getName();
String name2=name;
int r=name2.lastIndexOf(".");
if(r!=-1) name2=name2.substring(0,r);
String end2 =RootPath+"/缓存/切割/"+name2;
		File file = new File(end2);
		//Toast(file.getParent()+"\n"+file.exists());
		if(!file.exists()) file.mkdirs();  
//sendMsg("1087018867","",list0+"");
if(type==2){
ArrayList arrayList = new ArrayList();
arrayList.add("-y");
        arrayList.add("-i");
        arrayList.add(sourcePath);
        arrayList.add("-ac");
       arrayList.add("1");
      arrayList.add("-ar");
      arrayList.add("12000");
    //  arrayList.add("9000");
        arrayList.add("-ab");
        arrayList.add("120k");
       arrayList.add(end+name2+".aac");
ArrayList list=new ArrayList(ffm(arrayList));
//Toast(list.get(0)+"");
if(list.get(0).equals("onSuccess")){ sourcePath=end+name2+".aac";
if(!sourcePath.equals(end+name)) delAllFile(new File(end+name),0);
//return sourcePath;
//Toast((filesize/1024f/1024f)+"");
//String filepath="/storage/emulated/0/QTool/薛之谦 郭聪明 - 耗尽.mp3.aac";
//MediaCodecDecoder de=new MediaCodecDecoder();
//de.init(sourcePath,true);
//Object info=de.getAudioInformation();
//int samplerate=0+info.getSampleRate();
//int channel=info.getChannels();
/*MediaExtractor mExtractor= new MediaExtractor();
mExtractor.setDataSource(sourcePath);
mExtractor.selectTrack(0);
MediaFormat inputFormat = mExtractor.getTrackFormat(0);
int samplerate=inputFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
//int channel=inputFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
//if(channel==1) channel=AudioFormat.CHANNEL_OUT_MONO;
//else if(channel==2) channel=AudioFormat.CHANNEL_OUT_STEREO;
//Toast(samplerate+" "+channel);
//mp3Convertpcm(sourcePath,end+name2+".pcm");
MP3ToPCM(sourcePath,end+name2+".pcm");

//PlayPCM(end+name+".pcm",samplerate,channel);
delAllFile(new File(end+name2+".aac"),0);
ConvertPCMToSilk(end+name2+".pcm",end2+"/0-"+name2+".silk",samplerate,20000);
delAllFile(new File(end+name2+".pcm"),0);*/
AudioToSilk(sourcePath,end2+"/0-"+name2+".silk",19000);
sourcePath=end2+"/0-"+name2+".silk";
File start = new File(sourcePath);
filesize=start.length();
name=start.getName();
//Toast(filesize);
if(filesize<=10485760) return sourcePath;
else type=0;
}
else type=3;
}
if(type==3){
//Toast("1"+sourcePath);
int time=getduration(sourcePath);
int cut= (int)Math.ceil((float)filesize/1024f/1024f/10f);
int cuttime=Math.ceil(time/1000f/cut);
     //    Toast(cuttime+"");
ArrayList arrayList = new ArrayList();
arrayList.add("-y");
        arrayList.add("-i");
        arrayList.add(sourcePath);
        arrayList.add("-f");
        arrayList.add("segment");
       arrayList.add("-segment_time");
       arrayList.add(cuttime+"");
       arrayList.add("-c");
       arrayList.add("copy");
       arrayList.add(end2+"/%d-"+name);
ArrayList list2=new ArrayList(ffm(arrayList));
delAllFile(new File(end+name),0);
//Toast(list2.get(1).substring(5100)+"");
if(list2.get(0).equals("onSuccess")) return end2+"/*-"+name;
//else return "错误";
}
try{
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(sourcePath));
			FileOutputStream bos; 
			int len = 0;
			int len2=0;
			byte[] flush = new byte[1024];
			//if(type==2){
			bos=new FileOutputStream(end2+"/0-"+name,true);
			while((len=bis.read(flush)) != -1) {
				bos.write(flush, 0, len);
		    len2=len+len2;  
 	      if(len2>10485760-1024) break;
			}
			//}
			}
		catch( e) {
			Toast("错误"+e+sourcePath);
			return "错误";
		}
		return end2+"/*-"+name;
}



public String filetype(String filepath)
{
String head=readfile(filepath);
String type="";
if(head.startsWith("#!SILK_V")) type="silk";
//else if(head.startsWith("OggS")) type="opus";
else if(head.startsWith("fLaC")) type="flac";
else if(head.contains("WAVEfmt")) type="wav";
else if(head.startsWith("#!AMR")) type="amr";
else {
MediaExtractor mExtractor= new MediaExtractor();
mExtractor.setDataSource(filepath);
mExtractor.selectTrack(0);
MediaFormat inputFormat = mExtractor.getTrackFormat(0);
Toast(inputFormat);
String mime=inputFormat.getString(MediaFormat.KEY_MIME);
if(mime.equals("audio/mpeg")) type="mp3";
else if(mime.equals("audio/opus")) type="opus";
else if(mime.equals("audio/vorbis")) type="ogg";
else if(mime.equals("audio/3gpp")) type="3gp";
else if(mime.contains("audio/mp4a")) {
boolean ifm4a=(inputFormat.containsKey("encoder-delay"));
//int pro=inputFormat.getInteger(MediaFormat.KEY_AAC_PROFILE);
if(ifm4a) type="m4a";
else type="aac";
}
else type=mime;
}
return type;
}