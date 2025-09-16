public void 加解密功能(Object data) {
    String quntext = data.MessageContent;
    String fsz=data.SenderNickName;//发送者的名字
    String qun = data.GroupUin;
    String uin = data.UserUin;
    if(data.MessageContent.startsWith("y解")||data.MessageContent.startsWith("Y解"))
			{
			String 解密内容=data.MessageContent.substring(2);
			String 解密结果=Y(解密内容);
			sendMsg(qun,"",lfmm+"\n"+"解密内容:"+解密内容+"\n解密结果:"+解密结果);
			}
			if(data.MessageContent.startsWith("b解")||data.MessageContent.startsWith("B解"))
			{
			String 解密内容=data.MessageContent.substring(2);
			String 解密结果=jm(解密内容);
			sendMsg(qun,"",lfmm+"\n"+"解密内容:"+解密内容+"\n解密结果:"+解密结果);
			}
			if(data.MessageContent.startsWith("b加")||data.MessageContent.startsWith("B加"))
			{
			String 解密内容=data.MessageContent.substring(2);
			String 解密结果=b加(解密内容);
			sendMsg(qun,"",lfmm+"\n"+"加密内容:"+解密内容+"\n加密结果:"+解密结果);
			}
			if(data.MessageContent.startsWith("u加")||data.MessageContent.startsWith("U加"))
			{
			String 解密内容=data.MessageContent.substring(2);
			String 解密结果=u加(解密内容);
			sendMsg(qun,"",lfmm+"\n"+"加密内容:"+解密内容+"\n加密结果:"+解密结果);
			}
			if(data.MessageContent.startsWith("u解")||data.MessageContent.startsWith("U解"))
			{
			String 解密内容=data.MessageContent.substring(2);
			String 解密结果=u解(解密内容);
			sendMsg(qun,"",lfmm+"\n"+"解密内容:"+解密内容+"\n解密结果:"+解密结果);
			}
			if(data.MessageContent.startsWith("ct解")||data.MessageContent.startsWith("CT解"))
			{
			String 解密内容=data.MessageContent.substring(2);
			String 解密结果=CT(解密内容);
			sendMsg(qun,"",lfmm+"\n"+"解密内容:"+解密内容+"\n解密结果:"+解密结果);
			}
			if(data.MessageContent.startsWith("萌新解")||data.MessageContent.startsWith("mx解"))
			{
			String 解密内容=data.MessageContent.substring(3);
			String 解密结果=encryptKaiser(解密内容,mima,1);
			sendMsg(qun,"",lfmm+"\n"+"解密内容:"+解密内容+"\n解密结果:"+解密结果);
			}
			}
