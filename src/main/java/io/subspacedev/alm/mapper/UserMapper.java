package io.subspacedev.alm.mapper;

import io.subspacedev.alm.dto.UserDto;
import io.subspacedev.alm.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
