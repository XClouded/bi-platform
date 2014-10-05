package by.bsu.fpmi.bip.common.util;

public final class Errors {
    private Errors() {
        throwInstantiationError();
    }

    public static void throwInstantiationError() {
        throw new InstantiationError();
    }
}
