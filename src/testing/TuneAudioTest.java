package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import text2speechAPI.FakeFreeTTSAdapter;
import text2speechAPI.TextToSpeechAPI;

class TuneAudioTest {
	private TextToSpeechAPI api;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Tune Audio Settings..");
	}

	@BeforeEach
	public void init() {
		api = new FakeFreeTTSAdapter();
	}
	
	@Test
	void test() {
		api.setPitch((float) 0.5);
		api.setRate(60);
		api.setVolume(40);
		assertEquals((float)0.5,api.getPitch());
		assertEquals((float)60,api.getRate());
		assertEquals((float)40,api.getVolume());
	}

}
