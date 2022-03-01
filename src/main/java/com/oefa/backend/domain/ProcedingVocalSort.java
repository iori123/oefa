package com.oefa.backend.domain;

public class ProcedingVocalSort  implements  Comparable<ProcedingVocalSort> {

    private Integer vocalId;
    private Integer quantyProceding;

    public ProcedingVocalSort( Integer vocalId, Integer quantyProceding ) {
        this.vocalId = vocalId;
        this.quantyProceding = quantyProceding;
    }
    public Integer getVocalId() {
        return vocalId;
    }

    public void setVocalId(Integer vocalId) {
        this.vocalId = vocalId;
    }

    public Integer getQuantyProceding() {
        return quantyProceding;
    }

    public void setQuantyProceding(Integer quantyProceding) {
        this.quantyProceding = quantyProceding;
    }

    @Override
    public int compareTo(ProcedingVocalSort o) {
        return quantyProceding.compareTo(o.getQuantyProceding());

    }
}
