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
        
        //preveri če se lahko premikaš naprej v določeno smer

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

        /*switch (entity.direction) {
            case "up":
                // predvideva kam se boš premaknil in pregleda kaj ti je v napoto
                entityTopRow = (entityTopY - entity.speed)/gp.tileSize;
                entityBottomRow = (entityBottomY + entity.speed)/gp.tileSize;
                tile1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tile2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tile3 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tile4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tile1].collision || gp.tileM.tile[tile2].collision || gp.tileM.tile[tile3].collision || gp.tileM.tile[tile4].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityTopRow = (entityTopY - entity.speed)/gp.tileSize;
                entityBottomRow = (entityBottomY + entity.speed)/gp.tileSize;
                tile1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tile2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tile3 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tile4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tile1].collision || gp.tileM.tile[tile2].collision || gp.tileM.tile[tile3].collision || gp.tileM.tile[tile4].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX - entity.speed)/gp.tileSize;
                entityRightCol= (entityRightX + entity.speed)/gp.tileSize;
                tile1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tile2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tile3 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                tile4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tile1].collision || gp.tileM.tile[tile2].collision || gp.tileM.tile[tile3].collision || gp.tileM.tile[tile4].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol= (entityRightX + entity.speed)/gp.tileSize;
                entityLeftCol = (entityLeftX - entity.speed)/gp.tileSize;
                tile1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tile2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                tile3 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tile4 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tile1].collision || gp.tileM.tile[tile2].collision || gp.tileM.tile[tile3].collision || gp.tileM.tile[tile4].collision) {
                    entity.collisionOn = true;
                }
                break;
        }*/
    }
}
