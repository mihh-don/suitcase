package com.suitcase.domainmodel.dto.baggage;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class BaggageContainerDTO extends BaggageItemDTO {

    private BigDecimal capacity;
    private Set<BaggageItemDTO> items;

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public Set<BaggageItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<BaggageItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaggageContainerDTO)) return false;
        if (!super.equals(o)) return false;
        BaggageContainerDTO that = (BaggageContainerDTO) o;
        return Objects.equals(getCapacity(), that.getCapacity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCapacity());
    }
}
