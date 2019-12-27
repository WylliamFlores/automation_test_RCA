package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.BuyTests;

@RunWith(Suite.class)
@SuiteClasses({ 
	BuyTests.class, })

public class SuiteTest {

}