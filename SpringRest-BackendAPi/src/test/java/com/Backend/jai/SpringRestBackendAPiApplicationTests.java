package com.Backend.jai;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application.properties")
public class SpringRestBackendAPiApplicationTests {
	
	@Autowired
	public MockMvc mockMvc;

//	@Test
//	void contextLoads() {
//		
////		create a dummy request object(Method,TYPE,URL,Header,body)
//		
//		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
//				.post("")
//				.contentType(MediaType.APPLICATION_JSON)
//				.contentType("");
//		
//		MockHttpServletRequestBuilder request1 = MockMvcRequestBuilders
//				.get("URL","Params","params")
//				.contentType(MediaType.APPLICATION_JSON);
//		
//				
//		
//		
//		
//		
//	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Test
	@DisplayName("SAVING STUDENT") // giving test case name
	@Order(1) // order of test
	public void CreateStudentTest() throws Exception {
		
		
	

		String Body = "  {\n"
				
				+ "        \"stdName\": \"Jenny Miller\",\n"
				+ "        \"stdGen\": \"Male\",\n"
				+ "        \"stdCourse\": \"Bio\",\n"
				+ "        \"stdAddr\": \"300 Redwood St, City, Country\"\n"
				+ "    }";
//  1.create a dummy request object(Method,TYPE,Body,URL,)
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("http://localhost:9999/v1/api/student/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(Body);
				
// 2.Send the request and get the response
				MvcResult result = mockMvc.perform(request).andReturn();
						
				
//3. Retrieve the data from the request object to perform testing
				MockHttpServletResponse response = result.getResponse();
				
// 4.Use junit to test wheter the testcase is pass or fail
				assertEquals(HttpStatus.CREATED.value(),response.getStatus());
		
		
	}
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
	
	@Test
	@Order(2)
	@DisplayName("Finding STUDENT")
	public void getStudentTest() throws Exception {

	    // 1. Create a dummy request object (Method, TYPE, Body, URL)
	    MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	            .get("http://localhost:9999/v1/api/student/find/{id}", 10);

	    // 2. Send the request and get the response
	    MvcResult result = mockMvc.perform(request).andReturn();

	    // 3. Retrieve the data from the response object to perform testing
	    MockHttpServletResponse response = result.getResponse();

	    // 4. Use JUnit to test whether the test case passes or fails
	    assertEquals(HttpStatus.OK.value(), response.getStatus());
	    assertNotNull(response.getContentAsString());

	    // Get the response content type and check it against expected JSON content type
	    assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());

	    // Output the response body
	    String output = response.getContentAsString();
	    System.out.println(output);
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
	@Test
	@Order(3)
	@DisplayName("Delete STUDENT Not Found")
	public void deleteStudentNotFoundTest() throws Exception {
	    // Attempt to delete a student that does not exist
	    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("http://localhost:9999/v1/api/student/remove/{id}", 9);

	    MvcResult result = mockMvc.perform(request).andReturn();
	    MockHttpServletResponse response = result.getResponse();

	    // Assert that the status is 404 NOT FOUND
	    assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());

	    // Assert the content type
	    assertEquals(HttpStatus.ACCEPTED.value(), response.getContentType());

	    // Check the response body for expected message
	    String output = response.getContentAsString();
	    System.out.println("Response Body: " + output);
	    
	    // Optionally, parse the output JSON to check for specific messages if needed
	}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------			
	
	@Test
	@Order(3)
	@DisplayName("Finding All STUDENT")
	public void getallStudentTest() throws Exception {

	    // 1. Create a dummy request object (Method, TYPE, Body, URL)
		 MockHttpServletRequestBuilder request = MockMvcRequestBuilders
		            .get("http://localhost:9999/v1/api/student/all");
		 
	    // 2. Send the request and get the response
		 MvcResult result = mockMvc.perform(request).andReturn();
		 
	    // 3. Retrieve the data from the response object to perform testing
		 MockHttpServletResponse response = result.getResponse();
	    

	    // 4. Use JUnit to test whether the test case passes or fails
		 assertEquals(HttpStatus.OK.value(), response.getStatus());
		 String output = response.getContentAsString();
		 System.out.println(output);
	   
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------			

	
	@Test
	@Order(4)
	@DisplayName("Modify Student Test")
	public void modifyStudentTest() throws Exception {
	    String body = "{\n"
	            + "        \"stdId\": 2,\n"
	            + "        \"stdName\": \"Divya\",\n"
	            + "        \"stdGen\": \"Female\",\n"
	            + "        \"stdCourse\": \"Mechanical Engineering\",\n"
	            + "        \"stdAddr\": \"456 Elm St, City, Country\"\n"
	            + "    }";

	    // 1. Create a dummy request object (Method, TYPE, Body, URL)
	    MockHttpServletRequestBuilder request = MockMvcRequestBuilders
	            .put("http://localhost:9999/v1/api/student/modify") // Ensure this endpoint is correct for PUT
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(body);

	    // 2. Send the request and get the response
	    MvcResult result = mockMvc.perform(request).andReturn();

	    // 3. Retrieve the data from the response object to perform testing
	    MockHttpServletResponse response = result.getResponse();

	    // 4. Use JUnit to test whether the test case passes or fails
	    assertEquals(HttpStatus.OK.value(), response.getStatus());

	    // Output the response body to verify the modification details
	    String output = response.getContentAsString();
	    System.out.println("Response Body: " + output);

	    
	   
	}



	

}

 