package src;
import java.util.Scanner;
import java.util.Random;

class Input{
    int k1,k2,k3,k4;
    Scanner sc = new Scanner(System.in);

    public void inputManual(){
        System.out.println("Masukkan Kartu Anda");
        /* Membaca input */
        String input_text = sc.nextLine();

        /* Membaca satu2 (traversal) */
        /* Baca untuk k1 */
        k1 = charToInt(input_text.charAt(0));

        /* Baca untuk k2 */
        k2 = charToInt(input_text.charAt(2));

        /* Baca untuk k3 */
        k3 = charToInt(input_text.charAt(4));

        /* Baca untuk k4 */
        k4 = charToInt(input_text.charAt(6));

        if (k1 == -1000 || k2 == -1000 || k3 == -1000 || k4 == -1000){
            System.out.println("Masukkan salah! Ulangi pemasukan!");
            inputManual();
        }
    }

    public void inputAuto(){
        Random rand = new Random();
        
        /* Generate Random */
        k1 = rand.nextInt(12) + 1;
        k2 = rand.nextInt(12) + 1;
        k3 = rand.nextInt(12) + 1;
        k4 = rand.nextInt(12) + 1;

    }

    public int charToInt(char c){
        int k;
        if(c == 'A'){
            k = 1;
        } else if( c == 'K'){
            k = 10;
        } else if ( c == 'Q'){
            k = 11;
        } else if ( c == 'J'){
            k = 12;
        }else if (c >= '2' & c<='9'){
            k = c - 48;
        }else{
            /* FLAG ERROR */
            k = -1000;
        }
        return k;
    }

    public static void main(String[] args){
        Input in = new Input();
        in.inputAuto();
        System.out.println(in.k1);
        System.out.println(in.k2);
        System.out.println(in.k3);
        System.out.println(in.k4);
    }
}