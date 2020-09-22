public class ProtecterAward extends Award {

      // ammo life time
      private float lifeTimeApply =15;

      // hold the creation time
      private long createTimeApply;
  
      private Tank tank;

    @Override
    public void applyRewardToTank(Tank tankToApply) {
      
        GameState.getProtectedTanks().add(tankToApply);
        GameView.getAwardLable().setText("Protected award applied");
        this.tank = tankToApply;
        createTimeApply = System.currentTimeMillis();

    }

    public  void removeAward (){
        GameState.getProtectedTanks().remove(this.tank);
        GameView.getAwardLable().setText("");

    }

}
