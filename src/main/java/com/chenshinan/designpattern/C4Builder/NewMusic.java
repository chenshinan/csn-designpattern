package com.chenshinan.designpattern.C4Builder;

/**
 * @author shinan.chen
 * @date 2018/8/31
 */
public class NewMusic {
    private String writeWord;
    private String writeMusic;

    public NewMusic(Builder builder) {
        this.writeMusic = builder.writeMusic;
        this.writeWord = builder.writeWord;
    }

    protected static class Builder{
        private String writeWord;
        private String writeMusic;

        protected Builder composer(String composer){
            this.writeMusic = composer;
            return this;
        }

        protected Builder writer(String writer){
            this.writeWord = writer;
            return this;
        }

        protected NewMusic build(){
            return new NewMusic(this);
        }
    }
}



