public class Player {
    static final int BASE_SPEED = 4;
    
    int x;
	int y;
	int speed;
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        speed = BASE_SPEED;
    }

    public void UpMove() {
        this.y -= speed;
    }
    public void DownMove() {
        this.y += speed;
    }
    public void LeftMove() {
        this.x -= speed;
    }
    public void RightMove() {
        this.x += speed;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}
