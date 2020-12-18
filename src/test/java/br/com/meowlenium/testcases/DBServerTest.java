package br.com.meowlenium.testcases;

import br.com.meowlenium.framework.utils.bases.BaseDesktop;
import br.com.meowlenium.pageobjects.DBServerPageObject;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DBServerTest extends BaseDesktop
{
    @Test(
            description = "Pratica de automação",
            priority = 1
    )
    public void dbserverTest()
    {
        Screen screen = new Screen();
        DBServerPageObject object = new DBServerPageObject(screen);

        screen.type("m", KeyModifier.WIN);
        object.openChrome().waitScreenElement();

        try {
            screen.doubleClick(object.openChrome().pattern());
            object.searchGoogle().waitScreenElement();
            screen.click(object.searchGoogle().pattern());
            screen.type("DBServer");
            screen.type(Key.ENTER);
            object.dbserverLink().waitScreenElement();
            screen.click(object.dbserverLink().pattern());
            boolean dbLogo = object.dbserverLogo().waitScreenElement();
            Assert.assertTrue(dbLogo);
            screen.type(Key.F4, KeyModifier.ALT);
        } catch (FindFailed ignored) {
        }
    }
}