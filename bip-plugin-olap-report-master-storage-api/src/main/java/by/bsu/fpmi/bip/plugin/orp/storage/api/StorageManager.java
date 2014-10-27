package by.bsu.fpmi.bip.plugin.orp.storage.api;

import by.bsu.fpmi.bip.plugin.orp.storage.api.collection.StorageDescriptors;

public interface StorageManager {
    StorageDescriptors getStorageDescriptors();

    Storage getStorageById(StorageId storageId);
}
