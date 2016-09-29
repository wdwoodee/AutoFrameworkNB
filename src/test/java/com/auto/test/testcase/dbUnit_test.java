package com.auto.test.testcase;

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
 * @date 2016年9月19日  新建  
 */
public class dbUnit_test implements DBConfig{

	
	String collection_name="test_api";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dbUnit_test test=new dbUnit_test();
	}

	
	public dbUnit_test(){
		
		DBConnUtil dbhelp=new DBConnUtil(mongo_ip,mongo_port,mongo_dbname);
		dbhelp.conn();
		
		
		/**
		 * insert
		 * if database or collection not exist ,it will be created by Automatic
		 */
		
		ArrayList<Document> documents=new ArrayList<Document>();
		
		Document document=new Document("name","mongodb2")
		        .append("type", "database2")
				.append("count", "112")
				.append("info", new Document("x",2032).append("y", 1022));
		
		documents.add(document);
		
		dbhelp.insertData(collection_name, documents);
		
		
		
		/**
		 * query
		 * 
		 */
		Document query_document=new Document("info.x",new Document("$gt",300));
		Document fiter_document=new Document("name",1).append("count", 1);
		
		FindIterable<Document> iterable=dbhelp.queryData(collection_name, query_document, fiter_document, 0);
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document);
		    }
		});
		
		
		
		

		/**
		 * update
		 * 
		 */
		
		Document update_document=new Document("name","mongodb2");
		Document update_option=new Document("$set",new Document("info.y",2000));
		long update_count=dbhelp.updateData(collection_name, update_document, update_option, 0);
		System.out.println(update_count);
		
		
		
		/**
		 * 
		 * delete
		 *
		 * 
		 */
		Document delete_document=new Document("type","database3");
		
		long delete_count=dbhelp.deleteData(collection_name, delete_document, 0);
		System.out.println("delete count is "+delete_count+"");
		
	}
	
	
	
	
}
