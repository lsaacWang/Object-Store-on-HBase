package com.wanghui.bigdata.hos.web.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wanghui.bigdata.hos.web.security.ContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.wanghui.bigdata.hos.core.ErrorCodes;
import com.wanghui.bigdata.hos.core.usermgr.model.UserInfo;

/**
 * Created by jixin on 18-3-14.
 */
@Controller
public class LoginController extends BaseController {

  @RequestMapping("/")
  public String logIn(HttpServletRequest request) {
    return "index.html";
  }

  @RequestMapping("/loginPost")
  @ResponseBody
  public Object loginPost(String username, String password, HttpSession session)
      throws IOException {
    if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password)) {
      return getError(ErrorCodes.ERROR_PERMISSION_DENIED, "username or password can not be null");
    }
    UserInfo userInfo = operationAccessControl.checkLogin(username, password);
    if (userInfo != null) {
      session.setAttribute(ContextUtil.SESSION_KEY, userInfo.getUserId());
      return getResult("success");
    } else {
      return getError(ErrorCodes.ERROR_PERMISSION_DENIED, "login error");
    }
  }

  @GetMapping("/logout")
  @ResponseBody
  public Object logout(HttpSession session) {
    session.removeAttribute(ContextUtil.SESSION_KEY);
    return getResult("success");
  }
}
