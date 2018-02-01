package com.hhz.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hhz.greendao.dao.AppDataDao;
import com.hhz.greendao.dao.DaoMaster;
import com.hhz.greendao.db.AppDataHelper;
import com.hhz.greendao.db.DbUtil;
import com.hhz.greendao.entity.AppData;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AppData> addDataList = new ArrayList<>();//操作的数据
    private AppDataHelper appDataHelper;
    private int i=1;
    private TextView tv_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_db = findViewById(R.id.tv_db);
        LogT.w("数据库版本："+ DaoMaster.SCHEMA_VERSION);
        //获取操作类
        appDataHelper = DbUtil.getAppDataHelper();

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppData addData = new AppData();
                addData.setBgColor(R.color.colorAccent);
                addData.setLabel("新增db标题"+i);
                addData.setHasUpdate(true);
                addData.setLoadedSize(1045+i*10);
                addData.setBgIndex(1+i);

                i++;
                addDataList.add(addData);
                appDataHelper.save(addData);
                tv_db.setText(addDataList.toString());
            }
        });
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataList = appDataHelper.queryAll();
                if (addDataList.size() > 0) {
                    AppData deleData = addDataList.get(addDataList.size() - 1);
                    //删除上一条记录
                    appDataHelper.delete(deleData);

                }else{
                    tv_db.setText("");
                    Toast.makeText(MainActivity.this,"没有数据",Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataList = appDataHelper.queryAll();
                LogT.w("所有列表："+addDataList.toString());
                if (addDataList.size() > 0) {
                    LogT.w("查询："+addDataList.toString());
                    tv_db.setText(addDataList.toString());

                }else{
                    tv_db.setText("");
                    Toast.makeText(MainActivity.this,"没有数据",Toast.LENGTH_SHORT).show();
                }

            }
        });
        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataList = appDataHelper.queryAll();
                if (addDataList.size() > 0) {
                    List<AppData> queryList= new ArrayList<>();
                    //获取BgIndex=3的数据
                    Query<AppData> query = appDataHelper.queryBuilder()
                            .where(AppDataDao.Properties.BgIndex.eq("3"))
                            .build();
                    queryList = query.list();
                    LogT.w("查询到bgIndex=3的列表："+queryList.toString());
                    tv_db.setText("查询到bgIndex=3的列表："+queryList.toString());
                }else{
                    tv_db.setText("");
                    Toast.makeText(MainActivity.this,"没有数据",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
