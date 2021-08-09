# BoatSens - Backend
 
BoatSens provides a **Springboot** based Backend for validation and reprocessing of Sensordata delivered via **REST API**.
The Backend runs on a **ec2-micro** instance on **Amazon AWS**. The Data is stored on **Amazon RDS** in a **PostgreSQL** Database.
As Sensorclients RaspberryPi Zero-W Boards with DS18B20 1-Wire Sensors are used. 


![Banner](https://user-images.githubusercontent.com/63147491/128516585-74659998-ae69-4942-8b3e-8b648a73bd3f.jpg)




### Shortcuts:

API controller can be found here:  
https://github.com/DomSimon/BoatSens-Backend/blob/main/src/main/kotlin/sensors_backend/ApiController.kt  
Spring application can be found here:  
https://github.com/DomSimon/BoatSens-Backend/blob/main/src/main/kotlin/sensors_backend/SensorsBackendApplication.kt  



### Direct access to the API is available at:  
Last 1h:  
http://ec2-3-68-226-39.eu-central-1.compute.amazonaws.com:8080/api/last1h

Between two Timestamps:
http://ec2-3-68-226-39.eu-central-1.compute.amazonaws.com:8080/api/between/2021-07-12T09:38/2021-07-12T09:40

Hottest recognized Temperature:
http://ec2-3-68-226-39.eu-central-1.compute.amazonaws.com:8080/api/hottest_day

Coldest recognized Temperature:
http://ec2-3-68-226-39.eu-central-1.compute.amazonaws.com:8080/api/coldest_day

### Data is provided via REST API as JSON in the form of

```
"id": "40405",
"sensorname": "28-0213137cfeaa",
"sensordate": "2021-08-09T00:28:40.080421",
"sensorvalue": "16.687",
"sensortype": "temperature"
},
{
"id": "40406",
"sensorname": "28-02131390d8aa",
"sensordate": "2021-08-09T00:38:42.190998",
"sensorvalue": "23.125",
"sensortype": "temperature"
},
{
"id": "40407",
"sensorname": "28-0213137cfeaa",
"sensordate": "2021-08-09T00:38:42.37802",
"sensorvalue": "16.937",
"sensortype": "temperature"
},
```
u
