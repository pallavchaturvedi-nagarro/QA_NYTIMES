package com.ams.utils;

public final class Sleeper {

    private Sleeper(){}

    public static void silentSleep(long time){
        try{
            Thread.sleep(time);
        }catch (InterruptedException interruptedExp){
            interruptedExp.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
