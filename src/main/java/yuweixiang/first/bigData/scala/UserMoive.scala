package yuweixiang.first.bigData.scala

import org.apache.spark.{SparkContext, SparkConf}

object UserMoive {
  def main(args: Array[String]) {
    def sparkConf = new SparkConf();
    val sc = new SparkContext("local[2]", "First Spark App", sparkConf)
    val data = sc.textFile("/Users/yuweixiang/Downloads/my/spark/data/ml-100k/u.user")
      .map(line => line.split("|"))
    val num_users = data.map(line=>line(0)).count()
    val num_genders = data.map(line=>line(2)).distinct().count()
    val num_occupations = data.map(line=>line(3)).distinct().count()
    val num_zipcode = data.map(line=>line(4)).distinct().count()
    println ("Users:%d,genders:%d,occupations:%d,zip codes:%d".format(num_users,num_genders,num_occupations,num_zipcode))

    val ages = data.map(x=>x(1).toInt).collect()

  }
}
