package com.auk.project.miniblog.service;

import com.auk.project.miniblog.dto.ArticlesDto;
import com.auk.project.miniblog.dto.PhotoDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.entity.Photo;
import com.auk.project.miniblog.mapper.PhotoMapper;
import com.auk.project.miniblog.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class PhotoService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoMapper photoMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void savePhotoImage(PhotoDto photoDTO, MultipartFile imageFile) throws Exception {
        // this gets us to src/main/resources without knowing the full path (hardcoding)
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        photoDTO.setPath(absolutePath + "/src/main/resources/static/photos/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photoDTO.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);
        kafkaTemplate.send("photoIn", path.normalize().toString());
    }

    /* (non-Javadoc)
     * @see com.plantplaces.dao.IPhotoDAO#save(com.plantplaces.dto.PhotoDTO)
     */

    public void save(PhotoDto photoDTO) {
        PhotoDto photoDto=new PhotoDto();
        photoDto.setFileName(photoDTO.getFileName());
        photoDto.setPath(photoDTO.getPath());
        Photo photo=photoMapper.mapToEntity(photoDTO);
        photoRepository.save(photo);
    }

    public List<PhotoDto> findAll(){
        return photoMapper.mapToDtoList(photoRepository.findAll());
    }

    public Photo findByPost(ArticlesDto article){
        Photo photo=findPhotoByArticleId(article.getId());

        return photo;
    }

    public Photo findPhotoByArticleId(Long articleId){
        List<Photo> photos = photoRepository.findAll();
        Photo photo=new Photo();
        for(Photo item:photos){
            if(item.getArtcicleId() == articleId){
                photo=item;
            }
        }

        return photo;
    }

}
