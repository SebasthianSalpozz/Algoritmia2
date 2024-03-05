// Kitt.java
package ProyectoI;

import static ProyectoI.TextAnalyzer.calculateSimilarityPercentage;

public class Kitt {
    public static void main(String[] args) {
        System.out.println("eg1");
        String filePath1 = "app/src/main/java/ProyectoI/assets/text1.txt";
        String filePath2 = "app/src/main/java/ProyectoI/assets/text2.txt";
        String fileContent = FileHandler.readFile(filePath1);
        String fileContent2 = FileHandler.readFile(filePath2);
        double similarityPercentage = calculateSimilarityPercentage(fileContent, fileContent2);
        System.out.println("The similarity percentage is: " + similarityPercentage + "%");

        System.out.println("eg2");

        String filePath3 = "app/src/main/java/ProyectoI/assets/text3.txt";
        String filePath4 = "app/src/main/java/ProyectoI/assets/text4.txt";
        String fileContent3 = FileHandler.readFile(filePath3);
        String fileContent4 = FileHandler.readFile(filePath4);
        double similarityPercentage2 = calculateSimilarityPercentage(fileContent3, fileContent4);
        System.out.println("The similarity percentage is: " + similarityPercentage2 + "%");

        System.out.println("eg3");
        String filePath5 = "app/src/main/java/ProyectoI/assets/text5.txt";
        String filePath6 = "app/src/main/java/ProyectoI/assets/text6.txt";
        String fileContent5 = FileHandler.readFile(filePath5);
        String fileContent6 = FileHandler.readFile(filePath6);
        double similarityPercentage3 = calculateSimilarityPercentage(fileContent5, fileContent6);
        System.out.println("The similarity percentage is: " + similarityPercentage3 + "%");

        System.out.println("eg4");
        String filePath7 = "app/src/main/java/ProyectoI/assets/text7.txt";
        String filePath8 = "app/src/main/java/ProyectoI/assets/text8.txt";
        String fileContent7 = FileHandler.readFile(filePath7);
        String fileContent8 = FileHandler.readFile(filePath8);
        double similarityPercentage4 = calculateSimilarityPercentage(fileContent7, fileContent8);
        System.out.println("The similarity percentage is: " + similarityPercentage4 + "%");
    }
}
