package pnnl.goss.gridpack.model;

import java.util.Collection;

public interface GridpackPowergrid {


    public String getMrid();

    public Double getSBase();

    public Integer getCaseId();

    public Collection<GridpackBus> getBuses();

    public Collection<GridpackBranch> getGridpackBranches();

}
