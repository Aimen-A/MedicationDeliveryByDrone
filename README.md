# DroneMedicationDelivery
This is a medication delivery by drone project


-Requirements
  Java 17
  Java IDE (Visual Studio,Eclipse,Intellij etc)
  Postman(Api Testing)

-Clone the project from the link : 

-Open the cloned project in the IDE.

-Maven will update all dependencies.

-Run the project

-Some of the assumption made are:-
    -Drone can be registered at any state that is LOADING,LOADED,DELIVERYING ETC.
    -Drones that are available for loading are of state IDLE,LOADING,RETURNED.
    -Drone can load multiple medicines as long as combine medicine weight does not exceed weight capacity of drone
    
-In Log folder, the logs are maintain for each day which contains Drone's Battery Level

-Project has H2 in-memory database configiration and has some data loaded automatically in it upon running.
  -H2 database's console can be accessed on the following link :
                    http://localhost:9090/h2-console/
   -Enter correct jdbc url link: jdbc:h2:mem:drone, username:sa, leave password empty and click connect
     ![image](https://user-images.githubusercontent.com/30953824/189734258-4d7d18dd-ebe3-40d6-af60-d795de4de805.png)

Following page will open, this is H2 database console and here you can view the table's preloaded data and new data that may be added as apis are tested.
![image](https://user-images.githubusercontent.com/30953824/189734681-950db963-b426-43d7-837a-e37b5b831c37.png)


-Testing the API
  Open Postman For testing APIs

  -Make sure to add ContentType is application/json in headers tab.
  ![image](https://user-images.githubusercontent.com/30953824/189733506-23ae444b-359c-4bdd-aa15-8ed9c5266dd6.png)

  1-Registering Drone -> http://localhost:9090/drone/dispatch/register
  Request:
  ![image](https://user-images.githubusercontent.com/30953824/189734966-4331ece7-53d8-46e8-9828-38c6cd819390.png)
  Response:
  ![image](https://user-images.githubusercontent.com/30953824/189735045-31d878de-cc30-44d3-9476-f1f702c32662.png)

  2-Available Drones For Loading -> http://localhost:9090/drone/dispatch/available
  Response:
  ![image](https://user-images.githubusercontent.com/30953824/189735378-b68b9afd-47d0-457f-9840-c47a10d8d3c4.png)

  3-Check Drone Battery -> http://localhost:9090/drone/dispatch/checkBattery/{serialNumber}
  Response:
  ![image](https://user-images.githubusercontent.com/30953824/189735577-c1694b27-f022-4f90-a09e-82e9b1efd1c0.png)

  4-Load Drone With Medication -> http://localhost:9090/drone/dispatch/loadDroneWithMedication
  Request:
  ![image](https://user-images.githubusercontent.com/30953824/189736253-42d2b7fc-9967-4345-b881-5329ff985c87.png)
  Response:
  ![image](https://user-images.githubusercontent.com/30953824/189736353-f2dca11c-2bcb-421d-9418-974836ba48ff.png)

  5-Check Loaded Medication of a Drone -> http://localhost:9090/drone/dispatch/checkBattery/{serialNumber}
  Response:
  ![image](https://user-images.githubusercontent.com/30953824/189737119-e46701b0-783e-4573-85a1-eebc2543955a.png)

END
