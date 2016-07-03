package yuweixiang.first.bigData;

import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.util.List;


/**
 * 系统过滤算法类
 *
 * @author yuweixiang
 * @version $ Id: CollaborativeFiltering.java, v 0.1 16/6/3 下午6:37 yuweixiang Exp $
 */
public class CollaborativeFiltering {

    /**
     * 协同过滤 -- 基于皮尔逊相关系数算法,基于用户
     *
     * @param userId 用户id
     * @param howMany 需要推荐的数量
     * @param model 模型
     * @return 推荐结果
     */
    public static List<RecommendedItem> pearsonUserBaseRecommender(long userId,
                                                                   int howMany, DataModel model) throws Exception {

        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(4, similarity, model);
        Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        return recommender.recommend(userId, howMany);
    }

    /**
     * 协同过滤 -- 基于皮尔逊相关系数算法,基于商品
     *
     * @param userId 用户id
     * @param howMany 需要推荐的数量
     * @param model 模型
     * @return 推荐结果
     */
    public static List<RecommendedItem> pearsonItemBaseRecommender(long userId,
                                                                   int howMany, DataModel model) throws Exception {

        ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
        Recommender recommender = new GenericItemBasedRecommender(model, similarity);
        return recommender.recommend(userId, howMany);
    }

    /**
     * 协同过滤 -- 基于欧几里德距离相关系数算法,基于用户
     *
     * @param userId 用户id
     * @param howMany 需要推荐的数量
     * @param model 模型
     * @return 推荐结果
     */
    public static List<RecommendedItem> euclideanUserBaseRecommender(long userId,
                                                                   int howMany, DataModel model) throws Exception {

        UserSimilarity similarity = new EuclideanDistanceSimilarity(model);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(4, similarity, model);
        Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        return recommender.recommend(userId, howMany);
    }

    /**
     * 协同过滤 -- 基于欧几里德距离相关系数算法,基于商品
     *
     * @param userId 用户id
     * @param howMany 需要推荐的数量
     * @param model 模型
     * @return 推荐结果
     */
    public static List<RecommendedItem> euclideanItemBaseRecommender(long userId,
                                                                   int howMany, DataModel model) throws Exception {

        ItemSimilarity similarity = new EuclideanDistanceSimilarity(model);
        Recommender recommender = new GenericItemBasedRecommender(model, similarity);
        return recommender.recommend(userId, howMany);
    }
}
