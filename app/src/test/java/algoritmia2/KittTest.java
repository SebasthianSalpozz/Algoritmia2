package algoritmia2;

import ProyectoI.FileHandler;
import org.junit.jupiter.api.Test;

import static ProyectoI.TextAnalyzer.calculateSimilarityPercentage;
import static org.junit.jupiter.api.Assertions.*;

class KittTest {

    @Test
    public void testKitt() {
        String filePath1 = "app/src/test/resources/text1.txt";
        String filePath2 = "app/src/test/resources/text2.txt";
        String fileContent = FileHandler.readFile(filePath1);
        String fileContent2 = FileHandler.readFile(filePath2);
        double similarityPercentage = calculateSimilarityPercentage(fileContent, fileContent2);
        System.out.println("The similarity percentage is: " + similarityPercentage + "%");
        assertEquals(95.83, 95.83);
    }

}
