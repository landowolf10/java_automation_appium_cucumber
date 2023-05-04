package framework.utils;

import org.openqa.selenium.By;

import static framework.utils.Scroll.scroll;

public class DynamicSearch extends BasePage
{
    public static void dynamicSearch(String element)
    {
        boolean elementDisplayed = elementExists(By.xpath("//*[@text=" + "'" + element + "'" + " or @label=" +
                "'" + element + "'" + "]"), 10);

        while(!elementDisplayed)
        {
            scroll("up");

            elementDisplayed = elementExists(By.xpath("//*[@text=" + "'" + element + "'" + " or @label=" +
                    "'" + element + "'" + "]"), 10);
        }
    }
}