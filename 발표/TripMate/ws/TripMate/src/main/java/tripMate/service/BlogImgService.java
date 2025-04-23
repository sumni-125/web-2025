package tripMate.service;

import java.util.ArrayList;

import tripMate.dao.BlogImgDAO;
import tripMate.model.BlogImgDTO;

public class BlogImgService {

	
	BlogImgDAO dao = new BlogImgDAO();

    // 이미지 목록 가져오기
    public ArrayList<BlogImgDTO> getImgList() {
        ArrayList<BlogImgDTO> list = dao.selectAll();  // DAO에서 이미지 목록 가져오기
        return list;
    }
}
