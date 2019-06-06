# productservice

Product Service API exposed below listed operations to to do Create/Update/Delete/Get products.

#### DELETE /productService/product/delete/{id}
#### DELETE /productService/product/deleteall
#### GET /productService/product/{id}
#### GET /productService/products/all
#### POST /productService/product/add

For client representation swagger 2.0 API is used. Application can be installed or run on tomcat server. Below is the
swagger URL. The API port and application database can be chnage through Application.properties.

## http://localhost:8080/swagger-ui.html

In-memory H2 database used for above listed operation. Below is the URL for database.

##http://localhost:8080/h2-console/

#Sample Request For above listed operations.

 ### Add Product
 
{
  "description": "string",
  "dietaryFlags": "VEGAN",
  "id": 0,
  "image": "string",
  "numberOfView": 0,
  "price": 0,
  "title": "string",
  "vendorUID": "string"
}

