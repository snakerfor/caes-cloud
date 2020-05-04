package com.ruoyi.common.auth.token;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.redis.util.RedisUtils;
import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("checkToken")
// 通用 token鉴权
public class CheckToken {
    @Autowired
    private RedisUtils redis;

    private final static String ACCESS_TOKEN  = Constants.ACCESS_TOKEN;

    // token取得用户信息
    private SysUser getUserInfo(String token) {
        return redis.get(ACCESS_TOKEN + token, SysUser.class);
    }

    // 验证token授权
    public boolean hasTokenAuth(String token) {
        return getUserInfo(token) != null;
    }

    // 鉴别管理员权限
    public boolean isAdminTokenAuth(String token) {
        return getUserInfo(token).isAdmin();
    }
}
