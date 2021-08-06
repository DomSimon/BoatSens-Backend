# BoatSens - Backend
 
BoatSens provides a Springboot based Backend for validation and reprocessing of Sensordata delivered via REST API.
As Sensorclients RaspberryPi Zero-W Boards with DS18B20 1-Wire Sensors are used. 


![Banner](https://user-images.githubusercontent.com/63147491/128516585-74659998-ae69-4942-8b3e-8b648a73bd3f.jpg)

The Backend is hostet in one ec2 instance on AmazonAWS.
Direct access to the API (measurements of the last 1h) is available at:
http://ec2-3-68-226-39.eu-central-1.compute.amazonaws.com:8080/api/last1h
