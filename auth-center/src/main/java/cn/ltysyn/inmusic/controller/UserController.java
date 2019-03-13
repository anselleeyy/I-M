package cn.ltysyn.inmusic.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	//暴露Remote Token Services接口
    //如果其它服务需要验证Token，则需要远程调用授权服务暴露的验证Token的API接口
    @GetMapping(value = "/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

}
