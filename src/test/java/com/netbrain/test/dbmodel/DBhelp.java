package com.netbrain.test.dbmodel;

import com.netbrain.test.util.DataPrepare;

/**
 * @author gaohuan
 *
 * 2016年9月12日下午8:41:21
 */
public class DBhelp {
	public static String getTenantGuid(){
		return DataPrepare.getStringRandom(8)+"-"+DataPrepare.getStringRandom(4)+"-"+DataPrepare.getStringRandom(4)+"-"+DataPrepare.getStringRandom(4)+"-"+DataPrepare.getStringRandom(12);
	}
	
	public static String getDomainGuid(){
		return DataPrepare.getStringRandom(8)+"-"+DataPrepare.getStringRandom(4)+"-"+DataPrepare.getStringRandom(4)+"-"+DataPrepare.getStringRandom(4)+"-"+DataPrepare.getStringRandom(12);
	}
	public static String getTenantname(){
		return "AutoTenant_"+DataPrepare.getStringRandom(6);
	}
	public static String getDomainname(){
		return "AutoDomain_"+DataPrepare.getStringRandom(6);
	}
	
	public static void  main(String[] args) {        
        System.out.println(getTenantname());
        System.out.println(getDomainname());
        System.out.println(getTenantGuid());
        System.out.println(getDomainGuid());           
    }
	
}
