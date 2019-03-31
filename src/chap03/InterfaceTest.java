package chap03;

public class InterfaceTest {

    public static void main(String[] args) {

        IntSequence square = new SquareSequence();

        double avg  = average(square, 100);
        System.out.println(avg);

        IntSequence digits = new DigitSequence(1729);

        while(digits.hasNext()){
            System.out.print(digits.next() + " ");
        }

        System.out.println();

        System.out.println((double)(9 + 2 + 7 + 1) / 4);
        digits = new DigitSequence(1729);

        avg = average(digits, 100);
        System.out.println(avg);

        // 타입 변환
        IntSequence is = new DigitSequence(1729);
        DigitSequence ds = (DigitSequence) is;
        System.out.println(ds.rest());

        // instanceof 메소드
        if(is instanceof DigitSequence){
            DigitSequence ds2 = (DigitSequence) is;
            System.out.println(ds2.rest());
        }

    }

    public static double average(IntSequence seq, int n){
        int count = 0;
        double sum = 0;

        while(seq.hasNext() && count < n){
            count++;
            sum += seq.next();
        }

        return count == 0 ? 0 : sum / count;
    }

}
