String RootPath3 = AppPath+"/冷雨目录/登录数据";
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Base64;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import android.app.Activity;

import android.app.*;
import android.content.*;
import android.app.Activity;
import android.app.Service;
import android.os.Vibrator;

import java.io.*; 
import java.net.*;
import java.util.zip.GZIPInputStream;

HashMap FileMemCache = new HashMap();
public put(String Path, WriteData){
try{
FileMemCache.put(Path,WriteData);
File file = new File(Path);
FileOutputStream fos = new FileOutputStream(file);
if(!file.exists()){
file.createNewFile();}
byte[] bytesArray = WriteData.getBytes();fos.write(bytesArray);fos.flush();}catch(IOException ioe){}
}
public sc(String Path){
File file = null;try{file = new File(Path);
if(file.exists()){file.delete();FileMemCache.remove(Path);}}catch(Exception e){Toast(e);}
}
public class FileSystem
{
	public ReadFile(String FilePath)
	{
		try
		{
			if(FileMemCache.containsKey(FilePath))
			{
				return FileMemCache.get(FilePath);
			}
			File file = new File(FilePath);
			if(!file.exists())
			{
				file.createNewFile();
			}
			InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(inputReader);
			String Text = "";
			while((str = bf.readLine()) != null)
			{
				Text = Text + "\n"+str;
			}
			if(Text.isEmpty())
			{
				return "";
			}
			FileMemCache.put(FilePath,Text.substring(1));
			return Text.substring(1);
		}
		catch(IOException ioe)
		{
			return "";
		}
	}
	public WriteFile(String Path, WriteData)
	{
		try
		{
			FileMemCache.put(Path,WriteData);
			File file = new File(Path);
			FileOutputStream fos = new FileOutputStream(file);
			if(!file.exists())
			{
				file.createNewFile();
			}
			byte[] bytesArray = WriteData.getBytes();
			fos.write(bytesArray);
			fos.flush();
		}
		catch(IOException ioe)
		{
			Toast("An error occurs in writing the file " + Path);
		}
	}
	public CreateDir(String Path)
	{
		File dir = null;
		try
		{
			dir = new File(Path);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
		}
		catch(Exception e)
		{
			Toast("创建文件夹时发生错误,相关信息:\n" + e);
		}
	}
	public DeleteFile(String Path)
	{
		File file = null;
		try
		{
			file = new File(Path);
			if(file.exists())
			{
				file.delete();
				FileMemCache.remove(Path);
			}
		}
		catch(Exception e)
		{
			Toast("删除文件时发生错误,相关信息:\n" + e);
		}
	}
	public DeleteDir(String Path)
	{
		File file = new File(Path);
		if(file.isFile())
		{
			file.delete();
		}else
		{
			File[] files = file.listFiles();
			if(files == null)
			{
				file.delete();
			}else
			{
				for (int i = 0; i < files.length; i++) 
				{
					DeleteDir(files[i].getAbsolutePath());
				}
				file.delete();
			}
		}
	}
	public SaveDataToFile(String path, byte[] Filedata) throws Exception
    {
        InputStream is = new ByteArrayInputStream(Filedata);
        byte[] bs = new byte[1024];
        int len;
        FileOutputStream out = new FileOutputStream(path, false);
        while((len = is.read(bs)) != -1)
        {
            out.write(bs, 0, len);
        }
        out.close();
        is.close();
    }
	public byte[] ReadByteByPath(String Path)
	{
		File MyFileaaa = new File(Path);
		FileInputStream input= new FileInputStream(MyFileaaa);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int n = 0;
		while(-1 != (n = input.read(buffer)))
        {
        output.write(buffer, 0, n);
        }
		return output.toByteArray();
	}
	public Object ReadObjectFromFile(String Path)
	{
		try{
			File mfile = new File(Path);
		if(!mfile.exists()) return new HashMap();
		FileInputStream fileIn = new FileInputStream(Path);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		return in.readObject();
		}
		catch(e)
		{
			return new HashMap();
		}
		
	}
	
	
	public void WriteObjectToFile(String Path,Object WriteData)
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream output = new ObjectOutputStream(out);
		output.writeObject(WriteData);
		output.flush();
		output.close();
		try{
			SaveDataToFile(Path,out.toByteArray());
		}
		catch(e)
		{
			Toast(""+e);
		}
		
	}
}
public JSON解析(String data,String a,String b)
{//鸭鸭
try
{
String s="";
JSONObject j = new JSONObject(data);
if(a.equals(""))
{
s=j.getString(b);
}
else if(b.equals(""))
{
s=j.getString(a);
}
else
{
s=j.getJSONObject(a).getString(b);
}
return s;
}
catch(e)
{
return "";Toast("解析错误"+e);
}
}
FileSystem MyFile = new FileSystem();