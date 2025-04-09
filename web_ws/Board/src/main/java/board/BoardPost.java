package board;  

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardPost {
    private static int count = 1; 

    int postId;               
    String title;
    String content;
    String writer;
    String writeTime;     

    public BoardPost(String title, String content, String writer) {
        this.postId = count++; 
        this.title = title;
        this.content = content;
        this.writer = writer;

        LocalDateTime now = LocalDateTime.now();
        this.writeTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd a HH:mm:ss"));
    }

    public int getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public String getWriteTime() {
        return writeTime;
    }
}
