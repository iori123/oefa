package com.oefa.backend.domain;

public class ProcedingVocal  implements  Comparable<ProcedingVocal>{
    private Integer vocalId;
    private Integer quantyProceding;

    public ProcedingVocal( Integer vocalId, Integer quantyProceding ) {
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
    public int compareTo(ProcedingVocal o) {
        return quantyProceding.compareTo(o.getQuantyProceding());
    }
}
