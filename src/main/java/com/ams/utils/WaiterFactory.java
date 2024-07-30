package com.ams.utils;

import java.util.function.BooleanSupplier;

public class WaiterFactory {



    private final BooleanSupplier condition;
    private Long waitSeconds=Long.parseLong("10");
    private Long pauseMilliseconds=Long.parseLong("1000");

    public WaiterFactory(BooleanSupplier condition){
        this.condition=condition;
    }

    public static boolean waitFor(BooleanSupplier predicate){
        return new WaiterFactory(predicate).waitForConditionToBeMet();
    }


    public boolean waitForConditionToBeMet(){
        final long start = System.currentTimeMillis();

        int tries = 0;
        while (System.currentTimeMillis() < start + waitSeconds * 1000) {
            tries++;

            boolean conditionMet;
            try {
                conditionMet = condition.getAsBoolean();
            } catch (final Exception e) {
                conditionMet = false;
            }

            if (conditionMet) {
                System.out.println("Condition met after {} retries / {} seconds.," + tries + "," + ((System.currentTimeMillis() - start) / 1000));
                return true;
            } else {
                Sleeper.silentSleep(pauseMilliseconds);
            }
        }

        System.out.println("Condition not met after "+tries+" retries and "+((System.currentTimeMillis() - start) / 1000)+"s waiting time with"+ pauseMilliseconds / 1000+" seconds wait in between - time out.");
        return false;
    }

}
