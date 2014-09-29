package com.gameserver.common.handler;

import com.common.msg.BaseBean.BaseMessage;
import com.gameserver.player.Player;

public interface IMessageHandler {
	public void execute();
	public void setMessage(BaseMessage baseMessage,Player player);
}
