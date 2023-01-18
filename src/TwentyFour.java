import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
public class TwentyFour {
    Output out = new Output();

    int[] arrAwal = new int[4];
    public int found = 0;
    String operationText;

    /* CONSTRUCTOR */
    public TwentyFour(int a, int b, int c, int d){
        arrAwal[0] = a;
        arrAwal[1] = b;
        arrAwal[2] = c;
        arrAwal[3] = d;
    }
    
    /* METHODS */
    public void findTwentyFour(){
        Scanner opt = new Scanner(System.in);

        double[][] arrKartu = new double[24][4];
        int n = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    for (int l = 0; l < 4 ; l++){
                        if ( i == j | i == k | i == l | j == k | j == l | k == l)
                        {
                            /* PASS */
                        }
                        else
                        {
                            arrKartu[n][0] = arrAwal[i];
                            arrKartu[n][1] = arrAwal[j];
                            arrKartu[n][2] = arrAwal[k];
                            arrKartu[n][3] = arrAwal[l];
                            n++;
                        }
                    }
                }
            }
        }

        Instant start = Instant.now();
        
        for (int i = 0; i < 24; i++){
            operations(arrKartu[i]);
        }

        Instant end = Instant.now();

        Duration dur = Duration.between(start,end);

        System.out.println("RESULTS: " + found + " combinations");
        System.out.println("==================================");
            
            if (found == 0){
                System.out.println("NO RESULTS");
            }else{
                for (int i = 0; i < out.results.size(); i++){
                    System.out.println(out.results.get(i));
                }
            }

            System.out.println("==================================");
        System.out.println("DURATION " + dur.toMillis() + "ms");

        System.out.println("Do you want to save the results? (Y/N)");

        String option = opt.nextLine();

        if(option.equals("Y")){
            out.writeToFile(found, dur.toMillis(), out.results, arrAwal);
            System.out.println("File is saved");
        }else{
            /* PASS */
        }

        opt.close();
    }

    public void operations(double[] arr){
        /* Mencoba seluruh operasi */
        int n = 0;
        double res = 0;
        while (n < 64){
            operationText = "";
            /* KASUS2 OPERASI TANPA KURUNG */
            if(n == 0)
            {
                res = arr[0] + arr[1] + arr[2] + arr[3];
                operationText += arr[0] + " + " + arr[1] + " + " + arr[2] + " + " + arr[3];
            }
            else if(n == 1)
            {
                res = arr[0] + arr[1] + arr[2] - arr[3];
                operationText += arr[0] + " + " + arr[1] + " + " + arr[2] + " - " + arr[3];
            }
            else if(n == 2)
            {
                res = arr[0] + arr[1] + arr[2] * arr[3];
                operationText += arr[0] + " + " + arr[1] + " + " + arr[2] + " * " + arr[3];
            }
            else if(n == 3)
            {
                res = arr[0] + arr[1] + arr[2] / arr[3];
                operationText += arr[0] + " + " + arr[1] + " + " + arr[2] + " * " + arr[3];
            }
            else if(n == 4)
            {
                res = arr[0] + arr[1] - arr[2] + arr[3];
                operationText += arr[0] + " + " + arr[1] + " - " + arr[2] + " + " + arr[3];
            }
            else if(n == 5)
            {
                res = arr[0] + arr[1] - arr[2] - arr[3];
                operationText += arr[0] + " + " + arr[1] + " - " + arr[2] + " - " + arr[3];
            }
            else if(n == 6)
            {
                res = arr[0] + arr[1] - arr[2] * arr[3];
                operationText += arr[0] + " + " + arr[1] + " - " + arr[2] + " * " + arr[3];
            }
            else if (n == 7)
            {
                res = arr[0] + arr[1] - arr[2] / arr[3];
                operationText += arr[0] + " + " + arr[1] + " - " + arr[2] + " / " + arr[3];
            }
            else if (n == 8)
            {
                res = arr[0] + arr[1] / arr[2] + arr[3];
                operationText += arr[0] + " + " + arr[1] + " / " + arr[2] + " + " + arr[3];
            }
            else if (n == 9)
            {
                res = arr[0] + arr[1] / arr[2] - arr[3];
                operationText += arr[0] + " + " + arr[1] + " / " + arr[2] + " - " + arr[3];
            }
            else if (n == 10)
            {
                res = arr[0] + arr[1] / arr[2] / arr[3];
                operationText += arr[0] + " + " + arr[1] + " / " + arr[2] + " / " + arr[3];
            }
            else if ( n == 11)
            {
                res = arr[0] + arr[1] / arr[2] * arr[3];
                operationText += arr[0] + " + " + arr[1] + " / " + arr[2] + " * " + arr[3];
            }
            else if (n == 12)
            {
                res = arr[0] + arr[1] * arr[2] + arr[3];
                operationText += arr[0] + " + " + arr[1] + " * " + arr[2] + " + " + arr[3];
            }
            else if (n == 13)
            {
                res = arr[0] + arr[1] * arr[2] - arr[3];
                operationText += arr[0] + " + " + arr[1] + " * " + arr[2] + " - " + arr[3];
            }
            else if (n == 14)
            {
                res = arr[0] + arr[1] * arr[2] / arr[3];
                operationText += arr[0] + " + " + arr[1] + " * " + arr[2] + " / " + arr[3];
            }
            else if (n == 15)
            {
                res = arr[0] + arr[1] * arr[2] * arr[3];
                operationText += arr[0] + " + " + arr[1] + " * " + arr[2] + " * " + arr[3];
            }
            else if (n == 16)
            {
                res = arr[0] - arr[1] + arr[2] + arr[3];
                operationText += arr[0] + " - " + arr[1] + " + " + arr[2] + " + " + arr[3];
            }
            else if(n == 17)
            {
                res = arr[0] - arr[1] + arr[2] - arr[3];
                operationText += arr[0] + " - " + arr[1] + " + " + arr[2] + " - " + arr[3];
            }
            else if(n == 18)
            {
                res = arr[0] - arr[1] + arr[2] * arr[3];
                operationText += arr[0] + " - " + arr[1] + " + " + arr[2] + " * " + arr[3];
            }
            else if(n == 19)
            {
                res = arr[0] - arr[1] + arr[2] / arr[3];
                operationText += arr[0] + " - " + arr[1] + " + " + arr[2] + " / " + arr[3];

            }
            else if(n == 20)
            {
                res = arr[0] - arr[1] - arr[2] + arr[3];
                operationText += arr[0] + " - " + arr[1] + " - " + arr[2] + " + " + arr[3];
            }
            else if(n == 21)
            {
                res = arr[0] - arr[1] - arr[2] - arr[3];
                operationText += arr[0] + " - " + arr[1] + " - " + arr[2] + " - " + arr[3];
            }
            else if(n == 22)
            {
                res = arr[0] - arr[1] - arr[2] * arr[3];
                operationText += arr[0] + " - " + arr[1] + " - " + arr[2] + " * " + arr[3];

            }
            else if (n == 23)
            {
                res = arr[0] - arr[1] - arr[2] / arr[3];
                operationText += arr[0] + " - " + arr[1] + " - " + arr[2] + " / " + arr[3];

            }
            else if (n == 24)
            {
                res = arr[0] - arr[1] / arr[2] + arr[3];
                operationText += arr[0] + " - " + arr[1] + " / " + arr[2] + " + " + arr[3];
            }
            else if (n == 25)
            {
                res = arr[0] - arr[1] / arr[2] - arr[3];
                operationText += arr[0] + " - " + arr[1] + " / " + arr[2] + " - " + arr[3];
            }
            else if (n == 26)
            {
                res = arr[0] - arr[1] / arr[2] / arr[3];
                operationText += arr[0] + " - " + arr[1] + " / " + arr[2] + " / " + arr[3];
            }
            else if ( n == 27)
            {
                res = arr[0] - arr[1] / arr[2] * arr[3];
                operationText += arr[0] + " - " + arr[1] + " / " + arr[2] + " * " + arr[3];
            }
            else if (n == 28)
            {
                res = arr[0] - arr[1] * arr[2] + arr[3];
                operationText += arr[0] + " - " + arr[1] + " * " + arr[2] + " + " + arr[3];
            }
            else if (n == 29)
            {
                res = arr[0] - arr[1] * arr[2] - arr[3];
                operationText += arr[0] + " - " + arr[1] + " * " + arr[2] + " - " + arr[3];
            }
            else if (n == 30)
            {
                res = arr[0] - arr[1] * arr[2] / arr[3];
                operationText += arr[0] + " - " + arr[1] + " * " + arr[2] + " / " + arr[3];
            }
            else if (n == 31)
            {
                res = arr[0] - arr[1] * arr[2] * arr[3];
                operationText += arr[0] + " - " + arr[1] + " * " + arr[2] + " * " + arr[3];
            }
            else if (n == 32)
            {
                res = arr[0] * arr[1] + arr[2] + arr[3];
                operationText += arr[0] + " * " + arr[1] + " + " + arr[2] + " + " + arr[3];
            }
            else if(n == 33)
            {
                res = arr[0] * arr[1] + arr[2] - arr[3];
                operationText += arr[0] + " * " + arr[1] + " + " + arr[2] + " - " + arr[3];
            }
            else if(n == 34)
            {
                res = arr[0] * arr[1] + arr[2] * arr[3];
                operationText += arr[0] + " * " + arr[1] + " + " + arr[2] + " * " + arr[3];
            }
            else if(n == 35)
            {
                res = arr[0] * arr[1] + arr[2] / arr[3];
                operationText += arr[0] + " * " + arr[1] + " + " + arr[2] + " / " + arr[3];
            }
            else if(n == 36)
            {
                res = arr[0] * arr[1] - arr[2] + arr[3];
                operationText += arr[0] + " * " + arr[1] + " - " + arr[2] + " + " + arr[3];
            }
            else if(n == 37)
            {
                res = arr[0] * arr[1] - arr[2] - arr[3];
                operationText += arr[0] + " * " + arr[1] + " - " + arr[2] + " - " + arr[3];
            }
            else if(n == 38)
            {
                res = arr[0] * arr[1] - arr[2] * arr[3];
                operationText += arr[0] + " * " + arr[1] + " + " + arr[2] + " - " + arr[3];
            }
            else if (n == 39)
            {
                res = arr[0] * arr[1] - arr[2] / arr[3];
                operationText += arr[0] + " * " + arr[1] + " + " + arr[2] + " / " + arr[3];
            }
            else if (n == 40)
            {
                res = arr[0] * arr[1] / arr[2] + arr[3];
                operationText += arr[0] + " * " + arr[1] + " / " + arr[2] + " + " + arr[3];
            }
            else if (n == 41)
            {
                res = arr[0] * arr[1] / arr[2] - arr[3];
                operationText += arr[0] + " * " + arr[1] + " / " + arr[2] + " - " + arr[3];
            }
            else if (n == 42)
            {
                res = arr[0] * arr[1] / arr[2] / arr[3];
                operationText += arr[0] + " * " + arr[1] + " / " + arr[2] + " / " + arr[3];
            }
            else if ( n == 43)
            {
                res = arr[0] * arr[1] / arr[2] * arr[3];
                operationText += arr[0] + " * " + arr[1] + " / " + arr[2] + " * " + arr[3];
            }
            else if (n == 44)
            {
                res = arr[0] * arr[1] * arr[2] + arr[3];
                operationText += arr[0] + " * " + arr[1] + " * " + arr[2] + " + " + arr[3];
            }
            else if (n == 45)
            {
                res = arr[0] * arr[1] * arr[2] - arr[3];
                operationText += arr[0] + " * " + arr[1] + " * " + arr[2] + " - " + arr[3];
            }
            else if (n == 46)
            {
                res = arr[0] * arr[1] * arr[2] / arr[3];
                operationText += arr[0] + " * " + arr[1] + " * " + arr[2] + " / " + arr[3];
            }
            else if (n == 47)
            {
                res = arr[0] * arr[1] * arr[2] * arr[3];
                operationText += arr[0] + " * " + arr[1] + " * " + arr[2] + " * " + arr[3];
            }
            else if (n == 48)
            {
                res = arr[0] / arr[1] + arr[2] + arr[3];
                operationText += arr[0] + " / " + arr[1] + " + " + arr[2] + " + " + arr[3];
            }
            else if(n == 49)
            {
                res = arr[0] / arr[1] + arr[2] - arr[3];
                operationText += arr[0] + " / " + arr[1] + " + " + arr[2] + " - " + arr[3];
            }
            else if(n == 50)
            {
                res = arr[0] / arr[1] + arr[2] * arr[3];
                operationText += arr[0] + " / " + arr[1] + " + " + arr[2] + " * " + arr[3];
            }
            else if(n == 51)
            {
                res = arr[0] / arr[1] + arr[2] / arr[3];
                operationText += arr[0] + " / " + arr[1] + " + " + arr[2] + " / " + arr[3];
            }
            else if(n == 52)
            {
                res = arr[0] / arr[1] - arr[2] + arr[3];
                operationText += arr[0] + " / " + arr[1] + " - " + arr[2] + " + " + arr[3];
            }
            else if(n == 53)
            {
                res = arr[0] / arr[1] - arr[2] - arr[3];
                operationText += arr[0] + " / " + arr[1] + " - " + arr[2] + " - " + arr[3];
            }
            else if(n == 54)
            {
                res = arr[0] / arr[1] - arr[2] * arr[3];
                operationText += arr[0] + " * " + arr[1] + " + " + arr[2] + " / " + arr[3];
            }
            else if (n == 55)
            {
                res = arr[0] / arr[1] - arr[2] / arr[3];
                operationText += arr[0] + " * " + arr[1] + " + " + arr[2] + " / " + arr[3];
            }
            else if (n == 56)
            {
                res = arr[0] / arr[1] / arr[2] + arr[3];
                operationText += arr[0] + " / " + arr[1] + " / " + arr[2] + " + " + arr[3];
            }
            else if (n == 57)
            {
                res = arr[0] / arr[1] / arr[2] - arr[3];
                operationText += arr[0] + " / " + arr[1] + " / " + arr[2] + " - " + arr[3];
            }
            else if (n == 58)
            {
                res = arr[0] / arr[1] / arr[2] / arr[3];
                operationText += arr[0] + " / " + arr[1] + " / " + arr[2] + " / " + arr[3];
            }
            else if ( n == 59)
            {
                res = arr[0] / arr[1] / arr[2] * arr[3];
                operationText += arr[0] + " / " + arr[1] + " / " + arr[2] + " * " + arr[3];
            }
            else if (n == 60)
            {
                res = arr[0] / arr[1] * arr[2] + arr[3];
                operationText += arr[0] + " / " + arr[1] + " * " + arr[2] + " + " + arr[3];
            }
            else if (n == 61)
            {
                res = arr[0] / arr[1] * arr[2] - arr[3];
                operationText += arr[0] + " / " + arr[1] + " * " + arr[2] + " - " + arr[3];
            }
            else if (n == 62)
            {
                res = arr[0] / arr[1] * arr[2] / arr[3];
                operationText += arr[0] + " / " + arr[1] + " * " + arr[2] + " / " + arr[3];
            }
            else if (n == 63)
            {
                res = arr[0] / arr[1] * arr[2] * arr[3];
                operationText += arr[0] + " / " + arr[1] + " * " + arr[2] + " * " + arr[3];
            }

            /* OPERASI DENGAN KURUNG */
            
            /* UNTUK RESULT = 24 */
            if(res == 24){
                found();
            }

            n++;
        }
    }

    public int operate (int a, char op, int b){
        int ret = 0;
        if (op == '+'){
            ret = a + b;
        } else if (op == '-'){
            ret = a - b;
        } else if (op == '*'){
            ret = a * b;
        } else if (op == '/'){
            ret = a / b;
        }
        return ret;
    }

    public void found(){
        /* WRITE KE OUTPUT */
        out.addResults(operationText);

        /* Tambah Jumlah found */
        found++;
    }
}
