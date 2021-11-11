**$ mvn versions:display-dependency-updates**

[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< org.example:SauceDemo >------------------------
[INFO] Building SauceDemo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- versions-maven-plugin:2.8.1:display-dependency-updates (default-cli) @ SauceDemo ---
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.0.0
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.4.0

**$ mvn versions:use-latest-versions**
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------------< org.example:SauceDemo >------------------------
[INFO] Building SauceDemo 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- versions-maven-plugin:2.8.1:use-latest-versions (default-cli) @ SauceDemo ---
[INFO] Major version changes allowed

**$ mvn clean test -Dtest=LoginTest test**

ChromeDriver was started successfully.
лист. 10, 2021 10:31:15 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.641 s - in tests.LoginTest
[INFO]
[INFO] Results:
[INFO]ChromeDriver was started successfully.
лист. 10, 2021 10:31:15 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.641 s - in tests.LoginTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0




**CartPage Checklist:**
1-add any product => passed.
2-add two products => passed.
3-remove product => passed.
4-empty cart for another user => failed _(there is some element)_.

**LoginPage Checklist:**
1-empty entry => passed.
1-empty login=> passed.
3-empty password => passed.
4-incorrect password=> passed.
5-password is hidden => passed.
6-login and password matched => passed.