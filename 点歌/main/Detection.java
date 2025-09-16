
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public void Detection(String msg,String url,String version){
Activity act = GetAct();
act.runOnUiThread(new Runnable()
{
public void run()
{
TextView editText = new TextView(act);
editText.setText(msg);
editText.setTextSize(15);
editText.setPadding(20,15,20,0);
editText.setTextColor(Color.parseColor("#000000"));
LinearLayout cy=new LinearLayout(act);
cy.setOrientation(LinearLayout.VERTICAL);
cy.addView(editText);
new AlertDialog.Builder(act, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT).setTitle("V"+version+"版本更新").setView(cy).setPositiveButton("取消", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
}}).setNegativeButton("更新", new DialogInterface.OnClickListener()
{
public void onClick(DialogInterface dialogInterface, int i)
{
ts3("开始更新...");
String file=Mpath+"/download.zip";
new Thread(new Runnable(){
public void run(){
try{
download(url,file);
unzip(file,Mpath.replace("点歌","").replace("//","/"));
ts("更新完成,重新加载即可");
File f1=new File(file);
f1.delete();
}catch(e){
ts("更新错误\n"+e);
}
OK=false;
}}).start();
}}).setCancelable(false).show();
}});
}
public void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        FileInputStream fis = new FileInputStream(zipFilePath);
        ZipInputStream zipInputStream = new ZipInputStream(fis);

        ZipEntry entry;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            String entryName = entry.getName();
            String filePath = destDirectory + File.separator + entryName;

            if (!entry.isDirectory()) {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));

                byte[] bytesIn = new byte[4096];
                int read;
                while ((read = zipInputStream.read(bytesIn)) != -1) {
                    bos.write(bytesIn, 0, read);
                }

                bos.close();
            } else {
                File dir = new File(filePath);
                dir.mkdirs();
            }
            zipInputStream.closeEntry();
        }

        zipInputStream.close();
        fis.close();
    }