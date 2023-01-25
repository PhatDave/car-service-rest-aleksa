package hr.neos.carservicerestaleksa.mapper;

import hr.neos.carservicerestaleksa.dto.AddressDto;
import hr.neos.carservicerestaleksa.entity.Address;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface AddressMapper {
    Address toEntity(AddressDto address);

    AddressDto toDto(Address address);
}
