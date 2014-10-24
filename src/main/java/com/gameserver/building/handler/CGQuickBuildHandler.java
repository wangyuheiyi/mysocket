package com.gameserver.building.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.BaseBean.BaseMessage.MessageCode;
import com.common.msg.BuildBean.CGQuickBuild;
import com.common.msg.BuildBean.GCUpdateBuildData;
import com.core.util.TimeUtils;
import com.gameserver.building.Build;
import com.gameserver.building.BuildDef.BuildFinishType;
import com.gameserver.building.BuildDef.BuildUpdateState;
import com.gameserver.building.BuildListLogic;
import com.gameserver.building.template.BuildTemplate;
import com.gameserver.common.globals.server.impl.ServerManager;
import com.gameserver.common.handler.IMessageHandler;
import com.gameserver.common.handler.impl.MessageHandlerServer;
import com.gameserver.human.Human;
import com.gameserver.player.Player;
/**
 * 快速建筑消息信息处理器
 * @author Administrator
 *
 */
@Scope("prototype")
@Component
public class CGQuickBuildHandler implements IMessageHandler{
	private CGQuickBuild cgQuickBuild;
	private Player player;
	public CGQuickBuildHandler(){
		MessageHandlerServer.getInstance().registerMessageHandler(MessageCode.CGQUICKBUILD, this);
	}
	@Override
	public void execute() {
		Human human=player.getHuman();
		long buildId=cgQuickBuild.getBuildId();
		Build build=human.getHumanAllManager().getHumanBuildManager().getBuildById(buildId);
		if(build==null) return;
		//获取建筑的模板数据
		BuildTemplate buildTemplate=ServerManager.getInstance().getBuildSever().getHumanTemplById(build.getTemplateId());
		if(buildTemplate==null)return;
		if(build.getIsFinish()==BuildFinishType.FINISH.getIndex()) return;
		
		//计算时间判断是否已经完成如果已经完成就不需要勾出消耗品
		
		
		
		//修改对象的建筑状态
		build.setIsFinish(BuildFinishType.FINISH.getIndex());
		//计算产出时间
		if(buildTemplate.getOutputType()!=0){
			long now =ServerManager.getInstance().getSystemTimeService().now();
			build.setOutPutTime(now+buildTemplate.getOutputInterval()*TimeUtils.SECOND);
		}
		
		//更新列表
		GCUpdateBuildData.Builder gcUpdateBuildData=GCUpdateBuildData.newBuilder();
		gcUpdateBuildData.addBuildData(BuildListLogic.getInstance().getBuildClientData(build,BuildUpdateState.ADD.getIndex()));
		player.sendMessage(player.buildBeseMessage(BaseMessage.Type.PLAYERMESSAGE, BaseMessage.MessageCode.GCUPDATEBUILDDATA).
				setExtension(BaseBean.gcUpdateBuildData, gcUpdateBuildData.build()).build());
	}

	@Override
	public void setMessage(BaseMessage baseMessage, Player player) {
		this.cgQuickBuild=baseMessage.getExtension(BaseBean.cgQuickBuild);
		this.player=player;
	}

}
