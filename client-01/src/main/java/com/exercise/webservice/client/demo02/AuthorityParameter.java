package com.exercise.webservice.client.demo02;

public class AuthorityParameter {
    /**
     * 用户名字段的名称
     */
    private String userNameKey;

    /**
     * 用户名字段的值
     */
    private String userNameValue;

    /**
     * 密码字段的名称
     */
    private String passwordKey;

    /**
     * 密码字段的值
     */
    private String passwordValue;

    public AuthorityParameter() {
        super();
    }

    /**
     * AuthorityParameter
     *
     * @param userNameKey   用户名的字段名称
     * @param userNameValue 用户名的字段值
     * @param passwordKey   密码的字段名称
     * @param passwordValue 密码的字段值
     */
    public AuthorityParameter(String userNameKey, String userNameValue, String passwordKey, String passwordValue) {
        super();
        this.userNameKey = userNameKey;
        this.userNameValue = userNameValue;
        this.passwordKey = passwordKey;
        this.passwordValue = passwordValue;
    }

    public String getUserNameKey() {
        return userNameKey;
    }

    public void setUserNameKey(String userNameKey) {
        this.userNameKey = userNameKey;
    }

    public String getUserNameValue() {
        return userNameValue;
    }


    public void setUserNameValue(String userNameValue) {
        this.userNameValue = userNameValue;
    }


    public String getPasswordKey() {
        return passwordKey;
    }


    public void setPasswordKey(String passwordKey) {
        this.passwordKey = passwordKey;
    }


    public String getPasswordValue() {
        return passwordValue;
    }


    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }
}