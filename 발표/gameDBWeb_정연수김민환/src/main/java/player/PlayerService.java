package player;

import java.util.ArrayList;

public class PlayerService {
    
    private PlayerDAO dao = new PlayerDAO();

    // 모든 플레이어 조회
    public ArrayList<Player> getPlayerListAll() {
        return dao.selectAll();
    }
    
    // 키워드로 플레이어 검색
    public ArrayList<Player> searchPlayerByKeyword(String keyword) {
        return dao.selectByKeyword(keyword);
    }
    
    // ID로 플레이어 조회
    public Player getPlayerById(String playerId) {
        return dao.selectById(playerId);
    }
    
    // 플레이어 삭제
    public void deletePlayerById(String playerId) {
        dao.deletePlayerById(playerId);
    }
    
    // 플레이어 정보 수정
    public void updatePlayer(Player player) {
        dao.updatePlayer(player);
    }
}