






















//爱情是不讲理，又没道理的游戏。














































































public String get(String url)
{
StringBuffer buffer = new StringBuffer();
InputStreamReader isr = null;
try {
URL urlObj = new URL(url);
URLConnection uc = urlObj.openConnection();
//访问链接最大时间
uc.setConnectTimeout(10000);
//访问链接最大时间
uc.setReadTimeout(10000);
isr = new InputStreamReader(uc.getInputStream(), "utf-8");
BufferedReader reader = new BufferedReader(isr); //缓冲
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

private byte[] fileConvertToByteArray(File file) {
        byte[] data = null;
 
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
 
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
 
            data = baos.toByteArray();
 
            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return data;
    }
public static String sendPost(String url, byte[] data) throws Exception{
 
        HttpURLConnection con = null;
        BufferedReader in = null;
        try {
            String result = "";
            URL httpUrl = new URL(url);
            con = (HttpURLConnection) httpUrl.openConnection();
            con.setRequestMethod("POST");//设置POST请求
            con.setDoOutput(true);// 设置是否向httpUrlConnection输出
            con.setConnectTimeout(10000);//请求超时最大时间
            con.setReadTimeout(10000);
            OutputStream out = con.getOutputStream();
            out.write(data);
            out.flush();
            out.close();
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                in = new BufferedReader(new InputStreamReader(con
                        .getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
                return result;
            } else {
 
            }
 
        } catch (IOException e) {
 
            throw e;
        } finally {
            if (in != null) {
                try {
                    if (in != null)
                        in.close();
                } catch (IOException e) {
                }
            }
 
            if (con != null) {
                try{
                    con.getInputStream().close();
                } catch (Throwable e){
 
                }
                try{
                    con.getOutputStream().close();
                } catch (Throwable e){
 
                }
                con.disconnect();//
            }
        }
        return null;
    }