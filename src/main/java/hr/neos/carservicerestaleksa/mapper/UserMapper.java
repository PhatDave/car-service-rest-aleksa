package hr.neos.carservicerestaleksa.mapper;

import hr.neos.carservicerestaleksa.dto.UserGetDto;
import hr.neos.carservicerestaleksa.dto.UserPostDto;
import hr.neos.carservicerestaleksa.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

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
    UserGetDto toDto(User user);

    List<UserGetDto> manyToDto(List<User> entities);
}
