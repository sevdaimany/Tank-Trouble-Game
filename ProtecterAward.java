public class ProtecterAward extends Award {

    
    @Override
    public void applyRewardToTank(Tank tankToApply) {
        while (isAlive()){
            GameState.getProtectedTanks().add(tankToApply);
        }
        GameState.getProtectedTanks().remove(tankToApply);
    }

}
