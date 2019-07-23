package com.suitcase.domainmodel.dto.travel;

import com.suitcase.domainmodel.dto.AbstractEntityDTO;
import com.suitcase.domainmodel.dto.enums.TravelClassEnum;
import com.suitcase.domainmodel.dto.transport.TransportCarrierDTO;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TravelTransportCarrierDTO extends AbstractEntityDTO {

    @NotNull
    private TransportCarrierDTO transportCarrier;
    private TravelClassEnum travelClass;
    private int sequence;

    public TransportCarrierDTO getTransportCarrier() {
        return transportCarrier;
    }

    public void setTransportCarrier(TransportCarrierDTO transportCarrier) {
        this.transportCarrier = transportCarrier;
    }

    public TravelClassEnum getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClassEnum travelClass) {
        this.travelClass = travelClass;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelTransportCarrierDTO)) return false;
        TravelTransportCarrierDTO that = (TravelTransportCarrierDTO) o;
        return getSequence() == that.getSequence() &&
                getTransportCarrier().equals(that.getTransportCarrier()) &&
                getTravelClass() == that.getTravelClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransportCarrier(), getTravelClass(), getSequence());
    }
}
