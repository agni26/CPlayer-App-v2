package cplayer.recommended.app.model;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

public class RecommendedTests {

	private Recommended recommended;

	@Before
	public void setUp() {
		recommended = new Recommended();
		recommended.setPid(1234);
		recommended.setName("Sachin");
		recommended.setFullName("Sachin Tendulkar");
		recommended.setCurrentAge("42 years");
		recommended.setCountry("India");
		recommended.setPlayingRole("Opener");
		recommended.setMajorTeams("India, Mumbai Indians");
		recommended.setImageURL("sampleimage.jpeg");
	}

	@Test
	public void test() {
		new BeanTester().testBean(Recommended.class);
	}
}