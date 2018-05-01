package com.taobao.rigel.rap.project.bo;

import java.util.Iterator;

import com.taobao.rigel.rap.common.utils.StringUtils;

public class ActionHttp implements java.io.Serializable{
	
	private int id;
	private int actionId;
	private String responseContext;
	private String requestContext;
	private String requestUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActionId() {
		return actionId;
	}
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}
	public String getResponseContext() {
		return responseContext;
	}
	public void setResponseContext(String responseContext) {
		this.responseContext = responseContext;
	}
	public String getRequestContext() {
		return requestContext;
	}
	public void setRequestContext(String requestContext) {
		this.requestContext = requestContext;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
	
	 public String toString() {
	        StringBuilder stringBuilder = new StringBuilder();

	        stringBuilder.append("{\"id\":" + getId() + ",");
	        stringBuilder.append("\"actionId\":\"" + getActionId()
	                + "\",");
	        stringBuilder.append("\"reqeustContext\":\"" + StringUtils.escapeInJ(getRequestContext())
	                + "\",");
	        stringBuilder.append("\"responseContext\":\"" + StringUtils.escapeInJ(getResponseContext())
	        + "\",");
	        stringBuilder.append("\"requestUrl\":\"" + StringUtils.escapeInJ(getRequestUrl())
	                + "\",");
	        stringBuilder.append("}");
	        return stringBuilder.toString();
	    }

}
