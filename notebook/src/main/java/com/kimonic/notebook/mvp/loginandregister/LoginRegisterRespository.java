package com.kimonic.notebook.mvp.loginandregister;

import android.content.Context;

import com.kimonic.notebook.config.UserConfig;
import com.kimonic.notebook.litemapbean.fixedassets.DataNameTableLMBean;
import com.kimonic.utilsmodule.utils.MD5Utils;

import org.litepal.crud.DataSupport;

/**
 * * ===============================================================
 * name:             LoginRegisterRespository
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/27
 * method:
 * <p>
 * <p>
 * description：  注册登陆respository
 * history：
 * *==================================================================
 */

public class LoginRegisterRespository {

    /**验证用户名密码是否正确*/
    public int  checkPassword(String userName,String password){
        String encodeUserName= MD5Utils.md5(userName);
        String encodePassword= MD5Utils.md5(password);
        return DataSupport.where("user = ? and passWord =?",encodeUserName,encodePassword)
                .find(DataNameTableLMBean.class)
                .size();
    }

    /**检查用户名是否已存在*/
    public int checkUserName(String userName){
        String encodeUserName= MD5Utils.md5(userName);
        return DataSupport.where("user = ?",encodeUserName)
                .find(DataNameTableLMBean.class)
                .size();
    }
    /**保存注册的用户名密码*/
    public void saveUserNamePassWord(String userName, String password, Context context){
        //保存用户配置
        UserConfig.getInstance().setUserName(context,userName);//用户名
        UserConfig.getInstance().setLogin(context,true);//登陆状态
        UserConfig.getInstance().setLoginDate(context);//成功登陆日期

        String encodeUserName= MD5Utils.md5(userName);
        String encodePassword= MD5Utils.md5(password);
        DataNameTableLMBean bean=new DataNameTableLMBean();
        bean.setUser(encodeUserName);
        bean.setPassWord(encodePassword);
        bean.save();
    }
}
