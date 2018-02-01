#简单引用greendao3步骤

>配置build.gradle

#app

     dependencies {
            classpath 'com.android.tools.build:gradle:3.0.1'
            classpath 'org.greenrobot:greendao-gradle-plugin:3.2.1'
      }
      
#module

      apply plugin: 'org.greenrobot.greendao'
      greendao {
          schemaVersion 1                         //版本号，升级数据库版本时配置
          daoPackage'com.handpay.laucher.dao'     //包名
          targetGenDir'src/main/java'             //生成目录
      }
      dependencies {
          implementation fileTree(dir: 'libs', include: ['*.jar'])
          implementation 'com.android.support:appcompat-v7:26.1.0'
          implementation 'org.greenrobot:greendao:3.2.0'
      }
      
>创建实体类

#创建entitiy -> AppData

    @Entity
    public class AppData {
        @Id
        public Long id;
        ……
    }
    字段新增，添加后重新make project
    
#创建dao

    同module中配置的daoPackage，创建空目录，然后make project，生成对应的Dao/DaoMaster/DaoSession文件
    ，自动补全AppData中的get,set方法，构造函数。    

>创建操作类

#辅助类-增删改查

     * DbCore，用于获取DaoMaster和DaoSession，
     * BaseDbHelper, 基础的泛型辅助类，封装基本增删改查方法
     * 创建自定义辅助类
         public class MyOpenHelper extends DaoMaster.OpenHelper {
             public MyOpenHelper(Context context, String name) {
                 super(context, name);
             }
             //增删改查
             ……
         }
    * 如果需要进行数据加密，添加
         implementation 'net.zetetic:android-database-sqlcipher:3.5.4'//数据库加密
         DbCore中添加，
         daoMaster = new DaoMaster(helper.getEncryptedReadableDb("pwd"));
         
    * 实现类，有几个实体类就有几个实现类，这里是 AppDataHelper,
        public class AppDataHelper extends BaseDbHelper<AppData, Long> {
            public AppDataHelper(AbstractDao dao) {
                super(dao);
            }
        }
    * 获取表 Helper 的工具类DbUtil    
    * 在 application 里初始化 DbCore.init(this);  
     
