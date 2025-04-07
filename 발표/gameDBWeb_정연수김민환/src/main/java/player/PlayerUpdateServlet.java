package player;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlayerUpdate")
public class PlayerUpdateServlet extends HttpServlet {

    // GET 요청: 수정 폼 표시
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerId = req.getParameter("playerId");
        
        // 유효성 검사
        if (playerId == null || playerId.trim().isEmpty()) {
            resp.sendRedirect("playerslist");
            return;
        }
        
        // 플레이어 정보 조회
        PlayerService service = new PlayerService();
        Player player = service.getPlayerById(playerId);
        
        if (player == null) {
            resp.sendRedirect("playerslist");
            return;
        }
        
        // 플레이어 정보를 요청 속성에 저장
        req.setAttribute("player", player);
        
        // 수정 폼 JSP로 포워드
        req.getRequestDispatcher("WEB-INF/views/playerUpdateForm.jsp").forward(req, resp);
    }
    
    // POST 요청: 수정 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 파라미터 인코딩 설정
        req.setCharacterEncoding("UTF-8");
        
        try {
            // 폼에서 전송된 데이터 가져오기
            String playerId = req.getParameter("playerId");
            String playerName = req.getParameter("playerName");
            int playerLevel = Integer.parseInt(req.getParameter("playerLevel"));
            int playerGold = Integer.parseInt(req.getParameter("playerGold"));
            int playerStr = Integer.parseInt(req.getParameter("playerStr"));
            int playerDex = Integer.parseInt(req.getParameter("playerDex"));
            int playerInt = Integer.parseInt(req.getParameter("playerInt"));
            
            // 기존 플레이어 정보 조회
            PlayerService service = new PlayerService();
            Player existingPlayer = service.getPlayerById(playerId);
            
            if (existingPlayer == null) {
                resp.sendRedirect("playerslist");
                return;
            }
            
            // 수정된 정보로 플레이어 객체 생성 (createdDate는 기존 값 유지)
            Player updatedPlayer = new Player(
                playerId, playerName, playerLevel, playerGold, 
                playerStr, playerDex, playerInt, existingPlayer.getCreatedDate()
            );
            
            // 데이터베이스 업데이트
            service.updatePlayer(updatedPlayer);
            
            // 성공 메시지 설정 및 목록 페이지로 리다이렉트
            resp.sendRedirect("playerslist");
            
        } catch (NumberFormatException e) {
            // 숫자 형식 오류 처리
            req.setAttribute("errorMessage", "입력 형식이 올바르지 않습니다.");
            req.getRequestDispatcher("playerslist").forward(req, resp);
        } catch (Exception e) {
            // 기타 예외 처리
            req.setAttribute("errorMessage", "플레이어 정보 수정 중 오류가 발생했습니다: " + e.getMessage());
            req.getRequestDispatcher("playerslist").forward(req, resp);
        }
    }
}