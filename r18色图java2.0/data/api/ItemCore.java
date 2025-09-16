HashMap FileMemCache = new HashMap();
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
public class ItemManage
{
	public SetItemData(String Path, SetName, ItemName, data)
	{
		try
		{
			MyFile.CreateDir(RootPath + Path);
			String UserData = MyFile.ReadFile(RootPath + Path + "/" + SetName + ".txt");
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
			MyFile.WriteFile(RootPath + Path + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	public DeleteItem(String Path, SetName, ItemName)
	{
		try
		{
			MyFile.CreateDir(RootPath + Path);
			String UserData = MyFile.ReadFile(RootPath + Path + "/" + SetName + ".txt");
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
			MyFile.WriteFile(RootPath + Path + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	public String[] MakeListForItem(String Path, SetName)
	{
		try
		{
			String UserData = MyFile.ReadFile(RootPath + Path + "/" + SetName + ".txt");
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
	public String GetItemData(String Path, SetName, ItemName)
	{
		try
		{
			String UserData = MyFile.ReadFile(RootPath + Path + "/" + SetName + ".txt");
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
	public Object GetItemJson(String Path, SetName)
	{
		try
		{
		String Path=RootPath + Path + "/" + SetName + ".txt";
		FileMemCache.remove(Path);
			String UserData = MyFile.ReadFile(Path);
			JSONObject UserDataJson = null;
				if(UserData.equals("")) UserData="{\"没有数据\":\"请先锁定\"}";
				UserDataJson = new JSONObject(UserData);
				return UserDataJson;
				
		}
		catch(Exception e)
		{
			return "";
		}
	}
	public SetItemData(String Path, SetName, ItemName,long data)
	{
		try
		{
			MyFile.CreateDir(RootPath + Path);
			String UserData = MyFile.ReadFile(RootPath + Path + "/" + SetName + ".txt");
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
			
			MyFile.WriteFile(RootPath + Path + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			Toast(e+"");
			return;
		}
	}
	public long GetItemDataInt(String Path, SetName, ItemName)
	{
		try
		{
			String UserData = MyFile.ReadFile(RootPath + Path + "/" + SetName + ".txt");
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
			return Long.parseLong(UserDataJson.getString(ItemName));
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	public DeleteItemFile(String Path, SetName)
	{
		MyFile.DeleteFile(RootPath + Path + "/" + SetName + ".txt");
	}
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
FileSystem MyFile = new FileSystem();
ItemManage item = new ItemManage();