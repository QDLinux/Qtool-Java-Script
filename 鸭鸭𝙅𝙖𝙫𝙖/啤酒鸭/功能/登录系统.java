String ttttt = "";
public void zl_playskey(Object msg, String mc, String mg, String mn, String mu) {
    if (Lshost.contains(mu)) {
        if (mc.equals("开启登录") || mc.equals("开启扫码")) {
            if (开关.读("登录", mg) == 1) {
                toast(repeat_ + "登录", 1500);
            } else {
                开关.写("登录", mg, 1);
                toast(repeat_t + "登录", 1500);
            }
        }
        if (mc.equals("关闭登录") || mc.equals("关闭扫码")) {
            if (开关.读("登录", mg) == 0) {
                toast(_repeat + "登录", 1500);
            } else {
                开关.写("登录", mg, 0);
                toast(t_repeat + "登录", 1500);
            }
        }
    }
    if (开关.读("登录", mg) == 0) return;
    if (mc.equals("申请空间码") || mc.equals("登录空间") || mc.equals("申请二维码")) {
        getcookie(msg, "qzone.qq.com");
    }
    if (mc.equals("申请会员码") || mc.equals("登录会员")) {
        getcookie(msg, "vip.qq.com");
    }
    if (mc.equals("申请群码") || mc.equals("登录群")) {
        getcookie(msg, "qun.qq.com");
    } //if(!mu.equals(MyUin))return;
    if (mc.contains("特别关心") && mc.length() < 7) {
        String v = mc.replace("特别关心", "");
        String xkc = "查询.我的.获取";
        if (v.equals("") || xkc.contains(v)) {
            try {
                String skey = "";
                String pskey = "";
                if (mu.equals(MyUin)) {
                    skey = getSkey();
                    pskey = getPskey("qzone.qq.com");
                } else {
                    String a = MyFile.ReadFile(Root + "数据/qzone.qq.com/" + mu + ".txt");
                    skey = JSON解析(a, "", "skey").replace("@", "");
                    pskey = JSON解析(a, "", "p_skey");
                }
                if (skey.equals("") || pskey.equals("")) {
                    getcookie(msg, "qzone.qq.com");
                    return;
                }
                String str = http.get("https://cloud.qqshabi.cn/api/care.php?uin=" + mu + "&skey=" + skey + "&pskey=" + pskey);
                if (str.contains("SK")) {
                    getcookie(msg, "qzone.qq.com");
                    return;
                }
                String l = "昵称：" + mn + 头像(mu, 2) + "\nQQ：(" + mu + ")\n是" + JSON解析(str, "", "count") + "人的特别关心哦";
                文字(msg, l);
            } catch (e) {
                回复(msg, "接口异常\n请稍后再试");
            }
        }
    }
    if (mc.startsWith("修改昵称")) {
        String skey = "";
        try {
            String j = "";
            if (mc.length() == 4) {
                回复(msg, 头像(mu, 3) + "请后续输入昵称哦");
                return;
            }
            String name = mc.substring(4);
            if (mu.equals(MyUin)) {
                skey = getSkey();
            } else {
                String a = MyFile.ReadFile(Root + "数据/qzone.qq.com/" + mu + ".txt");
                skey = JSON解析(a, "", "skey");
            }
            if (skey.equals("")) {
                getcookie(msg, "qzone.qq.com");
                return;
            }
            String str = http.get("http://lkaa.top/API/qzl/api.php?qq=" + mu + "&s=" + skey + "&name=" + name);
            if (str.contains("成")) {
                j = "成功";
            } else {
                j = "失败";
            }
            文字(msg, 头像(mu, 3) + j);
        } catch (e) {
            回复(msg, "接口异常\n请稍后再试");
        }
    }
    if (mc.equals("我的业务")) {
        //改写自卑微萌新
        String skey = "";
        if (!mu.equals(MyUin)) {
            String a = MyFile.ReadFile(Root + "数据/qzone.qq.com/" + mu + ".txt");
            skey = JSON解析(a, "", "skey");
        } else {
            skey = getSkey();
        }
        if (skey.equals("")) {
            getcookie(msg, "qzone.qq.com");
            return;
        }
        String result = "";
        String cookie = "uin=o0" + mu + ";skey=" + skey;
        String data = mu + "&openkey=" + skey + "&session_id=uin&session_type=skey";
        String api = "https://api.unipay.qq.com/v1/r/1450000172/wechat_query?cmd=7&pfkey=pfkey&openid=";
        JSONObject json = new JSONObject(httpget(api + data, cookie));
        int ret = json.get("ret");
        if (ret == 1081) {
            result = "";
        } else if (ret == 0) {
            JSONArray j = json.getJSONArray("service");
            for (int i = 0; i < j.length(); i++) {
                JSONObject y = j.get(i);
                String name = y.get("service_name");
                String start = y.get("start_time");
                String end = y.get("end_time");
                result += "\n\n" + name + "\n" + countdown(start, end) + "\n开通时间:" + start + "\n过期时间:" + end;
            }
        } else {
            result = "没有业务记录";
        }
        if (!result.equals("")) {
            文字(msg, 头像(mu, 2) + result.replaceFirst("\n", ""));
        } else {
            getcookie(msg, "qzone.qq.com");
        }
    }
    if (mc.equals("码")) {
        try {
            String time = new Date().getTime() + "";
            URLConnection R = new URL("https://ssl.ptlogin2.qq.com/ptqrshow?appid=716027609&e=2&l=M&s=3&d=72&v=4&t=0.79122108" + time + "&daid=383&pt_3rd_aid=101487368").openConnection();
            /*		R.setRequestProperty("Connection","keep-alive");
            R.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");
            R.setRequestProperty("Accept-Encoding","gzip,deflate,sdch");
            */
            R.setRequestProperty("cookie", "pgv_info=ssid=s6170680730; pgv_pvid=2756158800; pac_uid=0_d5e6aff8e23ba; iip=0; ariaDefaultTheme=null; pt_login_sig=OsR4T7KcyDXbhdXXOgr5VVHPP4PF1MwN63pMmIj8VGhyACdGT6PqTvfOKKJ2WVAI; pt_clientip=0653741cc675fce3; pt_serverip=dddf09958274b7c9; pt_local_token=-1524188088; uikey=f6f8444a22ea0f4e661bf5201c6d6d5e9c29533d1f0a87f3e66060887cbcf4e4; pt_guid_sig=5c5c0bdee34be90acd00ba3c06c5dbacbec999df2bd4c1883ea8fd58b196deb1; _qpsvr_localtk=0.43101279514108093; qrsig=ae18dff505d612cf390c0db52d9dd3acc04bf47a974f5e882f9af879e4f9e78d7cbd209aca02bc9331e91831df095c93b4a53d4ced605863c2052d4654435f2f");
            R.setRequestProperty("Referer", "https://xui.ptlogin2.qq.com/cgi-bin/xlogin?appid=716027609&daid=383&style=33&login_text=%E7%99%BB%E5%BD%95&hide_title_bar=1&hide_border=1&target=self&s_url=https%3A%2F%2Fgraph.qq.com%2Foauth2.0%2Flogin_jump&pt_3rd_aid=101487368&pt_feedback_link=https%3A%2F%2Fsupport.qq.com%2Fproducts%2F77942%3FcustomInfo%3Dwww.qq.com.appid101487368&theme=2&verify_theme=");
            R.setRequestProperty("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/537.36 (KHTML, like Gecko) Safari/537.36 VivoBrowser/12.9.0.3 Chrome/87.0.4280.141");
            R.connect();
            String L = "" + R;
            ttttt = R.getHeaderField("Set-Cookie").split(";")[0] + ";";
            String tu = L.replace("com.android.okhttp.internal.huc.HttpURLConnectionImpl:", "");
            L = L.replace("com.android.okhttp.internal.huc.HttpURLConnectionImpl:", "") + "\n\n" + ttttt;
            文字(msg, L);
        } catch (Exception e) {}
    }
    if (mc.equals("yl")) {
        String time = new Date().getTime() + "";
        URLConnection R = new URL("https://ssl.ptlogin2.qq.com/ptqrlogin?u1=https%3A%2F%2Fgraph.qq.com%2Foauth2.0%2Flogin_jump&ptqrtoken=1179179656&ptredirect=0&h=1&t=1&g=1&from_ui=1&ptlang=2052&action=3-0-1670544143594&js_ver=22112816&js_type=1&login_sig=OsR4T7KcyDXbhdXXOgr5VVHPP4PF1MwN63pMmIj8VGhyACdGT6PqTvfOKKJ2WVAI&pt_uistyle=40&aid=716027609&daid=383&pt_3rd_aid=101487368&&o1vId=26cfec439f8ff643a7d76113344d7709&pt_js_version=v1.38.0").openConnection();
        R.setRequestProperty("Host", "ssl.ptlogin2.qq.com");
        R.setRequestProperty("cookie", "qrsig=" + ttttt);
        R.setRequestProperty("Referer", "https://xui.ptlogin2.qq.com/");
        R.setRequestProperty("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/537.36 (KHTML, like Gecko) Safari/537.36 VivoBrowser/12.9.0.3 Chrome/87.0.4280.141");
        R.connect();
        String L = "" + R;
        String tu = L.replace("com.android.okhttp.internal.huc.HttpURLConnectionImpl:", "");
        L = L.replace("com.android.okhttp.internal.huc.HttpURLConnectionImpl:", "");
        文字(msg, L + "\n\n\n" + ttttt);
    }
    if (mc.equals("一键签到")) {
        try {
            String skey = "";
            String pskey = "";
            if (!mu.equals(MyUin)) {
                String a = MyFile.ReadFile(Root + "数据/vip.qq.com/" + mu + ".txt");
                skey = JSON解析(a, "", "skey");
                if (skey.equals("")) {
                    getcookie(msg, "vip.qq.com");
                    return;
                }
                pskey = JSON解析(a, "", "p_skey");
            } else {
                skey = getSkey();
                pskey = getPskey("vip.qq.com");
            }
            String api = "https://api.linhun.vip/api/Signin?";
            String cookie = "qq=" + mu + "&skey=" + skey + "&p_skey=" + pskey;
            文字(msg, "@" + mn + "请稍等几秒...");
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String data = http.get(api + cookie);
                        String tal = "";
                        if (data.contains("null")) {
                            getcookie(msg, "vip.qq.com");
                            return;
                        }
                        JSONObject ta = new JSONObject(data);
                        String tal = "";
                        for (int i = 0; i < 27; i++) {
                            String x = ta.get(i + "");
                            if (x.contains("SKEY") || x.contains("失败")) {
                                x = "";
                            } else {
                                x = msgArr(x, 12);
                            }
                            tal += x;
                        }
                        文字(msg, 头像(mu, 2) + tal);
                    } catch (Exception e) {
                        return;
                    }
                }
            }).start();
        } catch (e) {}
    }
    /* if(mc.equals("等级成长")){
            String skey="";
            if(mu.equals(MyUin)){
                skey=getSkey();
            }else{
                String a=MyFile.ReadFile(Root+"数据/qzone.qq.com/"+mu+".txt");
                skey=JSON解析(a,"","skey");
            }if(skey.equals("")){
                getcookie(msg,"qzone.qq.com");
                return;
            }JSONObject d=new JSONObject(http.get("https://api.uomg.com/api/get.qqdj?qq="+mu+"&skey="+skey));
            JSONObject c=d.get("info");
            String name=c.get("nickname");
            String tou=头像(mu,2);
            String vip=c.get("vip-level");
            String level=c.get("level");
            文字(msg,头像(mu,3)+d);
        }*/
    if (mc.startsWith("设置铭牌")) {
        String skey = "";
        String pskey = "";
        String token = "";
        if (mu.equals(MyUin)) {
            skey = getSkey();
            pskey = getPskey("vip.qq.com");
            token = getPT4Token("vip.qq.com");
        } else {
            String a = MyFile.ReadFile(Root + "数据/vip.qq.com/" + mu + ".txt");
            skey = JSON解析(a, "", "skey");
            if (skey.equals("")) {
                getcookie(msg, "vip.qq.com");
                return;
            }
            pskey = JSON解析(a, "", "p_skey");
            token = JSON解析(a, "", "pt4_token");
        }
        String id = mc.replaceAll("\\D", "");
        if (id.length() != 5) {
            回复(msg, "[PicUrl=http://gchat.qpic.cn/gchatpic_new/0/0-0-D827C9EF80C38B62D2244408BCF61573/0?term=2]\n回复：设置铭牌+ID\n例如：设置铭牌20070\nPS:请申请会员码");
            return;
        }
        if (id.matches("^[0-9]*$")) {
            String url = setnameplate(mu, skey, pskey, token, id);
            if (url.contains("失")) {
                getcookie(msg, "vip.qq.com");
                return;
            }
            if (url.startsWith("u")) url = "请确认是否登录\n或者查看ID是否正确";
            回复(msg, url);
        }
    }
    /* if(mc.startsWith("等级成长")){
            String skey="";
            String pskey="";
            if(!mu.equals(mQQ)){
                String a=MyFile.ReadFile(Root+"数据/vip.qq.com/"+mu+".txt");
                skey=JSON解析(a,"","skey");
                skey=JSON解析(a,"","p_skey");
            }else{
                skey=Skey;
                pskey=Pskey_vip;
            }Object j=getQQLevel(mu,skey,pskey);
            if(j.toString().contains("失")){
                getcookie(msg,"vip.qq.com");
                return;
            }String sNickName=j.optString("sNickName");
            //昵称
            String sFaceUrl=j.optString("sFaceUrl");
            //头像链接
            String iNextLevelDay=j.optString("iNextLevelDay");
            //正常下一等级剩余天数
            String iRealDays=j.optString("iRealDays");
            //今日成长
            String iQQLevel=j.optString("iQQLevel");
            //QQ等级
            String iYearVip=j.optString("iYearVip");
            //是否为年费
            String iVipLevel=j.optString("iVipLevel");
            //VIP等级
            /*"QzoneVisitor": "空间访问加速","SVIPStar": "SVIPStar加速","WeishiVideoview": "微视观看加速","iBaseDays": "基础活跃天数","iBigClubGrowth": "大会员成长","iBigClubLevel": "大会员等级","iBigClubSpeed": "大会员速度","iBigClubVipFlag": "大会员标志","iCmshowActive": "厘米秀加速","iCostMs": "没用","iMaxLvlRealDays": "不知道","iMaxLvlTotalDays": "电脑上显示年费最高天数","iMedal": "不知道","iMobileGameOnline": "手游加速","iMobileQQOnline": "手Q在线加速","iMobileQQOnlineTime": "手Q在线时间","iMqing": "不知道","iNextLevelDay": "正常下一等级剩余天数","iNoHideOnline": "非隐身加速","iNoHideOnlineTime": "非隐身时间","iPCQQOnline": "电脑QQ在线加速","iPCQQOnlineTime": "电脑QQ在线时间","iPCSafeOnline": "电脑腾讯管家在线","iQQLevel": "QQ等级","iQQSportStep": "QQ运动加速","iRealDays": "今日总成长","iSVip": "是否svip","iSpeedType": "加速类型","iSqq": "不知道","iSqqLevel": "不知道","iSqqSpeedRate": "不知道","iSvrDays": "不知道","iTotalActiveDay": "总共活跃天数","iTotalDays": "手机上显示年费最高","iVip": "是否vip","iVipLevel": "vip等级","iVipSpeedRate": "今日等级加速倍数*10","iYearBigClubFlag": "年大会员标志","iYearVip": "年费","sFaceUrl": "头像链接","sNickName": "昵称" */
}
public String countdown(String time, String time2) {
    try {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        /*天数差*/
        Date fromDate = simpleFormat.parse(simpleFormat.format(calendar.getTime()));
        Date toDate = simpleFormat.parse(time);
        long from = fromDate.getTime();
        long to = toDate.getTime();
        int days = (int)((to - from) / (1000 * 60 * 60 * 24));
        /*小时差*/
        int hours = (int)((to - from) / (1000 * 60 * 60));
        int hours2 = hours - days * 24;
        /*分钟差*/
        int minutes = (int)((to - from) / (1000 * 60));
        int minutes2 = minutes - hours * 60;
        //  int sec = (int) ((to2-to) / 1000 );  
        //int sec2=sec-minutes*60;
        String re;
        if (days < 0 || hours2 < 0 || minutes2 < 0) {
            Date toDate2 = simpleFormat.parse(time2);
            long to2 = toDate2.getTime();
            int days3 = (int)((to2 - from) / (1000 * 60 * 60 * 24));
            /*小时差*/
            int hours3 = (int)((to2 - from) / (1000 * 60 * 60));
            int hours4 = hours3 - days3 * 24;
            /*分钟差*/
            int minutes3 = (int)((to2 - from) / (1000 * 60));
            int minutes4 = minutes3 - hours3 * 60;
            if (days3 < 0 || hours4 < 0 || minutes4 < 0) {
                re = "❌已过期:" + Math.abs(days3) + "天" + Math.abs(hours4) + "小时" + Math.abs(minutes4) + "分钟" /*"+sec4+"秒"*/ ;
            } else {
                re = "✅已开通:" + Math.abs(days) + "天" + Math.abs(hours2) + "小时" + Math.abs(minutes2) + "分钟" /*"+sec2+"秒"*/ + "\n🕗还剩于:" + Math.abs(days3) + "天" + Math.abs(hours4) + "小时" + Math.abs(minutes4) + "分钟";
            }
        } else re = "距离开通还有:" + days + "天" + hours2 + "小时" + minutes2 + "分钟" /*"+sec2+"秒"*/ ;
        return re;
    } catch (Throwable e) { //Toast(e+" ");
        return time + "或" + time2 + "\n不是标准时间格式\n" + e;
    }
}

public String setnameplate(String QQ, String skey, String pskey, String token, String ID) { //刺痛
    try {
        String url = httppost("https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?ts=1632064034950&daid=18&g_tk=" + GetBkn(pskey) + "&pt4_token=" + token, "pvid=6037055062" + ";pgv_info=ssid=s4903576118" + ";pgv_pvid=5149793615" + ";o_cookie=" + QQ + ";uin=o0" + QQ + ";p_uin=o0" + QQ + ";pt4_token=" + token + ";skey=" + skey.replace("@", "") + ";p_skey=" + pskey, "{[双引号]13019[双引号]:{[双引号]stReq[双引号]:{[双引号]stLogin[双引号]:{[双引号]iKeyType[双引号]:1,[双引号]iOpplat[双引号]:2,[双引号]lUin[双引号]:" + QQ + ",[双引号]sClientIp[双引号]:[双引号][双引号],[双引号]sClientVer[双引号]:[双引号]8.8.20[双引号],[双引号]sSKey[双引号]:[双引号]" + skey + "[双引号]},[双引号]stNamePlate[双引号]:{[双引号]viptypeid[双引号]:258,[双引号]issetpendant[双引号]:0,[双引号]pendantid[双引号]:0},[双引号]stUniBusinessItem[双引号]:{[双引号]appid[双引号]:34,[双引号]itemid[双引号]:" + ID + "}}}}");
        JSONObject json = new JSONObject(url);
        String ecode = json.getString("ecode");
        String msg=json.getJSONObject("13019").getString("msg");
		if(ecode.equals("0")) 
		{
		    return msg;
		}
        else if(url.contains("未"))
        {
            return "cookie无效";
        }else return "提交失败";
    } catch (Exception e) {
    return "ID不能为空";
}
}
public long GetBkn(String pskey) {
    int hash = 5381;
    for (int i = 0, len = pskey.length(); i < len; i++)
        hash += (hash << 5) + (int)(char) pskey.charAt(i);
    return hash & 2147483647;
}


import java.net.*;
import java.util.zip.GZIPInputStream;

public String zipget(String url, String cookie) { //萌新
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try {
        URL urlObj = new URL(url);
        URLConnection uc = urlObj.openConnection();
        uc.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
        uc.setRequestProperty("Cookie", cookie);
        uc.setConnectTimeout(10000);
        uc.setReadTimeout(10000);
        InputStream in = uc.getInputStream(); in = new BufferedInputStream( in ); // 缓冲
        in = new GZIPInputStream( in ); // 解压数据
        byte[] buffer = new byte[256];
        int n;
        while ((n = in .read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (null != out) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return out.toString();
}
public Object getQQLevel(String QQ, String skey, String pskey) { //萌新
    try {
        String cookie = "uin=o0" + QQ + ";skey=" + skey + ";p_skey=" + pskey;
        String result = zipget("https://h5.vip.qq.com/p/mc/card/grow?pvsrc=2&_wvx=2", cookie);
        int rj = result.lastIndexOf("window.growInfo = ");
        if (rj != -1) {
            String msg = result.substring(rj + 18);
            int rd = msg.indexOf("};");
            String re = msg.substring(0, rd + 1);
            JSONObject json = new JSONObject(re);
            if ((json + "").contains("sNickName")) {
                return json;
            } else "获取失败,原因:\n" + re;
        }
        return "获取Json失败";
    } catch (Exception e) {
        return "代码失效";
    }
}