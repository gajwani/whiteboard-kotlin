package demo

import org.fluentlenium.adapter.junit.FluentTest
import org.fluentlenium.configuration.ConfigurationProperties
import org.fluentlenium.configuration.FluentConfiguration
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

@FluentConfiguration(
        screenshotMode=ConfigurationProperties.TriggerMode.AUTOMATIC_ON_FAIL,
        screenshotPath = "./screenshots"
)
open class BaseCMasterTest : FluentTest() {
    override fun newWebDriver(): WebDriver {
        return if (runningOnCI())
            linuxChromeWebDriver()
        else
            super.newWebDriver()
    }

    private fun runningOnCI(): Boolean {
        return System.getenv("CI") == "true"
    }

    private fun linuxChromeWebDriver(): WebDriver {
        val chromeOptions = ChromeOptions()
        chromeOptions.setBinary("/opt/google/chrome/chrome")
        chromeOptions.addArguments("--headless", "--disable-gpu")
        return ChromeDriver(chromeOptions)
    }
}
