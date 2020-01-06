package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.dto.ArticlesDto;
import com.auk.project.miniblog.dto.CategoryDto;
import com.auk.project.miniblog.dto.PhotoDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.entity.Photo;
import com.auk.project.miniblog.mapper.ArticleMapper;
import com.auk.project.miniblog.repository.ArticleRepository;
import com.auk.project.miniblog.service.ArticleService;
import com.auk.project.miniblog.service.CategoryService;
import com.auk.project.miniblog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/blog/")
public class ArticleController {
    @Autowired
    private ArticleRepository article;

    @Autowired
    private ArticleService articleService;

    @Autowired
    public CategoryService categoryService;

    @Autowired
    public PhotoService photoService;
    @Autowired
    public ArticleMapper articleMapper;

    @GetMapping("form")
    public String showArticleForm(Article articles, Model model, Category category){
        List<CategoryDto> categories= categoryService.findAll();
        model.addAttribute("categories",categories);
        return "add-articles";
    }

    @GetMapping("list")
    public String findAll(Model model) {
        model.addAttribute("articles", articleService.findAll());

        return "show-articles";
    }

   @GetMapping("post")
    public String showPost(Model model) {
        List<ArticlesDto> articlesDtos=articleService.findAll();
        for(ArticlesDto articleDto: articlesDtos){
            Photo photo = photoService.findPhotoByArticleId(articleDto.getId());
            articleDto.setPath(photo.getFileName());
        }

        model.addAttribute("articles", articlesDtos);

        return "posts";
    }

    @GetMapping("detail/{slug}")
    public String showDetails(@PathVariable("slug") String slug, Model model,Article article) {
        ArticlesDto article1=articleService.find(slug);
        model.addAttribute("articles", article1);
        model.addAttribute("photo", photoService.findByPost(articleMapper.mapToEntity(article1)));
        return "show-details";
    }

    @PostMapping("addArticles")
   public ModelAndView saveArticle(@RequestParam("imageFile")MultipartFile imageFile, ArticlesDto articlesDto)throws Exception{
        ModelAndView modelAndView=new ModelAndView();
        Article article=null;
        try{
          article=articleService.save(articlesDto);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Unable to save");
            modelAndView.setViewName("error");
            return modelAndView;
        }
        PhotoDto photoDto=new PhotoDto();
        photoDto.setFileName(imageFile.getOriginalFilename());
        photoDto.setPath("/photos/");
        photoDto.setArtcicleId(article.getId());
        photoService.save(photoDto);

        modelAndView.setViewName("redirect:/blog/post");

        try{
            photoService.savePhotoImage(photoDto,imageFile);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error saving photo");
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.addObject("photoDto",photoDto);
        modelAndView.addObject("articleDto", articlesDto);
        return modelAndView;
    }


}
