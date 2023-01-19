package hr.neos.carservicerestaleksa.mapper;

import hr.neos.carservicerestaleksa.dto.*;
import hr.neos.carservicerestaleksa.entity.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        uses = {
                AddressMapper.class,
        },
        builder = @Builder(disableBuilder = true)
)
public interface UserMapper {
    //@Mapping(source = "addressDto", target = "address")
    User toEntity(UserPostDto dto);

    //@Mapping(source = "address", target = "addressDto")
    UserPostDto toDto(User user);

    User to_entity(UserGetDto dto);

    UserGetDto to_dto(User user);

    List<UserGetDto> manyToDto(List<User> entities);
}
