package player;

import java.sql.Date;

public class Player {
    String playerId;
    String playerName;
    int playerLevel;
    int playerGold;
    int playerStr;
    int playerDex;
    int playerInt;
    Date createdDate;

    public Player() {
    	
    }

	public Player(String playerId, String playerName, int playerLevel, int playerGold, int playerStr, int playerDex,
			int playerInt, Date createdDate) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerLevel = playerLevel;
		this.playerGold = playerGold;
		this.playerStr = playerStr;
		this.playerDex = playerDex;
		this.playerInt = playerInt;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", playerLevel=" + playerLevel
				+ ", playerGold=" + playerGold + ", playerStr=" + playerStr + ", playerDex=" + playerDex
				+ ", playerInt=" + playerInt + ", createdDate=" + createdDate + "]";
	}

	public String getPlayerId() {
		return playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getPlayerLevel() {
		return playerLevel;
	}

	public int getPlayerGold() {
		return playerGold;
	}

	public int getPlayerStr() {
		return playerStr;
	}

	public int getPlayerDex() {
		return playerDex;
	}

	public int getPlayerInt() {
		return playerInt;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
    
    
    
}
