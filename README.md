# CS305 ASSIGNMENT 1

### Keshav Krishna<br />
### 2019CSB1224<br />
### CS305<br />

## 1. What does this program do<br />
In this program, a java library is developed, which executes SQL queries for create, read, update, delete operations on a database.<br />
The library, reads SQL queries from a xml file, by parsing the xml file.<br />
The parameters of the queries are populated dynamically from supplied objects.<br />
The resultSet from select queries are used to populate POJOs.<br />

## 2. A description of how this program works (i.e. its logic)<br />
This program's working can be roughly divided into following modules:<br />
The given xml file is parsed, and xml queries and paramTypes are filled in a list.<br />
Connection to database is established.<br />
paramType and passed paramters are comparred.<br />
All parameters in query are filled with respective values.<br />
The query is run and the result obtained is used to populate POJOs in case of SELECT queries.<br />
In detail, when a new object is created of finalImplementation2, the constructor is called, which parses the xml document and stores the queries and queryParam in a List. The user of the library opens a connection to a database and sets con variable of class FinalImplementation2 to the connection object.<br />
Then the user can start running the functions: selectOne, selectMany, insert, delete and update. <br />
The fuctions first iterate through the list of queries to get the query corresponding to the queryId passed.<br />
Then it checks if passed parameters and xml ParamType are of the same type or not. If they are not, a exception is thrown. <br />
If the type of passed parameters and xml ParamType are same, then the function checks condition and correspondingly calls either substituteValue Array or substituteValueObject to substitute the value dynamically in the query.<br />
Finally the query is run and the result is mapped to POJO in case of select query using a function mapRersultSetToObject, which maps the resultSet to similar named properties of the POJO, so actor_id column in resultSet is mapped to actor_id variable of the POJO and likewise.<br />

## 3. How to compile and run this program<br />
run following mysql queries on actor table of sakila database to get rows to test on:<br />
*insert into actor values(201, 'name1', 'namelast1', '2006-02-15 04:35:33');<br />
insert into actor values(202, 'name2', 'namelast2', '2006-02-15 04:35:33');<br />
insert into actor values(203, 'name3', 'namelast3', '2006-02-15 04:35:33');<br />
insert into actor values(204, 'name4', 'namelast4', '2006-02-15 04:35:33');<br />
insert into actor values(205, 'name5', 'namelast5', '2006-02-15 04:35:33');<br />*
Go the folder of this program and run<br />
gradle test<br />
Or it can also be run by opening the library in IntelliJ and then running the FinalImplementation2Test.java file.<br />
For primitives or array of primitives or collection of primitives:<br />
${value} is used to denote a single element, each ${value} can only be replaced by a single value, not an array.<br />
For objects of classes:<br />
${propx} is used to denoted obj.propx, that is, property propx of object obj.<br />
Here also, only one element can replace ${propx}, not an array of values.<br />

## 4. Provide a snapshot of a sample run:<br />

> Task :lib:compileJava<br />
Note: D:\Course_materials\CS305\Assignments\assign1_temp\lib\src\main\java\org\assign1_temp\finalimplementation2.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
> Task :lib:processResources NO-SOURCE
> Task :lib:classes
> Task :lib:compileTestJava UP-TO-DATE
> Task :lib:processTestResources NO-SOURCE
> Task :lib:testClasses UP-TO-DATE
> Task :lib:test
Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
1
PENELOPE
Query after replacing values:

      select * from actor where actor_id=1 and first_name="PENELOPE";


>1 PENELOPE GUINESS 2006-02-15 04:34:33.0
Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
1
Query after replacing values:

      select * from actor where actor_id=1;


>1 PENELOPE GUINESS 2006-02-15 04:34:33.0
Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
actor_id==1
first_name==PENELOPE
last_name==null
last_update==null
java.lang.NullPointerException
	at org.assign1_temp.finalImplementation2.substituteValueObject(finalimplementation2.java:42)
	at org.assign1_temp.finalImplementation2.selectOne(finalimplementation2.java:78)
	at org.assign1_temp.finalImplementation2Test.selectOne3(finalimplementation2Test.java:66)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:567)
	at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:688)
	at org.junit.jupiter.engine.execution.MethodInvocation.proceed(MethodInvocation.java:60)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:131)
	at org.junit.jupiter.engine.extension.TimeoutExtension.intercept(TimeoutExtension.java:149)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestableMethod(TimeoutExtension.java:140)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestMethod(TimeoutExtension.java:84)
	at org.junit.jupiter.engine.execution.ExecutableInvoker$ReflectiveInterceptorCall.lambda$ofVoidMethod$0(ExecutableInvoker.java:115)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.lambda$invoke$0(ExecutableInvoker.java:105)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:106)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.proceed(InvocationInterceptorChain.java:64)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.chainAndInvoke(InvocationInterceptorChain.java:45)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.invoke(InvocationInterceptorChain.java:37)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:104)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:98)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$6(TestMethodTestDescriptor.java:210)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:206)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:131)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:65)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:143)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:143)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:108)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:88)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:54)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:67)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:52)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:96)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:75)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:99)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$000(JUnitPlatformTestClassProcessor.java:79)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:75)
	at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:61)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:567)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
	at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33)
	at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:94)
	at com.sun.proxy.$Proxy2.stop(Unknown Source)
	at org.gradle.api.internal.tasks.testing.worker.TestWorker$3.run(TestWorker.java:193)
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.executeAndMaintainThreadName(TestWorker.java:129)
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:100)
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:60)
	at org.gradle.process.internal.worker.child.ActionExecutionWorker.execute(ActionExecutionWorker.java:56)
	at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:133)
	at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:71)
	at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:69)
	at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java:74)
Query after replacing values:

      select * from actor where actor_id=1 and first_name="PENELOPE";


>1 PENELOPE GUINESS 2006-02-15 04:34:33.0
Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
actor_id==201
first_name==changed
last_name==try
last_update==2006-02-15 04:35:33
Query after replacing values:

        UPDATE actor set first_name="changed" where actor_id=201;


>1
Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
changedyetagain
202
Query after replacing values:

        UPDATE actor set first_name="changedyetagain" where actor_id=202;


>1
Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
P%
Query after replacing values:

      select * from actor where first_name like "P%";


>1 PENELOPE GUINESS 2006-02-15 04:34:33.0
46 PARKER GOLDBERG 2006-02-15 04:34:33.0
54 PENELOPE PINKETT 2006-02-15 04:34:33.0
104 PENELOPE CRONYN 2006-02-15 04:34:33.0
120 PENELOPE MONROE 2006-02-15 04:34:33.0
Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
1
2
Query after replacing values:

      select * from actor where actor_id=1 or actor_id=2;


>1 PENELOPE GUINESS 2006-02-15 04:34:33.0
2 NICK WAHLBERG 2006-02-15 04:34:33.0
Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
203
Query after replacing values:

        DELETE FROM actor where actor_id=203;


>Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
actor_id==204
first_name==name4
last_name==try
last_update==2006-02-15 04:35:33
Query after replacing values:

        DELETE FROM actor where actor_id=204 and first_name="name4";


>Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
205
name5
namelast5
Query after replacing values:

        DELETE FROM actor where actor_id=205 and first_name="name5";


>Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
actor_id==206
first_name==abc
last_name==lastabc
last_update==2006-02-15 04:34:33
Query after replacing values:

      INSERT INTO actor values(206, "abc", "lastabc", "2006-02-15 04:34:33");


>Queries are:
insertIntoActor1 class org.assign1_temp.testclass2 INSERT INTO actor values(${actor_id}, ${first_name}, ${last_name}, ${last_update});
insertIntoActor2 class [Ljava.lang.Object; INSERT INTO actor values(${value}, ${value}, ${value}, ${value});
selectActors1 class java.lang.String select * from actor where first_name like ${value};
selectActors2 class [I select * from actor where actor_id=${value} or actor_id=${value};
selectActor1 class [Ljava.lang.Object; select * from actor where actor_id=${value} and first_name=${value};
selectActor2 class java.lang.Integer select * from actor where actor_id=${value};
selectActor3 class org.assign1_temp.testclass2 select * from actor where actor_id=${actor_id} and first_name=${first_name};
updateActor1 class org.assign1_temp.testclass2 UPDATE actor set first_name=${first_name} where actor_id=${actor_id};
updateActor2 class [Ljava.lang.Object; UPDATE actor set first_name=${value} where actor_id=${value};
deleteActor1 class java.lang.Integer DELETE FROM actor where actor_id=${value};
deleteActor2 class org.assign1_temp.testclass2 DELETE FROM actor where actor_id=${actor_id} and first_name=${first_name};
deleteActor3 class [Ljava.lang.Object; DELETE FROM actor where actor_id=${value} and first_name=${value};
207
hi
areYouOkay
2006-02-15 04:35:33
Query after replacing values:

      INSERT INTO actor values(207, "hi", "areYouOkay", "2006-02-15 04:35:33");


BUILD SUCCESSFUL in 10s
3 actionable tasks: 2 executed, 1 up-to-date
20:33:13: Execution finished ':lib:test --tests "org.assign1_temp.finalImplementation2Test"'.
