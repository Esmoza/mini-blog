package com.auk.project.miniblog.mapper;

import com.auk.project.miniblog.entity.User;

import java.util.Optional;

public interface CustomMapper<Modeli,ObjektiDto>{

    ObjektiDto mapToDto(Modeli entity);
    Modeli mapToEntity(ObjektiDto dto);
}
