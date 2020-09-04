package guru.springframework.msscjacksonexamples.model;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@JsonTest
public class BeerDtoTest extends BaseTest {

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
		String jsonString = "{\"beerName\":\"Beer Name 1\",\"beerStyle\":\"Beer Style 1\",\"upc\":1234567,\"price\":10,\"createdDate\":\"2020-09-04T23:11:06.7343194+05:30\",\"lastUpdatedDate\":\"2020-09-04T23:11:06.7343194+05:30\",\"localDate\":\"20200904\",\"id\":\"292756b0-b1d5-4fd0-914f-475792cfa2b5\"}";
		
		BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
		log.info("beerDto="+beerDto);
	}
}
