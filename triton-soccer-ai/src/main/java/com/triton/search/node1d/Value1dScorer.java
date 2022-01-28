package com.triton.search.node1d;

import com.triton.search.base.Scorer;

public class Value1dScorer implements Scorer<Node1d> {
    @Override
    public float computeCost(Node1d from, Node1d to) {
        return (float) Math.abs(to.getValue() - from.getValue());
    }
}
