public class ProtecterAward extends Award {


    @Override
    public void applyRewardToTank(Tank tankToApply) {
       long endTime = System.currentTimeMillis() + 15000;
        GameState.getProtectedTanks().add(tankToApply);

        while (System.currentTimeMillis() < endTime) {}
        GameState.getProtectedTanks().remove(tankToApply);
    }

}
