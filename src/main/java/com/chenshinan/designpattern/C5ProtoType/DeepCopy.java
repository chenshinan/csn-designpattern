package com.chenshinan.designpattern.C5ProtoType;

import java.io.*;

/**
 * @author shinan.chen
 * @date 2018/9/1
 */
public class DeepCopy implements Serializable {
    private String name;
    private String description;
    private DeepCopySon deepCopySon;

    public DeepCopy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DeepCopySon getDeepCopySon() {
        return deepCopySon;
    }

    public void setDeepCopySon(DeepCopySon deepCopySon) {
        this.deepCopySon = deepCopySon;
    }

    /**
     * 深拷贝1
     *
     * @return
     */
    public DeepCopy deepClone() throws IOException, ClassNotFoundException, OptionalDataException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (DeepCopy) ois.readObject();
    }

    /**
     * 深拷贝2，通过构造函数拷贝
     * @param deepCopy
     */
    public DeepCopy(DeepCopy deepCopy) {
        this.name = deepCopy.name;
        this.description = deepCopy.description;
        this.deepCopySon = new DeepCopySon(deepCopy.getDeepCopySon());
    }
}
