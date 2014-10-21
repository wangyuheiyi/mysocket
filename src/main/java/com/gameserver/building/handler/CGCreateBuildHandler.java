package com.gameserver.building.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.BuildBean.CGCreatBuild;
import com.gameserver.building.Build;
import com.gameserver.building.data.BuildIngData;
import com.gameserver.building.template.BuildTemplate;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.human.Human;
import com.gameserver.player.Player;
/**
 * 创建建筑消息信息处理器
 * @author Administrator
 *
 */
@Scope("prototype")
@Component
public class CGCreateBuildHandler implements IMessageHandler{
	private CGCreatBuild cgCreatBuild;
	private Player player;
	@Override
	public void execute() {
		Human human=player.getHuman();
		long roleId=cgCreatBuild.getRoleId();
		int templateId=cgCreatBuild.getTemplateId();
		//获取建筑的模板数据
		BuildTemplate buildTemplate=ServerManager.getInstance().getBuildSever().getHumanTemplById(templateId);
		if(buildTemplate==null)return;
		
		//获取对象
		//判断建筑列表是否还有空闲
		//判断建筑已经达到了最大限制
		//判断消耗是否够用
		//创建建筑，添加到建筑队列中
//		BuildIngData buildIngData=new BuildIngData();
//		buildIngData.setTemplateId(templateId);
//		buildIngData.setBuildStartTime(ServerManager.getInstance().getSystemTimeService().now());
//		build.getBuildIngDataList().add(buildIngData);
//		build.setModified();
//		human.getHumanAllManager().getHumanBuildManager()
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgCreatBuild=baseMessage.getExtension(BaseBean.cgCreatBuild);
		this.player=player;
	}

}
