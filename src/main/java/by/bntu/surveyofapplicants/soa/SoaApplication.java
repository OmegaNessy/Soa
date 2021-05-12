package by.bntu.surveyofapplicants.soa;

import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.util.IdentityChecker;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@SpringBootApplication
public class SoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();


		Converter<String, Float> toStringFloat = new AbstractConverter<String, Float>() {
			@Override
			protected Float convert(String source) {
				return Float.valueOf(source);
			}
		};
		Converter<Float,String> toFloatString = new AbstractConverter<Float, String>() {
			@Override
			protected String convert(Float aFloat) {
				return String.valueOf(aFloat);
			}
		};
		mapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true)
				.setFieldAccessLevel(PRIVATE);
		mapper.createTypeMap(Object.class,Object.class);
		mapper.addConverter(toStringFloat);
		mapper.addConverter(toFloatString);
		mapper.createTypeMap(TestResult.class, ResultDto.class);
		return mapper;
	}

	@Bean
	public IdentityChecker identityChecker(){
		return new IdentityChecker();
	}
}
