package models;

import java.io.Serializable;
import java.util.Objects;

public class BrandModel implements Serializable {
    private long brandId;
    private long ModelId;

    public BrandModel() {
    }

    public BrandModel(long brandId, long modelId) {
        this.brandId = brandId;
        ModelId = modelId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public long getModelId() {
        return ModelId;
    }

    public void setModelId(long modelId) {
        ModelId = modelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandModel that = (BrandModel) o;
        return brandId == that.brandId &&
                ModelId == that.ModelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, ModelId);
    }
}
