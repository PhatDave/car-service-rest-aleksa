package hr.neos.carservicerestaleksa.mapper;

import hr.neos.carservicerestaleksa.dto.*;
import hr.neos.carservicerestaleksa.entity.*;
import org.mapstruct.*;

@Mapper(
        uses = {
                AddressMapper.class,
        },
        builder = @Builder(disableBuilder = true)
)
public interface UserMapper {
    //@Mapping(source = "addressDto", target = "address")
    User toEntity(UserPostDto dto);
    //userPostDtoToDto

    //@Mapping(source = "address", target = "addressDto")
    UserPostDto toDto(User user);
    //userToUserPostDto
}
