package tripMate.model;

import java.sql.Date;
import java.util.List;

public class BlogPost {

    private String blogId;
    private String title;
    private String content;
    private Date regdate;
    private String locationId;
    private String userCode;
    List<String> imageList;
    

    public BlogPost() {
    }

    public BlogPost(String blogId, String title, String content, Date regdate, String locationId, String userCode) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.regdate = regdate;
        this.locationId = locationId;
        this.userCode = userCode;
    }
    
    

    // Getters and Setters
    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    
    public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public String getThumbnailPath() {
	    if (imageList != null && !imageList.isEmpty()) {
	        return "upload/" + imageList.get(0);
	    } else {
	        return "upload/default.png";
	    }
	}
    
    @Override
    public String toString() {
        return "BlogPost [blogId=" + blogId + ", title=" + title + ", content=" + content +
                ", regdate=" + regdate + ", locationId=" + locationId + ", userCode=" + userCode + "]";
    }
}