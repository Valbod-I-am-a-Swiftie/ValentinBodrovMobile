These tests are for checking of native and web based apps 
functionality on *EPAM Mobile Cloud service*. To run these tests
use the steps below:
* Sign in and run Mobile Cloud service
* Insert a token in `auth.api.properties` file
* Insert a UDID of device in preferable
properties file if you want to run tests on a 
certain device
* Set a suitable profile in InteliJ Idea and launch 
tests
    * You also can create run configurations in your
     InteliJ Idea. Using TestNG configuration, select
     group "ios_web" or "android_native" and run your 
     test