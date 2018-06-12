package com.darclejf.models;

/**
 * @author DarcleJF
 * 
 */
public class ResponseModel {
    private Object result;
    private boolean success;
    private String message;
    
    public ResponseModel() {

    }

    public ResponseModel(Object data, boolean success, String message) {
        this.result = data;
        this.success = success;
        this.message = message;
    }

    /**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}
    
    /**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}
    
    /**
	 * @return the success
	 */
	public boolean getSuccess() {
		return success;
	}
    
    /**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
    
    /**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
    
    /**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}