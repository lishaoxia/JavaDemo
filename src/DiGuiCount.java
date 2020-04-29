public class DiGuiCount {
    public static  void diGui_Count(long n)
    {
        if(n<=100)
        {
            System.out.println("第"+n+"次递归");
            n = n +1;
            diGui_Count(n);
        }

    }

    public static void main(String[] args) {
        long i = 0;
        diGui_Count(i);
    }
}
