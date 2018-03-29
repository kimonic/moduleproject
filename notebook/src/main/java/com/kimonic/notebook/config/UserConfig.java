package com.kimonic.notebook.config;

import android.content.Context;
import android.text.TextUtils;

import com.kimonic.utilsmodule.utils.LUtils;
import com.kimonic.utilsmodule.utils.SharedPreferencesUtils;
import com.kimonic.utilsmodule.utils.TimeUtils;

/**
 * * ===============================================================
 * name:             UserConfig
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：  用户信息配置
 * history：
 * *==================================================================
 */

public class UserConfig {
    /**
     * 单实例
     */
    private static UserConfig mUserConfig;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 支出记录是否修改
     */
    private boolean expenditureChange;
    /**
     * 收入记录是否修改
     */
    private boolean incomeChange;
    /**
     * 备忘录是否修改
     */
    private boolean memorandumChange;
    /**
     * 是否是免登陆状态
     */
    private boolean isLogin;
    /**
     * 成功登陆日期,用于判断登陆状态是否有效
     */
    private String loginDate = "";


    /**
     * 私有构造函数
     */
    private UserConfig() {

    }

    /**
     * @return UserConfig
     */
    public synchronized static UserConfig getInstance() {
        if (null == mUserConfig) {
            mUserConfig = new UserConfig();
        }
        return mUserConfig;
    }


    /**
     * 获取当前用户名
     */
    public String getUserName(Context context) {
        if (null == userName) {
            try {
                userName =
                        SharedPreferencesUtils.getInstance(context, Constants.USER_CONFIG)
                                .getString(Constants.USER_NAME, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (userName == null) {//此处进行未登陆处理
            return "";
        }
        return userName;
    }

    /**
     * 设置并保存username
     */
    public void setUserName(Context context, String username) {
        try {
            SharedPreferencesUtils.getInstance(context, Constants.USER_CONFIG)
                    .put(Constants.USER_NAME, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.userName = username;
    }

    public boolean isExpenditureChange() {
        return expenditureChange;
    }

    public void setExpenditureChange(boolean expenditureChange) {
        this.expenditureChange = expenditureChange;
    }

    public boolean isIncomeChange() {
        return incomeChange;
    }

    public void setIncomeChange(boolean incomeChange) {
        this.incomeChange = incomeChange;
    }

    /**
     * 备忘录是否修改
     */
    public boolean isMemorandumChange() {
        return memorandumChange;
    }

    /**
     * 备忘录是否修改
     */
    public void setMemorandumChange(boolean memorandumChange) {
        this.memorandumChange = memorandumChange;
    }

    /**
     * 是否是免登陆状态
     */
    public boolean isLogin(Context context) {
        try {
            return SharedPreferencesUtils.getInstance(context, Constants.USER_CONFIG)
                    .getBoolean(Constants.IS_LOGIN, false);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是否是免登陆状态
     */
    public void setLogin(Context context, boolean isLogin) {
        this.isLogin = isLogin;
        try {
            SharedPreferencesUtils.getInstance(context, Constants.USER_CONFIG)
                    .put(Constants.IS_LOGIN, isLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 成功登陆日期,用于判断登陆状态是否有效
     */
    public String getLoginDate(Context context) {
        try {
            loginDate = SharedPreferencesUtils.getInstance(context, Constants.USER_CONFIG)
                    .getString(Constants.LOGIN_DATE, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginDate;
    }

    /**
     * 成功登陆日期,用于判断登陆状态是否有效
     */
    public void setLoginDate(Context context) {
        this.loginDate = TimeUtils.getNowDateShort();
        try {
            SharedPreferencesUtils.getInstance(context, Constants.USER_CONFIG)
                    .put(Constants.LOGIN_DATE, loginDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**登陆状态是否有效
     *true--无效
     * false--有效
     */
    public boolean invalideLogin(Context context) {
        getLoginDate(context);//获取上次成功登陆日期
        LUtils.e(UserConfig.class,"logflag--loginDate-"+loginDate);

        if (TextUtils.isEmpty(loginDate)) {
            clear(context);
            return true;
        } else {
            //上次成功登陆日期距离今天已经超过3天,则登陆失效
            if (TimeUtils.differenceDaate(loginDate,TimeUtils.getNowDateShort())>3){
                clear(context);
                return true;
            }else {
                isLogin=true;
            }
        }
        return false;
    }

    /**清除用户状态*/
    public void clear(Context context){
        userName = "";
        isLogin = false;
        setUserName(context, "");
        setLogin(context, false);
        SharedPreferencesUtils.getInstance(context, Constants.USER_CONFIG)
                .put(Constants.LOGIN_DATE, "");
    }

    //退出登陆时,清除用户名,清除登陆状态
}
