package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.ClientRunner;
import other.IdGernerateServiceImpl;

public class IdGernerateTester {

	ClientRunner clientRunner =  new ClientRunner();
	@Test
	public void testgreID(){
		String  a = IdGernerateServiceImpl.gernerateId();
		assertEquals(false,a=="134");
	}
}
