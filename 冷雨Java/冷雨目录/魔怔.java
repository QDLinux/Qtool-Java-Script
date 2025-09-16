//YouGuess
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
String 图片外显=PictureDisplay;
public void 图片外显(Object data){
if("1".equals(getString(MyUin,"图片外显"))){
	if(data.IsSend&&data.msg instanceof MessageForPic){
		if(data.msg.picExtraData==null)data.msg.picExtraData=new PicMessageExtraData();
		data.msg.picExtraData.textSummary=图片外显;
		new java.lang.Thread(new Runnable(){
		}).start();
	}
}
}