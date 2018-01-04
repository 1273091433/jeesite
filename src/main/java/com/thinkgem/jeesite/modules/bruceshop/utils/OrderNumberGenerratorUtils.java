package com.thinkgem.jeesite.modules.bruceshop.utils;

import java.util.UUID;

public class OrderNumberGenerratorUtils {
	public static String getOrderIdByUUID(){
		int machineId = 1;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if(hashCodeV < 0){//有可能小于0
			hashCodeV = -hashCodeV;
		}
		return machineId + String.format("%015d", hashCodeV);
	}
}
