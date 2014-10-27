package by.bsu.fpmi.bip.plugin.orp.storage.api;

import by.bsu.fpmi.bip.plugin.orp.storage.api.collection.Array;
import by.bsu.fpmi.bip.plugin.orp.storage.api.collection.Dimensions;

public interface Storage {
    Dimensions getDimensions();

    Array getProjection(ProjectionCriteria projectionCriteria);
}
