package tripMate.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tripMate.model.BlogImgDTO;
import tripMate.model.BlogMainDTO;
import tripMate.model.BlogPost;


public class BlogMainDAO {
	 String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	    String user = "scott";
	    String password = "tiger";

    // 데이터베이스 연결 매서드
    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // 모든 블로그 리스트 조회
    public ArrayList<BlogMainDTO> selectAll() {
        ArrayList<BlogMainDTO> list = new ArrayList<>();
        String sql = "SELECT b.blog_id, b.title, b.content, b.regdate, i.image_url " +
                     "FROM blog_upload_tbl b LEFT JOIN image_info_tbl i " +
                     "ON b.blog_id = i.blog_id " +
                     "ORDER BY b.blog_id DESC";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            String currentId = null;
            BlogMainDTO currentDto = null;

            while (rs.next()) {
                String id = rs.getString("blog_id");

                // 새 블로그 아이디면 새 DTO 생성
                if (!id.equals(currentId)) {
                    currentId = id;
                    currentDto = new BlogMainDTO(
                            id,
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getString("regdate")
                    );
                    currentDto.setImageList(new ArrayList<>());
                    list.add(currentDto);
                }

                // 이미지 URL 추가
                String imgUrl = rs.getString("image_url");
                if (imgUrl != null && currentDto != null) {
                    currentDto.getImageList().add(imgUrl);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 특정 블로그 조회
    public BlogMainDTO oneSelect(String id) {
        String sql = "SELECT * FROM blog_upload_tbl WHERE blog_id = ?";
        BlogMainDTO bm = null;

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, id);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    bm = new BlogMainDTO(
                        rs.getString("blog_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("regdate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bm;
    }

    // 블로그 등록
 // Blog 등록 후 blog_id 반환하는 메서드
    public String insertAndReturnId(BlogMainDTO dto) {
        String blogId = null;
        String sql = "INSERT INTO blog_upload_tbl (title, content, user_code) \n"
        		+ "VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getUserCode());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                // 마지막 blog_id 다시 조회
                blogId = getLastInsertedBlogId(dto.getUserCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return blogId;
    }
    
    public String getLastInsertedBlogId(String userCode) {
        String sql = "SELECT blog_id FROM (SELECT blog_id FROM blog_upload_tbl WHERE user_code = ? ORDER BY blog_id DESC) WHERE ROWNUM = 1";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userCode);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("blog_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 이미지 등록
    public void insertImg(BlogImgDTO dto) {
        String sql = "INSERT INTO image_info_tbl (image_id, image_url, blog_id) VALUES (image_seq.NEXTVAL, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dto.getImageUrl());
            pstmt.setString(2, dto.getBlogId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 최신 블로그 조회
    public BlogMainDTO selectLastOne() {
        String sql = "SELECT * FROM (SELECT * FROM blog_upload_tbl ORDER BY blog_id DESC) WHERE ROWNUM = 1";
        BlogMainDTO dto = null;

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                dto = new BlogMainDTO(
                    rs.getString("blog_id"),
                    rs.getString("blog_title"),
                    rs.getString("blog_content"),
                    rs.getString("blog_regdate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    // 블로그 업데이트
    public void update(String id, String title, String content) {
        String sql = "UPDATE blog_upload_tbl SET title = ?, content = ? WHERE blog_id = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, title);
            pst.setString(2, content);
            pst.setString(3, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 이미지 삭제
    public void deleteImageByFileName(String blogId, String fileName) {
        String sql = "DELETE FROM image_info_tbl WHERE blog_id = ? AND image_url = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, blogId);
            pst.setString(2, fileName);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public BlogMainDTO selectByIdWithImage(String blogId) {
        BlogMainDTO blog = null;
        String sql = "SELECT b.blog_id, b.title, b.content, b.regdate, i.image_url " +
                     "FROM blog_upload_tbl b " +
                     "LEFT JOIN image_info_tbl i ON b.blog_id = i.blog_id " +
                     "WHERE b.blog_id = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, blogId);  // blogId를 파라미터로 전달

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // BlogMainDTO 객체 생성
                    blog = new BlogMainDTO(
                            rs.getString("blog_id"),
                            rs.getString("title"),
                            rs.getString("content"),
                            rs.getString("regdate")
                    );

                    // 이미지 리스트 추가
                    blog.setImageList(new ArrayList<>());
                    do {
                        String imageUrl = rs.getString("image_url");
                        if (imageUrl != null) {
                            blog.getImageList().add(imageUrl);  // 이미지 URL 추가
                        }
                    } while (rs.next());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blog;
    }
    
 // BlogMainDAO - getUserBlogs 메서드 추가
    public ArrayList<BlogMainDTO> getUserBlogs(String userCode) {
        ArrayList<BlogMainDTO> list = new ArrayList<>();
        String sql = "SELECT b.blog_id, b.title, b.content, b.regdate, i.image_url " +
                     "FROM blog_upload_tbl b LEFT JOIN image_info_tbl i " +
                     "ON b.blog_id = i.blog_id " +
                     "WHERE b.user_code = ? " +
                     "ORDER BY b.blog_id DESC";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, userCode);  // 사용자 코드를 파라미터로 전달

            try (ResultSet rs = pst.executeQuery()) {
                String currentId = null;
                BlogMainDTO currentDto = null;

                while (rs.next()) {
                    String id = rs.getString("blog_id");

                    // 첫 번째 블로그 또는 새 블로그이면 새 DTO 생성
                    if (currentId == null || !id.equals(currentId)) {
                        currentId = id;
                        currentDto = new BlogMainDTO(
                                id,
                                rs.getString("title"),
                                rs.getString("content"),
                                rs.getString("regdate")
                        );
                        currentDto.setImageList(new ArrayList<>());
                        list.add(currentDto);
                    }

                    // 이미지 URL 추가 (null 체크)
                    String imgUrl = rs.getString("image_url");
                    if (imgUrl != null) {
                        currentDto.getImageList().add(imgUrl);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<BlogMainDTO> getAllBlogsWithImages() {
        List<BlogMainDTO> blogList = new ArrayList<>();

        String blogSql = "SELECT blog_id, title, content, regdate FROM blog_upload_tbl";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(blogSql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BlogMainDTO dto = new BlogMainDTO();
                dto.setId(rs.getString("blog_id"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setRegDate(rs.getString("regdate")); // regDate가 String이면 그대로

                // 블로그에 해당하는 이미지 리스트 조회
                String imgSql = "SELECT image_url FROM image_info_tbl WHERE blog_id = ?";
                try (PreparedStatement imgPstmt = conn.prepareStatement(imgSql)) {
                    imgPstmt.setString(1, dto.getId());
                    try (ResultSet imgRs = imgPstmt.executeQuery()) {
                        List<String> imgList = new ArrayList<>();
                        while (imgRs.next()) {
                            imgList.add("/upload/" + imgRs.getString("image_url")); // 경로 포함
                        }
                        dto.setImageList(imgList);
                    }
                }

                blogList.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blogList;
    }
    
    
    
}