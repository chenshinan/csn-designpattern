package com.chenshinan.designpattern.C4Builder;

/**
 * @author shinan.chen
 * @date 2018/8/31
 */
public class MusicBuilder {
    private String writeMusic;
    private String writeWord;
    public MusicBuilder composer(String writeMusic){
        this.writeMusic = writeMusic;
        return this;
    }
    public MusicBuilder writer(String writeWord){
        this.writeWord = writeWord;
        return this;
    }

    public Music build(){
        Music music = new Music(writeWord,writeMusic);
        //可进行校验，不符合可直接结束，不返回对象
        return music;
    }

}
