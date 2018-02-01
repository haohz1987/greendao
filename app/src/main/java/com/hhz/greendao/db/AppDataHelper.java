package com.hhz.greendao.db;

import com.hhz.greendao.entity.AppData;

import org.greenrobot.greendao.AbstractDao;

/**
 *  具体表的实现类
 */
public class AppDataHelper extends BaseDbHelper<AppData, Long> {
    public AppDataHelper(AbstractDao dao) {
        super(dao);
    }
}
