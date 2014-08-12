package com.common.handler;

import com.common.msg.bean.BaseBean.BaseMessage;
import com.player.Player;

public interface IMessageHandler {
	public void execute();
	public void setMessage(BaseMessage baseMessage,Player player);
}
