<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그 등록</title>
<style>
    .wrap {
        width: 1000px;
        margin: 30px auto;
        padding: 20px;
        background-color: #f9f9f9;
        border-radius: 10px;
        display: flex;
        justify-content: space-between;
        border: 1px solid #ddd;
        box-sizing: border-box;
    }

    .text_wrap {
        width: 500px;
        padding: 20px;
    }

    .title {
        width: 100%;
        height: 50px;
        padding: 10px;
        font-size: 18px;
        margin-top: 10px;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-sizing: border-box;
    }

    .content_tx {
        width: 100%;
        height: 250px;
        padding: 10px;
        font-size: 16px;
        margin-top: 10px;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-sizing: border-box;
        resize: vertical;
    }

    .image_wrap {
        width: 350px;
        padding: 20px;
        border: 1px solid #ddd;
        background-color: #fff;
        border-radius: 10px;
    }

    .image_wrap img {
        width: 100%;
        height: auto;
        object-fit: cover;
        border-radius: 8px;
    }

    .img_box {
        width: 100%;
        height: 250px;
        margin-top: 10px;
        overflow: hidden;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .btn-upload {
        width: 150px;
        height: 40px;
        background: #007bff;
        color: white;
        border-radius: 10px;
        font-weight: 500;
        cursor: pointer;
        text-align: center;
        line-height: 40px;
        margin-top: 20px;
        border: none;
        transition: background-color 0.3s;
    }

    .btn-upload:hover {
        background: #0056b3;
    }

    #file {
        display: none;
    }

    .submit_btn {
        width: 150px;
        height: 50px;
        background: #28a745;
        color: white;
        border: none;
        border-radius: 25px;
        font-size: 18px;
        cursor: pointer;
        margin-top: 20px;
        margin-right: 10px;
        transition: background-color 0.3s;
    }

    .submit_btn:hover {
        background: #218838;
    }

    .cancel_btn {
        width: 150px;
        height: 50px;
        background: #6c757d;
        color: white;
        border: none;
        border-radius: 25px;
        font-size: 18px;
        cursor: pointer;
        margin-top: 20px;
        transition: background-color 0.3s;
    }

    .cancel_btn:hover {
        background: #5a6268;
    }
</style>
</head>
<body>

<form action="${pageContext.request.contextPath}/blogreg" method="post" enctype="multipart/form-data">
    <div class="wrap">
        <!-- 이미지 업로드 영역 -->
        <div class="image_wrap">
            <label for="file" class="btn-upload">사진 추가</label>
            <input type="file" name="file" id="file" accept="image/*">
            <div class="img_box" id="imbox"></div>
        </div>

        <!-- 텍스트 입력 영역 -->
        <div class="text_wrap">
            <input type="text" class="title" name="blog_title" placeholder="제목 입력">
            <textarea class="content_tx" name="blog_content" placeholder="내용 입력"></textarea>
            <div style="display: flex; gap: 10px;">
                <button class="submit_btn" type="submit">등록하기</button>
                <button type="button" class="cancel_btn" onclick="location.href='${pageContext.request.contextPath}/mainblog'">취소</button>
            </div>
        </div>
    </div>
</form>

<script>
// 이미지 미리보기
const imageInput = document.getElementById('file');
const imageContainer = document.getElementById('imbox');

imageInput.addEventListener('change', function (event) {
    const selectedFile = event.target.files[0];
    if (!selectedFile) return;

    imageContainer.innerHTML = ""; // 기존 이미지 삭제

    const reader = new FileReader();
    reader.onload = function () {
        const imageElement = document.createElement('img');
        imageElement.src = reader.result;
        imageContainer.appendChild(imageElement);
    };
    reader.readAsDataURL(selectedFile);
});
</script>

</body>
</html>
