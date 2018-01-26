package com.handpay.laucher.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.handpay.laucher.entity.AppData;

import com.handpay.laucher.dao.AppDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig appDataDaoConfig;

    private final AppDataDao appDataDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        appDataDaoConfig = daoConfigMap.get(AppDataDao.class).clone();
        appDataDaoConfig.initIdentityScope(type);

        appDataDao = new AppDataDao(appDataDaoConfig, this);

        registerDao(AppData.class, appDataDao);
    }
    
    public void clear() {
        appDataDaoConfig.clearIdentityScope();
    }

    public AppDataDao getAppDataDao() {
        return appDataDao;
    }

}
