# AUTOMATION MOBILE IN JAVA

## Framework

- Tests Definition: Gherkin language following TDD/BDD best practices
- BDD/TDD Framework: Cucumber. Using feature files in order to decouple test definition from test code
- Tests code: Java
- Cucumber:
-- Features directory: `features`.
-- Additional test code: `tests/src`
-- Framework utilizado para os testes https://github.com/VitorMeneses/thrall



## Test Execution

1. To perform the tests, it is necessary to have JDK of JAVA installed, Appium and an AVD created in Android Studio.
2. AVD must be configured according to the information contained in the createDriver class in the runner folder.
3. Put your appium server in the localhost path Host 127.0.0.1 - Port 4723
4. Execution via IDE, run the class responsible for starting the ANDROID RUNNER tests

