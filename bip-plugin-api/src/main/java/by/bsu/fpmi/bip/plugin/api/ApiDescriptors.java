package by.bsu.fpmi.bip.plugin.api;

public final class ApiDescriptors implements ApiDescriptor {
    private final String name;
    private final String version;
    private final Object apiProvider;

    private ApiDescriptors(String name, String version, Object apiProvider) {
        this.name = name;
        this.version = version;
        this.apiProvider = apiProvider;
    }

    public static ApiDescriptor getProvidedApiDescriptor(String name, String version, Object apiProvider) {
        return new ApiDescriptors(name, version, apiProvider);
    }

    public static ApiDescriptor getRequiredApiDescriptor(String name, String version) {
        return new ApiDescriptors(name, version, null);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Object getApiProvider() {
        return apiProvider;
    }
}
