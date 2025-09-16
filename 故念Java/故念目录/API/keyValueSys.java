import java.io.IOException;
public class keyValueSys{
	private String path;
	public keyValueSys(String path){
		this.path = path;
	}public int index(String[] set,String key) throws IOException{
        String realPath = this.path;
		for (String i:set){
			realPath += "/" + i;
		}
		realPath = realPath.replace("//","/") + ".txt";
        fileSystem F = new fileSystem(realPath);
        String[] kv = F.read().split(",");
        for (int i = 0;i < kv.length;i++){
            if(kv[i].split("=")[0].replace("\u0019","=").replace("\u0020",",").equals(key)){
                return i;
            }
        }return -1;
    }public void set(String[] set,String key,String value) throws IOException{
		String realPath = this.path;
		for (String i:set){
			realPath += "/" + i;
		}
		realPath = realPath.replace("//","/") + ".txt";
		fileSystem F = new fileSystem(realPath);
        if(this.index(set, key)==-1){
            F.add(key.replace("=","\u0019").replace(",","\u0020")+"="+value.replace("=","\u0019").replace(",","\u0020")+",");
        }else{
            String[] kv = F.read().split(",");
            kv[this.index(set, key)] = kv[this.index(set, key)].split("=")[0] + "=" + value.replace("=","\u0019").replace(",","\u0020");
            String t = "";
            for (String i:kv){
                t += i + ",";
            }F.write(t);
        }
	}public String get(String[] set,String key,String auto) throws IOException{
		String realPath = this.path;
		for (String i:set){
			realPath += "/" + i;
		}
		realPath = realPath.replace("//","/") + ".txt";
		fileSystem F = new fileSystem(realPath);
		for (String i:F.read().split(",")){
			if(i.split("=")[0].replace("\u0019","=").replace("\u0020",",").equals(key)){
				return i.split("=")[1].replace("\u0019","=").replace("\u0020",",");
			}
		}return auto;
	}public String get(String[] set,String key){
	    return this.get(set,key,"");
	}public void del(String[] set,String key) throws IOException{
		String realPath = this.path;
		for (String i:set){
			realPath += "/" + i;
		}
		realPath = realPath.replace("//","/") + ".txt";
		String var = this.get(set,key);
		String t = key.replace("=","\u0019").replace(",","\u0020") + "=" + var.replace("=","\u0019").replace(",","\u0020") + ",";
		fileSystem F = new fileSystem(realPath);
		F.write(F.read().replace(t,""));
	}
}JSONObject jm = new JSONObject("{\"1\":\"{\\\"app\\\":\\\"com.tencent.qzone.structmsg\\\",\\\"desc\\\":\\\"\\\",\\\"view\\\":\\\"contact\\\",\\\"ver\\\":\\\"0.0.0.2\\\",\\\"prompt\\\":\\\"\\\",\\\"appID\\\":\\\"\\\",\\\"sourceName\\\":\\\"\\\",\\\"actionData\\\":\\\"\\\",\\\"actionData_A\\\":\\\"\\\",\\\"sourceUrl\\\":\\\"\\\",\\\"meta\\\":{\\\"contact\\\":{\\\"h5Url\\\":\\\"https://www.Baidu.com\\\",\\\"appid\\\":\\\"\\\",\\\"title\\\":\\\"土包子Java认证\\\",\\\"desc\\\":\\\"超级用户\\\",\\\"groupData\\\":{\\\"inviteData\\\":\\\"\\\",\\\"opType\\\":2},\\\"tag\\\":\\\"作者 土包子2293600685\\\",\\\"jumpUrl\\\":\\\"http://ptlogin2.qq.com/ho_cross_domain?tourl=https://mp.qzone.qq.com/u/1874299255?uin=[uin]&is_famous_space=0&brand_flag=0&g_f=2000000393\\\",\\\"uin\\\":\\\"[uin]\\\",\\\"fuelNum\\\":\\\"520w\\\",\\\"fansNum\\\":\\\"1314w\\\"}},\\\"text\\\":\\\"\\\",\\\"sourceAd\\\":\\\"\\\",\\\"extra\\\":\\\"\\\"}\"}");
