package my.examples.blog.controller;

import lombok.RequiredArgsConstructor;
import my.examples.blog.domain.Category;
import my.examples.blog.domain.ImageFile;
import my.examples.blog.domain.Post;
import my.examples.blog.security.BlogSecurityUser;
import my.examples.blog.service.CategoryService;
import my.examples.blog.service.PostService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final CategoryService categoryService;
    private final PostService postService;

    @GetMapping("/write")
    public String writeform(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "posts/writeform";
    }

    @PostMapping("write")
    public String write(
            @RequestParam(name = "title")String title,
            @RequestParam(name = " content")String content,
            @RequestParam(name  = "categoryId") Long categoryId,
            @RequestParam(name = "image") MultipartFile[] images
    ) {
        Assert.hasText(title, "제목을 입력하세요");
        Assert.hasText(content, "내용을 입력하세요");

        BlogSecurityUser securityUser =
                (BlogSecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = new Post();
        post.setContent(content);
        post.setTitle(title);

        if (images != null && images.length > 0) {
            for (MultipartFile image : images) {
                ImageFile imageFile = new ImageFile();
                imageFile.setLength(image.getSize());
                imageFile.setMimeType(image.getContentType());
                imageFile.setName(image.getOriginalFilename());
                String saveFileName = saveFile(image);

                imageFile.setSaveFileName(saveFileName); // save되는 파일명
                post.addImageFile(imageFile);

            }
        }

        postService.addPost(post, categoryId, securityUser.getId());

        return "redirect:/main";
    }
    private String saveFile(MultipartFile image){
        String dir = "/tmp/";
        Calendar calendar = Calendar.getInstance();
        dir = dir + calendar.get(Calendar.YEAR);
        dir = dir + "/";
        dir = dir + (calendar.get(Calendar.MONTH) + 1);
        dir = dir + "/";
        dir = dir + calendar.get(Calendar.DAY_OF_MONTH);
        dir = dir + "/";
        File dirFile = new File(dir);
        dirFile.mkdirs(); // 디렉토리가 없을 경우 만든다. 퍼미션이 없으면 생성안될 수 있다.
        dir = dir + UUID.randomUUID().toString();

        try(FileOutputStream fos = new FileOutputStream(dir);
            InputStream in = image.getInputStream()
        ){
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){
                fos.write(buffer, 0, readCount);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return dir;
    }
}
