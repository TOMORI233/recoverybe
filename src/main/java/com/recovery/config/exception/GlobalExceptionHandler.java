package com.recovery.config.exception;


import com.recovery.util.Result;
import com.recovery.util.enums.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@ExceptionHandler(value = Exception.class)
	public Result defaultErrorHandler(HttpServletRequest req, Exception e) {
		String errorPosition = "";
		//如果错误堆栈信息存在
		if (e.getStackTrace().length > 0) {
			StackTraceElement element = e.getStackTrace()[0];
			String fileName = element.getFileName() == null ? "未找到错误文件" : element.getFileName();
			int lineNumber = element.getLineNumber();
			errorPosition = fileName + ":" + lineNumber;
		}
		Result result = new Result(ErrorEnum.E_400.getErrorCode(), e.toString() + "  错误位置:" + errorPosition);
		logger.error("异常", e);
		return result;
	}

	/**
	 * GET/POST请求方法错误的拦截器
	 * 因为开发时可能比较常见,而且发生在进入controller之前,上面的拦截器拦截不到这个错误
	 * 所以定义了这个拦截器
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Result httpRequestMethodHandler() {
		return new Result(ErrorEnum.E_500);
	}

	/**
	 * 请求参数错误 @requestBody
	 * Required  parameter is not present
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	public Result badRequest(HttpMessageNotReadableException e){
		logger.error(e.getMessage());
		return new Result(ErrorEnum.E_501);
	}
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
//	@ResponseStatus(value= HttpStatus.BAD_REQUEST)
	public Result illegalArgumentRequest(InvalidDataAccessApiUsageException e){
		logger.error(e.getMessage());
		return new Result(ErrorEnum.E_501);
	}
	/**
	 * 本系统自定义错误的拦截器
	 * 拦截到此错误之后,就返回这个类里面的json给前端
	 * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
	 */
	@ExceptionHandler(CommonJsonException.class)
	public Result commonJsonExceptionHandler(CommonJsonException commonJsonException) {
		return new Result(commonJsonException.getError());
	}

	/**
	 * 权限不足报错拦截
	 */
//	@ExceptionHandler(UnauthorizedException.class)
//	public JSONObject unauthorizedExceptionHandler() {
//		return CommonUtil.errorJson(ErrorEnum.E_502);
//	}

	/**
	 * 未登录报错拦截
	 * 在请求需要权限的接口,而连登录都还没登录的时候,会报此错
	 */
//	@ExceptionHandler(UnauthenticatedException.class)
//	public JSONObject unauthenticatedException() {
//		return CommonUtil.errorJson(ErrorEnum.E_20011);
//	}
}
