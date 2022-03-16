import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Boolean> pyramidNumbers = new HashMap<>();
        //A map which will contain the number and the info of it being
        //prime or not

        Scanner pyramidInput = new Scanner(System.in);
        String endToken = "END";

        int lineCounter = 0;
        Map<Integer, NonPrimeNumber> selected = new HashMap<>();

        while (pyramidInput.hasNextLine()) {

            String userInput = pyramidInput.nextLine();
            // if statement to break out when seeing END
            if (userInput.equals(endToken)) {
                break;
            }
            lineCounter = lineCounter + 1;

            String[] numbersOnCurrentLine = userInput.split(" ");
            for (int i = 0; i < numbersOnCurrentLine.length; i++) {

                int number = Integer.parseInt(numbersOnCurrentLine[i]);
                boolean isPrime = IsPrime.isPrime(number);

                if (isPrime) {
                    System.out.println("skipping number " + number + " isprime:" + isPrime);
                    continue;
                }

                if (numbersOnCurrentLine.length == 1) {
                    selected.put(lineCounter, new NonPrimeNumber(0, lineCounter, number));
                    System.out.println("selected number " + number + " on line " + lineCounter);
                    continue;
                }

                NonPrimeNumber previousLineSelected = selected.get(lineCounter-1);

                if (i == previousLineSelected.x
                        || i == previousLineSelected.x + 1
                        || i == previousLineSelected.x - 1) {

                    if (selected.get(lineCounter) == null) {

                        selected.put(lineCounter, new NonPrimeNumber(i, lineCounter, number));
                        System.out.println("selected number " + number + " on line " + lineCounter);

                    }
                    else if (selected.get(lineCounter) != null
                            && selected.get(lineCounter).value < number) {

                        selected.put(lineCounter, new NonPrimeNumber(i, lineCounter, number));
                        System.out.println("replaced selected number " + number + " on line " + lineCounter);

                    }
                }

            }

        }

        int total = 0;
        for (int j = 1; j <= selected.size() ; j++) {
            System.out.println("final selected number " + selected.get(j).value + " on line " + selected.get(j).y );
            total += selected.get(j).value;
        }
        System.out.println("toplam: " + total);


    }

}