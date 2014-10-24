package by.bsu.fpmi.bip.plugin.orp.storage.api;

import by.bsu.fpmi.bip.plugin.oms.api.collection.Dimensions;

public interface ProjectionCriteria {
    Dimensions getDimensions();

    Value getValue(Dimension dimension);
}
