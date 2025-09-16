import com.tencent.common.app.BaseApplicationImpl;
Object app=BaseApplicationImpl.getApplication().getRuntime();


import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;

PackageManager pm = context.getPackageManager();
ApplicationInfo sAppInfo = pm.getApplicationInfo("com.tencent.mobileqq",PackageManager.GET_META_DATA);
String UUID = sAppInfo.metaData.getString("com.tencent.rdm.uuid");
String Version_Code = UUID.substring(0,UUID.indexOf("_"));
int QQ_version=Integer.parseInt(Version_Code);

import com.tencent.mobileqq.app.BaseActivity;
BaseActivity activity;

while(activity==null){
activity=BaseActivity.sTopActivity;
}

import com.tencent.mobileqq.troop.api.ITroopInfoService;
ITroopInfoService TroopInfo=app.getRuntimeService(ITroopInfoService.class);

public String quncode(String qun) {
   String code= TroopInfo.getTroopCodeByTroopUin(qun);
   if(code==null||code.equals("")) code=qun;
   return code;
}

public String qunuin(String code) {
   String qun= TroopInfo.getTroopUinByTroopCode(code);
   if(qun==null||qun.equals("")) qun=code;
   return qun;
}
