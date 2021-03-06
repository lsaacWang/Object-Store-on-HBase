package com.wanghui.bigdata.hos.core.usermgr;

import com.wanghui.bigdata.hos.core.usermgr.model.UserInfo;

/**
 * Created by jixin on 18-3-8.
 */
public interface IUserService {

  public boolean addUser(UserInfo userInfo);

  public boolean updateUserInfo(String userId, String password, String detail);

  public boolean deleteUser(String userId);

  public UserInfo getUserInfo(String userId);

  public UserInfo checkPassword(String userName, String password);

  public UserInfo getUserInfoByName(String userName);
}
