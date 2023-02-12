## MapReduce Work Flow

### ----------------------------------Execution Direction----------------------------->

| input data     | event | mapper1~4                                                      | event   |                                                          | event  | output data(merged)                                                         |
| -------------- | ----- | -------------------------------------------------------------- | ------- | -------------------------------------------------------- | ------ | --------------------------------------------------------------------------- |
| file1(Mapper1) | Map   | <Hello, 1><br /><World, 1><br /><Bye, 1><br /><World, 1>       | combine | <Hello, 1><br /><World, 2><br /><Bye, 1><br /><World, 1> | reduce | <Bye, 1><br /><Goodbye, 1><br /><Hadoop, 2><br /><Hello, 2><br /><World, 2> |
| file2(Mapper2) | Map   | <Hello, 1><br /><Hadoop, 1><br /><Goodbye, 1><br /><Hadoop, 1> | combine | <Hello, 1><br /><Hadoop, 2><br /><Goodbye, 1>            | reduce |                                                                             |

### Execution Command

````Bash
mvn package wordCount
````

````Bash
hadoop jar target/wordCount-1.0-SNAPSHOT.jar WordCountTest src/main/java/input/ src/main/java/output/result
````
