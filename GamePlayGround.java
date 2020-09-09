/**
 * this class represent a playground for game
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class GamePlayGround {
  
    int[][]newMap = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0,0,1},
        {1,0,0,2,2,2,2,2,0,0,2,2,2,2,0,0,2,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,1,0,1,1,1,2,0,2,2,2,2,2,2,2,2,2,2,1},
        {1,0,0,0,0,0,0,1,1,1,0,1,2,0,0,0,1,0,0,0,2,0,0,0,1},
        {1,0,0,0,0,0,0,1,1,1,0,1,2,0,0,0,1,0,0,0,2,0,0,0,1},
        {1,2,2,2,2,2,2,1,1,1,0,1,2,0,0,0,1,0,0,0,2,0,0,0,1},
        {1,0,0,0,0,0,0,1,1,1,0,1,2,0,0,0,1,0,0,0,2,0,0,0,1},
        {1,0,0,0,0,0,0,1,1,1,0,1,2,0,0,0,1,0,0,0,2,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
};



         /* Constructor */

         
    /**
     * create a new playground
     */
    public GamePlayGround(){
        TileGrid tileGrid =new TileGrid(newMap);
        tileGrid.draw();
        GameState.setHeightPLayGround((newMap.length- 0.5) * 45);
        GameState.setWidthPLayGround((newMap[0].length- 0.5) *45);
    }


    
    public void render(){
        doRendering();
    }


    private void doRendering(){
        for (Tank tank:GameState.getTanks()){
            tank.draw();
        }

        for (Ammo ammo: GameState.getFiredAmmos()){
            ammo.draw();
        }
    }


}
