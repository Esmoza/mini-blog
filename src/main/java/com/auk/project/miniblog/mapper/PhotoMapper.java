package com.auk.project.miniblog.mapper;

import com.auk.project.miniblog.dto.ArticlesDto;
import com.auk.project.miniblog.dto.PhotoDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.entity.Photo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhotoMapper implements  CustomMapper<Photo, PhotoDto> {

    @Override
    public PhotoDto mapToDto(Photo entity) {
        PhotoDto photoDto=new PhotoDto();
        BeanUtils.copyProperties(entity,photoDto);
        return photoDto;
    }

    @Override
    public Photo mapToEntity(PhotoDto photoDto) {
        Photo photo=new Photo();
       BeanUtils.copyProperties(photoDto,photo);
        return photo;
    }

    public List<PhotoDto> mapToDtoList(Iterable<Photo> photos){
        List<PhotoDto> photoDtos=new ArrayList<>();
        for(Photo photo : photos){
            PhotoDto photoDto=new PhotoDto();
            photoDto.setPath(photo.getPath());
            photoDto.setFileName(photo.getFileName());
            photoDto.setComments(photo.getComments());
            photoDtos.add(photoDto);
        }
        return photoDtos;

    }
}
