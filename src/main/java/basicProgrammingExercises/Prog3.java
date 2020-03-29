package basicProgrammingExercises;

/**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，
 * 其各位数字立方和等于该数本身。例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 *
 * 程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
 */
public class Prog3 {
  public static void main(String[] args) {
    for (int i = 100; i <=999 ; i++) {
      if(isLotus(i)){
        System.out.println(i+" ");
      }
    }
  }

  public static boolean isLotus(int i){
    int m = i/100;
    int n = i%10;
    int l = (i%100)/10;

    int add = ((int) (Math.pow(m, 3) + Math.pow(n, 3) + Math.pow(l, 3)));

    if(add == i){
      return true;
    }

    return false;
  }
}
