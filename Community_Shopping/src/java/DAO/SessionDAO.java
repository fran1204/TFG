/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author fmrodriguez
 */
public class SessionDAO implements SessionAware{
    
    private static Map<String, Object> sessionMap;

    public SessionDAO() {
        sessionMap = ActionContext.getContext().getSession();
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = map;
    }
    public Map<String, Object> getSession() {
        return sessionMap;
    }
    
    public boolean existeSesion(){
        return !sessionMap.isEmpty();
    }
    
    public void destroySession(){
        sessionMap.clear();
    }
    
    
    
}
