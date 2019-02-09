package servlets.echoservlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//Для передачи параметров от jsp диспетчеру в контроллере
public class DispathParams {
    private User user;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private List towns;

    public DispathParams(User user, HttpServletRequest req, HttpServletResponse resp, List towns) {
        this.user = user;
        this.req = req;
        this. resp = resp;
        this.towns = towns;
    }

    public User getUser() {
        return user;
    }

    public HttpServletRequest getReq() {
        return req;
    }

    public HttpServletResponse getResp() {
        return resp;
    }

    public List getTowns() {
        return towns;
    }



    public void setUser(User user) {
        this.user = user;
    }

    public void setReq(HttpServletRequest req) {
        this.req = req;
    }

    public void setResp(HttpServletResponse resp) {
        this.resp = resp;
    }

    public void setTowns(List towns) {
        this.towns = towns;
    }
}
