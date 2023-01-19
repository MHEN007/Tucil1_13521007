import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Output {
    ArrayList<String> results = new ArrayList<>();
    String fileName;

    public void addResults(String math_exp){
        results.add(math_exp);
    }

    public String writeBackCards(int a){
        String ret;
        if(a == 1){
            ret = "A";
        }else if(a == 11){
            ret = "J";
        }else if(a == 12){
            ret = "Q";
        }else if(a == 13){
            ret = "K";
        }else{
            ret = Integer.toString(a);
        }
        return ret;
    }

    public void writeToFile(int founds, long time, ArrayList<String> results, int[] cards){
        Scanner fileRead = new Scanner(System.in);
        System.out.println("PLEASE ENTER YOUR FILENAME: ");
        fileName = fileRead.nextLine();
        fileName += ".txt";

        try{
            FileWriter outputFile = new FileWriter("../test/"+fileName);

            outputFile.write("THE CARDS: ");
            outputFile.write(writeBackCards(cards[0]) + " " + writeBackCards(cards[1]) + " " + writeBackCards(cards[2]) + " " + writeBackCards(cards[3]) + "\n");
            
            outputFile.write("Results that are 24: " + founds + " combinations\n");
            outputFile.write("==================================\n");
            
            if (founds == 0){
                outputFile.write("NO RESULTS\n");
            }else{
                for (int i = 0; i < results.size(); i++){
                    outputFile.write(results.get(i) + "\n");
                }
            }

            outputFile.write("==================================\n");

            outputFile.write("Runtime: " + time + "ms");

            outputFile.close();

        } catch (IOException e) {
            System.out.println("Error Occured.");
            e.printStackTrace();
        }

        fileRead.close();
    }    
}
