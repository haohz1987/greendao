package com.hhz.greendao.db;


import android.content.Context;

import com.hhz.greendao.dao.DaoMaster;
import com.hhz.greendao.dao.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * 用于获取DaoMaster和DaoSession
 */

public class DbCore {
    private static final String DEFAULT_DB_NAME = "appdata.db";
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    private static Context mContext;
    private static String DB_NAME;

    public static void init(Context context) {
        init(context, DEFAULT_DB_NAME);
    }

    public static void init(Context context, String dbName) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        mContext = context.getApplicationContext();
        DB_NAME = dbName;
    }

    public static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            //此处不可用 DaoMaster.DevOpenHelper, 那是开发辅助类，我们要自定义一个，方便升级
            DaoMaster.OpenHelper helper = new MyOpenHelper(mContext, DB_NAME);
            daoMaster = new DaoMaster(helper.getEncryptedReadableDb("123456"));//数据加密
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    public static void enableQueryBuilderLog(){
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }
}
