# Spring Cloud Contract

This repository gives you a bare bone example of how spring cloud contract can achieve consumer driven contract testing for REST. There is a workshop(http://cloud-samples.spring.io/spring-cloud-contract-samples/workshops.html) for spring cloud contract which explains how this can be extended for Messaging. This is not covered in this repository. 

This repository shows examples of
- storing contracts on the producer side
- generating contracts on the producer side and also package, bundle them as part of the other artifacts

> Spring Cloud Contract Verifier moves TDD to the level of software architecture.

## Projects

### producer
The producer application contains contracts for both REST only. From these contracts tests and stubs will be generated.

To verify if the contracts are fulfilled by producer's implementation, do a clean build after placing the contracts in the `test/resources/contracts` folder

```
cd producer
./gradlew clean build
```

To publish the stubs into a local maven reposioty, do
```
cd producer
./gradlew clean build publishToMavenLocal
```
`publishToMavenLocal` will publish all artifacts including stubs to `$HOME/.m2/repository/com/ebsco/cdc/producer/0.0.1-SNAPSHOT/producer-0.0.1-SNAPSHOT-stubs.jar`


> REST Docs are generated from the contracts in `producer/target/generated-snippets/contracts.adoc`

To view the contracts that are published after a clean build, go to
``` 
cd producer/build/libs/META-INF/com.ebsco.cdc/producer/0.0.1-SNAPSHOT/mappings/greeting/rest/
```
OR
```
cd producer/build/stubs/META-INF/com.ebsco.cdc/producer/0.0.1-SNAPSHOT/mappings/greeting/rest/
```

### consumera
To run the contract tests using the published stubs in a local Maven repository, do
```
cd consumera
./gradlew clean build
```


### consumerb
To run the contract tests using the published stubs in a local Maven repository, do
```
cd consumerb
./gradlew clean build
```

### Ongoing Development
We are still working on creating a nodejs consumer which will use the pacts from either a local maven repository or a remote one.



