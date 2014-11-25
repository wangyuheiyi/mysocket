package com.test;

import java.io.UnsupportedEncodingException;
import org.apache.mina.common.ByteBuffer;

import com.common.constants.CommonErrorLogInfo;
import com.common.msg.BaseBean;
import com.common.msg.BaseBean.BaseMessage;
import com.common.msg.MissionBean.MissionInfo;

public class BuildMissionInfo {
	public static int getBuildMissionInfo(){
		MissionInfo.Builder mission=MissionInfo.newBuilder();
		mission.setMissionId(123456L);
		mission.setStar(3);
		mission.setSelfRecord(100.5);
		mission.setSelfHit(100.5f);
		mission.setName("test");
		mission.setDescribe("test protobuf infoff");
		mission.setTest1(100);
		mission.setTest2(220.25);
		mission.setTest3(130.522f);
		mission.setTest4("message");
		mission.setTest5("message int test");
		mission.setTest6(999);
		mission.setTest7(999.99);
		mission.setTest8(999.999f);
		mission.setTest9("message");
		mission.setTest10("message int test");
		return mission.build().toByteArray().length;
	}
	
	public static int  getByteBuffer(){
		ByteBuffer buf= ByteBuffer.allocate(10);
		buf.setAutoExpand(true);
		buf.putLong(123456L);
		buf.putInt(3);
		buf.putDouble(100.5);
		buf.putFloat(100.5f);
		writeString(buf,"test","UTF-8");
		writeString(buf,"test protobuf infoff","UTF-8");
		
		buf.putInt(100);
		buf.putDouble(220.25);
		buf.putFloat(130.522f);
		writeString(buf,"message","UTF-8");
		writeString(buf,"message int test","UTF-8");
		
		buf.putInt(999);
		buf.putDouble(999.99);
		buf.putFloat(999.999f);
		writeString(buf,"message","UTF-8");
		writeString(buf,"message int test","UTF-8");
		return buf.position();
	}
	
	public static void writeString(ByteBuffer buf,String str, String charset) {
		try {
			if (str == null) {
				buf.putShort((short) 0);
				return;
			}
			byte[] bytes = str.getBytes(charset);
			buf.putShort((short) bytes.length);
			buf.put(bytes);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	

	protected static int seekIntFromUnsignedShort(ByteBuffer buf,
			boolean peek) {
		if (buf.remaining() >= 2) {
			int _op = buf.position();
			int _value = buf.getShort() << 16 >>> 16;
			if (peek) {
				buf.position(_op);
			}
			if (_value > 2) {
				throw new IllegalStateException(
						CommonErrorLogInfo.PACKET_BAD_HEADER_LEN);
			}
			return _value;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] arg){

		System.out.println("-----"+BuildMissionInfo.getBuildMissionInfo());
		System.out.println("-----"+BuildMissionInfo.getByteBuffer());
		long startTime=System.currentTimeMillis();
		for(int i=0;i<=50000;i++){
			BuildMissionInfo.getBuildMissionInfo();
		}
		long endTime=System.currentTimeMillis();
		System.out.println((endTime-startTime)+"ms");
		
		startTime=System.currentTimeMillis();
		for(int i=0;i<=50000;i++){
			BuildMissionInfo.getByteBuffer();
		}
		endTime=System.currentTimeMillis();
		System.out.println((endTime-startTime)+"ms");
	}
}
