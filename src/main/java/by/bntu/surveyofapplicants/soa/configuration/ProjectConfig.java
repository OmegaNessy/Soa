package by.bntu.surveyofapplicants.soa.configuration;

import by.bntu.surveyofapplicants.soa.dto.ResultDto;
import by.bntu.surveyofapplicants.soa.entity.TestResult;
import by.bntu.surveyofapplicants.soa.util.IdentityChecker;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class ProjectConfig {
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

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
