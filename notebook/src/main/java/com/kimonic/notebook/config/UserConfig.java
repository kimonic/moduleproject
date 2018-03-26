package com.kimonic.notebook.config;

import android.content.Context;

import com.kimonic.utilsmodule.utils.SharedPreferencesUtils;

/**
 * * ===============================================================
 * name:             UserConfig
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/2/2
 * description：
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
}
