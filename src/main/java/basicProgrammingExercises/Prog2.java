package basicProgrammingExercises;

/**
 * 题目：判断101-200之间有多少个素数，并输出所有素数。
 *
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，
 * 如果能被整除，则表明此数不是素数，反之是素数。
 */
public class Prog2 {
  public static void main(String[] args) {
    for (int i = 1; i <= 200; i++) {
      if(isPrime(i)){
        System.out.print(i+" ");
      }
    }
  }

  public static boolean isPrime(int n){
    int i;
    for (i = 2; i < Math.sqrt(n); i++) {
      if(n % i == 0){
        return false;
      }

    }
    return true;
  }
}
