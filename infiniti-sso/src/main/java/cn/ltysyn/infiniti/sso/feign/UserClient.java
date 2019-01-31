package cn.ltysyn.infiniti.sso.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ltysyn.infiniti.common.model.LoginAppUser;

@FeignClient(value = "user-center")
public interface UserClient {
	
	/**
	 * feign rpc 访问远程 /users-anon/login 接口
	 * @param username
	 * @return
	 */
	@GetMapping(value = "/users-anon/login", params = "username")
	LoginAppUser findByUsername(@RequestParam(value = "username") String username);

}
