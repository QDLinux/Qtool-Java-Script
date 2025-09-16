import java.io.*;
public class fileSystem{
    private File file;
    public fileSystem(String path) throws IOException{
        this.file = new File(path);
        if (!this.file.exists()){
            String dir = "";
            for (int i = 0;i < path.split("/").length - 1;i++){
                dir += path.split("/")[i]+"/";
            }new File(dir).mkdirs();
            this.file.createNewFile();
        }
    }
    public String read() throws IOException{
        try{
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(this.file)));
            if (this.file.canRead()){
                String t = "";
                String n = r.readLine();
                while (n != null){
                    t += "\n" + n;
                    n = r.readLine();
                }
                t = t.substring(1);
                r.close();
                return t;
            }else{
                r.close();
                return "";
            }
        }catch (Exception e){
            return "";
        }
    }
    public boolean write(String text) throws IOException{
        FileOutputStream w = new FileOutputStream(this.file);
        try{
            if (this.file.canWrite()){
                w.write(text.getBytes());
                w.close();
                return true;
            }else{
                w.close();
                return false;
            }
        }catch (Exception e){
            w.close();
            return false;
        }
    }
    public boolean add(String text){
        try{
            String oldText = this.read();
            this.write(oldText + text);
            return true;
        }catch (Exception e){
            return false;
        }
    }public boolean delete(){
        return this.file.delete();
    }public byte[] readBytes() throws IOException{
        BufferedInputStream r = new BufferedInputStream(new FileInputStream(this.file));
        try{
            int l = r.available();
            byte[] bytes = new byte[l];
            r.read(bytes,0,l);
            return bytes;
        }catch (Exception e){
            return null;
        }finally{
            r.close();
        }
    }public boolean writeBytes(byte[] b) throws IOException{
        try{
            FileOutputStream dos = new FileOutputStream(this.file);
            dos.write(b);
            dos.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
