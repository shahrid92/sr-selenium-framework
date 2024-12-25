## Simple Selenium Framework

#### Execute BDD using Cucumber using maven and tags

Maven Profile 1 : cucumber-profile
Parallel : False
Mandatory argument ``-Dtags``

``mvn test -Pcucumber-profile -Dtags=@SmokeTest`` 

``mvn test -Pcucumber-profile -Dtags=@Test``

to find test tags refer to the BDD feature files

#### Cucumber Parallel Test Execution

```shell
 mvn test -Pcucumber-parallel -Dtags=@Test
```

#### Trigger Gitlab pipelines using API

```shell
curl -X POST --fail -F token=glptt-e1485617ddefd9734f9829ef2748b0013f9c8557 -F "ref=REF_NAME" -F "variables[RUN_NIGHTLY_BUILD]=true" http://localhost/api/v4/projects/35/trigger/pipeline
```

#### Execute TDD TestNG XML file using maven


### Feature to be added
- [ ] Dockerfile orangehrm app
- [ ] keyword excel script automation
- [ ] aerokube for cicd implementation

### Last Activity Log

- add text context to share data between steps 
- add new java faker data generator
- add new lib - cucumber picontainer (share state)
- change io.cucumber version java,junit,pico-container

### High Priority
- [ ] pico-container **not working** require quick fix


### What TO-DO Next

- [ ] Need to setup app docker to access db for scenario
- [ ] explore mockito framework for mock or stub
- [ ] setup parallel test testng and cucumber for docker
- [ ] create docker compose yaml ondemand]

* test. [^1]

[^1]:testtrerertert

1. test 
   1. test
   1. test
   1.


