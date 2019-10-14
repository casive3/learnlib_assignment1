package seleniumsul;

import com.google.common.collect.ImmutableSet;
import de.learnlib.api.SUL;
import basiclearner.BasicLearner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by ramon on 13-12-16.
 */
public class SeleniumChocolateBarMachineLearner {
    public static void main(String[] args) throws IOException {
        /* Ensure that the following parameters are correctly set! */
        String candyMachineURI = "D:\\Informatika\\IX.Félév\\Testing Techniques\\Labor\\L2\\InteliJ_LearnLib\\Selenium\\public\\website.htm";
        String geckoDriverLocation = "chromedriver_win32\\chromedriver.exe"; // e.g. for chromedriver
        System.setProperty("webdriver.chrome.driver", geckoDriverLocation);
        WebDriver driver = new ChromeDriver();

        /* If all is set, we can start learning */
        Collection<String> inputAlphabet = ImmutableSet.of("5ct", "10ct", "mars", "snickers", "twix");
        SUL<String, String> sul = new SeleniumSUL(candyMachineURI, driver);
        BasicLearner.runControlledExperiment(
                sul,
                BasicLearner.LearningMethod.RivestSchapire,
                BasicLearner.TestingMethod.UserQueries,
                inputAlphabet);

        driver.close();
    }

}
