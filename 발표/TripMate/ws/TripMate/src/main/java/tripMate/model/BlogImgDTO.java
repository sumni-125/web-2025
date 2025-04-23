package tripMate.model;

public class BlogImgDTO {

    private String imageId;  // 이미지 ID
    private String imageUrl; // 이미지 URL
    private String blogId;   // 블로그 ID

    // 생성자
    public BlogImgDTO(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // 기본 생성자
    public BlogImgDTO() {}

    // Getter, Setter
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}