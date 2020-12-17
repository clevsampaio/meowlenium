package br.com.meowlenium.framework.utils;

import br.com.meowlenium.framework.reports.ReportListener;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({
        ExtentITestListenerClassAdapter.class,
        ReportListener.class
})
public abstract class BaseDesktop {
    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }
}