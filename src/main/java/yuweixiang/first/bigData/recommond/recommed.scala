package yuweixiang.first.bigData.recommond

import org.apache.spark.mllib.evaluation.RegressionMetrics
import org.apache.spark.mllib.recommendation.{ALS, Rating}
import org.apache.spark.{SparkContext, SparkConf}
import org.jblas.DoubleMatrix
import yuweixiang.first.bigData.bigdata_util.CommonUtil

object Recommed {
  def main(args: Array[String]) {
    def sparkConf = new SparkConf();
    val sc = new SparkContext("local[2]", "First Spark App", sparkConf)
    val rawData = sc.textFile("/Users/yuweixiang/Downloads/my/spark/data/ml-100k/u.data")
    val rawRatings = rawData.map(_.split("\t").take(3))
    val ratings = rawRatings.map { case Array(user, movie, rating) => Rating(user.toInt, movie.toInt, rating.toDouble) }
    val model = ALS.train(ratings, 50, 10, 0.01)
    val topKeys = model.recommendProducts(789, 10);
    // 基于用户推荐
    println(topKeys.mkString("\n"))

    //titles
    val movies = sc.textFile("/Users/yuweixiang/Downloads/my/spark/data/ml-100k/u.item")
    val titles = movies.map(_.split("\\|").take(2)).map(array => (array(0).toInt, array(1))).collectAsMap()
    println(titles(123))

    // 基于商品推荐 --通过计算每个商品余弦相似度来计算相似的商品
    val itemId = 567
    val itemFactor = model.productFeatures.lookup(itemId).head
    val itemVector = new DoubleMatrix(itemFactor)
    val sims = model.productFeatures.map { case (id, factor) =>
      val factorVector = new DoubleMatrix(factor)
      val sim = CommonUtil.consinSimilarity(factorVector, itemVector)
      (id, sim)
    }
    // 对数据进行排序,然后处理
    val sortedSims = sims.top(10)(Ordering.by[(Int, Double), Double] {
      case (id, similarity) => similarity
    })
    println(sortedSims.take(10).mkString("\n"))
    println(titles(itemId))

    // 计算模型的可靠性
    // MSE用于显示评级的情形:
    // 均方差:个平方误差的和与总数木的商(math.pow((actual-predicted),2))的和/count
    val usersProducts = ratings.map { case Rating(user, product, rating) => (user, product) }
    val predictions = model.predict(usersProducts).map { case Rating(user, product, rating) => ((user, product), rating) }
    val ratingsAndPredictions = ratings.map { case Rating(user, product, rating) => ((user, product), rating) }.join(predictions)
    val predictAndTrue = ratingsAndPredictions.map { case ((user, product), (preducted, actual)) => (preducted, actual) }
    val regressionMetrics = new RegressionMetrics(predictAndTrue)
    println("Mean Squared Error == " + regressionMetrics.meanSquaredError)
    println("Root Mean Squared Error == " + regressionMetrics.rootMeanSquaredError)

    // APK:K值平均准确率,APK试图衡量的是模型对用户感兴趣和会去接触的物品的预测能力
    // 适合隐式数据集
    val moviesForUser = ratings.keyBy(_.user).lookup(789)
    val actualMovies = moviesForUser.map(_.product)
    val predictMovies = topKeys.map(_.product)
    val apk10 = avgPrecisionK(actualMovies,predictMovies,10)
    println("APK:"+apk10)
  }

  def avgPrecisionK(actual: Seq[Int], predicted: Seq[Int], k: Int): Double = {
    val predK = predicted.take(k)
    var score = 0.0
    var numHits = 0.0
    for ((p, i) <- predK.zipWithIndex) {
      if (actual.contains(p)) {
        numHits += 1.0
        score += numHits / (i.toDouble + 1.0)
      }
    }
    if (actual.isEmpty) {
      1.0
    } else {
      score / scala.math.min(actual.size, k).toDouble
    }
  }
}
