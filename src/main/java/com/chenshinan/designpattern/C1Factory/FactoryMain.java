package com.chenshinan.designpattern.C1Factory;

/**
 * @author shinan.chen
 * @date 2018/8/27
 */
public class FactoryMain {
    public static void main(String[] args){
        PersonFactory personFactory = new PersonFactory();

        Person doctor = personFactory.getPerson(PersonType.DOCTOR);
        doctor.work();

        Person teacher = personFactory.getPerson(PersonType.TEACHER);
        teacher.work();
    }
}
