//接口来自光(1478950015)
//其实还是chatGPT(
//下载
//DownloadFile.download(fileUrl, saveDir, fileName);
//删除
//DeleteFile.delete(filePath)


import java.io.*;
import java.net.*;

/*public class DownloadFile {
  public static void download(String fileUrl, String saveDir, String fileName) throws IOException {
    URL url = new URL(fileUrl);
    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
    int responseCode = httpConn.getResponseCode();

    // 检查 HTTP 响应码
    if (responseCode == HttpURLConnection.HTTP_OK) {
      String disposition = httpConn.getHeaderField("Content-Disposition");
      String contentType = httpConn.getContentType();
      int contentLength = httpConn.getContentLength();

      System.out.println("Content-Type = " + contentType);
      System.out.println("Content-Disposition = " + disposition);
      System.out.println("Content-Length = " + contentLength);
      System.out.println("fileName = " + fileName);

      // 写文件到本地
      InputStream inputStream = httpConn.getInputStream();
      String saveFilePath = saveDir + File.separator + fileName;
      FileOutputStream outputStream = new FileOutputStream(saveFilePath);

      int bytesRead = -1;
      byte[] buffer = new byte[4096];
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
      }

      outputStream.close();
      inputStream.close();

      System.out.println("文件下载成功！");
    } else {
      System.out.println("无法获得正确的 HTTP 响应：" + responseCode);
    }
    httpConn.disconnect();
  }
}*/


public void DownloadToFile(String url,String filepath) throws Exception {
		File file = new File(filepath);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs(); 
		}
		InputStream input = null;
		try {
			URL ur = new URL(url);
			HttpURLConnection urlConn = (HttpURLConnection) ur.openConnection();
			input = urlConn.getInputStream();
			byte[] bs = new byte[1024];
			int len;
			FileOutputStream out = new FileOutputStream(filepath, false);
			while((len = input.read(bs)) != -1) {
				out.write(bs, 0, len);
			}
			out.close();
			input.close();
		} catch (IOException e) {
			return false;
		}
		finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}


import java.io.File;

public class DeleteFile {
  public static void delete(String filePath) {
    File file = new File(filePath);

    // 检查文件是否存在
    if (!file.exists()) {
      System.out.println("文件不存在！");
      return;
    }

    // 尝试删除文件
    if (file.delete()) {
      System.out.println("文件已删除！");
    } else {
      System.out.println("无法删除文件！");
    }
  }
}