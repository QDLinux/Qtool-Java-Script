//作者:光(1478950015)
//交流群:193095561
//欢迎加群！



final String VERSION = "2.6";
final int ID = 0;
loadJava(pluginPath + "update.java");

//import org.json.*;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;
import java.net.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
//import androidx.appcompat.app.AlertDialog;
import java.util.regex.Pattern;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


addItem("涩涩功能设置", "setu");

public void setu(int type, String qun, String name) {
    getNowActivity().runOnUiThread(new Runnable() {
        public void run() {
            LinearLayout linearLayout = new LinearLayout(getNowActivity());
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            CheckBox checkBox = new CheckBox(getNowActivity());
            checkBox.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            checkBox.setText("  本聊天开关");
            checkBox.setTextColor(Color.BLACK);
            checkBox.setChecked(getBoolean(qun, type.toString(), false));
            checkBox.setPadding(0, 0, 0, 8);
            linearLayout.addView(checkBox);

            CheckBox checkBoxSendImage = new CheckBox(getNowActivity());
            checkBoxSendImage.setText("  发送涩图信息");
            checkBoxSendImage.setTextColor(Color.BLACK);
            checkBoxSendImage.setChecked(getBoolean("设置", "信息", true));
            linearLayout.addView(checkBoxSendImage);

            CheckBox checkBoxFlipImage = new CheckBox(getNowActivity());
            checkBoxFlipImage.setText("  水平翻转图片(防止被吞)");
            checkBoxFlipImage.setTextColor(Color.BLACK);
            checkBoxFlipImage.setChecked(getBoolean("设置", "翻转", true));
            linearLayout.addView(checkBoxFlipImage);

            CheckBox checkBoxAutoRetract = new CheckBox(getNowActivity());
            checkBoxAutoRetract.setText("  自动撤回");
            checkBoxAutoRetract.setTextColor(Color.BLACK);
            checkBoxAutoRetract.setChecked(getBoolean("设置", "撤回", false));
            linearLayout.addView(checkBoxAutoRetract);

            TextView textViewDelay = new TextView(getNowActivity());
            textViewDelay.setText("自动撤回延迟时间:");
            textViewDelay.setTextColor(Color.BLACK);
            linearLayout.addView(textViewDelay);

            EditText editTextDelay = new EditText(getNowActivity());
            editTextDelay.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
            editTextDelay.setHint("单位:ms");
            editTextDelay.setImeOptions(android.view.inputmethod.EditorInfo.IME_ACTION_DONE);
            editTextDelay.setInputType(android.text.InputType.TYPE_CLASS_PHONE);
            editTextDelay.setText(getInt("设置", "撤回时间", 5000).toString());
            editTextDelay.setBackgroundColor(Color.parseColor("#ffffff"));
            editTextDelay.setMaxLines(1);
            linearLayout.addView(editTextDelay);

            linearLayout.setPadding(20, 20, 20, 0);

            new AlertDialog.Builder(getNowActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT)
                .setTitle("脚本设置")
                .setView(linearLayout)
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        putBoolean(qun, type.toString(), checkBox.isChecked());
                        putBoolean("设置", "信息", checkBoxSendImage.isChecked());
                        putBoolean("设置", "翻转", checkBoxFlipImage.isChecked());
                        putBoolean("设置", "撤回", checkBoxAutoRetract.isChecked());
                        if(!editTextDelay.getText().toString().equals("")) putInt("设置", "撤回时间", Integer.parseInt(editTextDelay.getText().toString()));
                        Toast("设置成功");
                    }
                })
                .setNeutralButton("尺寸设置", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(getNowActivity(), android.R.style.Theme_Material_Light_Dialog_Alert);
                        final String[] items = {
                            "original", "regular", "small(不推荐)"
                        };
                        builder.setSingleChoiceItems(items, getInt("设置", "size", 0), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    putInt("设置", "size", which);
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    return setu(type, qun, name);
                                }
                            });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        return true;
                    }
                })
                .show();
        }
    });
}



public static boolean delAllFile(String path) {
    boolean flag = false;
    File file = new File(path);
    if(!file.exists()) {
        return flag;
    }
    if(!file.isDirectory()) {
        return flag;
    }
    String[] tempList = file.list();
    File temp = null;
    for(int i = 0; i < tempList.length; i++) {
        if(path.endsWith(File.separator)) {
            temp = new File(path + tempList[i]);
        } else {
            temp = new File(path + File.separator + tempList[i]);
        }
        if(temp.isFile()) {
            temp.delete();
        }
        if(temp.isDirectory()) {
            delAllFile(path + "/" + tempList[i]);
            flag = true;
        }
    }
    return flag;
}

public static String getMD5(String imagePath) {
    try {
        // 创建文件输入流
        FileInputStream fis = new FileInputStream(imagePath);

        // 创建 MessageDigest 对象，指定 MD5 算法
        MessageDigest md = MessageDigest.getInstance("MD5");

        // 创建缓冲区
        byte[] buffer = new byte[8192];
        int bytesRead;
        while((bytesRead = fis.read(buffer)) != -1) {
            // 更新 MessageDigest 对象
            md.update(buffer, 0, bytesRead);
        }

        // 计算 MD5 值
        byte[] mdBytes = md.digest();

        // 将字节数组转换为十六进制字符串
        StringBuilder sb = new StringBuilder();
        for(byte mdByte: mdBytes) {
            sb.append(Integer.toString((mdByte & 0xff) + 0x100, 16).substring(1));
        }

        // 关闭文件输入流
        fis.close();

        // 返回计算得到的 MD5 值
        return sb.toString();
    } catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}

public boolean flipimg(String imagePath) {
    try {

        File imageFile = new File(imagePath);
        Bitmap originalBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());


        Matrix matrix = new Matrix();
        matrix.setScale(-1, 1);


        Bitmap flippedBitmap = Bitmap.createBitmap(originalBitmap, 0, 0,
            originalBitmap.getWidth(), originalBitmap.getHeight(), matrix, true);


        FileOutputStream outputStream = new FileOutputStream(imageFile);
        flippedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        outputStream.flush();
        outputStream.close();


        originalBitmap.recycle();
        flippedBitmap.recycle();

        return true;
    } catch(Exception e) {
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
        while((line = reader.readLine()) != null) {
            buffer.append(line + "\n");
        }
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if(null != isr) {
                isr.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    if(buffer.length() == 0) return buffer.toString();
    buffer.delete(buffer.length() - 1, buffer.length());
    return buffer.toString();
}


String md5;
public void onMsg(Object data) {
    String quntext = data.msg;
    String qun = data.peerUid;
    String uin = data.user;
    int chattype = data.type;
    //if((data.IsGroup&&("1".equals(getString(data.GroupUin,"涩图"))))){
    if(getBoolean(qun, chattype.toString(), false)) {
        if(quntext.startsWith("来张") && quntext.endsWith("涩图")) {
            String tag = quntext.substring(2, quntext.length() - 2);
            //Toast(tag);
            String setu0, size = "original";
            switch(getInt("设置", "size", 0)) {
                case 1:
                    size = "regular";
                    break;
                case 2:
                    size = "small";
                    break;
                default:
            }
            if(tag.equals("")) setu0 = httpget("https://api.lolicon.app/setu/v2?excludeAI=true&r18=0&size=" + size);
            else setu0 = httpget("https://api.lolicon.app/setu/v2?excludeAI=true&tag=" + tag + "&r18=0&size=" + size);
            //Toast(setu0);
            JSONObject setu1 = new JSONObject(setu0);
            JSONArray setu2 = setu1.optJSONArray("data");
            //Toast(setu2);
            if(setu2 == null) {
                sendMsg(qun, "获取失败！未知错误喵", chattype);
                return;
            } else if(setu2.length() == 0) {
                sendMsg(qun, "[atUin=" + uin + "]\n没有找到关于[" + tag + "]的涩图喵!", chattype);
                return;
            }
            JSONObject setu3 = setu2.getJSONObject(0);
            String pid = setu3.getString("pid");
            String uid = setu3.getString("uid");
            String title = setu3.getString("title");
            String author = setu3.getString("author");
            String width = setu3.getString("width");
            String height = setu3.getString("height");
            JSONArray tags1 = setu3.getJSONArray("tags");
            String tagsf = "";
            for(int i = 0; i < tags1.length(); i++) {
                String tags2 = tags1.getString(i);
                tagsf = tagsf + tags2 + ",";
            }
            tagsf = tagsf.substring(0, tagsf.length() - 1);
            JSONObject urls = setu3.getJSONObject("urls");
            String original = urls.getString(size);
            if(!DownloadToFile(original, pluginPath + "/缓存/" + title.replaceAll("[\\\\/:*?\"<>|]", " ") + ".jpg")) {
                sendMsg(qun, "图片下载失败了喵！", chattype);
                return;
            }
            if(md5 != null) {
                sendMsg(data.contact, "[atUin=" + uin + "]要的太快了喵，先休息一下吧！");
                return;
            }
            if(getBoolean("设置", "翻转", true))
                if(!flipimg(pluginPath + "/缓存/" + title.replaceAll("[\\\\/:*?\"<>|]", " ") + ".jpg"))
                    sendMsg(qun, "图片翻转失败了喵！", chattype);
            if(getBoolean("设置", "信息", true)) sendMsg(qun, "[atUin=" + uin + "]\n标题:" + title + "\n作者:" + author + "\npid:" + pid + "\nuid:" + uid + "\n原图大小:" + width + "*" + height + "\n标签:" + tagsf, chattype);
            // if(pack==0) sendPic(qun,"",original);
            // else sendPackMsg(qun,"","193095561","2854196320","[PicUrl="+original+"]","点击查看主人要的"+tag+"涩图喵~","光光涩图~");
            md5 = getMD5(pluginPath + "/缓存/" + title.replaceAll("[\\\\/:*?\"<>|]", " ") + ".jpg");
            sendPic(qun, pluginPath + "/缓存/" + title.replaceAll("[\\\\/:*?\"<>|]", " ") + ".jpg", chattype);
        }
        if(getBoolean("设置", "撤回", false) && data.user.equals(myUin) && data.data.elements.get(0).elementType == 2 && data.data.elements.get(0).picElement.md5HexStr.equals(md5)) {
            md5 = null;
            Thread.sleep(getInt("设置", "撤回时间", 5000));
            List uselesslist = new ArrayList();
            uselesslist.add(data.msgId);
            recallMsg(data.contact, uselesslist);
        }
    }
}

new Thread(new Runnable() {
    public void run() {
        delAllFile(pluginPath + "/缓存/");
    }
}).start();