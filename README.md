# Getting Started

#### REST API example application

	This application is built to run as a micro service where we store the vehicle details retrieved by the post url in a map.
	
	Vehicle is the model class for which we are accepting the input as JSON from the RestAPI
	Result is the output response which gives us 3 parameters
	- vin - which indicates the vehicle unique id
	- uid - Random generated ID
	- status - HTTP status

## Create a new Request

### Request

`POST /vehicle-api/v1/vehicles/vehicle/`

    curl --location --request POST `http://localhost:8081/vehicle-api/v1/vehicles/vehicle 
    Content-Type: application/json
    --data-raw '{"vin": "1A4AABBC5KD501999", "year": 2019,"make":"FCA","model": "RAM","transmissionType": "MANUAL"}`

### Response
    HTTP/1.1 200 OK
    Status: 200 OK
    Connection: close
    Content-Type: application/json
	{
	    "uid": "728a4278-3189-4442-ab79-4bc6b8fcc9a9",
	    "vin": "1A4AABBC5KD501999"
	}

## Junit tests
	200 - Success scenario
	400 - Invalid transmission type
	500 - Any other taken as internal server error
	
## Application start
	Start the application as a SpringBootApplication by running the VehicleDemoApplication.java 
	Got to post man and post for the data and same is handled for different positive and error scenarios
	Same can be tested with the Junit test cases too.