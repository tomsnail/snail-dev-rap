package com.taobao.rigel.rap.tester.web.action;

import com.taobao.rigel.rap.common.base.ActionBase;
import com.taobao.rigel.rap.common.utils.JsonFormatUtils;
import com.taobao.rigel.rap.organization.service.OrganizationMgr;
import com.taobao.rigel.rap.project.bo.Action;
import com.taobao.rigel.rap.project.bo.ActionHttp;
import com.taobao.rigel.rap.project.bo.Page;
import com.taobao.rigel.rap.project.service.ProjectMgr;


public class TesterAction extends ActionBase {

    private ProjectMgr projectMgr;
    private int id;
    private Page page;
    private int projectId;
    private String url;
    private OrganizationMgr organizationMgr;

    private int actionId;
    private String requestUrl;
    private String requestContext;
    private String responseContext;
    private String requsetContextHtml;
    private ActionHttp actionHttp;
    private String type;
    
    private String actionName;
    private String actionVersion;
    
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public OrganizationMgr getOrganizationMgr() {
        return organizationMgr;
    }

    public void setOrganizationMgr(OrganizationMgr organizationMgr) {
        this.organizationMgr = organizationMgr;
    }

    public int getProjectId() {
        return projectId;
    }

    public Page getPage() {
        return page;
    }

    public ProjectMgr getProjectMgr() {
        return projectMgr;
    }

    public void setProjectMgr(ProjectMgr projectMgr) {
        this.projectMgr = projectMgr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String pageTester() {

        if (!isUserLogined()) {
            plsLogin();
            setRelativeReturnUrl("/tester/pageTester.do?id="
                    + id);
            return LOGIN;
        }

        if (!organizationMgr.canUserAccessPage(getCurUserId(), id)) {
            setErrMsg(ACCESS_DENY);
            return ERROR;
        }

        page = projectMgr.getPage(id);
        projectMgr.loadParamIdListForPage(page);
        projectId = page.getModule().getProject().getId();
        return SUCCESS;
    }

    public String test() {
        /**
         SystemVisitorLog.clear(projectMgr);
         System.out.println("Clear complete!");
         setJson("clear complete");
         */
        return SUCCESS;
    }

    /**
     * used for system configuration when new version deployed
     *
     * @return
     */
    public String ___init___() throws Exception {


        return SUCCESS;
    }

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(String requestContext) {
		this.requestContext = requestContext;
	}

	public String getResponseContext() {
		return responseContext;
	}

	public void setResponseContext(String responseContext) {
		this.responseContext = responseContext;
	}

	

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionVersion() {
		return actionVersion;
	}

	public void setActionVersion(String actionVersion) {
		this.actionVersion = actionVersion;
	}

	public ActionHttp getActionHttp() {
		return actionHttp;
	}

	public void setActionHttp(ActionHttp actionHttp) {
		this.actionHttp = actionHttp;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public String getRequsetContextHtml() {
		return requsetContextHtml;
	}

	public void setRequsetContextHtml(String requsetContextHtml) {
		this.requsetContextHtml = requsetContextHtml;
	}

	public String getActionHttpInfo() {
		ActionHttp _actionHttp =  projectMgr.getActionHttp(getActionId());
		actionHttp = new ActionHttp();
		actionHttp.setActionId(_actionHttp.getActionId());
		actionHttp.setId(_actionHttp.getId());
		actionHttp.setRequestUrl(_actionHttp.getRequestUrl());
		actionHttp.setRequestContext(_actionHttp.getRequestContext());
		requsetContextHtml = JsonFormatUtils.formatJson(_actionHttp.getRequestContext());
		actionHttp.setResponseContext(JsonFormatUtils.formatJson(_actionHttp.getResponseContext()));
		Action action = projectMgr.getAction(getActionId());
		actionName = action.getName();
		actionVersion = action.getVersion();
		actionId = action.getId();
		return SUCCESS;
	}

	public String saveOrUpdateActionHttp() {
		ActionHttp actionHttp = new ActionHttp();
		actionHttp.setActionId(getActionId());
		actionHttp.setRequestContext(getRequestContext()==null?null:getRequestContext().replaceAll(" ","").replace("\n", ""));
		actionHttp.setRequestUrl(getRequestUrl());
		actionHttp.setResponseContext(getResponseContext()==null?null:getResponseContext().replaceAll(" ","").replace("\n", ""));
		int result = projectMgr.saveOrUpdateActionHttp(actionHttp, getType());
		if(result==1){
			setJson("SUCCESS");
		}else{
			setJson("ERROR");
		}
		return SUCCESS;
	}
	
	public String jsJsonFormat(){
		String t = getRequestContext();
		setJson(JsonFormatUtils.formatJson(t));
		return SUCCESS;
	}
	
	public String httptest(){
		System.out.println(getRequestUrl());
		setJson("1232435");
		return SUCCESS;
	}
}
