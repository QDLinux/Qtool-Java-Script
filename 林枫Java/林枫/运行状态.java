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
                        info[1]="充电中";
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
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
	public String getOperatorName() {
		String provider = "unknown";
		try {
			TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			String IMSI = telephonyManager.getSubscriberId();
			if (IMSI == null) {
				if (TelephonyManager.SIM_STATE_READY == telephonyManager
						.getSimState()) {
					String operator = telephonyManager.getSimOperator();
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
public static String getHostInfo() {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName+"("+context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode+")";
        } catch (Throwable e) {
            Log.e("Utils", "Can not get PackageInfo!");
            throw new AssertionError("Can not get PackageInfo!");
        }
    }
    public static List getInstalledApplication(boolean needSysAPP) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List resolveInfos = packageManager.queryIntentActivities(intent, 0);
        if (!needSysAPP) {
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
        return resolveInfos;
    }
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
    public String getAvailMemory() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(mi);
        return formatSize(mi.availMem);
    }
public static String getAvailableInternalMemorySize() {
File path = Environment.getDataDirectory();
StatFs stat = new StatFs(path.getPath());
long blockSize = stat.getBlockSize();
long availableBlocks = stat.getAvailableBlocks();
return Formatter.formatFileSize(context,availableBlocks * blockSize);
}
public static String getTotalInternalMemorySize() {
File path = Environment.getDataDirectory();
StatFs stat = new StatFs(path.getPath());
long blockSize = stat.getBlockSize();
long totalBlocks = stat.getBlockCount();
return Formatter.formatFileSize(context,totalBlocks * blockSize);
}

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
if(suffix != null)
resultBuffer.append(suffix);
return resultBuffer.toString();
}
public void 运行状态(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
if(quntext.equals("运行状态")&&uin.equals(MyUin))
	{

						List app = new ArrayList();
						app =getInstalledApplication(true);
						SimpleDateFormat df=new SimpleDateFormat("MM月dd日 HH:mm:ss");
						Calendar calendar=Calendar.getInstance();
						String time3=df.format(calendar.getTime());
						String info=lfmm+"\n"+"当前时间:"+time3+"\n电池类型:"+getBatteryStatus()[2]+"\n电池温度:"+getBatteryStatus()[3]+"\n电池电压:"+getBatteryStatus()[4]+"\n电池电量:"+getBatteryStatus()[0]+"("+getBatteryStatus()[1]+")\n应用数量:"+app.size()+"个\n剩余内存:"+getAvailMemory()+"\n存储信息:"+getAvailableInternalMemorySize()+"/"+getTotalInternalMemorySize()+"\nQQ版本:"+getHostInfo()+"\n手机型号:"+phoneModel()+"\n手机信息:"+phoneplay()+"\n安卓版本:"+phoneReleaseVersion()+"(SDK:"+phoneSdkVersion()+")";
                        info=info.replace(" GB/","/");
						sendMsg(qun,"",info);
	}
	}
	