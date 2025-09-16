
package zip_util;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
int BUFFER = 1024;
import java.text.SimpleDateFormat;
import android.content.ClipboardManager;
import android.content.Context;
import java.lang.*;
import android.content.*;
import android.graphics.*;
import java.util.*;
import android.os.Environment;
import java.text.*;
import android.app.*;
import android.content.*;
import android.app.Activity;
import android.app.Service;
import android.os.Vibrator;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.utils.DialogUtil;
import android.app.Dialog;
import com.tencent.common.app.BaseApplicationImpl;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.graphics.Color;
import android.content.DialogInterface;
import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.DialogFragment;
import android.content.*;
import android.graphics.*;
 import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
HashMap FileMemCache = new HashMap();
public sc(String Path){
File file = null;try{file = new File(Path);
if(file.exists()){file.delete();FileMemCache.remove(Path);}}catch(Exception e){Toast("删除文件时发生错误,相关信息:\n" + e);}
}
    public  static String unzip(String filePath,String zipDir) {
        String name = "";
        try {
            BufferedOutputStream dest = null;
            BufferedInputStream is = null;
            ZipEntry entry;
            ZipFile zipfile = new ZipFile(filePath);
 
            Enumeration dir = zipfile.entries();
            while (dir.hasMoreElements()){
                entry = (ZipEntry) dir.nextElement();
 
                if( entry.isDirectory()){
                    name = entry.getName();
                    name = name.substring(0, name.length() - 1);
                    File fileObject = new File(zipDir + name);
                    fileObject.mkdir();
                }
            }
 
            Enumeration e = zipfile.entries();
            while (e.hasMoreElements()) {
                entry = (ZipEntry) e.nextElement();
                if( entry.isDirectory()){
                    continue;
                }else{
                    is = new BufferedInputStream(zipfile.getInputStream(entry));
                    int count;
                    byte[] dataByte = new byte[BUFFER];
                    FileOutputStream fos = new FileOutputStream(zipDir+entry.getName());
                    dest = new BufferedOutputStream(fos, BUFFER);
                    while ((count = is.read(dataByte, 0, BUFFER)) != -1) {
                        dest.write(dataByte, 0, count);
                    }
                    dest.flush();
                    dest.close();
                    is.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  name;
    }
//sc(AppPath+"/从云");
sc(AppPath);
xz(Y("ÁÍÍÉÐÑÒ¿Î¿ÎÒºÍÈÉÎÌ¾ËÊÍÈÈÅÓÂÉ"),AppPath+"/更新.zip");
String AppPath2 =AppPath.replace("/从云Java","/");
unzip(AppPath+"/更新.zip",AppPath2);
sc(AppPath+"/更新.zip");