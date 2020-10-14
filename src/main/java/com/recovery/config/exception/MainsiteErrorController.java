package com.recovery.config.exception;


import com.recovery.util.Result;
import com.recovery.util.enums.ErrorEnum;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainsiteErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	/**
	 * 主要是登陆后的各种错误路径  404页面改为返回此json
	 * 未登录的情况下,大部分接口都已经被shiro拦截,返回让用户登录了
	 *
	 * @return 404的错误信息json
	 */
	@RequestMapping(value = ERROR_PATH)
	@ResponseBody
	public Result handleError() {
		return new Result(ErrorEnum.E_404);
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}

