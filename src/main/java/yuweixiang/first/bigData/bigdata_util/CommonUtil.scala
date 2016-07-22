package yuweixiang.first.bigData.bigdata_util

import org.jblas.DoubleMatrix

object CommonUtil {
  def consinSimilarity(vec1:DoubleMatrix,vec2:DoubleMatrix): Double ={
    vec1.dot(vec2)/(vec1.norm2()*vec2.norm2())
  }

  def main(args: Array[String]) {
    def a = new DoubleMatrix(Array(1.0,2.0,3.0))
    def b = new DoubleMatrix(Array(2.0,2.0,4.0))
    print(consinSimilarity(a,b))
  }
}
