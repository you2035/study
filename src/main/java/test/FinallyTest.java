package test;

public class FinallyTest {
    public static void main(String[] args) {
//        System.out.println(findResult());

        //--------------------------
//        ok:
//        for(int i=0;i<10;i++){
//            for(int j=0;j<10;j++){
//                System.out.println("i = "+i+"j = "+j);
//                if(j == 5) break ok;
//            }
//        }

        //---------------------------
        int arr[][] ={{1,2,3},{4,5,6,7},{9}};

        boolean found = false;

        for(int i=0;i<arr.length&&!found;i++)       {

            for(int j=0;j<arr[i].length;j++){

                System.out.println("i = "+i+", j = "+j);

                if(arr[i][j] ==5) {

                    found =true;

                    break;

                }

            }

        }
    }

    public static Integer findResult(){
        Integer aInteger = 5;
        try {
            return aInteger = 6;
        } catch (Exception e) {
            return aInteger = 7;
        } finally {
            return aInteger = 8;
        }
    }
}
