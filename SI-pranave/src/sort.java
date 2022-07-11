public class sort {
    public static void main(String[] args)
    {
        int [] arr = {13,23,5,3,2,5};
        System.out.println("Before sort:");
        for(int i=0;i<6;i++)
            System.out.print(arr[i]+ " ");
        System.out.println();
        System.out.println("Array after sort:");
        int [] new_arr= selsort(arr);
        for(int i=0;i<new_arr.length;i++)
            System.out.print(arr[i]+ " ");
    }
    public static int[] selsort(int[] arr)
    {
        for(int i=0;i< arr.length;i++)
        {
            for(int j= i+1;j<6;j++)
            {
                if(arr[i]>arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
