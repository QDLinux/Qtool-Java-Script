HashMap FileMemCache = new HashMap();
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;



public 写全局(SetName, ItemName, data)
	{
		try
		{
			新建(RootPath + "data/");
			String UserData = 读(RootPath + "data/" + SetName + ".txt");
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
			写(RootPath + "data/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	public 写(QQUin, SetName, ItemName, data)
	{
		try
		{
			新建(RootPath + "data/" + QQUin);
			String UserData = 读(RootPath + "data/" + QQUin + "/" + SetName + ".txt");
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
			写(RootPath + "data/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	public 清除( QQUin, SetName, ItemName)
	{
		try
		{
			新建(RootPath + "data/"+ QQUin);
			String UserData = 读(RootPath + "data/"  + QQUin + "/" + SetName + ".txt");
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
			写(RootPath + "data/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	
	public 清除全局( SetName, ItemName)
	{
		try
		{
			新建(RootPath + "data/");
			String UserData = 读(RootPath + "data/" + SetName + ".txt");
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
			写(RootPath + "data/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	public String[] 列表(QQUin, SetName)
	{
		try
		{
			String UserData = 读(RootPath + "data/" + QQUin + "/" + SetName + ".txt");
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
	public String[] 全局列表(SetName)
	{
		try
		{
			String UserData = 读(RootPath + "data/" + SetName + ".txt");
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
	public String 文字(QQUin, SetName, ItemName)
	{
		try
		{
			String UserData = 读(RootPath + "data/" + QQUin + "/" + SetName + ".txt");
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
	public String 全局文字( SetName, ItemName)
	{
		try
		{
			String UserData = 读(RootPath + "data/" + SetName + ".txt");
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
	public 写(QQUin, SetName, ItemName, long data)
	{
		try
		{
			新建(RootPath + "data/" + QQUin);
			String UserData = 读(RootPath + "data/" + QQUin + "/" + SetName + ".txt");
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
			
			写(RootPath + "data/" + QQUin + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			Toast(e+"");
			return;
		}
	}
	public 写全局( SetName, ItemName, long data)
	{
		try
		{
			新建(RootPath + "data/");
			String UserData = 读(RootPath + "data/" + SetName + ".txt");
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
			
			写(RootPath + "data/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			Toast(e+"");
			return;
		}
	}
	public long 读(QQUin, SetName, ItemName)
	{
		try
		{
			String UserData = 读(RootPath + "data/" + QQUin + "/" + SetName + ".txt");
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
	public long 读模糊(QQUin, SetName, ItemName)
	{
		try
		{
			String UserData = 读(RootPath + "data/" + QQUin + "/" + SetName + ".txt");
			JSONObject UserDataJson = null;
			if(UserData.contains(""))
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
	public long 读全局(SetName, ItemName)
	{
		try
		{
			String UserData = 读(RootPath + "data/" + SetName + ".txt");
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
	public 删除(QQUin, SetName)
	{
		删除(RootPath + "data/" + QQUin + "/" + SetName + ".txt");
	}
	public 删除(QQUin)
	{
		删除(RootPath + "data/" +  QQUin + "/");
	}
	public 删除全局(SetName)
	{
		删除(RootPath + "data/" + SetName + ".txt");
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