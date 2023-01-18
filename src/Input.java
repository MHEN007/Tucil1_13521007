import java.util.Scanner;
import java.util.Random;

public class Input{
    int k1,k2,k3,k4;
    Scanner sc = new Scanner(System.in);

    public void inputManual(){
        System.out.println("Masukkan Kartu Anda");
        /* Membaca input */
        String input_k1 = sc.next();
        String input_k2 = sc.next();
        String input_k3 = sc.next();
        String input_k4 = sc.next();

        /* Convert untuk k1 */
        k1 = stringToInt(input_k1);

        /* Convert untuk k2 */
        k2 = stringToInt(input_k2);

        /* Convert untuk k3 */
        k3 = stringToInt(input_k3);

        /* Convert untuk k4 */
        k4 = stringToInt(input_k4);

        /* Just Incase tidak boleh ada duplikat kartu yang sama
        if (k1 == -1000 | k2 == -1000 | k3 == -1000 | k4 == -1000){
            System.out.println("Masukkan salah! Ulangi pemasukan!");
            inputManual();
        }
        */
    }

    public void inputAuto(){
        Random rand = new Random();
        
        /* Generate Random */
        k1 = rand.nextInt(12) + 1;
        k2 = rand.nextInt(12) + 1;
        k3 = rand.nextInt(12) + 1;
        k4 = rand.nextInt(12) + 1;

        /* Just incase tidak boleh ada duplikat kartu yang sama
        if(k1 == k2 | k1 == k3 | k1 == k4 | k2 == k3 | k2 == k4 | k3 == k4)
        {
            inputAuto();
        }
        */

    }

    public int stringToInt(String c){
        int k;
        if(c.equals("A")){
            k = 1;
        } else if( c.equals("J")){
            k = 11;
        } else if ( c.equals("Q")){
            k = 12;
        } else if ( c.equals("K")){
            k = 13;
        }else if (c.equals("2")){
            k = 2;
        }else if (c.equals("3")){
            k = 3;
        }else if (c.equals("4")){
            k = 4;
        }else if (c.equals("5")){
            k = 5;
        }else if (c.equals("6")){
            k = 6;
        }else if (c.equals("7")){
            k = 7;
        }else if (c.equals("8")){
            k = 8;
        }else if (c.equals("9")){
            k = 9;
        }else if (c.equals("10")){
            k = 10;
        }else{
            /* FLAG ERROR */
            k = -1000;
        }
        return k;
    }

    public static void main(String[] args){
        Input in = new Input();
        in.inputManual();
        System.out.println(in.k1);
        System.out.println(in.k2);
        System.out.println(in.k3);
        System.out.println(in.k4);
    }
}