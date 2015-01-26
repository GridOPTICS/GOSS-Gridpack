package pnnl.goss.gridpack.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public interface GridpackBranch {

    String getBranchMrid();

    Integer getFromBusNumber();

    Integer getTobusNumber();

    TransmissionElements getTransmissionElements();

    List<TransmissionElementLine> getTransmissionElementLines();

    List<TransmissionElementTransformer> getTransmissionElementTransformers();

}
