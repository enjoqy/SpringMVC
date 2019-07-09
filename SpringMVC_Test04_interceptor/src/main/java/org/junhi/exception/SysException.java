package org.junhi.exception;

/**
 * 自定义异常类
 *
 * @author junhi
 * @date 2019/7/9 17:14
 */
public class SysException extends Exception {

    //存储提示信息用的
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
