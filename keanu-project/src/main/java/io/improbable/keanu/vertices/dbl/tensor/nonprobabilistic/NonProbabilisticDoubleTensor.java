package io.improbable.keanu.vertices.dbl.tensor.nonprobabilistic;

import io.improbable.keanu.vertices.dbl.tensor.DoubleTensor;
import io.improbable.keanu.vertices.NonProbabilisticObservationException;
import io.improbable.keanu.vertices.dbl.tensor.DoubleTensorVertex;

import java.util.Map;

public abstract class NonProbabilisticDoubleTensor extends DoubleTensorVertex {

    /**
     * Observing non-probabilistic values of this type causes the probability
     * of the graph to flatten to 0 in all places that doesn't exactly match
     * the observation. This is so bad that it is actually prohibited by throwing
     * an exception. This is not the case for all types of non-probabilistic
     * observations.
     *
     * @param value the value to be observed
     */
    @Override
    public void observe(DoubleTensor value) {
        throw new NonProbabilisticObservationException();
    }

    @Override
    public double density() {
        return this.getDerivedValue().equals(getValue()) ? 1.0 : 0.0;
    }

    @Override
    public Map<String, Double> dDensityAtValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isProbabilistic() {
        return false;
    }

    @Override
    public DoubleTensor updateValue() {
        setValue(getDerivedValue());
        return getValue();
    }

    public abstract DoubleTensor getDerivedValue();
}