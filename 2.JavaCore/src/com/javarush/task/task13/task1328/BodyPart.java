package com.javarush.task.task13.task1328;

public final class BodyPart {

    private String bodyPart;
    private BodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }
    final static BodyPart LEG = new BodyPart("нога");
    final static BodyPart HEAD = new BodyPart("голова");
    final static BodyPart ARM = new BodyPart("рука");
    final static BodyPart CHEST = new BodyPart("грудь");


    @Override
    public String toString() {
        return this.bodyPart;
    }
}