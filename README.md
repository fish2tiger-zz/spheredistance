# Great-distance calculator homework

## Getting Started
The project is built in using maven structure. The maven wrapper is prepared to ease the 
development environment setup.

To build the project, simple type: 

```
$ ./mvnw clean install
```

or

```
$ ./mvnw.cmd clean install
```

To Run, simple type :
```
$ java -jar target/hometest-1.0-SNAPSHOT-jar-with-dependencies.jar
```

The expected customer records will be printed in the console like: 
```

[INFO ] 2018-10-03 18:05:06.118 [main] RecordProvider - Loading customer records in url: https://s3.amazonaws.com/intercom-take-home-test/customers.txt
[INFO ] 2018-10-03 18:05:06.946 [main] CustomerRangeSearch - ============================================================================
[INFO ] 2018-10-03 18:05:06.946 [main] CustomerRangeSearch - Printing customer records within the range: 100.0 km , around center: Location {  latitude= 53.339428, longitude=-6.257664}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 0 : CustomerRecord {user_id='4', name='Ian Kehoe'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 1 : CustomerRecord {user_id='5', name='Nora Dempsey'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 2 : CustomerRecord {user_id='6', name='Theresa Enright'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 3 : CustomerRecord {user_id='8', name='Eoin Ahearn'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 4 : CustomerRecord {user_id='11', name='Richard Finnegan'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 5 : CustomerRecord {user_id='12', name='Christina McArdle'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 6 : CustomerRecord {user_id='13', name='Olive Ahearn'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 7 : CustomerRecord {user_id='15', name='Michael Ahearn'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 8 : CustomerRecord {user_id='17', name='Patricia Cahill'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 9 : CustomerRecord {user_id='23', name='Eoin Gallagher'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 10 : CustomerRecord {user_id='24', name='Rose Enright'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 11 : CustomerRecord {user_id='26', name='Stephen McArdle'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 12 : CustomerRecord {user_id='29', name='Oliver Ahearn'}
[INFO ] 2018-10-03 18:05:06.955 [main] CustomerRangeSearch - 13 : CustomerRecord {user_id='30', name='Nick Enright'}
[INFO ] 2018-10-03 18:05:06.956 [main] CustomerRangeSearch - 14 : CustomerRecord {user_id='31', name='Alan Behan'}
[INFO ] 2018-10-03 18:05:06.956 [main] CustomerRangeSearch - 15 : CustomerRecord {user_id='39', name='Lisa Ahearn'}
[INFO ] 2018-10-03 18:05:06.956 [main] CustomerRangeSearch - ============================================================================


```