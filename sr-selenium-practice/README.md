# Simple Selenium Framework

This test automation framework repofor self-learning purpose only. it is important for me to understand how it works from behind. 
There are lots of selenium outther such serinitybdd or selenide.

## Framework Structure

## Usage

### Execute BDD using Cucumber using maven and tags

Maven Profile 1 : cucumber-profile \
Parallel : False \
Mandatory argument ``-Dtags``

```shell
mvn test -Pcucumber-profile -Dtags=@SmokeTest
```

```shell
mvn test -Pcucumber-profile -Dtags=@Test
````

#### Available test tags for BDD
```java
@SmokeTest
@Test
```

### Cucumber Parallel Test Execution

```shell
 mvn test -Pcucumber-parallel -Dtags=@Test
```

### Trigger Gitlab pipelines using API

```shell
curl -X POST --fail -F token=glptt-e1485617ddefd9734f9829ef2748b0013f9c8557 -F "ref=REF_NAME" -F "variables[RUN_NIGHTLY_BUILD]=true" http://localhost/api/v4/projects/35/trigger/pipeline
```

### Execute TDD TestNG XML file using maven


### Cucumber Retry Run

`CucumberFailedTestRunner` will executed after main cucumber runner which is `CucumberTestRunner`. this have been configure through `pom.xml` under ``cucumber-profile`` profile

#### Notes

- Auto retry test failed only for single thread execution *(cucumber-profile)*. not available on remote parallel execution.

### App Configuration
#### Selenium properties
```
# Web Url to be tested
base_url=

# WebDriver
browser=CHROME

# Execution remote parallel such selenium grid.
# depends on browser.remote. else will be execute parallel on local env.
parallel=true

# Execute remote browser container such docker/kubernetes. true or false
browser.remote=true

# Remote selenium grid hub
browser.remote.url=http://localhost:4444

# force wait for elements selector to display within define time range.
# clickByText()
# verifyByText()
elements.timeout=5000
```
```element.timeout```is custom code to handling elements path not generated due to animation or something else.

##### Allure properties (NOT WORKING)
allure properties for cucumber settings. so far not working. will be fix later.
```
# allure.properties
allure.results.directory=target/allure-results
allure.link.pattern=https://example.com/issues/{}
allure.issues.tracker.pattern=https://example.com/issues/{}
```

##### Cucumber properties
```
No specific configuration define
```
## Lesson Learnt

- [x] Setup selenium webdriver, remote web driver from sratch
- [x] parallel execution on docker selenium grid with testng
- [x] execute test with different maven profiles
- [x] instantiate  web driver with threadlocal
- [x] develop and execute test scriptsing usince JVM cucumber and testng libraries
- [x] execute test combination different tags. cucumber and testng tags.
- [x] Include faker data generate for test scripts. email,address,firstname,lastname etc.
- [x] run test via CI tools such github action,gitlab and jenkins.
- [x] Re-execute test using testng retry analyzer.
- [x] Develop test script using BDD feature file.
- [x] Test API using RestAssured.
- [x] Integrate with allure report. 
- [x] add custom listener for every test step.
- [x] import test data using excel,csv and data provider testng

## Resources





