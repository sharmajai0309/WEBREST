package Skills.JunitWitMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Skills.JunitWitMockito.repo.Repository;
import Skills.JunitWitMockito.service.Service;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@Mock
	Repository repo;

	@InjectMocks
	Service s;

	@Test
	public void getDataByLenTest() {
		//Give mocking implementation when the code is not ready
		try {
			when(repo.getData()).thenReturn(
					Arrays.asList("sachin","saurav","dravid","dhoni","kohli","yuvi"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Test your code
		int expectedSize =3;
		List<String> actual = s.getDataByLen();
		
		//checking the comparison is made on the actual object
		assertNotNull(actual);
		
		
		int actualSize = s.getDataByLen().size();
		assertEquals(expectedSize, actualSize);
		
	}
	
	
	@Test
	public void ThrowException() {
		try {
			
			
			when(repo.getData()).thenThrow(new SQLException("sql"));
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String>actual = s.getDataByLen();
		assertEquals(0, actual.size());
	}

}

