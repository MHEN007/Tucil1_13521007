import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class Output {
    List<String> results = new ArrayList<>();

    public void addResults(String math_exp){
        results.add(math_exp);
    }

    public void writeToFile(int founds, long time, List<String> results){
        try{
            FileWriter outputFile = new FileWriter("results.txt");
            
            outputFile.write("Results that ends in 24: " + founds + "\n");
            outputFile.write("==================================\n");
            
            if (founds == 0){
                outputFile.write("NO RESULTS\n");
            }else{
                for (int i = 0; i < results.size(); i++){
                    outputFile.write(results.get(i) + "\n");
                }
            }

            outputFile.write("==================================\n");

            outputFile.write("Time: " + time + "ms");

            outputFile.close();

        } catch (IOException e) {
            System.out.println("Error Occured.");
            e.printStackTrace();
        }
    }    
}
