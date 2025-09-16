import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
public class ItemManage
{
	public SetItemData(String GroupUin, SetName, ItemName, data)
	{
		try
		{
			MyFile.CreateDir(RootPath + "data/" + GroupUin);
			String UserData = MyFile.ReadFile(RootPath + "data/" + GroupUin  + "/" + SetName + ".txt");
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
			MyFile.WriteFile(RootPath + "data/" + GroupUin + "/" + SetName + ".txt", UserDataJson.toString());
			return;
		}
		catch(Exception e)
		{
			return;
		}
	}
	public String GetItemData(String GroupUin, SetName, ItemName)
	{
		try
		{
			String UserData = MyFile.ReadFile(RootPath + "data/" + GroupUin + "/" + SetName + ".txt");
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
		    Toast("" + e);
			return "";
		}
	}
}
public class FileSystem
{
	public ReadFile(String FilePath)
	{
		try
		{
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
}
FileSystem MyFile = new FileSystem();
ItemManage item = new ItemManage();