# (Check-out Card)

How Build

 * set maven and java path.
  
 ```
 Run command : 
 1. mvn clean install
 2. mvn spring-boot:run

 ```
 Once suuccessfully start :+1: run below comman from Rest Client or Postman.
  
 - Set authentication is http basic and useename and password as user [ ref image 1]
 If you not set username and password then there will hht error code will back
 
 **Product list  :**
 ```
 Method : GET
 Rest url : http://localhost:8080/rest/productlist
 OutPut : 
 {
  "1": {
    "itemid": 1,
    "description": "prod_A_1",
    "category": "A",
    "price": 212.5,
    "sTaxinPercent": 10,
    "servicetaxprice": 21.25
  },
  "2": {
    "itemid": 2,
    "description": "prod_A_2",
    "category": "A",
    "price": 142.1,
    "sTaxinPercent": 10,
    "servicetaxprice": 14.21
  }, 
  ......
}
 ```
 
 **Generate bill list  :**
 In Body contain itemid and quantity for product, item id get from above request.[Ref image 2]
 ```
 Method : POST
 Content-Type : application/json
 Rest url : http://localhost:8080/rest/generatebill
 input in Body : 
 [
	{
		"itemId":"1",
		"quantity":"2"
	},
	{
		"itemId":"4",
		"quantity":"2"
	}
]
Output : 
 {
  "orderNumber": "8dadbb95-5221-40fc-a70a-de8ea8e883d5",
  "totalprice": 345.1,
  "servicetax": 37.162,
  "selectedProduct": [
    {
      "itemid": 1,
      "description": "prod_A_1",
      "category": "A",
      "price": 212.5,
      "sTaxinPercent": 10,
      "servicetaxprice": 21.25
    },
    {
      "itemid": 4,
      "description": "prod_A_4",
      "category": "A",
      "price": 132.6,
      "sTaxinPercent": 12,
      "servicetaxprice": 15.911999999999999
    }
  ]
}

Ouput contain list of item with total price and service tax. [Ref image 3]


 ```# (Check-out Card)

How Build

 * set maven and java path.
  
 ```
 Run command : 
 1. mvn clean install
 2. mvn spring-boot:run

 ```
 Once suuccessfully start :+1: run below comman from Rest Client or Postman.
  
 - Set authentication is http basic and useename and password as user [ ref image 1]
 If you not set username and password then there will hht error code will back
 
 **Product list  :**
 ```
 Method : GET
 Rest url : http://localhost:8080/rest/productlist
 OutPut : 
 {
  "1": {
    "itemid": 1,
    "description": "prod_A_1",
    "category": "A",
    "price": 212.5,
    "sTaxinPercent": 10,
    "servicetaxprice": 21.25
  },
  "2": {
    "itemid": 2,
    "description": "prod_A_2",
    "category": "A",
    "price": 142.1,
    "sTaxinPercent": 10,
    "servicetaxprice": 14.21
  }, 
  ......
}
 ```
 
 **Generate bill list  :**
 In Body contain itemid and quantity for product, item id get from above request.[Ref image 2]
 ```
 Method : POST
 Content-Type : application/json
 Rest url : http://localhost:8080/rest/generatebill
 input in Body : 
 [
	{
		"itemId":"1",
		"quantity":"2"
	},
	{
		"itemId":"4",
		"quantity":"2"
	}
]
Output : 
 {
  "orderNumber": "8dadbb95-5221-40fc-a70a-de8ea8e883d5",
  "totalprice": 345.1,
  "servicetax": 37.162,
  "selectedProduct": [
    {
      "itemid": 1,
      "description": "prod_A_1",
      "category": "A",
      "price": 212.5,
      "sTaxinPercent": 10,
      "servicetaxprice": 21.25
    },
    {
      "itemid": 4,
      "description": "prod_A_4",
      "category": "A",
      "price": 132.6,
      "sTaxinPercent": 12,
      "servicetaxprice": 15.911999999999999
    }
  ]
}

Ouput contain list of item with total price and service tax. [Ref image 3]


 ```