import android.graphics.*;
String textface="";
Object typeface;
try{typeface=Typeface.createFromFile(textface);}
catch(e){typeface=Typeface.DEFAULT_BOLD;}

public String MakeTextPhoto(String text){
text=text.replace("[]","");
String[] word=text.split("\n");

float textsize=40.0f;
float padding=30.0f;

Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
paint.setTypeface(typeface);
paint.setTextSize(textsize);
Bitmap mybitmap;
float text_width=0;
float average_width=0;
float text_height=0; 
String newword="";
for(String line:word){
average_width +=paint.measureText(line);}
average_width=average_width/word.length;

for(String line:word){
float width=paint.measureText(line);
if(width-average_width>700){
int rr=Math.ceil(width/average_width);
int cut=Math.ceil(line.length()/rr);

line=splitString(line,cut);
for(String newl:line.split("\n")){
width=paint.measureText(newl);
if(text_width<width) text_width=width;}}
if(text_width<width) text_width=width;
newword+=line+"\n";}
word=newword.split("\n");

int width=(int)(text_width  + padding * 2f);
int heigth=(int)((textsize+8) * word.length+ padding * 2f)-8;
Bitmap original = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);

Canvas canvas=new Canvas(original);
canvas.drawColor(ParseColor(Backgroundcolor,Color.WHITE));
paint.setColor(getColor(Colour));
float yoffset=textsize+padding;
for(String line:word){
canvas.drawText(line, padding, yoffset, paint);
yoffset += textsize+8;}
String path=AppPath+"/冷雨目录/图片/"+canvas+".png";
File end = new File(path);
if(!end.exists()) end.getParentFile().mkdirs();
FileOutputStream out = new FileOutputStream(end);
original.compress(Bitmap.CompressFormat.JPEG, 80, out);
out.close();
return path;
}
private static String randomColor(int len){
	try{
		StringBuffer result = new StringBuffer();
			for (int i = 0; i < len; i++){
				result.append(Integer.toHexString(new Random().nextInt(16)));
			}
			return result.toString().toUpperCase();
		}catch (Exception e){
			return "00CCCC";
		}
	};
public static int getColor(String color)
{
	switch(color)
	{
		case "红色":
			return Color.RED;
		case "黑色":
			return Color.BLACK;
		case "蓝色":
			return Color.BLUE;
		case "蓝绿":
			return Color.CYAN;
		case "白灰":
			return Color.LTGRAY;
		case "灰色":
			return Color.GRAY;
		case "绿色":
			return Color.GREEN;
		case "深灰":
			return Color.DKGRAY;
		case "洋红":
			return Color.MAGENTA;
		case "透明":
			return Color.TRANSPARENT;
		case "白色":
			return Color.WHITE;
		case "黄色":
			return Color.YELLOW;
		case "随机":
			return Color.parseColor("#"+randomColor(6));
		default:
			return Color.parseColor("#"+color);
	}
};
public Object ParseColor(String color,Object normal)
{
Object parsecolor;
try{
if(color.contains("随机")) parsecolor=Color.parseColor(randomColor(6));
else parsecolor=Color.parseColor(color);
}
catch(e){parsecolor=normal;}
return parsecolor;
}
public String splitString(String content, int len)
{
	String tmp = "";
	if(len > 0){
	if(content.length() > len){
	int rows = Math.ceil(content.length() / len);
	for (int i = 0; i < rows; i++){
	if(i == rows - 1){
	tmp += content.substring(i * len);}else{
	tmp += content.substring(i * len, i * len + len) + "\n ";}}}else{
	tmp = content;}}return tmp;
}

public Bitmap bitmapurl(String url)
{
	InputStream input = null;
	Bitmap original =null;
	try{File file=new File(url);
	if(file.exists()) original=BitmapFactory.decodeFile(url).copy(Bitmap.Config.ARGB_8888,true);
	else{
	URL urlsssss = new URL(url);
	HttpURLConnection urlConn = (HttpURLConnection) urlsssss.openConnection();
	urlConn.setConnectTimeout(10000);
	urlConn.setReadTimeout(10000);
	input = urlConn.getInputStream(); 
	original = BitmapFactory.decodeStream(input).copy(Bitmap.Config.ARGB_8888, true);}}
	catch (Exception e){}
	return original;
}

public Bitmap bitmapurl(String url)
{
	InputStream input = null;
	Bitmap original =null;
	try{File file=new File(url);
	if(file.exists()) original=BitmapFactory.decodeFile(url).copy(Bitmap.Config.ARGB_8888, true);
	else{
	URL urlsssss = new URL(url);
	HttpURLConnection urlConn = (HttpURLConnection) urlsssss.openConnection();
	urlConn.setConnectTimeout(10000);
	urlConn.setReadTimeout(10000);
	input = urlConn.getInputStream(); 
	original = BitmapFactory.decodeStream(input).copy(Bitmap.Config.ARGB_8888, true);}}
	catch (Exception e){}
	return original;
}

public void sendTextPic(String qun,String text){
String pic=MakeTextPhoto(text);
sendPic(qun,"",pic);
}