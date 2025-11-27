Step 1:- Start a hub in one machine using the command "java -jar selenium-server-4.38.0.jar hub"
Step 2:- Start a node in another machine using the command "java -jar selenium-server-4.38.0 node --detect-drivers true --publish-events tcp://ipaddressofhub:4442 --subscribe-events tcp://ipaddressofhub:4443"
Step 3:- Run the program in the hub machine using the ip address of the hub and then the test case will be executed in the node machine.
