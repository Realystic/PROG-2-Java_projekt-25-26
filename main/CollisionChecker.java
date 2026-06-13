package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        //the boundary of the entity
        int entityLeftX = entity.x + entity.solidArea.x;
        int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.y + entity.solidArea.y;
        int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;

        // in what collum they are
        int entityLeftCol = entityLeftX/gp.tileSize;
        int entityRightCol = entityRightX/gp.tileSize;
        int entityTopRow = entityTopY/gp.tileSize;
        int entityBottomRow = entityBottomY/gp.tileSize;

        int tile1, tile2;
        
        //checks if you can move in a certian direction
        //2 checks for y axis
        //up check
        if (entity.keyH.upPressed) {
            entityTopRow = (entityTopY - entity.speed)/gp.tileSize;
            tile1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tile2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            if (gp.tileM.tile[tile1].collision || gp.tileM.tile[tile2].collision) {
                entity.collisionOnY = true;
            }
            //reset for other checks
            entityTopRow = entityTopY/gp.tileSize;
        }
        //down check
        if (entity.keyH.downPressed) {
            entityBottomRow = (entityBottomY + entity.speed)/gp.tileSize;
            tile1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            tile2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if (gp.tileM.tile[tile1].collision || gp.tileM.tile[tile2].collision) {
                entity.collisionOnY = true;
            }
            //reset for other checks
            entityBottomRow = entityBottomY/gp.tileSize;
        }

        //2 checks for x axis
        //left check
        if (entity.keyH.leftPressed) {
            entityLeftCol = (entityLeftX - entity.speed)/gp.tileSize;
            tile1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tile2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            if (gp.tileM.tile[tile1].collision || gp.tileM.tile[tile2].collision) {
                entity.collisionOnX = true;
            }
            //reset for other checks
            entityLeftCol = entityLeftX/gp.tileSize;
        }
        //right check
        if (entity.keyH.rightPressed) {
            entityRightCol= (entityRightX + entity.speed)/gp.tileSize;
            tile1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            tile2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if (gp.tileM.tile[tile1].collision || gp.tileM.tile[tile2].collision) {
                entity.collisionOnX = true;
            }       
            //reset for other checks 
            entityRightCol = entityRightX/gp.tileSize;    
        }
    }
}
