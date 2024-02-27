package common.utilities;
import static common.TestBase.globalTimestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StepsScreenShot {
    public static void takeSnapShot(WebDriver webdriver, String fileName, WebElement ele) throws IOException {

        long timestampMillis = System.currentTimeMillis();
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampMillis), java.time.ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmssSSS");
        String formattedTimestamp = dateTime.format(formatter);

        String folderTarget = ".\\target\\screenshot\\"+globalTimestamp+"\\elements";
        new File(folderTarget).mkdirs();
        String folderTarget2 = ".\\target\\screenshot\\"+globalTimestamp+"\\";

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File Source_File=scrShot.getScreenshotAs(OutputType.FILE);

            String filepath = folderTarget2+fileName+"-"+timestampMillis+"-"+formattedTimestamp+".png";
            File destFile=new File(filepath);
            FileUtils.copyFile(Source_File, destFile);

        if(ele != null){
            BufferedImage fullImg = ImageIO.read(Source_File);

            Point point = ele.getLocation();

            int eleWidth = ele.getSize().getWidth();
            int eleHeight = ele.getSize().getHeight();

            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                    eleWidth, eleHeight);
            ImageIO.write(eleScreenshot, "png", Source_File);

            File screenshotLocation = new File(folderTarget+"\\"+timestampMillis+"-element"+".png");
            FileUtils.copyFile(Source_File, screenshotLocation);
        }
    }

    public static void takeSnapShot(WebDriver webdriver, String fileName)throws IOException{
        takeSnapShot(webdriver, fileName,null);
    }
}
