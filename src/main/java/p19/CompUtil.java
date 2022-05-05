package p19;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/5 21:42
 */
public class CompUtil {

    public static Object max(MyComparable[] objs) {
        if (objs == null || objs.length == 0) {
            return null;
        }
        MyComparable max = objs[0];
        for (int i = 1; i < objs.length; i++) {
            if (objs[i].compareTo(max) > 0) {
                max = objs[i];
            }
        }
        return max;
    }

    public static void sort(MyComparable[] objs){
        for(int i=0;i<objs.length;i++){
            int min = i;
            for(int j=i+1;j<objs.length;j++){
                if(objs[j].compareTo(objs[min])<0){
                    min = j;
                }
            }
            if(min!=i){
                MyComparable temp = objs[i];
                objs[i] = objs[min];
                objs[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(2,3),
                new Point(3,2),
                new Point(3,4),
        };
        System.out.println("max: " + CompUtil.max(points));
    }

}
