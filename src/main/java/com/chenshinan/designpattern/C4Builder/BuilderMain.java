package com.chenshinan.designpattern.C4Builder;

/**
 * @author shinan.chen
 * @date 2018/8/30
 */
public class BuilderMain {
    public static void main(String[] args) {

        /**
         * Builder类与被构造的对象分离开
         */
        Music music = new MusicBuilder().composer("chenshinan").writer("jaychou").build();
        /**
         * Builder类内嵌在被构造的对象中
         */
        NewMusic newMusic = new NewMusic.Builder().composer("chenshinan").writer("jaychou").build();

        System.out.println("music:" + music);
        System.out.println("newMusic:" + newMusic);
    }
}
