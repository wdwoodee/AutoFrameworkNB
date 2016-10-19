package com.auto.test.dbmodel;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**  
 * 类说明   
 *  
 * @author luozt  
 * @date 2016年9月19日  新建  
 */
public class DBConnUtil {
	
	
	


	public  String ip;
	public  int port;
	public  String dbname;
	String username;
	String passwd;
	MongoClient mongoClient;
	MongoDatabase db;
	FindIterable<Document> cursor=null;
	long update_count=0;
	long delete_count=0;
	
	
	public DBConnUtil(String ip,int port,String dbname,String username,String passwd){
		
		this.ip=ip;
		this.port=port;
		this.dbname=dbname;	
		this.username=username;
		this.passwd=passwd;
	}
	
	
	public MongoDatabase  conn()
	   {
		 MongoCredential credential = MongoCredential.createScramSha1Credential(username,"admin",passwd.toCharArray());
		 ServerAddress addr = new ServerAddress(ip, port);  
		 mongoClient = new MongoClient(addr,Arrays.asList(credential));
		 db = mongoClient.getDatabase(dbname);
		 
		 
		 return db;
		
	   }
	
	/**query data from database
	 * 
	 * @param collection_name
	 * @param document 为查询条件
	 * @param  document_projection为只返回需要的字段
	 * @return
	 * crud method please see http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/
	 */
	
	@SuppressWarnings("unchecked")
	public FindIterable<Document> queryData(String collection_name,Bson document,int flag){
		//collection_name为要查询的collection名字
		MongoCollection<Document> coll = db.getCollection(collection_name);
		
		if(flag==0){
			//0 代表查询所有
			cursor=coll.find(document);
		}
		else if(flag==1){
			//1 代表只查询一条数据
			cursor=(FindIterable<Document>) coll.find(document).first();
			
		}
		
		else if(flag==2){
			//2 代表没有查询条件
			cursor=coll.find();
			
		}
        return cursor;
	}
	
    @SuppressWarnings("unchecked")
	public FindIterable<Document> queryData(String collection_name,Bson document,Bson document_projection,int flag){
		
		MongoCollection<Document> coll = db.getCollection(collection_name);
		if(flag==0){
			//0 代表查询所有
		cursor=coll.find(document).projection(document_projection);
		}
		
		else if(flag==1){
			//1 代表只查询一条数据
			cursor=(FindIterable<Document>) coll.find(document).projection(document_projection).first();
		}
		
		else if(flag==2){
			//2 代表没有查询条件
			cursor=coll.find().projection(document_projection);
		}
        return cursor;
	}
	
	
    
    /**insert data to database;
	 * 
	 * crud method please see http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/
	 */
	public void insertData(String collection_name,ArrayList<Document> documents){
		
		
		MongoCollection<Document> coll = db.getCollection(collection_name);
		
		coll.insertMany(documents);
		
		
	}
	
	
	/**
	 * 
	 * update data to database
	 * 
	 * filter 通过此filter过滤需要更新的数据
	 * update 需要更新的内容
	 * 
	 * 
	 * 
	 * crud method please see http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/
	 */
	
	
	public long updateData(String collection_name,Bson filter,Bson update,int flag){
		
		
		MongoCollection<Document> coll = db.getCollection(collection_name);
		if(flag==0){
			update_count=coll.updateMany(filter, update).getModifiedCount();
		//	return update_count;
		}
		
		else if(flag==1){
			
			update_count=coll.updateOne(filter, update).getModifiedCount();
		//	return update_count;
		}
		return update_count;
	}
	
	
	
	
	/**
	 * 
	 * remove data from database
	 * 
	 * filter 通过此filter去过滤需要删除的数据
	 * crud method please see http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/
	 */
	
	public long deleteData(String collection_name,Bson filter,int flag){
		
		MongoCollection<Document> coll = db.getCollection(collection_name);
		if(flag==0){
			
			delete_count=coll.deleteMany(filter).getDeletedCount();
		//	return delete_count;
		}
		else if(flag==1){
			
			delete_count=coll.deleteOne(filter).getDeletedCount();
		//	return delete_count;
			
		}
		
		return delete_count;
	}
	


}
