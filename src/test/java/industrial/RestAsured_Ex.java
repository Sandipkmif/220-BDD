package industrial;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAsured_Ex {
	/*RestAssured API format
	Given- request formation/pre-requisite
	When- Action Perform
	Then- verification/Assertion of response
*/
	@Test
	public void getMethod(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		//RestAssured.given()//keep it blank if we dont have any request
	    Response response=RestAssured.when().get("posts/1");
	    
	    System.out.println("Response body"+response.body().asPrettyString());
	    
	    JsonPath path=new JsonPath(response.body().asString());
	    String title=path.get("title");
	    System.out.println(title);
	    Assert.assertEquals(title, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
	    
	    System.out.println("vary-"+response.header("vary"));
	    Headers header=response.headers();
	    List<Header>headers=header.asList();
	    	for(Header head:headers){
	    		System.out.println(head.getName()+" "+head.getValue());
	    	}
	    	System.out.println("status code"+response.statusCode());
	}
	@Test
	public void postMethod(){
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		Response response=RestAssured.given().body("{\r\n"
        		+ "  \"title\": \"foo\",\r\n"
        		+ "    \"body\": \"bar\",\r\n"
        		+ "    \"userId\": \"1\"\r\n"
        		+ "  }")
				.headers("Content-Type","application/json")
				.when()
				.post("posts");
		
		System.out.println(response.body().asString());
		JsonPath path=new JsonPath(response.body().asString());
		Integer id=path.get("id");
		System.out.println("it should be 101: "+id);
		System.out.println("status code: "+response.statusCode());
	}
	 @Test
		public void putMethod() {
			RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
			Response response = RestAssured.given()
			.body("  {\r\n"
					+ "      \"id\":\"1\",\r\n"
					+ "  \"title\": \"foo\",\r\n"
					+ "    \"body\": \"This is updated from Postman\",\r\n"
					+ "    \"userId\": \"1\"\r\n"
					+ "  }")
			 .headers("Content-Type","application/json")
			 .when()
			 .put("posts/1");
			
			System.out.println("Status code: "+response.statusCode());
			System.out.println("Response body= "+response.body().asString());
	        JsonPath path = new JsonPath(response.body().asString());
	       Integer id = path.get("id");
	       System.out.println("it should be 1: "+id);
	       
	       
		}
	    @Test
	    public void patchMethod() {
	    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
	    	Response response = RestAssured.given()
	    	.body("  {\r\n"
	    			+ "  \"title\": \"foo\"\r\n"
	    			+ "  }")
	    	.headers("Content-Type","application/json")
	    	.when()
	    	.patch("posts/1");
	    	
	    	System.out.println("Status code: "+response.statusCode());
	    	JsonPath path = new JsonPath(response.body().asString());
	    	Integer id = path.get("id");
	    	System.out.println("it should be: "+id);
	    	System.out.println(path);
	    	System.out.println(response.headers());
	    	
	    }
	    @Test
	    public void deleteMethod() {
	    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
	    	Response response = RestAssured.when().delete("posts/1");
	        String ss =response.body().asString();
	        System.out.println(ss);
	        System.out.println("Status code: "+response.statusCode());
	    }
		}

	

