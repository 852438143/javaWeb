package com.ylw.wx;

import com.sun.istack.internal.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
//
//
/**验证来自微信服务端的消息
 * Created by 85243 on 2017/2/28.
 */
public class Verification extends HttpServlet {
    static Logger log = Logger.getLogger(Verification.class);

    /**
     *来自微信消息的验证！
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        log.info("signature:" + signature + " timestamp:" + timestamp + " nonce:" + nonce + " echostr:" + echostr);
        ArrayList<String> list = new ArrayList<>();
        list.add(nonce);
        list.add(timestamp);
        list.add(Util.token);
        Collections.sort(list);
        String afterSort = list.get(0) + list.get(1) + list.get(2);
        log.info("aftersort: " + list.get(0) + list.get(1) + list.get(2));
        String afterSHA = SHA1.getSha1(afterSort);
        log.info("agterSHA:" + afterSHA);
        if (afterSHA.equals(signature)) {
            log.info("afterSHA is equals signature" + afterSHA + "  " + signature);
            resp.getWriter().println(echostr);
        } else resp.getWriter().print("error");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        String result = CoreService.deal(req);
        log.info("result is :" +result);
        resp.getWriter().print(result);
    }
}
