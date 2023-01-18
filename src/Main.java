import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Output ot = new Output();
        Scanner sc = new Scanner(System.in);
        Input in = new Input();
        
        System.out.println(" ================ ");
        System.out.println("  24 CARD GAME ");
        System.out.println(" ================ ");

        System.out.println("Pilih masukan kartu: ");
        System.out.println("1 untuk Manual, 2 untuk Auto");

        int x = sc.nextInt();

        while(x != 1 & x != 2)
        {
            System.out.println("Masukan salah! Silakan ulangi");
            x = sc.nextInt();
        }
        
        if(x == 1){
            in.inputManual();
        }else{
            in.inputAuto();
        }

        System.out.println("YOUR CARDS: ");
        System.out.print(ot.writeBackCards(in.k1) + " ");
        System.out.print(ot.writeBackCards(in.k2) + " ");
        System.out.print(ot.writeBackCards(in.k3) + " ");
        System.out.println(ot.writeBackCards(in.k4));

        TwentyFour tf = new TwentyFour(in.k1, in.k2, in.k3, in.k4);

        tf.findTwentyFour();

        sc.close();
    }
}
