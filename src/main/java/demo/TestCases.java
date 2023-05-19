package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
///
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase09() {

        // go to url
        driver.get("https://www.imdb.com/chart/top");
        // select rating
        WebElement sortby = driver.findElement(By.xpath("//select[@class='lister-sort-by']"));
        Select select = new Select(sortby);
        select.selectByVisibleText("IMDb Rating");
        // find list of all movies rating Using Locator "XPath"
        // //td[@class='ratingColumn imdbRating']/strong
        List<WebElement> allmovies = driver.findElements(By.xpath("//td[@class='titleColumn']/a"));
        // store in list
        List<String> movieslist = new ArrayList<String>();
        for (WebElement allmovies_ : allmovies) {
            String s = allmovies_.getText();
            movieslist.add(s);
        }

        // get first object from list using loop
        // get title of this first object for highest rating movie
        // The Shawshank Redemption//
        String highestratingmovie = movieslist.get(0);
        System.out.println("Highest Rated Movie Is : " + highestratingmovie);
        if (highestratingmovie.contains("The Shawshank Redemption")) {
            System.out.println("FIRST CONDITION IS PASSED FOR HIGHEST RATING MOVIE");

        } else {
            System.out.println("FIRST CONDITION FAIL");
        }
        // count total number of movies Using Locator "XPath" //h1[@class='header']
        WebElement totalMovieCount = driver.findElement(By.xpath("//h1[@class='header']"));
        // get text of this web element
        String CountOfAllMovie = totalMovieCount.getText();
        System.out.println("Total Movie Count Displayed Is " + CountOfAllMovie);
        // get oldest movie
        // select sort by dropdown

        select.selectByVisibleText("Release Date");
        // slect release date
        // find List webElement get title Using Locator "XPath"
        // //td[@class='titleColumn']/a
        // store in list of array
        List<WebElement> allmovies2 = driver.findElements(By.xpath("//td[@class='titleColumn']/a"));
        List<String> ReleaseDate = new ArrayList<>();
        for (int i = allmovies2.size() - 1; i >= 0; i--) {
            String ss = allmovies2.get(i).getText().toString();
            ReleaseDate.add(ss);

        }
        // reverse array
        // oldest movie
        // The Kid//
        String OldesMovie = ReleaseDate.get(0);

        // get first index
        System.out.println("Oldest Movie Released Is : " + OldesMovie);
        if (OldesMovie.contains("The Kid")) {
            System.out.println("SECOND CONDITION IS PASSED FOR OLDEST MOVIE");

        } else {
            System.out.println("SECOND CONDITION FAIL");
        }
        // to get recent move
        // Guardians of the Galaxy Vol. 3//
        // get title of last index from array list
        String RecentMovie = ReleaseDate.get(allmovies2.size() - 1);
        System.out.println("Recently Released movie Is : " + RecentMovie);
        if (RecentMovie.contains("Guardians of the Galaxy Vol. 3")) {
            System.out.println("THIRD CONDITION IS PASSED LATEST RELEASE MOVIE");

        } else {
            System.out.println("THIRD CONDITION FAIL");
        }
        // Which movie has the most user ratings?
        // select sort by dropdown
        // select RATING
        select.selectByVisibleText("Ranking");
        List<WebElement> allmovies3 = driver.findElements(By.xpath("//td[@class='titleColumn']/a"));
        // find webelement list Using Locator "XPath" //td[@class='titleColumn']/a
        List<String> userRating = new ArrayList<>();
        for (WebElement userrating : allmovies3) {
            String sss = userrating.getText();
            userRating.add(sss);

        }
        // store in list
        // select first one get title
        // The Shawshank Redemption//
        String mostUSerRating = userRating.get(0);
        System.out.println("Most User Rating : " + mostUSerRating);
        if (mostUSerRating.contains("The Shawshank Redemption")) {
            System.out.println("FOURTH CONDITION IS PASSED MOST USER RATING  MOVIE");

        } else {
            System.out.println("FOURTH CONDITION FAIL");
        }
    }
}
