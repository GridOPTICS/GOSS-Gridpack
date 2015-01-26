package pnnl.goss.gridpack.model;

import java.util.Collection;

public interface GridpackBus {

    Collection<GridpackLoad> getLoads();

    Collection<GridpackShunt> getShunts();

    Collection<GridpackGenerator> getGenerators();

    /**
     * @return the owner
     */
    int getOwner();

    /**
     * @return the mrid
     */
    String getMrid();

    /**
     * @return the powerGridId
     */
    int getPowerGridId();

    /**
     * @return the loadPl
     */
    double getLoadPl();

    /**
     * @return the loadQl
     */
    double getLoadQl();

    /**
     * @return the shuntGl
     */
    double getShuntGl();

    /**
     * @return the shuntBl
     */
    double getShuntBl();

    /**
     * @return the area
     */
    int getArea();

    /**
     * @return the zone
     */
    int getZone();

    int getBusNumber();

    double getBaseKV();

    int getCode();

    double getVa();

    double getVm();

    String getBusName();
}
