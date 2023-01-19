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
        /* OPERASI UNTUK KURUNG */

        /* (a operator b) operator (c operator d) */
        for(int i = 0; i < 4; i++){
            double ab, cd;
            String abText = "(";
            ab = operate(arr[0], i, arr[1]);
            abText += makeStringFromOp(arr[0], i, arr[1]);
            abText += ")";
            for (int j = 0 ; j < 4; j++){
                cd = operate(arr[2], j, arr[3]);
                String cdText = "(";
                cdText += makeStringFromOp(arr[2], j, arr[3]) + ")";
                for (int k = 0; k < 4; k++){
                    if(operate(ab, k, cd) == 24){
                        operationText = concateOperationsString(abText, k, cdText);
                        found();
                    }
                }
            }
        }

        /* ((a operator b) operator c) operator d */
        for (int i = 0; i < 4; i++){
            double ab;
            String abText = "(";
            ab = operate(arr[0], i, arr[1]);
            abText += makeStringFromOp(arr[0], i, arr[1]) + ")";
            for (int j = 0; j < 4 ; j++){
                double c;
                c = operate(ab, j, arr[2]);
                String cText = "(" + concateStringOp(abText, j, arr[2]) + ")";
                for (int k = 0; k<4 ;k++){
                    if(operate(c, k, arr[3]) == 24){
                        operationText = concateStringOp(cText, k, arr[3]);
                        found();
                    }
                }
            }
        }

        /* (a operator (b operator c)) operator d */
        for (int i = 0; i < 4; i++){
            double bc;
            bc = operate(arr[1], i, arr[2]);
            String bcText = "(" + makeStringFromOp(arr[1], i, arr[2]) + ")";
            for (int j = 0; j < 4 ; j++){
                double abc;
                abc = operate(arr[0], j, bc);
                String abcText = "(" + concateOpString(arr[0], j, bcText) +")";
                for (int k = 0; k<4; k++){
                    if(operate(abc, k, arr[3]) == 24){
                        operationText = concateStringOp(abcText, k, arr[3]);
                        found();
                    }
                }
            }
        }

        /* a operator (b operator c) operator d */
        /* TODO: Remove redudancy */
        for (int i = 0; i < 4 ; i++){
            double bc;
            bc = operate(arr[1], i, arr[2]);
            String bcText = "(" + makeStringFromOp(arr[1], i, arr[2]) + ")";
            for (int j = 0; j < 4 ; j++){
                for(int k = 0; k < 4 ;k++){
                    if((j >= 2 & k < 2) | (j >= 2 & k >=2) | (j < 2 & k < 2)){
                        double abc;
                        abc = operate(arr[0], j, bc);
                        String abcText = concateOpString(arr[0], j, bcText);
                        if(operate(abc, k, arr[3])==24 & j != 2){
                            operationText = concateStringOp(abcText, k, arr[3]);
                            found();
                        }
                    }else{
                        double bcd;
                        bcd = operate(bc, k, arr[3]);
                        String bcdText = concateStringOp(bcText, k, arr[3]);
                        if(operate(arr[0], j, bcd)==24){
                            operationText = concateOpString(arr[0], j, bcdText);
                            found();
                        }
                    }
                }
            }
        }

        /* a operator b operator (c operator d) */
        for (int i = 0; i < 4; i++){
            double cd;
            cd = operate(arr[2], i, arr[3]);
            String cdText = "(" + makeStringFromOp(arr[2], i, arr[3]) + ")";
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    if((j >= 2 & k < 2) | (j>=2 & k >= 2) | (j < 2 & k < 2)){
                        double ab;
                        ab = operate(arr[0], j, arr[1]);
                        String abText = makeStringFromOp(arr[0], j, arr[1]);
                        if(operate(ab, k, cd) == 24){
                            operationText = concateOperationsString(abText, k, cdText);
                            found();
                        }
                    }else{
                        double bcd;
                        bcd = operate(arr[1], k,cd);
                        String bcdText = concateOpString(arr[1], k, cdText);
                        if(operate(arr[0], j, bcd) == 24){
                            operationText = concateOpString(arr[0], j, bcdText);
                            found();
                        }
                    }
                }
            }
        }

        /* a operator (b operator (c operator d)) */
        for (int i = 0; i < 4; i++){
            double cd;
            cd = operate(arr[2], i, arr[3]);
            String cdText = "("+makeStringFromOp(arr[2], i, arr[3])+")";
            for (int j = 0; j < 4; j++){
                double bcd = operate(arr[1], j, cd);
                String bcdText = "(" + concateOpString(arr[1], j, cdText) + ")";
                for (int k = 0; k < 4; k++){
                    if(operate(arr[0], k, bcd) == 24){
                        operationText = concateOpString(arr[0], k, bcdText);
                        found();
                    }
                }
            }
        }

        /* a operator ((b operator c) operator d) */
        for (int i = 0; i < 4; i++){
            double bc = operate(arr[1], i, arr[2]);
            String bcText = "(" + makeStringFromOp(arr[1], i, arr[2]) + ")";
            for (int j = 0; j < 4; j++){
                double bcd = operate(bc, j, arr[3]);
                String bcdText = "(" + concateStringOp(bcText, j, arr[3]) + ")";
                for (int k = 0; k < 4 ; k++){
                    if(operate(arr[0], k,bcd) == 24){
                        operationText = concateOpString(arr[0], k, bcdText);
                        found();
                    }
                }
            }
        }

        /* (a operate b operate c) operate d */
        for (int i =0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                double temp;
                String tempText;
                if ((i >= 2 & j < 2) | (i < 2 & j < 2) | (i >= 2 & j >= 2)){
                    temp = operate(arr[0], i, arr[1]);
                    temp = operate(temp, j, arr[2]);
                }else{
                    temp = operate(arr[1],j, arr[2]);
                    temp = operate(arr[0], i, temp);
                }
                tempText = "(" + makeStringFromOp(arr[0],i, arr[1]);
                tempText = concateStringOp(tempText, j, arr[2]) + ")";
                for (int k = 0; k < 4; k++){
                    if(operate(temp, k, arr[3]) == 24){
                        operationText = concateStringOp(tempText, k, arr[3]);
                        found();
                    }
                }
            }
        }

        /* a operate (b operate c operate d) */
        for (int i =0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                double bc, cd, bcd;
                String tempText;
                if ((i >= 2 & j < 2) | (i < 2 & j < 2) | (i >= 2 & j >= 2)){
                    bc = operate(arr[1], i, arr[2]);
                    bcd = operate(bc, j, arr[3]);
                }else{
                    cd = operate(arr[2],j, arr[3]);
                    bcd = operate(arr[1], i, cd);            
                }
                tempText = "(" + makeStringFromOp(arr[1],i, arr[2]);
                tempText = concateStringOp(tempText, j, arr[3]) + ")";
                for (int k = 0; k < 4; k++){
                    if(operate(arr[0], k, bcd) == 24){
                        operationText = concateOpString(arr[0], k, tempText);
                        found();
                    }
                }
            }
        }


    }

    public double operate (double a, int op, double b){
        double ret = 0;
        if (op == 0){
            ret = a + b;
        } else if (op == 1){
            ret = a - b;
        } else if (op == 2){
            ret = a * b;
        } else if (op == 3){
            ret = a / b;
        }
        return ret;
    }

    public String concateOperationsString(String a, int op, String b){
        String text;
        text = "";
        text += a;
        if(op == 0){
            text += " + ";
        }else if(op == 1){
            text += " - ";
        }else if(op == 2){
            text += " * ";
        }else if(op == 3){
            text += " / ";
        }
        text+=b;
        return text;
    }

    public String concateStringOp(String a, int op, double b){
        String text;
        text = "";
        text += a;
        if(op == 0){
            text += " + ";
        }else if(op == 1){
            text += " - ";
        }else if(op == 2){
            text += " * ";
        }else if(op == 3){
            text += " / ";
        }
        text+=b;
        return text;
    }

    public String concateOpString(double a, int op, String b){
        String text;
        text = "";
        text += a;
        if(op == 0){
            text += " + ";
        }else if(op == 1){
            text += " - ";
        }else if(op == 2){
            text += " * ";
        }else if(op == 3){
            text += " / ";
        }
        text+=b;
        return text;
    }

    public String makeStringFromOp(double a, int op, double b){
        String text;
        text = "";
        text += a;
        if(op == 0){
            text += " + ";
        }else if(op == 1){
            text += " - ";
        }else if(op == 2){
            text += " * ";
        }else if(op == 3){
            text += " / ";
        }
        text+=b;
        return text;
    }

    public void found(){
        /* WRITE KE OUTPUT */
        out.addResults(operationText);

        /* Tambah Jumlah found */
        found++;
    }
}
