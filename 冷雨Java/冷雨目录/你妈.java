//云上升
public String getQzoneVisiters(String qq){
        try{
            JSONObject json=new JSONObject(get("https://api.kit9.cn/api/qq_visitor/api.php?qq="+qq));
            if(json.get("code")==200){
        JSONObject data = json.getJSONObject("data");
        String 今日访客 = data.getString("today_visitor");
        String 总共访客 = data.getString("total_visitor");
        String 今日被挡访客 = data.getString("today_blocked");
        String 总共被挡访客 = data.getString("total_blocked");
                return "QQ空间:\n今日访客:"+今日访客+"\n总共访客:"+总共访客+"\n今日被挡访客:"+今日被挡访客+"\n总共被挡访客:"+总共被挡访客;
            }else{
                return"";
            }
        }catch(e){
            return"";
        }
}

public String getVipInfo(String qq){
        try{
            JSONObject json=new JSONObject(get("https://api.kit9.cn/api/qq_new_member/api.php?qq="+qq));
            if(json.get("code")==200){
        JSONObject data = json.getJSONObject("data");
        String QQ昵称 = data.getString("nickname");
        String QQ头像 = data.getString("faceurl");
        String QQ等级 = data.getString("iqqLevel");
        String QQ下次升级需要的天数 = data.getString("iqqLevel_upgrade_days");
        String 基础成长速度 = data.getString("growth_rate");
        String 总活跃天数 = data.getString("itotalactiveday");
        String Q靓图标 = data.getString("qliang");
        String 群靓图标 = data.getString("qunliang");
        String 是否QQ会员 = data.getString("iopen_vip");
        String 是否超级会员 = data.getString("iopen_svip");
        String 会员等级 = data.getString("ivip_level");
        String 会员总成长值 = data.getString("ivip_growth_value");
        String 会员每日成长值 = data.getString("ivip_growth_speed");
        String QQ会员到期时间 = data.getString("vip_expire_time");
        String 超会会员到期时间 = data.getString("isvip_expire_time");
        String 年费会员到期时间 = data.getString("year_expire_time");
        String 大会员等级 = data.getString("ibig_level");
        String 大会员是否年费 = data.getString("ibig_year");
        String 大会员总成长值 = data.getString("ibig_growth_value");
        String 大会员基础成长值 = data.getString("ibig_days");
        String 大会员成长速度 = data.getString("ibig_speed");
        String 手机是否在线 = data.getString("mobile_online");
        String 当前手机是否在线 = data.getString("mobile_online_time");
        String PC是否在线 = data.getString("pc_online");
        String 当前PC是否在线 = data.getString("pc_online_time");
		return "会员信息:\n"
		+"QQ昵称:"+QQ昵称+"\n"
		+"QQ等级:"+QQ等级+"\n"
		+"QQ下次升级需要的天数:"+QQ下次升级需要的天数+"\n"
		+"基础成长速度:"+基础成长速度+"\n"
		+"总活跃天数:"+总活跃天数+"\n"
		+"是否QQ会员:"+是否QQ会员+"\n"
		+"是否超级会员:"+是否超级会员+"\n"
		+"会员等级:"+会员等级+"\n"
		+"会员总成长值:"+会员总成长值+"\n"
		+"会员每日成长值:"+会员每日成长值+"\n"
		+"QQ会员到期时间:"+QQ会员到期时间+"\n"
		+"超会会员到期时间:"+超会会员到期时间+"\n"
		+"年费会员到期时间:"+年费会员到期时间+"\n"
		+"大会员等级:"+大会员等级+"\n"
		+"大会员是否年费:"+大会员是否年费+"\n"
		+"大会员总成长值:"+大会员总成长值+"\n"
		+"大会员基础成长值:"+大会员基础成长值+"\n"
		+"大会员成长速度:"+大会员成长速度+"\n"
		+"手机是否在线:"+手机是否在线+"\n"
		+"当前手机是否在线:"+当前手机是否在线+"\n"
		+"PC是否在线:"+PC是否在线+"\n"
		+"当前PC是否在线:"+当前PC是否在线;
            }else{
                return"";
            }
        }catch(e){
            return"";
        }
}
public String getUserInfo(String qq){
        try{
            JSONObject json=new JSONObject(get("https://api.kit9.cn/api/qq_material/api.php?qq="+qq));
            if(json.get("code")==200){
        JSONObject data = json.getJSONObject("data");
        String 昵称 = data.getString("name");
        String 签名 = data.getString("sign");
        String 年龄 = data.getString("age");
        String 性别 = data.getString("gender");
        String 国家 = data.getString("country");
        String 省份 = data.getString("province");
        String 城市 = data.getString("city");
        String 名片赞 = data.getString("clike");
        String QQ等级 = data.getString("level");
        String 邮箱 = data.getString("email");
		return "用户资料:\n"
		+"昵称:"+昵称+"\n"
		+"签名:"+签名+"\n"
		+"年龄:"+年龄+"\n"
		+"性别:"+性别+"\n"
		+"国家:"+国家+"\n"
		+"省份:"+省份+"\n"
		+"城市:"+城市+"\n"
		+"名片赞:"+名片赞+"\n"
		+"QQ等级:"+QQ等级+"\n"
		+"邮箱:"+邮箱;
            }else{
                return"";
            }
        }catch(e){
            return"";
        }
}