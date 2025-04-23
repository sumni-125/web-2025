package tripMate.service;

import java.util.ArrayList;
import java.util.List;

import tripMate.dao.BlogMainDAO;
import tripMate.model.BlogImgDTO;
import tripMate.model.BlogMainDTO;


public class BlogMainService {

    BlogMainDAO dao = new BlogMainDAO();

    // 전체 블로그 글 목록을 가져오는 매서드
    public ArrayList<BlogMainDTO> getInfo() {
        return dao.selectAll();
    }

    
    // 블로그 글과 이미지를 등록하는 역할을 하는 매서드
    public void register(BlogMainDTO mDto, BlogImgDTO iDto) {
        dao.insertAndReturnId(mDto); // 블로그 글 저장
        String blogId = dao.getLastInsertedBlogId(mDto.getUserCode()); // blog_id 조회
        if (blogId != null) {
            iDto.setBlogId(blogId);
            dao.insertImg(iDto); // 이미지 저장
        } else {
            System.out.println("ERROR: Blog ID 조회 실패");
        }
    }
    
    // 제목, 내용, 이미지 수정 메서드 (블로그 글을 수정하는 기능을 수행)
    public void modifyMember(String id, String title, String content, List<String> newImages, List<String> imagesToDelete) {
        // 제목, 내용 수정
        dao.update(id, title, content);

        // 삭제할 이미지가 있으면 삭제
        if (imagesToDelete != null) {
            for (String img : imagesToDelete) {
                dao.deleteImageByFileName(id, img);
            }
        }

        // 새 이미지를 추가
        if (newImages != null) {
            for (String img : newImages) {
            	BlogImgDTO imgDto = new BlogImgDTO(img);
            	imgDto.setBlogId(id);  // blogId 직접 설정해줘야 함
            	dao.insertImg(imgDto);
            }
        }
    }


    // 특정 blog id로 정보를 가져오는 메서드
    public BlogMainDTO getBlogById(String id) {
        return dao.selectByIdWithImage(id);
    }
}
