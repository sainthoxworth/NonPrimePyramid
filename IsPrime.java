public class IsPrime {

    public static boolean isPrime(int x) {

        //Boolean method.
        //FALSE = NOT PRIME NUMBER
        //TRUE = PRIME NUMBER
        if(x ==1)
            return false;

        for (int i = 2; i < x; i++) {

            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
