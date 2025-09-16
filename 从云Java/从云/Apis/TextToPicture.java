import android.graphics.*;

Object typeface;
try{typeface=Typeface.createFromFile(textface);}
catch(e){typeface=Typeface.DEFAULT_BOLD;}


public String MakeTextPhoto(String text,String pic,boolean auto)
{
text=text.replace("[]","");
String[] word=text.split("\n");

float textsize=40.0f;
float padding=30.0f;

Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

paint.setTypeface(typeface);
paint.setTextSize(textsize);

Bitmap mybitmap;
if(phototype==2) mybitmap=bitmapurl(photourl);
if(phototype==3) mybitmap=bitmapurl(pic);
if(phototype!=1&&mybitmap==null) mybitmap =bitmapurl("https://tuapi.eees.cc/api.php?category={dongman,fengjing}&px=m&type=302");

float text_width=0;
float average_width=0;
float text_height=0; 
String newword="";
for(String line:word)
{
average_width +=paint.measureText(line);
}
average_width=average_width/word.length;

for(String line:word)
{
float width=paint.measureText(line);
if(auto/*&&phototype!=1*/){
//if(text_width>0&&width-text_width>300) {
if(width-average_width>700) {
int rr=Math.ceil(width/average_width);
int cut=Math.ceil(line.length()/rr);

line=splitString(line,cut);
for(String newl:line.split("\n"))
{
width=paint.measureText(newl);
if(text_width<width) text_width=width;
}
//Toast(rr+"  "+cut+"  "+line);
//line=splitString(line,(int)((line.length()/width)*(mybitmap.getWidth())));
//line=splitString(line,(int)(line.length()/1.9));
//width=width/cut+200;
}
}
if(text_width<width) text_width=width;
newword+=line+"\n";
}
word=newword.split("\n");

int width=(int)(text_width  + padding * 2f);
//Toast(text_width+" "+width);
int heigth=(int)((textsize+8) * word.length+ padding * 2f)-8;
Bitmap original = Bitmap.createBitmap(width, heigth, Bitmap.Config.ARGB_8888);


Canvas canvas=new Canvas(original);
if(phototype==1) canvas.drawColor(ParseColor(photocolor,Color.WHITE));
else {
Matrix matrix = new Matrix(); 
float i=(float)width/(float)mybitmap.getWidth();
float b=(float)heigth/(float)mybitmap.getHeight();
if(i>b) b=i;
//if(i<b) b=i;
    matrix.postScale(b,b); //长和宽放大缩小的比例
    Bitmap resizeBmp = Bitmap.createBitmap(mybitmap,0,0,mybitmap.getWidth(),mybitmap.getHeight(),matrix,true);
canvas.drawBitmap(resizeBmp, (original.getWidth()-resizeBmp.getWidth())/2, (original.getHeight()-resizeBmp.getHeight())/2, paint);
canvas.drawColor(Color.parseColor("#6AFFFFFF"));//白色半透明遮罩
}
paint.setColor(ParseColor(textcolor,Color.BLACK));
//float yoffset = heigth - padding * 2 + textsize * 2 / 3;
float yoffset=textsize+padding;
for(String line:word)
{
canvas.drawText(line, padding, yoffset, paint);
      yoffset += textsize+8;
}
String path=RootPath+"/缓存/"+canvas+".jpg";
File end = new File(path);
if(!end.exists()) end.getParentFile().mkdirs();
FileOutputStream out = new FileOutputStream(end);
original.compress(Bitmap.CompressFormat.JPEG, 50, out);
out.close();
return path;
}

public String splitString(String content, int len) {

        String tmp = "";
        if (len > 0) {
            if (content.length() > len) {
                int rows = Math.ceil(content.length() / len);
                for (int i = 0; i < rows; i++) {
                    if (i == rows - 1) {
                        tmp += content.substring(i * len);
                    } else {
                        tmp += content.substring(i * len, i * len + len) + "\n   ";
                    }

                }

            } else {
                tmp = content;
            }
        }

        return tmp;
    }
public String randomColor(int size)
{
        StringBuilder tx= new StringBuilder("#");
        String[] color=new String[]{"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        for (int i=0;i<size;i++){
            tx.append(color[(int) (Math.random() * color.length)]);
        }
        return tx.toString();
}

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