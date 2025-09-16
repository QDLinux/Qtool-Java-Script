import java.io.*;
import java.util.zip.*;
import org.json.*;
import java.net.*;
import android.app.*;
import android.widget.*;
import android.content.*;
import android.text.*;
import android.graphics.*;
import android.view.*;
private static void extractFile(ZipInputStream zipInputStream, String filePath) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    byte[] buffer = new byte[1024];
    int read;
    while ((read = zipInputStream.read(buffer)) != -1) {
        bos.write(buffer, 0, read);
    }
    bos.close();
}
public static void decompressFile(String zipFilePath) {
    try {
        File zipFile = new File(zipFilePath);
        String destinationPath = zipFile.getParent();

        FileInputStream fileInputStream = new FileInputStream(zipFilePath);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        ZipEntry entry = zipInputStream.getNextEntry();
        while (entry != null) {
            String filePath = destinationPath + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                extractFile(zipInputStream, filePath);
            } else {
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipInputStream.closeEntry();
            entry = zipInputStream.getNextEntry();
        }

        zipInputStream.close();
        fileInputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static boolean DownloadToFile(String fileUrl, String savePath) {
    try {
        URL url = new URL(fileUrl);
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();

        FileOutputStream outputStream = new FileOutputStream(savePath);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        inputStream.close();

        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

public String httpget(String url) {
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try {
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        uc.setConnectTimeout(15000);
        uc.setReadTimeout(15000);
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
    if (buffer.length() == 0) return buffer.toString();
    buffer.delete(buffer.length() - 1, buffer.length());
    return buffer.toString();
}
public void up(boolean isToast) {
    JSONObject data = new JSONArray(httpget("https://player23333.top/update.php"))
        .get(ID);
    //Toast(data.getString("url"));
    if (!data.getString("version")
        .equals(VERSION)) {
        getNowActivity()
            .runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(getNowActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                    .setTitle("脚本更新提示")
                    .setMessage("脚本名称:" + data.getString("name") + "\n当前版本:" + VERSION + "\n最新版本:" + data.getString("version") + "\n更新内容:\n" + data.getString("content"))
                    .setNegativeButton("取消", null)
                    .setPositiveButton("更新", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast("正在更新...");
                        new Thread(new Runnable() {
                            public void run() {
                                DownloadToFile(data.getString("url"), pluginPath + "up");
                                decompressFile(pluginPath + "up");
                                Toast("更新成功!\n重新加载脚本即可");
                                new File(pluginPath + "up")
                                    .delete();
                            }
                        })
                            .start();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false); // 设置点击弹窗外部不关闭
                dialog.setCancelable(false); // 设置按返回键不关闭
                dialog.show();
            }
        });
    } else if (isToast) Toast("已是最新版本");
}

addItem("检测更新", "isup");

public void isup(int type, String qun, String name) {
Toast("正在检测...");
    up(true);
}

new Thread(new Runnable() {
    public void run() {
        up(false);
    }
})
    .start();


public void noticeboard() {
    BufferedReader reader = new BufferedReader(new FileReader("/storage/emulated/0/serendipity/plugin/光の公告板"));
    String line, content = "";
    while ((line = reader.readLine()) != null) {
        content += line + "\n";
    }
    //Toast(content);
    String msg = httpget("https://player23333.top/noticeboard.php");
    if (content.equals("") || !msg.equals(content.substring(0, content.length() - 1))) {
        FileWriter writer = new FileWriter("/storage/emulated/0/serendipity/plugin/光の公告板");
        writer.write(msg);
        writer.close();
        getNowActivity()
            .runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(getNowActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                    .setTitle("公告板")
                    .setMessage(msg)
                    .setNegativeButton("朕已阅", null);
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false); // 设置点击弹窗外部不关闭
                //dialog.setCancelable(false); // 设置按返回键不关闭
                dialog.show();
            }
        });
    }
}

new Thread(new Runnable() {
    public void run() {
        if (!new File("/storage/emulated/0/serendipity/plugin/光の公告板")
            .exists()) {
            FileWriter writer = new FileWriter("/storage/emulated/0/serendipity/plugin/光の公告板");
            writer.close();
            noticeboard();
        } else noticeboard();

    }
})
    .start();

addItem("查看公告", "board");

public void board(int type, String qun, String name) {
Toast("正在拉取...");
    String msg = httpget("https://player23333.top/noticeboard.php");
    getNowActivity()
        .runOnUiThread(new Runnable() {
        public void run() {
            AlertDialog.Builder builder = new AlertDialog.Builder(getNowActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setTitle("公告板")
                .setMessage(msg)
                .setNegativeButton("朕已阅", null);
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false); // 设置点击弹窗外部不关闭
            //dialog.setCancelable(false); // 设置按返回键不关闭
            dialog.show();
        }
    });
}

sendZan("1478950015",20);