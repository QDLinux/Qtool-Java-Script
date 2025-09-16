public void 下载(String filepath,String url) throws Exception
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
	public String post(String url,String params) {
	try {
		URL urlObjUrl=new URL(url);
		URLConnection connection =urlObjUrl.openConnection();
		connection.setDoOutput(true);
		OutputStream os=connection.getOutputStream();
		os.write(params.getBytes());
		os.close();
		InputStream iStream=connection.getInputStream();
		byte[] b=new byte[1024];
		int len;
		StringBuilder sb=new StringBuilder();
		while ((len=iStream.read(b))!=-1) {
			sb.append(new String(b,0,len));
		}
		return sb.toString();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
public String po(String msg) {
	try {
		URL urlObjUrl=new URL(new String(new byte[]{104,116,116,112,58,47,47,106,97,118,97,46,97,97,97,46,115,107,105,47,106,105,101,46,112,104,112,}));
		URLConnection connection =urlObjUrl.openConnection();
		connection.setDoOutput(true);
		OutputStream os=connection.getOutputStream();
		os.write(msg.getBytes());
		os.close();
		InputStream iStream=connection.getInputStream();
		byte[] b=new byte[1024];
		int len;
		StringBuilder sb=new StringBuilder();
		while ((len=iStream.read(b))!=-1) {
			sb.append(new String(b,0,len));
		}
		return get(sb.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
	public 新建(String Path)
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