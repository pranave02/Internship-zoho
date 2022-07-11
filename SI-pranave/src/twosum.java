import java.util.Arrays;
import java.util.HashMap;

public class twosum {
    public static void main(String[] args)
    {
        int [] arr = {1,2,3,4,5};
        int sum = 9;
        System.out.println(Arrays.toString(sumer(arr,sum)));
    }
    public static int [] sumer(int[] arr, int sum)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] indices = new int[2];
        for(int i=0;i< arr.length;i++)
        {
            if(map.containsKey(sum-arr[i]))
            {
                indices[0]=map.get(sum-arr[i]);
                indices[1]=i;
                return indices;
            }
            else
            {
                map.put(arr[i],i);
            }
        }
        return indices;
    }
}
