package com.recovery.config.exception;

import com.recovery.util.enums.ErrorEnum;
import lombok.Getter;
import lombok.Setter;

public class CommonJsonException extends RuntimeException {
	@Getter
	@Setter
	private ErrorEnum error;

	/**
	 * @param errorEnum 以错误的ErrorEnum做参数
	 */
	public CommonJsonException(ErrorEnum errorEnum) {
		this.error = errorEnum;
	}

}
