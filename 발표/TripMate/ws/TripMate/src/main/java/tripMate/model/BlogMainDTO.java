package tripMate.model;

import java.util.ArrayList;
import java.util.List;

public class BlogMainDTO {

	String id;
	String title;
	String content;
	String regDate;
	List<String> imageList;
	String userCode;
	
	public BlogMainDTO() {
	    this.imageList = new ArrayList<>();  // 빈 리스트로 초기화
	}
	
	public void addImage(String imagePath) {
	    if (this.imageList == null) {
	        this.imageList = new ArrayList<>();
	    }
	    this.imageList.add(imagePath);
	}
	

	public BlogMainDTO(String id, String title, String content, String regDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public BlogMainDTO(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public BlogMainDTO(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

	public BlogMainDTO(String id) {
		this.id = id;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	 public List<String> getImageList() {
			return imageList;
		}

		public void setImageList(List<String> imageList) {
			this.imageList = imageList;
		}

		// 썸네일 경로 반환
		public String getThumbnailPath() {
		    if (imageList != null && !imageList.isEmpty()) {
		        return "upload/" + imageList.get(0);
		    } else {
		        return "upload/default.png";
		    }
		}
	    
	    

	public String getUserCode() {
			return userCode;
		}

	@Override
	public String toString() {
		return "BlogMainDTO [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + "]";
	}
}