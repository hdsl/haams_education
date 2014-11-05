/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package haams.web.utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bryte
 */
public class SessionClass 
{
    
    public static HttpSession getSession()
    {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
    
    public static ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }
}
