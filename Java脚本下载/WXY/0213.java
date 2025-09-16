





























//向来缘浅，奈何情深








































import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


	
	private static final int  BUFFER_SIZE = 2 * 1024;
	
	private static void compress(File sourceFile, ZipOutputStream zos, String name,
			boolean KeepDirStructure) throws Exception{
		byte[] buf = new byte[BUFFER_SIZE];
		if(sourceFile.isFile()){
			// 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
			zos.putNextEntry(new ZipEntry(name));
			// copy文件到zip输出流中
			int len;
			FileInputStream in = new FileInputStream(sourceFile);
			while ((len = in.read(buf)) != -1){
				zos.write(buf, 0, len);
			}
			// Complete the entry
			zos.closeEntry();
			in.close();
		} else {
			File[] listFiles = sourceFile.listFiles();
			if(listFiles == null || listFiles.length == 0){
				// 需要保留原来的文件结构时,需要对空文件夹进行处理
				if(KeepDirStructure){
					// 空文件夹的处理
					zos.putNextEntry(new ZipEntry(name + "/"));
					// 没有文件，不需要文件的copy
					zos.closeEntry();
				}
				
			}else {
				for (File file : listFiles) {
					// 判断是否需要保留原来的文件结构
					if (KeepDirStructure) {
						compress(file, zos, name + "/" + file.getName(),KeepDirStructure);
					} else {
						compress(file, zos, file.getName(),KeepDirStructure);
					}
					
				}
			}
		}
	}
	public static void toZip(String srcDir, OutputStream out, boolean KeepDirStructure)
			throws RuntimeException{
		
		long start = System.currentTimeMillis();
		ZipOutputStream zos = null ;
		try {
			zos = new ZipOutputStream(out);
			File sourceFile = new File(srcDir);
			compress(sourceFile,zos,sourceFile.getName(),KeepDirStructure);
			long end = System.currentTimeMillis();
			//Toast("压缩完成，耗时：" + (end - start) +" ms");
		} catch (Exception e) {
			throw new RuntimeException("zip error from ZipUtils",e);
		}finally{
			if(zos != null){
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
    //处理解压zip
    public static void dealUnZip(String path1,String path2) {
        List sourcesList = new ArrayList();
        String zipPath1 =path1;
        String targetZipPath =path2;
        File targetFile = new File(targetZipPath);
        sourcesList.add(zipPath1);
        //sourcesList 真实使用时可能有多个;此处先以一个文件为例;
        if (sourcesList != null && !sourcesList.isEmpty()) {
            for (String zipPath : sourcesList) {
                if (zipPath.endsWith(".zip")) {
                    dealzip(zipPath, targetZipPath);
                }
            }
        }

        //解压后的文件夹可能还有文件夹;
        File[] files = targetFile.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                if (fileName.endsWith(".zip")) {
                    dealzip(file.getPath(), targetZipPath);
                    //用完后就删掉这个zip;
                    file.delete();
                }
            }
        }
    }

    //处理文件解压;
    public static void dealzip(String zipSourcePath, String targetZipPath) {
        //判断目标地址是否存在，如果没有就创建
        File pathFile = new File(targetZipPath);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(zipSourcePath, Charset.forName("UTF-8"));
            //若zip中含有中文名文件,换GBK
            //zip = new ZipFile(zipPath, Charset.forName("GBK"));
            //遍历里面的文件及文件夹
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zipFile.getInputStream(entry);
                //也就是把这个文件加入到目标文件夹路径;
                String outpath = (targetZipPath + zipEntryName).replace("/", File.separator);
                //不存在则创建文件路径
                File file = new File(outpath.substring(0, outpath.lastIndexOf(File.separator)));
                if (!file.exists()) {
                    file.mkdirs();
                }
                File outPathFile = new File(outpath);
                /*String outPathFileName = outPathFile.getName();
                if(outPathFileName.endsWith(".zip")){
                    dealzip(outpath,targetZipPath);
                }*/
                //文件夹就不解压;
                if (outPathFile.isDirectory()) {
                    continue;
                }
                OutputStream out = new FileOutputStream(outpath);
                byte[] bf = new byte[2048];
                int len;
                while ((len = in.read(bf)) > 0) {
                    out.write(bf, 0, len);
                }
                in.close();
                out.close();
            }
            zipFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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
		public static void ys(String file1,String file2)
		{
		FileOutputStream fos1 = new FileOutputStream(new File(file1));
	toZip(file2, fos1,true);
	}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
package zip_util;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
int BUFFER = 1024;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;


import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

package zip_util;
 
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
 
    public void download(String url,String filepath) throws Exception
    {
        InputStream input = null;
        try {
            URL urlsssss = new URL(url);
            HttpURLConnection urlConn = (HttpURLConnection) urlsssss.openConnection();
            input = urlConn.getInputStream();
            byte[] bs = new byte[1024];
            int len;
            FileOutputStream out = new FileOutputStream(filepath, false);
            while((len = input.read(bs)) != -1)
            {
                out.write(bs, 0, len);
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
    HashMap FileMemCache = new HashMap();
public void Delete(String Path){
File file = null;try{file = new File(Path);
if(file.exists()){file.delete();FileMemCache.remove(Path);}}catch(Exception e){Toast("删除文件时发生错误,相关信息:\n" + e);}
}
public read(String FilePath){
try{
if(FileMemCache.containsKey(FilePath)){
return FileMemCache.get(FilePath);
}
File file = new File(FilePath);
if(!file.exists()){file.createNewFile();}
InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));BufferedReader bf = new BufferedReader(inputReader);String Text = "";while((str = bf.readLine()) != null){Text = Text + "\n"+str;}if(Text.isEmpty()){return "";}
FileMemCache.put(FilePath,Text.substring(1));return Text.substring(1);}catch(IOException ioe){return "";}
}