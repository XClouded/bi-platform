package by.bsu.fpmi.bip.plugin.api;

public interface ApiDescriptor {
    String getName();

    String getVersion();

    Object getApiProvider();
}
