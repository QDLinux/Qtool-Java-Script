
//卑微萌新(779412117)据菜豆开源代码改写
/*

把单声道音频(不支持双声道)转化成Silk

AudioToSilk(String Source,String dest,int ToRate)
原文件路径，输出文件路径，输出Silk采样率(不要超过21000否则QQ二次压缩)

*/


import android.media.*;

import java.io.*;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import java.util.Arrays;
import java.util.ArrayList;

import com.tencent.mobileqq.videocodec.ffmpeg.*;

public class ffmpegcallback extends ExecuteBinResponseCallback {
final ArrayList list;

ffmpegcallback(ArrayList t) {
list=t;
}
public void onFinish(boolean z) {
       // list.add("onFinish");
        }
public void onSuccess(String str) {
        list.add("onSuccess");
        list.add(str);
        }
        
public void onFailure(String str){
list.add("onFailure:");
list.add(str);
}
}

boolean progress=false;
FFmpeg ffmpeg=FFmpeg.getInstance(context);
public ArrayList ffm(ArrayList arrayList)
{
ArrayList list=new ArrayList();
new java.lang.Thread(new Runnable()
{
public void run()
{
while(progress){
//Toast("任务进行中");
Thread.sleep(5000);
}
progress=true;
ffmpeg.execute(arrayList.toArray(new String[0]),new ffmpegcallback(list));
}
}).start();
while(list==null||list.size()<1){
Thread.sleep(100);
}
progress=false;
//Toast("任务完成"+arrayList);
return list;
}


import com.tencent.mobileqq.utils.SilkCodecWrapper;


public void AudioToSilk(String Source,String dest,int ToRate)
    {
    public MediaExtractor mExtractor;
    public MediaCodec mDecoder;
    public int FromRate;
    SilkCodecWrapper SilkCodec = new SilkCodecWrapper(context);
        try{
            mExtractor = new MediaExtractor();
            mExtractor.setDataSource(Source);
            mExtractor.selectTrack(0);
            int count = mExtractor.getTrackCount();
            MediaFormat inputFormat;
for (int i = 0; i < count; i++) {
    MediaFormat format = mExtractor.getTrackFormat(i);
    //获取 mime 类型
    String mime = format.getString(MediaFormat.KEY_MIME);
if (mime.startsWith("audio")) {
    	//音频轨
        inputFormat = format;
        break;
    }
}
//Toast(inputFormat);
if(inputFormat==null){Toast("AudioToPcm Error:\n从"+Source+"提取音频数据失败!"); return;}
            FromRate=inputFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
            File file = new File(dest);
            if(!file.getParentFile().exists())
            {
                file.getParentFile().mkdirs();
            }
            FileOutputStream outData = new FileOutputStream(file);
            outData.write(2);
            outData.write("#!SILK_V3".getBytes(StandardCharsets.UTF_8));
            mDecoder = MediaCodec.createDecoderByType(inputFormat.getString(MediaFormat.KEY_MIME));
            mDecoder.configure(inputFormat,null,null,0);
            mDecoder.start();
            //解码PCM编码SILK过程
            MediaCodec.BufferInfo info = new MediaCodec.BufferInfo(); //缓冲区
            info.size = 10240; //设置output buffer 的大小//1024*64*4
            while (true) {
                int inIndex = mDecoder.dequeueInputBuffer(info.size);
                if (inIndex >= 0) {
                    ByteBuffer buffer =  mDecoder.getInputBuffer(inIndex);
                    //从MediaExtractor中读取一帧待解的数据
                    int sampleSize = mExtractor.readSampleData(buffer, 0);
                    //小于0 代表所有数据已读取完成
                    if (sampleSize < 0) {
                        mDecoder.queueInputBuffer(inIndex, 0, 0, 0, MediaCodec.BUFFER_FLAG_END_OF_STREAM);
                    } else {
                        //插入一帧待解码的数据
                        mDecoder.queueInputBuffer(inIndex, 0, sampleSize, mExtractor.getSampleTime(), 0);
                        //MediaExtractor移动到下一取样处
                        mExtractor.advance();
                    }
                }
                int outIndex = mDecoder.dequeueOutputBuffer(info, info.size);
                switch (outIndex) {
                    case MediaCodec.INFO_OUTPUT_FORMAT_CHANGED:
                        break;
                    case MediaCodec.INFO_TRY_AGAIN_LATER:
                        break;
                    default:
                        ByteBuffer outBuffer = mDecoder.getOutputBuffer(outIndex);
                        //BufferInfo内定义了此数据块的大小
                        final byte[] chunk = new byte[info.size];
                        //将Buffer内的数据取出到字节数组中
                        outBuffer.get(chunk);
                        //数据取出后一定记得清空此Buffer MediaCodec是循环使用这些Buffer的，不清空下次会得到同样的数据
                        outBuffer.clear();
                        try {
                        if(QQ_version<8000){
                        SilkCodec.a(FromRate,ToRate,0);
                        }
                        else{
                         SilkCodec.b(FromRate,ToRate,0);
                         }
                        Object ProcessData = SilkCodec.a(chunk,0,chunk.length);
                if(ProcessData!=null)
                {
                    byte[] gProcessResult = ProcessData.c;
                    int length = ProcessData.a;
                    outData.write(Arrays.copyOf(gProcessResult,length));
                }
                        } catch (Exception e) {
                            Toast("PcmToSilk Error:\n"+e);
                        }
                        //此操作一定要做，不然MediaCodec用完所有的Buffer后 将不能向外输出数据
                        mDecoder.releaseOutputBuffer(outIndex, false);
                        break;
                }
                if (info.flags != 0) {
                    break;
                }
            }
            if(QQ_version<8000) SilkCodec.a();
            else SilkCodec.close();
           outData.flush();
            outData.close();
        }catch (Exception e)
        {
            Toast("AudioToSilk Error:\n"+e);
        }
    }



//import com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3FileCheck;

public boolean RemoveID3V2(String sourcePath,String outpath)
{
try{
File end = new File(outpath);
if(end.exists()) return false;
if(!end.exists()) end.getParentFile().mkdirs();
MP3FileCheck check=new MP3FileCheck(sourcePath);
check.fileCheck();
long size=check.mID3V2Size;
if(size<0)size =0;
BufferedInputStream bis=new BufferedInputStream(new FileInputStream(sourcePath));
FileOutputStream bos; 
byte[] flush = new byte[1024];
int len = 0;
int len2=0;
while((len=bis.read(flush)) != -1) {
//bos.write(flush, 0, len);
len2=len+len2;  
if(len2>size) break;
}
len2=0;len=0;
bos=new FileOutputStream(outpath,false); 
while((len=bis.read(flush)) != -1) {
bos.write(flush, 0, len);
}
return true;
}
catch (e){Toast(e);return false;}
}

