package yuweixiang.first.test;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import yuweixiang.first.bigData.CollaborativeFiltering;

import java.io.File;

/**
 * 推荐测试类
 *
 * @author yuweixiang
 * @version $ Id: RecommodTest.java, v 0.1 16/6/3 下午5:38 yuweixiang Exp $
 */
public class RecommodTest {

    public static void main(String args[]) {
        CollaborativeFiltering collaborativeFiltering = new CollaborativeFiltering();
        try {
            System.out.println("皮尔逊,基于item:"+collaborativeFiltering.pearsonItemBaseRecommender(1L, 2, getDataModel()));
            System.out.println("皮尔逊,基于user:"+collaborativeFiltering.pearsonUserBaseRecommender(1L, 2, getDataModel()));
            System.out.println("欧几里德距离,基于user:"+collaborativeFiltering.euclideanUserBaseRecommender(1L, 2, getDataModel()));
            System.out.println("欧几里德距离,基于item:"+collaborativeFiltering.euclideanItemBaseRecommender(1L, 2, getDataModel()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据模型,分三种方式 1. 代码写入 2. 文件读取 3. bd读取
     *
     * @return 数据对象
     */
    public static DataModel getDataModel() {
        // 1. 设置用户信息
        // 1.1 通过代码来实现
//        FastByIDMap<PreferenceArray> preferences = new FastByIDMap<PreferenceArray>();

        //        PreferenceArray prefsForUser1 = new GenericUserPreferenceArray(10);
        //        prefsForUser1.setUserID(0, 1L);
        //        prefsForUser1.setItemID(0, 101L);
        //        prefsForUser1.setValue(0, 3.0f);
        //        prefsForUser1.setItemID(1, 102L);
        //        prefsForUser1.setValue(1, 4.5f);
        //        prefsForUser1.setItemID(2, 103L);
        //        prefsForUser1.setValue(2, 3.5f);
        //
        //        PreferenceArray prefsForUser2 = new GenericUserPreferenceArray(10);
        //        prefsForUser2.setUserID(0, 2L);
        //        prefsForUser2.setItemID(0, 101L);
        //        prefsForUser2.setValue(0, 3.0f);
        //        prefsForUser2.setItemID(1, 107L);
        //        prefsForUser2.setValue(1, 4.5f);
        //        prefsForUser2.setItemID(2, 108L);
        //        prefsForUser2.setValue(2, 3.5f);
        //
        //        PreferenceArray prefsForUser3 = new GenericUserPreferenceArray(10);
        //        prefsForUser2.setUserID(0, 3L);
        //        prefsForUser2.setItemID(0, 101L);
        //        prefsForUser2.setValue(0, 3.0f);
        //        prefsForUser2.setItemID(1, 107L);
        //        prefsForUser2.setValue(1, 4.5f);
        //        prefsForUser2.setItemID(2, 103L);
        //        prefsForUser2.setValue(2, 3.5f);
        //
        //        preferences.put(1L, prefsForUser1); //use userID as the key
        //        preferences.put(2L, prefsForUser2); //use userID as the key
        //        preferences.put(3L, prefsForUser3); //use userID as the key
        //        DataModel model = new GenericDataModel(preferences);

        // 1.2 通过文件读取
        try {
            DataModel model = new FileDataModel(new File("/Users/yuweixiang/Downloads/my/testData/Mahout.csv"));
            return model;
        }catch (Exception e){
            e.printStackTrace();
        }
        // 1.3 通过db获取
        //        MysqlDataSource dataSource = new MysqlDataSource();
        //        dataSource.setServerName("my_user");
        //        dataSource.setUser("my_password");
        //        dataSource.setPassword("my_database_host");
        //        JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "my_prefs_table",
        //                "my_user_column", "my_item_column", "my_pref_value_column");
        return null;
    }
}
