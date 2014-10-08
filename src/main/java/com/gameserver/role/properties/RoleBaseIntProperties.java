package com.gameserver.role.properties;

import java.util.BitSet;

import com.core.annotation.Comment;
import com.core.annotation.Type;

/**
 * 玩家角色整型属性:符号值定义
 * 
 * @author Thinker
 * 
 */
public class RoleBaseIntProperties extends GenericPropertyObject<Integer>
{
	/** 基础整型属性索引开始值 */
	public static int _BEGIN = 0;
	
	/** 基础整型属性索引结束值 */
	public static int _END = _BEGIN;
	
	/** 职业类型 */
	@Comment(content = "职业类型")
	@Type(Integer.class)
	public static final int VOCATIONTYPE = ++_END;
	
	/** 等级 */
	@Comment(content = "等级")
	@Type(Integer.class)
	public static final int LEVEL = ++_END;
	
	/** 钻石 */
	@Comment(content = "钻石")
	@Type(Integer.class)
	public static final int DIAMOND = ++_END;

	/** 金币 */
	@Comment(content = "金币")
	@Type(Integer.class)
	public static final int GOLD = ++_END;
	
	/** 点券 */
	@Comment(content = "点券")
	@Type(Integer.class)
	public static final int COUPON = ++_END;
	
	/** 当前经验 */
	@Comment(content = "当前经验")
	@Type(Integer.class)
	public static final int CUR_EXP = ++_END;
	
	/** 体力值上限 */
	@Comment(content = "体力值上限")
	@Type(Integer.class)
	public static final int MAX_VIM= ++_END;

	/** 模版ID */
	@Comment(content = "模版ID")
	@Type(Integer.class)
	public static final int TEMPLATE_ID = ++_END;
	
	/** 场景ID */
	@Comment(content = "场景ID")
	@Type(Integer.class)
	public static final int SCENE_ID = ++_END;
	
	/**  剧情ID */
	@Comment(content = " 剧情ID")
	@Type(Integer.class)
	public static final int STORY_ID = ++_END;
	
	/** 角色的AvatarId */
	@Comment(content = "角色的AvatarId")
	@Type(Integer.class)
	public static final int AVATAR = ++_END;
	
	/** 新手引导ID */
	@Comment(content = "新手引导ID")
	@Type(Integer.class)
	public static final int GUIDEID = ++_END;
	
	/** 新手引导状态 */
	@Comment(content = "新手引导状态")
	@Type(Integer.class)
	public static final int GUIDESTATE = ++_END;

	/** 统帅值 */
	@Comment(content = "统帅值")
	@Type(Integer.class)
	public static final int CONTROL = ++_END;
	/** 攻击 */
	@Comment(content = "攻击")
	@Type(Integer.class)
	public static final int ATTACK = ++_END;
	/** 防御 */
	@Comment(content = "防御")
	@Type(Integer.class)
	public static final int DEFENCE = ++_END;
	/** 法力 */
	@Comment(content = "法力")
	@Type(Integer.class)
	public static final int MAGIC = ++_END;
	/** 幸运 */
	@Comment(content = "幸运")
	@Type(Integer.class)
	public static final int LUCKY = ++_END;
	/** 命中 */
	@Comment(content = "命中")
	@Type(Integer.class)
	public static final int HIT = ++_END;
	
	/** 闪避 */
	@Comment(content = "闪避")
	@Type(Integer.class)
	public static final int DODGE = ++_END;
	
	/** 免伤 */
	@Comment(content = "免伤")
	@Type(Integer.class)
	public static final int AVOIDDAMAGE = ++_END;
	
	/** 暴击 */
	@Comment(content = "暴击")
	@Type(Integer.class)
	public static final int CRIT = ++_END;

	/** 基础整型属性的个数 */
	public static final int _SIZE = _END - _BEGIN + 1;

	public static final int TYPE = PropertyType.BASE_ROLE_PROPS_INT;

	/** 数值是否修改的副本标识 */
	private final BitSet shadowBitSet;

	public RoleBaseIntProperties() 
	{
		super(Integer.class, _SIZE, TYPE);
		this.shadowBitSet = new BitSet(this.size());
	}

	/**
	 * 重载{@link #resetChanged()},在重置前将props的修改记录下来
	 */
	@Override
	public void resetChanged()
	{
		this.props.fillChangedBit(this.shadowBitSet);
		super.resetChanged();
	}

	/**
	 * 是否有副本属性的修改
	 * 
	 * @return ture,有修改
	 */
	public boolean isShadowChanged()
	{
		return this.props.isChanged() || (!this.shadowBitSet.isEmpty());
	}

	/**
	 * 检查指定的副本属性索引是否有修改
	 * 
	 * @param index
	 * @return true,有修改;false,无修改
	 */
	public boolean isShadowChanged(final int index)
	{
		return this.props.isChanged(index) || this.shadowBitSet.get(index);
	}

	public void resetShadowChanged() 
	{
		this.shadowBitSet.clear();
	}

	/**
	 * 判定指定的属性索引是否有修改
	 * 
	 * @param index
	 * @return
	 */
	public boolean isChanged(int index) 
	{
		return this.props.isChanged(index);
	}

	/**
	 * 获取属性值
	 * 
	 * @param index
	 * @return
	 */
	@Override
	public Integer getPropertyValue(int index)
	{
		Integer value = props.get(index);
		if (value != null)
		{
			return value;
		} else
		{
			return 0;
		}
	}
}
