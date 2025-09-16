
import java.io.File;
import android.content.*;
import android.net.wifi.Wifi;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.StatFs;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.concurrent.TimeUnit;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.text.format.Formatter;
import android.app.Activity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DecimalFormat;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;




public String[] getBatteryStatus() {
IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
Intent batteryStatus = context.registerReceiver(null, ifilter);
float level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
float scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
float vol=batteryStatus.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
String[] info=new String[5];
info[0]=(int)((level/scale) * 100) + "%";
int pluged = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                switch (pluged) {
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        // 电源是AC charger.[应该是指充电器]
                        info[1]="充电中";
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        // 电源是USB port
                        info[1]="USB充电中";
                        break;
                    default: info[1]="未充电";
                        break;
                        }                 
     info[2]=batteryStatus.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
     info[3] =(batteryStatus.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)/10)+"℃";
     info[4]=vol/1000+"V";
return info;
}

public String[] getWifiStatus() {
String result =null;
WifiManager wm = (WifiManager) context
.getSystemService(Context.WIFI_SERVICE);
WifiInfo connectionInfo = wm.getConnectionInfo();
int rssi = connectionInfo.getRssi();
//Toast("signal" + rssi);
if (rssi > -60) {
result = "wifi(信号强)";
} else if (rssi <= -60 && rssi >-80) {
result = "wifi(信号一般)";
} else if (rssi <= -80&&rssi>-120) {
result = "wifi(信号弱，有可能断开)";
}
String[] info=new String[2];
info[0]=rssi+"dbm";
info[1]=result;
return info;
}


	public String getOperatorName() {
		String provider = "unknown";
		try {
			TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			String IMSI = telephonyManager.getSubscriberId();
			//Log.v("tag", "getProvider.IMSI:" + IMSI);
			if (IMSI == null) {
				if (TelephonyManager.SIM_STATE_READY == telephonyManager
						.getSimState()) {
					String operator = telephonyManager.getSimOperator();
					//Log.v("tag", "getProvider.operator:" + operator);
					if (operator != null) {
						if (operator.equals("46000")
								|| operator.equals("46002")
								|| operator.equals("46007")) {
							provider = "中国移动";
						} else if (operator.equals("46001")) {
							provider = "中国联通";
						} else if (operator.equals("46003")) {
							provider = "中国电信";
						}
					}
				}
			} else {
				if (IMSI.startsWith("46000") || IMSI.startsWith("46002")
						|| IMSI.startsWith("46007")) {
					provider = "中国移动";
				} else if (IMSI.startsWith("46001")) {
					provider = "中国联通";
				} else if (IMSI.startsWith("46003")) {
					provider = "中国电信";
				}
			}
			return provider;
		} catch (Exception e) {
		return "未给权限";
			Toast("错误"+e);
		}
	}
	/**
	 * 得到当前的手机网络类型
	 *
	 * @param context
	 * @return
	 */
	public String getCurrentNetType() {
		String type = "未知";
		try{
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if (info == null) {
			type = "未知";
		} else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
			type = getWifiStatus()[1]+"\n信号强度:"+getWifiStatus()[0];
		} else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
			int subType = info.getSubtype();
			if (subType == TelephonyManager.NETWORK_TYPE_CDMA
					|| subType == TelephonyManager.NETWORK_TYPE_GPRS
					|| subType == TelephonyManager.NETWORK_TYPE_EDGE) {
				type = "2G";
			} else if (subType == TelephonyManager.NETWORK_TYPE_UMTS
					|| subType == TelephonyManager.NETWORK_TYPE_HSDPA
					|| subType == TelephonyManager.NETWORK_TYPE_EVDO_A
					|| subType == TelephonyManager.NETWORK_TYPE_EVDO_0
					|| subType == TelephonyManager.NETWORK_TYPE_EVDO_B) {
				type = "3G";
			} else if (subType == TelephonyManager.NETWORK_TYPE_LTE) {// LTE是3g到4g的过渡，是3.9G的全球标准
				type = "4G";
			}
			else type="5G";
			type=getOperatorName()+type/*+"\n信号强度:"+getCurrentNetDBM.dbm2*/;
		}
		//setType(type);
		return type;
		}catch (Exception e) {
		return "未给权限";
			Toast("错误"+e);
	}
	}


	
public static String getHostInfo() {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName+"("+context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode+")";
        } catch (Throwable e) {
            Log.e("Utils", "Can not get PackageInfo!");
            throw new AssertionError("Can not get PackageInfo!");
        }
    }
    
    //获取用户安装的APP
    public static List getInstalledApplication(boolean needSysAPP) {
  //  Toast("你多喝点");
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List resolveInfos = packageManager.queryIntentActivities(intent, 0);
        if (!needSysAPP) {
        //Toast("hshhsj");
            List resolveInfosWithoutSystem = new ArrayList();
            for (int i = 0; i < resolveInfos.size(); i++) {
                ResolveInfo resolveInfo = resolveInfos.get(i);
                try {
                    if (!isSysApp(resolveInfo.activityInfo.packageName)) {
                        resolveInfosWithoutSystem.add(resolveInfo);
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Toast("错误"+e);
                }
            }
            return resolveInfosWithoutSystem;
        }
        //Toast("sss");
        return resolveInfos;
    }
 
    //判断是否系统应用
    public static boolean isSysApp(String packageName) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return (packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 1;
    }
    
    public static String phoneModel()
    {return Build.MODEL;}
    public static String phoneReleaseVersion()
    {return Build.VERSION.RELEASE;}
    public static String phoneSdkVersion()
    {return Build.VERSION.SDK;}
    public static String phoneplay()
    {return Build.DISPLAY;}
    /**
     *  获取android当前可用运行内存大小
     *  @param context
     */
    public String getAvailMemory() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);
        // mi.availMem; 当前系统的可用内存
        return formatSize(mi.availMem);// 将获取的内存大小规格化
    }



public static String getAvailableInternalMemorySize() {
File path = Environment.getDataDirectory();
StatFs stat = new StatFs(path.getPath());
long blockSize = stat.getBlockSize();
long availableBlocks = stat.getAvailableBlocks();
return Formatter.formatFileSize(context,availableBlocks * blockSize);
}
//获取内部存储设备总容量
public static String getTotalInternalMemorySize() {
File path = Environment.getDataDirectory();
StatFs stat = new StatFs(path.getPath());
long blockSize = stat.getBlockSize();
long totalBlocks = stat.getBlockCount();
return Formatter.formatFileSize(context,totalBlocks * blockSize);
}

//把byte单位转换成G
public static String formatSize(float size) {
String suffix = null;

if (size >= 1024) {
suffix = "KB";
size /= 1024;
if (size >= 1024) {
suffix = "MB";
size /= 1024;
}
if (size >= 1024) {
suffix = "GB";
size /= 1024; 
}
}
DecimalFormat format=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
 String p=format.format(size);
StringBuilder resultBuffer = new StringBuilder(p);

/*int commaOffset = resultBuffer.length() - 3;
while (commaOffset > 0) {
resultBuffer.insert(commaOffset, ',');
commaOffset -= 3;
}
*/
if (suffix != null)
resultBuffer.append(suffix);
return resultBuffer.toString();
}



public static String formatTime(float time) {
String suffix = "豪秒";
long seconds =(long)(time/1000);
String tr=seconds / 3600 +"时"+(seconds % 3600) / 60 + "分" + seconds % 3600 % 60 % 60 + "秒";
tr=tr.replace("分0秒","分");
tr=tr.replace("时0分","时");
tr=tr.replace("0时","");
return tr;
}