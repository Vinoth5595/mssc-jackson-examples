package guru.springframework.msscjacksonexamples.model;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void testSerializeBeerDto() throws JsonProcessingException {
		BeerDto beerDto = getBeerDto();
		
		String jsonString = objectMapper.writeValueAsString(beerDto);
		log.info("jsonString="+jsonString);
	}
	
	@Test
	public void testDeserializeBeerDto() throws JsonParseException, JsonMappingException, IOException {
		String jsonString = "{\"id\":\"1da8255c-cb4c-4580-87c4-0aebd4acbc8e\",\"beer_name\":\"Beer Name 1\",\"beer_style\":\"Beer Style 1\",\"upc\":1234567,\"price\":10,\"created_date\":\"2020-09-04T22:24:06.1038094+05:30\",\"last_updated_date\":\"2020-09-04T22:24:06.1048091+05:30\"}";
		
		BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
		log.info("beerDto="+beerDto);
	}
}
