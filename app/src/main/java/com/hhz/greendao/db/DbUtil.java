/*
******************************* Copyright (c)*********************************\
**
**                 (c) Copyright 2015, 蒋朋, china, qd. sd
**                          All Rights Reserved
**
**                           By()
**                         
**-----------------------------------版本信息------------------------------------
** 版    本: V0.1
**
**------------------------------------------------------------------------------
********************************End of Head************************************\
*/

package com.hhz.greendao.db;

import com.hhz.greendao.dao.AppDataDao;

/**
 *  获取表 Helper 的工具类
 */
public class DbUtil {
    private static AppDataHelper appDataHelper;


    private static AppDataDao getDriverDao() {
        return DbCore.getDaoSession().getAppDataDao();
    }

    public static AppDataHelper getAppDataHelper() {
        if (appDataHelper == null) {
            appDataHelper = new AppDataHelper(getDriverDao());
        }
        return appDataHelper;
    }


}
