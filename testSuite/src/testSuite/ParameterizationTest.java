package testSuite;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class ParameterizationTest {
	
	public  String username;
	public String password;
	public int pin;
	
	public ParameterizationTest(String username, String password, int pin){
		this.username = username;
		this.password = password;
		this.pin = pin;
	}
	@Parameters
	public static Collection<Object[]> getData(){
		Object[][] data = new Object[2][3];
		data[0][0]="test1";
		data[0][1]="pass1";
		data[0][2]= 9000;
		
		data[1][0]="test1";
		data[1][1]="pass1";
		data[1][2]= 9000;
		
		return Arrays.asList(data);
		
		
				}
	
	@Test
	public void testLogin(){
		System.out.println("testing login"+username+" "+password+" "+pin+" ");
		
	}

}
