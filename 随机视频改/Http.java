import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.RandomAccessFile;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.File;
import java.lang.Exception;
public class Http
{
	public String get(String url)
	{
		StringBuffer buffer = new StringBuffer();
            InputStreamReader isr = null;
            try {
                URL urlObj = new URL(url);
                URLConnection uc = urlObj.openConnection();
                uc.setConnectTimeout(10000);
                uc.setReadTimeout(10000);
                isr = new InputStreamReader(uc.getInputStream(), "utf-8");
                BufferedReader reader = new BufferedReader(isr);
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != isr) {
                        isr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        if(buffer.length()==0)return buffer.toString();
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
	}
	public void DownloadToFile(String url,String filepath) throws Exception
    {
        InputStream input = null;
        try {
            URL ur = new URL(url);
            HttpURLConnection urlConn = (HttpURLConnection) ur.openConnection();
            //urlConn.setRequestProperty("Range","bytes=0-"+(10*1024*1024));
            input = urlConn.getInputStream();
            byte[] bs = new byte[1024];
            int len;
            //File file=new File(filepath);
            FileOutputStream out = new FileOutputStream(filepath, false);
            //RandomAccessFile out=new RandomAccessFile(file, "rw");         
            //int allLen=0;                  
            while((len = input.read(bs)) != -1)
            {
                /*if(allLen>=10*1024*1024){
                    break;
                }*/              
                out.write(bs, 0, len);
                //allLen+=len;
            }
            out.close();
            input.close();

        } catch (IOException e) {
            return;
        }
        finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}