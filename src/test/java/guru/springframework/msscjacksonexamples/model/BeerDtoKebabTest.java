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
@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest {
	
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
		String jsonString = "{\"id\":\"b99efef6-6963-4ac7-b1cb-5dd051cd61f1\",\"beer-name\":\"Beer Name 1\",\"beer-style\":\"Beer Style 1\",\"upc\":1234567,\"price\":10,\"created-date\":\"2020-09-04T22:30:47.5167036+05:30\",\"last-updated-date\":\"2020-09-04T22:30:47.5167036+05:30\"}";
		
		BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);
		log.info("beerDto="+beerDto);
	}
}
