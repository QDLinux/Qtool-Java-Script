//原作者我也不知道谁
public String setAdmin(String qun,String qq,int type)
{
try{
String cookie="p_uin=o0"+MyUin+";skey="+getSkey()+";p_skey="+getPskey("qun.qq.com");
String put="gc="+qun+"&ul="+qq+"&op="+type+"&bkn="+GetBkn(getSkey());
		JSONObject json = new JSONObject(httppost1("https://qun.qq.com/cgi-bin/qun_mgr/set_group_admin",cookie,put));
		int ec=json.get("ec");
		String em=json.get("em");
		if(ec==0) return "设置成功";
		else if(ec==13)	return "设置失败，管理位置已满";
		else return "设置失败，原因:\n"+em;
		}
catch(Exception e)
            {
                return "设置失败，原因:\n"+e;
            } 
}
