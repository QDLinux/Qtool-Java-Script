public String readfile(String url)
{
String text;
      File file = new File(url);
        if(!file.getParentFile().exists())    
       {    
        file.getParentFile().mkdirs(); 
        file.createNewFile();    
       }
       else if(!file.exists()) file.createNewFile();
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                 
              StringBuffer sb = new StringBuffer();
                
                //while((text = bufferedReader.readLine()) != null){
                text = bufferedReader.readLine();
                sb.append(text);
                text = bufferedReader.readLine();
                sb.append(text);
               // }
                text=sb.toString();             
   try
   {
       return text;
   }
   catch (Throwable e)
   {
   }
}

public static String writefile(String url,String word,int t)
{
String kai="0";
try
   {
        File file = new File(url);
        if(!file.getParentFile().exists())    
       {    
        file.getParentFile().mkdirs(); 
        file.createNewFile();    
       }
       else if(!file.exists()) file.createNewFile();
            if(t==1) fileOutputStream = new FileOutputStream(file);
            else fileOutputStream = new FileOutputStream(file,true);
           fileOutputStream.write(word.getBytes());
           fileOutputStream.flush();
           fileOutputStream.close();
           kai="1";        
}
catch (e) {Toast(e+"");}
return kai;
}

public static void copyFile(String sourcePath, String newPath) {
		File start = new File(sourcePath);
		File end = new File(newPath);
		if(end.exists()) return;
        else end.getParentFile().mkdirs();
       if(!start.exists()) 
       {
        start.getParentFile().mkdirs(); 
        start.createNewFile();    
       }
		try{BufferedInputStream bis=new BufferedInputStream(new FileInputStream(start));
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(end)); 
			int len = 0;
			byte[] flush = new byte[10240];
			while((len=bis.read(flush)) != -1) {
				bos.write(flush, 0, len);
			}
			bos.flush();
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
}

public String encryptKaiser(String orignal, String str,int type) {
long key = Long.parseLong(str);
char[] chars = orignal.toCharArray();
StringBuilder sb = new StringBuilder();
for (char aChar : chars) {
long asciiCode = aChar;
if(type==1)  asciiCode += key;
if(type==0)  asciiCode -= key;
char result = (char) asciiCode;
    sb.append(result);
}
return sb.toString();
}

    
public static void delAllFile(File directory,int type){
if(!directory.exists()) return;
String text="删除";
    if (!directory.isDirectory()){
    text+="\n文件"+directory.getAbsolutePath();
        directory.delete();
    } else{
        File [] files = directory.listFiles();

        // 空文件夹
        if (type==0&&files.length==0){
           directory.delete();
          text+="\n空文件夹"+directory.getAbsolutePath();
            return;
        }

        // 删除子文件夹和子文件
        for (File file : files){
            if (file.isDirectory()){
                delAllFile(file,type);
            } else {
                file.delete();
                text+="\n文件"+file.getAbsolutePath();
            }
        }

        // 删除文件夹本身
        if(type==0){
        directory.delete();
      text+="\n文件夹" + directory.getAbsolutePath();
      }
    }
   // if(!text.equals("删除")) Toast(text);
}

delAllFile(new File(RootPath+"/缓存"),0);