package by.bntu.surveyofapplicants.soa.mapper;

import by.bntu.surveyofapplicants.soa.dto.UserDto;
import by.bntu.surveyofapplicants.soa.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    ModelMapper mapper;

    public User toEntity (UserDto dto){
        return mapper.map(dto,User.class);
    }

    public UserDto toDto (User entity){
        return mapper.map(entity,UserDto.class);
    }
}
