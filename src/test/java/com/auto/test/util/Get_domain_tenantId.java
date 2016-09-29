package com.auto.test.util;

import java.util.ArrayList;

import org.bson.Document;

import com.auto.test.basedata.DBConfig;
import com.auto.test.dbmodel.DBConnUtil;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

/**  
 * 类说明   
 *  
 * @author luozt  
 * @date 2016年9月27日  新建  
 * 
 * 
 */
public class Get_domain_tenantId implements DBConfig{
	
	ArrayList<String> dot=new ArrayList<String>();
	
	
	public Get_domain_tenantId(){
		
		DBConnUtil dbConnUtil=new DBConnUtil(mongo_ip,mongo_port,NGSystem);
		dbConnUtil.conn();
		Document query_document=new Document("name",Tenant_name);
		FindIterable<Document> iterable=dbConnUtil.queryData(Tenant, query_document, 0);
		
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		       
		        dot.add(document.getString("_id")); 
		        
		        dot.add(((Document)((ArrayList)document.get("domains")).get(0)).getString("guid"));
	 
		    }
		});
		
		
	}
	
	
	
	
	public ArrayList<String> get_dt(){
		
		return dot;
		
	}

}
