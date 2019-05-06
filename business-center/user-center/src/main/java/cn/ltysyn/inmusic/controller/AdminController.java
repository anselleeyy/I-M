package cn.ltysyn.inmusic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ltysyn.inmusic.commons.Response;
import cn.ltysyn.inmusic.commons.ReturnCode;
import cn.ltysyn.inmusic.entity.User;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/admin")
@Api(tags = "管理员接口类")
public class AdminController extends BaseController {
    
    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    
    @PostMapping(value = "/login")
    public Object login(@RequestBody User user) {
        LOG.info("管理员登录: {}", user);
        user = userService.checkLogin(user);
        Response response;
        if (null != user) {
            if (user.getAuthorities().size() > 0) {
                response = new Response(ReturnCode.ADMIN_LOGIN_SUCCEED, user);                
            } else {
                response = new Response(ReturnCode.ADMIN_LOGIN_AUTH_FAILED);
            }
        } else {
            response = new Response(ReturnCode.ADMIN_LOGIN_FAILED);
        }
        return response;
    }

}
