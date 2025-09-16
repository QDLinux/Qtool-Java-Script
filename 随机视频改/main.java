import org.json.JSONObject;
import com.tencent.mobileqq.activity.shortvideo.d;
import com.tencent.mobileqq.app.BaseActivity;
import android.content.Intent;
//import java.lang.reflect.Constructor;
import java.util.*;
load(AppPath + "/Http.java");
Http http = new Http();
public String url="https://api.lolimi.cn/API/sjsp/api.php?msg=热舞&type=json";
public String videoPath =AppPath+"/video/";
public boolean flag=false;
public List list=new ArrayList();

new Thread(new Runnable() {
      //@Override
      public void run() {
          while(true){
              try{
		          File dir = new File(videoPath);
			      if(!dir.exists()){
				    dir.mkdirs();
				    DownloadToVideo(-1);
			      }else{
			          for(int i=0;i<10;i++){
			              String fi=videoPath+i+".mp4";
			              File di = new File(fi);
			              if(!di.exists()){
				              DownloadToVideo(i);
				              if(list.contains(fi)){
				                  list.remove(fi);
				              }
				          }
			          }
			          flag=true;
		          }
		      }catch(Exception e){
			    e.printStackTrace();
		     }
          }                          
      }
}).start();  

public void DownloadToVideo(int j){
    if(j==-1){
        Toast("正在初始化,下载视频缓存中,请稍后");
        for(int i=0;i<10;i++){
            try {
                JSONObject jsonObject=new JSONObject(http.get(url));
                String ur=jsonObject.getString("video_url");
                http.DownloadToFile(ur,videoPath+i+".mp4");
                } catch (Exception e) {                        
                    e.printStackTrace();
                }                    
        }
        flag=true;
        Toast("初始化成功");
    }else{
        try {
            JSONObject jsonObject=new JSONObject(http.get(url));
            String ur=jsonObject.getString("video_url");
            http.DownloadToFile(ur,videoPath+j+".mp4");
        } catch (Exception e) {
            e.printStackTrace();
        }                  
    }       
}
    public DeleteFile(String Path){
		File file = null;
		try
		{
			file = new File(Path);
			if(file.exists())
			{
				file.delete();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


public void send_video(String group,String file){
         Intent intent = new Intent();
         intent.putExtra("file_send_path",file);
         intent.putExtra("uin",group);
         intent.putExtra("uintype", 1);
         intent.putExtra("send_in_background",true);
         intent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
         /*
         Class d=Class.forName("com.tencent.mobileqq.activity.shortvideo.d");
         Constructor constructor = d.getConstructor(BaseActivity.class,Intent.class);
         Object o = constructor.newInstance(BaseActivity.sTopActivity,intent);*/
       com.tencent.mobileqq.activity.shortvideo.d sendVideo=new com.tencent.mobileqq.activity.shortvideo.d(BaseActivity.sTopActivity,intent);
        sendVideo.execute(new Void[0]);
}

public void Callback_OnRawMsg(Object data){
    if(data.getClass().getSimpleName().equals("MessageForShortVideo")){
        String fi=data.videoFileName;
        if(list.contains(fi)){
            new Thread(new Runnable(){
			public void run(){
				try
				{
				    boolean flag=true;				    
				    while(flag){
				        if(data.extraflag==0){
				            DeleteFile(fi);
				            flag=false;
				        }				        
				        Thread.sleep(1000);
				    }
				}
				catch(Throwable e)
				{
					Toast(e);
				}
			}
		}).start();
        }
    }   
}
public void onMsg(Object data){
    if(data.MessageContent.equals("随机视频")){    
        if(flag){
            getData(data.GroupUin);
        }else{
            Toast("脚本初始化未完成\n或视频缓存为完成\n请稍后");
        }  
    }         	 		
}

public void getData(String group){
    int num=(int)(Math.random() *9);
    String fi=videoPath+num+".mp4";
    if(!list.contains(fi)){
        send_video(group,fi);
        list.add(fi);        
    }else{
        getData(group);
    }
}
