package org.zk.application.core.exception;

public class ZkException extends Exception{
	public ZkException(){
		
	}

	public ZkException(String message){
		super(message);
	}
	
	public ZkException(Exception exception){
		super(exception);
	}
}
