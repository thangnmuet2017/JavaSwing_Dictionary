public class cau1 {
    
    public int ucln(int a, int b)
            {
                a = Math.abs(a);
                b = Math.abs(b);
                while ( a!= b)
                {
                    if(a>b){
                        a -= b;
                    }
                    else
                        b -= a;
                }
                return a;
            }
    public int fibonaxi(int n)
    {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonaxi(n-1) + fibonaxi(n-2);
    }
    public static void main(String[] args) {
        cau1 test = new cau1();
        for(int i =0; i<10; i++){
            int b = test.fibonaxi(i);
            System.out.println(i + " " + b );
    }
        int a = test.ucln(-15, -10);
        System.out.println(a);
    }
}
