<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그 수정</title>
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

    .img_box {
        width: 100%;
        display: flex;
        flex-direction: column;
        gap: 10px;
        margin-top: 10px;
    }

    .img_box div {
        display: flex;
        align-items: center;
        gap: 10px;
    }

    .img_box img {
        width: 100px;
        height: 100px;
        object-fit: cover;
        border-radius: 8px;
        border: 1px solid #ccc;
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
        display: inline-block;
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
        margin-top: 30px;
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
        margin-top: 10px;
        margin-left: 10px;
        transition: background-color 0.3s;
    }

    .cancel_btn:hover {
        background: #5a6268;
    }
</style>
</head>
<body>

<form action="${pageContext.request.contextPath}/update" method="post" enctype="multipart/form-data">
    <div class="wrap">
        <!-- 이미지 영역 -->
        <div class="image_wrap">
            <div class="img_box">
                <c:forEach var="img" items="${blog.imageList}">
                    <div>
                        <img src="/blogTest/upload/${img}" alt="이미지">
                        <label>
                            <input type="checkbox" name="deleteImage" value="${img}"> 삭제
                        </label>
                    </div>
                </c:forEach>
            </div>

            <label for="file" class="btn-upload">새 이미지 추가</label>
            <input type="file" name="newImages" id="file" multiple>
            <div class="img_box" id="imbox"></div>
        </div>

        <!-- 텍스트 입력 -->
        <div class="text_wrap">
            <input type="hidden" name="id" value="${blog.id}">
            <input type="text" class="title" name="title" value="${blog.title}" placeholder="제목 입력">
            <textarea class="content_tx" name="content" placeholder="내용 입력">${blog.content}</textarea>
            <button type="submit" class="submit_btn">수정완료</button>
            <button type="button" class="cancel_btn" onclick="history.back()">취소</button>
        </div>
    </div>
</form>

<script>
// 이미지 미리보기
const imageInput = document.getElementById('file');
const imageContainer = document.getElementById('imbox');

imageInput.addEventListener('change', function (event) {
    const files = event.target.files;
    if (!files.length) return;

    imageContainer.innerHTML = ""; // 기존 미리보기 초기화

    Array.from(files).forEach(file => {
        const reader = new FileReader();
        reader.onload = function () {
            const img = document.createElement('img');
            img.src = reader.result;
            img.style.width = '100px';
            img.style.height = '100px';
            img.style.objectFit = 'cover';
            img.style.borderRadius = '8px';
            img.style.border = '1px solid #ccc';
            imageContainer.appendChild(img);
        };
        reader.readAsDataURL(file);
    });
});
</script>

</body>
</html>
