HashMap FileMemCache = new HashMap();
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
	public 写(String GroupUin, QQUin, SetName, ItemName, data)
	{
		try
		{
			新建(路径 + "data/" + GroupUin + "/" + QQUin);
			String UserData = 读(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt");
			JSONObject UserDataJson = null;
			if(UserData.equals(""))
			{
				UserDataJson = new JSONObject("{}");
			}
			else
			{
				UserDataJson = new JSONObject(UserData);
			}
			UserDataJson.put(ItemName, data);
			写(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	public 清除(String GroupUin, QQUin, SetName, ItemName)
	{
		try
		{
			新建(路径 + "data/" + GroupUin + "/" + QQUin);
			String UserData = 读(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt");
			JSONObject UserDataJson = null;
			if(UserData.equals(""))
			{
				return;
			}
			else
			{
				UserDataJson = new JSONObject(UserData);
			}
			UserDataJson.remove(ItemName);
			写(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	public String[] 列表(String GroupUin, QQUin, SetName)
	{
		try
		{
			String UserData = 读(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt");
			JSONObject UserDataJson = null;
			if(UserData.equals(""))
			{
				return new String[0];
			}
			else
			{
				UserDataJson = new JSONObject(UserData);
			}
			Iterator it = UserDataJson.keys();
			ArrayList List = new ArrayList();
			while(it.hasNext())
			{
				List.add(it.next());
			}
			String[] fintext = List.toArray(new String[0]);
			return fintext;
		}
		catch(Exception e)
		{
			return new String[0];
		}
	}
	public String 文字(String GroupUin, QQUin, SetName, ItemName)
	{
		try
		{
			String UserData = 读(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt");
			JSONObject UserDataJson = null;
			if(UserData.equals(""))
			{
				return "";
			}
			else
			{
				UserDataJson = new JSONObject(UserData);
			}
			if(!UserDataJson.has(ItemName)) return "";
			return UserDataJson.getString(ItemName);
		}
		catch(Exception e)
		{
			return "";
		}
	}
	public 写(String GroupUin, QQUin, SetName, ItemName, long data)
	{
		try
		{
			新建(路径 + "data/" + GroupUin + "/" + QQUin);
			String UserData = 读(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt");
			JSONObject UserDataJson = null;
			
			if(UserData.equals(""))
			{
				UserDataJson = new JSONObject("{}");
			}
			else
			{
				UserDataJson = new JSONObject(UserData);
			}
			UserDataJson.put(ItemName, String.valueOf(data));
			
			写(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			Toast(e+"");
			return;
		}
	}
	public long 读(String GroupUin, QQUin, SetName, ItemName)
	{
		try
		{
			String UserData = 读(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt");
			JSONObject UserDataJson = null;
			if(UserData.equals(""))
			{
				return 0;
			}
			else
			{
				UserDataJson = new JSONObject(UserData);
			}
			if(!UserDataJson.has(ItemName)) return 0;
			return Long.parseLong(UserDataJson.getString(ItemName));;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	public 删除(String GroupUin, QQUin, SetName)
	{
		删除(路径 + "data/" + GroupUin + "/" + QQUin + "/" + SetName + ".txt");
	}
	public 删除(String GroupUin, QQUin)
	{
	try{
		String 路径a=路径 + "data/" + GroupUin + "/" + QQUin + "/";
		新建(路径a);
		List fs = Arrays.asList(new File(路径a).listFiles());
		for(File f: fs)
		{
		String lj=路径a+f.getName();
		删除(lj);
		}
		}
		catch(IOException ioe)
		{
			return "";
		}
	}
	public 读(String FilePath)
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
	public 写(String Path, WriteData)
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
			
		}
	}
	public 新建(String Path)
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
	public 删除(String Path)
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