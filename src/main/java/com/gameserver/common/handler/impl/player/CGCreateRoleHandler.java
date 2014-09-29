package com.gameserver.common.handler.impl.player;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.PlayerBean.CGCreateRole;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.human.Human;
import com.gameserver.human.template.HumanTemplate;
import com.gameserver.player.Player;
import com.gameserver.player.PlayerState;
import com.gameserver.player.async.CreateRoleOperation;
/**
 * 创建用户消息信息处理器
 * @author Administrator
 *
 */
@Scope("prototype")
@Component
public class CGCreateRoleHandler implements IMessageHandler{
	private CGCreateRole cgCreateRole;
	private Player player;
	@Override
	public void execute() {
		
		long playerId=cgCreateRole.getPlayerId();
		int avatar=cgCreateRole.getAvatar();
		//穿件角色信息
		player.setState(PlayerState.creatingrole);
		//获取human的模板数据
		HumanTemplate humanTemplate=ServerManager.getInstance().getHumanSever().getHumanTemplByAvatar(avatar);
		if(humanTemplate==null)return;
		//创建human对象
		Human human=new Human(player);
		human.setAvatar(avatar);
		human.setAllianceTypeId(humanTemplate.getVocationType());
		human.setInDb(false);
		human.setLevel(1);
		human.setName("");
		human.setPassportId(playerId);
		human.setLastLoginTime(new Timestamp(new Date().getTime()));
		human.setLastLoginIp("");
		human.setDeleteTime(null);
		human.setCreateTime(new Timestamp(new Date().getTime()));
		// 异步保存到DBS
		CreateRoleOperation _createTask = new CreateRoleOperation(player, human);
		ServerManager.getInstance().getGameAsyncService().createSyncOperationAndExecuteAtOnce(_createTask);
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgCreateRole=baseMessage.getExtension(BaseBean.cgCreateRole);
		this.player=player;
	}

}
