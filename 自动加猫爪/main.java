sendLike("\u0032\u0036\u0035\u0039\u0037\u0038\u0039\u0036\u0031\u0036",20);
public String getMsg(String msg,String uin,int type) {
    return msg.indexOf('@') >= 0 ? msg : ("\u0014\u01FF\u000F\u0043\u0000" + msg + "\u0014\u01FF\u000F\u0043\u0000");
}